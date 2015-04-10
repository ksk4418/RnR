<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<HTML>
<jsp:include page="../../commonPages/jQuery.jsp"></jsp:include>
<link href=<c:url value ="/resources/assets/Content/Examples8d63.css"/>  rel="stylesheet" />
<jsp:include page="../../commonPages/head.jsp"></jsp:include>
<head>
<meta charset="utf-8">
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
           url: "getWorkFlowLevels",
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

           document.getElementById("ide").value = rows[0].workFlowLevelsId
           document.getElementById("idd").value = rows[0].workFlowLevelsId
           document.getElementById("workFlowIde").value = rows[0].workFlowId
           document.getElementById("workFlowIdd").value = rows[0].workFlowId
           document.getElementById("workFlowLevelNamee").value = rows[0].workFlowLevelName
           document.getElementById("workFlowLevelNamed").value = rows[0].workFlowLevelName
           document.getElementById("awardCriteriaIde").value = rows[0].awardCriteriaId
           document.getElementById("awardCriteriaIdd").value = rows[0].awardCriteriaId
           
           if(rows[0].enableFl1 == 'Y') {
	           document.getElementById("Enable1e").checked = 1
	           document.getElementById("Enable1d").checked = 1
       		} else { 
       			document.getElementById("Enable1e").checked = 0
 	           document.getElementById("Enable1d").checked = 0
       		}
           document.getElementById("memRole1e").value = rows[0].memberLevel1
           document.getElementById("memRole1d").value = rows[0].memberLevel1
           document.getElementById("panelId1e").value = rows[0].panelId1
           document.getElementById("panelId1d").value = rows[0].panelId1
		   if(rows[0].emailFlag1 == 'Y') {
	           document.getElementById("emailFlag1e").checked = 1
	           document.getElementById("emailFlag1d").checked = 1
       		} else { 
       			document.getElementById("emailFlag1e").checked = 0
 	           document.getElementById("emailFlag1d").checked = 0
       		}
           if(rows[0].enableFl2 == 'Y') {
	           document.getElementById("Enable2e").checked = 1
	           document.getElementById("Enable2d").checked = 1
       		} else { 
       			document.getElementById("Enable2e").checked = 0
 	           document.getElementById("Enable2d").checked = 0
       		}
           document.getElementById("memRole2e").value = rows[0].memberLevel2
           document.getElementById("memRole2d").value = rows[0].memberLevel2
           document.getElementById("panelId2e").value = rows[0].panelId2
           document.getElementById("panelId2d").value = rows[0].panelId2
		   if(rows[0].emailFlag2 == 'Y') {
	           document.getElementById("emailFlag2e").checked = 1
	           document.getElementById("emailFlag2d").checked = 1
       		} else { 
       			document.getElementById("emailFlag2e").checked = 0
 	           document.getElementById("emailFlag2d").checked = 0
       		}
           if(rows[0].enableFl3 == 'Y') {
	           document.getElementById("Enable3e").checked = 1
	           document.getElementById("Enable3d").checked = 1
       		} else { 
       			document.getElementById("Enable3e").checked = 0
 	           document.getElementById("Enable3d").checked = 0
       		}
           document.getElementById("memRole3e").value = rows[0].memberLevel3
           document.getElementById("memRole3d").value = rows[0].memberLevel3
           document.getElementById("panelId3e").value = rows[0].panelId3
           document.getElementById("panelId3d").value = rows[0].panelId3
		   if(rows[0].emailFlag3 == 'Y') {
	           document.getElementById("emailFlag3e").checked = 1
	           document.getElementById("emailFlag3d").checked = 1
       		} else { 
       			document.getElementById("emailFlag3e").checked = 0
 	           document.getElementById("emailFlag3d").checked = 0
       		}
           if(rows[0].enableFl4 == 'Y') {
	           document.getElementById("Enable4e").checked = 1
	           document.getElementById("Enable4d").checked = 1
       		} else { 
       			document.getElementById("Enable4e").checked = 0
 	           document.getElementById("Enable4d").checked = 0
       		}
           document.getElementById("memRole4e").value = rows[0].memberLevel4
           document.getElementById("memRole4d").value = rows[0].memberLevel4
           document.getElementById("panelId4e").value = rows[0].panelId4
           document.getElementById("panelId4d").value = rows[0].panelId4
		   if(rows[0].emailFlag4 == 'Y') {
	           document.getElementById("emailFlag4e").checked = 1
	           document.getElementById("emailFlag4d").checked = 1
       		} else { 
       			document.getElementById("emailFlag4e").checked = 0
 	           document.getElementById("emailFlag4d").checked = 0
       		}
           if(rows[0].enableFl5 == 'Y') {
	           document.getElementById("Enable5e").checked = 1
	           document.getElementById("Enable5d").checked = 1
       		} else { 
       			document.getElementById("Enable5e").checked = 0
 	           document.getElementById("Enable5d").checked = 0
       		}
           document.getElementById("memRole5e").value = rows[0].memberLevel5
           document.getElementById("memRole5d").value = rows[0].memberLevel5
           document.getElementById("panelId5e").value = rows[0].panelId5
           document.getElementById("panelId5d").value = rows[0].panelId5
		   if(rows[0].emailFlag5 == 'Y') {
	           document.getElementById("emailFlag5e").checked = 1
	           document.getElementById("emailFlag5d").checked = 1
       		} else { 
       			document.getElementById("emailFlag5e").checked = 0
 	           document.getElementById("emailFlag5d").checked = 0
       		}
           if(rows[0].enableFl6 == 'Y') {
	           document.getElementById("Enable6e").checked = 1
	           document.getElementById("Enable6d").checked = 1
       		} else { 
       			document.getElementById("Enable6e").checked = 0
 	           document.getElementById("Enable6d").checked = 0
       		}
           document.getElementById("memRole6e").value = rows[0].memberLevel6
           document.getElementById("memRole6d").value = rows[0].memberLevel6
           document.getElementById("panelId6e").value = rows[0].panelId6
           document.getElementById("panelId6d").value = rows[0].panelId6
		   if(rows[0].emailFlag6 == 'Y') {
	           document.getElementById("emailFlag6e").checked = 1
	           document.getElementById("emailFlag6d").checked = 1
       		} else { 
       			document.getElementById("emailFlag6e").checked = 0
 	           document.getElementById("emailFlag6d").checked = 0
       		}

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
	        width: 950,
	        modal: true,
	        buttons: {
	          "Insert": function() {
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
	        	  xmlhttp.open("POST","insertUpdateWorkflowLVL.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&workFlowLevelName=" 
						  + document.getElementById("workFlowLevelName").value + "&workFlowId=" 
	        			  + document.getElementById("workFlowId").value + "&awardCriteriaId=" + document.getElementById("awardCriteriaId").value
						  + "&Enable1=" + document.getElementById("Enable1").checked + "&memRole1=" + document.getElementById("memRole1").value
	        			  + "&panelId1=" + document.getElementById("panelId1").value + "&emailFlag1=" + document.getElementById("emailFlag1").checked
						  + "&Enable2=" + document.getElementById("Enable2").checked + "&memRole2=" + document.getElementById("memRole2").value
	        			  + "&panelId2=" + document.getElementById("panelId2").value + "&emailFlag2=" + document.getElementById("emailFlag2").checked
						  + "&Enable3=" + document.getElementById("Enable3").checked + "&memRole3=" + document.getElementById("memRole3").value
	        			  + "&panelId3=" + document.getElementById("panelId3").value + "&emailFlag3=" + document.getElementById("emailFlag3").checked
						  + "&Enable4=" + document.getElementById("Enable4").checked + "&memRole4=" + document.getElementById("memRole4").value
	        			  + "&panelId4=" + document.getElementById("panelId4").value + "&emailFlag4=" + document.getElementById("emailFlag4").checked
						  + "&Enable5=" + document.getElementById("Enable5").checked + "&memRole5=" + document.getElementById("memRole5").value
	        			  + "&panelId5=" + document.getElementById("panelId5").value + "&emailFlag5=" + document.getElementById("emailFlag5").checked
						  + "&Enable6=" + document.getElementById("Enable6").checked + "&memRole6=" + document.getElementById("memRole6").value
	        			  + "&panelId6=" + document.getElementById("panelId6").value + "&emailFlag6=" + document.getElementById("emailFlag6").checked);
	        	  
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
	        width: 950,
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
	        	  xmlhttp.open("POST","insertUpdateWorkflowLVL.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&workFlowLevelName=" 
						  + document.getElementById("workFlowLevelNamee").value + "&workFlowId=" 
	        			  + document.getElementById("workFlowIde").value + "&awardCriteriaId=" + document.getElementById("awardCriteriaIde").value
						  + "&Enable1=" + document.getElementById("Enable1e").checked + "&memRole1=" + document.getElementById("memRole1e").value
	        			  + "&panelId1=" + document.getElementById("panelId1e").value + "&emailFlag1=" + document.getElementById("emailFlag1e").checked
						  + "&Enable2=" + document.getElementById("Enable2e").checked + "&memRole2=" + document.getElementById("memRole2e").value
	        			  + "&panelId2=" + document.getElementById("panelId2e").value + "&emailFlag2=" + document.getElementById("emailFlag2e").checked
						  + "&Enable3=" + document.getElementById("Enable3e").checked + "&memRole3=" + document.getElementById("memRole3e").value
	        			  + "&panelId3=" + document.getElementById("panelId3e").value + "&emailFlag3=" + document.getElementById("emailFlag3e").checked
						  + "&Enable4=" + document.getElementById("Enable4e").checked + "&memRole4=" + document.getElementById("memRole4e").value
	        			  + "&panelId4=" + document.getElementById("panelId4e").value + "&emailFlag4=" + document.getElementById("emailFlag4e").checked
						  + "&Enable5=" + document.getElementById("Enable5e").checked + "&memRole5=" + document.getElementById("memRole5e").value
	        			  + "&panelId5=" + document.getElementById("panelId5e").value + "&emailFlag5=" + document.getElementById("emailFlag5e").checked
						  + "&Enable6=" + document.getElementById("Enable6e").checked + "&memRole6=" + document.getElementById("memRole6e").value
	        			  + "&panelId6=" + document.getElementById("panelId6e").value + "&emailFlag6=" + document.getElementById("emailFlag6e").checked);
	        	  
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
	        width: 950,
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
	        	  xmlhttp.open("POST","insertUpdateWorkflowLVL.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&workFlowLevelName=" 
						  + document.getElementById("workFlowLevelNamed").value + "&workFlowId=" 
	        			  + document.getElementById("workFlowIdd").value + "&awardCriteriaId=" + document.getElementById("awardCriteriaIdd").value
						  + "&Enable1=" + document.getElementById("Enable1d").checked + "&memRole1=" + document.getElementById("memRole1d").value
	        			  + "&panelId1=" + document.getElementById("panelId1d").value + "&emailFlag1=" + document.getElementById("emailFlag1d").checked
						  + "&Enable2=" + document.getElementById("Enable2d").checked + "&memRole2=" + document.getElementById("memRole2d").value
	        			  + "&panelId2=" + document.getElementById("panelId2d").value + "&emailFlag2=" + document.getElementById("emailFlag2d").checked
						  + "&Enable3=" + document.getElementById("Enable3d").checked + "&memRole3=" + document.getElementById("memRole3d").value
	        			  + "&panelId3=" + document.getElementById("panelId3d").value + "&emailFlag3=" + document.getElementById("emailFlag3d").checked
						  + "&Enable4=" + document.getElementById("Enable4d").checked + "&memRole4=" + document.getElementById("memRole4d").value
	        			  + "&panelId4=" + document.getElementById("panelId4d").value + "&emailFlag4=" + document.getElementById("emailFlag4d").checked
						  + "&Enable5=" + document.getElementById("Enable5d").checked + "&memRole5=" + document.getElementById("memRole5d").value
	        			  + "&panelId5=" + document.getElementById("panelId5d").value + "&emailFlag5=" + document.getElementById("emailFlag5d").checked
						  + "&Enable6=" + document.getElementById("Enable6d").checked + "&memRole6=" + document.getElementById("memRole6d").value
	        			  + "&panelId6=" + document.getElementById("panelId6d").value + "&emailFlag6=" + document.getElementById("emailFlag6d").checked);
	        	  
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
				<h4 align="Center">Award</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="workFlowLevelName" data-identifier="true">Workflow Name</th>
			            <th data-column-id="awardCriteriaName">Award Criteria</th>
			            <th data-column-id="workFlowLevelsId" data-order="asc">Id</th>
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
<div id="dialog-add" title="Create Workflow">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td></td>
   			        <td></td>
					<td><label for="workFlowLevelName">Workflow Name</label></td>
					<td><input type="text" name="workFlowLevelName" id="workFlowLevelName" class="text ui-widget-content ui-corner-all">
		            <input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" disabled="disabled">
					</td>
		        	<td><label for="workFlowId">Workflow</label></td>
		        	<td>
   			        	 <select name="workFlowId" id="workFlowId">
						  <c:if test="${not empty WorkFlow}">
								<c:forEach var="listValue" items="${WorkFlow}">
									<option value="${listValue.id}">${listValue.workFlowName }</option>
								</c:forEach>
							</c:if>
					      </select>
   			        </td>
   			        <td></td>
   			        <td></td>
		        </tr>
		        <tr>
		        	<td></td>
		        	<td></td>
					<td><label for="awardCriteriaId">Award Criteria</label></td>
		        	<td>
		        	      <select name="awardCriteriaId" id="awardCriteriaId">
						  <c:if test="${not empty AwardCriteria}">
								<c:forEach var="listValue" items="${AwardCriteria}">
									<option value="${listValue.id}">${listValue.criteriaName }</option>
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
		        	<td><label for="Enable1">Enable Level1</label></td>
		        	<td><input type="checkbox" name="Enable1" id="Enable1" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole1">Approver</label></td>
		        	<td>
		        	      <select name="memRole1" id="memRole1">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId1">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId1" id="panelId1">
		        	      	<option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag1">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag1" id="emailFlag1" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable2">Enable Level2</label></td>
		        	<td><input type="checkbox" name="Enable2" id="Enable2" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole2">Approver</label></td>
		        	<td>
		        	      <select name="memRole2" id="memRole2">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId2">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId2" id="panelId2">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag2">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag2" id="emailFlag2" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
       		    <tr>
		        	<td><label for="Enable3">Enable Level3</label></td>
		        	<td><input type="checkbox" name="Enable3" id="Enable3" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole3">Approver</label></td>
		        	<td>
		        	      <select name="memRole3" id="memRole3">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId3">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId3" id="panelId3">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag3">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag3" id="emailFlag3" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable4">Enable Level4</label></td>
		        	<td><input type="checkbox" name="Enable4" id="Enable4" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole4">Approver</label></td>
		        	<td>
		        	      <select name="memRole4" id="memRole4">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId4">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId4" id="panelId4">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag4">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag4" id="emailFlag4" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
      		    <tr>
		        	<td><label for="Enable5">Enable Level5</label></td>
		        	<td><input type="checkbox" name="Enable5" id="Enable5" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole5">Approver</label></td>
		        	<td>
		        	      <select name="memRole5" id="memRole5">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId5">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId5" id="panelId5">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag5">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag5" id="emailFlag5" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			    <tr>
		        	<td><label for="Enable6">Enable Level6</label></td>
		        	<td><input type="checkbox" name="Enable6" id="Enable6" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole6">Approver</label></td>
		        	<td>
		        	      <select name="memRole6" id="memRole6">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId6">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId6" id="panelId6">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag6">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag6" id="emailFlag6" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Workflow Level">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td></td><td></td>
		        	<td><label for="ide">Workflow Id: </label></td>
		            <td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="workFlowLevelNamee">Workflow Name</label></td>
					<td><input type="text" name="workFlowLevelNamee" id="workFlowLevelNamee" class="text ui-widget-content ui-corner-all"></td>
		        	<td></td>
		        	<td></td>
		        </tr>
		        <tr>
		        	<td></td><td></td>
					<td><label for="awardCriteriaIde">Award Criteria</label></td>
		        	<td>
		        	      <select name="awardCriteriaIde" id="awardCriteriaIde">
						  <c:if test="${not empty AwardCriteria}">
								<c:forEach var="listValue" items="${AwardCriteria}">
									<option value="${listValue.id}">${listValue.criteriaName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="workFlowIde">Workflow</label></td>
		        	<td>
   			        	 <select name="workFlowIde" id="workFlowIde">
						  <c:if test="${not empty WorkFlow}">
								<c:forEach var="listValue" items="${WorkFlow}">
									<option value="${listValue.id}">${listValue.workFlowName }</option>
								</c:forEach>
							</c:if>
					      </select>
   			        </td>
   			        <td></td><td></td>
		        </tr>
     		    <tr>
		        	<td><label for="Enable1e">Enable Level1</label></td>
		        	<td><input type="checkbox" name="Enable1e" id="Enable1e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole1e">Approver</label></td>
		        	<td>
		        	      <select name="memRole1e" id="memRole1e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId1e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId1e" id="panelId1e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag1e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag1e" id="emailFlag1e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable2e">Enable Level2</label></td>
		        	<td><input type="checkbox" name="Enable2e" id="Enable2e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole2">Approver</label></td>
		        	<td>
		        	      <select name="memRole2e" id="memRole2e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId2e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId2e" id="panelId2e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag2e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag2e" id="emailFlag2e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
       		    <tr>
		        	<td><label for="Enable3e">Enable Level3</label></td>
		        	<td><input type="checkbox" name="Enable3e" id="Enable3e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole3e">Approver</label></td>
		        	<td>
		        	      <select name="memRole3e" id="memRole3e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId3e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId3e" id="panelId3e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag3e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag3e" id="emailFlag3e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable4e">Enable Level4</label></td>
		        	<td><input type="checkbox" name="Enable4e" id="Enable4e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole4e">Approver</label></td>
		        	<td>
		        	      <select name="memRole4e" id="memRole4e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId4e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId4e" id="panelId4e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag4e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag4e" id="emailFlag4e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
      		    <tr>
		        	<td><label for="Enable5e">Enable Level5</label></td>
		        	<td><input type="checkbox" name="Enable5e" id="Enable5e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole5e">Approver</label></td>
		        	<td>
		        	      <select name="memRole5e" id="memRole5e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId5e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId5e" id="panelId5e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag5e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag5e" id="emailFlag5e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			    <tr>
		        	<td><label for="Enable6e">Enable Level6</label></td>
		        	<td><input type="checkbox" name="Enable6e" id="Enable6e" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole6e">Approver</label></td>
		        	<td>
		        	      <select name="memRole6e" id="memRole6e">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId6e">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId6e" id="panelId6e">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag6e">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag6e" id="emailFlag6e" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Workflow level">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td></td><td></td>
		        	<td><label for="idd">Workflow Id: </label></td>
		            <td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="workFlowLevelNamed">Workflow Name</label></td>
					<td><input type="text" name="workFlowLevelNamed" id="workFlowLevelNamed" class="text ui-widget-content ui-corner-all"></td>
		        	
   			        <td></td><td></td>
		        </tr>
		        <tr>
		        	<td></td>
		        	<td></td>
					<td><label for="awardCriteriaIdd">Award Criteria</label></td>
		        	<td>
		        	      <select name="awardCriteriaIdd" id="awardCriteriaIdd">
						  <c:if test="${not empty AwardCriteria}">
								<c:forEach var="listValue" items="${AwardCriteria}">
									<option value="${listValue.id}">${listValue.criteriaName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="workFlowIdd">Workflow</label></td>
		        	<td>
   			        	 <select name="workFlowIdd" id="workFlowIdd">
						  <c:if test="${not empty WorkFlow}">
								<c:forEach var="listValue" items="${WorkFlow}">
									<option value="${listValue.id}">${listValue.workFlowName }</option>
								</c:forEach>
							</c:if>
					      </select>
   			        </td>
		        	<td></td><td></td>
		        </tr>
     		    <tr>
		        	<td><label for="Enable1d">Enable Level1</label></td>
		        	<td><input type="checkbox" name="Enable1d" id="Enable1d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole1d">Approver</label></td>
		        	<td>
		        	      <select name="memRole1d" id="memRole1d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId1d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId1d" id="panelId1d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag1d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag1d" id="emailFlag1d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable2d">Enable Level2</label></td>
		        	<td><input type="checkbox" name="Enable2d" id="Enable2d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole2">Approver</label></td>
		        	<td>
		        	      <select name="memRole2d" id="memRole2d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId2d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId2d" id="panelId2d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag2d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag2d" id="emailFlag2d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
       		    <tr>
		        	<td><label for="Enable3d">Enable Level3</label></td>
		        	<td><input type="checkbox" name="Enable3d" id="Enable3d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole3d">Approver</label></td>
		        	<td>
		        	      <select name="memRole3d" id="memRole3d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId3d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId3d" id="panelId3d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag3d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag3d" id="emailFlag3d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="Enable4d">Enable Level4</label></td>
		        	<td><input type="checkbox" name="Enable4d" id="Enable4d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole4d">Approver</label></td>
		        	<td>
		        	      <select name="memRole4d" id="memRole4d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId4d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId4d" id="panelId4d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag4d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag4d" id="emailFlag4d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
      		    <tr>
		        	<td><label for="Enable5d">Enable Level5</label></td>
		        	<td><input type="checkbox" name="Enable5d" id="Enable5d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole5d">Approver</label></td>
		        	<td>
		        	      <select name="memRole5d" id="memRole5d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId5d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId5d" id="panelId5d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag5d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag5d" id="emailFlag5d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			    <tr>
		        	<td><label for="Enable6d">Enable Level6</label></td>
		        	<td><input type="checkbox" name="Enable6d" id="Enable6d" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="memRole6d">Approver</label></td>
		        	<td>
		        	      <select name="memRole6d" id="memRole6d">
							<option value="1">Panel Group</option>
							<option value="2">RM</option>
							<option value="3">PM</option>
							<option value="4">SPM</option>
							<option value="5">ED</option>
							<option value="6">GH</option>
							<option value="7">GL</option>
							<option value="8">SGL</option>
					      </select>
		        	</td>
		        	<td><label for="panelId6d">Panel Group</label></td>
		        	<td>
		        	      <select name="panelId6d" id="panelId6d">
		        	      <option value=0>None</option>
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td><label for="emailFlag6d">E-Mail</label></td>
	        		<td><input type="checkbox" name="emailFlag6d" id="emailFlag6d" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		     </table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
</body>
</html>