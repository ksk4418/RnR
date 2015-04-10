<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<jsp:include page="../../commonPages/head.jsp"></jsp:include>
	<!-- jQuery -->
	<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
	<script src=<c:url value ="/resources/assets/js/jquery.autocomplete.min.js"/>></script>
  
  <style>
  .autocomplete-suggestions {
    max-height: 100px;
    overflow-y: auto;
    /* prevent horizontal scrollbar */
    overflow-x: hidden;
  }

  * html .autocomplete-suggestions {
    height: 100px;
  }

.autocomplete-suggestions {
        padding: 0px;
        border: 1px solid WindowFrame;
        background-color: Window;
        overflow: hidden;
}

.autocomplete-selected {
        background-color: Highlight;
        color: HighlightText;
		width: 100%;
        list-style-position: outside;
        list-style: none;
        padding: 0;
        margin: 0px;
        cursor: pointer;
        overflow: hidden;
}
  </style>
<script type="text/javascript" lang="javascript">
 	$(document).ready(function() {
 		$('#emplName').autocomplete({
 			serviceUrl : 'getEmployeeNames?awardId=${awardId}',
 			paramName : "tagName",
 			delimiter : ",",
 			transformResult : function(response) {
 				return {
 					suggestions : $.map($.parseJSON(response), function(item) {
 						return {
 							value : item.employeeName,
 							data : item.employeeId
 						};
 					})
 				};
 			}
 		});
 	});
</script>

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
						<h2>Nominate yourself or your peer member</h2>
						<hr />
						<form class="form-horizontal" role="form"
							action="nominationSearch.cgi" method="post">
							<div class="form-group ui-widget">
								<label class="control-label col-sm-2" for="awardId">Award:</label>
								<div class="col-sm-4 ui-widget">
									<input type="text" class="form-control ui-widget" id="awardId"
										placeholder="Name" name = "awardId" required="required" readonly="readonly" value="${awardId }">
									<input type="hidden" name="aType" id="aType" value ="${aType}" >
								</div>
							</div>
							<div class="form-group ui-widget">
								<label class="control-label col-sm-2" for="name">Name:</label>
								<div class="col-sm-4 ui-widget">
									<input type="text" class="form-control ui-widget" id="emplName"
										placeholder="Name" name = "emplName" required="required">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="emp">Employee
									Id:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="emp"
										placeholder="Employee Id" name="emplId">
								</div>
								<div class="col-sm-1">
<!-- 									<button type="button" class="glyphicon glyphicon-search" id=""></button> -->
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-2"></div>
								<div class="col-sm-1">
									<button class="btn rnr-btn-primary" id="">Search</button>
								</div>
								<div class="col-sm-1">
									<button class="btn rnr-btn-primary" id="" type="reset">Clear</button>
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
