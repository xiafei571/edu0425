package edu0425.spring.service.impl;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.util.MD5Util;
import edu0425.spring.dao.mapper.UserMapper;
import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserInfo getUserByLoginId(String loginId) {
		return userMapper.getUserByLoginId(loginId);
	}

	@Override
	public boolean loginValid(LoginInfo login, HttpSession session) {
		//1.先判断登录loginid是不是空
		if(StringUtils.isBlank(login.getLoginId()))
			return false;
		
		//2.看用户是否能找到
		UserInfo user = getUserByLoginId(login.getLoginId());
		if(null != user) {
			//3. 判断密码对不对
			if(user.getPassword().equals(MD5Util.textToMD5U16(login.getPassword()))) {
				//4.如果密码相同
				login.setUsername(user.getUserName());
				session.setAttribute("USER_SESSION", login);
				return true;
			}
		}
		return false;
	}

	@Override
	public JSONArray getPermissions(String loginId) {
		Set<String> permissions = userMapper.getPermissions(loginId);
		JSONArray jsonArray = new JSONArray();
		for(String s : permissions) {
			jsonArray.add(s);
		}
		return jsonArray;
	}

}
