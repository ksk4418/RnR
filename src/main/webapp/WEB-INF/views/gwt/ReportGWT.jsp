<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<!-- The DOCTYPE declaration above will set the     -->
<!-- browser's rendering engine into                -->
<!-- "Standards Mode". Replacing this declaration   -->
<!-- with a "Quirks Mode" doctype is not supported. -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href=<c:url value ="/resources/assets/Content/Examples8d63.css"/>  rel="stylesheet" />
<jsp:include page="../commonPages/head.jsp"></jsp:include>
<head>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.11.2.js"></script>
<script src=<c:url value ="/resources/assets/Scripts/Examples46f4" />></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<link href=<c:url value ="/resources/assets/css/cgi-rnr-style.css" />
	rel="stylesheet">
    <link type="text/css" rel="stylesheet" href=<c:url value ="/resources/gwt/ReportGWT.css" />>

    <title></title>
    
    <script type="text/javascript" src=<c:url value ="/resources/gwt/reportgwt/reportgwt.nocache.js" />>
     google.load("visualization", "1", {'packages' : ["corechart"] });
    </script>
    <script>
    $( document ).ready(function(e)
    		   {
    		       //e.stopPropagation();
    		       $(this).remove();
//    		        document.getElementById("add").disabled = true;
//    		        document.getElementById("edit").disabled = true;
//    		        document.getElementById("delete").disabled = true;
    		       $("#grid-keep-selection").bootgrid({
    		           ajax: true,
    		           post: function ()
    		           {
    		               return {
    		                   id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
    		               };
    		           },
    		           url: "getPageLoad",
    		           
    		       });
    		   });
    </script>
  </head>

  <body>
  <div id="wrapper">
<jsp:include page="../commonPages/header.jsp"></jsp:include>
	<jsp:include page="../commonPages/navigationMenu.jsp"></jsp:include>
		<section class="cgi-rnr-main-content">
			<div class="container">
 <div class="row" align="center">
				<h4 align="Center">Report</h4>
	<div  class="table1" align="left">			
<div id="2Parent">
 <table>
 <thead>
  <tr>
 <td><div id="frequencyDrop"></div></td><td><div id="quarterDrop"></div></td><td><div id="halfYearlyDrop"></div></td><td><div id="fromYear"></div></td><td><div id="toYear"></div></td>
 </tr>
 <tr>
 </tr>
 <tr>
 </tr>
 </thead>
 </table>
 </div></div>
 <div class="table2" align="left">
<div id="3Parent">
 <table>
 <thead>
 <tr>
 <td><div id="verticalDrop"></div></td><td><div id="pyramidDrop"></div></td><td><div id="projectDrop"></div></td>
 </tr>
 </thead>
</table>
</div>
</div>
<div id="figures">
<tr>
 <td><div id="memberFigure"></div></td><td><div id="nominationFigure"></div></td><td><div id="awardedFigure"></div></td>
 </tr>
</div>

<div id="gwtContainer"></div>
<div id="message"></div>
    </div>
    </div>
    </section>
    </div>
  </body>
</html>
