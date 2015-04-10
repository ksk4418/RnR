<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-parent="#accordion" href="collapseTwo">Member Information</a>
			<span class="cgi-rnr-arrow-down" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"></span>
		</h4>
	</div>
	<div id="collapseTwo" class="panel-collapse in">
		<div class="panel-body">
			<div class="cgi-rnr-infoPanel awardPanel row">
				<table class="table cgi-rnr-awardTable" border="1">
					<tbody>
						<tr>
							<td class="width20">Name</td>
							<td>${member.employeeName}<input type="text" value="${member.employeeName}" name="emplName" hidden="true"/></td>
							<td class="width20">Project / Engagement</td>
							<td>${member.projectDescription}<input type="text" value="${member.projectDescription}" name="projectDesc" hidden="true"/></td>
						</tr>
						<tr>
							<td class="width20">PSA ID</td>
							<td>${member.employeeId}<input hidden="true" type="text" value="${member.employeeId}" name="emplId"/></td>
							<td class="width20">Reporting Manager</td>
							<td>${member.reportingManager}<input hidden="true" type="text" value="${member.reportingManager}" /></td>
						</tr>
						<tr>
							<td class="width20">Date of Joining</td>
							<td>${member.employeeId}<input type="text" hidden="true" value="${member.dateOfJoining}" /></td>
							<td class="width20">Group Head</td>
							<td>${member.groupHeadName}<input hidden="true" type="text" value="${member.groupHeadName}" /></td>
						</tr>
						<tr>
							<td class="width20">Designation</td>
							<td>${member.designation}<input hidden="true" type="text" value="${member.designation}" /></td>
							<td class="width20">Year</td>
							<td><%=session.getAttribute("FY") %><input hidden="true" type="text" value="<%=session.getAttribute("FY") %>" name="FY"/></td>
						</tr>
						<tr>
							<td class="width20">Location</td>
							<td>${member.location}<input hidden="true" type="text" value="${member.location}" /></td>
							<td class="width20">Period</td>
							<td>QTR - <%=session.getAttribute("QTR") %><input hidden="true" type="text" value="<%=session.getAttribute("QTR") %>" name="QTR"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>