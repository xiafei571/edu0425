package edu0425.spring.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu0425.spring.dao.mapper.PlayerMapper;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.NationInfo;

@Component
public class InitInfo implements InitializingBean {

	@Autowired
	private PlayerMapper playerMapper;

	public static Map<Integer, ClubInfo> club = new HashMap<Integer, ClubInfo>();

	public static Map<Integer, NationInfo> nation = new HashMap<Integer, NationInfo>();

	@Override
	public void afterPropertiesSet() throws Exception {
		initClub();
		initNation();
	}

	private void initNation() {
		// 初始化国家数据
		List<NationInfo> nationList = playerMapper.getAllNation();
		for (NationInfo n : nationList) {
			nation.put(n.getNid(), n);
		}
		System.out.println("国家数据初始化，数量" + nationList.size());
	}

	private void initClub() {
		// 拿到所有俱乐部信息
		List<ClubInfo> clubList = playerMapper.getAllClub();
		for (ClubInfo c : clubList) {
			club.put(c.getCid(), c);
		}
		System.out.println("俱乐部数据初始化，数量" + clubList.size());
	}

}
