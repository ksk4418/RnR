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
           url: "http://localhost:8080/rnr/getEmployeeNames",
           selection: true,
           multiSelect: false,
           rowSelect: true,
           keepSelection: true,
//            formatters: {
// 	           "commands": function(column, row)
// 	           {
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
           document.getElementById("employeeId").value = rows[0].employeeId;
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
	      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
	      name = $( "#name" ),
	      email = $( "#email" ),
	      password = $( "#password" ),
	      allFields = $( [] ).add( name ).add( email ).add( password ),
	      tips = $( ".validateTips" );

	    function updateTips( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }

	    function checkLength( o, n, min, max ) {
	      if ( o.val().length > max || o.val().length < min ) {
	        o.addClass( "ui-state-error" );
	        updateTips( "Length of " + n + " must be between " +
	          min + " and " + max + "." );
	        return false;
	      } else {
	        return true;
	      }
	    }

	    function checkRegexp( o, regexp, n ) {
	      if ( !( regexp.test( o.val() ) ) ) {
	        o.addClass( "ui-state-error" );
	        updateTips( n );
	        return false;
	      } else {
	        return true;
	      }
	    }

	    function addUser() {
	      var valid = true;
	      allFields.removeClass( "ui-state-error" );

	      valid = valid && checkLength( name, "username", 3, 16 );
	      valid = valid && checkLength( email, "email", 6, 80 );
	      valid = valid && checkLength( password, "password", 5, 16 );

	      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
	      valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
	      valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

	      if ( valid ) {
	        $( "#users tbody" ).append( "<tr>" +
	          "<td>" + name.val() + "</td>" +
	          "<td>" + email.val() + "</td>" +
	          "<td>" + password.val() + "</td>" +
	        "</tr>" );
	        dialog.dialog( "close" );
	      }
	      return valid;
	    }
	    dialog = $( "#dialog-form" ).dialog({
	        autoOpen: false,
	        height: 300,
	        width: 350,
	        modal: true,
	        buttons: {
	          "Insert": addUser,
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
	        addUser();
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
			            <th data-column-id="employeeId" data-identifier="true">Member Id</th>
			            <th data-column-id="employeeName">Member Name</th>
			            <th data-column-id="dateOfJoining" data-order="desc">Date of joining</th>
			            <th data-column-id="titleGroup">Title Group</th>
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
<div id="dialog-form" title="Create new user">
  <form>
    <fieldset>
      <label for="employeeId">Employee Id</label>
      <input type="text" name="employeeId" id="employeeId" class="text ui-widget-content ui-corner-all">
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