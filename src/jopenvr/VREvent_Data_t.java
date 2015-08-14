package jopenvr;
import com.sun.jna.Pointer;
import com.sun.jna.Union;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class VREvent_Data_t extends Union {
	/** C type : VREvent_Reserved_t */
	public VREvent_Reserved_t reserved;
	/** C type : VREvent_Controller_t */
	public VREvent_Controller_t controller;
	/** C type : VREvent_Mouse_t */
	public VREvent_Mouse_t mouse;
	/** C type : VREvent_Process_t */
	public VREvent_Process_t process;
	public VREvent_Data_t() {
		super();
	}
	/** @param reserved C type : VREvent_Reserved_t */
	public VREvent_Data_t(VREvent_Reserved_t reserved) {
		super();
		this.reserved = reserved;
		setType(VREvent_Reserved_t.class);
	}
	/** @param controller C type : VREvent_Controller_t */
	public VREvent_Data_t(VREvent_Controller_t controller) {
		super();
		this.controller = controller;
		setType(VREvent_Controller_t.class);
	}
	/** @param mouse C type : VREvent_Mouse_t */
	public VREvent_Data_t(VREvent_Mouse_t mouse) {
		super();
		this.mouse = mouse;
		setType(VREvent_Mouse_t.class);
	}
	/** @param process C type : VREvent_Process_t */
	public VREvent_Data_t(VREvent_Process_t process) {
		super();
		this.process = process;
		setType(VREvent_Process_t.class);
	}
	public VREvent_Data_t(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends VREvent_Data_t implements com.sun.jna.Structure.ByReference {
		
	};
	public static class ByValue extends VREvent_Data_t implements com.sun.jna.Structure.ByValue {
		
	};
}
