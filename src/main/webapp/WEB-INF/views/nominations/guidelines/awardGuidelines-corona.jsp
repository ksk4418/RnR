<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<!--cgi-rnr-memberRigthWrapper-->
					<div class="col-md-12 col-xs-12">
						<!--accordion-->
						<div id="accordion" class="cgi-rnr-panel panel-group">
							<!--cri-rnr-INFORMATION-->
							<h2 align="center">Corona&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="nominate.cgi?awardId=${awardId}&emplId=${emplId}">Nominate</a></h2>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">INFORMATION</a>
										<span class="cgi-rnr-arrow-down" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"></span>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse in">
									<div class="panel-body">
										<div class="cgi-rnr-infoPanel awardPanel row">
											<table class="table cgi-rnr-awardTable">
												<tbody>
													<tr>
														<td class="width20">Description</td>
														<td>The Bumble Bee award recognies freshers for demonstrating performance par excellence in the past year</td>
													</tr>
													<tr>
														<td class="width20">Eligibility</td>
														<td>Full Time Members of CGI India</td>
													</tr>
													<tr>
														<td class="width20">Level</td>
														<td>Title Group 1</td>
													</tr>
													<tr>
														<td class="width20">Panel Review</td>
														<td>No</td>
													</tr>
													<tr>
														<td class="width20">Frequency</td>
														<td>Quarterly</td>
													</tr>
													<tr>
														<td>Forum</td>
														<td>All Hands Meet</td>
													</tr>
													<tr>
														<td>Award Items</td>
														<td>Certificate, Cash Award - INR 3000*</td>
													</tr>
													<tr>
														<td>Number of Nominations</td>
														<td>1.5% of the total resource strength of the Engagement / Support Group (rounded off to the nearest rational number)</td>
													</tr>
												</tbody>
											</table>
										</div>	
									</div>
								</div>
							</div>
							<!--End cri-rnr-INFORMATION-->
							<!--Criteria To Qualify-->
							<div class="panel panel-default ">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Criteria To Qualify</a>
										<span class="cgi-rnr-arrow-down" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"></span>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse in">
									<div class="panel-body">
										<div class="cgi-rnr-criteriaPanel row">
											<ul>
												<h6><strong>Project / Function Deliverables:</strong></h6>
												<li>Citable Instances pertaining to on time deliveries / adherence to strict deadlines</li>
												<li>Tangible impact on billings (revenue enhancement / generation)</li>
												<li>Initiatives and Consistenc</li>
												<li>Benefit to Customer / Project</li>
											</ul>
											<ul>
												<h6><strong>Project / Function Deliverables:</strong></h6>
												<li>Citable Instances pertaining to on time deliveries / adherence to strict deadlines</li>
												<li>Tangible impact on billings (revenue enhancement / generation)</li>
												<li>Initiatives and Consistenc</li>
												<li>Benefit to Customer / Project</li>
											</ul>
											<ul>
												<h6><strong>Project / Function Deliverables:</strong></h6>
												<li>Citable Instances pertaining to on time deliveries / adherence to strict deadlines</li>
												<li>Tangible impact on billings (revenue enhancement / generation)</li>
												<li>Initiatives and Consistenc</li>
												<li>Benefit to Customer / Project</li>
											</ul>
										</div>
									</div>
								</div>	
							</div>
							<!--End Criteria To Qualify-->
							<!--Award Winner-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Award Winner</a>
										<span class="cgi-rnr-arrow-down" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"></span>
									</h4>
								</div>
<!-- 								<div id="collapseThree" class="panel-collapse in"> -->
<!-- 										<table class="table tablesorter tablesorter-default cgi-rnr-searchTable" role="grid"> -->
<!-- 										<thead> -->
<!-- 											<tr role="row" class="tablesorter-headerRow"> -->
<!-- 												<th data-column="0" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Name: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Year/Quarter</div></th> -->
<!-- 												<th data-column="1" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Emp Id: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Name</div></th> -->
<!-- 												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Award</div></th> -->
<!-- 												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Status</div></th> -->
<!-- 												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">&nbsp;&nbsp;&nbsp;&nbsp;</div></th> -->
<!-- 											</tr> -->
<!-- 										</thead> -->
<!-- 										<tbody aria-live="polite" aria-relevant="all"> -->
<%-- 										<c:if test="${not empty awards}"> --%>
<%-- 											<c:forEach var="listValue" items="${awards}"> --%>
										
<!-- 												<tr role="row"> -->
<%-- 													<td>${listValue[1]}/QTR-${listValue[2]}</td> --%>
<%-- 													<td>${listValue[4]}</td> --%>
<%-- 													<td>${listValue[8]}</td> --%>
<%-- 													<td>${listValue[7]}</td> --%>
<%-- 													<td><a href="viewNomination.cgi?id=${listValue[0]}" >View</a></td> --%>
<!-- 												</tr> -->
<%-- 												</c:forEach> --%>
<%-- 											</c:if> --%>
<!-- 										</tbody> -->
<!-- 									</table> -->
<!-- 									</div> -->
								</div>
							</div>
							<!--EndAward Winner-->						
						</div>
						<!--End accordion-->
					</div>
					<!-- End cgi-rnr-memberRigthWrapper-->
					</div>
				</div>
			</section>
			<!-- Main Content-->
			<!-- Footer -->
<jsp:include page="../../commonPages/footer.jsp"></jsp:include>
			<!-- End Footer-->
		</div><!--Endwrapper-->
		<!-- jQuery -->
<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
	</body>
</html>		