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
           url: "getAwards",
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
           document.getElementById("awardTypee").value = rows[0].awardTypeId
           document.getElementById("awardTyped").value = rows[0].awardTypeId
           document.getElementById("minRolee").value = rows[0].minimumRoleId
           document.getElementById("minRoled").value = rows[0].minimumRoleId
//            document.getElementById("maxRolee").value = rows[0].maximumRoleId
//            document.getElementById("maxRoled").value = rows[0].maximumRoleId
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
	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&awardName=" + document.getElementById("awardName").value + "&awardDesc=" 
	        			  + document.getElementById("awardDec").value + "&activeFl=" + document.getElementById("activeFl").checked 
	        			  + "&frequency=" + document.getElementById("frequency").value + "&minRoleId=" + document.getElementById("minRole").value
// 	        			  + "&maxRoleId=" + document.getElementById("maxRole").value
	        			  + "&awardTypeId=" + document.getElementById("awardType").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&awardName=" + document.getElementById("awardNamee").value + "&awardDesc=" 
	        			  + document.getElementById("awardDece").value + "&activeFl=" + document.getElementById("activeFle").checked 
	        			  + "&frequency=" + document.getElementById("frequencye").value + "&minRoleId=" + document.getElementById("minRolee").value
// 	        			  + "&maxRoleId=" + document.getElementById("maxRolee").value
	        			  + "&awardTypeId=" + document.getElementById("awardTypee").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateAward.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&awardName=" + document.getElementById("awardNamed").value + "&awardDesc=" 
	        			  + document.getElementById("awardDecd").value + "&activeFl=" + document.getElementById("activeFld").checked 
	        			  + "&frequency=" + document.getElementById("frequencyd").value + "&minRoleId=" + document.getElementById("minRoled").value
// 	        			  + "&maxRoleId=" + document.getElementById("maxRoled").value
	        			  + "&awardTypeId=" + document.getElementById("awardTyped").value);
	        	  
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
			        	<th data-column-id="id" data-identifier="true">Award Id</th>
			            <th data-column-id="awardName">Award Name</th>
			            <th data-column-id="activeFl">Active</th>
			            <th data-column-id="freqName">Frequency</th>
			            <th data-column-id="minimumRole">Min. Role</th>
<!-- 			            <th data-column-id="maximumRole">Max. Role</th> -->
			            <th data-column-id="awardType" data-order="desc">Type</th>
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
					<td><label for="awardName">Award Name</label></td>
					<td><input type="text" name="awardName" id="awardName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="awardDec">Award Desc</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="awardDec" id="awardDec" class="text ui-widget-content ui-corner-all" >
   			        </td>
		        </tr>
		        <tr>
		        	<td><label for="activeFl">Active</label></td>
		        	<td><input type="checkbox" name="activeFl" id="activeFl" class="text ui-widget-content ui-corner-all" ></td>
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
		        </tr>
     		    <tr>
		        <td><label for="awardType">Award Type</label></td>
		        	<td>
		        	      <select name="awardType" id="awardType">
							<option value="1">INDIVIDUAL</option>
							<option value="2">TEAM</option>
							<option value="3">ENGAGEMENT</option>
							<option value="4">OTHERS</option>
					      </select>
		        	</td>
		        <td><label for="minRole">Min. role to nominate</label></td>
		        	<td>
		        	      <select name="minRole" id="minRole">
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
<!-- 		        <tr> -->
<!-- 		        <td><label for="maxRole">Max. role</label></td> -->
<!-- 		        	<td> -->
<!-- 		        	      <select name="maxRole" id="maxRole"> -->
<!-- 							<option value="1">MEMBER</option> -->
<!-- 							<option value="2">RM</option> -->
<!-- 							<option value="3">PM</option> -->
<!-- 							<option value="4">SPM</option> -->
<!-- 							<option value="5">ED</option> -->
<!-- 							<option value="6">GH</option> -->
<!-- 							<option value="7">GL</option> -->
<!-- 							<option value="8">SGL</option> -->
<!-- 					      </select> -->
<!-- 		        	</td> -->
<!-- 		        	<td></td> -->
<!-- 		        	<td></td> -->
<!-- 		        </tr> -->
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
		            <td><label for="ide">Award Id: </label></td>
		            <td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="awardNamee">Award Name</label></td>
					<td><input type="text" name="awardNamee" id="awardNamee" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardDece">Award Desc</label></td>
		        	<td><input type="text" name="awardDece" id="awardDece" class="text ui-widget-content ui-corner-all" ></td>
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
					<td><label for="awardTypee">Award Type</label></td>
		        	<td>
		        	      <select name="awardTypee" id="awardTypee">
							<option value="1">INDIVIDUAL</option>
							<option value="2">TEAM</option>
							<option value="3">ENGAGEMENT</option>
							<option value="4">OTHERS</option>
					      </select>
		        	</td>
		        </tr>
		        <tr>
		        <td><label for="minRolee">Min. role to nominate</label></td>
		        	<td>
		        	      <select name="minRolee" id="minRolee">
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
		        	<td></td>
<!-- 		        	<td><label for="maxRolee">Max. role</label></td> -->
		        	<td>
<!-- 		        	      <select name="maxRolee" id="maxRolee"> -->
<!-- 							<option value="1">MEMBER</option> -->
<!-- 							<option value="2">RM</option> -->
<!-- 							<option value="3">PM</option> -->
<!-- 							<option value="4">SPM</option> -->
<!-- 							<option value="5">ED</option> -->
<!-- 							<option value="6">GH</option> -->
<!-- 							<option value="7">GL</option> -->
<!-- 							<option value="8">SGL</option> -->
<!-- 					      </select> -->
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
		            <td><label for="idd">Award Id: </label></td>
		            <td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="awardNamed">Award Name</label></td>
					<td><input type="text" name="awardNamed" id="awardNamed" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
		        	<td><label for="awardDecd">Award Desc</label></td>
		        	<td><input type="text" name="awardDecd" id="awardDecd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="activeFld">Active</label></td>
		        	<td><input type="checkbox" name="activeFld" id="activeFld" class="text ui-widget-content ui-corner-all" disabled="disabled" ></td>
		        </tr>
     		    <tr>
		        	<td><label for="frequencyd">Frequency</label></td>
		        	<td>
		        	      <select name="frequencyd" id="frequencyd" disabled="disabled">
						  <c:if test="${not empty Frequency}">
								<c:forEach var="listValue" items="${Frequency}">
									<option value="${listValue.id}">${listValue.frequencyName }</option>
								</c:forEach>
							</c:if>
					      	
					      </select>
		        	</td>
					<td><label for="awardTyped">Award Type</label></td>
		        	<td>
		        	      <select name="awardTyped" id="awardTyped" disabled="disabled">
							<option value="1">INDIVIDUAL</option>
							<option value="2">TEAM</option>
							<option value="3">ENGAGEMENT</option>
							<option value="4">OTHERS</option>
					      </select>
		        	</td>
		        </tr>
       		    <tr>
		        <td><label for="minRoled">Min. role to nominate</label></td>
		        	<td>
		        	      <select name="minRoled" id="minRoled" disabled="disabled">
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
		        	<td></td>
<!-- 		        	<td><label for="maxRoled">Max. role</label></td> -->
		        	<td>
<!-- 		        	      <select name="maxRoled" id="maxRoled" disabled="disabled"> -->
<!-- 							<option value="1">MEMBER</option> -->
<!-- 							<option value="2">RM</option> -->
<!-- 							<option value="3">PM</option> -->
<!-- 							<option value="4">SPM</option> -->
<!-- 							<option value="5">ED</option> -->
<!-- 							<option value="6">GH</option> -->
<!-- 							<option value="7">GL</option> -->
<!-- 							<option value="8">SGL</option> -->
<!-- 					      </select> -->
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