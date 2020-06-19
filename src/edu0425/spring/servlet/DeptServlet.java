package edu0425.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu0425.spring.service.DeptService;
import edu0425.spring.service.impl.DeptServiceImpl;
import edu0425.spring.vo.DeptInfo;

public class DeptServlet extends HttpServlet {

	/*
	 * 1. 实现(implements)Servelt接口 2. 继承(extends)GenericServlet 实现service方法 3. 继承HttpServlet 实现doget
	 * dopost
	 */

	private DeptService deptService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deptService = new DeptServiceImpl();
		List<DeptInfo> list = deptService.getDeptList();
		req.setAttribute("list", list);
		req.setAttribute("cnt", deptService.getDeptCount());
		req.getRequestDispatcher("/dept.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
