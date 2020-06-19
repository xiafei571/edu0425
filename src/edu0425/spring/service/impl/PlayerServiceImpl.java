package edu0425.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0425.common.page.Pagination;
import edu0425.common.page.PaginationResult;
import edu0425.spring.dao.mapper.PlayerMapper;
import edu0425.spring.init.InitInfo;
import edu0425.spring.service.PlayerService;
import edu0425.spring.vo.ChartData;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PlayerInfo;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public Integer getTotalCount() {
		// 获取所有球员数量
		return playerMapper.getTotalCount();
	}

	@Override
	public PaginationResult<List<PlayerInfo>> getPlayerPage(Integer pageIndex, Integer pageSize) {
		// 获取分页的球员列表信息
		Pagination pagination = new Pagination(pageIndex, pageSize);
		pagination.setTotalCount(getTotalCount());
		// 查询一次，得到10个结果
		List<PlayerInfo> list = playerMapper.getPlayers(pagination.getCursor(), pagination.getOffset());
		for (PlayerInfo player : list) {
			// 循环查询俱乐部和国家信息
//			player.setClub(playerMapper.getClubById(player.getCid()));
//			player.setNation(playerMapper.getNationById(player.getNid()));
			player.setClub(InitInfo.club.get(player.getCid()));
			player.setNation(InitInfo.nation.get(player.getNid()));
		}

		pagination.setCurrentPageCount(list.size());

		PaginationResult<List<PlayerInfo>> result = new PaginationResult<List<PlayerInfo>>(pagination, list);

		return result;
	}

	@Override
	public NationInfo getNationById(Integer nid) {
		// TODO 通过国家ID获取国家信息
		return null;
	}

	@Override
	public ClubInfo getClubById(Integer cid) {
		// TODO 获取俱乐部信息
		return null;
	}

	@Override
	public List<NationInfo> getAllNation() {
		// TODO 获取所有国家信息
		return null;
	}

	@Override
	public List<ClubInfo> getAllClub() {
		// TODO 获取所有俱乐部信息
		return null;
	}

	@Override
	public PlayerInfo getPlayerById(Integer pid) {
		return playerMapper.getPlayerById(pid);
	}

	@Override
	public JSONArray getJsonAge() {
		List<ChartData> list = playerMapper.getDataOfAge();
		JSONArray array = new JSONArray();
		for (ChartData data : list) {
			JSONObject json = new JSONObject();
			json.put("value", data.getValue());
			json.put("name", data.getKey());
			array.add(json);
		}

		return array;
	}

}
