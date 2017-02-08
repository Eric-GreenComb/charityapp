package com.ecloudtime.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecloudtime.model.ChainCodeDeployRequest;
import com.ecloudtime.model.ChainCodeInvokeRequest;

import net.sf.json.JSONObject;
 
public class HttpRequestUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);    //日志记录
 
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        return httpPost(url, jsonParam, false);
    }
 
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
        //post请求返回结果
    	HttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        method.addHeader("Content-type","application/json; charset=utf-8");  
        method.setHeader("Accept", "application/json");  
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                method.addHeader("Content-type","application/json; charset=utf-8");  
                method.setHeader("Accept", "application/json");  
                method.setEntity(new StringEntity(jsonParam.toString(), Charset.forName("UTF-8")));  
                
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    if (noNeedResponse) {
                        return null;
                    }
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return jsonResult;
    }
 
 
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
 
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        }
        return jsonResult;
    }
    
    
    public static void main(String[] argsdfd) {
    	HttpRequestUtils client =new HttpRequestUtils();
    	String url="http://192.168.31.100:7050/chaincode";
    	logger.info("1.注册deploy：初始化区块链信息!");
    	ChainCodeDeployRequest request= new ChainCodeDeployRequest("github.com/CebEcloudTime/charitycc");
    	JSONObject jsonParam = JSONObject.fromObject(request);
//    	System.out.println(jsonParam.toString());
    	JSONObject response=client.httpPost(url, jsonParam);
    	logger.info("response:"+response.toString());
    	logger.info("2.调用invoke：初始化区块链信息!");
    	//String chaincodeName,String funcName,List<String> args
    	String chaincodeName="8b9ccebd1587fbf83da1a7a01b0383c967cec84f0515d04b88f9055a04e35c720c927948ddfc6af8647f4ba60c46edae27f51e543e652fe7126e4281fb053838";
    	String funcName="registerBank";
    	List<String> paramArgs=new ArrayList<String>();
    	paramArgs.add("cebbank");
    	paramArgs.add("LS0tLS1CRUdJTiBwdWJsaWMga2V5LS0tLS0KTUlHZk1BMEdDU3FHU0liM0RRRUJBUVVBQTRHTkFEQ0JpUUtCZ1FDK0oxWjRiTGFPOFNobTFyOXFOOHB6RjJxbwp1c08rSnhoOWpGcDdQTkcwMERGTUR5RUhWNU9JajhhdFlVdzBwRkFTUG95dldHMGhlRzdCVU00bVRpWHNZOFF3ClpYMjZ6L2I2bk05Q3ZtM2xlell1NjgwT2NQQnNIczdLb0RZTkUrUGM2c0EwRGVDVnUxNm5aeGpQbFRwbUxMdmkKb2Z3bS9ReVlKZlVsNElRazFRSURBUUFCCi0tLS0tRU5EIHB1YmxpYyBrZXktLS0tLQo=");
    	paramArgs.add("TV1xznZQSfCliJBdTvKNhn5s1M8Ji9tuET68hrMQHpbd5LO83K7yHyMJQQo7lX4iV0qVvYyK5p8zeJwVVyOeNQd1jRpi83XmfLqWHzhddf3zK81xOpzz+2GVuZolyKS2dzXyheJ7holm3PyxUwZtL5+qWfQhAXBKLqN0LrU5pcE=");
    	ChainCodeInvokeRequest invoke =new ChainCodeInvokeRequest(chaincodeName,funcName,null);
    	jsonParam=JSONObject.fromObject(invoke);
	    response=client.httpPost(url, jsonParam);
	    logger.info("response:"+response.toString());
//    	System.out.println(response);
//    	ChainCodeResponseModel result=(ChainCodeResponseModel)JSONObject.toBean(response,ChainCodeResponseModel.class);
//    	System.out.println(result.getResult().getMessage());
	}
}