<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Dept Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome to Department Page</h1>
		
		<a href="add">添加部门<br/></a>
		
		<table class="table table-bordered">
			<thead>
				<tr>部门数量：${rs.pagination.totalCount}
				</tr>
				<tr>
					<th scope="col">#</th>
					<th scope="col">部门名称</th>
					<th scope="col">地点</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rs.pageData}" var="dept">
					<tr>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td>${dept.loc}</td>
						<td>
							<a href="update/${dept.deptno}">修改</a> &nbsp;
							<a href="delete/${dept.deptno}" onclick="return confirm('确定要删除${dept.dname}吗?')">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<nav aria-label="...">
			<ul class="pagination" id="page">
				<li class="page-item disabled" id="page_pre"><a
					class="page-link" href="list?pageIndex=${rs.pagination.pageIndex-1}&pageSize=${rs.pagination.pageSize}" tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item" id="page_next"><a class="page-link"
					href="list?pageIndex=${rs.pagination.pageIndex+1}&pageSize=${rs.pagination.pageSize}">Next</a></li>
			</ul>
		</nav>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		window.onload = function() {//页面加载后调用
			var totalCountPage = ${rs.pagination.totalCountPage};
			var pageIndex = ${rs.pagination.pageIndex};
			var pageSize = ${rs.pagination.pageSize};
			
			//alert("总页数："+totalCountPage);
			var page_num = "";
			for (var i = 1; i <= totalCountPage; i++) {
				if(i == pageIndex){
					page_num = page_num + '<li class="page-item active" aria-current="page"><a class="page-link" href="list?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'<span class="sr-only">(current)</span></a></li>';
				}else{
					page_num = page_num + '<li class="page-item"><a class="page-link" href="list?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'</a></li>';
				}
			}
			
			$("#page_pre").after(page_num);
			
			if(pageIndex == 1){//如果是第一页，上一页按钮置灰
				$("#page_pre").addClass("disabled");
			}else{
				$("#page_pre").removeClass("disabled");
			}
			
			if(pageIndex == totalCountPage){//如果是最后一页，下一页按钮置灰
				$("#page_next").addClass("disabled");
			}else{
				$("#page_next").removeClass("disabled");
			}
			
		}
	</script>
</body>
</html>