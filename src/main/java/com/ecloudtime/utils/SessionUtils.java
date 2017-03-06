package com.ecloudtime.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ecloudtime.model.Foundation;
import com.ecloudtime.model.User;

public class SessionUtils {
	public static String getSessionStr(String code){
		//shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		return  (String)session.getAttribute(code);
	}
	
	public static void setSessionStrByCode(String code,String value){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			session.setAttribute(code,value);
		}
	}
	
	public static void putUserInfoToSession(User user){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			session.setAttribute(Const.SESSION_USER,user);
		}
	}
	
	public static User getUserFromSession(){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			return (User)session.getAttribute(Const.SESSION_USER);
		}
		return null;
	}
	public static String getUserNameFromSession(){
		User user =getUserFromSession();
		if(null!=user){
			return user.getName();
		}
		return null;
	}
	
	
	public static void clearUserInfoFromSession(){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			session.removeAttribute(Const.SESSION_USER);
		}
	}
	
	public static void clearFoundUserInfoFromSession(){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			session.removeAttribute(Const.SESSION_FUND_USER);
		}
	}
	public static void putFoundUserInfoToSession(Foundation found){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			session.setAttribute(Const.SESSION_FUND_USER,found);
		}
	}
	
	public static Foundation getFundUserFromSession(){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		if(null!=session){
			return (Foundation)session.getAttribute(Const.SESSION_FUND_USER);
		}
		return null;
	}
	
	public static String getFundUserNameFromSession(){
		Foundation fund =getFundUserFromSession();
		if(null!=fund){
			return fund.getName();
		}
		return null;
	}
	
	
	
	
}
