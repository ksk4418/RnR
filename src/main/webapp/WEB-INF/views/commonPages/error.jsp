<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="head.jsp"></jsp:include>
	<jsp:include page="jQuery.jsp"></jsp:include>

		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="navigationMenu.jsp"></jsp:include>

				<div class="row alert alert-info cgi-rnr-info-box">
					<a href="#" class="close" data-dismiss="alert">&times;</a>
					<p>
						${errorMessage}
					</p>
				</div>
		<jsp:include page="footer.jsp"></jsp:include>
				
				