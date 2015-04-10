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
           url: "getQuarter",
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
           document.getElementById("qtre").value = rows[0].qtr
           document.getElementById("qtrd").value = rows[0].qtr
           document.getElementById("quarterNamed").value = rows[0].name
           document.getElementById("quarterNamee").value = rows[0].name
           if(rows[0].openFl == 'Y') {
	           document.getElementById("opene").checked = 1
	           document.getElementById("opend").checked = 1
       		} else { 
       			document.getElementById("opene").checked = 0
 	           document.getElementById("opend").checked = 0
       		}
           if(rows[0].closeFl == 'Y') {
	           document.getElementById("closee").checked = 1
	           document.getElementById("closed").checked = 1
       		} else { 
       			document.getElementById("closee").checked = 0
 	           document.getElementById("closed").checked = 0
       		}
           document.getElementById("fye").value = rows[0].fy
           document.getElementById("fyd").value = rows[0].fy
           
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
	        	  xmlhttp.open("POST","insertUpdateQuarter.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&quarterName=" + document.getElementById("quarterName").value + "&qtr=" 
	        			  + document.getElementById("qtr").value + "&open=" + document.getElementById("open").checked 
	        			  + "&close=" + document.getElementById("close").checked + "&fy=" + document.getElementById("fy").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateQuarter.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&quarterName=" + document.getElementById("quarterNamee").value + "&qtr=" 
	        			  + document.getElementById("qtre").value + "&open=" + document.getElementById("opene").checked 
	        			  + "&close=" + document.getElementById("closee").checked + "&fy=" + document.getElementById("fye").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdateQuarter.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&quarterName=" + document.getElementById("quarterNamed").value + "&qtr=" 
	        			  + document.getElementById("qtrd").value + "&open=" + document.getElementById("opend").checked 
	        			  + "&close=" + document.getElementById("closed").checked + "&fy=" + document.getElementById("fyd").value);
	        	  
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
				<h4 align="Center">Quarter</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="quarterName" data-identifier="true">Quarter</th>
			            <th data-column-id="name">Name</th>
			            <th data-column-id="openFl">Open</th>
			            <th data-column-id="closeFl">Closed</th>
			            <th data-column-id="id">Id</th>
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
<div id="dialog-add" title="Create Quarter">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="fy">Fiscal Year</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="fy" id="fy" class="text ui-widget-content ui-corner-all" >
   			        </td>
					<td><label for="quarterName">Quarter Name</label></td>
					<td><input type="text" name="quarterName" id="quarterName" class="text ui-widget-content ui-corner-all"></td>
		        </tr>
		        <tr>
		        	<td><label for="qtr">Quarter</label></td>
					<td><input type="text" name="qtr" id="qtr" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="open">Open</label></td>
		        	<td><input type="checkbox" name="open" id="open" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
     		    <tr>
     		    	<td><label for="close">Closed</label></td>
		        	<td><input type="checkbox" name="close" id="close" class="text ui-widget-content ui-corner-all" ></td>
		        	<td></td>
		        	<td></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Quarter">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
		        	<td><label for="ide">Id</label></td>
		        	<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="fye">Fiscal Year</label></td>
		        	<td><input type="text" name="fye" id="fye" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
					<td><label for="quarterNamee">Quarter Name</label></td>
					<td><input type="text" name="quarterNamee" id="quarterNamee" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="qtre">Quarter</label></td>
					<td><input type="text" name="qtre" id="qtre" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
     		    <tr>
					<td><label for="opene">Open</label></td>
		        	<td><input type="checkbox" name="opene" id="opene" class="text ui-widget-content ui-corner-all" ></td>
     		    	<td><label for="closee">Closed</label></td>
		        	<td><input type="checkbox" name="closee" id="closee" class="text ui-widget-content ui-corner-all" ></td>
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
		        	<td><label for="idd">Id</label></td>
		        	<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
					<td><label for="fyd">Fiscal Year</label></td>
		        	<td><input type="text" name="fyd" id="fyd" class="text ui-widget-content ui-corner-all"  disabled="disabled"></td>
		        </tr>
		        <tr>
					<td><label for="quarterNamed">Quarter Name</label></td>
					<td><input type="text" name="quarterNamed" id="quarterNamed" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        	<td><label for="qtrd">Quarter</label></td>
					<td><input type="text" name="qtrd" id="qtrd" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
     		    <tr>
					<td><label for="opend">Open</label></td>
		        	<td><input type="checkbox" name="opend" id="opend" class="text ui-widget-content ui-corner-all"  disabled="disabled"></td>
     		    	<td><label for="closed">Closed</label></td>
		        	<td><input type="checkbox" name="closed" id="closed" class="text ui-widget-content ui-corner-all"  disabled="disabled"></td>
		        </tr>
			</table>

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
</div>
</body>
</html>