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
    	String out=base64Util.getFromBase64("CvoKCAESgwESgAFmY2IzYjNkZDcxYmNkNTk3NDhlODg2OWZjNTQyNjk4YTRhYmNmZjA1MTlhYjMyM2ZiMjlmZWMxYTMxYmVmMmE5YmM2Mzc3NWQwNmRjNmMyODU5ZGJhODA2NTE5M2MzMzViM2U4YjYxOGExZDcyZmFkZmRkYzg4ODhkZjRlMjY5MxrqCQoGZHJhd2VkCkdmdW5kMDE6MjVhYjU4MGEyMDkzNzc2Y2EyZTFkZDE3NzVlOTZkZmVjNWYxZmZiY2M5NTY1MTI5MzUxY2IzMzBjZjA3MTJkNwokOGJjOTViYjQtNGRiZC00MTY5LWI4ZWMtZWY3MjhiZTY4NzkxCrAHZXlKMGVHOTFkQ0k2VzNzaWMybG5iaUk2SWlJc0ltRmtaSElpT2lKaVlYSm5ZV2x1TURFNk9HWmpZelU0WldFM1pXUXlNVEptTjJNeA0KWW1Fek5UbGtNVFZpWldFeE5EUmxOamRqTXprd01EUTBaRGsxTXpjNU56VTBPR05tTmpkbVpEWXlOVE0wWVNJc0ltRjBkSElpT2lKeg0KYldGeWRHTnZiblJ5WVdOME1ERTZNV1ExTkdFNE56RXpPVEl6WVdZeE56RTRaVGhsWldGaVpXTXpaVFJrT0RVNU5tUmlZbVJtTW1SaA0KTTJZMk9XVmhNak5oWldJNFl6ZGhOV0ZpTnpOa09DdzRZbU01TldKaU5DMDBaR0prTFRReE5qa3RZamhsWXkxbFpqY3lPR0psTmpnMw0KT1RFaUxDSjJZV3gxWlNJNk1USXpOREF3TURBd2ZWMHNJbWx1Y0hWMFJHRjBZU0k2SW5OdFlYSjBZMjl1ZEhKaFkzUXdNVG94WkRVMA0KWVRnM01UTTVNak5oWmpFM01UaGxPR1ZsWVdKbFl6TmxOR1E0TlRrMlpHSmlaR1l5WkdFelpqWTVaV0V5TTJGbFlqaGpOMkUxWVdJMw0KTTJRNExERXlNelFzWW1GeVoyRnBiakF4T2pobVkyTTFPR1ZoTjJWa01qRXlaamRqTVdKaE16VTVaREUxWW1WaE1UUTBaVFkzWXpNNQ0KTURBME5HUTVOVE0zT1RjMU5EaGpaalkzWm1RMk1qVXpOR0VpTENKbWIzVnVaR1Z5SWpvaWMyMWhjblJqYjI1MGNtRmpkREF4T2pGaw0KTlRSaE9EY3hNemt5TTJGbU1UY3hPR1U0WldWaFltVmpNMlUwWkRnMU9UWmtZbUprWmpKa1lUTm1OamxsWVRJellXVmlPR00zWVRWaA0KWWpjelpEZ2lMQ0oyWlhKemFXOXVJam95TURFM01ERXdNU3dpZEdsdFpYTjBZVzF3SWpveE5EZzROVEE0TkRVeUxDSjBlR2x1SWpwYg0KZXlKemIzVnlZMlZVZUVoaGMyZ2lPaUlpTENKaFpHUnlJam9pYzIxaGNuUmpiMjUwY21GamREQXhPakZrTlRSaE9EY3hNemt5TTJGbQ0KTVRjeE9HVTRaV1ZoWW1Wak0yVTBaRGcxT1Raa1ltSmtaakprWVRObU5qbGxZVEl6WVdWaU9HTTNZVFZoWWpjelpEZ2lMQ0pwWkhnaQ0KT2pCOVhYMD0KrAFuMHJ1ZVVaWkNiYUFGVjVlRzM2VElkUWptR1Q5dnJ6QUZSY2kvVk0rMUlzY0xvcHBSOHFsRy9FcitoVTdQYzJoNll6UTlEU1RWS3ljWllyT0ppT2VIZ0lta05EWWt3a1JvWmdDdys2OUx0dEdOQUF3UlVEd0hRUTJwSFpMUUdtck5jMEo3Q2FFbXF0R1Y5enRONk1zOHpTUjNCbkxTZGNVYWdCOU4rdUZVdEE9Cg86OjotMTIzNDo6OjEyMzQqA2ppbQ==");
    	System.out.println(out);
	}
}  