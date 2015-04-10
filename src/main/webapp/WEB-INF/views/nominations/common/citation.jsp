<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="collapseFour">CITATION</a> <span
												class="cgi-rnr-arrow-down" data-toggle="collapse"
												data-parent="#accordion" href="collapseFour"></span>
										</h4>
									</div>
									<div id="collapseFour" class="panel-collapse in">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12 col-xs-12">
													<textarea rows="3" cols="50" name="citation" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${citation}</textarea>
												</div>

											</div>

										</div>
									</div>
								</div>