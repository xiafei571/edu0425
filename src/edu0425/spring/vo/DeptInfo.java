package edu0425.spring.vo;

public class DeptInfo {

	private Integer deptno;
	
	private String dname;
	
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public DeptInfo(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	//无参构造函数
	public DeptInfo() {
	}

	@Override
	public String toString() {
		return "DeptInfo [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
