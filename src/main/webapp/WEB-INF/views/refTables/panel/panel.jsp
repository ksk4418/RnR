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
           url: "getPanel",
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
           
           document.getElementById("ide").value = rows[0].panelId
           document.getElementById("idd").value = rows[0].panelId
           document.getElementById("panelNamee").value = rows[0].panelName
           document.getElementById("panelNamed").value = rows[0].panelName
           document.getElementById("panelDescriptione").value = rows[0].panelDescription
           document.getElementById("panelDescriptiond").value = rows[0].panelDescription
           if(rows[0].autoGenerate == 'Y') {
	           document.getElementById("autoGeneratee").checked = 1
	           document.getElementById("autoGenerated").checked = 1
       		} else { 
       			document.getElementById("autoGeneratee").checked = 0
 	           document.getElementById("autoGenerated").checked = 0
       		}
           document.getElementById("tresholde").value = rows[0].treshold
           document.getElementById("tresholdd").value = rows[0].treshold
           document.getElementById("minExpRequirede").value = rows[0].minExpRequired
           document.getElementById("minExpRequiredd").value = rows[0].minExpRequired
           document.getElementById("titleGroupe").value = rows[0].titleGroup
           document.getElementById("titleGroupd").value = rows[0].titleGroup

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
	        	  xmlhttp.open("POST","insertUpdatePanel.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&panelName=" + document.getElementById("panelName").value + "&panelDescription=" 
	        			  + document.getElementById("panelDescription").value + "&autoGenerate=" + document.getElementById("autoGenerate").checked 
	        			  + "&treshold=" + document.getElementById("treshold").value + "&minExpRequired=" + document.getElementById("minExpRequired").value
	        			  + "&titleGroup=" + document.getElementById("titleGroup").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePanel.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&panelName=" + document.getElementById("panelNamee").value + "&panelDescription=" 
	        			  + document.getElementById("panelDescriptione").value + "&autoGenerate=" + document.getElementById("autoGeneratee").checked 
	        			  + "&treshold=" + document.getElementById("tresholde").value + "&minExpRequired=" + document.getElementById("minExpRequirede").value
	        			  + "&titleGroup=" + document.getElementById("titleGroupe").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePanel.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&panelName=" + document.getElementById("panelNamed").value + "&panelDescription=" 
	        			  + document.getElementById("panelDescriptiond").value + "&autoGenerate=" + document.getElementById("autoGenerated").checked 
	        			  + "&treshold=" + document.getElementById("tresholdd").value + "&minExpRequired=" + document.getElementById("minExpRequiredd").value
	        			  + "&titleGroup=" + document.getElementById("titleGroupd").value);
	        	  
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
				<h4 align="Center">Panel Group</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="panelName" data-identifier="true">Panel Name</th>
			            <th data-column-id="panelDescription">Panel Desc.</th>
			            <th data-column-id="treshold">Threshold</th>
			            <th data-column-id="autoGenerate">Auto Gen</th>
			            <th data-column-id="titleGroup" data-order="asc">Title Group<th>
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
<div id="dialog-add" title="Create Panel Group">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="panelName">Panel Name</label></td>
					<td><input type="text" name="panelName" id="panelName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="panelDescription">Panel Desc.</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="panelDescription" id="panelDescription" class="text ui-widget-content ui-corner-all" >
   			        </td>
		        </tr>
		        <tr>
		        	<td><label for="autoGenerate">Auto Generate</label></td>
		        	<td><input type="checkbox" name="autoGenerate" id="autoGenerate" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="minExpRequired">Experience required in CGI</label></td>
		        	<td>
		        		<select id="minExpRequired" name="minExpRequired">
		        			<option value=0>0 months</option>
		        			<option value=1>6 months</option>
		        			<option value=12>12 months</option>
		        			<option value=18>18 months</option>
		        			<option value=24>24 months</option>
		        			<option value=30>30 months</option>
		        			<option value=36>36 months</option>
		        			<option value=42>42 months</option>
		        			<option value=48>48 months</option>
		        		</select>
		        	</td>
		        </tr>
		        <tr>
					<td><label for="treshold">Threshold</label></td>
					<td><input type="text" name="treshold" id="treshold" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="titleGroup">Title Group</label></td>
		        	<td>
		        		<select id="titleGroup" name="titleGroup">
		        			<option value=1>Title Group 1</option>
		        			<option value=2>Title Group 2</option>
		        			<option value=3>Title Group 3</option>
		        			<option value=4>Title Group 4</option>
		        			<option value=5>Title Group 5</option>
		        		</select>
		        	</td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Panel Group">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
				<tr>
					<td></td>
					<td><label for="ide">Panel Group ID</label></td>
					<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
					<td></td>
				</tr>
		        <tr>
					<td><label for="panelNamee">Panel Name</label></td>
					<td><input type="text" name="panelNamee" id="panelNamee" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="panelDescriptione">Panel Desc.</label></td>
		        	<td><input type="text" name="panelDescriptione" id="panelDescriptione" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="autoGeneratee">Auto Generate</label></td>
		        	<td><input type="checkbox" name="autoGeneratee" id="autoGeneratee" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="minExpRequirede">Experience required in CGI</label></td>
		        	<td>
		        		<select id="minExpRequirede" name="minExpRequirede">
		        			<option value=0>0 months</option>
		        			<option value=1>6 months</option>
		        			<option value=12>12 months</option>
		        			<option value=18>18 months</option>
		        			<option value=24>24 months</option>
		        			<option value=30>30 months</option>
		        			<option value=36>36 months</option>
		        			<option value=42>42 months</option>
		        			<option value=48>48 months</option>
		        		</select>
		        	</td>
		        </tr>
		        <tr>
					<td><label for="tresholde">Threshold</label></td>
					<td><input type="text" name="tresholde" id="tresholde" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="titleGroupe">Title Group</label></td>
		        	<td>
		        		<select id="titleGroupe" name="titleGroupe">
		        			<option value=1>Title Group 1</option>
		        			<option value=2>Title Group 2</option>
		        			<option value=3>Title Group 3</option>
		        			<option value=4>Title Group 4</option>
		        			<option value=5>Title Group 5</option>
		        		</select>
		        	</td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Panel Group">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
				<tr>
					<td></td>
					<td><label for="idd">Panel Group ID</label></td>
					<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" readonly="readonly" ></td>
					<td></td>
				</tr>
		        <tr>
					<td><label for="panelNamed">Panel Name</label></td>
					<td><input type="text" name="panelNamed" id="panelNamed" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="panelDescriptiond">Panel Desc.</label></td>
		        	<td><input type="text" name="panelDescriptiond" id="panelDescriptiond" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        </tr>
		        <tr>
		        	<td><label for="autoGenerated">Auto Generate</label></td>
		        	<td><input type="checkbox" name="autoGenerated" id="autoGenerated" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="minExpRequiredd">Experience required in CGI</label></td>
		        	<td>
		        		<select id="minExpRequiredd" name="minExpRequiredd" disabled="disabled">
		        			<option value=0>0 months</option>
		        			<option value=1>6 months</option>
		        			<option value=12>12 months</option>
		        			<option value=18>18 months</option>
		        			<option value=24>24 months</option>
		        			<option value=30>30 months</option>
		        			<option value=36>36 months</option>
		        			<option value=42>42 months</option>
		        			<option value=48>48 months</option>
		        		</select>
		        	</td>
		        </tr>
		        <tr>
					<td><label for="tresholdd">Threshold</label></td>
					<td><input type="text" name="tresholdd" id="tresholdd" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="titleGroupd">Title Group</label></td>
		        	<td>
		        		<select id="titleGroupd" name="titleGroupd" disabled="disabled">
		        			<option value=1>Title Group 1</option>
		        			<option value=2>Title Group 2</option>
		        			<option value=3>Title Group 3</option>
		        			<option value=4>Title Group 4</option>
		        			<option value=5>Title Group 5</option>
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