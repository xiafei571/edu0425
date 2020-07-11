package edu0425.spring.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import edu0425.common.util.MD5Util;
import edu0425.spring.dao.mapper.UserMapper;
import edu0425.spring.vo.UserInfo;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private UserMapper userMapper;

	public static void main(String[] args) {
		System.out.println(MD5Util.textToMD5U16("admin"));
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//拿到当前登录的用户ID
		String loginId = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userMapper.getRoles(loginId));
		authorizationInfo.setStringPermissions(userMapper.getPermissions(loginId));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginId = (String) token.getPrincipal();
		UserInfo user = userMapper.getUserByLoginId(loginId);
		AuthenticationInfo authInfo = new SimpleAuthenticationInfo(user.getLoginId(), user.getPassword(), getName());
		return authInfo;
	}
}
