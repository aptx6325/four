package com.java.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by liang on 2018/3/21.
 */
public class Realm extends AuthenticatingRealm {
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken token) throws
			AuthenticationException{
		String principal = (String) token.getPrincipal();
		char [] credentials = (char[]) token.getCredentials();
		String pass =String.valueOf(credentials);
		String user ="java";
		String password="java";
		if(!pass.equals(password)){
            throw  new UnknownAccountException("用户名或密码错误");
		}
		String  realmName =getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
		return  info;

	}
}
