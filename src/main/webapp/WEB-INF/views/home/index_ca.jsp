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
				<!--Gallery-->
				<div class="row cgi-rnr-gallery">
					<div class="col-xs-3 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/dummy1.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>

							</a>
						</div>
					</div>
					<div class="col-xs-4">
						<div class="col-xs-12 cgi-rnr-gallery-thumbnail">
							<img src=<c:url value ="/resources/placeholders/gallery/dummy2.jpg" /> alt=""> 
							<span class="cgi-rnr-gallery-overlay"></span>
							<div class="cgi-rnr-gallery-hover-content">
								<a href="http://google.co.in" target="_blank"> 
								<span>Text here</span>
								</a>
							</div>
						</div>
						<div class="col-xs-6 cgi-rnr-gallery-thumbnail">
							<img src=<c:url value ="/resources/placeholders/gallery/soins-sp_cifiques-xs.jpg" /> alt=""> 
							<span class="cgi-rnr-gallery-overlay"></span>
							<div class="cgi-rnr-gallery-hover-content">
								<a href="http://google.co.in" target="_blank"> 
								<span>Text here</span>
								</a>
							</div>
						</div>
						<div class="col-xs-6 cgi-rnr-gallery-thumbnail">
							<img src=<c:url value ="/resources/placeholders/gallery/Picture-12.png" /> alt=""> 
							<span class="cgi-rnr-gallery-overlay"></span>
							<div class="cgi-rnr-gallery-hover-content">
								<a href="http://google.co.in" target="_blank"> 
									<span>Text here</span>
								</a>
							</div>
						</div>
					</div>
					<div class="col-xs-3 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/dummy4.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
					<div class="col-xs-2 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/Meade--Sarah162.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
				</div>
				<div class="row cgi-rnr-gallery">
					<div class="col-xs-5 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/glasses_by_iagoblack-d5axeol.png" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
					<div class="col-xs-2 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/dummy3.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
					<div class="col-xs-2 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/timthumb1.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
					<div class="col-xs-3 cgi-rnr-gallery-thumbnail">
						<img src=<c:url value ="/resources/placeholders/gallery/voldemort.jpg" /> alt=""> 
						<span class="cgi-rnr-gallery-overlay"></span>
						<div class="cgi-rnr-gallery-hover-content">
							<a href="http://google.co.in" target="_blank"> 
							<span>Text here</span>
							</a>
						</div>
					</div>
				</div>
				<!-- End gallery -->
<hr />
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
		<jsp:include page="../commonPages/footer.jsp"></jsp:include>
		<!-- End Footer-->
	</div>
	<!--Endwrapper-->

	<!-- jQuery -->
	<jsp:include page="../commonPages/jQuery.jsp"></jsp:include>

</body>
</html>