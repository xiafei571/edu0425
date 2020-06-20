package edu0425.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import edu0425.spring.vo.ChartData;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PlayerInfo;

public interface PlayerMapper {

	@Select("select count(*) from players")
	Integer getTotalCount();

	@Select("select * from players limit #{cursor},#{offset}")
	List<PlayerInfo> getPlayers(@Param("cursor") Integer cursor, @Param("offset") Integer offset);

	@Select("select * from players where pid = #{pid}")
	PlayerInfo getPlayerById(@Param("pid") Integer pid);

	@Select("select * from nation where nid = #{nid}")
	@ResultMap("nationInfoResult")
	NationInfo getNationById(@Param("nid")Integer nid);

	@Select("select * from club where cid = #{cid}")
	@ResultMap("clubInfoResult")
	ClubInfo getClubById(@Param("cid")Integer cid);

	@Select("select * from nation")
	@ResultMap("nationInfoResult")
	List<NationInfo> getAllNation();

	@Select("select * from club")
	@ResultMap("clubInfoResult")
	List<ClubInfo> getAllClub();
	
	List<ChartData> getDataOfAge();
	
	List<ChartData> getAvgOfOverallByNation();

}
