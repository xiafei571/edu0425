<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>用户信息</title>
</head>
<body>

	<div class="container">
	    <h4>${user.userName}</h4>
		<h4>${user.onOff}</h4>
		
		<div class="form-check" id="onOff-check">
			<input class="form-check-input" type="checkbox" 
				id="defaultCheck1"> <label class="form-check-label"
				for="defaultCheck1"> NOTIFYPRAISE </label> <br /> 
				<input
				class="form-check-input" type="checkbox" id="defaultCheck2"> <label class="form-check-label" for="defaultCheck2">
				NOTIFYCOMMENT </label> <br /> 
				<input class="form-check-input"
				type="checkbox" value="" id="defaultCheck3"> <label
				class="form-check-label" for="defaultCheck3"> NOTIFYFORWARD
			</label> <br /> 
			<input class="form-check-input" type="checkbox" 
				id="defaultCheck4"> <label class="form-check-label"
				for="defaultCheck4"> NOTIFYAT </label> <br /> 
				<input
				class="form-check-input" type="checkbox" id="defaultCheck5"> <label class="form-check-label" for="defaultCheck5">
				FOLLOWING </label> <br /> 
				<input class="form-check-input" type="checkbox"
				id="defaultCheck6"> <label
				class="form-check-label" for="defaultCheck6"> NOTIFYSYSTEM </label>
			<br />
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		window.onload = function() {
			var onOff = parseInt("${user.onOff}").toString(2);
			var array = onOff.split("");
			var inputArray = $('#onOff-check>input');
			for (var i = 0; i < array.length; i++) {
				if (array[i] == 1) {
					if (null != inputArray[i]) {
						inputArray[i].setAttribute("checked", true);
					}
				} else {
					if (null != inputArray[i]) {
						inputArray[i].removeAttribute("checked");
					}
				}
			}

		}
	</script>
</body>
</html>