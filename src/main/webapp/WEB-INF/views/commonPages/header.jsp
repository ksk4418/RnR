<%@page import="cgi.rnr.util.Utils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="cgi-rnr-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="cgi-rnr-globalBar">
					<!-- Logo and page headeing -->
					<div class="portal-name">
						<div class="cgi-rnr-logo">
							<%if(session.getAttribute("memberId") != null){ %>
							<a href="homeDashBoard.cgi" title="homeScreen"><img
								src=<c:url value ="/resources/assets/images/cgi-rnr-logo.png" />
								alt="Logo"> </a>
							<%} else { %>
							<a href="home.cgi" title="homeScreen"><img
								src=<c:url value ="/resources/assets/images/cgi-rnr-logo.png" />
								alt="Logo"> </a>
							<%} %>
						</div>
						<div class="cgi-rnr-siteName">Rewards & Recognition Portal</div>
					</div>
					<!-- Welcome and login/logout -->
					<div class="user-info">
						<ul>
							<li><img src=<c:url value ="/resources/assets/images/cgi-rnr-userIcon.png" /> alt="usericon" title="usericon" width="25" height="28" /><span>Welcome <span class="cgi-rnr-username"><%=session.getAttribute("memberName")==null?"Guest":session.getAttribute("memberName") %></span></span></li>
							<%if(session.getAttribute("memberDetails1")==null){ %>
							<li><img src=<c:url value ="/resources/assets/images/cgi-rnr-loginIcon.png" /> alt="Login" title="Login" width="16" height="16"/><a href="loginPage.cgi" class="cgi-rnr-loginBtn" data-toggle="modal" data-target=".cgi-rnr-loginPanel">Login</a></li>
							<li><%=request.getParameter("ctry")==null?"Generic":Utils.getCountry(request.getParameter("ctry")) %></li>
							<%} else { %>
							<li><img src=<c:url value ="/resources/assets/images/cgi-rnr-loginIcon.png" /> alt="logout" title="Logout" width="16" height="16"/><a href="logout.cgi" >Logout</a></li>
							<%} %>
							
						</ul>
															<!--login form--><div class="cgi-rnr-logiBlockn">
										<div class="modal fade cgi-rnr-loginPanel" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
											  <div class="modal-dialog modal-sm">
												<div class="modal-content">
												  
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h4 class="modal-title">Login</h4>
														</div>

														
														<div class="modal-body">
															<!-- The form is placed inside the body of modal -->
															<form id="cgi-rnr-loginForm" method="post" action="login.cgi" class="form-horizontal fv-form fv-form-bootstrap" validate="validate">
																<div class="form-group has-feedback">
																	<label class="col-xs-3 control-label">User name</label>
																	<div class="col-xs-8">
																	<input type="text" required class="form-control" id="emailField" placeholder="Enter username" name="userName">
																	</div>
																</div>

																<div class="form-group has-feedback">
																	<label class="col-xs-3 control-label">Password</label>
																	<div class="col-xs-8">
																	<input type="password" required class="form-control" id="emailField" placeholder="Enter Password" name="password">
																	</div>	
																</div>

																<div class="form-group">
																	<div class="col-xs-8 col-xs-offset-3">
																		<button type="submit" class="btn btn-default rnr-btn-primary">Login</button>
																	</div>
																</div>
															
															</form>
														</div>
												</div>
											  </div>
										</div>
									</div>  <!--End login form-->
					</div>
				</div>
			</div>
		</div>
	</div>
</header>