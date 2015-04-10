<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

								<div class="panel panel-default ">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="collapseThree">Criteria To Qualify</a> <span
												class="cgi-rnr-arrow-down" data-toggle="collapse"
												data-parent="#accordion" href="#collapseThree"></span>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse in">
										<div class="panel-body">
											<div class="cgi-rnr-criteriaPanel row">
												<table class="cgi-rnr-achievementTable">
													<thead>
														<tr role="row">
															<th>SN</th>
															<th>Achievement</th>
															<th>Weightage(If applicable)</th>
														</tr>
													</thead>
													<tbody>
														<tr role="row">
															<td>1</td>
															<td><textarea rows="7" cols="125"
																	name="nomText1Line1" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line1}</textarea></td>
															<td>100%</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>