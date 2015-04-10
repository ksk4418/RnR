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
															<td><b>Operational Excellence:</b>
																<ul>
																	<li>a) Demonstration of excellent performance over 
																		the past quarter, taking into account any 
																		significant challenges to overcome etc.</li>
																	<li>b) Commendable instances of teamwork, problem 
																		solving and continuous improvement</li>
																	<li>c) Quality of deliverables</li>
																	<li>d) Cost effectiveness</li>
																	<li>e) Retention of team through project life cycle -
																	 Attrition metrics to be provided</li>
																	<li>f) Timely delivery of services</li>
																	<li>g) No.  of best practices </li>
																	<li>h) Percentage of Junior Members in the team 
																	( < 2 yrs)</li>
																	<li>i) Actual Vs Budget</li>
																</ul></td>
															<td><textarea rows="7" cols="50"
																	name="nomText1Line1" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line1}</textarea></td>
															<td>35%</td>
														</tr>
														<tr role="row">
															<td>2</td>
															<td><b>Client Intimacy:</b>
																<ul>
																	<li>a) Demonstration of commendable client service </li>
																	<li>b) Citable instances and tangible measures of 
																	customer satisfaction such as  Customer 
																	Satisfaction Scores etc.</li>

																</ul></td>
															<td><textarea rows="6" cols="50"
																	name="nomText1Line2" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line2}</textarea></td>
															<td>35%</td>
														</tr>
														<tr role="row">
															<td>3</td>
															<td><b>Impact</b></td>
															<ul>
																<li>a) Tangible and measurable impact, outcomes 
																	within the team / engagement</li>
															</ul>
															<td><textarea rows="3" cols="50"
																	name="nomText1Line3" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line3}</textarea></td>
															<td>30%</td>
														</tr>
													</tbody>
												</table>

											</div>
										</div>
									</div>
								</div>