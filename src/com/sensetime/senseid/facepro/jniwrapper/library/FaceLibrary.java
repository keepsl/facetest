package com.sensetime.senseid.facepro.jniwrapper.library;

//import android.graphics.Rect;

public class FaceLibrary {
	public static final int ST_OK = 0;
	  public static final int ST_E_INVALIDARG = -1;
	  public static final int ST_E_HANDLE = -2;
	  public static final int ST_E_OUTOFMEMORY = -3;
	  public static final int ST_E_FAIL = -4;
	  public static final int ST_E_INVALID_PIXEL_FORMAT = -6;
	  public static final int ST_E_FILE_NOT_FOUND = -7;
	  public static final int ST_E_INVALID_FILE_FORMAT = -8;
	  public static final int ST_E_FILE_EXPIRE = -9;
	  public static final int ST_E_INVALID_AUTH = -13;
	  public static final int ST_E_INVALID_APPID = -14;
	  public static final int ST_E_AUTH_EXPIRE = -15;
	  public static final int ST_E_UUID_MISMATCH = -16;
	  public static final int ST_E_ONLINE_AUTH_CONNECT_FAIL = -17;
	  public static final int ST_E_ONLINE_AUTH_TIMEOUT = -18;
	  public static final int ST_E_ONLINE_AUTH_INVALID = -19;
	  public static final int ST_E_LICENSE_IS_NOT_ACTIVABLE = -20;
	  public static final int ST_E_ACTIVE_FAIL = -21;
	  public static final int ST_E_ACTIVE_CODE_INVALID = -22;
	  public static final int ST_E_PRODUCT_VERSION_MISMATCH = -23;
	  public static final int ST_E_PLATFORM_NOTSUPPORTED = -24;
	  public static final int ST_E_UNZIP_FAILED = -25;
	  public static final int ST_E_SUBMODULE_NON_EXIT = -26;
	  public static final int ST_E_ONLINE_ACTIVATE_NO_NEED = -27;
	  public static final int ST_E_ONLINE_ACTIVATE_FAIL = -28;
	  public static final int ST_E_ONLINE_ACTIVATE_CODE_INVALID = -29;
	  public static final int ST_E_ONLINE_ACTIVATE_CONNECT_FAIL = -30;
	  public static final int ST_E_HW_AUTH_INIT_FAIL = -32;
	  public static final int ST_E_HW_AUTH_FAIL = -33;
	  public static final int ST_E_SETINSTRUCTION = -34;
	  public static final int ST_E_HASP_NOT_SUPPORT_REMOTE_DESKTOP = -993;
	  public static final int ST_E_CPU_CORE_OUTOF_LIMIT = -994;
	  public static final int ST_E_NO_NETWORK = -995;
	  public static final int ST_E_OUT_OF_LIMIT_COUNT = -996;
	  public static final int ST_E_FILE_ACCESS_ERROR = -997;
	  public static final int ST_E_SOCKET_ERROR = -998;
	  public static final int ST_E_CANNOT_BE_ACCESSED = -999;
	  public static final int ST_E_UNSUPPORTED = -1000;
	  public static final int ST_E_GET_UUID_FAILED = -1001;
	  public static final int ST_E_ONLINEISSE_INVALID_LICENSE = -1002;
	  public static final int ST_E_ONLINEISSE_INVALID_LICENSE_NOT_REDISTRIBUTABLE = -1003;
	  public static final int ST_E_ONLINEISSE_INVALID_REDISTRUBUTE_LIMIT_EXCEED = -1004;
	  public static final int ST_E_INVALID_CAPABILITY = -1005;
	  public static final int ST_E_UNSUPPORTED_MODEL_VERSION = -1006;
	  public static final int ST_E_OUT_OF_MAX_SEARCH_NUMBER = -1007;
	  public static final int ST_E_ACTIVATION_NUMBER_USED_UP = -1009;
	  public static final int ST_E_DUPLICATE_AUTH = -1010;
	  public static final int ST_FEATURE_NOT_FOUND = -1011;
	  public static final int ST_NOT_FOUND = -1012;
	  public static final int ST_OLD_DRIVER = -1013;
	  public static final int ST_NO_DRIVER = -1014;
	  public static final int ST_INV_VCODE = -1015;
	  public static final int ST_FEATURE_TYPE_NOT_IMPL = -1016;
	  public static final int ST_TMOF = -1017;
	  public static final int ST_INV_HND = -1018;
	  public static final int ST_INV_FILEID = -1019;
	  public static final int ST_MEM_RANGE = -1020;
	  public static final int ST_E_ONLINEISSE_INVALID_UNKNOWN_ERROR = -2000;
	  public static final int ST_DETECT_ENABLE_ALIGN_21 = 256;
	  public static final int ST_DETECT_ENABLE_ALIGN_106 = 512;
	  public static final int ST_FACE_DEFAULT_CONFIG = 0;
	  public static final int ST_FACE_RESIZE_IMG_320W = 2;
	  public static final int ST_FACE_RESIZE_IMG_640W = 4;
	  public static final int ST_FACE_RESIZE_IMG_1280W = 8;
	  public static final int ST_DETECT_SMALL_FACE = 1024;
	  public static final int ST_DETECT_LARGE_FACE = 2048;
	  public static final int ST_DETECT_ANY_FACE = 4096;
	  public static final int ST_FACE_TRACKING_TWO_THREAD = 1114112;
	  public static final int ST_PIX_FMT_GRAY8 = 0;
	  public static final int ST_PIX_FMT_YUV420P = 1;
	  public static final int ST_PIX_FMT_NV12 = 2;
	  public static final int ST_PIX_FMT_NV21 = 3;
	  public static final int ST_PIX_FMT_BGRA8888 = 4;
	  public static final int ST_PIX_FMT_BGR888 = 5;
	  public static final int ST_PIX_FMT_RGBA8888 = 6;
	  public static final int ST_PIX_FMT_RGB888 = 7;
	  public static final int ST_FACE_UP = 1;
	  public static final int ST_FACE_LEFT = 2;
	  public static final int ST_FACE_DOWN = 4;
	  public static final int ST_FACE_RIGHT = 8;
	  public static final int ST_FACE_UNKNOWN = 15;
	  public static final int STID_LOG_NULL = -1;
	  public static final int STID_LOG_TERMINAL = 0;
	  public static final int STID_LOG_FILE = 1;
	  public static final int STID_LOG_IMAGE = 2;
	  public static final int STID_DEBUG_LEVEL_RELEASE = -1;
	  public static final int STID_DEBUG_LEVEL_ERROR = 0;
	  public static final int STID_DEBUG_LEVEL_WARN = 1;
	  public static final int STID_DEBUG_LEVEL_INFO = 2;
	  public static final int STID_DEBUG_LEVEL_PROCESS = 3;
	  public static final int STID_DEBUG_LEVEL_DEBUG = 4;
	  
	  static
	  {
	    try
	    {
	      System.loadLibrary("stidfacepro_api");
	      //System.loadLibrary("jni_face");
	    }
	    catch (UnsatisfiedLinkError e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public native FloatResult binocularlivenessDetect(Object paramObject, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, DetectResult paramDetectResult1, DetectResult paramDetectResult2);
	  
	  public native void destroyBinocularliveness(Object paramObject);
	  
	  public native HandleResult createBinocularliveness(String paramString);
	  
	  public native void destroyBinocularlivenessTracker(Object paramObject);
	  
	  public native void resetBinocularlivenessTracker(Object paramObject);
	  
	  public native BinocularResult binocularlivenessTrack(Object paramObject, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
	  
	  public native HandleResult createBinocularlivenessTracker(String paramString, int paramInt);
	  
	  public native FloatResult singlelivenessDetect(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DetectResult paramDetectResult);
	  
	  public native void destroySingleliveness(Object paramObject);
	  
	  public native HandleResult createSingleliveness(String paramString, int paramInt);
	  
	  public native FloatResult livenessFrameSelectorDetector(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, int paramInt5, DetectResult paramDetectResult);
	  
	  public native void destroyLivenessSelector(Object paramObject);
	  
	  public native HandleResult createLivenessSelector(String paramString);
	  
	  public native void resetLivenessSelector(Object paramObject);
	  
	  public native FloatResult imageQualitySharpness(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect);
	  
	  public native SearchResult verifySearchFaceFromList(Object paramObject, String[] paramArrayOfString, int paramInt1, String paramString, int paramInt2, int paramInt3);
	  
	  public native FloatResult verifyCompareFeature(Object paramObject, String paramString1, String paramString2);
	  
	  public native StringResult verifyGetFeature(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DetectResult paramDetectResult);
	  
	  public native void verifyDestroyHandle(Object paramObject);
	  
	  public native HandleResult verifyDuplicateHandle(Object paramObject);
	  
	  public native HandleResult verifyCreateHandle(String paramString);
	  
	  public native int trackSetDetectFaceCntLimit(Object paramObject, int paramInt);
	  
	  public native void resetTracker(Object paramObject);
	  
	  public native DetectResults track(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
	  
	  public native void destroyTracker(Object paramObject);
	  
	  public native HandleResult createTracker(String paramString, int paramInt);
	  
	  public native DetectResults detect(Object paramObject, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
	  
	  public native void destroyDetector(Object paramObject);
	  
	  public native int setThreshold(Object paramObject, float paramFloat);
	  
	  public native FloatResult getThreshold(Object paramObject);
	  
	  public native HandleResult createDetector(String paramString, int paramInt);
	  
	  public native int setLogType(int paramInt1, int paramInt2);
	  
	  public native int addLicense(String paramString);
	  
	  public native int activite(String paramString);
	  
	  public native StringResult getActivationCode(String paramString);
	  
	  public static String getErrorNameByCode(int code)
	  {
	    switch (code)
	    {
	    case 0: 
	      return "ST_OK";
	    case -1: 
	      return "ST_E_INVALIDARG";
	    case -2: 
	      return "ST_E_HANDLE";
	    case -3: 
	      return "ST_E_OUTOFMEMORY";
	    case -4: 
	      return "ST_E_FAIL";
	    case -6: 
	      return "ST_E_INVALID_PIXEL_FORMAT";
	    case -7: 
	      return "ST_E_FILE_NOT_FOUND";
	    case -8: 
	      return "ST_E_INVALID_FILE_FORMAT";
	    case -9: 
	      return "ST_E_FILE_EXPIRE";
	    case -13: 
	      return "ST_E_INVALID_AUTH";
	    case -14: 
	      return "ST_E_INVALID_APPID";
	    case -15: 
	      return "ST_E_AUTH_EXPIRE";
	    case -16: 
	      return "ST_E_UUID_MISMATCH";
	    case -17: 
	      return "ST_E_ONLINE_AUTH_CONNECT_FAIL";
	    case -18: 
	      return "ST_E_ONLINE_AUTH_TIMEOUT";
	    case -19: 
	      return "ST_E_ONLINE_AUTH_INVALID";
	    case -20: 
	      return "ST_E_LICENSE_IS_NOT_ACTIVABLE";
	    case -21: 
	      return "ST_E_ACTIVE_FAIL";
	    case -22: 
	      return "ST_E_ACTIVE_CODE_INVALID";
	    case -23: 
	      return "ST_E_PRODUCT_VERSION_MISMATCH";
	    case -24: 
	      return "ST_E_PLATFORM_NOTSUPPORTED";
	    case -25: 
	      return "ST_E_UNZIP_FAILED";
	    case -26: 
	      return "ST_E_SUBMODULE_NON_EXIT";
	    case -27: 
	      return "ST_E_ONLINE_ACTIVATE_NO_NEED";
	    case -28: 
	      return "ST_E_ONLINE_ACTIVATE_FAIL";
	    case -29: 
	      return "ST_E_ONLINE_ACTIVATE_CODE_INVALID";
	    case -30: 
	      return "ST_E_ONLINE_ACTIVATE_CONNECT_FAIL";
	    case -32: 
	      return "ST_E_HW_AUTH_INIT_FAIL";
	    case -33: 
	      return "ST_E_HW_AUTH_FAIL";
	    case -34: 
	      return "ST_E_SETINSTRUCTION";
	    case -993: 
	      return "ST_E_HASP_NOT_SUPPORT_REMOTE_DESKTOP";
	    case -994: 
	      return "ST_E_CPU_CORE_OUTOF_LIMIT";
	    case -995: 
	      return "ST_E_NO_NETWORK";
	    case -996: 
	      return "ST_E_OUT_OF_LIMIT_COUNT";
	    case -997: 
	      return "ST_E_FILE_ACCESS_ERROR";
	    case -998: 
	      return "ST_E_SOCKET_ERROR";
	    case -999: 
	      return "ST_E_CANNOT_BE_ACCESSED";
	    case -1000: 
	      return "ST_E_UNSUPPORTED";
	    case -1001: 
	      return "ST_E_GET_UUID_FAILED";
	    case -1002: 
	      return "ST_E_GET_UUID_FAILED";
	    case -1003: 
	      return "ST_E_ONLINEISSE_INVALID_LICENSE_NOT_REDISTRIBUTABLE";
	    case -1004: 
	      return "ST_E_ONLINEISSE_INVALID_REDISTRUBUTE_LIMIT_EXCEED";
	    case -1005: 
	      return "ST_E_INVALID_CAPABILITY";
	    case -1006: 
	      return "ST_E_UNSUPPORTED_MODEL_VERSION";
	    case -1007: 
	      return "ST_E_OUT_OF_MAX_SEARCH_NUMBER";
	    case -1009: 
	      return "ST_E_ACTIVATION_NUMBER_USED_UP";
	    case -1010: 
	      return "ST_E_DUPLICATE_AUTH";
	    case -1011: 
	      return "ST_FEATURE_NOT_FOUND";
	    case -1012: 
	      return "ST_NOT_FOUND";
	    case -1013: 
	      return "ST_OLD_DRIVER";
	    case -1014: 
	      return "ST_NO_DRIVER";
	    case -1015: 
	      return "ST_INV_VCODE";
	    case -1016: 
	      return "ST_FEATURE_TYPE_NOT_IMPL";
	    case -1017: 
	      return "ST_TMOF";
	    case -1018: 
	      return "ST_INV_HND";
	    case -1019: 
	      return "ST_INV_FILEID";
	    case -1020: 
	      return "ST_MEM_RANGE";
	    case -2000: 
	      return "ST_E_ONLINEISSE_INVALID_UNKNOWN_ERROR";
	    }
	    return null;
	  }
}
