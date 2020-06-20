<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Player Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- 引入 ECharts 文件 -->
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Welcome to Player Page</h1>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">球员ID</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Overall</th>
					<th scope="col">国籍</th>
					<th scope="col">俱乐部</th>
				</tr>
			</thead>
			<tbody id="player_tbody">
				<!-- 我们要在这里用jsrender模板啦！ -->
			</tbody>
		</table>

		<nav aria-label="...">
			<ul class="pagination" id="page">
				<li class="page-item disabled" id="page_pre"><a
					class="page-link" href="index?pageIndex=${pageIndex-1}&pageSize=${pageSize}" tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item" id="page_next"><a class="page-link"
					href="index?pageIndex=${pageIndex+1}&pageSize=${pageSize}">Next</a></li>
			</ul>
		</nav>
		
		 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
		 <div class="row">
		 	<div id="chart_1" class="col" style="height:400px;"></div>
		 	<div id="chart_2" class="col" style="height:400px;"></div>
		 </div>
		 
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		
	<!-- Load JsRender latest version, from www.jsviews.com: -->
	<script src="https://www.jsviews.com/download/jsrender.js"></script>
		
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
			//var totalCountPage = ${rs.pagination.totalCountPage};
			var pageIndex = ${pageIndex};
			var pageSize = ${pageSize};
			
			//http://localhost:8080/edu0425/player/page?pageIndex=1&pageSize=10
			//ajax 可以去请求服务端接口，并且接收返回值, 修改页面数据
			$.ajax({
				url : "page?pageIndex="+pageIndex+"&pageSize="+pageSize,
				success : function(result){
					//ajax成功返回result
					var totalCountPage = result.pagination.totalCountPage;
					initPage(pageIndex, pageSize, totalCountPage);
					
					//1.获取模板
					jsRenderTpl = $.templates('#player_table');
					//2.模板与数据融合
					finalTpl = jsRenderTpl(result);
					//3.加载到HTML里
					$("#player_tbody").html(finalTpl);
				}
				
			});
			
			//初始化图表
			initChart();
			//初始化第二个图表
			initChart2();
		}
		
		function initPage(pageIndex, pageSize, totalCountPage){
			//alert("总页数："+totalCountPage);
			var page_num = "";
		
			var i = 1;
			var j = totalCountPage;
			
			if(pageIndex > 5){
				i = pageIndex - 4;
			}
			
			if(pageIndex + 4 < totalCountPage) {// 如果超出范围就用...代替
				$("#page_next").before("...");
				j = pageIndex + 5;
			}
			
			for (; i <= j; i++) {
				if(i == pageIndex){
					page_num = page_num + '<li class="page-item active" aria-current="page"><a class="page-link" href="index?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'<span class="sr-only">(current)</span></a></li>';
				}else{
					page_num = page_num + '<li class="page-item"><a class="page-link" href="index?pageIndex='+i+'&pageSize='+pageSize+'">'+i+'</a></li>';
				}
			}
			
			$("#page_pre").after(page_num);
			
			if(pageIndex > 5){ // 如果超出范围就用...代替
				$("#page_pre").after("...");
			}
			
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
	
	<script type="text/x-jsrender" id="player_table">
		{{for pageData}}
			<tr>
				<td>{{:rowId}}</td>
				<td>{{:pid}}</td>
				<td>{{:pname}}</td>
				<td>{{:age}}</td>
				<td>{{:overall}}</td>
				<td>{{:nation.nation}}</td>
				<td>{{:club.cname}}</td>
			</tr>
		{{/for}}
	</script>
	
	<script type="text/javascript">
	function initChart(){
		// 初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_1'));
			//ajax 可以去请求服务端接口，并且接收返回值, 修改页面数据
		$.ajax({
			url : "chartofage",
			success : function(result){
				option = {
						title: {
							text:"球员年龄分布",
							subtext:"数据来源FIFA",
							left: "center"
						},
						
						series:[
							{
								name:"年龄段",
								type:"pie",
								radius:"55%",
								center:["50%", "60%"],
								// 动态数据
								data:result
							}
						]
				};
				
				//显示图表
				myChart.setOption(option);
			}
		});
	}
	
	
	function initChart2(){
		// 初始化echarts实例
		var myChart = echarts.init(document.getElementById('chart_2'));
		$.ajax({
			url : "chartofoverall",
			success : function(result){
				option = {
					    title:{
					          text: '国家球员能力平均值Top10',
					        subtext: 'FIFA 2018',
					    },
					    tooltip: {
					        trigger: 'axis',
					        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
					            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
					    xAxis: {
					        type: 'category',
					        data: result.xAxis,
					        axisTick: {
				                alignWithLabel: true
				            }
					    },
					    yAxis: {
					        type: 'value',
					        max:80,
					        min:60
					    },
					    series: [{
					        data: result.series,
					        type: 'bar'
					    }]
					};
				//显示图表
				myChart.setOption(option);
			}});
	}
	</script>
</body>
</html>