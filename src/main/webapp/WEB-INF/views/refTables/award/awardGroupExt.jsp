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
           url: "getAwardGroupExt",
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
           document.getElementById("awardGroupExtNamee").value = rows[0].awardGroupExtName
           document.getElementById("awardGroupExtNamed").value = rows[0].awardGroupExtName
           
           document.getElementById("dispMessagee").value = rows[0].displayMessage
           document.getElementById("dispMessaged").value = rows[0].displayMessage

           document.getElementById("fye").value = rows[0].fy
           document.getElementById("fyd").value = rows[0].fy
           
           document.getElementById("qtre").value = rows[0].qtrId
           document.getElementById("qtrd").value = rows[0].qtrId
           
           document.getElementById("awardGroupIde").value = rows[0].awardGroupId
           document.getElementById("awardGroupIdd").value = rows[0].awardGroupId
           
           if(rows[0].openForNominations == 'Y') {
	           document.getElementById("openForNominationse").checked = 1
	           document.getElementById("openForNominationsd").checked = 1
           } else {
	           document.getElementById("openForNominationse").checked = 0
	           document.getElementById("openForNominationsd").checked = 0
           }
           
           if(rows[0].closeNominations == 'Y') {
	           document.getElementById("closeNominationse").checked = 1
	           document.getElementById("closeNominationsd").checked = 1
           } else {
	           document.getElementById("closeNominationse").checked = 0
	           document.getElementById("closeNominationsd").checked = 0
           }
           
           if(rows[0].openPanelGroupReviews == 'Y') {
	           document.getElementById("openPanelGroupReviewse").checked = 1
	           document.getElementById("openPanelGroupReviewsd").checked = 1
           } else {
	           document.getElementById("openPanelGroupReviewse").checked = 0
	           document.getElementById("openPanelGroupReviewsd").checked = 0
           }
           
           if(rows[0].closePanelGroupReviews == 'Y') {
	           document.getElementById("closePanelGroupReviewse").checked = 1
	           document.getElementById("closePanelGroupReviewsd").checked = 1
           } else {
	           document.getElementById("closePanelGroupReviewse").checked = 0
	           document.getElementById("closePanelGroupReviewsd").checked = 0
           }
           
           if(rows[0].publish == 'Y') {
	           document.getElementById("publishe").checked = 1
	           document.getElementById("publishd").checked = 1
           } else {
	           document.getElementById("publishe").checked = 0
	           document.getElementById("publishd").checked = 0
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
	        height: 350,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroupExt.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=1&id=" + document.getElementById("id").value + "&awardGroupExtName=" + document.getElementById("awardGroupExtName").value
	        			  + "&dispMessage=" + document.getElementById("dispMessage").value + "&fy=" + document.getElementById("fy").value
	        			  + "&qtrId=" + document.getElementById("qtr").value + "&awardGroupId=" + document.getElementById("awardGroupId").value
	        			  + "&openForNominations=" + document.getElementById("openForNominations").checked + "&closeNominations=" + document.getElementById("closeNominations").checked
	        			  + "&openPanelGroupReviews=" + document.getElementById("openPanelGroupReviews").checked + "&closePanelGroupReviews=" 
	        			  + document.getElementById("closePanelGroupReviews").checked + "&publish=" + document.getElementById("publish").checked);
	        	  
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
	        height: 350,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroupExt.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=2&id=" + document.getElementById("ide").value + "&awardGroupExtName=" + document.getElementById("awardGroupExtNamee").value
	        			  + "&dispMessage=" + document.getElementById("dispMessagee").value + "&fy=" + document.getElementById("fye").value
	        			  + "&qtrId=" + document.getElementById("qtre").value + "&awardGroupId=" + document.getElementById("awardGroupIde").value
	        			  + "&openForNominations=" + document.getElementById("openForNominationse").checked + "&closeNominations=" + document.getElementById("closeNominationse").checked
	        			  + "&openPanelGroupReviews=" + document.getElementById("openPanelGroupReviewse").checked + "&closePanelGroupReviews=" 
	        			  + document.getElementById("closePanelGroupReviewse").checked + "&publish=" + document.getElementById("publishe").checked);
	        	  
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
	        height: 350,
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
	        	  xmlhttp.open("POST","insertUpdateAwardGroupExt.cgi",false);
	        	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        	  xmlhttp.send("action=3&id=" + document.getElementById("idd").value + "&awardGroupExtName=" + document.getElementById("awardGroupExtNamed").value
	        			  + "&dispMessage=" + document.getElementById("dispMessaged").value + "&fy=" + document.getElementById("fyd").value
	        			  + "&qtrId=" + document.getElementById("qtrd").value + "&awardGroupId=" + document.getElementById("awardGroupIdd").value
	        			  + "&openForNominations=" + document.getElementById("openForNominationsd").checked + "&closeNominations=" + document.getElementById("closeNominationsd").checked
	        			  + "&openPanelGroupReviews=" + document.getElementById("openPanelGroupReviewsd").checked 
	        			  + "&closePanelGroupReviews=" + document.getElementById("closePanelGroupReviewsd").checked + "&publish=" + document.getElementById("publishd").checked);
	        	  
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
				<h4 align="Center">Award Group Maintenance</h4>
				<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
			     <thead>
			        <tr>
<!-- 			        	<th data-column-id="awardGroupExtName" data-identifier="true">Extended Group Name</th> -->
			            <th data-column-id="awardGroupName" >Group Name</th>
			            <th data-column-id="fyQtr" data-identifier="true">FY/Quarter</th>
			            <th data-column-id="openForNominations" >Open nom's</th>
			            <th data-column-id="closeNominations" >Close nom's</th>
			            <th data-column-id="openPanelGroupReviews" >Open for review</th>
			            <th data-column-id="closePanelGroupReviews" >Close reviews</th>
			            <th data-column-id="publish" data-order="desc" >Publish</th>
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
					<td><label for="awardGroupExtName">Group extended Name</label></td>
					<td><input type="text" name="awardGroupExtName" id="awardGroupExtName" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="dispMessage">Display message:</label></td>
		        	<td>
   			        	<input type="hidden" name="id" id="id" class="text ui-widget-content ui-corner-all" >
   			        	<input type="text" name="dispMessage" id="dispMessage" class="text ui-widget-content ui-corner-all" >
   			        </td>
		        </tr>
		        <tr>
		        	<td><label for="fy">Fiscal year</label></td>
		        	<td>
	        	      <select name="fy" id="fy">
						  <c:if test="${not empty FY}">
								<c:forEach var="listValue" items="${FY}">
									<option value="${listValue[1]}">${listValue[1] }</option>
								</c:forEach>
							</c:if>
				      </select>
				    </td>
		        	<td><label for="qtr">Quarter</label></td>
		        	<td>
	        	      <select name="qtr" id="qtr">
						  <c:if test="${not empty Quarter}">
								<c:forEach var="listValue" items="${Quarter}">
									<option value="${listValue.id}">${listValue.quarterName }</option>
								</c:forEach>
							</c:if>
				      </select>	
				    </td>
		        </tr>
		        <tr>
		        	<td><label for="awardGroupId">Award Group:</label></td>
		        	<td>
	        	      <select name="awardGroupId" id="awardGroupId">
						  <c:if test="${not empty AwardGroup}">
								<c:forEach var="listValue" items="${AwardGroup}">
									<option value="${listValue.awardGroupName}">${listValue.awardGroupName }</option>
								</c:forEach>
							</c:if>
				      </select>
				     </td>
				    <td><label for="openForNominations">Open for Nominations</label></td>
		        	<td><input type="checkbox" name="openForNominations" id="openForNominations" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closeNominations">Close Nominations</label></td>
		        	<td><input type="checkbox" name="closeNominations" id="closeNominations" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="openPanelGroupReviews">Open for review</label></td>
		        	<td><input type="checkbox" name="openPanelGroupReviews" id="openPanelGroupReviews" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closePanelGroupReviews">Close reviews</label></td>
		        	<td><input type="checkbox" name="closePanelGroupReviews" id="closePanelGroupReviews" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="publish">Publish results</label></td>
		        	<td><input type="checkbox" name="publish" id="publish" class="text ui-widget-content ui-corner-all" ></td>
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
					<td><label for="awardGroupExtNamee">Group extended Id</label></td>
					<td><input type="text" name="ide" id="ide" class="text ui-widget-content ui-corner-all" ></td>
					<td></td>
					<td></td>
				</tr>
		        <tr>
					<td><label for="awardGroupExtNamee">Group extended Name</label></td>
					<td><input type="text" name="awardGroupExtNamee" id="awardGroupExtNamee" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="dispMessagee">Display message:</label></td>
		        	<td><input type="text" name="dispMessagee" id="dispMessagee" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="fye">Fiscal year</label></td>
		        	<td>
	        	      <select name="fye" id="fye">
						  <c:if test="${not empty FY}">
								<c:forEach var="listValue" items="${FY}">
									<option value="${listValue[1]}">${listValue[1] }</option>
								</c:forEach>
							</c:if>
				      </select>
				    </td>
		        	<td><label for="qtre">Quarter</label></td>
		        	<td>
	        	      <select name="qtre" id="qtre">
						  <c:if test="${not empty Quarter}">
								<c:forEach var="listValue" items="${Quarter}">
									<option value="${listValue.id}">${listValue.quarterName }</option>
								</c:forEach>
							</c:if>
				      </select>	
				    </td>
		        </tr>
		        <tr>
		        	<td><label for="awardGroupIde">Award Group:</label></td>
		        	<td>
	        	      <select name="awardGroupIde" id="awardGroupIde">
						  <c:if test="${not empty AwardGroup}">
								<c:forEach var="listValue" items="${AwardGroup}">
									<option value="${listValue.awardGroupName}">${listValue.awardGroupName }</option>
								</c:forEach>
							</c:if>
				      </select>
				     </td>
				    <td><label for="openForNominationse">Open for Nominations</label></td>
		        	<td><input type="checkbox" name="openForNominationse" id="openForNominationse" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closeNominationse">Close Nominations</label></td>
		        	<td><input type="checkbox" name="closeNominationse" id="closeNominationse" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="openPanelGroupReviewse">Open for review</label></td>
		        	<td><input type="checkbox" name="openPanelGroupReviewse" id="openPanelGroupReviewse" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closePanelGroupReviewse">Close reviews</label></td>
		        	<td><input type="checkbox" name="closePanelGroupReviewse" id="closePanelGroupReviewse" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="publishe">Publish results</label></td>
		        	<td><input type="checkbox" name="publishe" id="publishe" class="text ui-widget-content ui-corner-all" ></td>
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
					<td><label for="awardGroupExtNamed">Group extended Id</label></td>
					<td><input type="text" name="idd" id="idd" class="text ui-widget-content ui-corner-all" ></td>
					<td></td>
					<td></td>
				</tr>
		        <tr>
					<td><label for="awardGroupExtNamed">Group extended Name</label></td>
					<td><input type="text" name="awardGroupExtNamed" id="awardGroupExtNamed" class="text ui-widget-content ui-corner-all"></td>
		        	<td><label for="dispMessaged">Display message:</label></td>
		        	<td>
   			        	<input type="text" name="dispMessaged" id="dispMessaged" class="text ui-widget-content ui-corner-all" >
   			        </td>
		        </tr>
		        <tr>
		        	<td><label for="fyd">Fiscal year</label></td>
		        	<td>
	        	      <select name="fyd" id="fyd">
						  <c:if test="${not empty FY}">
								<c:forEach var="listValue" items="${FY}">
									<option value="${listValue[1]}">${listValue[1] }</option>
								</c:forEach>
							</c:if>
				      </select>
				    </td>
		        	<td><label for="qtrd">Quarter</label></td>
		        	<td>
	        	      <select name="qtrd" id="qtrd">
						  <c:if test="${not empty Quarter}">
								<c:forEach var="listValue" items="${Quarter}">
									<option value="${listValue.id}">${listValue.quarterName }</option>
								</c:forEach>
							</c:if>
				      </select>	
				    </td>
		        </tr>
		        <tr>
		        	<td><label for="awardGroupIdd">Award Group:</label></td>
		        	<td>
	        	      <select name="awardGroupIdd" id="awardGroupIdd">
						  <c:if test="${not empty AwardGroup}">
								<c:forEach var="listValue" items="${AwardGroup}">
									<option value="${listValue.awardGroupName}">${listValue.awardGroupName }</option>
								</c:forEach>
							</c:if>
				      </select>
				     </td>
				    <td><label for="openForNominationsd">Open for Nominations</label></td>
		        	<td><input type="checkbox" name="openForNominationsd" id="openForNominationsd" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closeNominationsd">Close Nominations</label></td>
		        	<td><input type="checkbox" name="closeNominationsd" id="closeNominationsd" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="openPanelGroupReviewsd">Open for review</label></td>
		        	<td><input type="checkbox" name="openPanelGroupReviewsd" id="openPanelGroupReviewsd" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
		        <tr>
		        	<td><label for="closePanelGroupReviewsd">Close reviews</label></td>
		        	<td><input type="checkbox" name="closePanelGroupReviewsd" id="closePanelGroupReviewsd" class="text ui-widget-content ui-corner-all" ></td>
		        	<td><label for="publishd">Publish results</label></td>
		        	<td><input type="checkbox" name="publishd" id="publishd" class="text ui-widget-content ui-corner-all" ></td>
		        </tr>
			</table>

      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px" value="Submit">
    </fieldset>
  </form>
  </div>
</body>
</html>