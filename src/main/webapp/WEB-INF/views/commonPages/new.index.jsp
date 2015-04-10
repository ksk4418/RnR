<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<!-- Head tag -->
	<jsp:include page="head.jsp"></jsp:include>
<!-- End of Head tag -->
<jsp:include page="jQuery.jsp"></jsp:include>
<script>
function showError(){
	<% if(request.getParameter("error")!=null && request.getParameter("error").toString().equalsIgnoreCase("login")){ %>
		alert("Invalid username and password combination. Try again.");
	<%}
	else if(request.getParameter("error")!=null && request.getParameter("error").toString().equalsIgnoreCase("login1")) {%>
		alert("An error occured while processing your request. Please try again.");	
	<%}%>
}
</script>
<body <%= request.getParameter("error")!=null?"onLoad=\"showError()\"":""%>>
	<!--wrapper-->
	<div id="wrapper">
		<!-- Header-->
			<jsp:include page="header.jsp"></jsp:include>
		<!--End Header-->
		<!-- Golbal navigation -->
		<jsp:include page="navigationMenu.jsp"></jsp:include>
		<!--End Golbal navigation -->

		<!-- Main Content-->
		<section class="cgi-rnr-main-content">
			<div class="container">
				<jsp:include page="../home/CGIHomePage.jsp"></jsp:include>
				<!-- myCarousel-->
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src=<c:url value ="/resources/placeholders/gallery/carousel_1.png" /> alt="image1" />
						</div>

						<div class="item">
							<img src=<c:url value ="/resources/placeholders/gallery/carousel_2.png" /> alt="image2" />
							</div>

						<div class="item">
							<img src=<c:url value ="/resources/placeholders/gallery/carousel_3.png" /> alt="image3" />
						</div>
					</div>
					<!-- Indicators -->
					<div>
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"><div class="circle">1</div></li>
							<li id="image2" data-target="#myCarousel" data-slide-to="1"><div class="circle">2</div></li>
							<li data-target="#myCarousel" data-slide-to="2"><div class="circle">3</div></li>
						</ol>
					</div>
				</div>
				<!--End myCarousel-->
			</div>
		</section>
		<!-- Main Content-->

		<!-- Footer -->
		<jsp:include page="footer.jsp"></jsp:include>
		<!-- End Footer-->
	</div>
	<!--Endwrapper-->

	<!-- jQuery -->


</body>
</html>