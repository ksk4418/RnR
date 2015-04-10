<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<HTML>
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
           url: "getAwards",
           selection: true,
           multiSelect: false,
           rowSelect: true,
           keepSelection: true
       }).on("selected.rs.jquery.bootgrid", function(e, rows)
       {
           document.getElementById("edit").disabled = false;
           document.getElementById("delete").disabled = false;
           document.getElementById("edit").className = document.getElementById("edit").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           document.getElementById("delete").className = document.getElementById("delete").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           
           document.getElementById("ide").value = rows[0].id
           document.getElementById("idd").value = rows[0].id
           document.getElementById("awardNamee").value = rows[0].awardName
           document.getElementById("awardNamed").value = rows[0].awardName
           document.getElementById("awardDece").value = rows[0].awardDesc
           document.getElementById("awardDecd").value = rows[0].awardDesc
           if(rows[0].activeFl == 'Y') {
	           document.getElementById("activeFle").checked = 1
	           document.getElementById("activeFld").checked = 1
       		} else { 
       			document.getElementById("activeFle").checked = 0
 	           document.getElementById("activeFld").checked = 0
       		}
           document.getElementById("frequencye").value = rows[0].frequencyId
           document.getElementById("frequencyd").value = rows[0].frequencyId
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
// 	          "Insert": function() {
// 	        	  dialog.dialog("close");
// 	        	  var xmlhttp = new XMLHttpRequest();
// 	        	  xmlhttp.onreadystatechange=function()
// 	        	  {
// 	        	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
// 	        	    {
// 	        	    	alert(xmlhttp.responseText);
// 	        	    }
// 	        	  }
// 	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
// 	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
// 	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&awardName=" + document.getElementById("awardName").value + "&awardDesc=" 
// 	        			  + document.getElementById("awardDec").value + "&activeFl=" + document.getElementById("activeFl").checked 
// 	        			  + "&frequency=" + document.getElementById("frequency").value);
	        	  
// 	        	  location.reload();
// 	          },
// 	          Cancel: function() {
// 	            dialog.dialog( "close" );
// 	          }
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
// 	          "Update": function() {
// 	        	  dialog2.dialog("close");

// 	        	  var xmlhttp = new XMLHttpRequest();
// 	        	  xmlhttp.onreadystatechange=function()
// 	        	  {
// 	        	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
// 	        	    {
// 	        	    	alert(xmlhttp.responseText);
// 	        	    }
// 	        	  }
// 	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
// 	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
// 	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&awardName=" + document.getElementById("awardNamee").value + "&awardDesc=" 
// 	        			  + document.getElementById("awardDece").value + "&activeFl=" + document.getElementById("activeFle").checked 
// 	        			  + "&frequency=" + document.getElementById("frequencye").value);
	        	  
// 	        	  location.reload();
// 	          },
// 	          Cancel: function() {
// 	            dialog2.dialog( "close" );
// 	          }
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
// 	          "Delete": function() {
// 	        	  dialog.dialog("close");
	        	  
// 	        	  var xmlhttp = new XMLHttpRequest();
// 	        	  xmlhttp.onreadystatechange=function()
// 	        	  {
// 	        	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
// 	        	    {
// 	        	    	alert(xmlhttp.statusText);
// 	        	    }
// 	        	  }
// 	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
// 	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
// 	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&awardName=" + document.getElementById("awardNamed").value + "&awardDesc=" 
// 	        			  + document.getElementById("awardDecd").value + "&activeFl=" + document.getElementById("activeFld").checked 
// 	        			  + "&frequency=" + document.getElementById("frequencyd").value);
	        	  
// 	        	  location.reload();
// 	          },
// 	          Cancel: function() {
// 	            dialog3.dialog( "close" );
// 	          }
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
	      $( "#cancel" ).button().on( "click", function() {
		        dialog.dialog( "close" );
		      });
	      $( "#cancele" ).button().on( "click", function() {
		        dialog2.dialog( "close" );
		      });
	      $( "#canceld" ).button().on( "click", function() {
		        dialog3.dialog( "close" );
		      });
	      $( "#edit" ).button().on( "click", function() {
		        dialog2.dialog( "open" );
		      });
	      $( "#delete" ).button().on( "click", function() {
		        dialog3.dialog( "open" );
		      });
	      $("#update").hover(function() {
	    	 $(this).addClass("ui-state-hover");
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
				<h4 align="Center">Award Table</h4>
<!-- 		<div class="col-sm-9 main" role="main"> -->
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			            <th data-column-id="awardName" data-identifier="true">Award Name</th>
			            <th data-column-id="id">Award Id</th>
			            <th data-column-id="activeFl">Active</th>
<!-- 			            <th data-column-id="tilteGroup">Title Group</th> -->
			        </tr>
			    </thead>
			</table>
<!-- 		</div> -->
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
  <form method="post" action="insertUpdateAward.cgi">
    <fieldset>
    	<input type="hidden" id="action" name="action" value="1">
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		            <td><label for="id">Award Id: </label></td>
		            <td><input type="text" name="id" id="id" value = "Auto number" class="text ui-widget-content ui-corner-all" readonly="readonly" required="required"></td>
					<td><label for="awardName">Award Name</label></td>
					<td><input type="text" name="awardName" id="awardName" class="text ui-widget-content ui-corner-all" required="required"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardDec">Award Desc</label></td>
		        	<td><input type="text" name="awardDec" id="awardDec" class="text ui-widget-content ui-corner-all" required="required"></td>
		        	<td><label for="activeFl">Active</label></td>
		        	<td><input type="checkbox" name="activeFl" id="activeFl" class="text ui-widget-content ui-corner-all" required="required"></td>
		        </tr>
     		    <tr>
		        	<td><label for="frequency">Frequency</label></td>
		        	<td>
		        	      <select name="frequency" id="frequency">
						  <c:if test="${not empty Frequency}">
								<c:forEach var="listValue" items="${Frequency}">
									<option value="${listValue.id}">${listValue.frequencyName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        </tr>
		        		        <tr>
		        	<td colspan="4"><hr size="30"/></td>
		        </tr>
		        <tr>
		        	<td></td>
		        	<td><input type="submit" value="Insert" id="insert" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" ></td>
		        	<td><input type="button" value="Cancel" id="cancel"></td>
		        	<td></td>
		        	</tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Award">
  <form method="post" action="insertUpdateAward.cgi">
    <fieldset>
    <input type="hidden" id="action" name="action" value="2">
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		            <td><label for="ide">Award Id: </label></td>
		            <td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="awardNamee">Award Name</label></td>
					<td><input type="text" name="awardNamee" id="awardNamee" class="text ui-widget-content ui-corner-all" required="required"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardDece">Award Desc</label></td>
		        	<td><input type="text" name="awardDece" id="awardDece" class="text ui-widget-content ui-corner-all" required="required"></td>
		        	<td><label for="activeFle">Active</label></td>
		        	<td><input type="checkbox" name="activeFle" id="activeFle" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
     		    <tr>
		        	<td><label for="frequencye">Frequency</label></td>
		        	<td>
		        	      <select name="frequencye" id="frequencye">
						  <c:if test="${not empty Frequency}">
								<c:forEach var="listValue" items="${Frequency}">
									<option value="${listValue.id}">${listValue.frequencyName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        </tr>
		        <tr>
		        	<td colspan="4"><hr size="30"/></td>
		        </tr>
		        <tr>
		        	<td></td>
		        	<td><input type="submit" value="Update" id="update" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" ></td>
		        	<td><input type="button" value="Cancel" id="cancele"></td>
		        	<td></td>
		        	</tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Award">
  <form method="get" action="insertUpdateAward.cgi">
    <fieldset>
    <input type="hidden" id="action" name="action" value="3">
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		            <td><label for="idd">Award Id: </label></td>
		            <td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
					<td><label for="awardNamed">Award Name</label></td>
					<td><input type="text" name="awardNamed" id="awardNamed" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardDecd">Award Desc</label></td>
		        	<td><input type="text" name="awardDecd" id="awardDecd" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="activeFld">Active</label></td>
		        	<td><input type="checkbox" name="activeFld" id="activeFld" class="text ui-widget-content ui-corner-all" readonly="readonly" ></td>
		        </tr>
     		    <tr>
		        	<td><label for="frequencyd">Frequency</label></td>
		        	<td>
		        	      <select name="frequencyd" id="frequencyd" readonly="readonly">
						  <c:if test="${not empty Frequency}">
								<c:forEach var="listValue" items="${Frequency}">
									<option value="${listValue.id}">${listValue.frequencyName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
		        	<td></td>
		        	<td></td>
		        </tr>
			</table>
			<table>
		        <tr>
		        	<td colspan="4"><hr size="300" color="black"/></td>
		        </tr>
		        <tr>
		        	<td></td>
		        	<td><input type="submit" value="Delete" id="delete" class="ui-button ui-widget ui-state-default ui-corner-all" role="button" ></td>
		        	<td><input type="button" value="Cancel" id="canceld"></td>
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