package edu0425.spring.demo;

import java.util.HashMap;
import java.util.Map;

import edu0425.spring.vo.DeptInfo;

public class Demo {
	public static void main(String[] args) {
//		System.out.println(21/5);
		
		Map<String, DeptInfo> map = new HashMap<String, DeptInfo>();
		
		DeptInfo d1 = new DeptInfo(1, "dept1", "loc1");
		DeptInfo d2 = new DeptInfo(2, "dept2", "loc2");
		DeptInfo d3 = new DeptInfo(3, "dept3", "loc3");
		
		map.put("d1", d1);
		map.put("d1", d2);
		map.put("d1", d3);
		
		System.out.println(map.get("d1"));
	}
}
