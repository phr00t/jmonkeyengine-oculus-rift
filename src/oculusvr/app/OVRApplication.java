/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oculusvr.app;

import com.jme3.app.SimpleApplication;
import static com.jme3.app.SimpleApplication.INPUT_MAPPING_EXIT;
import com.jme3.input.KeyInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import oculusvr.input.OculusRift;
import oculusvr.state.OVRAppState;
import oculusvr.util.OculusGuiNode;
import oculusvr.util.OculusRiftUtil;

/**
 *
 * @author reden
 */
public class OVRApplication extends SimpleApplication{

    protected boolean useFOVMax, flipEyes, disable_vignette;
    protected OVRAppState ovrAppState;
    private String TOGGLE_LOW_PERSISTENCE = "ToggleLowPersistence";
    private String RESET_HMD = "ResetHMD";
    
    private DismissWarningListener oculusListener = new DismissWarningListener();
    
    private class DismissWarningListener implements RawInputListener {

        public void beginInput() {
        }

        public void endInput() {
        }

        public void onJoyAxisEvent(JoyAxisEvent evt) {
        }

        public void onJoyButtonEvent(JoyButtonEvent evt) {
            dismissWarning();
        }

        public void onMouseMotionEvent(MouseMotionEvent evt) {
        }

        public void onMouseButtonEvent(MouseButtonEvent evt) {
            dismissWarning();
        }

        public void onKeyEvent(KeyInputEvent evt) {
            dismissWarning();
        }

        public void onTouchEvent(TouchEvent evt) {
            dismissWarning();
        }
    }
    
    private class OculusListener implements ActionListener{

        public void onAction(String name, boolean isPressed, float tpf) {
            if(name.equals(TOGGLE_LOW_PERSISTENCE) && !isPressed){
                OculusRift.toggleLowPersistence();
            } else if (name.equals(RESET_HMD) && !isPressed){
                reset();
            }
        }
    }
    

    public OVRApplication() {
        super();
        guiNode = new OculusGuiNode();        
        OculusRift.initialize();
    }
    
    public void preconfigureOVRApp(boolean disable_vignette, boolean force_max_fov, boolean flip_eyes, boolean force_oculus) {
        
        useFOVMax = force_max_fov;
        flipEyes = flip_eyes;
        this.disable_vignette = disable_vignette;
        
        if( force_oculus ) {
            // this will make it work even if an HMD isn't present
            OculusRift.forceInitializeSuccess();
        }               
    }
    
    public OVRAppState getOVRAppState() {
        return ovrAppState;
    }
    
    @Override
    public void simpleInitApp() {
        // run this function before OVRAppState gets initialized to force
        // maximum FOV rendering
        if( OculusRift.isInitialized() ) {
            OculusRiftUtil.useMaxEyeFov(useFOVMax);
            OculusRiftUtil.disableVignette(disable_vignette);

            ovrAppState = new OVRAppState((OculusGuiNode)guiNode, flipEyes);
            ovrAppState.getGuiNode().setPositioningMode(OculusGuiNode.POSITIONING_MODE.AUTO);
            inputManager.addRawInputListener(oculusListener);
            inputManager.addListener(new OculusListener(), new String[]{TOGGLE_LOW_PERSISTENCE, RESET_HMD});
            inputManager.addMapping(TOGGLE_LOW_PERSISTENCE, new KeyTrigger(KeyInput.KEY_F10));
            inputManager.addMapping(RESET_HMD, new KeyTrigger(KeyInput.KEY_F9));
            stateManager.attach(ovrAppState);
            
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        OculusRift.destroy();
    }
    
    public void dismissWarning(){
        OculusRift.loadedHmd.dismissHSWDisplay();
        reset(); // reset position when the warning gets removed
        inputManager.removeRawInputListener(oculusListener);
    }
    
    @Override
    public void gainFocus(){
        if (pauseOnFocus) {
            paused = false;
            //context.setAutoFlushFrames(true);
            if (inputManager != null) {
                inputManager.reset();
            }
        }
    }

    @Override
    public void loseFocus(){
        if (pauseOnFocus){
            paused = true;
            //context.setAutoFlushFrames(false);
        }
    }
    
    
    public void reset(){
        OculusRift.reset();
    }
}