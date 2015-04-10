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
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Awards</a>
										<span class="cgi-rnr-arrow-down" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"></span>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse in">
									<div class="panel-body">
									<table class="table tablesorter tablesorter-default cgi-rnr-searchTable" role="grid">
										<thead>
											<tr role="row" class="tablesorter-headerRow">
												<th data-column="0" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Name: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Year/Quarter</div></th>
												<th data-column="1" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Emp Id: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Name</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Award</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Status</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">&nbsp;&nbsp;&nbsp;&nbsp;</div></th>
											</tr>
										</thead>
										<tbody aria-live="polite" aria-relevant="all">
										<c:if test="${not empty searchAwardsPanel}">
											<c:forEach var="listValue" items="${searchAwardsPanel}">
												<tr role="row">
														<td>${listValue.FY}/QTR-${listValue.quarter}</td>
														<td>${listValue.employeeName}</td>
														<td>${listValue.awardName}</td>
														<c:if test="${listValue.vote lt 1 }">
														<td>In Process</td>
														<td><a href="voteNomination.cgi?id=${listValue.id}" ><b>View/Vote</b></a></td>
														</c:if>
														<c:if test="${listValue.vote gt 0 }">
														<td>Voted</td>
														<td><a href="voteNomination.cgi?iid=${listValue.id}" ><b>View</b></a></td>
														</c:if>
														
												</tr>
											</c:forEach>
										</c:if>
										</tbody>
									</table>
									</div>
								</div>
							</div>
							<!--End Award Winner-->
						</div>
						<!--End accordion-->
					</div>
					<!-- End cgi-rnr-memberRigthWrapper-->
					</div>
				</div>
			</section>
			<!-- Main Content-->
			<!-- Footer -->
			<footer class="cgi-rnr-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<div class="cgi-rnr-copyright-info">
								&copy; CGI Group Inc.
							</div>
						</div>			
					</div>
				</div>
			</footer>
			<!-- End Footer-->
		</div><!--Endwrapper-->
		<!-- jQuery -->
<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
	</body>
</html>		