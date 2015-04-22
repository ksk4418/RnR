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
           url: "getPages",
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
           document.getElementById("pageNamee").value = rows[0].pageName
           document.getElementById("pageNamed").value = rows[0].pageName
           
           document.getElementById("pathe").value = rows[0].path
           document.getElementById("pathd").value = rows[0].path
           
           document.getElementById("pageDisplayNamee").value = rows[0].pageDisplayName
           document.getElementById("pageDisplayNamed").value = rows[0].pageDisplayName
           
           if(rows[0].activeFl == 'Y') {
	           document.getElementById("activeFle").checked = 1
	           document.getElementById("activeFld").checked = 1
       		} else { 
       			document.getElementById("activeFle").checked = 0
 	           document.getElementById("activeFld").checked = 0
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
	        	  xmlhttp.open("POST","insertUpdatePage.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&pageName=" + document.getElementById("pageName").value 
	        			  + "&activeFl=" + document.getElementById("activeFl").checked + "&path=" + document.getElementById("path").value 
	        			  + "&pageDisplayName=" + document.getElementById("pageDisplayName").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePage.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&pageName=" + document.getElementById("pageNamee").value 
	        			  + "&activeFl=" + document.getElementById("activeFle").checked+ "&path=" + document.getElementById("pathe").value 
	        			  + "&pageDisplayName=" + document.getElementById("pageDisplayNamee").value);
	        	  
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
	        	  xmlhttp.open("POST","insertUpdatePage.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&pageName=" + document.getElementById("pageNamed").value 
						  + "&activeFl=" + document.getElementById("activeFld").checked+ "&path=" + document.getElementById("pathd").value 
						  + "&pageDisplayName=" + document.getElementById("pageDisplayNamed").value);
	        	  
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
				<h4 align="Center">Application Pages</h4>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			        	<th data-column-id="pageName" data-identifier="true">Page Name</th>
			        	<th data-column-id="pageDisplayName" data-identifier="true">Display Name</th>
			        	<th data-column-id="path" data-identifier="true">Path</th>
			            <th data-column-id="activeFl">Active</th>
			            <th data-column-id="id" data-order="desc">Page Id</th>
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
<div id="dialog-add" title="Create Page">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="pageName">Page Name</label></td>
					<td><input type="text" name="pageName" id="pageName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="activeFl">Active</label></td>
		        	<td>
			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
			        	<input type="checkbox" name="activeFl" id="activeFl" class="text ui-widget-content ui-corner-all" >
			        </td>
		        </tr>
		        <tr>
		        	<td><label for="path">Path</label></td>
					<td><input type="text" name="path" id="path" class="text ui-widget-content ui-corner-all"></td>
					<td><label for="pageDisplayName">Display Name</label></td>
					<td><input type="text" name="pageDisplayName" id="pageDisplayName" class="text ui-widget-content ui-corner-all"></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-edit" title="Edit Page">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="pageNamee">Page Name</label></td>
					<td><input type="text" name="pageNamee" id="pageNamee" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="activeFle">Active</label></td>
		        	<td><input type="checkbox" name="activeFle" id="activeFle" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
<!-- 		        	<td><label for="ide">Page ID</label></td> -->
		        	<td><input type="hidden" name="ide" id="ide" class="text ui-widget-content ui-corner-all" readonly="readonly" >
		        	<label for="pageDisplayNamee">Display Name</label></td>
					<td><input type="text" name="pageDisplayNamee" id="pageDisplayNamee" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="pathe">Path</label></td>
					<td><input type="text" name="pathe" id="pathe" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        </tr>
			</table>
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
  <div id="dialog-delete" title="Delete Page">
  <form>
    <fieldset>
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
		        <tr>
					<td><label for="pageNamed">Page Name</label></td>
					<td><input type="text" name="pageNamed" id="pageNamed" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="activeFld">Active</label></td>
		        	<td><input type="checkbox" name="activeFld" id="activeFld" class="text ui-widget-content ui-corner-all" disabled="disabled"></td>
		        </tr>
		        <tr>
<!-- 		        	<td><label for="idd">Page ID</label></td> -->
		        	<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" readonly="readonly" >
		        	<label for="pageDisplayNamed">Display Name</label></td>
					<td><input type="text" name="pageDisplayNamed" id="pageDisplayNamed" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        	<td><label for="pathd">Path</label></td>
					<td><input type="text" name="pathd" id="pathd" class="text ui-widget-content ui-corner-all" readonly="readonly"></td>
		        </tr>
			</table>

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
</body>
</html>