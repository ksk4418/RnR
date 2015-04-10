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
							<a href="index.cgi" title="homeScreen"><img
								src=<c:url value ="/resources/assets/images/cgi-rnr-logo.png" />
								alt="Logo"> </a>
							<%} %>
						</div>
						<div class="cgi-rnr-siteName">Rewards & Recognition Portal</div>
					</div>
					<!-- Welcome and login/logout -->
					<div class="user-info">
						<ul>
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
																		<button type="submit" class="btn btn-default">Login</button>
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