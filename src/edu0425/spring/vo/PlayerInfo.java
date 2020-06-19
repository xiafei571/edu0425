package edu0425.spring.vo;

public class PlayerInfo {
	//序列号
	private Integer rowId;
	//球员ID
	private Integer pid;
	//球员名称
	private String pname;
	//年龄
	private Integer age;
	//照片
	private String photo;
	//国籍ID
	private Integer nid;
	//能力
	private Integer overall;
	//潜力
	private Integer potential;
	//俱乐部ID
	private Integer cid;
	
	private ClubInfo club;
	
	private NationInfo nation;
	
	
	public ClubInfo getClub() {
		return club;
	}
	public void setClub(ClubInfo club) {
		this.club = club;
	}
	public NationInfo getNation() {
		return nation;
	}
	public void setNation(NationInfo nation) {
		this.nation = nation;
	}
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public Integer getOverall() {
		return overall;
	}
	public void setOverall(Integer overall) {
		this.overall = overall;
	}
	public Integer getPotential() {
		return potential;
	}
	public void setPotential(Integer potential) {
		this.potential = potential;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
}
