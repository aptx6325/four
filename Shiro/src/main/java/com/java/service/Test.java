package com.java.service;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by liang on 2018/3/21.
 */
public class Test {

	public void  login(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager instance = factory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject currentUser =SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("java","java");
		try{
                currentUser.login(token);
		}catch (UnknownAccountException e){
			e.printStackTrace();
		}catch (IncorrectCredentialsException e){
			e.printStackTrace();
		}
		boolean authenticated = currentUser.isAuthenticated();
		System.out.println(authenticated);
	}
	public static void main(String[] args){
		Test test = new Test();
		test.login();


	}
}
