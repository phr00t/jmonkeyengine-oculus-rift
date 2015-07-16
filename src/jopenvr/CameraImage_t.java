package jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : headers\openvr_capi.h</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class CameraImage_t extends Structure {
	public int frameID;
	/** C type : HmdMatrix34_t */
	public HmdMatrix34_t pose;
	/**
	 * unsigned char *<br>
	 * C type : unsigned char*
	 */
	public Pointer pBuffer;
	public int unBufferLen;
	/**
	 * @see CameraImageResult<br>
	 * C type : CameraImageResult
	 */
	public int result;
	public CameraImage_t() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("frameID", "pose", "pBuffer", "unBufferLen", "result");
	}
	/**
	 * @param pose C type : HmdMatrix34_t<br>
	 * @param pBuffer unsigned char *<br>
	 * C type : unsigned char*<br>
	 * @param result @see CameraImageResult<br>
	 * C type : CameraImageResult
	 */
	public CameraImage_t(int frameID, HmdMatrix34_t pose, Pointer pBuffer, int unBufferLen, int result) {
		super();
		this.frameID = frameID;
		this.pose = pose;
		this.pBuffer = pBuffer;
		this.unBufferLen = unBufferLen;
		this.result = result;
	}
	public CameraImage_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends CameraImage_t implements Structure.ByReference {
		
	};
	public static class ByValue extends CameraImage_t implements Structure.ByValue {
		
	};
}