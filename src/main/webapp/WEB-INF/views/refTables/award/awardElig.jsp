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
           url: "getAwardEligibility",
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
           
           document.getElementById("ide").value = rows[0].award_ELIG_ID
           document.getElementById("idd").value = rows[0].award_ELIG_ID
//            document.getElementById("awardNamee").value = rows[0].award_NM
//            document.getElementById("awardNamed").value = rows[0].award_NM
           document.getElementById("awardDece").value = rows[0].description
           document.getElementById("awardDecd").value = rows[0].description
           if(rows[0].title_GROUP) {
           	document.getElementById("titleGroupe").value = rows[0].title_GROUP.charAt(14);
           	document.getElementById("titleGroupd").value = rows[0].title_GROUP.charAt(14)
           }
           document.getElementById("awardIde").value = rows[0].award_ID;
           document.getElementById("awardIdd").value = rows[0].award_ID;
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
	        	  xmlhttp.open("POST","insertUpdateAwardElig.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&awardDesc=" 
	        			  + document.getElementById("awardDec").value + "&titleGroup=" + document.getElementById("titleGroup").value 
	        			  + "&awardId=" + document.getElementById("awardId").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateAwardElig.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&awardDesc=" 
	        			  + document.getElementById("awardDece").value + "&titleGroup=" + document.getElementById("titleGroupe").value
	        			  + "&awardId=" + document.getElementById("awardIde").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateAwardElig.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&awardDesc=" 
	        			  + document.getElementById("awardDecd").value + "&titleGroup=" + document.getElementById("titleGroupd").value
	        			  + "&awardId=" + document.getElementById("awardIdd").value);
	        	  
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
				<h4 align="Center">Award Eligibility</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="award_ELIG_ID" data-identifier="true">Id</th>
			            <th data-column-id="award_NM">Award Name</th>
			            <th data-column-id="description">Description</th>
			            <th data-column-id="title_GROUP">Title Group</th>
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
		            <td><label for="id">Eligibility Id: </label></td>
		            <td><input type="text" name="id" id="id" class="text ui-widget-content ui-corner-all" readonly="readonly" value="Auto Generated ID"></td>
					<td><label for="awardId">Award Name</label></td>
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
		        <tr>
		        	<td><label for="awardDec">Award Desc</label></td>
		        	<td><input type="text" name="awardDec" id="awardDec" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="titleGroup">Active</label></td>
		        	<td>
		        	<select name="titleGroup" id="titleGroup">
						<option value="1" selected="selected">Title Group - 1</option>
						<option value="2">Title Group - 2</option>
						<option value="3">Title Group - 3</option>
						<option value="4">Title Group - 4</option>
						<option value="5">Title Group - 5</option>
						<option value="0">Title Group - N/A</option>
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
		            <td><label for="ide">Eligibility Id: </label></td>
		            <td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="awardNamee">Award Name</label></td>
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
		        <tr>
		        	<td><label for="awardDece">Award Desc</label></td>
		        	<td><input type="text" name="awardDece" id="awardDece" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="titleGroupe">Active</label></td>
		        	<td>
		        	<select name="titleGroupe" id="titleGroupe" disabled="disabled">
						<option value="1" selected="selected">Title Group - 1</option>
						<option value="2">Title Group - 2</option>
						<option value="3">Title Group - 3</option>
						<option value="4">Title Group - 4</option>
						<option value="5">Title Group - 5</option>
						<option value="0">Title Group - N/A</option>
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
		            <td><label for="idd">Eligibility Id: </label></td>
		            <td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="awardNamed">Award Name</label></td>
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
		        <tr>
		        	<td><label for="awardDecd">Award Desc</label></td>
		        	<td><input type="text" name="awardDecd" id="awardDecd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="titleGroupd">Active</label></td>
		        	<td>
		        	<select name="titleGroupd" id="titleGroupd" disabled="disabled">
						<option value="1" selected="selected">Title Group - 1</option>
						<option value="2">Title Group - 2</option>
						<option value="3">Title Group - 3</option>
						<option value="4">Title Group - 4</option>
						<option value="5">Title Group - 5</option>
						<option value="0">Title Group - N/A</option>
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