package com.ecloudtime.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RSASignatureUtil {  
	
	private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class); // 日志记录

	@Value("${chaincode.des.rsapath}")
	private String rsapath;
	
	@Value("${chaincode.des.rsapath2}")
	private String rsapath2;
    /** 
     * 签名算法 
     */  
    public static final String SIGN_ALGORITHMS = "SHA256WithRSA";  

    /** 
     * 从文件中加载私钥 
     *  
     * @param keyFileName 
     *            私钥文件名 
     * @return 是否成功 
     * @throws Exception 
     */  
    public static String loadPrivateKeyByFile(String path,String filename) throws Exception {  
        try {  
            BufferedReader br = new BufferedReader(new FileReader(path));  
            String readLine = null;  
            StringBuilder sb = new StringBuilder();  
            while ((readLine = br.readLine()) != null) {  
                sb.append(readLine);  
            }  
            br.close();
            String rpHead = sb.toString().replace("-----BEGIN PRIVATE KEY-----","");
            return rpHead.replace("-----END PRIVATE KEY-----","");  
        } catch (IOException e) {  
            throw new Exception("私钥数据读取错误");  
        } catch (NullPointerException e) {  
            throw new Exception("私钥输入流为空");  
        }  
    } 

    /** 
     * 从文件中输入流中加载公钥 
     *  
     * @param in 
     *            公钥输入流 
     * @throws Exception 
     *             加载公钥时产生的异常 
     */  
    public static String loadPublicKeyByFile(String path) throws Exception {  
        try {  
            BufferedReader br = new BufferedReader(new FileReader(path));  
            String readLine = null;  
            StringBuilder sb = new StringBuilder();  
            while ((readLine = br.readLine()) != null) {  
                sb.append(readLine);  
            }  
            br.close();  
            String rpHead = sb.toString().replace("-----BEGIN PUBLIC KEY-----","");
            return rpHead.replace("-----END PUBLIC KEY-----","");  
        } catch (IOException e) {  
            throw new Exception("公钥数据流读取错误");  
        } catch (NullPointerException e) {  
            throw new Exception("公钥输入流为空");  
        }  
    }      

    public  String signWithKeyPath(String content, String keyPath)throws Exception{
    	/*File fielRoot = new File(System.getProperty("user.dir"));
    	String filepath=fielRoot.getParent()+File.separator+"rsakey"+File.separator;*/
    	File fielRoot= new File(rsapath);
    	if(!fielRoot.exists()){
    		fielRoot=new File(rsapath2);
    	}
    	String filepath=fielRoot+File.separator;
    	String filename="";
    	if("cebBank".equals(keyPath)){
//    		"donor01pkcs8_private.pem";
    		filename="cebbankpkcs8_private.pem";
    	}else if("donor01".equals(keyPath)){
    		filename="donor01pkcs8_private.pem";
	    }else if("donor02".equals(keyPath)){
	    	filename="donor02pkcs8_private.pem";
	    }else if("donor03".equals(keyPath)){
	    	filename="donor03pkcs8_private.pem";
	    }else if("donor04".equals(keyPath)){
	    	filename="donor04pkcs8_private.pem";
	    }else if("donor05".equals(keyPath)){
	    	filename="donor05pkcs8_private.pem";
	    }else if("donor06".equals(keyPath)){
	    	filename="donor06pkcs8_private.pem";
	    }else if("donor07".equals(keyPath)){
	    	filename="donor07pkcs8_private.pem";
	    }else if("donor08".equals(keyPath)){
	    	filename="donor08pkcs8_private.pem";
	    }else if("donor09".equals(keyPath)){
	    	filename="donor09pkcs8_private.pem";
	    }else if("donor10".equals(keyPath)){
	    	filename="donor10pkcs8_private.pem";
	    }
    	else if("fund".equals(keyPath)||"draw".equals(keyPath)){
    		filename="fund01pkcs8_private.pem";
    	}	
    	filepath+=filename;
    	logger.info("filepath:"+filepath+" filename="+filename);
    	String privateKey = loadPrivateKeyByFile(filepath,filename);
    	return sign(content,privateKey);
    }
    
    public  String sign(String content, String privateKey)  
    {  
        try   
        {  

            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64.getDecoder().decode(privateKey) );   
            KeyFactory keyf = KeyFactory.getInstance("RSA");  
            PrivateKey priKey = keyf.generatePrivate(priPKCS8); 

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);  
            signature.initSign(priKey);  
            signature.update( content.getBytes());  
            byte[] signed = signature.sign();  
            return Base64.getEncoder().encodeToString(signed);
        }  
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
        return null;  
    } 

    public  boolean doCheck(String content, String sign, String publicKey)  
    {  
        try   
        {  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            byte[] encodedKey = Base64.getDecoder().decode(publicKey);  
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));  
  
          
            java.security.Signature signature = java.security.Signature  
            .getInstance(SIGN_ALGORITHMS);  
          
            signature.initVerify(pubKey);  
            signature.update( content.getBytes() );  
          
            boolean bverify = signature.verify( Base64.getDecoder().decode(sign) );  
            return bverify;  
              
        }   
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
          
        return false;  
    }               

    
    public static void main(String[] args) throws Exception {  
    	
//        String filepath="/home/eric/go/src/github.com/CebEcloudTime/tools/java/rsa";  
   /* 	RSASignatureUtil  rsaUtil= new RSASignatureUtil();
        String filepath=rsaUtil.getClass().getResource("/").getPath();
        System.out.println(filepath);
        URL xmlpath = rsaUtil.getClass().getClassLoader().getResource("rsaFile.go"); 
        System.out.println(xmlpath); 
//        System.out.println( System.getProperty("java.class.path")); 
        System.out.println(System.getProperty("user.dir")); */
		
    	String filepath=new File(System.getProperty("user.dir")).getParent()+File.separator+"rsakey"+File.separator+"donor01pkcs8_private.pem";
        String key = loadPrivateKeyByFile(filepath,"donor01pkcs8_private.pem");

        System.out.println(key);
  
        //RSAEncrypt.genKeyPair(filepath);  
          
        System.out.println("---------------私钥签名过程------------------");  
        String content = "用于签名的原始数据";  
        RSASignatureUtil rs = new RSASignatureUtil();
        // key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ0DWxqG4kkQYPoJMbvmpy+vjsgQ17DemzIcGnU9OYwPmhfmSywVKlmrFVyGgFlOjSHJK5+x3oqkET5YbTOviGjoy/uV4Ec0jCCjS3IFc59vMHV5a3yir8o3dwInmnuNBKnaPFTl10dreeAhtcmDF7hZ/tYnnG9KdrODOSDE/pTRAgMBAAECgYBt+9LOQxuxWHLF0rjuyUPlSFF43StpbpVBxaPW6fssnCUxhpSznWPcCdZdyK2RYU/FEdin9X1Qmlql1GUyJkwjL6v+vMlN9o4AkYqzOVJnu6vHRgLB/BP78C1b7MHn+l+SPyLApBe/daeY9XZfOlD/S4Enjrvg4DsDfXnkouYWAQJBAM37rGhzn9IRi/C9wNjhLXwuRz6ubD9dF2TC1lIuZDXzFVt9f9PXxvsrwKWsTayK/SkN1MIA22q9SmmaAQvXP/ECQQDDI5vPkPa6UHjZ3FVEkG6DgmD847WJZNgmtNb/dARPwqnmOQrYZAarDZ3E+Fq/uVFDTtGEjJtfqpQhkk76x4LhAkAE4yrVE6FAJ8BtRuNTggxFPQfdud/BpSDP+DuDmawxB4KDODgXO7Bx9zjL9YmmRWn6VmSs8b5DCxi/5rKNqF7RAkBZw5CR+8ozTH87IGqs3o+nuRrqWckRSa1QqNFZs0GkexRyjfzaK7ERkHLpv6DnHtUt1Bz3D0MNz8bSZp4kKBChAkBq/2Lwf1Q35280F6Hd9t98WY2XKIvXjskvNfDlxRkV0L/U6fvKp5S2fRXmxDpMvShYqmoAbC3WYz3C6Tp1kF7r";
        String signstr = rs.sign(content,key);  
        System.out.println("签名原串："+content);  
        System.out.println("签名串：");
        System.out.println(signstr);  
        System.out.println();  
        filepath=System.getProperty("user.dir")+File.separator+"rsakey"+File.separator+"donor01public.pem";
        System.out.println("---------------公钥校验签名------------------");  
        System.out.println("验签结果："+rs.doCheck(content, signstr, loadPublicKeyByFile(filepath)));  
        
        System.out.println();  
          
    }  
} 