<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			<nav class="cgi-rnr-golbalNav">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<ul>
								<%if(session.getAttribute("memberId") == null){ %>
									<li><a href="home.cgi">Home</a></li>
								<%} else { %>
									<li><a href="homeDashBoard.cgi">Home</a></li>
								<%
									if(session.getAttribute("Menus") != null){
									HashMap menus = (HashMap) session.getAttribute("Menus");
									Set<String> s = menus.keySet();
									for(String key: s){
									%>
										<li class="has-sub-menu">
										<a href="javascript:void(0)" class="inner-menu"><%=key %><img src=<c:url value ="/resources/assets/images/drop-down.png" /> alt=<%=key %> title=<%=key %> width="5" height="4" /></a>
										<ul class="sub-menu">
											<% 	Set<String> ss = ((HashMap)menus.get(key)).keySet();
												for(String keys: ss){
													%>
										<li><a href="<%=keys %>.cgi" class="inner-menu-link"><%=((HashMap)menus.get(key)).get(keys) %></a></li>
											<%
												}
											%>
										</ul>
										</li>	
								<%								
									}
								}
								%>
								
<!-- 								<li class="has-sub-menu"> -->
<!-- 									<a href="javascript:void(0)" class="inner-menu">Awards Configuration<img src=<c:url value ="/resources/assets/images/drop-down.png" /> alt="User Profile Menu" title="User Profile Menu" width="5" height="4" /></a> -->
<!-- 									<ul class="sub-menu"> -->
<!-- 										<li><a href="frequency.cgi" class="inner-menu-link">Frequency</a></li> -->
<!-- 										<li><a href="awardConfig.cgi" class="inner-menu-link">Awards</a></li> -->
<!-- 										<li><a href="awardGroup.cgi" class="inner-menu-link">Award Group</a></li> -->
<!-- 										<li><a href="awardGroupExt.cgi" class="inner-menu-link">Award Group Extended</a></li> -->
<!-- 										<li><a href="awardEligConfig.cgi" class="inner-menu-link">Awards Eligibility</a></li> -->
<!-- 										<li><a href="awardCriteria.cgi" class="inner-menu-link">Award Criteria</a></li> -->
<!-- 									</ul> -->
<!-- 								</li> -->
<!-- 								<li class="has-sub-menu"> -->
<!-- 									<a href="javascript:void(0)" class="inner-menu">Nominations<img src=<c:url value ="/resources/assets/images/drop-down.png" /> alt="User Profile Menu" title="User Profile Menu" width="5" height="4" /></a> -->
<!-- 									<ul class="sub-menu"> -->
<!-- 										<li><a href="nominationPhaseConfig.cgi" class="inner-menu-link">Nomination Phase</a></li> -->
<!-- 										<li><a href="fYConfig.cgi" class="inner-menu-link">Fiscal Year</a></li> -->
<!-- 										<li><a href="quarterConfig.cgi" class="inner-menu-link">Quarter</a></li> -->
<!-- 										<li><a href="nominations.cgi" class="inner-menu-link">Nominations</a></li> -->
<!-- 									</ul> -->
<!-- 								</li> -->
								<c:if test="${not empty nominationTypes}">
									<li class="has-sub-menu">
										<a href="javascript:void(0)" class="inner-menu">Nominate<img src=<c:url value ="/resources/assets/images/drop-down.png" /> alt="User Profile Menu" title="User Profile Menu" width="5" height="4" /></a>
										<ul class="sub-menu">
											<c:forEach var="listValue" items="${nominationTypes}">
												<li><a href="${listValue}.cgi" class="inner-menu-link">${listValue} Award</a></li>
											</c:forEach>
										</ul>
									</li>
								</c:if>
<!-- 									<li><a href="nominatationWizard.cgi">Nomination</a></li> -->
<!-- 									<li><a href="searchAwards.cgi">Search Awards</a></li> -->
<!-- 									<li><a href="test.cgi">test</a></li> -->
<!-- 									<li><a href="cityConfig.cgi">City</a></li> -->
<!-- 									<li><a href="workFlowConfig.cgi">WorkFlow</a></li> -->
<!-- 									<li><a href="workFlowCriteriaConfig.cgi">Flow Criteria</a></li> -->
<!-- 									<li><a href="workFlowLevelsConfig.cgi">Flow Levels</a></li> -->
<!-- 									<li><a href="memberConfig.cgi">Member</a></li> -->
<!-- 									<li><a href="memberEXTConfig.cgi">Member_EXT</a></li> -->
<!-- 									<li><a href="panelConfig.cgi">Panel</a></li> -->
<!-- 									<li><a href="panelMembersConfig.cgi">Panel Members</a></li> -->
<!-- <li><a href="rolesConfig.cgi">Role</a></li> -->
<!-- <li><a href="pagesConfig.cgi">Pages</a></li> -->
<!-- <li><a href="accessConfig.cgi">Page Access</a></li> -->
<!-- <li><a href="workFlowConfig.cgi">Workflow</a></li> -->
<!-- <li><a href="workFlowLevelsConfig.cgi">Workflow Levels</a></li> -->
<!-- <li><a href="panelConfig.cgi">Panel</a></li> -->
<!-- <li><a href="panelMembersConfig.cgi">PMembers</a></li> -->
<!-- <li><a href="pageCategConfig.cgi">PCateg</a></li> -->
<!-- <li><a href="memberRoleConfig.cgi">Member Role</a></li> -->
<%-- 								<%} %> --%>
								<%if(session.getAttribute("panelMember") != null){ %>
									<li><a href="searchAwardsPanel.cgi">Panel page</a></li>
								<%}} %>
							</ul>
						</div>
					</div>
				</div>
			</nav>