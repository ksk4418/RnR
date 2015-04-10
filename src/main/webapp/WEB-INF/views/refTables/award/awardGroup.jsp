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
           url: "getAwardGroup",
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
           document.getElementById("awardGroupNamee").value = rows[0].awardGroupName
           document.getElementById("awardGroupNamed").value = rows[0].awardGroupName
           document.getElementById("awardGroupDesce").value = rows[0].awardGroupDesc
           document.getElementById("awardGroupDescd").value = rows[0].awardGroupDesc

           document.getElementById("awardIde").value = rows[0].awardId
           document.getElementById("awardIdd").value = rows[0].awardId

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
	        height: 300,
	        width: 550,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroup.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&awardId=" + document.getElementById("awardId").value + "&awardGroupName=" 
	        			  + document.getElementById("awardGroupName").value + "&awardGroupDesc=" + document.getElementById("awardGroupDesc").value);
	        	  
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
	        height: 300,
	        width: 550,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroup.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&awardId=" + document.getElementById("awardIde").value + "&awardGroupName=" 
	        			  + document.getElementById("awardGroupNamee").value + "&awardGroupDesc=" + document.getElementById("awardGroupDesce").value);
	        	  
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
	        height: 300,
	        width: 550,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroup.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&awardId=" + document.getElementById("awardIdd").value + "&awardGroupName=" 
	        			  + document.getElementById("awardGroupNamed").value + "&awardGroupDesc=" + document.getElementById("awardGroupDescd").value);
	        	  
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
				<h4 align="Center">Award Group</h4>
				<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			     <thead>
			        <tr>
			        	<th data-column-id="id" data-identifier="true">Group Id</th>
			            <th data-column-id="awardGroupName">Group Name</th>
			            <th data-column-id="awardGroupDesc">Description</th>
			            <th data-column-id="awardName" data-order="desc">Award Name</th>
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
					<td><label for="awardGroupName">Group Name</label></td>
					<td><input type="text" name="awardGroupName" id="awardGroupName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="awardGroupDesc">Award Desc</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="awardGroupDesc" id="awardGroupDesc" class="text ui-widget-content ui-corner-all" >
   			        </td>
		        </tr>
		        <tr>
		        	<td><label for="awardId">Award:</label></td>
		        	<td>
		        	      <select name="awardId" id="awardId">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
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
  <div id="dialog-edit" title="Edit Award">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td><label for="ide">Group Id</label></td>
		        	<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>		        	
					<td><label for="awardGroupNamee">Group Name</label></td>
					<td><input type="text" name="awardGroupNamee" id="awardGroupNamee" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardGroupDesce">Award Desc</label></td>
		        	<td><input type="text" name="awardGroupDesce" id="awardGroupDesce" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="awardIde">Award:</label></td>
		        	<td>
		        	      <select name="awardIde" id="awardIde" disabled="disabled">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
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
  <div id="dialog-delete" title="Delete Award">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td><label for="idd">Group Id</label></td>
		        	<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>		        	
					<td><label for="awardGroupNamed">Group Name</label></td>
					<td><input type="text" name="awardGroupNamed" id="awardGroupNamed" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardGroupDescd">Award Desc</label></td>
		        	<td><input type="text" name="awardGroupDescd" id="awardGroupDescd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="awardIdd">Award:</label></td>
		        	<td>
		        	      <select name="awardIdd" id="awardIdd" disabled="disabled">
						  <c:if test="${not empty Award}">
								<c:forEach var="listValue" items="${Award}">
									<option value="${listValue.id}">${listValue.awardName }</option>
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
</body>
</html>