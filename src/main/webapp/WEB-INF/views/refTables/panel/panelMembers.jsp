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
<link href=<c:url value ="/resources/assets/css/cgi-rnr-style.css" /> rel="stylesheet">
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
           url: "getPanelMembers",
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
           
           document.getElementById("ide").value = rows[0].panelMemberId
           document.getElementById("idd").value = rows[0].panelMemberId
           document.getElementById("panelNamee").value = rows[0].panelId
           document.getElementById("panelNamed").value = rows[0].panelId
           document.getElementById("memberIDe").value = rows[0].memberUID
           document.getElementById("memberIDd").value = rows[0].memberUID

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
	        	  xmlhttp.open("POST","insertUpdatePanelMembers.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&panelId=" + document.getElementById("panelName").value + "&memberUID=" 
	        			  + document.getElementById("memberID").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePanelMembers.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&panelId=" + document.getElementById("panelNamee").value + "&memberUID=" 
	        			  + document.getElementById("memberIDe").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePanelMembers.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&panelId=" + document.getElementById("panelNamed").value + "&memberUID=" 
	        			  + document.getElementById("memberIDd").value);
	        	  
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
				<h4 align="Center">Panel Members</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="panelName">Panel Name</th>
			            <th data-column-id="memberUID" data-identifier="true">Panel Member ID</th>
			            <th data-column-id="panelId">Panel Id</th>
			            <th data-column-id="panelMemberId" data-order="asc">ID</th>
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
<div id="dialog-add" title="Assign Member to Panel">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="panelName">Panel Name</label></td>
					<td>
						<select name="panelName" id="panelName">
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
		        	<td><label for="memberID">Member UID</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<select name="memberID" id="memberID">
						  <c:if test="${not empty Member}">
								<c:forEach var="listValue" items="${Member}">
									<option value="${listValue.memberEmail}">${listValue.employeeName }</option>
								</c:forEach>
							</c:if>
					    </select>
   			        </td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Modify Panel Member">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="panelNamee">Panel Name</label></td>
					<td>
						<select name="panelNamee" id="panelNamee" disabled="disabled">
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
		        	<td><label for="memberIDe">Member UID</label></td>
		        	<td>
   			        	<input type="hidden" name="ide" id="ide" class="text ui-widget-content ui-corner-all" >
   			        	<select name="memberIDe" id="memberIDe">
						  <c:if test="${not empty Member}">
								<c:forEach var="listValue" items="${Member}">
									<option value="${listValue.memberEmail}">${listValue.employeeName }</option>
								</c:forEach>
							</c:if>
					    </select>
   			        </td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Panel Member">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="panelNamed">Panel Name</label></td>
					<td>
						<select name="panelNamed" id="panelNamed" disabled="disabled">
						  <c:if test="${not empty Panel}">
								<c:forEach var="listValue" items="${Panel}">
									<option value="${listValue.panelId}">${listValue.panelName }</option>
								</c:forEach>
							</c:if>
					    </select>
					</td>
		        	<td><label for="memberIDd">Member UID</label></td>
		        	<td>
   			        	<input type="hidden" name="idd" id="idd" class="text ui-widget-content ui-corner-all" >
   			        	<select name="memberIDd" id="memberIDd" disabled="disabled">
						  <c:if test="${not empty Member}">
								<c:forEach var="listValue" items="${Member}">
									<option value="${listValue.memberEmail}">${listValue.employeeName }</option>
								</c:forEach>
							</c:if>
					    </select>
   			        </td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
<%--   <jsp:include page="../../commonPages/footer.jsp"></jsp:include> --%>
</body>
</html>