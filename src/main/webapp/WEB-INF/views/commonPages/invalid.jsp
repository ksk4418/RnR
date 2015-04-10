<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script>
function showError(){
	alert("Invalid user name password combination. Try again");
}
</script>
</head>
<body onload="showError()">
</body>
</html>