package edu0425.spring.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.util.MD5Util;
import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	// http://localhost:8080/edu0425/user/admin
	@RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfoByLoginId(@PathVariable String loginId) {
		return userService.getUserByLoginId(loginId);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("user", new LoginInfo());
		return "login";
	}

	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
		// 如果成功，跳转到 index页面
		if (userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}
		// 否则返回登录页，密码置空，显示账号或密码错误
		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "账号或密码错误");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login2(LoginInfo user, HttpSession session, ModelMap modelMap) {
		// 获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		// 封装表单中提交的用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginId(),
				MD5Util.textToMD5U16(user.getPassword()), user.isRemember());
		try {
			// 调用login方法， 传入封装好的token（令牌）
			subject.login(token);
			// 登录成功跳转：
			return "redirect:player/index?pageIndex=1&pageSize=10";
		} catch (Exception e) {
			// 否则返回登录页，密码置空，显示账号或密码错误
			user.setPassword(null);
			modelMap.put("user", user);
			modelMap.put("msg", "账号或密码错误");
			return "login";
		}
	}

	// RESTFUL API 接口，返回json数据
	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getPermissions(@PathVariable String loginId) {
		// 根据loginId查询这个用户的所有权限关键字，以json数组的格式返回
		return userService.getPermissions(loginId);
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}

	@RequestMapping("/profile/{loginId}")
	public String userProfile(@PathVariable String loginId, ModelMap modelMap) {
		UserInfo user = userService.getUserByLoginId(loginId);
		modelMap.put("user", user);
		return "user_profile";
	}

}
