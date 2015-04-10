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
       //e.stopPropagation();
       $(this).remove();
//        document.getElementById("add").disabled = true;
//        document.getElementById("edit").disabled = true;
//        document.getElementById("delete").disabled = true;
       $("#grid-keep-selection").bootgrid({
           ajax: true,
           post: function ()
           {
               return {
                   id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
               };
           },
           url: "http://localhost:8080/rnr/getCountry",
           selection: true,
           multiSelect: false,
           rowSelect: true,
           keepSelection: true
//            formatters: {
// 	           "commands": function(column, row)
// 	           {
// 	        	   alert(row);
// 	               return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-pencil\"></span></button> " + 
// 	                   "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-trash-o\"></span></button>";
// 	           }
//            }
       }).on("selected.rs.jquery.bootgrid", function(e, rows)
       {
           document.getElementById("add").disabled = false;
           document.getElementById("edit").disabled = false;
           document.getElementById("delete").disabled = false;
           document.getElementById("add").className = document.getElementById("add").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           document.getElementById("edit").className = document.getElementById("edit").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           document.getElementById("delete").className = document.getElementById("delete").className.replace("ui-button-disabled", "").replace("ui-state-disabled", "").replace("  ", " ");
           document.getElementById("id").value = rows[0].id;
       }).on("deselected.rs.jquery.bootgrid", function(e, rows)
       {
        	//As of now not required.
           document.getElementById("add").disabled = true;
           document.getElementById("edit").disabled = true;
           document.getElementById("delete").disabled = true;
       });
       
     });
   $(function() {
	    var dialog, form,

	    dialog = $( "#dialog-form" ).dialog({
	        autoOpen: false,
	        height: 300,
	        width: 350,
	        modal: true,
	        buttons: {
	          "Insert": function() {
	        	  dialog.dialog("close");
	        	  document.url="google.com";
	        	  var press = jQuery.Event("keypress");
	        	  press.keyCode = 13;
	        	  var textBox = document.getElementsByClassName("search-field")[0]; 
	        	  textBox.value =document.getElementById("id").value;
	        	  $(".search-field").trigger(press);
	          },
	          Cancel: function() {
	            dialog.dialog( "close" );
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
		        dialog.dialog( "open" );
		      });
	      $( "#delete" ).button().on( "click", function() {
		        dialog.dialog( "open" );
		      });
	      document.getElementById("add").disabled = true;
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
				<h4 align="Center">Member</h4>
<!-- 		<div class="col-sm-9 main" role="main"> -->
			<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			    <thead>
			        <tr>
			            <th data-column-id="countryName" data-identifier="true">Country Name</th>
			            <th data-column-id="countryID">Country Id</th>
			            <th data-column-id="countryDisplayName">Display Name</th>
			           <!--  <th data-column-id="frequencyId">Title Group</th> -->
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
<div id="dialog-form" title="Create new user">
  <form>
    <fieldset>
      <label for="id">Employee Id</label>
      <input type="text" name="id" id="id" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>
</body>
</html>