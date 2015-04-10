//v1.0
//Copyright 2006 Adobe Systems, Inc. All rights reserved.
function AC_AddExtension(src, ext)
{
  if (src.indexOf('?') != -1)
    return src.replace(/\?/, ext+'?'); 
  else
    return src + ext;
}

function AC_Generateobj(objAttrs, params, embedAttrs) 
{ 
  var str = '<object ';
  for (var i in objAttrs)
    str += i + '="' + objAttrs[i] + '" ';
  str += '>';
  for (var i in params)
    str += '<param name="' + i + '" value="' + params[i] + '" /> ';
  str += '<embed ';
  for (var i in embedAttrs)
    str += i + '="' + embedAttrs[i] + '" ';
  str += ' ></embed></object>';

  document.write(str);
}

function AC_FL_RunContent(){
  var ret = 
    AC_GetArgs
    (  arguments, ".swf", "movie", "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
     , "application/x-shockwave-flash"
    );
  AC_Generateobj(ret.objAttrs, ret.params, ret.embedAttrs);
}

function AC_SW_RunContent(){
  var ret = 
    AC_GetArgs
    (  arguments, ".dcr", "src", "clsid:166B1BCA-3F9C-11CF-8075-444553540000"
     , null
    );
  AC_Generateobj(ret.objAttrs, ret.params, ret.embedAttrs);
}

function AC_GetArgs(args, ext, srcParamName, classid, mimeType){
  var ret = new Object();
  ret.embedAttrs = new Object();
  ret.params = new Object();
  ret.objAttrs = new Object();
  for (var i=0; i < args.length; i=i+2){
    var currArg = args[i].toLowerCase();    

    switch (currArg){	
      case "classid":
        break;
      case "pluginspage":
        ret.embedAttrs[args[i]] = args[i+1];
        break;
      case "src":
      case "movie":	
        args[i+1] = AC_AddExtension(args[i+1], ext);
        ret.embedAttrs["src"] = args[i+1];
        ret.params[srcParamName] = args[i+1];
        break;
      case "onafterupdate":
      case "onbeforeupdate":
      case "onblur":
      case "oncellchange":
      case "onclick":
      case "ondblClick":
      case "ondrag":
      case "ondragend":
      case "ondragenter":
      case "ondragleave":
      case "ondragover":
      case "ondrop":
      case "onfinish":
      case "onfocus":
      case "onhelp":
      case "onmousedown":
      case "onmouseup":
      case "onmouseover":
      case "onmousemove":
      case "onmouseout":
      case "onkeypress":
      case "onkeydown":
      case "onkeyup":
      case "onload":
      case "onlosecapture":
      case "onpropertychange":
      case "onreadystatechange":
      case "onrowsdelete":
      case "onrowenter":
      case "onrowexit":
      case "onrowsinserted":
      case "onstart":
      case "onscroll":
      case "onbeforeeditfocus":
      case "onactivate":
      case "onbeforedeactivate":
      case "ondeactivate":
      case "type":
      case "codebase":
        ret.objAttrs[args[i]] = args[i+1];
        break;
      case "width":
      case "height":
      case "align":
      case "vspace": 
      case "hspace":
      case "class":
      case "title":
      case "accesskey":
      case "name":
      case "id":
      case "tabindex":
        ret.embedAttrs[args[i]] = ret.objAttrs[args[i]] = args[i+1];
        break;
      default:
        ret.embedAttrs[args[i]] = ret.params[args[i]] = args[i+1];
    }
  }
  ret.objAttrs["classid"] = classid;
  if (mimeType) ret.embedAttrs["type"] = mimeType;
  return ret;
}
;
/*	SWFObject v2.2 <http://code.google.com/p/swfobject/>
	is released under the MIT License <http://www.opensource.org/licenses/mit-license.php>
*/
var swfobject=function(){var D="undefined",r="object",S="Shockwave Flash",W="ShockwaveFlash.ShockwaveFlash",q="application/x-shockwave-flash",R="SWFObjectExprInst",x="onreadystatechange",O=window,j=document,t=navigator,T=false,U=[h],o=[],N=[],I=[],l,Q,E,B,J=false,a=false,n,G,m=true,M=function(){var aa=typeof j.getElementById!=D&&typeof j.getElementsByTagName!=D&&typeof j.createElement!=D,ah=t.userAgent.toLowerCase(),Y=t.platform.toLowerCase(),ae=Y?/win/.test(Y):/win/.test(ah),ac=Y?/mac/.test(Y):/mac/.test(ah),af=/webkit/.test(ah)?parseFloat(ah.replace(/^.*webkit\/(\d+(\.\d+)?).*$/,"$1")):false,X=!+"\v1",ag=[0,0,0],ab=null;if(typeof t.plugins!=D&&typeof t.plugins[S]==r){ab=t.plugins[S].description;if(ab&&!(typeof t.mimeTypes!=D&&t.mimeTypes[q]&&!t.mimeTypes[q].enabledPlugin)){T=true;X=false;ab=ab.replace(/^.*\s+(\S+\s+\S+$)/,"$1");ag[0]=parseInt(ab.replace(/^(.*)\..*$/,"$1"),10);ag[1]=parseInt(ab.replace(/^.*\.(.*)\s.*$/,"$1"),10);ag[2]=/[a-zA-Z]/.test(ab)?parseInt(ab.replace(/^.*[a-zA-Z]+(.*)$/,"$1"),10):0}}else{if(typeof O.ActiveXObject!=D){try{var ad=new ActiveXObject(W);if(ad){ab=ad.GetVariable("$version");if(ab){X=true;ab=ab.split(" ")[1].split(",");ag=[parseInt(ab[0],10),parseInt(ab[1],10),parseInt(ab[2],10)]}}}catch(Z){}}}return{w3:aa,pv:ag,wk:af,ie:X,win:ae,mac:ac}}(),k=function(){if(!M.w3){return}if((typeof j.readyState!=D&&j.readyState=="complete")||(typeof j.readyState==D&&(j.getElementsByTagName("body")[0]||j.body))){f()}if(!J){if(typeof j.addEventListener!=D){j.addEventListener("DOMContentLoaded",f,false)}if(M.ie&&M.win){j.attachEvent(x,function(){if(j.readyState=="complete"){j.detachEvent(x,arguments.callee);f()}});if(O==top){(function(){if(J){return}try{j.documentElement.doScroll("left")}catch(X){setTimeout(arguments.callee,0);return}f()})()}}if(M.wk){(function(){if(J){return}if(!/loaded|complete/.test(j.readyState)){setTimeout(arguments.callee,0);return}f()})()}s(f)}}();function f(){if(J){return}try{var Z=j.getElementsByTagName("body")[0].appendChild(C("span"));Z.parentNode.removeChild(Z)}catch(aa){return}J=true;var X=U.length;for(var Y=0;Y<X;Y++){U[Y]()}}function K(X){if(J){X()}else{U[U.length]=X}}function s(Y){if(typeof O.addEventListener!=D){O.addEventListener("load",Y,false)}else{if(typeof j.addEventListener!=D){j.addEventListener("load",Y,false)}else{if(typeof O.attachEvent!=D){i(O,"onload",Y)}else{if(typeof O.onload=="function"){var X=O.onload;O.onload=function(){X();Y()}}else{O.onload=Y}}}}}function h(){if(T){V()}else{H()}}function V(){var X=j.getElementsByTagName("body")[0];var aa=C(r);aa.setAttribute("type",q);var Z=X.appendChild(aa);if(Z){var Y=0;(function(){if(typeof Z.GetVariable!=D){var ab=Z.GetVariable("$version");if(ab){ab=ab.split(" ")[1].split(",");M.pv=[parseInt(ab[0],10),parseInt(ab[1],10),parseInt(ab[2],10)]}}else{if(Y<10){Y++;setTimeout(arguments.callee,10);return}}X.removeChild(aa);Z=null;H()})()}else{H()}}function H(){var ag=o.length;if(ag>0){for(var af=0;af<ag;af++){var Y=o[af].id;var ab=o[af].callbackFn;var aa={success:false,id:Y};if(M.pv[0]>0){var ae=c(Y);if(ae){if(F(o[af].swfVersion)&&!(M.wk&&M.wk<312)){w(Y,true);if(ab){aa.success=true;aa.ref=z(Y);ab(aa)}}else{if(o[af].expressInstall&&A()){var ai={};ai.data=o[af].expressInstall;ai.width=ae.getAttribute("width")||"0";ai.height=ae.getAttribute("height")||"0";if(ae.getAttribute("class")){ai.styleclass=ae.getAttribute("class")}if(ae.getAttribute("align")){ai.align=ae.getAttribute("align")}var ah={};var X=ae.getElementsByTagName("param");var ac=X.length;for(var ad=0;ad<ac;ad++){if(X[ad].getAttribute("name").toLowerCase()!="movie"){ah[X[ad].getAttribute("name")]=X[ad].getAttribute("value")}}P(ai,ah,Y,ab)}else{p(ae);if(ab){ab(aa)}}}}}else{w(Y,true);if(ab){var Z=z(Y);if(Z&&typeof Z.SetVariable!=D){aa.success=true;aa.ref=Z}ab(aa)}}}}}function z(aa){var X=null;var Y=c(aa);if(Y&&Y.nodeName=="OBJECT"){if(typeof Y.SetVariable!=D){X=Y}else{var Z=Y.getElementsByTagName(r)[0];if(Z){X=Z}}}return X}function A(){return !a&&F("6.0.65")&&(M.win||M.mac)&&!(M.wk&&M.wk<312)}function P(aa,ab,X,Z){a=true;E=Z||null;B={success:false,id:X};var ae=c(X);if(ae){if(ae.nodeName=="OBJECT"){l=g(ae);Q=null}else{l=ae;Q=X}aa.id=R;if(typeof aa.width==D||(!/%$/.test(aa.width)&&parseInt(aa.width,10)<310)){aa.width="310"}if(typeof aa.height==D||(!/%$/.test(aa.height)&&parseInt(aa.height,10)<137)){aa.height="137"}j.title=j.title.slice(0,47)+" - Flash Player Installation";var ad=M.ie&&M.win?"ActiveX":"PlugIn",ac="MMredirectURL="+O.location.toString().replace(/&/g,"%26")+"&MMplayerType="+ad+"&MMdoctitle="+j.title;if(typeof ab.flashvars!=D){ab.flashvars+="&"+ac}else{ab.flashvars=ac}if(M.ie&&M.win&&ae.readyState!=4){var Y=C("div");X+="SWFObjectNew";Y.setAttribute("id",X);ae.parentNode.insertBefore(Y,ae);ae.style.display="none";(function(){if(ae.readyState==4){ae.parentNode.removeChild(ae)}else{setTimeout(arguments.callee,10)}})()}u(aa,ab,X)}}function p(Y){if(M.ie&&M.win&&Y.readyState!=4){var X=C("div");Y.parentNode.insertBefore(X,Y);X.parentNode.replaceChild(g(Y),X);Y.style.display="none";(function(){if(Y.readyState==4){Y.parentNode.removeChild(Y)}else{setTimeout(arguments.callee,10)}})()}else{Y.parentNode.replaceChild(g(Y),Y)}}function g(ab){var aa=C("div");if(M.win&&M.ie){aa.innerHTML=ab.innerHTML}else{var Y=ab.getElementsByTagName(r)[0];if(Y){var ad=Y.childNodes;if(ad){var X=ad.length;for(var Z=0;Z<X;Z++){if(!(ad[Z].nodeType==1&&ad[Z].nodeName=="PARAM")&&!(ad[Z].nodeType==8)){aa.appendChild(ad[Z].cloneNode(true))}}}}}return aa}function u(ai,ag,Y){var X,aa=c(Y);if(M.wk&&M.wk<312){return X}if(aa){if(typeof ai.id==D){ai.id=Y}if(M.ie&&M.win){var ah="";for(var ae in ai){if(ai[ae]!=Object.prototype[ae]){if(ae.toLowerCase()=="data"){ag.movie=ai[ae]}else{if(ae.toLowerCase()=="styleclass"){ah+=' class="'+ai[ae]+'"'}else{if(ae.toLowerCase()!="classid"){ah+=" "+ae+'="'+ai[ae]+'"'}}}}}var af="";for(var ad in ag){if(ag[ad]!=Object.prototype[ad]){af+='<param name="'+ad+'" value="'+ag[ad]+'" />'}}aa.outerHTML='<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"'+ah+">"+af+"</object>";N[N.length]=ai.id;X=c(ai.id)}else{var Z=C(r);Z.setAttribute("type",q);for(var ac in ai){if(ai[ac]!=Object.prototype[ac]){if(ac.toLowerCase()=="styleclass"){Z.setAttribute("class",ai[ac])}else{if(ac.toLowerCase()!="classid"){Z.setAttribute(ac,ai[ac])}}}}for(var ab in ag){if(ag[ab]!=Object.prototype[ab]&&ab.toLowerCase()!="movie"){e(Z,ab,ag[ab])}}aa.parentNode.replaceChild(Z,aa);X=Z}}return X}function e(Z,X,Y){var aa=C("param");aa.setAttribute("name",X);aa.setAttribute("value",Y);Z.appendChild(aa)}function y(Y){var X=c(Y);if(X&&X.nodeName=="OBJECT"){if(M.ie&&M.win){X.style.display="none";(function(){if(X.readyState==4){b(Y)}else{setTimeout(arguments.callee,10)}})()}else{X.parentNode.removeChild(X)}}}function b(Z){var Y=c(Z);if(Y){for(var X in Y){if(typeof Y[X]=="function"){Y[X]=null}}Y.parentNode.removeChild(Y)}}function c(Z){var X=null;try{X=j.getElementById(Z)}catch(Y){}return X}function C(X){return j.createElement(X)}function i(Z,X,Y){Z.attachEvent(X,Y);I[I.length]=[Z,X,Y]}function F(Z){var Y=M.pv,X=Z.split(".");X[0]=parseInt(X[0],10);X[1]=parseInt(X[1],10)||0;X[2]=parseInt(X[2],10)||0;return(Y[0]>X[0]||(Y[0]==X[0]&&Y[1]>X[1])||(Y[0]==X[0]&&Y[1]==X[1]&&Y[2]>=X[2]))?true:false}function v(ac,Y,ad,ab){if(M.ie&&M.mac){return}var aa=j.getElementsByTagName("head")[0];if(!aa){return}var X=(ad&&typeof ad=="string")?ad:"screen";if(ab){n=null;G=null}if(!n||G!=X){var Z=C("style");Z.setAttribute("type","text/css");Z.setAttribute("media",X);n=aa.appendChild(Z);if(M.ie&&M.win&&typeof j.styleSheets!=D&&j.styleSheets.length>0){n=j.styleSheets[j.styleSheets.length-1]}G=X}if(M.ie&&M.win){if(n&&typeof n.addRule==r){n.addRule(ac,Y)}}else{if(n&&typeof j.createTextNode!=D){n.appendChild(j.createTextNode(ac+" {"+Y+"}"))}}}function w(Z,X){if(!m){return}var Y=X?"visible":"hidden";if(J&&c(Z)){c(Z).style.visibility=Y}else{v("#"+Z,"visibility:"+Y)}}function L(Y){var Z=/[\\\"<>\.;]/;var X=Z.exec(Y)!=null;return X&&typeof encodeURIComponent!=D?encodeURIComponent(Y):Y}var d=function(){if(M.ie&&M.win){window.attachEvent("onunload",function(){var ac=I.length;for(var ab=0;ab<ac;ab++){I[ab][0].detachEvent(I[ab][1],I[ab][2])}var Z=N.length;for(var aa=0;aa<Z;aa++){y(N[aa])}for(var Y in M){M[Y]=null}M=null;for(var X in swfobject){swfobject[X]=null}swfobject=null})}}();return{registerObject:function(ab,X,aa,Z){if(M.w3&&ab&&X){var Y={};Y.id=ab;Y.swfVersion=X;Y.expressInstall=aa;Y.callbackFn=Z;o[o.length]=Y;w(ab,false)}else{if(Z){Z({success:false,id:ab})}}},getObjectById:function(X){if(M.w3){return z(X)}},embedSWF:function(ab,ah,ae,ag,Y,aa,Z,ad,af,ac){var X={success:false,id:ah};if(M.w3&&!(M.wk&&M.wk<312)&&ab&&ah&&ae&&ag&&Y){w(ah,false);K(function(){ae+="";ag+="";var aj={};if(af&&typeof af===r){for(var al in af){aj[al]=af[al]}}aj.data=ab;aj.width=ae;aj.height=ag;var am={};if(ad&&typeof ad===r){for(var ak in ad){am[ak]=ad[ak]}}if(Z&&typeof Z===r){for(var ai in Z){if(typeof am.flashvars!=D){am.flashvars+="&"+ai+"="+Z[ai]}else{am.flashvars=ai+"="+Z[ai]}}}if(F(Y)){var an=u(aj,am,ah);if(aj.id==ah){w(ah,true)}X.success=true;X.ref=an}else{if(aa&&A()){aj.data=aa;P(aj,am,ah,ac);return}else{w(ah,true)}}if(ac){ac(X)}})}else{if(ac){ac(X)}}},switchOffAutoHideShow:function(){m=false},ua:M,getFlashPlayerVersion:function(){return{major:M.pv[0],minor:M.pv[1],release:M.pv[2]}},hasFlashPlayerVersion:F,createSWF:function(Z,Y,X){if(M.w3){return u(Z,Y,X)}else{return undefined}},showExpressInstall:function(Z,aa,X,Y){if(M.w3&&A()){P(Z,aa,X,Y)}},removeSWF:function(X){if(M.w3){y(X)}},createCSS:function(aa,Z,Y,X){if(M.w3){v(aa,Z,Y,X)}},addDomLoadEvent:K,addLoadEvent:s,getQueryParamValue:function(aa){var Z=j.location.search||j.location.hash;if(Z){if(/\?/.test(Z)){Z=Z.split("?")[1]}if(aa==null){return L(Z)}var Y=Z.split("&");for(var X=0;X<Y.length;X++){if(Y[X].substring(0,Y[X].indexOf("="))==aa){return L(Y[X].substring((Y[X].indexOf("=")+1)))}}}return""},expressInstallCallback:function(){if(a){var X=c(R);if(X&&l){X.parentNode.replaceChild(l,X);if(Q){w(Q,true);if(M.ie&&M.win){l.style.display="block"}}if(E){E(B)}}a=false}}}}();;

(function($){$.extend({tablesorter:new function(){var parsers=[],widgets=[];this.defaults={cssHeader:"header",cssAsc:"headerSortUp",cssDesc:"headerSortDown",sortInitialOrder:"asc",sortMultiSortKey:"shiftKey",sortForce:null,sortAppend:null,textExtraction:"simple",parsers:{},widgets:[],widgetZebra:{css:["even","odd"]},headers:{},widthFixed:false,cancelSelection:true,sortList:[],headerList:[],dateFormat:"us",decimal:'.',debug:false};function benchmark(s,d){log(s+","+(new Date().getTime()-d.getTime())+"ms");}this.benchmark=benchmark;function log(s){if(typeof console!="undefined"&&typeof console.debug!="undefined"){console.log(s);}else{alert(s);}}function buildParserCache(table,$headers){if(table.config.debug){var parsersDebug="";}var rows=table.tBodies[0].rows;if(table.tBodies[0].rows[0]){var list=[],cells=rows[0].cells,l=cells.length;for(var i=0;i<l;i++){var p=false;if($.metadata&&($($headers[i]).metadata()&&$($headers[i]).metadata().sorter)){p=getParserById($($headers[i]).metadata().sorter);}else if((table.config.headers[i]&&table.config.headers[i].sorter)){p=getParserById(table.config.headers[i].sorter);}if(!p){p=detectParserForColumn(table,cells[i]);}if(table.config.debug){parsersDebug+="column:"+i+" parser:"+p.id+"\n";}list.push(p);}}if(table.config.debug){log(parsersDebug);}return list;};function detectParserForColumn(table,node){var l=parsers.length;for(var i=1;i<l;i++){if(parsers[i].is($.trim(getElementText(table.config,node)),table,node)){return parsers[i];}}return parsers[0];}function getParserById(name){var l=parsers.length;for(var i=0;i<l;i++){if(parsers[i].id.toLowerCase()==name.toLowerCase()){return parsers[i];}}return false;}function buildCache(table){if(table.config.debug){var cacheTime=new Date();}var totalRows=(table.tBodies[0]&&table.tBodies[0].rows.length)||0,totalCells=(table.tBodies[0].rows[0]&&table.tBodies[0].rows[0].cells.length)||0,parsers=table.config.parsers,cache={row:[],normalized:[]};for(var i=0;i<totalRows;++i){var c=table.tBodies[0].rows[i],cols=[];cache.row.push($(c));for(var j=0;j<totalCells;++j){cols.push(parsers[j].format(getElementText(table.config,c.cells[j]),table,c.cells[j]));}cols.push(i);cache.normalized.push(cols);cols=null;};if(table.config.debug){benchmark("Building cache for "+totalRows+" rows:",cacheTime);}return cache;};function getElementText(config,node){if(!node)return"";var t="";if(config.textExtraction=="simple"){if(node.childNodes[0]&&node.childNodes[0].hasChildNodes()){t=node.childNodes[0].innerHTML;}else{t=node.innerHTML;}}else{if(typeof(config.textExtraction)=="function"){t=config.textExtraction(node);}else{t=$(node).text();}}return t;}function appendToTable(table,cache){if(table.config.debug){var appendTime=new Date()}var c=cache,r=c.row,n=c.normalized,totalRows=n.length,checkCell=(n[0].length-1),tableBody=$(table.tBodies[0]),rows=[];for(var i=0;i<totalRows;i++){rows.push(r[n[i][checkCell]]);if(!table.config.appender){var o=r[n[i][checkCell]];var l=o.length;for(var j=0;j<l;j++){tableBody[0].appendChild(o[j]);}}}if(table.config.appender){table.config.appender(table,rows);}rows=null;if(table.config.debug){benchmark("Rebuilt table:",appendTime);}applyWidget(table);setTimeout(function(){$(table).trigger("sortEnd");},0);};function buildHeaders(table){if(table.config.debug){var time=new Date();}var meta=($.metadata)?true:false,tableHeadersRows=[];for(var i=0;i<table.tHead.rows.length;i++){tableHeadersRows[i]=0;};$tableHeaders=$("thead th",table);$tableHeaders.each(function(index){this.count=0;this.column=index;this.order=formatSortingOrder(table.config.sortInitialOrder);if(checkHeaderMetadata(this)||checkHeaderOptions(table,index))this.sortDisabled=true;if(!this.sortDisabled){$(this).addClass(table.config.cssHeader);}table.config.headerList[index]=this;});if(table.config.debug){benchmark("Built headers:",time);log($tableHeaders);}return $tableHeaders;};function checkCellColSpan(table,rows,row){var arr=[],r=table.tHead.rows,c=r[row].cells;for(var i=0;i<c.length;i++){var cell=c[i];if(cell.colSpan>1){arr=arr.concat(checkCellColSpan(table,headerArr,row++));}else{if(table.tHead.length==1||(cell.rowSpan>1||!r[row+1])){arr.push(cell);}}}return arr;};function checkHeaderMetadata(cell){if(($.metadata)&&($(cell).metadata().sorter===false)){return true;};return false;}function checkHeaderOptions(table,i){if((table.config.headers[i])&&(table.config.headers[i].sorter===false)){return true;};return false;}function applyWidget(table){var c=table.config.widgets;var l=c.length;for(var i=0;i<l;i++){getWidgetById(c[i]).format(table);}}function getWidgetById(name){var l=widgets.length;for(var i=0;i<l;i++){if(widgets[i].id.toLowerCase()==name.toLowerCase()){return widgets[i];}}};function formatSortingOrder(v){if(typeof(v)!="Number"){i=(v.toLowerCase()=="desc")?1:0;}else{i=(v==(0||1))?v:0;}return i;}function isValueInArray(v,a){var l=a.length;for(var i=0;i<l;i++){if(a[i][0]==v){return true;}}return false;}function setHeadersCss(table,$headers,list,css){$headers.removeClass(css[0]).removeClass(css[1]);var h=[];$headers.each(function(offset){if(!this.sortDisabled){h[this.column]=$(this);}});var l=list.length;for(var i=0;i<l;i++){h[list[i][0]].addClass(css[list[i][1]]);}}function fixColumnWidth(table,$headers){var c=table.config;if(c.widthFixed){var colgroup=$('<colgroup>');$("tr:first td",table.tBodies[0]).each(function(){colgroup.append($('<col>').css('width',$(this).width()));});$(table).prepend(colgroup);};}function updateHeaderSortCount(table,sortList){var c=table.config,l=sortList.length;for(var i=0;i<l;i++){var s=sortList[i],o=c.headerList[s[0]];o.count=s[1];o.count++;}}function multisort(table,sortList,cache){if(table.config.debug){var sortTime=new Date();}var dynamicExp="var sortWrapper = function(a,b) {",l=sortList.length;for(var i=0;i<l;i++){var c=sortList[i][0];var order=sortList[i][1];var s=(getCachedSortType(table.config.parsers,c)=="text")?((order==0)?"sortText":"sortTextDesc"):((order==0)?"sortNumeric":"sortNumericDesc");var e="e"+i;dynamicExp+="var "+e+" = "+s+"(a["+c+"],b["+c+"]); ";dynamicExp+="if("+e+") { return "+e+"; } ";dynamicExp+="else { ";}var orgOrderCol=cache.normalized[0].length-1;dynamicExp+="return a["+orgOrderCol+"]-b["+orgOrderCol+"];";for(var i=0;i<l;i++){dynamicExp+="}; ";}dynamicExp+="return 0; ";dynamicExp+="}; ";eval(dynamicExp);cache.normalized.sort(sortWrapper);if(table.config.debug){benchmark("Sorting on "+sortList.toString()+" and dir "+order+" time:",sortTime);}return cache;};function sortText(a,b){return((a<b)?-1:((a>b)?1:0));};function sortTextDesc(a,b){return((b<a)?-1:((b>a)?1:0));};function sortNumeric(a,b){return a-b;};function sortNumericDesc(a,b){return b-a;};function getCachedSortType(parsers,i){return parsers[i].type;};this.construct=function(settings){return this.each(function(){if(!this.tHead||!this.tBodies)return;var $this,$document,$headers,cache,config,shiftDown=0,sortOrder;this.config={};config=$.extend(this.config,$.tablesorter.defaults,settings);$this=$(this);$headers=buildHeaders(this);this.config.parsers=buildParserCache(this,$headers);cache=buildCache(this);var sortCSS=[config.cssDesc,config.cssAsc];fixColumnWidth(this);$headers.click(function(e){$this.trigger("sortStart");var totalRows=($this[0].tBodies[0]&&$this[0].tBodies[0].rows.length)||0;if(!this.sortDisabled&&totalRows>0){var $cell=$(this);var i=this.column;this.order=this.count++%2;if(!e[config.sortMultiSortKey]){config.sortList=[];if(config.sortForce!=null){var a=config.sortForce;for(var j=0;j<a.length;j++){if(a[j][0]!=i){config.sortList.push(a[j]);}}}config.sortList.push([i,this.order]);}else{if(isValueInArray(i,config.sortList)){for(var j=0;j<config.sortList.length;j++){var s=config.sortList[j],o=config.headerList[s[0]];if(s[0]==i){o.count=s[1];o.count++;s[1]=o.count%2;}}}else{config.sortList.push([i,this.order]);}};setTimeout(function(){setHeadersCss($this[0],$headers,config.sortList,sortCSS);appendToTable($this[0],multisort($this[0],config.sortList,cache));},1);return false;}}).mousedown(function(){if(config.cancelSelection){this.onselectstart=function(){return false};return false;}});$this.bind("update",function(){this.config.parsers=buildParserCache(this,$headers);cache=buildCache(this);}).bind("sorton",function(e,list){$(this).trigger("sortStart");config.sortList=list;var sortList=config.sortList;updateHeaderSortCount(this,sortList);setHeadersCss(this,$headers,sortList,sortCSS);appendToTable(this,multisort(this,sortList,cache));}).bind("appendCache",function(){appendToTable(this,cache);}).bind("applyWidgetId",function(e,id){getWidgetById(id).format(this);}).bind("applyWidgets",function(){applyWidget(this);});if($.metadata&&($(this).metadata()&&$(this).metadata().sortlist)){config.sortList=$(this).metadata().sortlist;}if(config.sortList.length>0){$this.trigger("sorton",[config.sortList]);}applyWidget(this);});};this.addParser=function(parser){var l=parsers.length,a=true;for(var i=0;i<l;i++){if(parsers[i].id.toLowerCase()==parser.id.toLowerCase()){a=false;}}if(a){parsers.push(parser);};};this.addWidget=function(widget){widgets.push(widget);};this.formatFloat=function(s){var i=parseFloat(s);return(isNaN(i))?0:i;};this.formatInt=function(s){var i=parseInt(s);return(isNaN(i))?0:i;};this.isDigit=function(s,config){var DECIMAL='\\'+config.decimal;var exp='/(^[+]?0('+DECIMAL+'0+)?$)|(^([-+]?[1-9][0-9]*)$)|(^([-+]?((0?|[1-9][0-9]*)'+DECIMAL+'(0*[1-9][0-9]*)))$)|(^[-+]?[1-9]+[0-9]*'+DECIMAL+'0+$)/';return RegExp(exp).test($.trim(s));};this.clearTableBody=function(table){if($.browser.msie){function empty(){while(this.firstChild)this.removeChild(this.firstChild);}empty.apply(table.tBodies[0]);}else{table.tBodies[0].innerHTML="";}};}});$.fn.extend({tablesorter:$.tablesorter.construct});var ts=$.tablesorter;ts.addParser({id:"text",is:function(s){return true;},format:function(s){return $.trim(s.toLowerCase());},type:"text"});ts.addParser({id:"digit",is:function(s,table){var c=table.config;return $.tablesorter.isDigit(s,c);},format:function(s){return $.tablesorter.formatFloat(s);},type:"numeric"});ts.addParser({id:"currency",is:function(s){return/^[£$€?.]/.test(s);},format:function(s){return $.tablesorter.formatFloat(s.replace(new RegExp(/[^0-9.]/g),""));},type:"numeric"});ts.addParser({id:"ipAddress",is:function(s){return/^\d{2,3}[\.]\d{2,3}[\.]\d{2,3}[\.]\d{2,3}$/.test(s);},format:function(s){var a=s.split("."),r="",l=a.length;for(var i=0;i<l;i++){var item=a[i];if(item.length==2){r+="0"+item;}else{r+=item;}}return $.tablesorter.formatFloat(r);},type:"numeric"});ts.addParser({id:"url",is:function(s){return/^(https?|ftp|file):\/\/$/.test(s);},format:function(s){return jQuery.trim(s.replace(new RegExp(/(https?|ftp|file):\/\//),''));},type:"text"});ts.addParser({id:"isoDate",is:function(s){return/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/.test(s);},format:function(s){return $.tablesorter.formatFloat((s!="")?new Date(s.replace(new RegExp(/-/g),"/")).getTime():"0");},type:"numeric"});ts.addParser({id:"percent",is:function(s){return/\%$/.test($.trim(s));},format:function(s){return $.tablesorter.formatFloat(s.replace(new RegExp(/%/g),""));},type:"numeric"});ts.addParser({id:"usLongDate",is:function(s){return s.match(new RegExp(/^[A-Za-z]{3,10}\.? [0-9]{1,2}, ([0-9]{4}|'?[0-9]{2}) (([0-2]?[0-9]:[0-5][0-9])|([0-1]?[0-9]:[0-5][0-9]\s(AM|PM)))$/));},format:function(s){return $.tablesorter.formatFloat(new Date(s).getTime());},type:"numeric"});ts.addParser({id:"shortDate",is:function(s){return/\d{1,2}[\/\-]\d{1,2}[\/\-]\d{2,4}/.test(s);},format:function(s,table){var c=table.config;s=s.replace(/\-/g,"/");if(c.dateFormat=="us"){s=s.replace(/(\d{1,2})[\/\-](\d{1,2})[\/\-](\d{4})/,"$3/$1/$2");}else if(c.dateFormat=="uk"){s=s.replace(/(\d{1,2})[\/\-](\d{1,2})[\/\-](\d{4})/,"$3/$2/$1");}else if(c.dateFormat=="dd/mm/yy"||c.dateFormat=="dd-mm-yy"){s=s.replace(/(\d{1,2})[\/\-](\d{1,2})[\/\-](\d{2})/,"$1/$2/$3");}return $.tablesorter.formatFloat(new Date(s).getTime());},type:"numeric"});ts.addParser({id:"time",is:function(s){return/^(([0-2]?[0-9]:[0-5][0-9])|([0-1]?[0-9]:[0-5][0-9]\s(am|pm)))$/.test(s);},format:function(s){return $.tablesorter.formatFloat(new Date("2000/01/01 "+s).getTime());},type:"numeric"});ts.addParser({id:"metadata",is:function(s){return false;},format:function(s,table,cell){var c=table.config,p=(!c.parserMetadataName)?'sortValue':c.parserMetadataName;return $(cell).metadata()[p];},type:"numeric"});ts.addWidget({id:"zebra",format:function(table){if(table.config.debug){var time=new Date();}$("tr:visible",table.tBodies[0]).filter(':even').removeClass(table.config.widgetZebra.css[1]).addClass(table.config.widgetZebra.css[0]).end().filter(':odd').removeClass(table.config.widgetZebra.css[0]).addClass(table.config.widgetZebra.css[1]);if(table.config.debug){$.tablesorter.benchmark("Applying Zebra widget",time);}}});})(jQuery);;
(function($){
	$.fn.tablePager = function(options) 
	{
		/*	Default values
		*/
		var defaults = {
			offset: 0, //where to start
			limit: 40, // how many rows each page
			language: false,
			placeTop: false // place pager links over the table?
		};
		
		var options = $.extend(defaults, options);
		this.each(function() 
		{
			/* We wrap the table with a div, so that we can use that div as reference point for all other functions... neat!
			*/
			$(this).wrap("<div>");
		
							
			/*	Plugin variables
			*/
			var parent = $(this).parent();
			var table = $("table", parent);
			var rows = $("tbody > tr", table);
			var totalItems = rows.length;
			var totalPages = Math.ceil((totalItems / options.limit));
			var currentPage = 1;
			
			/*	If the total amount of rows is bigger than the defined limit for each page, we do anything;
			*/
			if (totalItems > options.limit)
			{
				/*	Did we have more than 1 page?, if yes, create some page links ;-)
				*/
				var pages = "";
				var values = "";
								
				/*	HTML Layout for the links
				*/
				var tb = $("<div id='jPaginate'></div><br />");
	
				/*	Appending it to the DOM
				*/
				if(options.placeTop)
				{
					table.before(tb);
				}
				else
				{
					table.after(tb);
				}				
				var bootOptions = {
		                currentPage: 1,
		                totalPages: totalPages,
		                numberOfPages: 7,
		                size:'normal',
		                alignment:'right',
		                onPageClicked: function(e,originalEvent,type,page){
		                	options.offset = (page-1)*options.limit;
							currentPage = currentPage-(currentPage-this.id);
							parent.renderTable();
		                }
		            }

		        $('#jPaginate').bootstrapPaginator(bootOptions);				
			
			}
			
			/*	And finally we try to sort out witch rows should be visible ;-)
			*/
			parent.renderTable = function ()
			{
				var currentItem = 0;
				
				$(".pagerLinks *", parent).removeClass("active");
				$("#"+currentPage+"", parent).addClass("active");
				
				/*	So, if we are at last page we hide the next link ;-)
				*/
				if (currentPage == totalPages) 
				{
					$(".nextPage", parent).css("visibility", "hidden");
				} 
				else 
				{
					$(".nextPage", parent).css("visibility", "visible");
				}
						
				/*	If we are at first page we hide the prev link
				*/
				if (currentPage == 1) 
				{
					$(".previousPage", parent).css("visibility", "hidden");
				} 
				else 
				{
					$(".previousPage", parent).css("visibility", "visible");
				}			
				
				/*	Run through all rows and check what we want to show
				*/
				rows.each
				(
					function()
					{
						obj = $(this);
		
						if (currentItem >= options.offset && currentItem < (options.offset+options.limit))
						{
							obj.show();	
						}
						else
						{
							obj.hide();	
						}
						
						currentItem++;
					}
				);
			}
			
			/*	Initialize on page load
			*/
			parent.renderTable();
		});
  };  
})(jQuery);  ;
/*
 * Custom CGI javascript goes here
 */
var $ = jQuery.noConflict();


$(document).ready(function () {

    jQuery.fn.exists = function () {
        return this.length > 0;
    }

    var lang = Drupal.settings.swflang;
    var language = '';
    if (lang == 'fr') {
        language = lang;
    }
    
    //var lang = $('html').attr('xml:lang');
	if($('body').hasClass('page-mediacentre')) {
		$('.page-mediacentre .region-content').isotope({
  	    	itemSelector: '.block-views'
		})
	};
	
	 $("#filter_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
	 $("#filter_table_video").tablePager({
	        offset: 0,
	        limit: 5,
	        language: language
	    });	 
	 /*Pagination for Events table - C2-0051082*/
	 $("#events_table").tablePager({
		 offset: 0,
	     limit: 40,
	     language: language
	 });
	 
	 $("#content_globalnews").tablePager({
	        offset: 0,
	        limit: 8,
	        language: language
	    });
    
    $('.openinshadowbox').click(function (e) {
        e.preventDefault();
        $('#sb-container').addClass('logica-css');
        var nid = $(this).attr("nid");
        var url = '/en/only_content/' + nid;
        if (language == 'fr') {
            url = '/fr/only_content/' + nid;
        }
        $.ajax({
            type: 'POST',
            url: url,
            success: function (data) {
                $('#fullview_' + nid).css('display', 'none');
                $('#fullview_' + nid).html(data.value);

                $('#next').live('click', function () {
                    var nid = $(this).attr('nid');
                    var url = '/en/only_content/' + nid;
                    if (language == 'fr') {
                        url = '/fr/only_content/' + nid;
                    }
                    $.ajax({
                        type: 'POST',
                        url: url,
                        success: function (data) {
                            $('.latestcontent').html(data.value);
                        },
                        dataType: 'json'
                    });
                });
                $('#previous').live('click', function () {
                    var nid = $(this).attr('nid');
                    var url = '/en/only_content/' + nid;
                    if (language == 'fr') {
                        url = '/fr/only_content/' + nid;
                    }
                    $.ajax({
                        type: 'POST',
                        url: url,
                        success: function (data) {
                            $('.latestcontent').html(data.value);
                        },
                        dataType: 'json'
                    });
                });
                Shadowbox.open({
                    content: $('#fullview_' + nid).html(),
                    player: "html",
                    height: 600,
                    width: 765,
                    options: {
                        onClose: function () {
                            $('#sb-container').removeClass('logica-css');
                            $('#next').die('click');
                        }
                    }
                });
            },
            dataType: 'json'
        });
    });



    //generic slideToggle effect for all sections
    $('p.stLink').click(function () {
        var contentID = $(this).next().attr("id");
        var toggleID = $(this).children().attr("id");
        var backgroundID = $(this).attr("id");
        var promoID;

        // If visible, slide Up
        if ( $("div#" + contentID).is(":visible") ) {
            // SlideUp, then replace [-] with [+]
            $("div#" + contentID).slideUp("slow", function() {
                $("span#" + toggleID).removeClass("togOpen").addClass("togClose");
                $("p#" + backgroundID).removeClass("stTabOpen").addClass("stTabClose");
            });
        } else {
            // Replace [+] with [-], then SlideDown           
            $("span#" + toggleID).removeClass("togClose").addClass("togOpen");
            $("p#" + backgroundID).removeClass("stTabClose").addClass("stTabOpen");

            $("div#" + contentID).slideDown("slow");
        }

    });


    //the slideToggle effect for IT Outsourcing
    $('p.gdmLink').click(function () {

        var contentID = $(this).next().attr("id");
        var toggleID = $(this).children().attr("id");
        var backgroundID = $(this).attr("id");
        
        var promoID;

        if (contentID == "c1") {
            promoID = "link1";
        } else if (contentID == "c2") {
            promoID = "link2";
        } else if (contentID == "c3") {
            promoID = "link3";
        } else {
            promoID = "link4";
        }

        // If visible, slide Up
        if ( $("div#" + contentID).is(":visible") ) {
            // SlideUp, then replace [-] with [+]
            $("div#" + contentID).slideUp("slow", function() {
                $("span#" + toggleID).removeClass("toggleOpen").addClass("toggleClosed");
                $("p#" + backgroundID).removeClass("openTab").addClass("closeTab");
                $("a#" + promoID).css("color", "#363636");
            });
        } else {
            // Replace [+] with [-], then SlideDown
            $("span#" + toggleID).removeClass("toggleClosed").addClass("toggleOpen");
            $("p#" + backgroundID).removeClass("closeTab").addClass("openTab");
            $("a#" + promoID).css("color", "#040404");

            $("div#" + contentID).slideDown("slow");
        }
    });


    //Cgi at a glance & Hiring Process
    $('#glance div.container, #careerTabs div.container').hide(); // Hide all divs
    $('#glance div.container:first, #careerTabs div.container:first').show(); // Show the first div
    $('#glance ul li:first,#careerTabs ul li:first').addClass('active'); // Set the class of the first link to active

    $('#glance ul li a.step,#careerTabs ul li a.step').click(function () { //When any link is clicked
        $('#glance ul li,#careerTabs ul li').removeClass('active'); // Remove active class from all links
        $(this).parent().addClass('active'); //Set clicked link class to active
        var currentTab = $(this).attr('href'); // Set variable currentTab to value of href attribute of clicked link
        $('#glance div.container, #careerTabs div.container').hide(); // Hide all divs
        $(currentTab).show(); // Show div with id equal to variable currentTab
        return false;
    });


    if ($('#block-i18npoll-0').length > 0) {
        equalHeight($("#block-block-7 .v-divider , #block-block-24 .ContentMenu , #block-i18npoll-0"));
    } else {
        equalHeight($("#block-block-7 .v-divider , #block-block-24 .ContentMenu"));
    }

    $("div#InvestorAnnouncementBgFr .ClickMe").click(function () {
        window.location = "/fr/CGI-sonne-la-cloche-de-cloture-a-la-Bourse-de-New-York";
        return false;
    });

    $("div#InvestorAnnouncementBgEn .ClickMe").click(function () {
        window.location = "/en/CGI-rings-NYSE-closing-bell";
        return false;
    });

     /*CSR Policy Toggle*/

    $(".open-message").click(function () {
        $(".open-message").hide();
        $(".message-container").show();
    });

	 $(".close-message").click(function () {
        $(".message-container").hide();
		$(".open-message").show();
    });

    /*CAREER FILTER TOGGLE*/
    $(".filter-country").click(function () {
        $(".ticker .filter").toggleClass('filtershow');
    });

    $(".filter span.close").click(function () {
        $(".filter").toggleClass('filtershow');
    });
	
	/*Toggle class*/
	$( ".click-collapse" ).click(function() {
  		$( ".content-collapse" ).toggle( "fast", function() {
   		 // Animation complete.
		 var image = $(".click-collapse").find("span").attr("class");
		 if(image == "minus"){
				$(".minus").toggleClass("plus","fast")
			}else if (image == "minus plus"){
				$(".minus").toggleClass("plus","fast")
			}
  		});
	});

    // Creating hoverscroll with fixed arrows
    $('#opp-list').hoverscroll({
        vertical: true,
        // Display the list vertically or horizontally
        width: 300,
        // Width of the list container
        height: 195,
        // Height of the list container
        arrows: true,
        // Display direction indicator arrows or not
        arrowsOpacity: 1,
        // Max possible opacity of the arrows
        fixedArrows: true,
        // Fixed arrows on the sides of the list (disables arrowsOpacity)
        rtl: false,
        // Print images from right to left
        debug: false // Debug output in the firebug console
    });

    //FILTER
    $('#country-list').hoverscroll({
        vertical: true,
        // Display the list vertically or horizontally
        width: 135,
        // Width of the list container
        height: 213,
        // Height of the list container
        arrows: true,
        // Display direction indicator arrows or not
        arrowsOpacity: 1,
        // Max possible opacity of the arrows
        fixedArrows: true,
        // Fixed arrows on the sides of the list (disables arrowsOpacity)
        rtl: false,
        // Print images from right to left
        debug: false // Debug output in the firebug console
    });
    // Starting the movement automatically at loading
    // @param direction: right/bottom = 1, left/top = -1
    // @param speed: Speed of the animation (scrollPosition += direction * speed)
    var direction = 0,
        speed = 3;
    /*RTC no.99773 SH - configure job feed on DK site to only display DK jobs */
    if ($('#opp-list').length) {
        $("#opp-list")[0].startMoving(direction, speed);
    }
    if($('#country-list').length) {
    	$("#country-list")[0].startMoving(direction, speed);
    }

    $('#sorrypage').click(function (e) {
        e.preventDefault();
        var url = '/sorrypage/get/french';
        if (language == 'fr') {
            url = '/fr/sorrypage/get/english';
        }
        var nodeid = $('#sorrypage').attr('nodeid');
        $.ajax({
            type: 'POST',
            url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
            data: "nid=" + nodeid,
            success: function (data) {
                $('#content-area').html(data.sorrypage).parent().find("#sidebar-right").hide();
            }, // The js function that will be called upon success request
            dataType: 'json' //define the type of data that is going to get back from the server
            // data: 'js=1' //Pass a key/value pair
        });
    });

    $.fn.updateCategory = function () {
        $('#categorySelect').change(function (e) {
            var url = '/products/get/' + $('#categorySelect').val();
            e.preventDefault();
            if (language == 'fr') {
                url = '/fr' + url;
            }
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categorySelect').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/products\/get/ig, "infrastructure-services/case-studies"));
                    }
                    $("#case_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updateCategory();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }

    $.fn.updateAnnounceCategory = function () {
        $('#categorymedia').change(function (e) {
            var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'announce/get/' + $('#categorymedia').val();
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categorymedia').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/announce\/get/ig, "infrastructure-services/media-announcements"));
                    }
                    $("#announce_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updateAnnounceCategory();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }

    $.fn.updatewhiteCategory = function () {
        $('#categoryWhite').change(function (e) {
            var url = '/white/get/' + $('#categoryWhite').val();
            if (language == 'fr') {
                url = '/fr' + url;
            }
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categoryWhite').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/white\/get/ig, "infrastructure-services/white-papers"));
                    }
                    $("#white_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updatewhiteCategory();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }

    $.fn.updatewhite2Category = function () {
        $('#categoryWhite2').change(function (e) {
            var url = '/white2/get/' + $('#categoryWhite2').val();
            e.preventDefault();
            if (language == 'fr') { 
                url = '/fr' + url;
            }
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categoryWhite2').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/white2\/get/ig, "infrastructure-services/white-papers"));
                    }
                    $("#white2_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updatewhite2Category();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }

    $.fn.updatebrochureCategory = function () {
        $('#categoryBrochure').change(function (e) {
            var url = '/brochure/get/' + $('#categoryBrochure').val();
            e.preventDefault();
            if (language == 'fr') {
                url = '/fr' + url;
            }
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categoryBrochure').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/brochure\/get/ig, "infrastructure-services/brochures"));
                    }
                    $("#brochure_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updatebrochureCategory();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }

    $.fn.updatebrochure2Category = function () {
        $('#categoryBrochure2').change(function (e) {
            var url = '/brochure2/get/' + $('#categoryBrochure2').val();
            e.preventDefault();
            if (language == 'fr') {
                url = '/fr' + url;
            }
            $.ajax({
                type: 'POST',
                url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
                success: function (data) {
                    $('#content-area').html(data.products);

                    $('#categoryBrochure2').val(data.selcat);
                    if ($('.item-list .pager').length > 0) {
                        $('.item-list .pager').html($('.item-list .pager').html().replace(/brochure2\/get/ig, "infrastructure-services/brochures"));
                    }
                    $("#brochure2_table").tablePager({
                        offset: 0,
                        limit: 40,
                        language: language
                    });
                    $('#sidebar-left-inner').height($('#content').height());
                    $(this).updatebrochure2Category();
                }, // The js function that will be called upon success request
                dataType: 'json' //define the type of data that is going to get back from the server
                // data: 'js=1' //Pass a key/value pair
            });
        });
    }
    $(this).updateCategory();
    $(this).updateAnnounceCategory();
    $(this).updatewhiteCategory();
    $(this).updatewhite2Category();
    $(this).updatebrochureCategory();
    $(this).updatebrochure2Category();
    $("#brochure_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $("#brochure2_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $("#white_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $("#white2_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $("#announce_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $("#case_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });


    $('a.outboundEn').attr({
        href: "https://cgi.njoyn.com/CGI/xweb/xweb.asp?page=joblisting&CLID=21001&Lang=1&sbdid=20464&utm_source=CGI&utm_medium=Careers%2BSection&utm_campaign=Revamp"
    });

    $('a.outboundFr').attr({
        href: "https://cgi.njoyn.com/CGI/xweb/xweb.asp?page=joblisting&CLID=21001&Lang=2&sbdid=20464&utm_source=CGI&utm_medium=Careers%2BSection&utm_campaign=Revamp"
    });
    $('a.outboundDe').attr({
        href: "https://cgi.njoyn.com/CGI/xweb/xweb.asp?page=joblisting&CLID=21001&Lang=2&countryid=de&sbdid=20464&utm_source=CGI&utm_medium=Careers%2BSection&utm_campaign=Revamp"
    });

    $('a.outboundEn, a.outboundFr, a.outboundDe').click(function (e) {
        e.preventDefault();
        _gat._getTrackerByName()._trackEvent('Njoyn Links', 'njoyn.com');
        var redirectUrl = $(this).attr('href');
        setTimeout(function () {
            window.open(redirectUrl, '_blank');
        }, 100);

    });

    // call the tablesorter plugin 
    $("#banking_table").tablesorter({
        sortList: [
            [0, 0]
        ]
    });

    //.tablesorterPager({container: $("#pager")}); 
    var object2 = {
        language: language
    };

    $("#banking_table").tablePager({
        offset: 0,
        limit: 40,
        language: language
    });
    $('#sidebar-left-inner').height($('#content').height());

    //To open the all pdf in next window
    $('a[href$=".pdf"]').attr('target', '_blank');
    $('a[href$=".pdf"]').removeAttr('onclick');
    var value;
    var newvalue;
    value = $('a[href$=".xls"]').attr('href');
    if (value) {
        newvalue = value.replace("cgi/xls", "sites/default/files/xls");
        $('a[href$=".xls"]').attr('href', newvalue);
    }
    if (($('.webform-confirmation h4').html() == 'Disclaimer') || ($('.webform-confirmation h4').html() == 'Avis d\'exclusion de responsabilité')) {
        $('.links').html('');
        $('.links').css('display', 'none');
    }

	

    $("ul.nice-menu-down ul li").hover(

    function () {
        $(this).addClass("hover");
    },

    function () {
        $(this).removeClass("hover");
    });

	/*Careers Event Block*/
	$(".c-landing-events ul li").each(function() {
		if ($(this).find("img").length) {
			if ($(this).find("img").css("display") != "none"){
				$(this).find("a").css("width", "45%");			
			}
		}
	 });
    /*Webfomr Captcha image lable - hide function*/
    $('#edit-captcha-response-wrapper label').hide();

    // Annual Report 2010
    // /en/annual-report-2010

    $("div.ARP-Pulldown").hover(
        function () {
            $(this).find("ul.ARP-ReportContentMenu").fadeIn();
        },
        function () {
            $(this).find("ul.ARP-ReportContentMenu").fadeOut();
        }
    );

  //RTC ticket no.99786 #C2-39221 - Add an empty alt attribute to the images with no Alt attribute
    $("img").each(function() {
        var image = $(this);
        var destination;
        var pathname;
        var altAttribute="";
        var reg = /.+?\:\/\/.+?(\/.+?)(?:#|\?|$)/;
        if (!image.attr("alt")) {
        	if(image.parents("a").length > 0) {
        		destination = image.parents("a").attr("href");
        		var extORint = new RegExp('^(?:[a-z]+:)?//', 'i');
        		var result = extORint.test(destination);
        		if(result == true){
        			pathname = reg.exec(destination)[1].split('/');
        		} else {
        			pathname = destination.split('/').pop();
        		}
        		altAttribute = setAlt(pathname, altAttribute, result);
    			image.attr("alt", altAttribute);
        		
        	} else {
        		image.attr("alt", "");
        	}
        }
    });

  //End

});

/*******Image Rotator*******/

function theRotator() {
    //Set the opacity of all images to 0
    $('div.rotator ul li').css({
        opacity: 0.0
    });

    //Get the first image and display it (gets set to full opacity)
    $('div.rotator ul li:first').css({
        opacity: 1.0
    });

    //Call the rotator function to run the slideshow, 6000 = change to next image after 6 seconds

    setInterval('rotate()', 6000);

}

function rotate() {
    //Get the first image
    var current = ($('div.rotator ul li.show') ? $('div.rotator ul li.show') : $('div.rotator ul li:first'));

    if (current.length == 0) current = $('div.rotator ul li:first');

    //Get next image, when it reaches the end, rotate it back to the first image
    var next = ((current.next().length) ? ((current.next().hasClass('show')) ? $('div.rotator ul li:first') : current.next()) : $('div.rotator ul li:first'));

    //Un-comment the 3 lines below to get the images in random order

    //var sibs = current.siblings();
    //var rndNum = Math.floor(Math.random() * sibs.length );
    //var next = $( sibs[ rndNum ] );


    //Set the fade in effect for the next image, the show class has higher z-index
    next.css({
        opacity: 0.0
    })
        .addClass('show')
        .animate({
        opacity: 1.0
    }, 1000);

    //Hide the current image
    current.animate({
        opacity: 0.0
    }, 1000)
        .removeClass('show');

};

/*******END Image Rotator*******/
jQuery.fn.fadeToggle = function (speed, easing, callback) {
    return this.animate({
        opacity: 'toggle'
    }, speed, easing, callback);

};

/*Contact us tabs*/

$(function () {

    // Tabs

    if ($("#tabs").exists()) {
        $('#tabs').tabs();
    }
    //hover states on the static widgets
    $('#dialog_link, ul#icons li').hover(

    function () {
        $(this).addClass('ui-state-hover');
    }, function () {
        $(this).removeClass('ui-state-hover');
    });

});


//Homepage equal height collumns
function equalHeight(group) {
    tallest = 0;
    var tallerHeight = $("#block-block-7 .v-divider").height();
    if ($("#block-block-24 #ContentMenu").height() > tallerHeight) {
        tallerHeight = $("#block-block-24 #ContentMenu").height();
    }
    if ($('#block-i18npoll-0').length > 0) {
        if ($("#block-i18npoll-0").height() > tallerHeight) {
            tallerHeight = $("#block-i18npoll-0").height();
        } else {
            $("#block-i18npoll-0").height(tallerHeight - 15);
        }
    }
    if ($("#block-block-167 #Spotlight").length > 0) {
        if ($("#block-block-167 #Spotlight") > tallerHeight) {
            tallerHeight = $("#block-block-167 #Spotlight").height();
        }
    }
    if ($("#block-block-169 #Spotlight").length > 0) {
        if ($("#block-block-169 #Spotlight") > tallerHeight) {
            tallerHeight = $("#block-block-169 #Spotlight").height();
        }
    }
    $("#block-block-7 .v-divider").height(tallerHeight);
    $("#block-block-24 #ContentMenu").height(tallerHeight);
    if ($("#block-poll-6 #ContentMenu").length > 0) {
        $("#block-poll-6 #ContentMenu").height(tallerHeight);
    }
    if ($("#block-block-167 #Spotlight").length > 0) {
        $("#block-block-167 #Spotlight").height(tallerHeight - 15);
    }
    if ($("#block-block-169 #Spotlight").length > 0) {
        $("#block-block-169 #Spotlight").height(tallerHeight - 15);
    }
}


/* ========================= FUNCTIONS ========================= */

function csrStory(page, ajax) {

    (function ($) {

        $('#displayArea').html('<img src="/loading_icon.gif" />');

        //var url = '/en/csr_stories/get?page=' + page + '&ajax=' + ajax;
        var url = '/'+Drupal.settings.pathPrefix+'csr_stories/get?page=' + page + '&ajax=' + ajax;

        $.ajax({
            type: 'GET',
            url: url,
            dataType: 'json',
            success: function (data) {
                $('#displayArea').html(data.value);
            }
        });

    })(jQuery); //jquery function end

} //csr function end

/* ========================= FUNCTIONS TO TRACK OUTBOUND LINK ========================= */

function recordOutboundLink(link, action, label, value) {
    _gaq.push(['_trackEvent', action, label, value]);
    setTimeout(function () {
    	window.open(link.href,'_blank');
    }, 100);
    return false;
}


/*CGI contact-us webform- Reset/Cancel function*/
function ResetContactForm(ev) {
    document.getElementById(ev).reset();
}

function termCookie(termName) {
    var COOKIE_NAME = 'term_name';
    var options = {
        path: '/'
    };
    $.cookie(COOKIE_NAME, termName, options);
}


function cgiSocialFeedjs(page, ajax, pgfeedid, perpage) {

    $('#displayArea').html('<img src="/loading_icon.gif" />');

    var url = '/en/cgi_socialfeed/get?page=' + page + '&ajax=' + ajax + '&feedid=' + pgfeedid + '&perpage=' + perpage;

    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (data) {
            $('#displayArea' + pgfeedid).html(data.value);

        }
    });
} //socialfeed js function end

//Twitter feed js function start
function cgiTwitterFeedjs(page, ajax, pgtweetname, perpage,language) {

    $('#displayArea').html('<img src="/loading_icon.gif" />');

    var url = "/en/cgi_twitter_feed/get?page=" + page + "&ajax=" + ajax + "&vscreen_name=" + pgtweetname + "&perpage=" + perpage;

    $.ajax({
        type: 'GET',
        url: url,
        success: function (data) {
            $('#displayArea').html(data.value);
    
            $(".scroll").click(function (event) {
                //prevent the default action for the click event
                event.preventDefault();

                //get the full url - like mysitecom/index.htm#home
                var full_url = this.href;

                //split the url by # and get the anchor target name - home in mysitecom/index.htm#home
                var parts = full_url.split("#");
                var trgt = parts[1];

                //get the top offset of the target anchor
                var target_offset = $("#" + trgt).offset();
                var target_top = target_offset.top;

                //goto that anchor by setting the body scroll top to anchor top
                $('html, body').animate({
                    scrollTop: target_top
                }, 500);
            });
        },
        dataType: 'json'
    });

}
//Twitter feed js function END

function replaceAllImagesWithLastForIE() {

    // For IE9 only
    if( $.browser.msie == true && $.browser.version == "9.0") {

        // Get URL of image
        var lastImageUrl = $('.field-slideshow div:nth-child(3) img').attr('src');
        var lastImageWidth = $('.field-slideshow div:nth-child(3) img').attr('width');
        var lastImageHeight = $('.field-slideshow div:nth-child(3) img').attr('height');
        var lastImageLink = $('.field-slideshow div:nth-child(3) a').attr('href');

        if( lastImageUrl != null && lastImageLink != null ){

            // Clear all images
            $('div.node-cgi-slider div.content').html('');
            var aLink = $('<a />').attr('href', lastImageLink).append( $('<img />').attr('src', lastImageUrl).attr('width', lastImageWidth).attr('height', lastImageHeight) );
            $('div.node-cgi-slider div.content').append(aLink);

        }
    }
}



// After everything is loaded
$(window).load(function(){

    window.setTimeout(function() {
        replaceAllImagesWithLastForIE();
    }, 0);

//******* CGI EXPERT *******//

$('.cgi-expert-cont .talk').click(function() {
  var e = $(this);
  e.toggle();
  e.next('.detail').show()
  /*$(".detail").show();*/
  return false;
});

//******* remove left navigation ext link in IE7 ********//

  // Work around for Internet Explorer box model problems.
  if (($.support && !($.support.boxModel === undefined) && !$.support.boxModel) || ($.browser.msie && parseInt($.browser.version) <= 7)) {
    $('span.ext').css('display', 'none');
  }

  //******* Colorbox YouTube and 404 *******//
  $(document).ready(function(){
    $(".youtube").colorbox({iframe:true, innerWidth:640, innerHeight:390});
    
    //****** 404 ******//
    if ($('body').hasClass('page-node-15791') && $('body').hasClass('i18n-fr')) {
	  $('.language-switcher-locale-url li.fr').remove();
    }
	
    if ($('body').hasClass('page-node-15791') && $('body').hasClass('i18n-en')) {
	  $('.language-switcher-locale-url li.en').remove();
    }
		
		/*Poll if this checked*/
		$('.poll .vote-form .choices input').click(function() {
			$('.poll .vote-form .choices .form-item').removeClass("active");
		if ($(this).is(":checked")) {
		 $(this).parent().addClass("active");
			}
	 });
  });	

});

//Exposed filter for tax vocabulary list
function exposed_filters_taxvoc_views(vid,ctype,lang) {

    (function ($) {

        $('#displayArea').html('<img src="/throbber.gif" />');

        var url = "/"+lang+"/cgicustom_taxonomy_term_list/get?vid=" + vid +"&ctype="+ctype;

        $.ajax({
            type: 'GET',
            url: url,
            success: function (data) {
                $('#displayArea').html(data.value);
            }
        });

    })(jQuery); //jquery function end

} //Exposed filter for taxonomy vocabulary list function end

//Exposed filter for taxonomy vocabulary term list
function exposed_filters_taxvoc_termview_list(btnact,clang,refpath,pgviewname,term_sys) {
	if(btnact==1){
	    (function ($) {

	             
	       var lang = clang;

	       if(clang=='en' ||clang=='fr'){ 
	      	    var url = "/"+lang+"/cgicustom_exposed_filters/get/" + term_sys + "/" +  $('#globalmediacat').val() + "/" + $('#globalsubcat').val()+ "/" + pgviewname;
	      	    var rpath = refpath;
	     }else {
	    		var url = "/cgicustom_exposed_filters/get/" + term_sys + "/" +  $('#globalmediacat').val() + "/" + $('#globalsubcat').val()+ "/" + pgviewname;
	    	    var rpath = "/"+refpath;
	      }
	        //alert("Custom url"+url+" Redirect Path:"+rpath);
			var optglobalcat1 = $('#globalmediacat').val();
			var optglobalcat2 = $('#globalsubcat').val();
		
	        $.ajax({
	            type: 'POST',
	            url: url,
	            dataType: 'json' ,
	            success: function (data) {
	            	$('#content-area').html(data.products);

	            	$('#globalmediacat').val(data.selglobatcat);
	                $('#globalsubcat').val(data.selcat);
	                
	                if ($('.item-list .pager').length > 0) {
	                    $('.item-list .pager').html($('.item-list .pager').html().replace(/cgicustom_global_term_id\/get/ig, "'"+rpath+"'"));
	                }
	                $('#sidebar-left-inner').height($('#content').height());
	            }
	              
	        });
	        
	    })(jQuery); //jquery function end
	}else{
		//Reset value
		   var lang = clang;

		 if(clang=='en' ||clang=='fr'){ 
			var url = "/"+lang+"/"+refpath;
		}else {
		    var url = refpath;
	    }
	 	location.href = url;
		}
}

/*RTC ticket no.99786 #C2-39221 - Add an empty alt attribute to the images with no Alt attribute*/
function setAlt(value, altAttribute, extrORintr) {
	if(extrORintr == true) {
		$(value).each(function(i) {
			if(altAttribute == "") {
				if(value[i] != "en" && value[i] != "fr") {
					altAttribute = value[i];
				}
			} else {
				altAttribute = altAttribute+' '+value[i];
			}
		});
		altAttribute = altAttribute + ' Page';
	} else {
		altAttribute = value + ' Page';
	}
	return altAttribute;
}
/*End*/

/*Finland social media feeds*/
function toogleButton(element) {
	var elementId = $(element).attr('id');
	$('#'+elementId).addClass('active');
	if(elementId == 'tab_twitter') {
	  $('#tab_facebook').removeClass('active');
	  $('.facebook_content').removeClass('active');
	  $('.twitter_content').addClass('active');
	} else if(elementId == 'tab_facebook') {
	  $('#tab_twitter').removeClass('active');
	  $('.twitter_content').removeClass('active');
	  $('.facebook_content').addClass('active');
	}
}
/*End*/;
/**
 * HoverScroll jQuery Plugin
 *
 * Make an unordered list scrollable by hovering the mouse over it
 *
 * @author RasCarlito <carl.ogren@gmail.com>
 * @version 0.2.4
 * @revision 21
 *
 * 
 *
 * FREE BEER LICENSE VERSION 1.02
 *
 * The free beer license is a license to give free software to you and free
 * beer (in)to the author(s).
 * 
 *
 * Released: 09-12-2010 11:31pm
 *
 * Changelog
 * ----------------------------------------------------
 *
 * 0.2.4    - Added "Right to Left" option, only works with horizontal lists
 *          - Optimization of arrows opacity control (Thanks to Josef Körner)
 *
 * 0.2.3    - Added fixed arrows option
 *          - Binded startMoving and stopMoving functions to the HoverScrolls HTML object for external access
 *
 * 0.2.2    Bug fixes
 *          - Backward compatibility with jQuery 1.1.x
 *          - Added test file to the archive
 *          - Bug fix: The right arrow appeared when it wasn't necessary (thanks to <admin at unix dot am>)
 *        
 * 0.2.1    Bug fixes
 *          - Backward compatibility with jQuery 1.2.x (thanks to Andy Mull for compatibility with jQuery >= 1.2.4)
 *          - Added information to the debug log
 * 
 * 0.2.0    Added some new features
 *          - Direction indicator arrows
 *          - Permanent override of default parameters
 * 
 * 0.1.1    Minor bug fix
 *          - Hover zones did not cover the complete container
 *
 *          note: The css file has not changed therefore it is still versioned 0.1.0
 *
 * 0.1.0    First release of the plugin. Supports:
 *          - Horizontal and vertical lists
 *          - Width and height control
 *          - Debug log (doesn't show useful information for the moment)
 */
 
(function($) {

/**
 * @method hoverscroll
 * @param	params {Object}  Parameter list
 * 	params = {
 * 		vertical {Boolean},	// Vertical list or not ?
 * 		width {Integer},	// Width of list container
 * 		height {Integer},	// Height of list container
 *  	arrows {Boolean},	// Show direction indicators or not
 *  	arrowsOpacity {Float},	// Arrows maximum opacity
 *  	fixedArrows {Boolean},  // Display arrows permenantly, this overrides arrowsOpacity option
 * 		debug {Boolean}		// Debug output in firebug console
 * 	};
 */
$.fn.hoverscroll = function(params) {
	if (!params) { params = {}; }
	
	// Extend default parameters
	// note: empty object to prevent params object from overriding default params object
	params = $.extend({}, $.fn.hoverscroll.params, params);
	
	// Loop through all the elements
	this.each(function() {
		var $this = $(this);
		
		if (params.debug) {
			$.log('[HoverScroll] Trying to create hoverscroll on element ' + this.tagName + '#' + this.id);
		}
		
		// wrap ul list with a div.listcontainer
        if (params.fixedArrows) {
            $this.wrap('<div class="fixed-listcontainer"></div>')
        }
        else {
            $this.wrap('<div class="listcontainer"></div>');
        }
		
		$this.addClass('list');
		//.addClass('ui-helper-clearfix');
		
		// store handle to listcontainer
		var listctnr = $this.parent();
		
		// wrap listcontainer with a div.hoverscroll
		listctnr.wrap('<div class="ui-widget-content hoverscroll' +
			(params.rtl && !params.vertical ? " rtl" : "") + '"></div>');
		//listctnr.wrap('<div class="hoverscroll"></div>');
		
		// store hoverscroll container
		var ctnr = listctnr.parent();

        var leftArrow, rightArrow, topArrow, bottomArrow;

		// Add arrow containers
		if (params.arrows) {
			if (!params.vertical) {
                if (params.fixedArrows) {
                    leftArrow = '<div class="fixed-arrow left"></div>';
                    rightArrow = '<div class="fixed-arrow right"></div>';

                    listctnr.before(leftArrow).after(rightArrow);
                }
                else {
                    leftArrow = '<div class="arrow left"></div>';
                    rightArrow = '<div class="arrow right"></div>';
                    
                    listctnr.append(leftArrow).append(rightArrow);
                }
			}
			else {
                if (params.fixedArrows) {
                    topArrow = '<div class="fixed-arrow top"></div>';
                    bottomArrow = '<div class="fixed-arrow bottom"></div>';

                    listctnr.before(topArrow).after(bottomArrow);
                }
                else {
                    topArrow = '<div class="arrow top"></div>';
                    bottomArrow = '<div class="arrow bottom"></div>';

                    listctnr.append(topArrow).append(bottomArrow);
                }
			}
		}
		
		// Apply parameters width and height
		ctnr.width(params.width).height(params.height);

        if (params.arrows && params.fixedArrows) {
            if (params.vertical) {
                topArrow = listctnr.prev();
                bottomArrow = listctnr.next();

                listctnr.width(params.width)
                    .height(params.height - (topArrow.height() + bottomArrow.height()));
            }
            else {
                leftArrow = listctnr.prev();
                rightArrow = listctnr.next();
                
                listctnr.height(params.height)
                    .width(params.width - (leftArrow.width() + rightArrow.width()));
            }
        }
        else {
            listctnr.width(params.width).height(params.height);
        }
		
		var size = 0;
		
		if (!params.vertical) {
			ctnr.addClass('horizontal');
			
			// Determine content width
			$this.children().each(function() {
				$(this).addClass('item');
				
				if ($(this).outerWidth) {
					size += $(this).outerWidth(true);
				}
				else {
					// jQuery < 1.2.x backward compatibility patch
					size += $(this).width() + parseInt($(this).css('padding-left')) + parseInt($(this).css('padding-right'))
						+ parseInt($(this).css('margin-left')) + parseInt($(this).css('margin-right'));
				}
			});
			// Apply computed width to listcontainer
			$this.width(size);
			
			if (params.debug) {
				$.log('[HoverScroll] Computed content width : ' + size + 'px');
			}
			
			// Retrieve container width instead of using the given params.width to include padding
			if (ctnr.outerWidth) {
				size = ctnr.outerWidth();
			}
			else {
				// jQuery < 1.2.x backward compatibility patch
				size = ctnr.width() + parseInt(ctnr.css('padding-left')) + parseInt(ctnr.css('padding-right'))
					+ parseInt(ctnr.css('margin-left')) + parseInt(ctnr.css('margin-right'));
			}
			
			if (params.debug) {
				$.log('[HoverScroll] Computed container width : ' + size + 'px');
			}
		}
		else {
			ctnr.addClass('vertical');
			
			// Determine content height
			$this.children().each(function() {
				$(this).addClass('item')
				
				if ($(this).outerHeight) {
					size += $(this).outerHeight(true);
				}
				else {
					// jQuery < 1.2.x backward compatibility patch
					size += $(this).height() + parseInt($(this).css('padding-top')) + parseInt($(this).css('padding-bottom'))
						+ parseInt($(this).css('margin-bottom')) + parseInt($(this).css('margin-bottom'));
				}
			});
			// Apply computed height to listcontainer
			$this.height(size);
			
			if (params.debug) {
				$.log('[HoverScroll] Computed content height : ' + size + 'px');
			}
			
			// Retrieve container height instead of using the given params.height to include padding
			if (ctnr.outerHeight) {
				size = ctnr.outerHeight();
			}
			else {
				// jQuery < 1.2.x backward compatibility patch
				size = ctnr.height() + parseInt(ctnr.css('padding-top')) + parseInt(ctnr.css('padding-bottom'))
					+ parseInt(ctnr.css('margin-top')) + parseInt(ctnr.css('margin-bottom'));
			}
			
			if (params.debug) {
				$.log('[HoverScroll] Computed container height : ' + size + 'px');
			}
		}
		
		// Define hover zones on container
		var zone = {
			1: {action: 'move', from: 0, to: 0.06 * size, direction: -1 , speed: 16},
			2: {action: 'move', from: 0.06 * size, to: 0.15 * size, direction: -1 , speed: 8},
			3: {action: 'move', from: 0.15 * size, to: 0.25 * size, direction: -1 , speed: 4},
			4: {action: 'move', from: 0.25 * size, to: 0.4 * size, direction: -1 , speed: 2},
			5: {action: 'stop', from: 0.4 * size, to: 0.6 * size},
			6: {action: 'move', from: 0.6 * size, to: 0.75 * size, direction: 1 , speed: 2},
			7: {action: 'move', from: 0.75 * size, to: 0.85 * size, direction: 1 , speed: 4},
			8: {action: 'move', from: 0.85 * size, to: 0.94 * size, direction: 1 , speed: 8},
			9: {action: 'move', from: 0.94 * size, to: size, direction: 1 , speed: 16}
		}
		
		// Store default state values in container
		ctnr[0].isChanging = false;
		ctnr[0].direction  = 0;
		ctnr[0].speed      = 1;
		
		
		/**
		 * Check mouse position relative to hoverscroll container
		 * and trigger actions according to the zone table
		 *
		 * @param x {Integer} Mouse X event position
		 * @param y {Integer} Mouse Y event position
		 */
		function checkMouse(x, y) {
			x = x - ctnr.offset().left;
			y = y - ctnr.offset().top;
			
			var pos;
			if (!params.vertical) {pos = x;}
			else {pos = y;}
			
			for (i in zone) {
				if (pos >= zone[i].from && pos < zone[i].to) {
					if (zone[i].action == 'move') {startMoving(zone[i].direction, zone[i].speed);}
					else {stopMoving();}
				}
			}
		}
		
		
		/**
		 * Sets the opacity of the left|top and right|bottom
		 * arrows according to the scroll position.
		 */
		function setArrowOpacity() {
			if (!params.arrows || params.fixedArrows) {return;}
			
			var maxScroll;
			var scroll;
			
			if (!params.vertical) {
				maxScroll = listctnr[0].scrollWidth - listctnr.width();
				scroll = listctnr[0].scrollLeft;
			}
			else {
				maxScroll = listctnr[0].scrollHeight - listctnr.height();
				scroll = listctnr[0].scrollTop;
			}
			var limit = params.arrowsOpacity;
			
            // Optimization of opacity control by Josef Körner
            // Initialize opacity; keep it between its extremas (0 and limit) we don't need to check limits after init
			var opacity = (scroll / maxScroll) * limit;
            
   		    if (opacity > limit) { opacity = limit; }
			if (isNaN(opacity)) { opacity = 0; }
            
			// Check if the arrows are needed
			// Thanks to <admin at unix dot am> for fixing the bug that displayed the right arrow when it was not needed
			var done = false;
			if (opacity <= 0) {
                $('div.arrow.left, div.arrow.top', ctnr).hide();
                if(maxScroll > 0) {
                    $('div.arrow.right, div.arrow.bottom', ctnr).show().css('opacity', limit);
                }
                done = true;
            }
			if (opacity >= limit || maxScroll <= 0) {
           	    $('div.arrow.right, div.arrow.bottom', ctnr).hide();
                done = true;
            }

			if (!done) {
				$('div.arrow.left, div.arrow.top', ctnr).show().css('opacity', opacity);
				$('div.arrow.right, div.arrow.bottom', ctnr).show().css('opacity', (limit - opacity));
			}
            // End of optimization
		}
		
		
		/**
		 * Start scrolling the list with a given speed and direction
		 *
		 * @param direction {Integer}	Direction of the displacement, either -1|1
		 * @param speed {Integer}		Speed of the displacement (20 being very fast)
		 */
		function startMoving(direction, speed) {
			if (ctnr[0].direction != direction) {
				if (params.debug) {
					$.log('[HoverScroll] Starting to move. direction: ' + direction + ', speed: ' + speed);
				}
				
				stopMoving();
				ctnr[0].direction  = direction;
				ctnr[0].isChanging = true;
				move();
			}
			if (ctnr[0].speed != speed) {
				if (params.debug) {
					$.log('[HoverScroll] Changed speed: ' + speed);
				}
				
				ctnr[0].speed = speed;
			}
		}
		
		/**
		 * Stop scrolling the list
		 */
		function stopMoving() {
			if (ctnr[0].isChanging) {
				if (params.debug) {
					$.log('[HoverScroll] Stoped moving');
				}
				
				ctnr[0].isChanging = false;
				ctnr[0].direction  = 0;
				ctnr[0].speed      = 1;
				clearTimeout(ctnr[0].timer);
			}
		}
		
		/**
		 * Move the list one step in the given direction and speed
		 */
		function move() {
			if (ctnr[0].isChanging == false) {return;}
			
			setArrowOpacity();
			
			var scrollSide;
			if (!params.vertical) {scrollSide = 'scrollLeft';}
			else {scrollSide = 'scrollTop';}
			
			listctnr[0][scrollSide] += ctnr[0].direction * ctnr[0].speed;
			ctnr[0].timer = setTimeout(function() {move();}, 50);
		}

		// Initialize "right to left" option if specified
		if (params.rtl && !params.vertical) {
			listctnr[0].scrollLeft = listctnr[0].scrollWidth - listctnr.width();
		}
		
		// Bind actions to the hoverscroll container
		ctnr
		// Bind checkMouse to the mousemove
		.mousemove(function(e) {checkMouse(e.pageX, e.pageY);})
		// Bind stopMoving to the mouseleave
		// jQuery 1.2.x backward compatibility, thanks to Andy Mull!
		// replaced .mouseleave(...) with .bind('mouseleave', ...)
		.bind('mouseleave', function() {stopMoving();});

        // Bind the startMoving and stopMoving functions
        // to the HTML object for external access
        this.startMoving = startMoving;
        this.stopMoving = stopMoving;
		
		if (params.arrows && !params.fixedArrows) {
			// Initialise arrow opacity
			setArrowOpacity();
		}
		else {
			// Hide arrows
			$('.arrowleft, .arrowright, .arrowtop, .arrowbottom', ctnr).hide();
		}
	});
	
	return this;
};


// Backward compatibility with jQuery 1.1.x
if (!$.fn.offset) {
	$.fn.offset = function() {
		this.left = this.top = 0;
		
		if (this[0] && this[0].offsetParent) {
			var obj = this[0];
			do {
				this.left += obj.offsetLeft;
				this.top += obj.offsetTop;
			} while (obj = obj.offsetParent);
		}
		
		return this;
	}
}



/**
 * HoverScroll default parameters
 */
$.fn.hoverscroll.params = {
	vertical:	false,      // Display the list vertically or not
	width:		400,        // Width of the list
	height:		50,         // Height of the list
	arrows:		true,       // Display arrows to the left and top or the top and bottom
	arrowsOpacity:	0.7,    // Maximum opacity of the arrows if fixedArrows
    fixedArrows: false,     // Fix the displayed arrows to the side of the list
	rtl:		false,		// Set display mode to "Right to Left"
	debug:		false       // Display some debugging information in firebug console
};



/**
 * Log errors to consoles (firebug, opera) if exist, else uses alert()
 */
$.log = function() {
	try {console.log.apply(console, arguments);}
	catch (e) {
		try {opera.postError.apply(opera, arguments);}
		catch (e) {
//            alert(Array.prototype.join.call(arguments, " "));
        }
	}
};


})(jQuery);
;
/**
 * jQuery.ScrollTo - Easy element scrolling using jQuery.
 * Copyright (c) 2007-2009 Ariel Flesler - aflesler(at)gmail(dot)com | http://flesler.blogspot.com
 * Dual licensed under MIT and GPL.
 * Date: 5/25/2009
 * @author Ariel Flesler
 * @version 1.4.2
 *
 * http://flesler.blogspot.com/2007/10/jqueryscrollto.html
 */
;(function(d){var k=d.scrollTo=function(a,i,e){d(window).scrollTo(a,i,e)};k.defaults={axis:'xy',duration:parseFloat(d.fn.jquery)>=1.3?0:1};k.window=function(a){return d(window)._scrollable()};d.fn._scrollable=function(){return this.map(function(){var a=this,i=!a.nodeName||d.inArray(a.nodeName.toLowerCase(),['iframe','#document','html','body'])!=-1;if(!i)return a;var e=(a.contentWindow||a).document||a.ownerDocument||a;return d.browser.safari||e.compatMode=='BackCompat'?e.body:e.documentElement})};d.fn.scrollTo=function(n,j,b){if(typeof j=='object'){b=j;j=0}if(typeof b=='function')b={onAfter:b};if(n=='max')n=9e9;b=d.extend({},k.defaults,b);j=j||b.speed||b.duration;b.queue=b.queue&&b.axis.length>1;if(b.queue)j/=2;b.offset=p(b.offset);b.over=p(b.over);return this._scrollable().each(function(){var q=this,r=d(q),f=n,s,g={},u=r.is('html,body');switch(typeof f){case'number':case'string':if(/^([+-]=)?\d+(\.\d+)?(px|%)?$/.test(f)){f=p(f);break}f=d(f,this);case'object':if(f.is||f.style)s=(f=d(f)).offset()}d.each(b.axis.split(''),function(a,i){var e=i=='x'?'Left':'Top',h=e.toLowerCase(),c='scroll'+e,l=q[c],m=k.max(q,i);if(s){g[c]=s[h]+(u?0:l-r.offset()[h]);if(b.margin){g[c]-=parseInt(f.css('margin'+e))||0;g[c]-=parseInt(f.css('border'+e+'Width'))||0}g[c]+=b.offset[h]||0;if(b.over[h])g[c]+=f[i=='x'?'width':'height']()*b.over[h]}else{var o=f[h];g[c]=o.slice&&o.slice(-1)=='%'?parseFloat(o)/100*m:o}if(/^\d+$/.test(g[c]))g[c]=g[c]<=0?0:Math.min(g[c],m);if(!a&&b.queue){if(l!=g[c])t(b.onAfterFirst);delete g[c]}});t(b.onAfter);function t(a){r.animate(g,j,b.easing,a&&function(){a.call(this,n,b)})}}).end()};k.max=function(a,i){var e=i=='x'?'Width':'Height',h='scroll'+e;if(!d(a).is('html,body'))return a[h]-d(a)[e.toLowerCase()]();var c='client'+e,l=a.ownerDocument.documentElement,m=a.ownerDocument.body;return Math.max(l[h],m[h])-Math.min(l[c],m[c])};function p(a){return typeof a=='object'?a:{top:a,left:a}}})(jQuery);;
/**
 * Cookie plugin
 *
 * Copyright (c) 2006 Klaus Hartl (stilbuero.de)
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 */

/**
 * Create a cookie with the given name and value and other optional parameters.
 *
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Set the value of a cookie.
 * @example $.cookie('the_cookie', 'the_value', { expires: 7, path: '/', domain: 'jquery.com', secure: true });
 * @desc Create a cookie with all available options.
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Create a session cookie.
 * @example $.cookie('the_cookie', null);
 * @desc Delete a cookie by passing null as value. Keep in mind that you have to use the same path and domain
 *       used when the cookie was set.
 *
 * @param String name The name of the cookie.
 * @param String value The value of the cookie.
 * @param Object options An object literal containing key/value pairs to provide optional cookie attributes.
 * @option Number|Date expires Either an integer specifying the expiration date from now on in days or a Date object.
 *                             If a negative value is specified (e.g. a date in the past), the cookie will be deleted.
 *                             If set to null or omitted, the cookie will be a session cookie and will not be retained
 *                             when the the browser exits.
 * @option String path The value of the path atribute of the cookie (default: path of page that created the cookie).
 * @option String domain The value of the domain attribute of the cookie (default: domain of page that created the cookie).
 * @option Boolean secure If true, the secure attribute of the cookie will be set and the cookie transmission will
 *                        require a secure protocol (like HTTPS).
 * @type undefined
 *
 * @name $.cookie
 * @cat Plugins/Cookie
 * @author Klaus Hartl/klaus.hartl@stilbuero.de
 */

/**
 * Get the value of a cookie with the given name.
 *
 * @example $.cookie('the_cookie');
 * @desc Get the value of a cookie.
 *
 * @param String name The name of the cookie.
 * @return The value of the cookie.
 * @type String
 *
 * @name $.cookie
 * @cat Plugins/Cookie
 * @author Klaus Hartl/klaus.hartl@stilbuero.de
 */
jQuery.cookie = function(name, value, options) {
    if (typeof value != 'undefined') { // name and value given, set cookie
        options = options || {};
        if (value === null) {
            value = '';
            options.expires = -1;
        }
        var expires = '';
        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
            var date;
            if (typeof options.expires == 'number') {
                date = new Date();
                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
            } else {
                date = options.expires;
            }
            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
        }
        // CAUTION: Needed to parenthesize options.path and options.domain
        // in the following expressions, otherwise they evaluate to undefined
        // in the packed version for some reason...
        var path = options.path ? '; path=' + (options.path) : '';
        var domain = options.domain ? '; domain=' + (options.domain) : '';
        var secure = options.secure ? '; secure' : '';
        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
    } else { // only name given, get cookie
        var cookieValue = null;
        if (document.cookie && document.cookie != '') {
            var cookies = document.cookie.split(';');
            for (var i = 0; i < cookies.length; i++) {
                var cookie = jQuery.trim(cookies[i]);
                // Does this cookie string begin with the name we want?
                if (cookie.substring(0, name.length + 1) == (name + '=')) {
                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                    break;
                }
            }
        }
        return cookieValue;
    }
};;
// JavaScript Document
var $ = jQuery.noConflict();

 $(document).ready(function () {
  $('#zoom-in').zoom();
 });;
/*!
	Zoom v1.7.12 - 2014-02-12
	Enlarge images on click or mouseover.
	(c) 2014 Jack Moore - http://www.jacklmoore.com/zoom
	license: http://www.opensource.org/licenses/mit-license.php
*/
(function(o){var n={url:!1,callback:!1,target:!1,duration:120,on:"mouseover",touch:!0,onZoomIn:!1,onZoomOut:!1,magnify:1};o.zoom=function(n,t,e,i){var u,c,a,m,r,l,s,f=o(n).css("position");return o(n).css({position:/(absolute|fixed)/.test(f)?f:"relative",overflow:"hidden"}),e.style.width=e.style.height="",o(e).addClass("zoomImg").css({position:"absolute",top:0,left:0,opacity:0,width:e.width*i,height:e.height*i,border:"none",maxWidth:"none",maxHeight:"none"}).appendTo(n),{init:function(){c=o(n).outerWidth(),u=o(n).outerHeight(),t===n?(m=c,a=u):(m=o(t).outerWidth(),a=o(t).outerHeight()),r=(e.width-c)/m,l=(e.height-u)/a,s=o(t).offset()},move:function(o){var n=o.pageX-s.left,t=o.pageY-s.top;t=Math.max(Math.min(t,a),0),n=Math.max(Math.min(n,m),0),e.style.left=n*-r+"px",e.style.top=t*-l+"px"}}},o.fn.zoom=function(t){return this.each(function(){var e,i=o.extend({},n,t||{}),u=i.target||this,c=this,a=document.createElement("img"),m=o(a),r="mousemove.zoom",l=!1,s=!1;(i.url||(e=o(c).find("img"),e[0]&&(i.url=e.data("src")||e.attr("src")),i.url))&&(a.onload=function(){function n(n){e.init(),e.move(n),m.stop().fadeTo(o.support.opacity?i.duration:0,1,o.isFunction(i.onZoomIn)?i.onZoomIn.call(a):!1)}function t(){m.stop().fadeTo(i.duration,0,o.isFunction(i.onZoomOut)?i.onZoomOut.call(a):!1)}var e=o.zoom(u,c,a,i.magnify);"grab"===i.on?o(c).on("mousedown.zoom",function(i){1===i.which&&(o(document).one("mouseup.zoom",function(){t(),o(document).off(r,e.move)}),n(i),o(document).on(r,e.move),i.preventDefault())}):"click"===i.on?o(c).on("click.zoom",function(i){return l?void 0:(l=!0,n(i),o(document).on(r,e.move),o(document).one("click.zoom",function(){t(),l=!1,o(document).off(r,e.move)}),!1)}):"toggle"===i.on?o(c).on("click.zoom",function(o){l?t():n(o),l=!l}):"mouseover"===i.on&&(e.init(),o(c).on("mouseenter.zoom",n).on("mouseleave.zoom",t).on(r,e.move)),i.touch&&o(c).on("touchstart.zoom",function(o){o.preventDefault(),s?(s=!1,t()):(s=!0,n(o.originalEvent.touches[0]||o.originalEvent.changedTouches[0]))}).on("touchmove.zoom",function(o){o.preventDefault(),e.move(o.originalEvent.touches[0]||o.originalEvent.changedTouches[0])}),o.isFunction(i.callback)&&i.callback.call(a)},a.src=i.url,o(c).one("zoom.destroy",function(){o(c).off(".zoom"),m.remove()}))})},o.fn.zoom.defaults=n})(window.jQuery);;
/*
Author: Emmanuel Filteau
Date: 2012-06-26
URL: cgi.com/en/investors/financial-reports
Desc: This script defines the parameters for cgi.jquery.AnchorScroll.js

*/
(function($) {

$(document).ready(function () {
	

	$(".AnchorScroller .Menu a").click(function(evt) {
		evt.preventDefault();
		
		var chosenSection = $(this).attr('class');
		var sectionIndex = $('.Sections .' + chosenSection).nextAll().length;
		var sectionHeight = $('.Sections .' + chosenSection).height();
		
		$('.Sections').height(sectionIndex * sectionHeight + sectionHeight);
		
		$(".AnchorScroller .Menu li").removeClass("Active");
		$(".Sections").scrollTo( $("table." + chosenSection),800);
		$(this).parent().addClass("Active");
		
		
		
		//alert(sectionHeight);
	
	});
  
});

})(jQuery); //jquery function end;
/*
Author: Emmanuel Filteau
Date: 2013-01-09
URL: cgi.com/contact-resources
Desc: This script defines the parameters for cgi.addon.tabs

*/
(function($) {

$(document).ready(function () {
	

//$(".tab1").addClass("active");Default tab 

	$(".tabsDefault .tabs li").click(function(evt) {
		evt.preventDefault();//Prevents page jumping
		
		$(".tabsDefault .active").removeClass("active");
			
		var activeTab = $(this).attr('id');
		
		$(this).addClass("active");
		
		$(".tabsDefault div." + activeTab).addClass("active")
		
		
	});


});

})(jQuery); //jquery function end;
