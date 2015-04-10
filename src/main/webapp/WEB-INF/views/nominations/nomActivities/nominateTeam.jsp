<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<jsp:include page="../../commonPages/head.jsp"></jsp:include>
	<!-- jQuery -->
	<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
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
					<div class="col-md-12 col-xs-12 cgi-rnr-search">
						<h2>Select an award</h2>
						<hr />
						<form class="form-horizontal" role="form"
							action="nomination.cgi method="post">
							<div class="form-group">
								<label class="control-label col-sm-2" for="Select">Award:</label>
								<div class="col-sm-4">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											id="menu1" data-toggle="dropdown">
											Select <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
											<c:if test="${not empty listOfAwardsModel}">
												<c:forEach var="listValue" items="${listOfAwardsModel}">
													<li role="presentation"><a role="menuitem" tabindex="-1"
														href="nominate.cgi?awardId=${listValue}&aType=2">${listValue}</a></li>
												</c:forEach>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-2"></div>
								<div class="col-sm-1">
<!-- 									<button class="btn" id="">Nominate</button> -->
								</div>
							</div>
						</form>
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

</body>
</html>
