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
									<form action="searchAwards.cgi" method="post">
										<div class="row">
												<div class="col-md-4 col-xs-4">
													<input type="text" name="emplName" class="form-control" id="name" placeholder="Employee Name">
												</div>
												<div class="col-md-4 col-xs-4 cgi-rnr-empidAwardWinner">
													<input type="text" name="emplId" class="form-control" id="emp" placeholder="Employee Id">
											    </div>
												<div class="col-md-4 col-xs-4">
													<input type="text" name="fiscalYear" class="form-control" id="fy" placeholder="Fiscal Year" required="required">
												</div>
										</div>
										<div class="row">
												<div class="col-md-4 col-xs-4">
													<input type="text" name="quarter" class="form-control" id="qtr" placeholder="Quarter" required="required">
												</div>
												<div class="col-md-4 col-xs-4 cgi-rnr-empidAwardWinner">
													<input type="text" name="award" class="form-control" id="award" placeholder="Award">
											    </div>
												<div class="col-md-4 col-xs-4 cgi-rnr-searchAwardWinner">
													<button class="btn rnr-btn-primary" id="">Search</button>
												</div>
										</div>
										</form>
									<table class="table tablesorter tablesorter-default cgi-rnr-searchTable" role="grid">
										<thead>
											<tr role="row" class="tablesorter-headerRow">
												<th data-column="0" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Name: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Year/Quarter</div></th>
												<th data-column="1" class="tablesorter-header tablesorter-headerUnSorted" tabindex="0" scope="col" role="columnheader" aria-disabled="false" unselectable="on" aria-sort="none" aria-label="Emp Id: No sort applied, activate to apply an ascending sort" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Name</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Award</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Status</div></th>
												<th class="awards tablesorter-header sorter-false tablesorter-headerUnSorted" data-column="2" tabindex="0" scope="col" role="columnheader" aria-disabled="true" unselectable="on" aria-sort="none" style="-webkit-user-select: none;"><div class="tablesorter-header-inner">Nominated By</div></th>
											</tr>
										</thead>
										<tbody aria-live="polite" aria-relevant="all">
										<c:if test="${not empty searchAwards}">
											<c:forEach var="listValue" items="${searchAwards}">
												<tr role="row">
														<td>${listValue[1]}/QTR-${listValue[2]}</td>
														<td>${listValue[4]}</td>
														<td>${listValue[8]}</td>
														<td>${listValue[7]}</td>
														<td>${listValue[9]}</td>
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