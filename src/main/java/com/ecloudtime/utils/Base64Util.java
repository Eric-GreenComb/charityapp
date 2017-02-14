package com.ecloudtime.utils;

import java.io.UnsupportedEncodingException;  

import sun.misc.*;  
  
public class Base64Util {  
    // 加密  
    public static String getBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
  
    // 解密  
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    
    
    public static void main(String[] args) {
    	Base64Util base64Util= new Base64Util();
    	String out=base64Util.getFromBase64("CsoFCAESgwESgAExMjk5NzgxODMxODMwNDI4NTE0YWZmMzkzMGFkMjE4Yjc4NzliMzUyMzAzYzc1OGZiMTk2MzNmYTI0ZGQwNmQzODI4NThhMGMzYzhjOWZiNjc0OGZjYTM3MzM4MDIzZWMyODYxMmU4ZmI5ZWQ5NjU3OTk5N2E5NDk2NWZjODU3OBq6BAoPcmVnaXN0ZXJBY2NvdW50CgliYXJnYWluMDEK7AJMUzB0TFMxQ1JVZEpUaUJRVlVKTVNVTWdTMFZaTFMwdExTMEtUVWxIWmsxQk1FZERVM0ZIVTBsaU0wUlJSVUpCVVZWQlFUUkhUa0ZFUTBKcFVVdENaMUZETTNSNFIzaG5XVXRLY2psWksyMWlNVFJPY0VOS1MwTnRVZ280UW1OUmVrOU1Tak5FSzNFdlVGbzFaazl4VXpVemRGaHZWa28yUVVadE5Fd3llbFpMWVVGa01XTk9TMHM0TDJ0M1JrdHNWMUU1WW1KTFoxWk9WMjV6Q25jNE1qTTBOMDV5UnpReGFXWm9jRlozZFRoSlZISlNPR2xNT0M5cFIzbE1kbmg0U0dnME9XcG1RM1JJV2tGSFYzaHJXa0ZzVkRCd2RrUlpZVE5KTVcwS1RqWk1LeXRaV0N0MldXNDJXVGRPT0ZCM1NVUkJVVUZDQ2kwdExTMHRSVTVFSUZCVlFreEpReUJMUlZrdExTMHRMUW89CqwBZElQNDI4SGdNK3NHSXBVbWk5Q1h3Z09RMGNtb01EYzNFNDZHWE40dHlvM3FvL2VKTElTTDNCbDJxVFRpMEtWWGpzMFM1MjJUeWdRczN5My9OQXlpd21BaUw1WmVULzgxY2tlUWY5RXJVRStMcmV5a2tBNWtEMFpGcEVtdHVDaEZma3oxRFhZUnI2by9JWHpyZmw0TVpoSnRpQndTelU2VmMyYmhwT3d2ZGtvPSoDamlt");
    	System.out.println(out);
	}
}  