<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<HTML>
<link href=<c:url value ="/resources/assets/Content/Examples8d63.css"/>  rel="stylesheet" />
<jsp:include page="../../commonPages/head.jsp"></jsp:include>
<head>
<meta charset="utf-8">
<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
<script src=<c:url value ="/resources/assets/js/jquery-1.11.2.js" />></script>
<script src=<c:url value ="/resources/assets/Scripts/Examples46f4" />></script>
<link rel="stylesheet" href=<c:url value ="/resources/assets/js/jquery-ui.css" />>
<script src=<c:url value ="/resources/assets/js/jquery-ui.js" />></script>
<link href=<c:url value ="/resources/assets/css/cgi-rnr-style.css" />
	rel="stylesheet">
<script lang="text/javascript">
   $( document ).ready(function(e)
   {
       $(this).remove();
       $("#grid-keep-selection").bootgrid({
           ajax: true,
           post: function ()
           {
               return {
                   id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
               };
           },
           url: "getAwardCriteria",
           selection: true,
           multiSelect: false,
           rowSelect: true,
           keepSelection: true,
           columnSelection: false,
       }).on("selected.rs.jquery.bootgrid", function(e, rows)
       {
           document.getElementById("edit").disabled = false;
           document.getElementById("delete").disabled = false;
           document.getElementById("edit").className = document.getElementById("edit").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           document.getElementById("delete").className = document.getElementById("delete").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           
           document.getElementById("ide").value = rows[0].id
           document.getElementById("idd").value = rows[0].id
           document.getElementById("criteriaNamee").value = rows[0].criteriaName
           document.getElementById("criteriaNamed").value = rows[0].criteriaName
           document.getElementById("criteriaDesce").value = rows[0].awardCriteriaDesc
           document.getElementById("criteriaDescd").value = rows[0].awardCriteriaDesc
           
           document.getElementById("quotaPercentaged").value = rows[0].quotaPercentage
           document.getElementById("quotaPercentagee").value = rows[0].quotaPercentage
           document.getElementById("quotaQuantityd").value = rows[0].quotaQuantity
           document.getElementById("quotaQuantitye").value = rows[0].quotaQuantity
           document.getElementById("quotaAlinedToRoled").value = rows[0].quotaAlinedToRole
           document.getElementById("quotaAlinedToRolee").value = rows[0].quotaAlinedToRole
           
           if(rows[0].activeFl == 'Y') {
	           document.getElementById("activeFle").checked = 1
	           document.getElementById("activeFld").checked = 1
       		} else { 
       			document.getElementById("activeFle").checked = 0
 	           document.getElementById("activeFld").checked = 0
       		}
           document.getElementById("awardIdd").value = rows[0].awardId
           document.getElementById("awardIde").value = rows[0].awardId
           
           document.getElementById("verticalIdd").value = rows[0].verticalId
           document.getElementById("verticalIde").value = rows[0].verticalId
           document.getElementById("projectIdd").value = rows[0].projectId
           document.getElementById("projectIde").value = rows[0].projectId
           
           document.getElementById("companyIdd").value = rows[0].companyId
           document.getElementById("companyIde").value = rows[0].companyId
           document.getElementById("continentIdd").value = rows[0].continentId
           document.getElementById("continentIde").value = rows[0].continentId
           document.getElementById("countryIdd").value = rows[0].countryId
           document.getElementById("countryIde").value = rows[0].countryId
           
           document.getElementById("stateIdd").value = rows[0].stateId
           document.getElementById("stateIde").value = rows[0].stateId
           document.getElementById("locationIdd").value = rows[0].locationId
           document.getElementById("locationIde").value = rows[0].locationId
           document.getElementById("cityIdd").value = rows[0].cityId
           document.getElementById("cityIde").value = rows[0].cityId
           document.getElementById("subCityIdd").value = rows[0].subCityId
           document.getElementById("subCityIde").value = rows[0].subCityId

       }).on("deselected.rs.jquery.bootgrid", function(e, rows)
       {
           document.getElementById("edit").disabled = true;
           document.getElementById("delete").disabled = true;
       });
       
     });
   $(function() {
	    var dialog, form,

	    dialog = $( "#dialog-add" ).dialog({
	        autoOpen: false,
	        height: 450,
	        width: 900,
	        modal: true,
	        buttons: {
	          "Insert": function() {
	        	  dialog.dialog("close");
	        	  var xmlhttp = new XMLHttpRequest();
	        	  xmlhttp.onreadystatechange=function()
	        	  {
	        	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	        	    {
	        		  	if(xmlhttp.responseText.toLowerCase().lastIndexOf("error") > -1) {
	        		  		alert(xmlhttp.responseText);
	        		  	}
	        		  	else {
	        	    		alert(xmlhttp.responseText);
	        	    		dialog.dialog("close");
	        	    		location.reload();
	        		  	}
	        	    }
	        	  }
	        	  xmlhttp.open("POST","insertUpdateAwardCriteria.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&criteriaName=" + document.getElementById("criteriaName").value + "&awardCriteriaDesc=" 
	        			  + document.getElementById("criteriaDesc").value + "&activeFl=" + document.getElementById("activeFl").checked 
	        			  + "&criteriaName=" + document.getElementById("criteriaName").value
	        			  + "&quotaPercentage=" + document.getElementById("quotaPercentage").value + "&quotaQuantity=" + document.getElementById("quotaQuantity").value
	        			  + "&quotaAlinedToRole=" + document.getElementById("quotaAlinedToRole").value + "&awardId=" + document.getElementById("awardId").value
	        			  + "&verticalId=" + document.getElementById("verticalId").value + "&projectId=" + document.getElementById("projectId").value
	        			  + "&companyId=" + document.getElementById("companyId").value + "&continentId=" + document.getElementById("continentId").value
	        			  + "&countryId=" + document.getElementById("countryId").value + "&stateId=" + document.getElementById("stateId").value
	        			  + "&locationId=" + document.getElementById("locationId").value + "&cityId=" + document.getElementById("cityId").value
	        			  + "&subCityId=" + document.getElementById("subCityId").value);
	        	  
	          },
	          Cancel: function() {
	            dialog.dialog( "close" );
	          }
	        },
	        close: function() {
	        }
	      });

	    dialog2 = $( "#dialog-edit" ).dialog({
	        autoOpen: false,
	        height: 450,
	        width: 900,
	        modal: true,
	        buttons: {
	          "Update": function() {

	        	  var xmlhttp = new XMLHttpRequest();
	        	  xmlhttp.onreadystatechange=function()
	        	  {
	        	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	        	    {
	        		  if(xmlhttp.responseText.toLowerCase().lastIndexOf("error") > -1) {
	        		  		alert(xmlhttp.responseText);
	        		  	}
	        		  	else {
	        	    		alert(xmlhttp.responseText);
	        	    		dialog2.dialog("close");
	        	    		location.reload();
	        		  	}	        	    }
	        	  }
	        	  xmlhttp.open("POST","insertUpdateAwardCriteria.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&criteriaName=" + document.getElementById("criteriaNamee").value + "&awardCriteriaDesc=" 
	        			  + document.getElementById("criteriaDesce").value + "&activeFl=" + document.getElementById("activeFle").checked 
	        			  + "&criteriaName=" + document.getElementById("criteriaNamee").value
	        			  + "&quotaPercentage=" + document.getElementById("quotaPercentagee").value + "&quotaQuantity=" + document.getElementById("quotaQuantitye").value
	        			  + "&quotaAlinedToRole=" + document.getElementById("quotaAlinedToRolee").value + "&awardId=" + document.getElementById("awardIde").value
	        			  + "&verticalId=" + document.getElementById("verticalIde").value + "&projectId=" + document.getElementById("projectIde").value
	        			  + "&companyId=" + document.getElementById("companyIde").value + "&continentId=" + document.getElementById("continentIde").value
	        			  + "&countryId=" + document.getElementById("countryIde").value + "&stateId=" + document.getElementById("stateIde").value
	        			  + "&locationId=" + document.getElementById("locationIde").value + "&cityId=" + document.getElementById("cityIde").value
	        			  + "&subCityId=" + document.getElementById("subCityIde").value);
	        	  
	          },
	          Cancel: function() {
	            dialog2.dialog( "close" );
	          }
	        },
	        close: function() {
	        }
	      });
	    
	    dialog3 = $( "#dialog-delete" ).dialog({
	        autoOpen: false,
	        height: 450,
	        width: 900,
	        modal: true,
	        buttons: {
	          "Delete": function() {
	        	  
	        	  var xmlhttp = new XMLHttpRequest();
	        	  xmlhttp.onreadystatechange=function()
	        	  {
				if (xmlhttp.readyState==4 && xmlhttp.status==200){
	        		  if(xmlhttp.responseText.toLowerCase().lastIndexOf("error") > -1) {
	        		  		alert(xmlhttp.responseText);
	        		  	}
	        		  	else {
	        	    		alert(xmlhttp.responseText);
	        	    		dialog3.dialog("close");
	        	    		location.reload();
	        		  	}
				  }
	        	  }
	        	  xmlhttp.open("POST","insertUpdateAwardCriteria.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&criteriaName=" + document.getElementById("criteriaNamed").value + "&awardCriteriaDesc=" 
	        			  + document.getElementById("criteriaDescd").value + "&activeFl=" + document.getElementById("activeFld").checked 
	        			  + "&criteriaName=" + document.getElementById("criteriaNamed").value
	        			  + "&quotaPercentage=" + document.getElementById("quotaPercentaged").value + "&quotaQuantity=" + document.getElementById("quotaQuantityd").value
	        			  + "&quotaAlinedToRole=" + document.getElementById("quotaAlinedToRoled").value + "&awardId=" + document.getElementById("awardIdd").value
	        			  + "&verticalId=" + document.getElementById("verticalIdd").value + "&projectId=" + document.getElementById("projectIdd").value
	        			  + "&companyId=" + document.getElementById("companyIdd").value + "&continentId=" + document.getElementById("continentIdd").value
	        			  + "&countryId=" + document.getElementById("countryIdd").value + "&stateId=" + document.getElementById("stateIdd").value
	        			  + "&locationId=" + document.getElementById("locationIdd").value + "&cityId=" + document.getElementById("cityIdd").value
	        			  + "&subCityId=" + document.getElementById("subCityIdd").value);
	        	  
	          },
	          Cancel: function() {
	            dialog3.dialog( "close" );
	          }
	        },
	        close: function() {
	          //form[ 0 ].reset();
	          //allFields.removeClass( "ui-state-error" );
	        }
	      });
	      form = dialog.find( "form" ).on( "submit", function( event ) {
	        event.preventDefault();
	      });

	      $( "#add" ).button().on( "click", function() {
	        dialog.dialog( "open" );
	      });
	      $( "#edit" ).button().on( "click", function() {
		        dialog2.dialog( "open" );
		      });
	      $( "#delete" ).button().on( "click", function() {
		        dialog3.dialog( "open" );
		      });
         document.getElementById("edit").disabled = true;
         document.getElementById("delete").disabled = true;
  });
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="../../commonPages/header.jsp"></jsp:include>
	<jsp:include page="../../commonPages/navigationMenu.jsp"></jsp:include>
		<section class="cgi-rnr-main-content">
			<div class="container">
				<div class="row">
				<h4 align="Center">Award Criteria</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="criteriaName" data-identifier="true">Name</th>
			            <th data-column-id="awardName">Award</th>
			            <th data-column-id="activeFl">Active</th>
			            <th data-column-id="verticalName">Vertical</th>
			            <th data-column-id="projectName">Project</th>
			            <th data-column-id="continentName">Continent</th>
			            <th data-column-id="countryName">Country</th>
			            <th data-column-id="quotaPer">Quota</th>
			            <th data-column-id="quotaAlinedToRoleName">Aligned to.</th>
			        </tr>
			    </thead>
			</table>
<div class="form-group">
	<div class="col-sm-1">
	</div>
	<div class="col-sm-1">
		<button id="add" class="btn">Add</button>
	</div>
	<div class="col-sm-1">
		<button id="edit" class="btn">Edit</button>
	</div>
	<div class="col-sm-1">
		<button id="delete" class="btn">Delete</button>
	</div>
</div>
</div>
</div>
</section>
</div>
<div id="dialog-add" title="Create Award">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="criteriaName">Criteria Name</label></td>
					<td><input type="text" name="criteriaName" id="criteriaName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="criteriaDesc">Description</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="criteriaDesc" id="criteriaDesc" class="text ui-widget-content ui-corner-all" >
   			        </td>
   			        <td><label for="quotaPercentage">Quota percentage</label></td>
   			        <td><input type="text" name="quotaPercentage" id="quotaPercentage" class="text ui-widget-content ui-corner-all"></td>
		        </tr>
		        <tr>
		        	<td colspan="1"><label for="quotaQuantity">Quota in count</label></td>
   			        <td><input type="text" name="quotaQuantity" id="quotaQuantity" class="text ui-widget-content ui-corner-all"></td>
		        	<td colspan="1"><label for="quotaAlinedToRole">Quota aligned</label></td>
		        	<td colspan="1">
	        	      <select name="quotaAlinedToRole" id="quotaAlinedToRole">
						<option value="1">MEMBER</option>
						<option value="2">RM</option>
						<option value="3">PM</option>
						<option value="4">SPM</option>
						<option value="5">ED</option>
						<option value="6">GH</option>
						<option value="7">GL</option>
						<option value="8">SGL</option>
				      </select>
		        	</td>
		        	<td colspan="1"><label for="activeFl">Active</label></td>
		        	<td align="left"><input type="checkbox" name="activeFl" id="activeFl" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
					<td colspan="1"><label for="awardId">Award Name</label></td>
					<td>
						<select name="awardId" id="awardId">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Project Details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="verticalId">Vertical</label></td>
		        	<td colspan="1">
	        	      <select name="verticalId" id="verticalId">
						<option value="0">ALL</option>
						<c:if test="${not empty Vertical}">
								<c:forEach var="listValue" items="${Vertical}">
									<option value="${listValue.id}">${listValue.verticalName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="projectId">Project</label></td>
		        	<td colspan="3">
	        	      <select name="projectId" id="projectId">
						<option value="0">ALL</option>
						<c:if test="${not empty Project}">
								<c:forEach var="listValue" items="${Project}">
									<option value="${listValue.id}">${listValue.projectName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Copmany details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="companyId">Company</label></td>
		        	<td>
	        	      <select name="companyId" id="companyId">
						<option value="0">ALL</option>
						<c:if test="${not empty Company}">
								<c:forEach var="listValue" items="${Company}">
									<option value="${listValue.id}">${listValue.companyName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="continentId">Continent</label></td>
		        	<td>
	        	      <select name="continentId" id="continentId">
						<option value="0">ALL</option>
						<c:if test="${not empty Continent}">
								<c:forEach var="listValue" items="${Continent}">
									<option value="${listValue.id}">${listValue.continentName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="countryId">Country</label></td>
		        	<td>
	        	      <select name="countryId" id="countryId">
						<option value="0">ALL</option>
						<c:if test="${not empty Country}">
								<c:forEach var="listValue" items="${Country}">
									<option value="${listValue.id}">${listValue.countryName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="stateId">State</label></td>
		        	<td>
	        	      <select name="stateId" id="stateId">
						<option value="0">ALL</option>
						<c:if test="${not empty State}">
								<c:forEach var="listValue" items="${State}">
									<option value="${listValue.id}">${listValue.stateName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="locationId">Location</label></td>
		        	<td>
	        	      <select name="locationId" id="locationId">
						<option value="0">ALL</option>
						<c:if test="${not empty Location}">
								<c:forEach var="listValue" items="${Location}">
									<option value="${listValue.id}">${listValue.locationName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="cityId">Continent</label></td>
		        	<td>
	        	      <select name="cityId" id="cityId">
						<option value="0">ALL</option>
						<c:if test="${not empty City}">
								<c:forEach var="listValue" items="${City}">
									<option value="${listValue.id}">${listValue.cityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="subCityId">Sub City</label></td>
		        	<td>
	        	      <select name="subCityId" id="subCityId">
						<option value="0">ALL</option>
						<c:if test="${not empty SubCity}">
								<c:forEach var="listValue" items="${SubCity}">
									<option value="${listValue.id}">${listValue.subCityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Award">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td><label for="criteriaIde">Criteria Id</label></td>
		        	<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="criteriaNamee">Criteria Name</label></td>
					<td><input type="text" name="criteriaNamee" id="criteriaNamee" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="criteriaDesce">Description</label></td>
		        	<td><input type="text" name="criteriaDesce" id="criteriaDesce" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="quotaPercentagee">Quota percentage</label></td>
   			        <td><input type="text" name="quotaPercentagee" id="quotaPercentagee" class="text ui-widget-content ui-corner-all"></td>
		        	<td colspan="1"><label for="quotaQuantitye">Quota in count</label></td>
   			        <td><input type="text" name="quotaQuantitye" id="quotaQuantitye" class="text ui-widget-content ui-corner-all"></td>
		        	<td colspan="1"><label for="quotaAlinedToRolee">Quota aligned</label></td>
		        	<td colspan="1">
	        	      <select name="quotaAlinedToRolee" id="quotaAlinedToRolee">
						<option value="1">MEMBER</option>
						<option value="2">RM</option>
						<option value="3">PM</option>
						<option value="4">SPM</option>
						<option value="5">ED</option>
						<option value="6">GH</option>
						<option value="7">GL</option>
						<option value="8">SGL</option>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td colspan="1"><label for="activeFle">Active</label></td>
		        	<td align="left"><input type="checkbox" name="activeFle" id="activeFle" class="text ui-widget-content ui-corner-all" ></td>
					<td colspan="1"><label for="awardId">Award Name</label></td>
					<td>
						<select name="awardIde" id="awardIde" disabled="disabled">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
					<td></td>
					<td></td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Project Details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="verticalIde">Vertical</label></td>
		        	<td colspan="1">
	        	      <select name="verticalIde" id="verticalIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Vertical}">
								<c:forEach var="listValue" items="${Vertical}">
									<option value="${listValue.id}">${listValue.verticalName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="projectIde">Project</label></td>
		        	<td colspan="3">
	        	      <select name="projectIde" id="projectIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Project}">
								<c:forEach var="listValue" items="${Project}">
									<option value="${listValue.id}">${listValue.projectName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Copmany details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="companyIde">Company</label></td>
		        	<td>
	        	      <select name="companyIde" id="companyIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Company}">
								<c:forEach var="listValue" items="${Company}">
									<option value="${listValue.id}">${listValue.companyName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="continentIde">Continent</label></td>
		        	<td>
	        	      <select name="continentIde" id="continentIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Continent}">
								<c:forEach var="listValue" items="${Continent}">
									<option value="${listValue.id}">${listValue.continentName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="countryIde">Country</label></td>
		        	<td>
	        	      <select name="countryIde" id="countryIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Country}">
								<c:forEach var="listValue" items="${Country}">
									<option value="${listValue.id}">${listValue.countryName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="stateIde">State</label></td>
		        	<td>
	        	      <select name="stateIde" id="stateIde">
						<option value="0">ALL</option>
						<c:if test="${not empty State}">
								<c:forEach var="listValue" items="${State}">
									<option value="${listValue.id}">${listValue.stateName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="locationIde">Location</label></td>
		        	<td>
	        	      <select name="locationIde" id="locationIde">
						<option value="0">ALL</option>
						<c:if test="${not empty Location}">
								<c:forEach var="listValue" items="${Location}">
									<option value="${listValue.id}">${listValue.locationName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="cityIde">Continent</label></td>
		        	<td>
	        	      <select name="cityIde" id="cityIde">
						<option value="0">ALL</option>
						<c:if test="${not empty City}">
								<c:forEach var="listValue" items="${City}">
									<option value="${listValue.id}">${listValue.cityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="subCityIde">Sub City</label></td>
		        	<td>
	        	      <select name="subCityIde" id="subCityIde">
						<option value="0">ALL</option>
						<c:if test="${not empty SubCity}">
								<c:forEach var="listValue" items="${SubCity}">
									<option value="${listValue.id}">${listValue.subCityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>
		    </table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Award">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td><label for="idd">Criteria Id</label></td>
		        	<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="criteriaNamed">Criteria Name</label></td>
					<td><input type="text" name="criteriaNamed" id="criteriaNamed" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="criteriaDescd">Description</label></td>
		        	<td><input type="text" name="criteriaDescd" id="criteriaDescd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
   			        <td><label for="quotaPercentaged">Quota percentage</label></td>
   			        <td><input type="text" name="quotaPercentaged" id="quotaPercentaged" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td colspan="1"><label for="quotaQuantityd">Quota in count</label></td>
   			        <td><input type="text" name="quotaQuantityd" id="quotaQuantityd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td colspan="1"><label for="quotaAlinedToRoled">Quota aligned</label></td>
		        	<td colspan="1">
	        	      <select name="quotaAlinedToRoled" id="quotaAlinedToRoled" disabled="disabled">
						<option value="1">MEMBER</option>
						<option value="2">RM</option>
						<option value="3">PM</option>
						<option value="4">SPM</option>
						<option value="5">ED</option>
						<option value="6">GH</option>
						<option value="7">GL</option>
						<option value="8">SGL</option>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td colspan="1"><label for="activeFld">Active</label></td>
		        	<td align="left"><input type="checkbox" name="activeFld" id="activeFld" class="text ui-widget-content ui-corner-all"  disabled="disabled"></td>
					<td colspan="1"><label for="awardIdd">Award Name</label></td>
					<td>
						<select name="awardIdd" id="awardIdd" disabled="disabled">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
					<td></td>
					<td></td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Project Details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="verticalIdd">Vertical</label></td>
		        	<td colspan="1">
	        	      <select name="verticalIdd" id="verticalIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Vertical}">
								<c:forEach var="listValue" items="${Vertical}">
									<option value="${listValue.id}">${listValue.verticalName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="projectIdd">Project</label></td>
		        	<td colspan="3">
	        	      <select name="projectIdd" id="projectIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Project}">
								<c:forEach var="listValue" items="${Project}">
									<option value="${listValue.id}">${listValue.projectName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td colspan="7" align="center"><b>Copmany details</b></td>
		        </tr>
		        <tr>
		        	<td><label for="companyIdd">Company</label></td>
		        	<td>
	        	      <select name="companyIdd" id="companyIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Company}">
								<c:forEach var="listValue" items="${Company}">
									<option value="${listValue.id}">${listValue.companyName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="continentIdd">Continent</label></td>
		        	<td>
	        	      <select name="continentIdd" id="continentIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Continent}">
								<c:forEach var="listValue" items="${Continent}">
									<option value="${listValue.id}">${listValue.continentName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="countryIdd">Country</label></td>
		        	<td>
	        	      <select name="countryIdd" id="countryIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Country}">
								<c:forEach var="listValue" items="${Country}">
									<option value="${listValue.id}">${listValue.countryName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="stateIdd">State</label></td>
		        	<td>
	        	      <select name="stateIdd" id="stateIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty State}">
								<c:forEach var="listValue" items="${State}">
									<option value="${listValue.id}">${listValue.stateName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="locationIdd">Location</label></td>
		        	<td>
	        	      <select name="locationIdd" id="locationIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty Location}">
								<c:forEach var="listValue" items="${Location}">
									<option value="${listValue.id}">${listValue.locationName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td><label for="cityIdd">Continent</label></td>
		        	<td>
	        	      <select name="cityIdd" id="cityIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty City}">
								<c:forEach var="listValue" items="${City}">
									<option value="${listValue.id}">${listValue.cityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        </tr>
		        <tr>
		        	<td><label for="subCityIdd">Sub City</label></td>
		        	<td>
	        	      <select name="subCityIdd" id="subCityIdd" disabled="disabled">
						<option value="0">ALL</option>
						<c:if test="${not empty SubCity}">
								<c:forEach var="listValue" items="${SubCity}">
									<option value="${listValue.id}">${listValue.subCityName }</option>
								</c:forEach>
						</c:if>
				      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>
		    </table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
</body>
</html>