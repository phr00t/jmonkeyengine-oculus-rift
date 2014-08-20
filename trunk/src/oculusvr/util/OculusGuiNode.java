/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oculusvr.util;

import com.jme3.math.Matrix3f;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import oculusvr.input.OculusRift;

/**
 *
 * @author
 * phr00t
 */
public class OculusGuiNode extends Node {
    
    public enum POSITIONING_MODE {
        MANUAL, AUTO
    }
    
    private Camera cam;
    private float guiDistance;
    private float guiRatioW, guiRatioH;
    private POSITIONING_MODE posMode = POSITIONING_MODE.MANUAL;
    
    private Vector3f look = new Vector3f(), left = new Vector3f();
    private Matrix3f orient = new Matrix3f();
    private Quaternion tempq = new Quaternion();
    
    public OculusGuiNode() {
        super("ogui");
        guiDistance = 2f;
    }
    
    public OculusGuiNode(float dist) {
        super("ogui");
        guiDistance = dist;
    }
    
    public void setPositioningMode(POSITIONING_MODE mode) {
        posMode = mode;
    }
    
    public POSITIONING_MODE getPositioningMode() {
        return posMode;
    }    
    
    public void positionGui() {
        Vector3f guiPos = getLocalTranslation();
        setLocalScale(guiDistance * 0.0025f * guiRatioW, guiDistance * 0.0025f * guiRatioH, guiDistance * 0.005f);
        if( cam != null ) {
            Vector3f campos = cam.getLocation();
            guiPos.set(guiDistance * 1.6333f, -guiDistance, guiDistance);
            cam.getRotation().mult(guiPos, guiPos);
            guiPos.x += campos.x;
            guiPos.y += campos.y;
            guiPos.z += campos.z;
            rotateScreen();
        }
    }
    
    private void rotateScreen() {
        // coopt diff for our in direction:
        look.set(cam.getDirection()).negateLocal();
        // coopt loc for our left direction:
        left.set(cam.getLeft()).negateLocal();
        orient.fromAxes(left, cam.getUp(), look);
        Node myparent = getParent();
        Quaternion rot = tempq.fromRotationMatrix(orient);
        if ( myparent != null ) {
            rot =  myparent.getWorldRotation().inverse().multLocal(rot);
            rot.normalizeLocal();
        }
        setLocalRotation(rot);
    }
    
    public void setGuiDistance(float newGuiDistance) {
        guiDistance = newGuiDistance;                
    }
    
    public void adjustGuiDistance(float adjustAmount) {
        guiDistance += adjustAmount;
    }
    
    public void setupGui(ViewPort left, ViewPort right) {
        left.attachScene(this);
        right.attachScene(this);
        cam = left.getCamera();
        guiRatioW = 1280f / cam.getWidth();
        guiRatioH = 800f / cam.getHeight();
        setPositioningMode(posMode);
        positionGui();
    }
     
    public void fixBrokenElements() {
        convertAll(this);
    }
    
    private void convertAll(Spatial s) {
        s.setQueueBucket(Bucket.Translucent);
        if( s instanceof Node ) {
            for(Spatial ns : ((Node)s).getChildren()) {
                convertAll(ns);
            }
        }
    }
    
    /**
     * <code>attachChild</code> attaches a child to this node. This node
     * becomes the child's parent. The current number of children maintained is
     * returned.
     * <br>
     * If the child already had a parent it is detached from that former parent.
     * 
     * @param child
     *            the child to attach to this node.
     * @return the number of children maintained by this node.
     * @throws IllegalArgumentException if child is null.
     */
    @Override
    public int attachChild(Spatial child) {
        if( OculusRift.isInitialized() ) convertAll(child);
        return super.attachChild(child);
    }
    
    /**
     * 
     * <code>attachChildAt</code> attaches a child to this node at an index. This node
     * becomes the child's parent. The current number of children maintained is
     * returned.
     * <br>
     * If the child already had a parent it is detached from that former parent.
     * 
     * @param child
     *            the child to attach to this node.
     * @return the number of children maintained by this node.
     * @throws NullPointerException if child is null.
     */
    @Override
    public int attachChildAt(Spatial child, int index) {
        if( OculusRift.isInitialized() ) convertAll(child);
        return super.attachChildAt(child, index);
    }    
}