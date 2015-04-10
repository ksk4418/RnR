<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<!-- Head tag -->
	<jsp:include page="../commonPages/head.jsp"></jsp:include>
<!-- End of Head tag -->
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
			<jsp:include page="../commonPages/header.jsp"></jsp:include>
		<!--End Header-->
		<!-- Golbal navigation -->
		<jsp:include page="../commonPages/navigationMenu.jsp"></jsp:include>
		<!--End Golbal navigation -->

		<!-- Main Content-->
		<section class="cgi-rnr-main-content">
			<div class="container">
				
				<!-- CGI-Carousel-->
				<div id="myCarousel1" class="carousel slide rnr-carousel" data-ride="carousel">
					
					<!-- Wrapper for slides -->
					<div class="carousel-inner rnr-carousel-inner" role="listbox">
						<div class="item active">
						  <img src="resources/placeholders/gallery/cgi_homepage_bn_ar2014_en_0_0.jpg" alt="cgi_image1">
						</div>

						<div class="item">
						  <img src="resources/placeholders/gallery/cgi_homepage_bn_big_data_en.jpg" alt="cgi_image1">
						</div>

						<div class="item">
						  <img src="resources/placeholders/gallery/cgi_homepage_bn_cybersecurity_en.jpg" alt="cgi_image1">
						</div>

						<div class="item">
						  <img src="resources/placeholders/gallery/cgi_homepage_bn_join_cgi_en.jpg" alt="cgi_image1">
						</div>
					</div>
					  
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel1" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel1" data-slide-to="1"></li>
						<li data-target="#myCarousel1" data-slide-to="2"></li>
						<li data-target="#myCarousel1" data-slide-to="3"></li>
					</ol>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel1" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel1" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
				<!--End CGI-Carousel-->
					
				<!-- myCarousel-->
					<div id="myCarousel" class="carousel slide"> 
					  	<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div id="cgi-rnr-divcaption">
								<span class="cgi-rnr-1">1</span> 
								<span class="cgi-rnr-rev">
								<ul>
									<li><a href="#">Review Nomination</a></li>
									<li><a href="#">Vote</a></li>
								</ul>
								</span>
								<img src="resources/placeholders/gallery/carousel_1.png" alt="image1"/>
							</div>
						</div>

						<div class="item">
							<div id="cgi-rnr-divcaption">
								<span class="cgi-rnr-1">2</span> 
								<span class="cgi-rnr-rev">
								<ul>
									<li><a href="#">Review Nomination</a></li>
									<li><a href="#">Vote</a></li>
								</ul>
								</span>
								<img src="resources/placeholders/gallery/carousel_1.png" alt="image2"/>
							</div>
						</div>

						<div class="item">
							<div id="cgi-rnr-divcaption">
								<span class="cgi-rnr-1">3</span> 
								<span class="cgi-rnr-rev">
								<ul>
									<li><a href="#">Review Nomination</a></li>
									<li><a href="#">Vote</a></li>
								</ul>
								</span>
								<img src="resources/placeholders/gallery/carousel_1.png" alt="image2"/>
							</div>
						</div>
						</div>
						<!-- Indicators -->
						<div>
						<ol class="carousel-indicators cgi-rnr-carousel-indicators">
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
		<jsp:include page="../commonPages/footer.jsp"></jsp:include>
		<!-- End Footer-->
	</div>
	<!--Endwrapper-->

	<!-- jQuery -->
	<jsp:include page="../commonPages/jQuery.jsp"></jsp:include>

</body>
</html>