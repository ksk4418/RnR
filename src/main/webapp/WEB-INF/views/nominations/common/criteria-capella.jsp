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
															<td><b>Productivity and Work Efficiency:</b>
																<ul>
																	<li>Contribution to project / engagement/ 
																		organization in terms of billability or 
																		process improvement</li>
																	<li>Cost consciousness and high quality 
																		of deliverables </li>
																	<li>Commitment to CGI quality process and knowledge sharing</li>
																	<li>Technical / functional proficiency that has 
																		positively impacted the engagement /department 
																		and thereby merits recognition</li>
																</ul></td>
															<td><textarea rows="7" cols="50"
																	name="nomText1Line1" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line1}</textarea></td>
															<td>30%</td>
														</tr>
														<tr role="row">
															<td>2</td>
															<td><b>Business Development Endeavours:</b>
																<ul>
																	<li>Commendable efforts of member in business 
																		development initiatives resulting in 
																		engagement / organization benefits   </li>
																</ul></td>
															<td><textarea rows="6" cols="50"
																	name="nomText1Line2" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line2}</textarea></td>
															<td>25%</td>
														</tr>
														<tr role="row">
															<td>3</td>
															<td><b>Client Relationship Management:</b>
															<ul>
																	<li>Interaction and association with clients 
																		that has resulted in high levels of 
																		customer satisfaction, improved relations 
																		and brand image</li>
																	<li>Engagement growth in terms of team size / 
																		billability due to good customer relations</li>
																</ul></td>
															<td><textarea rows="3" cols="50"
																	name="nomText1Line3" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line3}</textarea></td>
															<td>25%</td>
														</tr>
														<tr role="row">
															<td>4</td>
															<td><b>Commitment to Organisation:</b>
															<ul>
															<li>Initiatives resulting in overall organization benefits</li>
															<li>Personifies and promotes the image of the organization</li>
															<li>Participation in Organizationwide initiatives</li>
															</ul></td>
															<td><textarea rows="3" cols="50"
																	name="nomText1Line4" required="required" <%if(request.getParameter("id") != null || request.getParameter("iid") != null){ %> readonly="readonly" <%} %>>${nomText1Line4}</textarea></td>
															<td>20%</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>