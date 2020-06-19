package edu0425.spring.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu0425.spring.dao.DeptDAO;
import edu0425.spring.vo.DeptInfo;

public class DeptDAOImpl implements DeptDAO{

	private static String url = "jdbc:mysql://172.16.81.3:3306/setsu0406";
	private static String user = "root";
	private static String password = "root";
	
	@Override
	public List<DeptInfo> getDeptList() {
		List<DeptInfo> deptList = new ArrayList<DeptInfo>();
		try {
			// 注册驱动1 
			Class.forName("com.mysql.jdbc.Driver");
			// 注册驱动2
//			Driver driver = new com.mysql.jdbc.Driver();
			// 注册驱动3
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// 获取连接
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			// 创建Statement
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				DeptInfo dept = new DeptInfo(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				deptList.add(dept);
			}

			stmt.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
	}

	@Override
	public DeptInfo getDeptById(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getDeptCount() {
		Integer cnt = 0;
		try {
			// 注册驱动1 
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			// 创建Statement
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM dept");
			while(rs.next()) {
				cnt = rs.getInt(1);//rs.getInt("cnt")
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}


}
