package openvr_api;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.Pointer.StringType;
import org.bridj.PointerIO;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
import org.bridj.cpp.CPPRuntime;
/**
 * Wrapper for library <b>openvr_api</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("openvr_api") 
@Runtime(CPPRuntime.class) 
public class Openvr_apiLibrary implements IOpenvr_api {
	static {
		BridJ.register();
	}
	/**
	 * Original signature : <code>uint64_t ButtonMaskFromId(EVRButtonId)</code><br>
	 * <i>native declaration : /usr/include/stdint.h:543</i>
	 */
	@Name("ButtonMaskFromId") 
	public long buttonMaskFromId(IntValuedEnum<Openvr_apiLibrary.EVRButtonId > id) {
		return (long)1 << id.value();
	}
	/**
	 * Original signature : <code>vr::IVRSystem* VR_Init(vr::HmdError*)</code><br>
	 * <i>native declaration : /usr/include/stdint.h:1344</i>
	 */
	@Name("VR_Init") 
	public Pointer<IVRSystem > vRInit(Pointer<IOpenvr_api.HmdError > peError) {
		return (Pointer)Pointer.pointerToAddress(vRInit(Pointer.getPeer(peError)), IVRSystem.class, null);
	}
	@Name("VR_Init") 
	@Ptr 
	public native long vRInit(@Ptr long peError);
	/**
	 * Original signature : <code>void VR_Shutdown()</code><br>
	 * <i>native declaration : /usr/include/stdint.h:1348</i>
	 */
	@Name("VR_Shutdown") 
	public native void vRShutdown();
	/**
	 * Original signature : <code>bool VR_IsHmdPresent()</code><br>
	 * <i>native declaration : /usr/include/stdint.h:1354</i>
	 */
	@Name("VR_IsHmdPresent") 
	public native boolean vRIsHmdPresent();
	/**
	 * Original signature : <code>char* VR_GetStringForHmdError(vr::HmdError)</code><br>
	 * <i>native declaration : /usr/include/stdint.h:1357</i>
	 */
	@Name("VR_GetStringForHmdError") 
	public String vRGetStringForHmdError(Pointer error) {
		return ((Pointer)Pointer.pointerToAddress(vRGetStringForHmdError(error.getLong()), Byte.class, null)).getString(StringType.C);
	}
	@Name("VR_GetStringForHmdError") 
	@Ptr 
	public native long vRGetStringForHmdError(@Ptr long error);
	/**
	 * Original signature : <code>void* VR_GetGenericInterface(const char*, vr::HmdError*)</code><br>
	 * <i>native declaration : /usr/include/stdint.h:1362</i>
	 */
	@Name("VR_GetGenericInterface") 
	public Pointer<? > vRGetGenericInterface(Pointer<Byte > pchInterfaceVersion, Pointer<IOpenvr_api.HmdError > peError) {
		return Pointer.pointerToAddress(vRGetGenericInterface(Pointer.getPeer(pchInterfaceVersion), Pointer.getPeer(peError)), (PointerIO)null);
	}
	@Name("VR_GetGenericInterface") 
	@Ptr 
	public native long vRGetGenericInterface(@Ptr long pchInterfaceVersion, @Ptr long peError);
}
