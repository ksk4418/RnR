<%@page import="cgi.rnr.common.Constants"%>
<%@page import="com.cgi.member.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<!-- Head tag -->
	<jsp:include page="../commonPages/head.jsp"></jsp:include>
<!-- End of Head tag -->
<script>
function showMessage(){
	<% if(request.getParameter("nom")!=null && request.getParameter("nom").toString().equalsIgnoreCase("1")){ %>
		alert("Nomination submitted successfully.");
	<%}
	else if(request.getParameter("nom")!=null && request.getParameter("nom").toString().equalsIgnoreCase("2")) {%>
		alert("An error occured while processing your request. Please try again.");	
	<%}%>
}
</script>
<body <%= request.getParameter("nom")!=null?"onLoad=\"showMessage()\"":""%>>
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
			<div class="container cgi-rnr-customContainer">
				<div class="row alert alert-info cgi-rnr-info-box">
					<a href="#" class="close" data-dismiss="alert">&times;</a>
					<p>
<%-- 						<a href="#">${nomMessage }</a> --%>
							${nomMessage }
					</p>
				</div>
				<div class="row">
					<!--cmemberGenInfoWrapper-->
					<div class="col-md-4 col-xs-4 cgi-rnr-memberGenInfoWrapper">
						<div class="cg-rnr-memberInfo clearfix">
							<img src=<c:url value ="/resources/assets/images/cgi-rnr-avtar.jpg" /> alt="avtar"
								title="avtar" />
							<div class="cg-rnr-memberInfoDesc">
								<span><strong><%=session.getAttribute("memberDetails1")!=null?((Member) session.getAttribute("memberDetails1")).getEmployeeName():"Not Found" %></strong></span> <span><small>
										<%=session.getAttribute("memberDetails1")!=null?((Member) session.getAttribute("memberDetails1")).getDesignation():"Not Found" %></small></span>
							</div>
						</div>
						<div class="cg-rnr-memberGenInfo clearfix">
							<div class="cgi-rnr-memberGenInfoTitle">
								<ul>
									<li>Date Of Joining:</li>
									<li>Project:</li>
									<li>Location:</li>
									<li><p align="right"><b></b></p></li>
								</ul>
							</div>
							<div class="cgi-rnr-memberGenInfoText">
								<ul>
									<li><%=session.getAttribute("memberDetails1")!=null?((Member) session.getAttribute("memberDetails1")).getDateOfJoining():"Not Found" %></li>
									<li><%=session.getAttribute("memberDetails1")!=null?((Member) session.getAttribute("memberDetails1")).getProjectDescription():"Not Found" %></li>
									<li><%=session.getAttribute("memberDetails1")!=null?((Member) session.getAttribute("memberDetails1")).getLocation():"Not Found" %></li>
									<li><p align="left"><b>Nomination Details</b></p></li>
								</ul>
							</div>
							<div class="cgi-rnr-memberGenInfoTitle">
								<ul>
									<li>Being Nominated:</li>
									<li>Awarded:</li>
									<li>Nominations submitted:</li>
									<li>Approved:</li>
								</ul>
							</div>
							<div class="cgi-rnr-memberGenInfoText">
								<ul>
									<li>${ totalGotNominated }</li>
									<li>${totalAwarded }</li>
									<li>${totalNominated }</li>
									<li>${totalNominationsAwarded }</li>
								</ul>
							</div>
						</div>
					</div>
					<!--End cmemberGenInfoWrapper-->
					<!--cgi-rnr-memberRigthWrapper-->
					<div class="col-md-8 col-xs-8 cgi-rnr-memberRigthWrapper">
						<!--accordion-->
						<div class="cgi-rnr-panel panel-group">
							<!--cri-rnr-NominationStatus-->
							
							<div class="panel panel-default cgi-rnr-NominationStatus">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Nominations submitted</a>
									</h4>
								</div>
								<div class="panel-collapse cgi-rnr-scrollbar">
									<div class="panel-body">
										<c:if test="${not empty nominated}">
											<c:forEach var="listValue" items="${nominated}">
												<div class="cgi-rnr-infoPanel">
													<div class="cgi-rnr-userDashboarDesc">
														<c:if test="${not empty listValue[8] }">
															<div><I>${listValue[8]}</I> has been nominated for <I>${listValue[7]}</i> Award</div>
															<table>
															<tr>
															<td width="100%">
															<div style="font-size: 1.2em">For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div></td>
															<td align="right"><c:if test="${not empty listValue[11] }">
																<c:if test="${listValue[4] eq 1 }">
																	<div align="right"><a href="updateNomination.cgi?iid=${listValue[0]}">View/Update</a></div>
																</c:if>
																<c:if test="${listValue[4] gt 1 }">
																	<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
																</c:if>
															</c:if></td>
															</tr>
															</table>
														</c:if>
														<c:if test="${empty listValue[8] }">
															<div><i>${listValue[9]}</i> has been nominated for <i>${listValue[7]}</i> Award</div>
															<div>For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div>
															<c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if>
														</c:if>
													</div>
												</div>
											</c:forEach>
											<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
										</c:if>
									</div>
								</div>
							</div>
							<c:if test="${not empty nominationsReceivied}">
							<div class="panel panel-default cgi-rnr-NominationStatus">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Nominations Received</a>
									</h4>
								</div>
								<div class="panel-collapse cgi-rnr-scrollbar">
									<div class="panel-body">
										
											<c:forEach var="listValue" items="${nominationsReceivied}">
												<div class="cgi-rnr-infoPanel">
													<div class="cgi-rnr-userDashboarDesc">
														<c:if test="${not empty listValue[8] }">
															<div><I>${listValue[8]}</I> has been nominated for <I>${listValue[7]}</i> Award</div>
															<table>
															<tr>
															<td width="100%">
															<div style="font-size: 1.2em">For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div></td>
															<td align="right"><c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if></td>
															</tr>
															</table>
														</c:if>
														<c:if test="${empty listValue[8] }">
															<div><i>${listValue[9]}</i> has been nominated for <i>${listValue[7]}</i> Award</div>
															<div>For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div>
															<c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if>
														</c:if>
													</div>
												</div>
											</c:forEach>
											<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
									</div>
								</div>
							</div>
							</c:if>
							<%if(session.getAttribute("memberLevel") != null && (Integer) session.getAttribute("memberLevel") > 1){ %>
							<c:if test="${not empty nominationToMembers}">
							<div class="panel panel-default cgi-rnr-NominationStatus">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Nominations for all your reportees</a>
									</h4>
								</div>
								<div class="panel-collapse cgi-rnr-scrollbar">
									<div class="panel-body">
											<c:forEach var="listValue" items="${nominationToMembers}">
												<div class="cgi-rnr-infoPanel">
													<div class="cgi-rnr-userDashboarDesc">
														<c:if test="${not empty listValue[8] }">
															<div><I>${listValue[8]}</I> has been nominated for <I>${listValue[7]}</i> Award</div>
															<table>
															<tr>
															<td width="100%">
															<div style="font-size: 1.2em">For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div></td>
															<td align="right"><c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if></td>
															</tr>
															</table>
														</c:if>
														<c:if test="${empty listValue[8] }">
															<div><i>${listValue[9]}</i> has been nominated for <i>${listValue[7]}</i> Award</div>
															<div>For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div>
															<c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if>
															<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
														</c:if>
													</div>
												</div>
											</c:forEach>
											<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
									</div>
								</div>
							</div>
							</c:if>
							<%} %>
							<c:if test="${not empty nominationToMembersPublished}">
							<div class="panel panel-default cgi-rnr-NominationStatus">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Nominations Published Self & Members</a>
									</h4>
								</div>
								<div class="panel-collapse cgi-rnr-scrollbar">
									<div class="panel-body">
											<c:forEach var="listValue" items="${nominationToMembersPublished}">
												<div class="cgi-rnr-infoPanel">
													<div class="cgi-rnr-userDashboarDesc">
														<c:if test="${not empty listValue[8] }">
															<div><I>${listValue[8]}</I> has been nominated for <I>${listValue[7]}</i> Award</div>
															<table>
															<tr>
															<td width="100%">
															<div style="font-size: 1.2em">For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div></td>
															<td align="right"><c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if></td>
															</tr>
															</table>
														</c:if>
														<c:if test="${empty listValue[8] }">
															<div><i>${listValue[9]}</i> has been nominated for <i>${listValue[7]}</i> Award</div>
															<div>For fiscal year: ${listValue[3]} Quarter: QTR-${listValue[2]} </div>
															<c:if test="${not empty listValue[11] }">
																<div align="right"><a href="viewNomination.cgi?iid=${listValue[0]}">View</a></div>
															</c:if>
															<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
														</c:if>
													</div>
												</div>
											</c:forEach>
											<table><tr><td width="100%">&nbsp;</td><td align="right"><a href="#"><b>More...&nbsp;&nbsp;</b></a></td></tr></table>
									</div>
								</div>
							</div>
							</c:if>
							<!--End cri-rnr-NominationStatus-->
						</div>
						<!--End accordion-->
					</div>
					<!-- End cgi-rnr-memberRigthWrapper-->
				</div>
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