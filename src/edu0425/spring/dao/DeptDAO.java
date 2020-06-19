package edu0425.spring.dao;

import java.util.List;

import edu0425.spring.vo.DeptInfo;

public interface DeptDAO {

	List<DeptInfo> getDeptList();
	
	DeptInfo getDeptById(Integer deptno);
	
	Integer getDeptCount();
	
}
