package edu0425.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0425.common.page.PaginationResult;
import edu0425.spring.service.PlayerService;
import edu0425.spring.vo.PlayerInfo;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playService;

	//http://localhost:8080/edu0425/player/page?pageIndex=1&pageSize=10
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public PaginationResult<List<PlayerInfo>> getPage(Integer pageIndex, Integer pageSize) {
		return playService.getPlayerPage(pageIndex, pageSize);
	}
	
	//http://localhost:8080/edu0425/player/info/158023
	//restfulAPI
	@RequestMapping(value = "/info/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public PlayerInfo getPlayer(@PathVariable Integer pid) {
		return playService.getPlayerById(pid);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getMain(ModelMap modelMap, Integer pageIndex, Integer pageSize) {
		modelMap.put("pageIndex", pageIndex);
		modelMap.put("pageSize", pageSize);
		return "player";
	}
	
	@RequestMapping(value = "/chartofage", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getChartOfAge() {
		return playService.getJsonAge();
	}
	
	@RequestMapping(value = "/chartofoverall", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAvgOfOverallByNation() {
		return playService.getAvgOfOverallByNation();
	}
}
