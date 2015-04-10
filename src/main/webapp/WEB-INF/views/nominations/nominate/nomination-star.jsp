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
					<form:form action="nominationConfirmation.cgi" method="POST"
						commandName="nomination">
						<!--cgi-rnr-memberRigthWrapper-->
						<div class="col-md-12 col-xs-12">
							<!--accordion-->
							<div id="accordion" class="cgi-rnr-panel panel-group">
								<!--INFORMATION-->
								<jsp:include page="../common/awardInfo.jsp"></jsp:include>
								<!--End INFORMATION-->
								<!--MEMBER INFORMATION-->
								<jsp:include page="../common/memberInfoForAward.jsp"></jsp:include>
								<!--End MEMBER INFORMATION-->
								<!--Criteria To Qualify-->
								<jsp:include page="../common/criteria-star.jsp"></jsp:include>
								<!--End Criteria To Qualify-->
								<!--CITATION-->
								<jsp:include page="../common/citation.jsp"></jsp:include>
								<!--End CITATION-->
								<!--End accordion-->
							</div>
							<!-- End cgi-rnr-memberRigthWrapper-->
						</div>
						<div class="cgi-rnr-submitArea">
							<button type="submit" class="btn">Submit</button>
							<button class="btn" type="reset">Clear</button>
						</div>
					</form:form>
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
