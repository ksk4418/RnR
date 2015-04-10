<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

								<div class="panel panel-default ">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="collapseThree">Criteria To Qualify</a> <span
												class="cgi-rnr-arrow-down" data-toggle="collapse"
												data-parent="#accordion" href="collapseThree"></span>
										</h4>
									</div>
									<div id="collapseThree" class="panel-collapse in">
										<div class="panel-body">
											<div class="cgi-rnr-criteriaPanel row">
												<table class="cgi-rnr-achievementTable">
													<thead>
														<tr role="row">
															<th>SN</th>
															<th>Criteria</th>
															<th>Achievement</th>
															<th>Weightage(If applicable)</th>
														</tr>
													</thead>
													<tbody>
														<tr role="row">
															<td>1</td>
															<td><b>Project / Functional Deliverables:</b>
																<ul>
																	<li>Citable Instances pertaining to on time
																		deliveries / adherence to strict deadlines</li>
																	<li>Tangible impact on billings (revenue
																		enhancement / generation)</li>
																	<li>Initiatives and Consistency</li>
																	<li>Benefit to customer / Project</li>
																</ul></td>
															<td><textarea rows="7" cols="50"
																	name="nomText1Line1" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line1}</textarea></td>
															<td>30%</td>
														</tr>
														<tr role="row">
															<td>2</td>
															<td><b>Technical / Functional Expertise:</b>
																<ul>
																	<li>Expertise to be validated with citable
																		instances</li>
																	<li>Niche skill expertise</li>
																	<li>Impact on Engagement / Department deliverables</li>
																	<li>Learning ability & Process adherence</li>
																</ul></td>
															<td><textarea rows="6" cols="50"
																	name="nomText1Line2" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line2}</textarea></td>
															<td>30%</td>
														</tr>
														<tr role="row">
															<td>3</td>
															<td><b>Client Satisfaction:</b></td>
															<td><textarea rows="3" cols="50"
																	name="nomText1Line3" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>> ${nomText1Line3} </textarea></td>
															<td>30%</td>
														</tr>
														<tr role="row">
															<td>4</td>
															<td><b>Other Noteworthy Achievements:</b></td>
															<td><textarea rows="3" cols="50"
																	name="nomText1Line4" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line4}</textarea></td>
															<td>10%</td>
														</tr>
													</tbody>
												</table>

											</div>
										</div>
									</div>
								</div>