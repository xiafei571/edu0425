package edu0425.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
		//如果成功，跳转到 index页面
		if(userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}
		//否则返回登录页，密码置空，显示账号或密码错误
		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "账号或密码错误");
		return "login";
	}
	
	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getPermissions(@PathVariable String loginId) {
		//TODO 根据loginId查询这个用户的所有权限关键字，以json数组的格式返回
		return null;
	}

}
