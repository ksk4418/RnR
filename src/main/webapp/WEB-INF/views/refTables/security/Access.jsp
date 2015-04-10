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
           url: "getAccess",
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
           document.getElementById("accessNamee").value = rows[0].accessName
           document.getElementById("accessNamed").value = rows[0].accessName
           
           document.getElementById("pageIde").value = rows[0].pageId
           document.getElementById("pageIdd").value = rows[0].pageId
           
           if(rows[0].insertFl == 'Y') {
	           document.getElementById("insertFle").checked = 1
	           document.getElementById("insertFld").checked = 1
       		} else { 
       			document.getElementById("insertFle").checked = 0
 	           document.getElementById("insertFld").checked = 0
       		}
           
           if(rows[0].updateFl == 'Y') {
	           document.getElementById("updateFle").checked = 1
	           document.getElementById("updateFld").checked = 1
       		} else { 
       			document.getElementById("updateFle").checked = 0
 	           document.getElementById("updateFld").checked = 0
       		}
           
           if(rows[0].deleteFl == 'Y') {
	           document.getElementById("deleteFle").checked = 1
	           document.getElementById("deleteFld").checked = 1
       		} else { 
       			document.getElementById("deleteFle").checked = 0
 	           document.getElementById("deleteFld").checked = 0
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
	        height: 275,
	        width: 700,
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
	        	  xmlhttp.open("POST","insertUpdateAccess.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&accessName=" + document.getElementById("accessName").value 
	        			  + "&pageId=" + document.getElementById("pageId").value + "&insertFl=" + document.getElementById("insertFl").checked
	        			  + "&updateFl=" + document.getElementById("updateFl").checked + "&deleteFl=" + document.getElementById("deleteFl").checked);
	        	  
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
	        height: 275,
	        width: 700,
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
	        	  xmlhttp.open("POST","insertUpdateAccess.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&accessName=" + document.getElementById("accessNamee").value 
	        			  + "&pageId=" + document.getElementById("pageIde").value + "&insertFl=" + document.getElementById("insertFle").checked
	        			  + "&updateFl=" + document.getElementById("updateFle").checked + "&deleteFl=" + document.getElementById("deleteFle").checked);
	        	  
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
	        height: 275,
	        width: 700,
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
	        	  xmlhttp.open("POST","insertUpdateAccess.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&accessName=" + document.getElementById("accessNamed").value 
	        			  + "&pageId=" + document.getElementById("pageIdd").value + "&insertFl=" + document.getElementById("insertFld").checked
	        			  + "&updateFl=" + document.getElementById("updateFld").checked + "&deleteFl=" + document.getElementById("deleteFld").checked);
	        	  
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
				<h4 align="Center">Application Page Access </h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="accessName">Role Name</th>
			        	<td data-column-id="pageName" data-identifier="true">Page Name</td>
			            <th data-column-id="insertFl">Insert action</th>
			            <th data-column-id="updateFl">Update action</th>
			            <th data-column-id="deleteFl">Delete action</th>
			            <th data-column-id="id" data-order="desc">Access Id</th>
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
<div id="dialog-add" title="Create Page Access">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="accessName">Role Name</label></td>
					<td>
			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
						<select id="accessName" name="accessName">
						  <c:if test="${not empty Roles}">
								<c:forEach var="listValue" items="${Roles}">
									<option value="${listValue.roleName}">${listValue.roleName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
					<td><label for="pageId">Page Name</label></td>
					<td>
						<select id="pageId" name="pageId">
						  <c:if test="${not empty Pages}">
								<c:forEach var="listValue" items="${Pages}">
									<option value="${listValue.id}">${listValue.pageDisplayName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
		        </tr>
		        <tr>
   		        	<td><label for="insertFl">Insert access</label></td>
		        	<td><input type="checkbox" name="insertFl" id="insertFl" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="updateFl">Update Access</label></td>
		        	<td><input type="checkbox" name="updateFl" id="updateFl" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
				<tr>
					<td><label for="deleteFl">Delete Access</label></td>
		        	<td><input type="checkbox" name="deleteFl" id="deleteFl" class="text ui-widget-content ui-corner-all" ></td>
		        	<td></td>
		        	<td></td>
				</tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Page Access">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="ide">Access Id</label></td>
		        	<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
					<td><label for="accessNamee">Role Name</label></td>
					<td>
						<select id="accessNamee" name="accessNamee">
						  <c:if test="${not empty Roles}">
								<c:forEach var="listValue" items="${Roles}">
									<option value="${listValue.roleName}">${listValue.roleName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
		        </tr>
		        <tr>
					<td><label for="pageIde">Page Name</label></td>
					<td>
						<select id="pageIde" name="pageIde" disabled="disabled">
						  <c:if test="${not empty Pages}">
								<c:forEach var="listValue" items="${Pages}">
									<option value="${listValue.id}">${listValue.pageName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
   		        	<td><label for="insertFle">Insert Access</label></td>
		        	<td><input type="checkbox" name="insertFle" id="insertFle" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
				<tr>
					<td><label for="updateFle">Update Access</label></td>
		        	<td><input type="checkbox" name="updateFle" id="updateFle" class="text ui-widget-content ui-corner-all" ></td>
					<td><label for="deleteFle">Delete Access</label></td>
		        	<td><input type="checkbox" name="deleteFle" id="deleteFle" class="text ui-widget-content ui-corner-all" ></td>
				</tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Page Access">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="idd">Access Id</label></td>
		        	<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
					<td><label for="accessNamed">Role Name</label></td>
					<td>
						<select id="accessNamed" name="accessNamed">
						  <c:if test="${not empty Roles}">
								<c:forEach var="listValue" items="${Roles}">
									<option value="${listValue.roleName}">${listValue.roleName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
		        </tr>
		        <tr>
					<td><label for="pageIdd">Page Name</label></td>
					<td>
						<select id="pageIdd" name="pageIdd" disabled="disabled">
						  <c:if test="${not empty Pages}">
								<c:forEach var="listValue" items="${Pages}">
									<option value="${listValue.id}">${listValue.pageName }</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
   		        	<td><label for="insertFld">Insert Access</label></td>
		        	<td><input type="checkbox" name="insertFld" id="insertFld" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        </tr>
				<tr>
					<td><label for="updateFld">Update Access</label></td>
		        	<td><input type="checkbox" name="updateFld" id="updateFld" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
					<td><label for="deleteFld">Delete Access</label></td>
		        	<td><input type="checkbox" name="deleteFld" id="deleteFld" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
				</tr>
			</table>

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
</body>
</html>