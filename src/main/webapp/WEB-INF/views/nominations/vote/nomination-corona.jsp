<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<jsp:include page="../../commonPages/head.jsp"></jsp:include>
<body>
	<!--wrapper-->
	<div id="wrapper">
		<!-- Header-->
		<jsp:include page="../../commonPages/header.jsp"></jsp:include>
		<!--End Header-->
		<!-- Golbal navigation -->
		<jsp:include page="../../commonPages/navigationMenu.jsp"></jsp:include>
		<!--End Golbal navigation -->
		<!-- Main Content-->
		<section class="cgi-rnr-main-content">
			<div class="container">
				<div class="row">
					<form action="searchAwardsPanel.cgi" method="post">
						<!--cgi-rnr-memberRigthWrapper-->
						<input type="hidden" name="id" value = "${nominationId}"/>
<%-- 						<jsp:include page="vote.jsp"></jsp:include> --%>
						<div align="right">
							<%if(request.getParameter("iid") == null) {%>
								<button type="submit" class="btn rnr-btn-primary">Vote</button>
							<%} %>
							<a href="searchAwardsPanel.cgi" class="btn rnr-btn-primary">Close</a>
						</div>
						</form>
						<div class="col-md-12 col-xs-12">
							<!--accordion-->
							<div id="accordion" class="cgi-rnr-panel panel-group">
								<!--INFORMATION-->
								<!--Criteria To Qualify-->
								<jsp:include page="../common/criteria-corona.jsp"></jsp:include>
								<!--End Criteria To Qualify-->
								<!--CITATION-->
								<jsp:include page="../common/citation.jsp"></jsp:include>
								<!--End CITATION-->
								<!--End accordion-->
							</div>
							<!-- End cgi-rnr-memberRigthWrapper-->
						</div>
				</div>
			</div>
		</section>
		<!-- Main Content-->
		<!-- Footer -->
		<jsp:include page="../../commonPages/footer.jsp"></jsp:include>
		<!-- End Footer-->
	</div>
	<!--Endwrapper-->
	<!-- jQuery -->
	<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
</body>
</html>
