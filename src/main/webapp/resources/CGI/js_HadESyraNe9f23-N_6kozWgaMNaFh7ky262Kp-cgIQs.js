(function($) {

Drupal.behaviors.customFilter = {};
Drupal.behaviors.customFilter.attach = function(context) {
	var lang = Drupal.settings.swflang;
	var is_mobile = Drupal.settings.is_mobile;
	//alert(is_mobile);
    var language = '';
    if (lang == 'fr') {
        language = lang;
    } 
	/* functionality for views expose filter begins here */
	$.fn.pageClickedEvent = function (){
		    $('.pagerLinks').paginate({
				count 		: 100,
				start 		: 1,
				display     : 15,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: '#89213C',	
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page){
											alert(page);
										  }
			});
	}
	
	 $.fn.updateTermDisplay = function ($term) {
		 $('#vocabSelect').change(function (e) {
			  e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'term/select';
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $(this).attr('view'), vid: $('#vocabSelect').val(), term: $term, sub_path:  $(this).attr('sub_path') },
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#termDisplayArea').html(data.termList);
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
	      }); 
	 }
	 
	 $.fn.updateViewContent = function () {
		 $('#viewFilterSubmit').click(function (e) {
			  e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'filter/'+$('#vocabSelect').attr('view')+'/'+$('#vocabSelect').attr('sub_path');
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $('#vocabSelect').attr('view'), 
	            	  vid: $('#vocabSelect').val(), 
	            	  tid: $('#termSelect').val(), 
	            	  view_name: $('#vocabSelect').attr('view_name'), 
	            	  view_page:$('#vocabSelect').attr('view_page'),
	            	  sub_path:$('#vocabSelect').attr('sub_path')},
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#content-area').html(data.output);
	              	
	              	$('#vocabSelect').val(data.selvoc);
	              	$(this).updateTermDisplay(data.selter);
	              	$('#vocabSelect').change();
	              	//alert(data.selter);
	              	
	              	//$('#termSelect').val(data.selter);
	              	
	              	 $("#filter_table").tablePager({
	                      offset: 0,
	                      limit: 40,
	                      language: lang
	                  });
	            	 $("#filter_table_video").tablePager({
	         	        offset: 0,
	         	        limit: 5,
	         	        language: lang
	         	    });	 
	              	 $("#content_globalnews").tablePager({
	         	        offset: 0,
	         	        limit: 8,
	         	        language: lang
	         	    });
	              	 
	              	$(this).updateViewContent();
	              	$(this).resetViewContent();
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
	      });		 
	 }	
	 
	 $.fn.resetViewContent = function () {
		 $('#viewFilterReset').click(function(e){
			 e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'filter/'+$('#vocabSelect').attr('view')+'/'+$('#vocabSelect').attr('sub_path');
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $('#vocabSelect').attr('view'), 
	            	  vid: '', 
	            	  tid: 'all', 
	            	  term_retain: $('#termSelect').val(),
	            	  view_name: $('#vocabSelect').attr('view_name'), 
	            	  view_page:$('#vocabSelect').attr('view_page'),
	            	  sub_path:$('#vocabSelect').attr('sub_path')},
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#content-area').html(data.output);
	              	
	              	$('#vocabSelect').val(data.selvoc);
	              	$(this).updateTermDisplay(data.selter);
	              	$('#vocabSelect').change();
	              	//alert(data.selter);
	              	
	              	//$('#termSelect').val(data.selter);
	              	
	              	 $("#filter_table").tablePager({
	                      offset: 0,
	                      limit: 40,
	                      language: lang
	                  });
	             	
	              	 $("#content_globalnews").tablePager({
	         	        offset: 0,
	         	        limit: 8,
	         	        language: lang
	         	    });
	              	 
	              	$(this).updateViewContent();
	              	$(this).resetViewContent();
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
			 
		 });
	 }
	 $(this).updateTermDisplay();
  	 $(this).updateViewContent();
  	 $(this).resetViewContent(); 
};

})(jQuery);;
/*!
	jQuery Colorbox v1.4.19 - 2013-06-03
	(c) 2013 Jack Moore - jacklmoore.com/colorbox
	license: http://www.opensource.org/licenses/mit-license.php
*/
(function(t,e,i){function o(i,o,n){var r=e.createElement(i);return o&&(r.id=te+o),n&&(r.style.cssText=n),t(r)}function n(){return i.innerHeight?i.innerHeight:t(i).height()}function r(t){var e=E.length,i=(j+t)%e;return 0>i?e+i:i}function h(t,e){return Math.round((/%/.test(t)?("x"===e?H.width():n())/100:1)*parseInt(t,10))}function l(t,e){return t.photo||t.photoRegex.test(e)}function s(t,e){return t.retinaUrl&&i.devicePixelRatio>1?e.replace(t.photoRegex,t.retinaSuffix):e}function a(t){"contains"in x[0]&&!x[0].contains(t.target)&&(t.stopPropagation(),x.focus())}function d(){var e,i=t.data(A,Z);null==i?(_=t.extend({},Y),console&&console.log&&console.log("Error: cboxElement missing settings object")):_=t.extend({},i);for(e in _)t.isFunction(_[e])&&"on"!==e.slice(0,2)&&(_[e]=_[e].call(A));_.rel=_.rel||A.rel||t(A).data("rel")||"nofollow",_.href=_.href||t(A).attr("href"),_.title=_.title||A.title,"string"==typeof _.href&&(_.href=t.trim(_.href))}function c(i,o){t(e).trigger(i),se.trigger(i),t.isFunction(o)&&o.call(A)}function u(){var t,e,i,o,n,r=te+"Slideshow_",h="click."+te;_.slideshow&&E[1]?(e=function(){clearTimeout(t)},i=function(){(_.loop||E[j+1])&&(t=setTimeout(J.next,_.slideshowSpeed))},o=function(){M.html(_.slideshowStop).unbind(h).one(h,n),se.bind(ne,i).bind(oe,e).bind(re,n),x.removeClass(r+"off").addClass(r+"on")},n=function(){e(),se.unbind(ne,i).unbind(oe,e).unbind(re,n),M.html(_.slideshowStart).unbind(h).one(h,function(){J.next(),o()}),x.removeClass(r+"on").addClass(r+"off")},_.slideshowAuto?o():n()):x.removeClass(r+"off "+r+"on")}function f(i){G||(A=i,d(),E=t(A),j=0,"nofollow"!==_.rel&&(E=t("."+ee).filter(function(){var e,i=t.data(this,Z);return i&&(e=t(this).data("rel")||i.rel||this.rel),e===_.rel}),j=E.index(A),-1===j&&(E=E.add(A),j=E.length-1)),g.css({opacity:parseFloat(_.opacity),cursor:_.overlayClose?"pointer":"auto",visibility:"visible"}).show(),V&&x.add(g).removeClass(V),_.className&&x.add(g).addClass(_.className),V=_.className,K.html(_.close).show(),$||($=q=!0,x.css({visibility:"hidden",display:"block"}),W=o(ae,"LoadedContent","width:0; height:0; overflow:hidden").appendTo(v),D=b.height()+k.height()+v.outerHeight(!0)-v.height(),B=T.width()+C.width()+v.outerWidth(!0)-v.width(),N=W.outerHeight(!0),z=W.outerWidth(!0),_.w=h(_.initialWidth,"x"),_.h=h(_.initialHeight,"y"),J.position(),u(),c(ie,_.onOpen),O.add(S).hide(),x.focus(),_.trapFocus&&e.addEventListener&&(e.addEventListener("focus",a,!0),se.one(he,function(){e.removeEventListener("focus",a,!0)})),_.returnFocus&&se.one(he,function(){t(A).focus()})),w())}function p(){!x&&e.body&&(X=!1,H=t(i),x=o(ae).attr({id:Z,"class":t.support.opacity===!1?te+"IE":"",role:"dialog",tabindex:"-1"}).hide(),g=o(ae,"Overlay").hide(),L=o(ae,"LoadingOverlay").add(o(ae,"LoadingGraphic")),y=o(ae,"Wrapper"),v=o(ae,"Content").append(S=o(ae,"Title"),I=o(ae,"Current"),P=t('<button type="button"/>').attr({id:te+"Previous"}),R=t('<button type="button"/>').attr({id:te+"Next"}),M=o("button","Slideshow"),L,K=t('<button type="button"/>').attr({id:te+"Close"})),y.append(o(ae).append(o(ae,"TopLeft"),b=o(ae,"TopCenter"),o(ae,"TopRight")),o(ae,!1,"clear:left").append(T=o(ae,"MiddleLeft"),v,C=o(ae,"MiddleRight")),o(ae,!1,"clear:left").append(o(ae,"BottomLeft"),k=o(ae,"BottomCenter"),o(ae,"BottomRight"))).find("div div").css({"float":"left"}),F=o(ae,!1,"position:absolute; width:9999px; visibility:hidden; display:none"),O=R.add(P).add(I).add(M),t(e.body).append(g,x.append(y,F)))}function m(){function i(t){t.which>1||t.shiftKey||t.altKey||t.metaKey||t.ctrl||(t.preventDefault(),f(this))}return x?(X||(X=!0,R.click(function(){J.next()}),P.click(function(){J.prev()}),K.click(function(){J.close()}),g.click(function(){_.overlayClose&&J.close()}),t(e).bind("keydown."+te,function(t){var e=t.keyCode;$&&_.escKey&&27===e&&(t.preventDefault(),J.close()),$&&_.arrowKey&&E[1]&&!t.altKey&&(37===e?(t.preventDefault(),P.click()):39===e&&(t.preventDefault(),R.click()))}),t.isFunction(t.fn.on)?t(e).on("click."+te,"."+ee,i):t("."+ee).live("click."+te,i)),!0):!1}function w(){var n,r,a,u=J.prep,f=++de;q=!0,U=!1,A=E[j],d(),c(le),c(oe,_.onLoad),_.h=_.height?h(_.height,"y")-N-D:_.innerHeight&&h(_.innerHeight,"y"),_.w=_.width?h(_.width,"x")-z-B:_.innerWidth&&h(_.innerWidth,"x"),_.mw=_.w,_.mh=_.h,_.maxWidth&&(_.mw=h(_.maxWidth,"x")-z-B,_.mw=_.w&&_.w<_.mw?_.w:_.mw),_.maxHeight&&(_.mh=h(_.maxHeight,"y")-N-D,_.mh=_.h&&_.h<_.mh?_.h:_.mh),n=_.href,Q=setTimeout(function(){L.show()},100),_.inline?(a=o(ae).hide().insertBefore(t(n)[0]),se.one(le,function(){a.replaceWith(W.children())}),u(t(n))):_.iframe?u(" "):_.html?u(_.html):l(_,n)?(n=s(_,n),U=e.createElement("img"),t(U).addClass(te+"Photo").bind("error",function(){_.title=!1,u(o(ae,"Error").html(_.imgError))}).one("load",function(){var e;f===de&&(U.alt=t(A).attr("alt")||t(A).attr("data-alt")||"",_.retinaImage&&i.devicePixelRatio>1&&(U.height=U.height/i.devicePixelRatio,U.width=U.width/i.devicePixelRatio),_.scalePhotos&&(r=function(){U.height-=U.height*e,U.width-=U.width*e},_.mw&&U.width>_.mw&&(e=(U.width-_.mw)/U.width,r()),_.mh&&U.height>_.mh&&(e=(U.height-_.mh)/U.height,r())),_.h&&(U.style.marginTop=Math.max(_.mh-U.height,0)/2+"px"),E[1]&&(_.loop||E[j+1])&&(U.style.cursor="pointer",U.onclick=function(){J.next()}),U.style.width=U.width+"px",U.style.height=U.height+"px",setTimeout(function(){u(U)},1))}),setTimeout(function(){U.src=n},1)):n&&F.load(n,_.data,function(e,i){f===de&&u("error"===i?o(ae,"Error").html(_.xhrError):t(this).contents())})}var g,x,y,v,b,T,C,k,E,H,W,F,L,S,I,M,R,P,K,O,_,D,B,N,z,A,j,U,$,q,G,Q,J,V,X,Y={transition:"elastic",speed:300,fadeOut:300,width:!1,initialWidth:"600",innerWidth:!1,maxWidth:!1,height:!1,initialHeight:"450",innerHeight:!1,maxHeight:!1,scalePhotos:!0,scrolling:!0,inline:!1,html:!1,iframe:!1,fastIframe:!0,photo:!1,href:!1,title:!1,rel:!1,opacity:.9,preloading:!0,className:!1,retinaImage:!1,retinaUrl:!1,retinaSuffix:"@2x.$1",current:"image {current} of {total}",previous:"previous",next:"next",close:"close",xhrError:"This content failed to load.",imgError:"This image failed to load.",open:!1,returnFocus:!0,trapFocus:!0,reposition:!0,loop:!0,slideshow:!1,slideshowAuto:!0,slideshowSpeed:2500,slideshowStart:"start slideshow",slideshowStop:"stop slideshow",photoRegex:/\.(gif|png|jp(e|g|eg)|bmp|ico|webp)((#|\?).*)?$/i,onOpen:!1,onLoad:!1,onComplete:!1,onCleanup:!1,onClosed:!1,overlayClose:!0,escKey:!0,arrowKey:!0,top:!1,bottom:!1,left:!1,right:!1,fixed:!1,data:void 0},Z="colorbox",te="cbox",ee=te+"Element",ie=te+"_open",oe=te+"_load",ne=te+"_complete",re=te+"_cleanup",he=te+"_closed",le=te+"_purge",se=t("<a/>"),ae="div",de=0;t.colorbox||(t(p),J=t.fn[Z]=t[Z]=function(e,i){var o=this;if(e=e||{},p(),m()){if(t.isFunction(o))o=t("<a/>"),e.open=!0;else if(!o[0])return o;i&&(e.onComplete=i),o.each(function(){t.data(this,Z,t.extend({},t.data(this,Z)||Y,e))}).addClass(ee),(t.isFunction(e.open)&&e.open.call(o)||e.open)&&f(o[0])}return o},J.position=function(t,e){function i(t){b[0].style.width=k[0].style.width=v[0].style.width=parseInt(t.style.width,10)-B+"px",v[0].style.height=T[0].style.height=C[0].style.height=parseInt(t.style.height,10)-D+"px"}var o,r,l,s=0,a=0,d=x.offset();H.unbind("resize."+te),x.css({top:-9e4,left:-9e4}),r=H.scrollTop(),l=H.scrollLeft(),_.fixed?(d.top-=r,d.left-=l,x.css({position:"fixed"})):(s=r,a=l,x.css({position:"absolute"})),a+=_.right!==!1?Math.max(H.width()-_.w-z-B-h(_.right,"x"),0):_.left!==!1?h(_.left,"x"):Math.round(Math.max(H.width()-_.w-z-B,0)/2),s+=_.bottom!==!1?Math.max(n()-_.h-N-D-h(_.bottom,"y"),0):_.top!==!1?h(_.top,"y"):Math.round(Math.max(n()-_.h-N-D,0)/2),x.css({top:d.top,left:d.left,visibility:"visible"}),t=x.width()===_.w+z&&x.height()===_.h+N?0:t||0,y[0].style.width=y[0].style.height="9999px",o={width:_.w+z+B,height:_.h+N+D,top:s,left:a},0===t&&x.css(o),x.dequeue().animate(o,{duration:t,complete:function(){i(this),q=!1,y[0].style.width=_.w+z+B+"px",y[0].style.height=_.h+N+D+"px",_.reposition&&setTimeout(function(){H.bind("resize."+te,J.position)},1),e&&e()},step:function(){i(this)}})},J.resize=function(t){var e;$&&(t=t||{},t.width&&(_.w=h(t.width,"x")-z-B),t.innerWidth&&(_.w=h(t.innerWidth,"x")),W.css({width:_.w}),t.height&&(_.h=h(t.height,"y")-N-D),t.innerHeight&&(_.h=h(t.innerHeight,"y")),t.innerHeight||t.height||(e=W.scrollTop(),W.css({height:"auto"}),_.h=W.height()),W.css({height:_.h}),e&&W.scrollTop(e),J.position("none"===_.transition?0:_.speed))},J.prep=function(e){function i(){return _.w=_.w||W.width(),_.w=_.mw&&_.mw<_.w?_.mw:_.w,_.w}function n(){return _.h=_.h||W.height(),_.h=_.mh&&_.mh<_.h?_.mh:_.h,_.h}if($){var h,a="none"===_.transition?0:_.speed;W.empty().remove(),W=o(ae,"LoadedContent").append(e),W.hide().appendTo(F.show()).css({width:i(),overflow:_.scrolling?"auto":"hidden"}).css({height:n()}).prependTo(v),F.hide(),t(U).css({"float":"none"}),h=function(){function e(){t.support.opacity===!1&&x[0].style.removeAttribute("filter")}var i,n,h=E.length,d="frameBorder",u="allowTransparency";$&&(n=function(){clearTimeout(Q),L.hide(),c(ne,_.onComplete)},S.html(_.title).add(W).show(),h>1?("string"==typeof _.current&&I.html(_.current.replace("{current}",j+1).replace("{total}",h)).show(),R[_.loop||h-1>j?"show":"hide"]().html(_.next),P[_.loop||j?"show":"hide"]().html(_.previous),_.slideshow&&M.show(),_.preloading&&t.each([r(-1),r(1)],function(){var e,i,o=E[this],n=t.data(o,Z);n&&n.href?(e=n.href,t.isFunction(e)&&(e=e.call(o))):e=t(o).attr("href"),e&&l(n,e)&&(e=s(n,e),i=new Image,i.src=e)})):O.hide(),_.iframe?(i=o("iframe")[0],d in i&&(i[d]=0),u in i&&(i[u]="true"),_.scrolling||(i.scrolling="no"),t(i).attr({src:_.href,name:(new Date).getTime(),"class":te+"Iframe",allowFullScreen:!0,webkitAllowFullScreen:!0,mozallowfullscreen:!0}).one("load",n).appendTo(W),se.one(le,function(){i.src="//about:blank"}),_.fastIframe&&t(i).trigger("load")):n(),"fade"===_.transition?x.fadeTo(a,1,e):e())},"fade"===_.transition?x.fadeTo(a,0,function(){J.position(0,h)}):J.position(a,h)}},J.next=function(){!q&&E[1]&&(_.loop||E[j+1])&&(j=r(1),f(E[j]))},J.prev=function(){!q&&E[1]&&(_.loop||j)&&(j=r(-1),f(E[j]))},J.close=function(){$&&!G&&(G=!0,$=!1,c(re,_.onCleanup),H.unbind("."+te),g.fadeTo(_.fadeOut||0,0),x.stop().fadeTo(_.fadeOut||0,0,function(){x.add(g).css({opacity:1,cursor:"auto"}).hide(),c(le),W.empty().remove(),setTimeout(function(){G=!1,c(he,_.onClosed)},1)}))},J.remove=function(){x&&(x.stop(),t.colorbox.close(),x.stop().remove(),g.remove(),G=!1,x=null,t("."+ee).removeData(Z).removeClass(ee),t(e).unbind("click."+te))},J.element=function(){return t(A)},J.settings=Y)})(jQuery,document,window);;
(function ($) {

Drupal.behaviors.initColorbox = {
  attach: function (context, settings) {
    if (!$.isFunction($.colorbox)) {
      return;
    }

    if (settings.colorbox.mobiledetect && window.matchMedia) {
      // Disable Colorbox for small screens.
      mq = window.matchMedia("(max-device-width: " + settings.colorbox.mobiledevicewidth + ")");
      if (mq.matches) {
        return;
      }
    }

    $('.colorbox', context)
      .once('init-colorbox')
      .colorbox(settings.colorbox);
  }
};

{
  $(document).bind('cbox_complete', function () {
    Drupal.attachBehaviors('#cboxLoadedContent');
  });
}

})(jQuery);
;
(function ($) {

Drupal.behaviors.initColorboxDefaultStyle = {
  attach: function (context, settings) {
    $(document).bind('cbox_complete', function () {
      // Only run if there is a title.
      if ($('#cboxTitle:empty', context).length == false) {
        $('#cboxLoadedContent img', context).bind('mouseover', function () {
          $('#cboxTitle', context).slideDown();
        });
        $('#cboxOverlay', context).bind('mouseover', function () {
          $('#cboxTitle', context).slideUp();
        });
      }
      else {
        $('#cboxTitle', context).hide();
      }
    });
  }
};

})(jQuery);
;
(function ($) {

Drupal.behaviors.initColorboxInline = {
  attach: function (context, settings) {
    if (!$.isFunction($.colorbox)) {
      return;
    }
    $.urlParam = function(name, url){
      if (name == 'fragment') {
        var results = new RegExp('(#[^&#]*)').exec(url);
      }
      else {
        var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(url);
      }
      if (!results) { return ''; }
      return results[1] || '';
    };
    $('.colorbox-inline', context).once('init-colorbox-inline').colorbox({
      transition:settings.colorbox.transition,
      speed:settings.colorbox.speed,
      opacity:settings.colorbox.opacity,
      slideshow:settings.colorbox.slideshow,
      slideshowAuto:settings.colorbox.slideshowAuto,
      slideshowSpeed:settings.colorbox.slideshowSpeed,
      slideshowStart:settings.colorbox.slideshowStart,
      slideshowStop:settings.colorbox.slideshowStop,
      current:settings.colorbox.current,
      previous:settings.colorbox.previous,
      next:settings.colorbox.next,
      close:settings.colorbox.close,
      overlayClose:settings.colorbox.overlayClose,
      maxWidth:settings.colorbox.maxWidth,
      maxHeight:settings.colorbox.maxHeight,
      innerWidth:function(){
        return $.urlParam('width', $(this).attr('href'));
      },
      innerHeight:function(){
        return $.urlParam('height', $(this).attr('href'));
      },
      title:function(){
        return decodeURIComponent($.urlParam('title', $(this).attr('href')));
      },
      iframe:function(){
        return $.urlParam('iframe', $(this).attr('href'));
      },
      inline:function(){
        return $.urlParam('inline', $(this).attr('href'));
      },
      href:function(){
        return $.urlParam('fragment', $(this).attr('href'));
      }
    });
  }
};

})(jQuery);
;
(function ($) {
    
Drupal.behaviors.jquerymenu = { 
    attach:function(context) {    
    

  $('ul.jquerymenu .open').parents('li').removeClass('closed').addClass('open');
  $('ul.jquerymenu .open').parents('li').children('span.parent').removeClass('closed').addClass('open').slideDown('700');
  $('ul.jquerymenu .active').parents('li').removeClass('closed').addClass('open');
  $('ul.jquerymenu .active').parents('li').children('span.parent').removeClass('closed').addClass('open');  

    
  // create functions for hover effects  
  jqm_showit = function() {
    $(this).children('.jqm_link_edit').fadeIn();
  }
  jqm_hideit = function() {
    $(this).children('.jqm_link_edit').fadeOut();
  }
  $('ul.jquerymenu li').hover(jqm_showit, jqm_hideit);
  
  jqm_mouseenter = function() {
    momma = $(this);
    if ($(momma).hasClass('closed')){
      if (Drupal.settings.jquerymenu.animate === 1) {
        $($(this).siblings('ul').children()).hide().fadeIn('3000');
        $(momma).children('ul').slideDown('700');
      }
      $(momma).removeClass('closed').addClass('open');
      $(this).removeClass('closed').addClass('open');
    } 
  }
  
  jqm_mouseleave = function(){
    momma = $(this);
    if ($(momma).hasClass('open')){
      if (Drupal.settings.jquerymenu.animate === 1) {
        $(momma).children('ul').slideUp('700');
        $($(this).siblings('ul').children()).fadeOut('3000');
      }
      $(momma).removeClass('open').addClass('closed');
      $(this).removeClass('open').addClass('closed');
    }   
  }
  
  // set selector variable
  var selector = "li.parent span.parent";
  if (Drupal.settings.jquerymenu.click_to_expand) {
    selector = selector + ', li.parent > a';
  }  

  // if hover, change menu state
  if (Drupal.settings.jquerymenu.hover === 1) {
    $('ul.jquerymenu:not(.jquerymenu-processed)', context).addClass('jquerymenu-processed').each(function(){
      $(this).find(selector).hover(jqm_mouseenter, jqm_mouseleave);
    });
    // remove the + and - boxes
    $('ul.jquerymenu-processed span.parent').remove();
    return false;
  }

  // if not hover, change menu state on click 
  else if (Drupal.settings.jquerymenu.hover === 0) {
    $('ul.jquerymenu:not(.jquerymenu-processed)', context).addClass('jquerymenu-processed').each(function(){
      $(this).find(selector).click(function(){
        momma = $(this).parent();
        if ($(momma).hasClass('closed')){
          if (Drupal.settings.jquerymenu.animate === 1) {
            $($(this).siblings('ul').children()).hide().fadeIn('3000');
            $(momma).children('ul').slideDown('700');
          }
          $(momma).removeClass('closed').addClass('open');
          $(this).removeClass('closed').addClass('open');
          return false;
        }
        else{
          if (Drupal.settings.jquerymenu.animate === 1) {          
            $(momma).children('ul').slideUp('700');
            $($(this).siblings('ul').children()).fadeOut('3000');
          }
          $(momma).removeClass('open').addClass('closed');
          $(this).removeClass('open').addClass('closed');
          return false;
        }
      });
    });
  }
}
}
})(jQuery);;
/**
 * Cookie plugin
 *
 * Copyright (c) 2006 Klaus Hartl (stilbuero.de)
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 */
jQuery.cookie=function(name,value,options){if(typeof value!='undefined'){options=options||{};if(value===null){value='';options.expires=-1;}
var expires='';if(options.expires&&(typeof options.expires=='number'||options.expires.toUTCString)){var date;if(typeof options.expires=='number'){date=new Date();date.setTime(date.getTime()+(options.expires*24*60*60*1000));}else{date=options.expires;}
expires='; expires='+date.toUTCString();}
var path=options.path?'; path='+(options.path):'';var domain=options.domain?'; domain='+(options.domain):'';var secure=options.secure?'; secure':'';document.cookie=[name,'=',encodeURIComponent(value),expires,path,domain,secure].join('');}else{var cookieValue=null;if(document.cookie&&document.cookie!=''){var cookies=document.cookie.split(';');for(var i=0;i<cookies.length;i++){var cookie=jQuery.trim(cookies[i]);if(cookie.substring(0,name.length+1)==(name+'=')){cookieValue=decodeURIComponent(cookie.substring(name.length+1));break;}}}
return cookieValue;}};;
(function($){Drupal.behaviors.pollanonHandleVoteView={attach:function(a){if(typeof PollAnon=='undefined'||!PollAnon.nid){return}cookieName='pa-'+PollAnon.nid;$('form.pollanon').fadeIn('fast');if($.cookie(cookieName)){$hiddenResults=$('.pollanon-poll-results.hidden');if($hiddenResults.length>0){$poll_form=$('form.pollanon .vote-form');$('.form-radios, .form-submit',$poll_form).hide();$hiddenResults.hide();$hiddenResults.removeClass('hidden');$hiddenResults.fadeIn('fast')}}else{ua=navigator.userAgent;uaI=Math.floor(ua.length/2);pollanonKey=ua?ua.substring(uaI,uaI+2)+ua.length:'';pollanonKey+='-'+new Date().getTime();$.cookie('pa-submit',pollanonKey,{path:'/'});$('form.pollanon input[name="pollanonkey"]',a).attr('value',pollanonKey)}msg=$.cookie('pa-messages');if(msg){msg=unescape(msg.replace(/\+/g," "));$('form.pollanon').before('<div class="messages status">'+msg+'</div>');$.cookie('pa-messages',null,{path:'/'})}}}})(jQuery);;
"undefined"==typeof jwplayer&&(jwplayer=function(f){if(jwplayer.api)return jwplayer.api.selectPlayer(f)},jwplayer.version="6.5.3609",jwplayer.vid=document.createElement("video"),jwplayer.audio=document.createElement("audio"),jwplayer.source=document.createElement("source"),function(f){function a(h){return function(){return d(h)}}var k=document,e=window,c=navigator,b=f.utils=function(){};b.exists=function(h){switch(typeof h){case "string":return 0<h.length;case "object":return null!==h;case "undefined":return!1}return!0};
b.styleDimension=function(h){return h+(0<h.toString().indexOf("%")?"":"px")};b.getAbsolutePath=function(h,a){b.exists(a)||(a=k.location.href);if(b.exists(h)){var d;if(b.exists(h)){d=h.indexOf("://");var c=h.indexOf("?");d=0<d&&(0>c||c>d)}else d=void 0;if(d)return h;d=a.substring(0,a.indexOf("://")+3);var c=a.substring(d.length,a.indexOf("/",d.length+1)),e;0===h.indexOf("/")?e=h.split("/"):(e=a.split("?")[0],e=e.substring(d.length+c.length+1,e.lastIndexOf("/")),e=e.split("/").concat(h.split("/")));
for(var g=[],m=0;m<e.length;m++)e[m]&&(b.exists(e[m])&&"."!=e[m])&&(".."==e[m]?g.pop():g.push(e[m]));return d+c+"/"+g.join("/")}};b.extend=function(){var a=b.extend.arguments;if(1<a.length){for(var d=1;d<a.length;d++)b.foreach(a[d],function(d,c){try{b.exists(c)&&(a[0][d]=c)}catch(e){}});return a[0]}return null};b.log=function(a,b){"undefined"!=typeof console&&"undefined"!=typeof console.log&&(b?console.log(a,b):console.log(a))};var d=b.userAgentMatch=function(a){return null!==c.userAgent.toLowerCase().match(a)};
b.isIE=a(/msie/i);b.isFF=a(/firefox/i);b.isChrome=a(/chrome/i);b.isIOS=a(/iP(hone|ad|od)/i);b.isIPod=a(/iP(hone|od)/i);b.isIPad=a(/iPad/i);b.isSafari602=a(/Macintosh.*Mac OS X 10_8.*6\.0\.\d* Safari/i);b.isAndroid=function(a){return a?d(RegExp("android.*"+a,"i")):d(/android/i)};b.isMobile=function(){return b.isIOS()||b.isAndroid()};b.saveCookie=function(a,b){k.cookie="jwplayer."+a+"\x3d"+b+"; path\x3d/"};b.getCookies=function(){for(var a={},b=k.cookie.split("; "),d=0;d<b.length;d++){var c=b[d].split("\x3d");
0==c[0].indexOf("jwplayer.")&&(a[c[0].substring(9,c[0].length)]=c[1])}return a};b.typeOf=function(a){var b=typeof a;return"object"===b?!a?"null":a instanceof Array?"array":b:b};b.translateEventResponse=function(a,d){var c=b.extend({},d);a==f.events.JWPLAYER_FULLSCREEN&&!c.fullscreen?(c.fullscreen="true"==c.message?!0:!1,delete c.message):"object"==typeof c.data?(c=b.extend(c,c.data),delete c.data):"object"==typeof c.metadata&&b.deepReplaceKeyName(c.metadata,["__dot__","__spc__","__dsh__","__default__"],
["."," ","-","default"]);b.foreach(["position","duration","offset"],function(a,b){c[b]&&(c[b]=Math.round(1E3*c[b])/1E3)});return c};b.flashVersion=function(){if(b.isAndroid())return 0;var a=c.plugins,d;try{if("undefined"!==a&&(d=a["Shockwave Flash"]))return parseInt(d.description.replace(/\D+(\d+)\..*/,"$1"))}catch(n){}if("undefined"!=typeof e.ActiveXObject)try{if(d=new ActiveXObject("ShockwaveFlash.ShockwaveFlash"))return parseInt(d.GetVariable("$version").split(" ")[1].split(",")[0])}catch(f){}return 0};
b.getScriptPath=function(a){for(var b=k.getElementsByTagName("script"),d=0;d<b.length;d++){var c=b[d].src;if(c&&0<=c.indexOf(a))return c.substr(0,c.indexOf(a))}return""};b.deepReplaceKeyName=function(a,d,c){switch(f.utils.typeOf(a)){case "array":for(var e=0;e<a.length;e++)a[e]=f.utils.deepReplaceKeyName(a[e],d,c);break;case "object":b.foreach(a,function(b,g){var e;if(d instanceof Array&&c instanceof Array){if(d.length!=c.length)return;e=d}else e=[d];for(var n=b,k=0;k<e.length;k++)n=n.replace(RegExp(d[k],
"g"),c[k]);a[n]=f.utils.deepReplaceKeyName(g,d,c);b!=n&&delete a[b]})}return a};var n=b.pluginPathType={ABSOLUTE:0,RELATIVE:1,CDN:2};b.getPluginPathType=function(a){if("string"==typeof a){a=a.split("?")[0];var d=a.indexOf("://");if(0<d)return n.ABSOLUTE;var c=a.indexOf("/");a=b.extension(a);return 0>d&&0>c&&(!a||!isNaN(a))?n.CDN:n.RELATIVE}};b.getPluginName=function(a){return a.replace(/^(.*\/)?([^-]*)-?.*\.(swf|js)$/,"$2")};b.getPluginVersion=function(a){return a.replace(/[^-]*-?([^\.]*).*$/,"$1")};
b.isYouTube=function(a){return-1<a.indexOf("youtube.com")||-1<a.indexOf("youtu.be")};b.isRtmp=function(a,b){return 0==a.indexOf("rtmp")||"rtmp"==b};b.foreach=function(a,b){var d,c;for(d in a)a.hasOwnProperty(d)&&(c=a[d],b(d,c))};b.isHTTPS=function(){return 0==e.location.href.indexOf("https")};b.repo=function(){var a="http://p.jwpcdn.com/"+f.version.split(/\W/).splice(0,2).join("/")+"/";try{b.isHTTPS()&&(a=a.replace("http://","https://ssl."))}catch(d){}return a}}(jwplayer),function(f){var a="video/",
k=f.foreach,e={mp4:a+"mp4",vorbis:"audio/ogg",ogg:a+"ogg",webm:a+"webm",aac:"audio/mp4",mp3:"audio/mpeg",hls:"application/vnd.apple.mpegurl"},c={mp4:e.mp4,f4v:e.mp4,m4v:e.mp4,mov:e.mp4,m4a:e.aac,f4a:e.aac,aac:e.aac,mp3:e.mp3,ogv:e.ogg,ogg:e.vorbis,oga:e.vorbis,webm:e.webm,m3u8:e.hls,hls:e.hls},a="video",a={flv:a,f4v:a,mov:a,m4a:a,m4v:a,mp4:a,aac:a,f4a:a,mp3:"sound",smil:"rtmp",m3u8:"hls",hls:"hls"},b=f.extensionmap={};k(c,function(a,c){b[a]={html5:c}});k(a,function(a,c){b[a]||(b[a]={});b[a].flash=
c});b.types=e;b.mimeType=function(a){var b;k(e,function(c,e){!b&&e==a&&(b=c)});return b};b.extType=function(a){return b.mimeType(c[a])}}(jwplayer.utils),function(f){var a=f.loaderstatus={NEW:0,LOADING:1,ERROR:2,COMPLETE:3},k=document;f.scriptloader=function(e){function c(){d=a.ERROR;h.sendEvent(n.ERROR)}function b(){d=a.COMPLETE;h.sendEvent(n.COMPLETE)}var d=a.NEW,n=jwplayer.events,h=new n.eventdispatcher;f.extend(this,h);this.load=function(){var h=f.scriptloader.loaders[e];if(h&&(h.getStatus()==
a.NEW||h.getStatus()==a.LOADING))h.addEventListener(n.ERROR,c),h.addEventListener(n.COMPLETE,b);else if(f.scriptloader.loaders[e]=this,d==a.NEW){d=a.LOADING;var p=k.createElement("script");p.addEventListener?(p.onload=b,p.onerror=c):p.readyState&&(p.onreadystatechange=function(){("loaded"==p.readyState||"complete"==p.readyState)&&b()});k.getElementsByTagName("head")[0].appendChild(p);p.src=e}};this.getStatus=function(){return d}};f.scriptloader.loaders={}}(jwplayer.utils),function(f){f.trim=function(a){return a.replace(/^\s*/,
"").replace(/\s*$/,"")};f.pad=function(a,f,e){for(e||(e="0");a.length<f;)a=e+a;return a};f.xmlAttribute=function(a,f){for(var e=0;e<a.attributes.length;e++)if(a.attributes[e].name&&a.attributes[e].name.toLowerCase()==f.toLowerCase())return a.attributes[e].value.toString();return""};f.extension=function(a){if(!a||"rtmp"==a.substr(0,4))return"";a=a.substring(a.lastIndexOf("/")+1,a.length).split("?")[0].split("#")[0];if(-1<a.lastIndexOf("."))return a.substr(a.lastIndexOf(".")+1,a.length).toLowerCase()};
f.stringToColor=function(a){a=a.replace(/(#|0x)?([0-9A-F]{3,6})$/gi,"$2");3==a.length&&(a=a.charAt(0)+a.charAt(0)+a.charAt(1)+a.charAt(1)+a.charAt(2)+a.charAt(2));return parseInt(a,16)}}(jwplayer.utils),function(f){f.key=function(a){var k,e,c;this.edition=function(){return c&&c.getTime()<(new Date).getTime()?"invalid":k};this.token=function(){return e};f.exists(a)||(a="");try{a=f.tea.decrypt(a,"36QXq4W@GSBV^teR");var b=a.split("/");(k=b[0])?/^(free|pro|premium|ads)$/i.test(k)?(e=b[1],b[2]&&0<parseInt(b[2])&&
(c=new Date,c.setTime(String(b[2])))):k="invalid":k="free"}catch(d){k="invalid"}}}(jwplayer.utils),function(f){var a=f.tea={};a.encrypt=function(c,b){if(0==c.length)return"";var d=a.strToLongs(e.encode(c));1>=d.length&&(d[1]=0);for(var n=a.strToLongs(e.encode(b).slice(0,16)),h=d.length,f=d[h-1],p=d[0],q,j=Math.floor(6+52/h),g=0;0<j--;){g+=2654435769;q=g>>>2&3;for(var m=0;m<h;m++)p=d[(m+1)%h],f=(f>>>5^p<<2)+(p>>>3^f<<4)^(g^p)+(n[m&3^q]^f),f=d[m]+=f}d=a.longsToStr(d);return k.encode(d)};a.decrypt=function(c,
b){if(0==c.length)return"";for(var d=a.strToLongs(k.decode(c)),n=a.strToLongs(e.encode(b).slice(0,16)),h=d.length,f=d[h-1],p=d[0],q,j=2654435769*Math.floor(6+52/h);0!=j;){q=j>>>2&3;for(var g=h-1;0<=g;g--)f=d[0<g?g-1:h-1],f=(f>>>5^p<<2)+(p>>>3^f<<4)^(j^p)+(n[g&3^q]^f),p=d[g]-=f;j-=2654435769}d=a.longsToStr(d);d=d.replace(/\0+$/,"");return e.decode(d)};a.strToLongs=function(a){for(var b=Array(Math.ceil(a.length/4)),d=0;d<b.length;d++)b[d]=a.charCodeAt(4*d)+(a.charCodeAt(4*d+1)<<8)+(a.charCodeAt(4*d+
2)<<16)+(a.charCodeAt(4*d+3)<<24);return b};a.longsToStr=function(a){for(var b=Array(a.length),d=0;d<a.length;d++)b[d]=String.fromCharCode(a[d]&255,a[d]>>>8&255,a[d]>>>16&255,a[d]>>>24&255);return b.join("")};var k={code:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d",encode:function(a,b){var d,n,h,f,p=[],q="",j,g,m=k.code;g=("undefined"==typeof b?0:b)?e.encode(a):a;j=g.length%3;if(0<j)for(;3>j++;)q+="\x3d",g+="\x00";for(j=0;j<g.length;j+=3)d=g.charCodeAt(j),n=g.charCodeAt(j+
1),h=g.charCodeAt(j+2),f=d<<16|n<<8|h,d=f>>18&63,n=f>>12&63,h=f>>6&63,f&=63,p[j/3]=m.charAt(d)+m.charAt(n)+m.charAt(h)+m.charAt(f);p=p.join("");return p=p.slice(0,p.length-q.length)+q},decode:function(a,b){b="undefined"==typeof b?!1:b;var d,f,h,r,p,q=[],j,g=k.code;j=b?e.decode(a):a;for(var m=0;m<j.length;m+=4)d=g.indexOf(j.charAt(m)),f=g.indexOf(j.charAt(m+1)),r=g.indexOf(j.charAt(m+2)),p=g.indexOf(j.charAt(m+3)),h=d<<18|f<<12|r<<6|p,d=h>>>16&255,f=h>>>8&255,h&=255,q[m/4]=String.fromCharCode(d,f,
h),64==p&&(q[m/4]=String.fromCharCode(d,f)),64==r&&(q[m/4]=String.fromCharCode(d));r=q.join("");return b?e.decode(r):r}},e={encode:function(a){a=a.replace(/[\u0080-\u07ff]/g,function(a){a=a.charCodeAt(0);return String.fromCharCode(192|a>>6,128|a&63)});return a=a.replace(/[\u0800-\uffff]/g,function(a){a=a.charCodeAt(0);return String.fromCharCode(224|a>>12,128|a>>6&63,128|a&63)})},decode:function(a){a=a.replace(/[\u00e0-\u00ef][\u0080-\u00bf][\u0080-\u00bf]/g,function(a){a=(a.charCodeAt(0)&15)<<12|
(a.charCodeAt(1)&63)<<6|a.charCodeAt(2)&63;return String.fromCharCode(a)});return a=a.replace(/[\u00c0-\u00df][\u0080-\u00bf]/g,function(a){a=(a.charCodeAt(0)&31)<<6|a.charCodeAt(1)&63;return String.fromCharCode(a)})}}}(jwplayer.utils),function(f){f.events={COMPLETE:"COMPLETE",ERROR:"ERROR",API_READY:"jwplayerAPIReady",JWPLAYER_READY:"jwplayerReady",JWPLAYER_FULLSCREEN:"jwplayerFullscreen",JWPLAYER_RESIZE:"jwplayerResize",JWPLAYER_ERROR:"jwplayerError",JWPLAYER_SETUP_ERROR:"jwplayerSetupError",JWPLAYER_MEDIA_BEFOREPLAY:"jwplayerMediaBeforePlay",
JWPLAYER_MEDIA_BEFORECOMPLETE:"jwplayerMediaBeforeComplete",JWPLAYER_COMPONENT_SHOW:"jwplayerComponentShow",JWPLAYER_COMPONENT_HIDE:"jwplayerComponentHide",JWPLAYER_MEDIA_BUFFER:"jwplayerMediaBuffer",JWPLAYER_MEDIA_BUFFER_FULL:"jwplayerMediaBufferFull",JWPLAYER_MEDIA_ERROR:"jwplayerMediaError",JWPLAYER_MEDIA_LOADED:"jwplayerMediaLoaded",JWPLAYER_MEDIA_COMPLETE:"jwplayerMediaComplete",JWPLAYER_MEDIA_SEEK:"jwplayerMediaSeek",JWPLAYER_MEDIA_TIME:"jwplayerMediaTime",JWPLAYER_MEDIA_VOLUME:"jwplayerMediaVolume",
JWPLAYER_MEDIA_META:"jwplayerMediaMeta",JWPLAYER_MEDIA_MUTE:"jwplayerMediaMute",JWPLAYER_MEDIA_LEVELS:"jwplayerMediaLevels",JWPLAYER_MEDIA_LEVEL_CHANGED:"jwplayerMediaLevelChanged",JWPLAYER_CAPTIONS_CHANGED:"jwplayerCaptionsChanged",JWPLAYER_CAPTIONS_LIST:"jwplayerCaptionsList",JWPLAYER_PLAYER_STATE:"jwplayerPlayerState",state:{BUFFERING:"BUFFERING",IDLE:"IDLE",PAUSED:"PAUSED",PLAYING:"PLAYING"},JWPLAYER_PLAYLIST_LOADED:"jwplayerPlaylistLoaded",JWPLAYER_PLAYLIST_ITEM:"jwplayerPlaylistItem",JWPLAYER_PLAYLIST_COMPLETE:"jwplayerPlaylistComplete",
JWPLAYER_DISPLAY_CLICK:"jwplayerViewClick",JWPLAYER_CONTROLS:"jwplayerViewControls",JWPLAYER_INSTREAM_CLICK:"jwplayerInstreamClicked",JWPLAYER_INSTREAM_DESTROYED:"jwplayerInstreamDestroyed",JWPLAYER_AD_TIME:"jwplayerAdTime",JWPLAYER_AD_ERROR:"jwplayerAdError",JWPLAYER_AD_CLICK:"jwplayerAdClicked",JWPLAYER_AD_COMPLETE:"jwplayerAdComplete",JWPLAYER_AD_IMPRESSION:"jwplayerAdImpression",JWPLAYER_AD_COMPANIONS:"jwplayerAdCompanions"}}(jwplayer),function(f){var a=jwplayer.utils;f.eventdispatcher=function(f,
e){var c,b;this.resetEventListeners=function(){c={};b=[]};this.resetEventListeners();this.addEventListener=function(b,e,h){try{a.exists(c[b])||(c[b]=[]),"string"==a.typeOf(e)&&(e=(new Function("return "+e))()),c[b].push({listener:e,count:h})}catch(f){a.log("error",f)}return!1};this.removeEventListener=function(b,e){if(c[b]){try{for(var h=0;h<c[b].length;h++)if(c[b][h].listener.toString()==e.toString()){c[b].splice(h,1);break}}catch(f){a.log("error",f)}return!1}};this.addGlobalListener=function(d,
c){try{"string"==a.typeOf(d)&&(d=(new Function("return "+d))()),b.push({listener:d,count:c})}catch(e){a.log("error",e)}return!1};this.removeGlobalListener=function(d){if(d){try{for(var c=0;c<b.length;c++)if(b[c].listener.toString()==d.toString()){b.splice(c,1);break}}catch(e){a.log("error",e)}return!1}};this.sendEvent=function(d,n){a.exists(n)||(n={});a.extend(n,{id:f,version:jwplayer.version,type:d});e&&a.log(d,n);if("undefined"!=a.typeOf(c[d]))for(var h=0;h<c[d].length;h++){try{c[d][h].listener(n)}catch(r){a.log("There was an error while handling a listener: "+
r.toString(),c[d][h].listener)}c[d][h]&&(1===c[d][h].count?delete c[d][h]:0<c[d][h].count&&(c[d][h].count-=1))}for(h=0;h<b.length;h++){try{b[h].listener(n)}catch(p){a.log("There was an error while handling a listener: "+p.toString(),b[h].listener)}b[h]&&(1===b[h].count?delete b[h]:0<b[h].count&&(b[h].count-=1))}}}}(jwplayer.events),function(f){var a={},k={};f.plugins=function(){};f.plugins.loadPlugins=function(e,c){k[e]=new f.plugins.pluginloader(new f.plugins.model(a),c);return k[e]};f.plugins.registerPlugin=
function(e,c,b,d){var n=f.utils.getPluginName(e);a[n]||(a[n]=new f.plugins.plugin(e));a[n].registerPlugin(e,c,b,d)}}(jwplayer),function(f){f.plugins.model=function(a){this.addPlugin=function(k){var e=f.utils.getPluginName(k);a[e]||(a[e]=new f.plugins.plugin(k));return a[e]};this.getPlugins=function(){return a}}}(jwplayer),function(f){var a=jwplayer.utils,k=jwplayer.events;f.pluginmodes={FLASH:0,JAVASCRIPT:1,HYBRID:2};f.plugin=function(e){function c(){switch(a.getPluginPathType(e)){case a.pluginPathType.ABSOLUTE:return e;
case a.pluginPathType.RELATIVE:return a.getAbsolutePath(e,window.location.href)}}function b(){q=setTimeout(function(){n=a.loaderstatus.COMPLETE;j.sendEvent(k.COMPLETE)},1E3)}function d(){n=a.loaderstatus.ERROR;j.sendEvent(k.ERROR)}var n=a.loaderstatus.NEW,h,r,p,q,j=new k.eventdispatcher;a.extend(this,j);this.load=function(){if(n==a.loaderstatus.NEW)if(0<e.lastIndexOf(".swf"))h=e,n=a.loaderstatus.COMPLETE,j.sendEvent(k.COMPLETE);else if(a.getPluginPathType(e)==a.pluginPathType.CDN)n=a.loaderstatus.COMPLETE,
j.sendEvent(k.COMPLETE);else{n=a.loaderstatus.LOADING;var g=new a.scriptloader(c());g.addEventListener(k.COMPLETE,b);g.addEventListener(k.ERROR,d);g.load()}};this.registerPlugin=function(b,d,c,e){q&&(clearTimeout(q),q=void 0);p=d;c&&e?(h=e,r=c):"string"==typeof c?h=c:"function"==typeof c?r=c:!c&&!e&&(h=b);n=a.loaderstatus.COMPLETE;j.sendEvent(k.COMPLETE)};this.getStatus=function(){return n};this.getPluginName=function(){return a.getPluginName(e)};this.getFlashPath=function(){if(h)switch(a.getPluginPathType(h)){case a.pluginPathType.ABSOLUTE:return h;
case a.pluginPathType.RELATIVE:return 0<e.lastIndexOf(".swf")?a.getAbsolutePath(h,window.location.href):a.getAbsolutePath(h,c())}return null};this.getJS=function(){return r};this.getTarget=function(){return p};this.getPluginmode=function(){if("undefined"!=typeof h&&"undefined"!=typeof r)return f.pluginmodes.HYBRID;if("undefined"!=typeof h)return f.pluginmodes.FLASH;if("undefined"!=typeof r)return f.pluginmodes.JAVASCRIPT};this.getNewInstance=function(a,b,d){return new r(a,b,d)};this.getURL=function(){return e}}}(jwplayer.plugins),
function(f){var a=f.utils,k=f.events,e=a.foreach;f.plugins.pluginloader=function(c,b){function d(){p?g.sendEvent(k.ERROR,{message:q}):r||(r=!0,h=a.loaderstatus.COMPLETE,g.sendEvent(k.COMPLETE))}function n(){j||d();if(!r&&!p){var b=0,e=c.getPlugins();a.foreach(j,function(c){c=a.getPluginName(c);var g=e[c];c=g.getJS();var h=g.getTarget(),g=g.getStatus();if(g==a.loaderstatus.LOADING||g==a.loaderstatus.NEW)b++;else if(c&&(!h||parseFloat(h)>parseFloat(f.version)))p=!0,q="Incompatible player version",d()});
0==b&&d()}}var h=a.loaderstatus.NEW,r=!1,p=!1,q,j=b,g=new k.eventdispatcher;a.extend(this,g);this.setupPlugins=function(b,d,g){var h={length:0,plugins:{}},m=0,f={},j=c.getPlugins();e(d.plugins,function(c,e){var A=a.getPluginName(c),n=j[A],k=n.getFlashPath(),p=n.getJS(),q=n.getURL();k&&(h.plugins[k]=a.extend({},e),h.plugins[k].pluginmode=n.getPluginmode(),h.length++);try{if(p&&d.plugins&&d.plugins[q]){var r=document.createElement("div");r.id=b.id+"_"+A;r.style.position="absolute";r.style.top=0;r.style.zIndex=
m+10;f[A]=n.getNewInstance(b,a.extend({},d.plugins[q]),r);m++;b.onReady(g(f[A],r,!0));b.onResize(g(f[A],r))}}catch(E){a.log("ERROR: Failed to load "+A+".")}});b.plugins=f;return h};this.load=function(){if(!(a.exists(b)&&"object"!=a.typeOf(b))){h=a.loaderstatus.LOADING;e(b,function(b){a.exists(b)&&(b=c.addPlugin(b),b.addEventListener(k.COMPLETE,n),b.addEventListener(k.ERROR,m))});var d=c.getPlugins();e(d,function(a,b){b.load()})}n()};var m=this.pluginFailed=function(){p||(p=!0,q="File not found",d())};
this.getStatus=function(){return h}}}(jwplayer),function(f){f.playlist=function(a){var k=[];if("array"==f.utils.typeOf(a))for(var e=0;e<a.length;e++)k.push(new f.playlist.item(a[e]));else k.push(new f.playlist.item(a));return k}}(jwplayer),function(f){var a=f.item=function(k){var e=jwplayer.utils,c=e.extend({},a.defaults,k);c.tracks=e.exists(k.tracks)?k.tracks:[];0==c.sources.length&&(c.sources=[new f.source(c)]);for(var b=0;b<c.sources.length;b++){var d=c.sources[b]["default"];c.sources[b]["default"]=
d?"true"==d.toString():!1;c.sources[b]=new f.source(c.sources[b])}if(c.captions&&!e.exists(k.tracks)){for(k=0;k<c.captions.length;k++)c.tracks.push(c.captions[k]);delete c.captions}for(b=0;b<c.tracks.length;b++)c.tracks[b]=new f.track(c.tracks[b]);return c};a.defaults={description:"",image:"",mediaid:"",title:"",sources:[],tracks:[]}}(jwplayer.playlist),function(f){var a=jwplayer.utils,k={file:void 0,label:void 0,type:void 0,"default":void 0};f.source=function(e){var c=a.extend({},k);a.foreach(k,
function(b){a.exists(e[b])&&(c[b]=e[b],delete e[b])});c.type&&0<c.type.indexOf("/")&&(c.type=a.extensionmap.mimeType(c.type));"m3u8"==c.type&&(c.type="hls");"smil"==c.type&&(c.type="rtmp");return c}}(jwplayer.playlist),function(f){var a=jwplayer.utils,k={file:void 0,label:void 0,kind:"captions","default":!1};f.track=function(e){var c=a.extend({},k);e||(e={});a.foreach(k,function(b){a.exists(e[b])&&(c[b]=e[b],delete e[b])});return c}}(jwplayer.playlist),function(f){var a=f.utils,k=f.events,e=!0,c=
!1,b=document,d=f.embed=function(n){function h(b,d){a.foreach(d,function(a,d){"function"==typeof b[a]&&b[a].call(b,d)})}function r(a){j(l,B+a.message)}function p(){j(l,B+"No playable sources found")}function q(){j(l,"Adobe SiteCatalyst Error: Could not find Media Module")}function j(b,d){if(m.fallback){var h=b.style;h.backgroundColor="#000";h.color="#FFF";h.width=a.styleDimension(m.width);h.height=a.styleDimension(m.height);h.display="table";h.opacity=1;var h=document.createElement("p"),f=h.style;
f.verticalAlign="middle";f.textAlign="center";f.display="table-cell";f.font="15px/20px Arial, Helvetica, sans-serif";h.innerHTML=d.replace(":",":\x3cbr\x3e");b.innerHTML="";b.appendChild(h);g(d,e)}else g(d,c)}function g(a,b){x&&(clearTimeout(x),x=null);n.dispatchEvent(k.JWPLAYER_SETUP_ERROR,{message:a,fallback:b})}var m=new d.config(n.config),l,t,u,w=m.width,z=m.height,B="Error loading player: ",y=f.plugins.loadPlugins(n.id,m.plugins),x=null;m.fallbackDiv&&(u=m.fallbackDiv,delete m.fallbackDiv);m.id=
n.id;t=b.getElementById(n.id);m.aspectratio?n.config.aspectratio=m.aspectratio:delete n.config.aspectratio;l=b.createElement("div");l.id=t.id;l.style.width=0<w.toString().indexOf("%")?w:w+"px";l.style.height=0<z.toString().indexOf("%")?z:z+"px";t.parentNode.replaceChild(l,t);f.embed.errorScreen=j;y.addEventListener(k.COMPLETE,function(){if(m.sitecatalyst)try{null!=s&&s.hasOwnProperty("Media")||q()}catch(b){q();return}if("array"==a.typeOf(m.playlist)&&2>m.playlist.length&&(0==m.playlist.length||!m.playlist[0].sources||
0==m.playlist[0].sources.length))p();else if(y.getStatus()==a.loaderstatus.COMPLETE){for(var f=0;f<m.modes.length;f++)if(m.modes[f].type&&d[m.modes[f].type]){var j=a.extend({},m),D=new d[m.modes[f].type](l,m.modes[f],j,y,n);if(D.supportsConfig())return D.addEventListener(k.ERROR,r),D.embed(),h(n,j.events),n}if(m.fallback){var t="No suitable players found and fallback enabled";x=setTimeout(function(){g(t,e)},10);a.log(t);new d.download(l,m,p)}else t="No suitable players found and fallback disabled",
g(t,c),a.log(t),l.parentNode.replaceChild(u,l)}});y.addEventListener(k.ERROR,function(a){j(l,"Could not load plugins: "+a.message)});y.load();return n}}(jwplayer),function(f){function a(a){if(a.playlist)for(var d=0;d<a.playlist.length;d++)a.playlist[d]=new c(a.playlist[d]);else{var f={};e.foreach(c.defaults,function(d){k(a,f,d)});f.sources||(a.levels?(f.sources=a.levels,delete a.levels):(d={},k(a,d,"file"),k(a,d,"type"),f.sources=d.file?[d]:[]));a.playlist=[new c(f)]}}function k(a,d,c){e.exists(a[c])&&
(d[c]=a[c],delete a[c])}var e=f.utils,c=f.playlist.item;(f.embed.config=function(b){var d={fallback:!0,height:270,primary:"html5",width:480,base:b.base?b.base:e.getScriptPath("jwplayer.js"),aspectratio:""};b=e.extend(d,f.defaults,b);var d={type:"html5",src:b.base+"jwplayer.html5.js"},c={type:"flash",src:b.base+"jwplayer.flash.swf"};b.modes="flash"==b.primary?[c,d]:[d,c];b.listbar&&(b.playlistsize=b.listbar.size,b.playlistposition=b.listbar.position);b.flashplayer&&(c.src=b.flashplayer);b.html5player&&
(d.src=b.html5player);a(b);c=b.aspectratio;if("string"!=typeof c||!e.exists(c))d=0;else{var h=c.indexOf(":");-1==h?d=0:(d=parseFloat(c.substr(0,h)),c=parseFloat(c.substr(h+1)),d=0>=d||0>=c?0:100*(c/d)+"%")}-1==b.width.toString().indexOf("%")?delete b.aspectratio:d?b.aspectratio=d:delete b.aspectratio;return b}).addConfig=function(b,c){a(c);return e.extend(b,c)}}(jwplayer),function(f){var a=f.utils,k=document;f.embed.download=function(e,c,b){function d(b,c){for(var d=k.querySelectorAll(b),e=0;e<d.length;e++)a.foreach(c,
function(a,b){d[e].style[a]=b})}function f(a,b,c){a=k.createElement(a);b&&(a.className="jwdownload"+b);c&&c.appendChild(a);return a}var h=a.extend({},c),r=h.width?h.width:480,p=h.height?h.height:320,q;c=c.logo?c.logo:{prefix:a.repo(),file:"logo.png",margin:10};var j,g,m,h=h.playlist,l,t=["mp4","aac","mp3"];if(h&&h.length){l=h[0];q=l.sources;for(h=0;h<q.length;h++){var u=q[h],w=u.type?u.type:a.extensionmap.extType(a.extension(u.file));u.file&&a.foreach(t,function(b){w==t[b]?(j=u.file,g=l.image):a.isYouTube(u.file)&&
(m=u.file)})}j?(q=j,b=g,e&&(h=f("a","display",e),f("div","icon",h),f("div","logo",h),q&&h.setAttribute("href",a.getAbsolutePath(q))),h="#"+e.id+" .jwdownload",e.style.width="",e.style.height="",d(h+"display",{width:a.styleDimension(Math.max(320,r)),height:a.styleDimension(Math.max(180,p)),background:"black center no-repeat "+(b?"url("+b+")":""),backgroundSize:"contain",position:"relative",border:"none",display:"block"}),d(h+"display div",{position:"absolute",width:"100%",height:"100%"}),d(h+"logo",
{top:c.margin+"px",right:c.margin+"px",background:"top right no-repeat url("+c.prefix+c.file+")"}),d(h+"icon",{background:"center no-repeat url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAgNJREFUeNrs28lqwkAYB/CZqNVDDj2r6FN41QeIy8Fe+gj6BL275Q08u9FbT8ZdwVfotSBYEPUkxFOoks4EKiJdaDuTjMn3wWBO0V/+sySR8SNSqVRKIR8qaXHkzlqS9jCfzzWcTCYp9hF5o+59sVjsiRzcegSckFzcjT+ruN80TeSlAjCAAXzdJSGPFXRpAAMYwACGZQkSdhG4WCzehMNhqV6vG6vVSrirKVEw66YoSqDb7cqlUilE8JjHd/y1MQefVzqdDmiaJpfLZWHgXMHn8F6vJ1cqlVAkEsGuAn83J4gAd2RZymQygX6/L1erVQt+9ZPWb+CDwcCC2zXGJaewl/DhcHhK3DVj+KfKZrMWvFarcYNLomAv4aPRSFZVlTlcSPA5fDweW/BoNIqFnKV53JvncjkLns/n/cLdS+92O7RYLLgsKfv9/t8XlDn4eDyiw+HA9Jyz2eyt0+kY2+3WFC5hluej0Ha7zQQq9PPwdDq1Et1sNsx/nFBgCqWJ8oAK1aUptNVqcYWewE4nahfU0YQnk4ntUEfGMIU2m01HoLaCKbTRaDgKtaVLk9tBYaBcE/6Artdr4RZ5TB6/dC+9iIe/WgAMYADDpAUJAxjAAAYwgGFZgoS/AtNNTF7Z2bL0BYPBV3Jw5xFwwWcYxgtBP5OkE8i9G7aWGOOCruvauwADALMLMEbKf4SdAAAAAElFTkSuQmCC)"})):
m?(c=m,e=f("embed","",e),e.src="http://www.youtube.com/v/"+/v=([^&]+)|\/([\w-]+)$|^([\w-]+)$/i.exec(c).slice(1).join(""),e.type="application/x-shockwave-flash",e.width=r,e.height=p):b()}}}(jwplayer),function(f){var a=f.utils,k=f.events,e={};(f.embed.flash=function(c,b,d,n,h){function r(a,b,c){var d=document.createElement("param");d.setAttribute("name",b);d.setAttribute("value",c);a.appendChild(d)}function p(a,b,c){return function(){try{c&&document.getElementById(h.id+"_wrapper").appendChild(b);var d=
document.getElementById(h.id).getPluginConfig("display");"function"==typeof a.resize&&a.resize(d.width,d.height);b.style.left=d.x;b.style.top=d.h}catch(e){}}}function q(b){if(!b)return{};var c={},d=[];a.foreach(b,function(b,e){var g=a.getPluginName(b);d.push(b);a.foreach(e,function(a,b){c[g+"."+a]=b})});c.plugins=d.join(",");return c}var j=new f.events.eventdispatcher,g=a.flashVersion();a.extend(this,j);this.embed=function(){d.id=h.id;if(10>g)return j.sendEvent(k.ERROR,{message:"Flash version must be 10.0 or greater"}),
!1;var f,l,t=h.config.listbar,u=a.extend({},d);if(c.id+"_wrapper"==c.parentNode.id)f=document.getElementById(c.id+"_wrapper");else{f=document.createElement("div");l=document.createElement("div");l.style.display="none";l.id=c.id+"_aspect";f.id=c.id+"_wrapper";f.style.position="relative";f.style.display="block";f.style.width=a.styleDimension(u.width);f.style.height=a.styleDimension(u.height);if(h.config.aspectratio){var w=parseFloat(h.config.aspectratio);l.style.display="block";l.style.marginTop=h.config.aspectratio;
f.style.height="auto";f.style.display="inline-block";t&&("bottom"==t.position?l.style.paddingBottom=t.size+"px":"right"==t.position&&(l.style.marginBottom=-1*t.size*(w/100)+"px"))}c.parentNode.replaceChild(f,c);f.appendChild(c);f.appendChild(l)}f=n.setupPlugins(h,u,p);0<f.length?a.extend(u,q(f.plugins)):delete u.plugins;"undefined"!=typeof u["dock.position"]&&"false"==u["dock.position"].toString().toLowerCase()&&(u.dock=u["dock.position"],delete u["dock.position"]);f=u.wmode?u.wmode:u.height&&40>=
u.height?"transparent":"opaque";l="height width modes events primary base fallback volume".split(" ");for(t=0;t<l.length;t++)delete u[l[t]];l=a.getCookies();a.foreach(l,function(a,b){"undefined"==typeof u[a]&&(u[a]=b)});l=window.location.href.split("/");l.splice(l.length-1,1);l=l.join("/");u.base=l+"/";e[c.id]=u;a.isIE()?(l='\x3cobject classid\x3d"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" " width\x3d"100%" height\x3d"100%"id\x3d"'+c.id+'" name\x3d"'+c.id+'" tabindex\x3d0""\x3e',l+='\x3cparam name\x3d"movie" value\x3d"'+
b.src+'"\x3e',l+='\x3cparam name\x3d"allowfullscreen" value\x3d"true"\x3e\x3cparam name\x3d"allowscriptaccess" value\x3d"always"\x3e',l+='\x3cparam name\x3d"seamlesstabbing" value\x3d"true"\x3e',l+='\x3cparam name\x3d"wmode" value\x3d"'+f+'"\x3e',l+='\x3cparam name\x3d"bgcolor" value\x3d"#000000"\x3e',l+="\x3c/object\x3e",c.outerHTML=l,f=document.getElementById(c.id)):(l=document.createElement("object"),l.setAttribute("type","application/x-shockwave-flash"),l.setAttribute("data",b.src),l.setAttribute("width",
"100%"),l.setAttribute("height","100%"),l.setAttribute("bgcolor","#000000"),l.setAttribute("id",c.id),l.setAttribute("name",c.id),l.setAttribute("tabindex",0),r(l,"allowfullscreen","true"),r(l,"allowscriptaccess","always"),r(l,"seamlesstabbing","true"),r(l,"wmode",f),c.parentNode.replaceChild(l,c),f=l);h.config.aspectratio&&(f.style.position="absolute");h.container=f;h.setPlayer(f,"flash")};this.supportsConfig=function(){if(g)if(d){if("string"==a.typeOf(d.playlist))return!0;try{var b=d.playlist[0].sources;
if("undefined"==typeof b)return!0;for(var c=0;c<b.length;c++){var e;if(e=b[c].file){var f=b[c].file,h=b[c].type;if(a.isYouTube(f)||a.isRtmp(f,h)||"hls"==h)e=!0;else{var j=a.extensionmap[h?h:a.extension(f)];e=!j?!1:!!j.flash}}if(e)return!0}}catch(k){}}else return!0;return!1}}).getVars=function(a){return e[a]}}(jwplayer),function(f){var a=f.utils,k=a.extensionmap,e=f.events;f.embed.html5=function(c,b,d,n,h){function r(a,b,d){return function(){try{var e=document.querySelector("#"+c.id+" .jwmain");d&&
e.appendChild(b);"function"==typeof a.resize&&(a.resize(e.clientWidth,e.clientHeight),setTimeout(function(){a.resize(e.clientWidth,e.clientHeight)},400));b.left=e.style.left;b.top=e.style.top}catch(f){}}}function p(a){q.sendEvent(a.type,{message:"HTML5 player not found"})}var q=this,j=new e.eventdispatcher;a.extend(q,j);q.embed=function(){if(f.html5){n.setupPlugins(h,d,r);c.innerHTML="";var g=f.utils.extend({},d);delete g.volume;g=new f.html5.player(g);h.container=document.getElementById(h.id);h.setPlayer(g,
"html5")}else g=new a.scriptloader(b.src),g.addEventListener(e.ERROR,p),g.addEventListener(e.COMPLETE,q.embed),g.load()};q.supportsConfig=function(){if(f.vid.canPlayType)try{if("string"==a.typeOf(d.playlist))return!0;for(var b=d.playlist[0].sources,c=0;c<b.length;c++){var e;var h=b[c].file,j=b[c].type;if(null!==navigator.userAgent.match(/BlackBerry/i)||a.isAndroid()&&("m3u"==a.extension(h)||"m3u8"==a.extension(h))||a.isRtmp(h,j))e=!1;else{var n=k[j?j:a.extension(h)],p;if(!n||n.flash&&!n.html5)p=!1;
else{var r=n.html5,q=f.vid;if(r)try{p=q.canPlayType(r)?!0:!1}catch(x){p=!1}else p=!0}e=p}if(e)return!0}}catch(v){}return!1}}}(jwplayer),function(f){var a=f.embed,k=f.utils,e=k.extend(function(c){function b(a){m.debug&&k.log(a)}function d(a){a=a.split("/");a=a[a.length-1];a=a.split("?");return a[0]}function e(){if(!C){var a=c.getPosition();b("stop: "+v+" : "+a);s.Media.stop(v,a)}}function h(a){C=!0;x=0;m.mediaName?a=m.mediaName:(a=c.getPlaylistItem(a.index),a=a.title?a.title:a.file?d(a.file):a.sources&&
a.sources.length?d(a.sources[0].file):"");v=a;A=m.playerName?m.playerName:c.id}function r(a,b){var c=g.events[a];g.events[a]="function"!=typeof g.events[a]?b:function(a){c&&c(a);b(a)}}var p=k.repo(),q=k.extend({},f.defaults),j=k.extend({},q,c.config),g=c.config,m=g.sitecatalyst,l=j.plugins,t=j.analytics,u=p+"jwpsrv.js",w=p+"sharing.js",z=p+"related.js",B=p+"gapro.js",q=f.key?f.key:q.key,y=(new f.utils.key(q)).edition(),x=0,v="",A="",C=!0,l=l?l:{};"ads"==y&&j.advertising&&(j.advertising.client.match(".js$|.swf$")?
l[j.advertising.client]=j.advertising:l[p+j.advertising.client+".js"]=j.advertising);delete g.advertising;g.key=q;j.analytics&&(j.analytics.client&&j.analytics.client.match(".js$|.swf$"))&&(u=j.analytics.client);delete g.analytics;if("free"==y||!t||!1!==t.enabled)l[u]=t?t:{};delete l.sharing;delete l.related;switch(y){case "premium":case "ads":j.sharing&&(j.sharing.client&&j.sharing.client.match(".js$|.swf$")&&(w=j.sharing.client),l[w]=j.sharing),j.related&&(j.related.client&&j.related.client.match(".js$|.swf$")&&
(z=j.related.client),l[z]=j.related),j.ga&&(j.ga.client&&j.ga.client.match(".js$|.swf$")&&(B=j.ga.client),l[B]=j.ga),m&&(g.events=k.extend({},g.events),r("onPlay",function(){if(!C){var a=c.getPosition();b("play: "+v+" : "+a);s.Media.play(v,a)}}),r("onPause",function(){e()}),r("onBuffer",function(){e()}),r("onPlaylistItem",h),r("onTime",function(){a:{if(C){var a=c.getDuration();if(-1==a)break a;C=!1;b("open: "+v+" : "+a+" : "+A);s.Media.open(v,a,A);b("play: "+v+" : 0");s.Media.play(v,0)}a=c.getPosition();
if(3<=Math.abs(a-x)){var d=x;b("seek: "+d+" to "+a);b("stop: "+v+" : "+d);s.Media.stop(v,d);b("play: "+v+" : "+a);s.Media.play(v,a)}x=a}}),r("onComplete",function(){var a=c.getPosition();b("stop: "+v+" : "+a);s.Media.stop(v,a);b("close: "+v);s.Media.close(v);C=!0;x=0}));case "pro":j.skin&&(g.skin=j.skin.replace(/^(beelden|bekle|five|glow|modieus|roundster|stormtrooper|vapor)$/i,k.repo()+"skins/$1.xml"))}g.plugins=l;return new a(c)},a);f.embed=e}(jwplayer),function(f){var a=[],k=f.utils,e=f.events,
c=e.state,b=document,d=f.api=function(a){function h(a,b){return function(c){return b(a,c)}}function r(a,b){l[a]||(l[a]=[],q(e.JWPLAYER_PLAYER_STATE,function(b){var c=b.newstate;b=b.oldstate;if(c==a){var d=l[c];if(d)for(var e=0;e<d.length;e++)"function"==typeof d[e]&&d[e].call(this,{oldstate:b,newstate:c})}}));l[a].push(b);return g}function p(a,b){try{a.jwAddEventListener(b,'function(dat) { jwplayer("'+g.id+'").dispatchEvent("'+b+'", dat); }')}catch(c){k.log("Could not add internal listener")}}function q(a,
b){m[a]||(m[a]=[],t&&u&&p(t,a));m[a].push(b);return g}function j(){if(u){for(var a=arguments[0],b=[],c=1;c<arguments.length;c++)b.push(arguments[c]);if("undefined"!=typeof t&&"function"==typeof t[a])switch(b.length){case 4:return t[a](b[0],b[1],b[2],b[3]);case 3:return t[a](b[0],b[1],b[2]);case 2:return t[a](b[0],b[1]);case 1:return t[a](b[0]);default:return t[a]()}return null}w.push(arguments)}var g=this,m={},l={},t=void 0,u=!1,w=[],z=void 0,B={},y={};g.container=a;g.id=a.id;g.getBuffer=function(){return j("jwGetBuffer")};
g.getContainer=function(){return g.container};g.addButton=function(a,b,c,d){try{y[d]=c,j("jwDockAddButton",a,b,"jwplayer('"+g.id+"').callback('"+d+"')",d)}catch(e){k.log("Could not add dock button"+e.message)}};g.removeButton=function(a){j("jwDockRemoveButton",a)};g.callback=function(a){if(y[a])y[a]()};g.forceState=function(a){j("jwForceState",a);return g};g.releaseState=function(){return j("jwReleaseState")};g.getDuration=function(){return j("jwGetDuration")};g.getFullscreen=function(){return j("jwGetFullscreen")};
g.getStretching=function(){return j("jwGetStretching")};g.getHeight=function(){return j("jwGetHeight")};g.getLockState=function(){return j("jwGetLockState")};g.getMeta=function(){return g.getItemMeta()};g.getMute=function(){return j("jwGetMute")};g.getPlaylist=function(){var a=j("jwGetPlaylist");"flash"==g.renderingMode&&k.deepReplaceKeyName(a,["__dot__","__spc__","__dsh__","__default__"],["."," ","-","default"]);return a};g.getPlaylistItem=function(a){k.exists(a)||(a=g.getPlaylistIndex());return g.getPlaylist()[a]};
g.getPlaylistIndex=function(){return j("jwGetPlaylistIndex")};g.getPosition=function(){return j("jwGetPosition")};g.getRenderingMode=function(){return g.renderingMode};g.getState=function(){return j("jwGetState")};g.getVolume=function(){return j("jwGetVolume")};g.getWidth=function(){return j("jwGetWidth")};g.setFullscreen=function(a){k.exists(a)?j("jwSetFullscreen",a):j("jwSetFullscreen",!j("jwGetFullscreen"));return g};g.setStretching=function(a){j("jwSetStretching",a);return g};g.setMute=function(a){k.exists(a)?
j("jwSetMute",a):j("jwSetMute",!j("jwGetMute"));return g};g.lock=function(){return g};g.unlock=function(){return g};g.load=function(a){j("jwLoad",a);return g};g.playlistItem=function(a){j("jwPlaylistItem",parseInt(a));return g};g.playlistPrev=function(){j("jwPlaylistPrev");return g};g.playlistNext=function(){j("jwPlaylistNext");return g};g.resize=function(a,c){if("flash"!=g.renderingMode){var d=document.getElementById(g.id);d.className=d.className.replace(/\s+aspectMode/,"");d.style.display="block";
j("jwResize",a,c)}else{var d=b.getElementById(g.id+"_wrapper"),e=b.getElementById(g.id+"_aspect");e&&(e.style.display="none");d&&(d.style.display="block",d.style.width=k.styleDimension(a),d.style.height=k.styleDimension(c))}return g};g.play=function(a){"undefined"==typeof a?(a=g.getState(),a==c.PLAYING||a==c.BUFFERING?j("jwPause"):j("jwPlay")):j("jwPlay",a);return g};g.pause=function(a){"undefined"==typeof a?(a=g.getState(),a==c.PLAYING||a==c.BUFFERING?j("jwPause"):j("jwPlay")):j("jwPause",a);return g};
g.stop=function(){j("jwStop");return g};g.seek=function(a){j("jwSeek",a);return g};g.setVolume=function(a){j("jwSetVolume",a);return g};g.loadInstream=function(a,b){return z=new d.instream(this,t,a,b)};g.getQualityLevels=function(){return j("jwGetQualityLevels")};g.getCurrentQuality=function(){return j("jwGetCurrentQuality")};g.setCurrentQuality=function(a){j("jwSetCurrentQuality",a)};g.getCaptionsList=function(){return j("jwGetCaptionsList")};g.getCurrentCaptions=function(){return j("jwGetCurrentCaptions")};
g.setCurrentCaptions=function(a){j("jwSetCurrentCaptions",a)};g.getControls=function(){return j("jwGetControls")};g.getSafeRegion=function(){return j("jwGetSafeRegion")};g.setControls=function(a){j("jwSetControls",a)};g.destroyPlayer=function(){j("jwPlayerDestroy")};g.playAd=function(a){j("jwPlayAd",a)};var x={onBufferChange:e.JWPLAYER_MEDIA_BUFFER,onBufferFull:e.JWPLAYER_MEDIA_BUFFER_FULL,onError:e.JWPLAYER_ERROR,onSetupError:e.JWPLAYER_SETUP_ERROR,onFullscreen:e.JWPLAYER_FULLSCREEN,onMeta:e.JWPLAYER_MEDIA_META,
onMute:e.JWPLAYER_MEDIA_MUTE,onPlaylist:e.JWPLAYER_PLAYLIST_LOADED,onPlaylistItem:e.JWPLAYER_PLAYLIST_ITEM,onPlaylistComplete:e.JWPLAYER_PLAYLIST_COMPLETE,onReady:e.API_READY,onResize:e.JWPLAYER_RESIZE,onComplete:e.JWPLAYER_MEDIA_COMPLETE,onSeek:e.JWPLAYER_MEDIA_SEEK,onTime:e.JWPLAYER_MEDIA_TIME,onVolume:e.JWPLAYER_MEDIA_VOLUME,onBeforePlay:e.JWPLAYER_MEDIA_BEFOREPLAY,onBeforeComplete:e.JWPLAYER_MEDIA_BEFORECOMPLETE,onDisplayClick:e.JWPLAYER_DISPLAY_CLICK,onControls:e.JWPLAYER_CONTROLS,onQualityLevels:e.JWPLAYER_MEDIA_LEVELS,
onQualityChange:e.JWPLAYER_MEDIA_LEVEL_CHANGED,onCaptionsList:e.JWPLAYER_CAPTIONS_LIST,onCaptionsChange:e.JWPLAYER_CAPTIONS_CHANGED,onAdError:e.JWPLAYER_AD_ERROR,onAdClick:e.JWPLAYER_AD_CLICK,onAdImpression:e.JWPLAYER_AD_IMPRESSION,onAdTime:e.JWPLAYER_AD_TIME,onAdComplete:e.JWPLAYER_AD_COMPLETE,onAdCompanions:e.JWPLAYER_AD_COMPANIONS};k.foreach(x,function(a){g[a]=h(x[a],q)});var v={onBuffer:c.BUFFERING,onPause:c.PAUSED,onPlay:c.PLAYING,onIdle:c.IDLE};k.foreach(v,function(a){g[a]=h(v[a],r)});g.remove=
function(){if(!u)throw"Cannot call remove() before player is ready";w=[];d.destroyPlayer(this.id)};g.setup=function(a){if(f.embed){var c=b.getElementById(g.id);c&&(a.fallbackDiv=c);c=g;w=[];d.destroyPlayer(c.id);c=f(g.id);c.config=a;return new f.embed(c)}return g};g.registerPlugin=function(a,b,c,d){f.plugins.registerPlugin(a,b,c,d)};g.setPlayer=function(a,b){t=a;g.renderingMode=b};g.detachMedia=function(){if("html5"==g.renderingMode)return j("jwDetachMedia")};g.attachMedia=function(a){if("html5"==
g.renderingMode)return j("jwAttachMedia",a)};g.dispatchEvent=function(a,b){if(m[a])for(var c=k.translateEventResponse(a,b),d=0;d<m[a].length;d++)if("function"==typeof m[a][d])try{a==e.JWPLAYER_PLAYLIST_LOADED&&k.deepReplaceKeyName(c.playlist,["__dot__","__spc__","__dsh__","__default__"],["."," ","-","default"]),m[a][d].call(this,c)}catch(f){k.log("There was an error calling back an event handler")}};g.dispatchInstreamEvent=function(a){z&&z.dispatchEvent(a,arguments)};g.callInternal=j;g.playerReady=
function(a){u=!0;t||g.setPlayer(b.getElementById(a.id));g.container=b.getElementById(g.id);k.foreach(m,function(a){p(t,a)});q(e.JWPLAYER_PLAYLIST_ITEM,function(){B={}});q(e.JWPLAYER_MEDIA_META,function(a){k.extend(B,a.metadata)});for(g.dispatchEvent(e.API_READY);0<w.length;)j.apply(this,w.shift())};g.getItemMeta=function(){return B};g.isBeforePlay=function(){return t.jwIsBeforePlay()};g.isBeforeComplete=function(){return t.jwIsBeforeComplete()};return g};d.selectPlayer=function(c){var e;k.exists(c)||
(c=0);c.nodeType?e=c:"string"==typeof c&&(e=b.getElementById(c));return e?(c=d.playerById(e.id))?c:d.addPlayer(new d(e)):"number"==typeof c?a[c]:null};d.playerById=function(b){for(var c=0;c<a.length;c++)if(a[c].id==b)return a[c];return null};d.addPlayer=function(b){for(var c=0;c<a.length;c++)if(a[c]==b)return b;a.push(b);return b};d.destroyPlayer=function(c){for(var d=-1,e,f=0;f<a.length;f++)a[f].id==c&&(d=f,e=a[f]);0<=d&&(c=e.id,f=b.getElementById(c+("flash"==e.renderingMode?"_wrapper":"")),k.clearCss&&
k.clearCss("#"+c),f&&("html5"==e.renderingMode&&e.destroyPlayer(),e=b.createElement("div"),e.id=c,f.parentNode.replaceChild(e,f)),a.splice(d,1));return null};f.playerReady=function(a){var b=f.api.playerById(a.id);b?b.playerReady(a):f.api.selectPlayer(a.id).playerReady(a)}}(jwplayer),function(f){var a=f.events,k=f.utils,e=a.state;f.api.instream=function(c,b,d,f){function h(a,b){j[a]||(j[a]=[],q.jwInstreamAddEventListener(a,'function(dat) { jwplayer("'+p.id+'").dispatchInstreamEvent("'+a+'", dat); }'));
j[a].push(b);return this}function r(b,c){g[b]||(g[b]=[],h(a.JWPLAYER_PLAYER_STATE,function(a){var c=a.newstate,d=a.oldstate;if(c==b){var e=g[c];if(e)for(var f=0;f<e.length;f++)"function"==typeof e[f]&&e[f].call(this,{oldstate:d,newstate:c,type:a.type})}}));g[b].push(c);return this}var p=c,q=b,j={},g={};this.dispatchEvent=function(a,b){if(j[a])for(var c=k.translateEventResponse(a,b[1]),d=0;d<j[a].length;d++)"function"==typeof j[a][d]&&j[a][d].call(this,c)};this.onError=function(b){return h(a.JWPLAYER_ERROR,
b)};this.onFullscreen=function(b){return h(a.JWPLAYER_FULLSCREEN,b)};this.onMeta=function(b){return h(a.JWPLAYER_MEDIA_META,b)};this.onMute=function(b){return h(a.JWPLAYER_MEDIA_MUTE,b)};this.onComplete=function(b){return h(a.JWPLAYER_MEDIA_COMPLETE,b)};this.onTime=function(b){return h(a.JWPLAYER_MEDIA_TIME,b)};this.onBuffer=function(a){return r(e.BUFFERING,a)};this.onPause=function(a){return r(e.PAUSED,a)};this.onPlay=function(a){return r(e.PLAYING,a)};this.onIdle=function(a){return r(e.IDLE,a)};
this.onClick=function(b){return h(a.JWPLAYER_INSTREAM_CLICK,b)};this.onInstreamDestroyed=function(b){return h(a.JWPLAYER_INSTREAM_DESTROYED,b)};this.play=function(a){q.jwInstreamPlay(a)};this.pause=function(a){q.jwInstreamPause(a)};this.destroy=function(){q.jwInstreamDestroy()};p.callInternal("jwLoadInstream",d,f?f:{})}}(jwplayer),function(f){var a=f.api,k=a.selectPlayer;a.selectPlayer=function(a){return(a=k(a))?a:{registerPlugin:function(a,b,d){f.plugins.registerPlugin(a,b,d)}}}}(jwplayer));;
/**
 * bootstrap-paginator.js v0.5
 * --
 * Copyright 2013 Yun Lai <lyonlai1984@gmail.com>
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

(function ($) {

    "use strict"; // jshint ;_;


    /* Paginator PUBLIC CLASS DEFINITION
     * ================================= */

    /**
     * Boostrap Paginator Constructor
     *
     * @param element element of the paginator
     * @param options the options to config the paginator
     *
     * */
    var BootstrapPaginator = function (element, options) {
        this.init(element, options);
    },
        old = null;

    BootstrapPaginator.prototype = {

        /**
         * Initialization function of the paginator, accepting an element and the options as parameters
         *
         * @param element element of the paginator
         * @param options the options to config the paginator
         *
         * */
        init: function (element, options) {

            this.$element = $(element);

            this.currentPage = 1;

            this.lastPage = 1;

            this.setOptions(options);

            this.initialized = true;
        },

        /**
         * Update the properties of the paginator element
         *
         * @param options options to config the paginator
         * */
        setOptions: function (options) {

            this.options = $.extend({}, (this.options || $.fn.bootstrapPaginator.defaults), options);

            this.totalPages = parseInt(this.options.totalPages, 10);  //setup the total pages property.
            this.numberOfPages = parseInt(this.options.numberOfPages, 10); //setup the numberOfPages to be shown

            //move the set current page after the setting of total pages. otherwise it will cause out of page exception.
            if (options && typeof (options.currentPage)  !== 'undefined') {

                this.setCurrentPage(options.currentPage);
            }

            this.listen();

            //render the paginator
            this.render();

            if (!this.initialized && this.lastPage !== this.currentPage) {
                this.$element.trigger("page-changed", [this.lastPage, this.currentPage]);
            }

        },

        /**
         * Sets up the events listeners. Currently the pageclicked and pagechanged events are linked if available.
         *
         * */
        listen: function () {

            this.$element.off("page-clicked");

            this.$element.off("page-changed");// unload the events for the element

            if (typeof (this.options.onPageClicked) === "function") {
                this.$element.bind("page-clicked", this.options.onPageClicked);
            }

            if (typeof (this.options.onPageChanged) === "function") {
                this.$element.on("page-changed", this.options.onPageChanged);
            }

        },


        /**
         *
         *  Destroys the paginator element, it unload the event first, then empty the content inside.
         *
         * */
        destroy: function () {

            this.$element.off("page-clicked");

            this.$element.off("page-changed");

            $.removeData(this.$element, 'bootstrapPaginator');

            this.$element.empty();

        },

        /**
         * Shows the page
         *
         * */
        show: function (page) {

            this.setCurrentPage(page);

            this.render();

            if (this.lastPage !== this.currentPage) {
                this.$element.trigger("page-changed", [this.lastPage, this.currentPage]);
            }
        },

        /**
         * Shows the next page
         *
         * */
        showNext: function () {
            var pages = this.getPages();

            if (pages.next) {
                this.show(pages.next);
            }

        },

        /**
         * Shows the previous page
         *
         * */
        showPrevious: function () {
            var pages = this.getPages();

            if (pages.prev) {
                this.show(pages.prev);
            }

        },

        /**
         * Shows the first page
         *
         * */
        showFirst: function () {
            var pages = this.getPages();

            if (pages.first) {
                this.show(pages.first);
            }

        },

        /**
         * Shows the last page
         *
         * */
        showLast: function () {
            var pages = this.getPages();

            if (pages.last) {
                this.show(pages.last);
            }

        },

        /**
         * Internal on page item click handler, when the page item is clicked, change the current page to the corresponding page and
         * trigger the pageclick event for the listeners.
         *
         *
         * */
        onPageItemClicked: function (event) {

            var type = event.data.type,
                page = event.data.page;

            this.$element.trigger("page-clicked", [event, type, page]);

            //show the corresponding page and retrieve the newly built item related to the page clicked before for the event return
            switch (type) {

            case "first":
                this.showFirst();
                break;
            case "prev":
                this.showPrevious();
                break;
            case "next":
                this.showNext();
                break;
            case "last":
                this.showLast();
                break;
            case "page":
                this.show(page);
                break;
            }

        },

        /**
         * Renders the paginator according to the internal properties and the settings.
         *
         *
         * */
        render: function () {

            //fetch the container class and add them to the container
            var containerClass = this.getValueFromOption(this.options.containerClass, this.$element),
                size = this.options.size || "normal",
                alignment = this.options.alignment || "left",
                pages = this.getPages(),
                listContainer = $("<ul></ul>"),
                listContainerClass =  this.getValueFromOption(this.options.listContainerClass, listContainer),
                first = null,
                prev = null,
                next = null,
                last = null,
                p = null,
                i = 0;


            this.$element.prop("class", "");

            this.$element.addClass("pagination");

            switch (size.toLowerCase()) {
            case "large":
                this.$element.addClass("pagination-large");
                break;
            case "small":
                this.$element.addClass("pagination-small");
                break;
            case "mini":
                this.$element.addClass("pagination-mini");
                break;
            default:
                break;
            }

            switch (alignment.toLowerCase()) {

            case "center":
                this.$element.addClass("pagination-centered");
                break;
            case "right":
                this.$element.addClass("pagination-right");
                break;
            default:
                break;

            }

            this.$element.addClass(containerClass);

            //empty the outter most container then add the listContainer inside.
            this.$element.empty();

            this.$element.append(listContainer);

            listContainer.addClass(listContainerClass);

            //update the page element reference
            this.pageRef = [];

            if (pages.first) {//if the there is first page element
                first = this.buildPageItem("first", pages.first);

                if (first) {
                    listContainer.append(first);
                }

            }

            if (pages.prev) {//if the there is previous page element

                prev = this.buildPageItem("prev", pages.prev);

                if (prev) {
                    listContainer.append(prev);
                }

            }


            for (i = 0; i < pages.length; i = i + 1) {//fill the numeric pages.

                p = this.buildPageItem("page", pages[i]);

                if (p) {
                    listContainer.append(p);
                }
            }

            if (pages.next) {//if there is next page

                next = this.buildPageItem("next", pages.next);

                if (next) {
                    listContainer.append(next);
                }
            }

            if (pages.last) {//if there is last page

                last = this.buildPageItem("last", pages.last);

                if (last) {
                    listContainer.append(last);
                }
            }
        },

        /**
         *
         * Creates a page item base on the type and page number given.
         *
         * @param page page number
         * @param type type of the page, whether it is the first, prev, page, next, last
         *
         * @return Object the constructed page element
         * */
        buildPageItem: function (type, page) {

            var itemContainer = $("<li></li>"),//creates the item container
                itemContent = $("<a></a>"),//creates the item content
                text = "",
                title = "",
                itemContainerClass = this.options.itemContainerClass(type, page, this.currentPage),
                itemContentClass = this.getValueFromOption(this.options.itemContentClass, type, page, this.currentPage),
                tooltipOpts = null;


            switch (type) {

            case "first":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "last":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "prev":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "next":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            case "page":
                if (!this.getValueFromOption(this.options.shouldShowPage, type, page, this.currentPage)) { return; }
                text = this.options.itemTexts(type, page, this.currentPage);
                title = this.options.tooltipTitles(type, page, this.currentPage);
                break;
            }

            itemContainer.addClass(itemContainerClass).append(itemContent);

            itemContent.addClass(itemContentClass).html(text).on("click", null, {type: type, page: page}, $.proxy(this.onPageItemClicked, this));

            if (this.options.pageUrl) {
                itemContent.attr("href", this.getValueFromOption(this.options.pageUrl, type, page, this.currentPage));
            }

            if (this.options.useBootstrapTooltip) {
                tooltipOpts = $.extend({}, this.options.bootstrapTooltipOptions, {title: title});

                itemContent.tooltip(tooltipOpts);
            } else {
                itemContent.attr("title", title);
            }

            return itemContainer;

        },

        setCurrentPage: function (page) {
            if (page > this.totalPages || page < 1) {// if the current page is out of range, throw exception.

                throw "Page out of range";

            }

            this.lastPage = this.currentPage;

            this.currentPage = parseInt(page, 10);

        },

        /**
         * Gets an array that represents the current status of the page object. Numeric pages can be access via array mode. length attributes describes how many numeric pages are there. First, previous, next and last page can be accessed via attributes first, prev, next and last. Current attribute marks the current page within the pages.
         *
         * @return object output objects that has first, prev, next, last and also the number of pages in between.
         * */
        getPages: function () {

            var totalPages = this.totalPages,// get or calculate the total pages via the total records
                pageStart = (this.currentPage % this.numberOfPages === 0) ? (parseInt(this.currentPage / this.numberOfPages, 10) - 1) * this.numberOfPages + 1 : parseInt(this.currentPage / this.numberOfPages, 10) * this.numberOfPages + 1,//calculates the start page.
                output = [],
                i = 0,
                counter = 0;

            pageStart = pageStart < 1 ? 1 : pageStart;//check the range of the page start to see if its less than 1.

            for (i = pageStart, counter = 0; counter < this.numberOfPages && i <= totalPages; i = i + 1, counter = counter + 1) {//fill the pages
                output.push(i);
            }

            if (this.currentPage > 1) {//add the first when the current page leaves the 1st page.
                output.first = 1;
            } else {
                output.first = null;
            }

            if (this.currentPage > 1) {// add the previous when the current page leaves the 1st page
                output.prev = this.currentPage - 1;
            } else {
                output.prev = null;
            }

            if (this.currentPage < totalPages) {// add the next page when the current page doesn't reach the last page
                output.next = this.currentPage + 1;
            } else {
                output.next = null;
            }

            if (this.currentPage < totalPages) {// add the last page when the current page doesn't reach the last page
                output.last = totalPages;
            } else {
                output.last = null;
            }

            output.current = this.currentPage;//mark the current page.

            output.total = totalPages;

            output.numberOfPages = this.options.numberOfPages;

            return output;

        },

        /**
         * Gets the value from the options, this is made to handle the situation where value is the return value of a function.
         *
         * @return mixed value that depends on the type of parameters, if the given parameter is a function, then the evaluated result is returned. Otherwise the parameter itself will get returned.
         * */
        getValueFromOption: function (value) {

            var output = null,
                args = Array.prototype.slice.call(arguments, 1);

            if (typeof value === 'function') {
                output = value.apply(this, args);
            } else {
                output = value;
            }

            return output;

        }

    };


    /* TYPEAHEAD PLUGIN DEFINITION
     * =========================== */

    old = $.fn.bootstrapPaginator;

    $.fn.bootstrapPaginator = function (option) {

        var args = arguments,
            result = null;

        $(this).each(function (index, item) {
            var $this = $(item),
                data = $this.data('bootstrapPaginator'),
                options = (typeof option !== 'object') ? null : option;

            if (!data) {
                $this.data('bootstrapPaginator', (data = new BootstrapPaginator(this, options)));
                return;
            }

            if (typeof option === 'string') {

                if (data[option]) {
                    result = data[option].apply(data, Array.prototype.slice.call(args, 1));
                } else {
                    throw "Method " + option + " does not exist";
                }

            } else {
                result = data.setOptions(option);
            }
        });

        return result;

    };

    $.fn.bootstrapPaginator.defaults = {
        containerClass: "",
        size: "normal",
        alignment: "left",
        listContainerClass: "",
        itemContainerClass: function (type, page, current) {
            return (page === current) ? "active" : "";
        },
        itemContentClass: function (type, page, current) {
            return "";
        },
        currentPage: 1,
        numberOfPages: 5,
        totalPages: 1,
        pageUrl: function (type, page, current) {
            return null;
        },
        onPageClicked: null,
        onPageChanged: null,
        useBootstrapTooltip: false,
        shouldShowPage: true,
        itemTexts: function (type, page, current) {
            switch (type) {
            case "first":
                return "&lt;&lt;";
            case "prev":
                return "&lt;";
            case "next":
                return "&gt;";
            case "last":
                return "&gt;&gt;";
            case "page":
                return page;
            }
        },
        tooltipTitles: function (type, page, current) {

            switch (type) {
            case "first":
                return "Go to first page";
            case "prev":
                return "Go to previous page";
            case "next":
                return "Go to next page";
            case "last":
                return "Go to last page";
            case "page":
                return (page === current) ? "Current page is " + page : "Go to page " + page;
            }
        },
        bootstrapTooltipOptions: {
            animation: true,
            html: true,
            placement: 'top',
            selector: false,
            title: "",
            container: false
        }
    };

    $.fn.bootstrapPaginator.Constructor = BootstrapPaginator;



}(window.jQuery));
;
(function($) {

Drupal.behaviors.customVideo = {};
Drupal.behaviors.customVideo.attach = function(context) {
	var lang = Drupal.settings.swflang;
	var is_mobile = Drupal.settings.is_mobile;
	//alert(is_mobile);
    var language = '';
    if (lang == 'fr') {
        language = lang;
    } 
	$('.colorbox-video').click(function (e){
    	e.preventDefault();
    	var url = $(this).attr('href');
    	var ext = url.split('.').pop().toLowerCase();
    	var player_height = '98%';
    	var player_width = '100%';
    	
    	var colobox_max_width = '40%';
    	var colobox_max_height = '60%';
    	var colobox_innerWidth = '35%';
    	if($.inArray(ext, ['mp3']) != -1) {
        	player_height = '25';
        	player_width = '100%';
        	colobox_max_height = '95';
        } 	
    	
    	if(is_mobile){
    		colobox_max_width = '80%';
    		colobox_innerWidth = '78%';
    		if($.inArray(ext, ['mp3']) != -1) {
            	player_height = '10%';
            	player_width = '100%';
            	colobox_max_height = '60%';
            }
    	}
    		$.colorbox({
    			maxWidth: colobox_max_width,
  		       	maxHeight: colobox_max_height,
    			initialWidth: '100%',
    			//initialHeight: colorbox_initial_height,
    			speed: 700,            
    			overlayClose: false,
    			inline: true,
    			href:'#video_load',
    			innerWidth: colobox_innerWidth,
 		        innerHeight:'45%',
    			onOpen:function(){
    				$( "body" ).append("<div id='video_load' style='display:none'>Audio/Video Loading...</div>");
    			},
    			onComplete:function(){
    				// var vidimg = $(divId).attr('vid-img');
    				jwplayer('video_load').setup({
    					file: url,
    					flashplayer:"/sites/all/modules/cgicustom/jwplayer/jwplayer.flash.swf",
    					html5player:"/sites/all/modules/cgicustom/jwplayer/jwplayer.html5.js",
    					height: player_height,
    					//       image: vidimg,
    					width: player_width
    				});    
    			},
    			onLoad:function(){     		    	
    				$('#video_load').css('display','block');
    			},
    			onCleanup:function(){  
    				//jwplayer().remove();
    				$('#video_load').remove();
    				$('#video_load_wrapper').remove();
    			}
    		});
    });
	
	/* functionality for views expose filter begins here */
/*	$.fn.pageClickedEvent = function (){
		    $('.pagerLinks').paginate({
				count 		: 100,
				start 		: 1,
				display     : 15,
				border					: true,
				border_color			: '#fff',
				text_color  			: '#fff',
				background_color    	: '#89213C',	
				border_hover_color		: '#ccc',
				text_hover_color  		: '#000',
				background_hover_color	: '#fff', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page){
											alert(page);
										  }
			});
	}
	
	 $.fn.updateTermDisplay = function ($term) {
		 $('#vocabSelect').change(function (e) {
			  e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'term/select';
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $(this).attr('view'), vid: $('#vocabSelect').val(), term: $term },
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#termDisplayArea').html(data.termList);
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
	      }); 
	 }
	 
	 $.fn.updateViewContent = function () {
		 $('#viewFilterSubmit').click(function (e) {
			  e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'filter/'+$('#vocabSelect').attr('view')+'/'+$('#vocabSelect').attr('sub_path');
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $('#vocabSelect').attr('view'), 
	            	  vid: $('#vocabSelect').val(), 
	            	  tid: $('#termSelect').val(), 
	            	  view_name: $('#vocabSelect').attr('view_name'), 
	            	  view_page:$('#vocabSelect').attr('view_page'),
	            	  sub_path:$('#vocabSelect').attr('sub_path')},
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#content-area').html(data.output);
	              	
	              	$('#vocabSelect').val(data.selvoc);
	              	$(this).updateTermDisplay(data.selter);
	              	$('#vocabSelect').change();
	              	//alert(data.selter);
	              	
	              	//$('#termSelect').val(data.selter);
	              	
	              	 $("#filter_table").tablePager({
	                      offset: 0,
	                      limit: 40,
	                      language: lang
	                  });
	             	
	              	 $("#content_globalnews").tablePager({
	         	        offset: 0,
	         	        limit: 8,
	         	        language: lang
	         	    });
	              	 
	              	$(this).updateViewContent();
	              	$(this).resetViewContent();
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
	      });		 
	 }	
	 
	 $.fn.resetViewContent = function () {
		 $('#viewFilterReset').click(function(e){
			 e.preventDefault();
			  var url = Drupal.settings.basePath + Drupal.settings.pathPrefix + 'filter/'+$('#vocabSelect').attr('view')+'/'+$('#vocabSelect').attr('sub_path');
	          $.ajax({
	              type: 'POST',
	              data: { view_type:  $('#vocabSelect').attr('view'), 
	            	  vid: '', 
	            	  tid: 'all', 
	            	  term_retain: $('#termSelect').val(),
	            	  view_name: $('#vocabSelect').attr('view_name'), 
	            	  view_page:$('#vocabSelect').attr('view_page'),
	            	  sub_path:$('#vocabSelect').attr('sub_path')},
	              url: url, // Which url should be handle the ajax request. This is the url defined in the <a> html tag
	              success: function (data) {
	              	$('#content-area').html(data.output);
	              	
	              	$('#vocabSelect').val(data.selvoc);
	              	$(this).updateTermDisplay(data.selter);
	              	$('#vocabSelect').change();
	              	//alert(data.selter);
	              	
	              	//$('#termSelect').val(data.selter);
	              	
	              	 $("#filter_table").tablePager({
	                      offset: 0,
	                      limit: 40,
	                      language: lang
	                  });
	             	
	              	 $("#content_globalnews").tablePager({
	         	        offset: 0,
	         	        limit: 8,
	         	        language: lang
	         	    });
	              	 
	              	$(this).updateViewContent();
	              	$(this).resetViewContent();
	              }, // The js function that will be called upon success request
	              dataType: 'json' //define the type of data that is going to get back from the server
	              // data: 'js=1' //Pass a key/value pair
	          });
			 
		 });
	 }
	 $(this).updateTermDisplay();
  	 $(this).updateViewContent();
  	 $(this).resetViewContent(); */
};

})(jQuery);;
(function(c){c.extend(c.fn,{validate:function(a){if(this.length){var b=c.data(this[0],"validator");if(b)return b;this.attr("novalidate","novalidate");b=new c.validator(a,this[0]);c.data(this[0],"validator",b);b.settings.onsubmit&&(this.find("input, button").filter(".cancel").click(function(){b.cancelSubmit=!0}),b.settings.submitHandler&&this.find("input, button").filter(":submit").click(function(){b.submitButton=this}),this.submit(function(a){function e(){if(b.settings.submitHandler){if(b.submitButton)var a=
c("<input type='hidden'/>").attr("name",b.submitButton.name).val(b.submitButton.value).appendTo(b.currentForm);b.settings.submitHandler.call(b,b.currentForm);b.submitButton&&a.remove();return!1}return!0}b.settings.debug&&a.preventDefault();return b.cancelSubmit?(b.cancelSubmit=!1,e()):b.form()?b.pendingRequest?(b.formSubmitted=!0,!1):e():(b.focusInvalid(),!1)}));return b}else a&&a.debug&&window.console&&console.warn("nothing selected, can't validate, returning nothing")},valid:function(){if(c(this[0]).is("form"))return this.validate().form();
else{var a=!0,b=c(this[0].form).validate();this.each(function(){a&=b.element(this)});return a}},removeAttrs:function(a){var b={},d=this;c.each(a.split(/\s/),function(a,c){b[c]=d.attr(c);d.removeAttr(c)});return b},rules:function(a,b){var d=this[0];if(a){var e=c.data(d.form,"validator").settings,f=e.rules,g=c.validator.staticRules(d);switch(a){case "add":c.extend(g,c.validator.normalizeRule(b));f[d.name]=g;b.messages&&(e.messages[d.name]=c.extend(e.messages[d.name],b.messages));break;case "remove":if(!b)return delete f[d.name],
g;var h={};c.each(b.split(/\s/),function(a,b){h[b]=g[b];delete g[b]});return h}}d=c.validator.normalizeRules(c.extend({},c.validator.metadataRules(d),c.validator.classRules(d),c.validator.attributeRules(d),c.validator.staticRules(d)),d);if(d.required)e=d.required,delete d.required,d=c.extend({required:e},d);return d}});c.extend(c.expr[":"],{blank:function(a){return!c.trim(""+a.value)},filled:function(a){return!!c.trim(""+a.value)},unchecked:function(a){return!a.checked}});c.validator=function(a,b){this.settings=
c.extend(!0,{},c.validator.defaults,a);this.currentForm=b;this.init()};c.validator.format=function(a,b){if(arguments.length==1)return function(){var b=c.makeArray(arguments);b.unshift(a);return c.validator.format.apply(this,b)};arguments.length>2&&b.constructor!=Array&&(b=c.makeArray(arguments).slice(1));b.constructor!=Array&&(b=[b]);c.each(b,function(b,c){a=a.replace(RegExp("\\{"+b+"\\}","g"),c)});return a};c.extend(c.validator,{defaults:{messages:{},groups:{},rules:{},errorClass:"error",validClass:"valid",
errorElement:"label",focusInvalid:!0,errorContainer:c([]),errorLabelContainer:c([]),onsubmit:!0,ignore:[],ignoreTitle:!1,onfocusin:function(a){this.lastActive=a;this.settings.focusCleanup&&!this.blockFocusCleanup&&(this.settings.unhighlight&&this.settings.unhighlight.call(this,a,this.settings.errorClass,this.settings.validClass),this.addWrapper(this.errorsFor(a)).hide())},onfocusout:function(a){!this.checkable(a)&&(a.name in this.submitted||!this.optional(a))&&this.element(a)},onkeyup:function(a){(a.name in
this.submitted||a==this.lastElement)&&this.element(a)},onclick:function(a){a.name in this.submitted?this.element(a):a.parentNode.name in this.submitted&&this.element(a.parentNode)},highlight:function(a,b,d){a.type==="radio"?this.findByName(a.name).addClass(b).removeClass(d):c(a).addClass(b).removeClass(d)},unhighlight:function(a,b,d){a.type==="radio"?this.findByName(a.name).removeClass(b).addClass(d):c(a).removeClass(b).addClass(d)}},setDefaults:function(a){c.extend(c.validator.defaults,a)},messages:{required:"This field is required.",
remote:"Please fix this field.",email:"Please enter a valid email address.",url:"Please enter a valid URL.",date:"Please enter a valid date.",dateISO:"Please enter a valid date (ISO).",number:"Please enter a valid number.",digits:"Please enter only digits.",creditcard:"Please enter a valid credit card number.",equalTo:"Please enter the same value again.",accept:"Please enter a value with a valid extension.",maxlength:c.validator.format("Please enter no more than {0} characters."),minlength:c.validator.format("Please enter at least {0} characters."),
rangelength:c.validator.format("Please enter a value between {0} and {1} characters long."),range:c.validator.format("Please enter a value between {0} and {1}."),max:c.validator.format("Please enter a value less than or equal to {0}."),min:c.validator.format("Please enter a value greater than or equal to {0}.")},autoCreateRanges:!1,prototype:{init:function(){function a(a){var b=c.data(this[0].form,"validator"),a="on"+a.type.replace(/^validate/,"");b.settings[a]&&b.settings[a].call(b,this[0])}this.labelContainer=
c(this.settings.errorLabelContainer);this.errorContext=this.labelContainer.length&&this.labelContainer||c(this.currentForm);this.containers=c(this.settings.errorContainer).add(this.settings.errorLabelContainer);this.submitted={};this.valueCache={};this.pendingRequest=0;this.pending={};this.invalid={};this.reset();var b=this.groups={};c.each(this.settings.groups,function(a,d){c.each(d.split(/\s/),function(c,d){b[d]=a})});var d=this.settings.rules;c.each(d,function(a,b){d[a]=c.validator.normalizeRule(b)});
c(this.currentForm).validateDelegate("[type='text'], [type='password'], [type='file'], select, textarea, [type='number'], [type='search'] ,[type='tel'], [type='url'], [type='email'], [type='datetime'], [type='date'], [type='month'], [type='week'], [type='time'], [type='datetime-local'], [type='range'], [type='color'] ","focusin focusout keyup",a).validateDelegate("[type='radio'], [type='checkbox'], select, option","click",a);this.settings.invalidHandler&&c(this.currentForm).bind("invalid-form.validate",
this.settings.invalidHandler)},form:function(){this.checkForm();c.extend(this.submitted,this.errorMap);this.invalid=c.extend({},this.errorMap);this.valid()||c(this.currentForm).triggerHandler("invalid-form",[this]);this.showErrors();return this.valid()},checkForm:function(){this.prepareForm();for(var a=0,b=this.currentElements=this.elements();b[a];a++)this.check(b[a]);return this.valid()},element:function(a){this.lastElement=a=this.clean(a);this.prepareElement(a);this.currentElements=c(a);var b=this.check(a);
b?delete this.invalid[a.name]:this.invalid[a.name]=!0;if(!this.numberOfInvalids())this.toHide=this.toHide.add(this.containers);this.showErrors();return b},showErrors:function(a){if(a){c.extend(this.errorMap,a);this.errorList=[];for(var b in a)a[b]&&this.errorList.push({message:a[b],element:this.findByName(b)[0]});this.successList=c.grep(this.successList,function(b){return!(b.name in a)})}this.settings.showErrors?this.settings.showErrors.call(this,this.errorMap,this.errorList):this.defaultShowErrors()},
resetForm:function(){c.fn.resetForm&&c(this.currentForm).resetForm();this.submitted={};this.prepareForm();this.hideErrors();this.elements().removeClass(this.settings.errorClass)},numberOfInvalids:function(){return this.objectLength(this.invalid)},objectLength:function(a){var b=0,c;for(c in a)b++;return b},hideErrors:function(){this.addWrapper(this.toHide).hide()},valid:function(){return this.size()==0},size:function(){return this.errorList.length},focusInvalid:function(){if(this.settings.focusInvalid)try{c(this.findLastActive()||
this.errorList.length&&this.errorList[0].element||[]).filter(":visible").focus().trigger("focusin")}catch(a){}},findLastActive:function(){var a=this.lastActive;return a&&c.grep(this.errorList,function(b){return b.element.name==a.name}).length==1&&a},elements:function(){var a=this,b={};return c(this.currentForm).find("input, select, textarea").not(":submit, :reset, :image, [disabled]").not(this.settings.ignore).filter(function(){!this.name&&a.settings.debug&&window.console&&console.error("%o has no name assigned",
this);return this.name in b||!a.objectLength(c(this).rules())?!1:b[this.name]=!0})},clean:function(a){return c(a)[0]},errors:function(){return c(this.settings.errorElement+"."+this.settings.errorClass,this.errorContext)},reset:function(){this.successList=[];this.errorList=[];this.errorMap={};this.toShow=c([]);this.toHide=c([]);this.currentElements=c([])},prepareForm:function(){this.reset();this.toHide=this.errors().add(this.containers)},prepareElement:function(a){this.reset();this.toHide=this.errorsFor(a)},
check:function(a){a=this.clean(a);this.checkable(a)&&(a=this.findByName(a.name).not(this.settings.ignore)[0]);var b=c(a).rules(),d=!1,e;for(e in b){var f={method:e,parameters:b[e]};try{var g=c.validator.methods[e].call(this,a.value.replace(/\r/g,""),a,f.parameters);if(g=="dependency-mismatch")d=!0;else{d=!1;if(g=="pending"){this.toHide=this.toHide.not(this.errorsFor(a));return}if(!g)return this.formatAndAdd(a,f),!1}}catch(h){throw this.settings.debug&&window.console&&console.log("exception occured when checking element "+
a.id+", check the '"+f.method+"' method",h),h;}}if(!d)return this.objectLength(b)&&this.successList.push(a),!0},customMetaMessage:function(a,b){if(c.metadata){var d=this.settings.meta?c(a).metadata()[this.settings.meta]:c(a).metadata();return d&&d.messages&&d.messages[b]}},customMessage:function(a,b){var c=this.settings.messages[a];return c&&(c.constructor==String?c:c[b])},findDefined:function(){for(var a=0;a<arguments.length;a++)if(arguments[a]!==void 0)return arguments[a]},defaultMessage:function(a,
b){return this.findDefined(this.customMessage(a.name,b),this.customMetaMessage(a,b),!this.settings.ignoreTitle&&a.title||void 0,c.validator.messages[b],"<strong>Warning: No message defined for "+a.name+"</strong>")},formatAndAdd:function(a,b){var c=this.defaultMessage(a,b.method),e=/\$?\{(\d+)\}/g;typeof c=="function"?c=c.call(this,b.parameters,a):e.test(c)&&(c=jQuery.format(c.replace(e,"{$1}"),b.parameters));c&&this.errorList.push({message:c,element:a});this.errorMap[a.name]=c;this.submitted[a.name]=
c},addWrapper:function(a){this.settings.wrapper&&(a=a.add(a.parent(this.settings.wrapper)));return a},defaultShowErrors:function(){for(var a=0;this.errorList[a];a++){var b=this.errorList[a];this.settings.highlight&&this.settings.highlight.call(this,b.element,this.settings.errorClass,this.settings.validClass);this.showLabel(b.element,b.message)}if(this.errorList.length)this.toShow=this.toShow.add(this.containers);if(this.settings.success)for(a=0;this.successList[a];a++)this.showLabel(this.successList[a]);
if(this.settings.unhighlight){a=0;for(b=this.validElements();b[a];a++)this.settings.unhighlight.call(this,b[a],this.settings.errorClass,this.settings.validClass)}this.toHide=this.toHide.not(this.toShow);this.hideErrors();this.addWrapper(this.toShow).show()},validElements:function(){return this.currentElements.not(this.invalidElements())},invalidElements:function(){return c(this.errorList).map(function(){return this.element})},showLabel:function(a,b){var d=this.errorsFor(a);d.length?(d.removeClass(this.settings.validClass).addClass(this.settings.errorClass),
d.attr("generated")&&d.html(b)):(d=c("<"+this.settings.errorElement+"/>").attr({"for":this.idOrName(a),generated:!0}).addClass(this.settings.errorClass).html(b||""),this.settings.wrapper&&(d=d.hide().show().wrap("<"+this.settings.wrapper+"/>").parent()),this.labelContainer.append(d).length||(this.settings.errorPlacement?this.settings.errorPlacement(d,c(a)):d.insertAfter(a)));!b&&this.settings.success&&(d.text(""),typeof this.settings.success=="string"?d.addClass(this.settings.success):this.settings.success(d));
this.toShow=this.toShow.add(d)},errorsFor:function(a){var b=this.idOrName(a);return this.errors().filter(function(){return c(this).attr("for")==b})},idOrName:function(a){return this.groups[a.name]||(this.checkable(a)?a.name:a.id||a.name)},checkable:function(a){return/radio|checkbox/i.test(a.type)},findByName:function(a){var b=this.currentForm;return c(document.getElementsByName(a)).map(function(c,e){return e.form==b&&e.name==a&&e||null})},getLength:function(a,b){switch(b.nodeName.toLowerCase()){case "select":return c("option:selected",
b).length;case "input":if(this.checkable(b))return this.findByName(b.name).filter(":checked").length}return a.length},depend:function(a,b){return this.dependTypes[typeof a]?this.dependTypes[typeof a](a,b):!0},dependTypes:{"boolean":function(a){return a},string:function(a,b){return!!c(a,b.form).length},"function":function(a,b){return a(b)}},optional:function(a){return!c.validator.methods.required.call(this,c.trim(a.value),a)&&"dependency-mismatch"},startRequest:function(a){this.pending[a.name]||(this.pendingRequest++,
this.pending[a.name]=!0)},stopRequest:function(a,b){this.pendingRequest--;if(this.pendingRequest<0)this.pendingRequest=0;delete this.pending[a.name];if(b&&this.pendingRequest==0&&this.formSubmitted&&this.form())c(this.currentForm).submit(),this.formSubmitted=!1;else if(!b&&this.pendingRequest==0&&this.formSubmitted)c(this.currentForm).triggerHandler("invalid-form",[this]),this.formSubmitted=!1},previousValue:function(a){return c.data(a,"previousValue")||c.data(a,"previousValue",{old:null,valid:!0,
message:this.defaultMessage(a,"remote")})}},classRuleSettings:{required:{required:!0},email:{email:!0},url:{url:!0},date:{date:!0},dateISO:{dateISO:!0},dateDE:{dateDE:!0},number:{number:!0},numberDE:{numberDE:!0},digits:{digits:!0},creditcard:{creditcard:!0}},addClassRules:function(a,b){a.constructor==String?this.classRuleSettings[a]=b:c.extend(this.classRuleSettings,a)},classRules:function(a){var b={};(a=c(a).attr("class"))&&c.each(a.split(" "),function(){this in c.validator.classRuleSettings&&c.extend(b,
c.validator.classRuleSettings[this])});return b},attributeRules:function(a){var b={},a=c(a),d;for(d in c.validator.methods){var e=a.attr(d);e?b[d]=e:a[0].getAttribute("type")===d&&(b[d]=!0)}b.maxlength&&/-1|2147483647|524288/.test(b.maxlength)&&delete b.maxlength;return b},metadataRules:function(a){if(!c.metadata)return{};var b=c.data(a.form,"validator").settings.meta;return b?c(a).metadata()[b]:c(a).metadata()},staticRules:function(a){var b={},d=c.data(a.form,"validator");d.settings.rules&&(b=c.validator.normalizeRule(d.settings.rules[a.name])||
{});return b},normalizeRules:function(a,b){c.each(a,function(d,e){if(e===!1)delete a[d];else if(e.param||e.depends){var f=!0;switch(typeof e.depends){case "string":f=!!c(e.depends,b.form).length;break;case "function":f=e.depends.call(b,b)}f?a[d]=e.param!==void 0?e.param:!0:delete a[d]}});c.each(a,function(d,e){a[d]=c.isFunction(e)?e(b):e});c.each(["minlength","maxlength","min","max"],function(){a[this]&&(a[this]=Number(a[this]))});c.each(["rangelength","range"],function(){a[this]&&(a[this]=[Number(a[this][0]),
Number(a[this][1])])});if(c.validator.autoCreateRanges){if(a.min&&a.max)a.range=[a.min,a.max],delete a.min,delete a.max;if(a.minlength&&a.maxlength)a.rangelength=[a.minlength,a.maxlength],delete a.minlength,delete a.maxlength}a.messages&&delete a.messages;return a},normalizeRule:function(a){if(typeof a=="string"){var b={};c.each(a.split(/\s/),function(){b[this]=!0});a=b}return a},addMethod:function(a,b,d){c.validator.methods[a]=b;c.validator.messages[a]=d!=void 0?d:c.validator.messages[a];b.length<
3&&c.validator.addClassRules(a,c.validator.normalizeRule(a))},methods:{required:function(a,b,d){if(!this.depend(d,b))return"dependency-mismatch";switch(b.nodeName.toLowerCase()){case "select":return(a=c(b).val())&&a.length>0;case "input":if(this.checkable(b))return this.getLength(a,b)>0;default:return c.trim(a).length>0}},remote:function(a,b,d){if(this.optional(b))return"dependency-mismatch";var e=this.previousValue(b);this.settings.messages[b.name]||(this.settings.messages[b.name]={});e.originalMessage=
this.settings.messages[b.name].remote;this.settings.messages[b.name].remote=e.message;d=typeof d=="string"&&{url:d}||d;if(this.pending[b.name])return"pending";if(e.old===a)return e.valid;e.old=a;var f=this;this.startRequest(b);var g={};g[b.name]=a;c.ajax(c.extend(!0,{url:d,mode:"abort",port:"validate"+b.name,dataType:"json",data:g,success:function(d){f.settings.messages[b.name].remote=e.originalMessage;var g=d===!0;if(g){var i=f.formSubmitted;f.prepareElement(b);f.formSubmitted=i;f.successList.push(b);
f.showErrors()}else i={},d=d||f.defaultMessage(b,"remote"),i[b.name]=e.message=c.isFunction(d)?d(a):d,f.showErrors(i);e.valid=g;f.stopRequest(b,g)}},d));return"pending"},minlength:function(a,b,d){return this.optional(b)||this.getLength(c.trim(a),b)>=d},maxlength:function(a,b,d){return this.optional(b)||this.getLength(c.trim(a),b)<=d},rangelength:function(a,b,d){a=this.getLength(c.trim(a),b);return this.optional(b)||a>=d[0]&&a<=d[1]},min:function(a,b,c){return this.optional(b)||a>=c},max:function(a,
b,c){return this.optional(b)||a<=c},range:function(a,b,c){return this.optional(b)||a>=c[0]&&a<=c[1]},email:function(a,b){return this.optional(b)||/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(a)},
url:function(a,b){return this.optional(b)||/^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(a)},
date:function(a,b){return this.optional(b)||!/Invalid|NaN/.test(new Date(a))},dateISO:function(a,b){return this.optional(b)||/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/.test(a)},number:function(a,b){return this.optional(b)||/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(a)},digits:function(a,b){return this.optional(b)||/^\d+$/.test(a)},creditcard:function(a,b){if(this.optional(b))return"dependency-mismatch";if(/[^0-9-]+/.test(a))return!1;for(var c=0,e=0,f=!1,a=a.replace(/\D/g,""),g=a.length-1;g>=0;g--){e=
a.charAt(g);e=parseInt(e,10);if(f&&(e*=2)>9)e-=9;c+=e;f=!f}return c%10==0},accept:function(a,b,c){c=typeof c=="string"?c.replace(/,/g,"|"):"png|jpe?g|gif";return this.optional(b)||a.match(RegExp(".("+c+")$","i"))},equalTo:function(a,b,d){d=c(d).unbind(".validate-equalTo").bind("blur.validate-equalTo",function(){c(b).valid()});return a==d.val()}}});c.format=c.validator.format})(jQuery);
(function(c){var a={};if(c.ajaxPrefilter)c.ajaxPrefilter(function(b,c,f){c=b.port;b.mode=="abort"&&(a[c]&&a[c].abort(),a[c]=f)});else{var b=c.ajax;c.ajax=function(d){var e=("port"in d?d:c.ajaxSettings).port;return("mode"in d?d:c.ajaxSettings).mode=="abort"?(a[e]&&a[e].abort(),a[e]=b.apply(this,arguments)):b.apply(this,arguments)}}})(jQuery);
(function(c){!jQuery.event.special.focusin&&!jQuery.event.special.focusout&&document.addEventListener&&c.each({focus:"focusin",blur:"focusout"},function(a,b){function d(a){a=c.event.fix(a);a.type=b;return c.event.handle.call(this,a)}c.event.special[b]={setup:function(){this.addEventListener(a,d,!0)},teardown:function(){this.removeEventListener(a,d,!0)},handler:function(a){arguments[0]=c.event.fix(a);arguments[0].type=b;return c.event.handle.apply(this,arguments)}}});c.extend(c.fn,{validateDelegate:function(a,
b,d){return this.bind(b,function(b){var f=c(b.target);if(f.is(a))return d.apply(f,arguments)})}})})(jQuery);;
/*!
* jQuery Cycle2; build: v20131005
* http://jquery.malsup.com/cycle2/
* Copyright (c) 2013 M. Alsup; Dual licensed: MIT/GPL
*/

/*! core engine; version: 20131003 */
;(function($) {
"use strict";

var version = '20131003';

$.fn.cycle = function( options ) {
    // fix mistakes with the ready state
    var o;
    if ( this.length === 0 && !$.isReady ) {
        o = { s: this.selector, c: this.context };
        $.fn.cycle.log('requeuing slideshow (dom not ready)');
        $(function() {
            $( o.s, o.c ).cycle(options);
        });
        return this;
    }

    return this.each(function() {
        var data, opts, shortName, val;
        var container = $(this);
        var log = $.fn.cycle.log;

        if ( container.data('cycle.opts') )
            return; // already initialized

        if ( container.data('cycle-log') === false || 
            ( options && options.log === false ) ||
            ( opts && opts.log === false) ) {
            log = $.noop;
        }

        log('--c2 init--');
        data = container.data();
        for (var p in data) {
            // allow props to be accessed sans 'cycle' prefix and log the overrides
            if (data.hasOwnProperty(p) && /^cycle[A-Z]+/.test(p) ) {
                val = data[p];
                shortName = p.match(/^cycle(.*)/)[1].replace(/^[A-Z]/, lowerCase);
                log(shortName+':', val, '('+typeof val +')');
                data[shortName] = val;
            }
        }

        opts = $.extend( {}, $.fn.cycle.defaults, data, options || {});

        opts.timeoutId = 0;
        opts.paused = opts.paused || false; // #57
        opts.container = container;
        opts._maxZ = opts.maxZ;

        opts.API = $.extend ( { _container: container }, $.fn.cycle.API );
        opts.API.log = log;
        opts.API.trigger = function( eventName, args ) {
            opts.container.trigger( eventName, args );
            return opts.API;
        };

        container.data( 'cycle.opts', opts );
        container.data( 'cycle.API', opts.API );

        // opportunity for plugins to modify opts and API
        opts.API.trigger('cycle-bootstrap', [ opts, opts.API ]);

        opts.API.addInitialSlides();
        opts.API.preInitSlideshow();

        if ( opts.slides.length )
            opts.API.initSlideshow();
    });
};

$.fn.cycle.API = {
    opts: function() {
        return this._container.data( 'cycle.opts' );
    },
    addInitialSlides: function() {
        var opts = this.opts();
        var slides = opts.slides;
        opts.slideCount = 0;
        opts.slides = $(); // empty set
        
        // add slides that already exist
        slides = slides.jquery ? slides : opts.container.find( slides );

        if ( opts.random ) {
            slides.sort(function() {return Math.random() - 0.5;});
        }

        opts.API.add( slides );
    },

    preInitSlideshow: function() {
        var opts = this.opts();
        opts.API.trigger('cycle-pre-initialize', [ opts ]);
        var tx = $.fn.cycle.transitions[opts.fx];
        if (tx && $.isFunction(tx.preInit))
            tx.preInit( opts );
        opts._preInitialized = true;
    },

    postInitSlideshow: function() {
        var opts = this.opts();
        opts.API.trigger('cycle-post-initialize', [ opts ]);
        var tx = $.fn.cycle.transitions[opts.fx];
        if (tx && $.isFunction(tx.postInit))
            tx.postInit( opts );
    },

    initSlideshow: function() {
        var opts = this.opts();
        var pauseObj = opts.container;
        var slideOpts;
        opts.API.calcFirstSlide();

        if ( opts.container.css('position') == 'static' )
            opts.container.css('position', 'relative');

        $(opts.slides[opts.currSlide]).css('opacity',1).show();
        opts.API.stackSlides( opts.slides[opts.currSlide], opts.slides[opts.nextSlide], !opts.reverse );

        if ( opts.pauseOnHover ) {
            // allow pauseOnHover to specify an element
            if ( opts.pauseOnHover !== true )
                pauseObj = $( opts.pauseOnHover );

            pauseObj.hover(
                function(){ opts.API.pause( true ); }, 
                function(){ opts.API.resume( true ); }
            );
        }

        // stage initial transition
        if ( opts.timeout ) {
            slideOpts = opts.API.getSlideOpts( opts.currSlide );
            opts.API.queueTransition( slideOpts, slideOpts.timeout + opts.delay );
        }

        opts._initialized = true;
        opts.API.updateView( true );
        opts.API.trigger('cycle-initialized', [ opts ]);
        opts.API.postInitSlideshow();
    },

    pause: function( hover ) {
        var opts = this.opts(),
            slideOpts = opts.API.getSlideOpts(),
            alreadyPaused = opts.hoverPaused || opts.paused;

        if ( hover )
            opts.hoverPaused = true; 
        else
            opts.paused = true;

        if ( ! alreadyPaused ) {
            opts.container.addClass('cycle-paused');
            opts.API.trigger('cycle-paused', [ opts ]).log('cycle-paused');

            if ( slideOpts.timeout ) {
                clearTimeout( opts.timeoutId );
                opts.timeoutId = 0;
                
                // determine how much time is left for the current slide
                opts._remainingTimeout -= ( $.now() - opts._lastQueue );
                if ( opts._remainingTimeout < 0 || isNaN(opts._remainingTimeout) )
                    opts._remainingTimeout = undefined;
            }
        }
    },

    resume: function( hover ) {
        var opts = this.opts(),
            alreadyResumed = !opts.hoverPaused && !opts.paused,
            remaining;

        if ( hover )
            opts.hoverPaused = false; 
        else
            opts.paused = false;

    
        if ( ! alreadyResumed ) {
            opts.container.removeClass('cycle-paused');
            // #gh-230; if an animation is in progress then don't queue a new transition; it will
            // happen naturally
            if ( opts.slides.filter(':animated').length === 0 )
                opts.API.queueTransition( opts.API.getSlideOpts(), opts._remainingTimeout );
            opts.API.trigger('cycle-resumed', [ opts, opts._remainingTimeout ] ).log('cycle-resumed');
        }
    },

    add: function( slides, prepend ) {
        var opts = this.opts();
        var oldSlideCount = opts.slideCount;
        var startSlideshow = false;
        var len;

        if ( $.type(slides) == 'string')
            slides = $.trim( slides );

        $( slides ).each(function(i) {
            var slideOpts;
            var slide = $(this);

            if ( prepend )
                opts.container.prepend( slide );
            else
                opts.container.append( slide );

            opts.slideCount++;
            slideOpts = opts.API.buildSlideOpts( slide );

            if ( prepend )
                opts.slides = $( slide ).add( opts.slides );
            else
                opts.slides = opts.slides.add( slide );

            opts.API.initSlide( slideOpts, slide, --opts._maxZ );

            slide.data('cycle.opts', slideOpts);
            opts.API.trigger('cycle-slide-added', [ opts, slideOpts, slide ]);
        });

        opts.API.updateView( true );

        startSlideshow = opts._preInitialized && (oldSlideCount < 2 && opts.slideCount >= 1);
        if ( startSlideshow ) {
            if ( !opts._initialized )
                opts.API.initSlideshow();
            else if ( opts.timeout ) {
                len = opts.slides.length;
                opts.nextSlide = opts.reverse ? len - 1 : 1;
                if ( !opts.timeoutId ) {
                    opts.API.queueTransition( opts );
                }
            }
        }
    },

    calcFirstSlide: function() {
        var opts = this.opts();
        var firstSlideIndex;
        firstSlideIndex = parseInt( opts.startingSlide || 0, 10 );
        if (firstSlideIndex >= opts.slides.length || firstSlideIndex < 0)
            firstSlideIndex = 0;

        opts.currSlide = firstSlideIndex;
        if ( opts.reverse ) {
            opts.nextSlide = firstSlideIndex - 1;
            if (opts.nextSlide < 0)
                opts.nextSlide = opts.slides.length - 1;
        }
        else {
            opts.nextSlide = firstSlideIndex + 1;
            if (opts.nextSlide == opts.slides.length)
                opts.nextSlide = 0;
        }
    },

    calcNextSlide: function() {
        var opts = this.opts();
        var roll;
        if ( opts.reverse ) {
            roll = (opts.nextSlide - 1) < 0;
            opts.nextSlide = roll ? opts.slideCount - 1 : opts.nextSlide-1;
            opts.currSlide = roll ? 0 : opts.nextSlide+1;
        }
        else {
            roll = (opts.nextSlide + 1) == opts.slides.length;
            opts.nextSlide = roll ? 0 : opts.nextSlide+1;
            opts.currSlide = roll ? opts.slides.length-1 : opts.nextSlide-1;
        }
    },

    calcTx: function( slideOpts, manual ) {
        var opts = slideOpts;
        var tx;
        if ( manual && opts.manualFx )
            tx = $.fn.cycle.transitions[opts.manualFx];
        if ( !tx )
            tx = $.fn.cycle.transitions[opts.fx];

        if (!tx) {
            tx = $.fn.cycle.transitions.fade;
            opts.API.log('Transition "' + opts.fx + '" not found.  Using fade.');
        }
        return tx;
    },

    prepareTx: function( manual, fwd ) {
        var opts = this.opts();
        var after, curr, next, slideOpts, tx;

        if ( opts.slideCount < 2 ) {
            opts.timeoutId = 0;
            return;
        }
        if ( manual && ( !opts.busy || opts.manualTrump ) ) {
            opts.API.stopTransition();
            opts.busy = false;
            clearTimeout(opts.timeoutId);
            opts.timeoutId = 0;
        }
        if ( opts.busy )
            return;
        if ( opts.timeoutId === 0 && !manual )
            return;

        curr = opts.slides[opts.currSlide];
        next = opts.slides[opts.nextSlide];
        slideOpts = opts.API.getSlideOpts( opts.nextSlide );
        tx = opts.API.calcTx( slideOpts, manual );

        opts._tx = tx;

        if ( manual && slideOpts.manualSpeed !== undefined )
            slideOpts.speed = slideOpts.manualSpeed;

        // if ( opts.nextSlide === opts.currSlide )
        //     opts.API.calcNextSlide();

        // ensure that:
        //      1. advancing to a different slide
        //      2. this is either a manual event (prev/next, pager, cmd) or 
        //              a timer event and slideshow is not paused
        if ( opts.nextSlide != opts.currSlide && 
            (manual || (!opts.paused && !opts.hoverPaused && opts.timeout) )) { // #62

            opts.API.trigger('cycle-before', [ slideOpts, curr, next, fwd ]);
            if ( tx.before )
                tx.before( slideOpts, curr, next, fwd );

            after = function() {
                opts.busy = false;
                // #76; bail if slideshow has been destroyed
                if (! opts.container.data( 'cycle.opts' ) )
                    return;

                if (tx.after)
                    tx.after( slideOpts, curr, next, fwd );
                opts.API.trigger('cycle-after', [ slideOpts, curr, next, fwd ]);
                opts.API.queueTransition( slideOpts);
                opts.API.updateView( true );
            };

            opts.busy = true;
            if (tx.transition)
                tx.transition(slideOpts, curr, next, fwd, after);
            else
                opts.API.doTransition( slideOpts, curr, next, fwd, after);

            opts.API.calcNextSlide();
            opts.API.updateView();
        } else {
            opts.API.queueTransition( slideOpts );
        }
    },

    // perform the actual animation
    doTransition: function( slideOpts, currEl, nextEl, fwd, callback) {
        var opts = slideOpts;
        var curr = $(currEl), next = $(nextEl);
        var fn = function() {
            // make sure animIn has something so that callback doesn't trigger immediately
            next.animate(opts.animIn || { opacity: 1}, opts.speed, opts.easeIn || opts.easing, callback);
        };

        next.css(opts.cssBefore || {});
        curr.animate(opts.animOut || {}, opts.speed, opts.easeOut || opts.easing, function() {
            curr.css(opts.cssAfter || {});
            if (!opts.sync) {
                fn();
            }
        });
        if (opts.sync) {
            fn();
        }
    },

    queueTransition: function( slideOpts, specificTimeout ) {
        var opts = this.opts();
        var timeout = specificTimeout !== undefined ? specificTimeout : slideOpts.timeout;
        if (opts.nextSlide === 0 && --opts.loop === 0) {
            opts.API.log('terminating; loop=0');
            opts.timeout = 0;
            if ( timeout ) {
                setTimeout(function() {
                    opts.API.trigger('cycle-finished', [ opts ]);
                }, timeout);
            }
            else {
                opts.API.trigger('cycle-finished', [ opts ]);
            }
            // reset nextSlide
            opts.nextSlide = opts.currSlide;
            return;
        }
        if ( timeout ) {
            opts._lastQueue = $.now();
            if ( specificTimeout === undefined )
                opts._remainingTimeout = slideOpts.timeout;

            if ( !opts.paused && ! opts.hoverPaused ) {
                opts.timeoutId = setTimeout(function() { 
                    opts.API.prepareTx( false, !opts.reverse ); 
                }, timeout );
            }
        }
    },

    stopTransition: function() {
        var opts = this.opts();
        if ( opts.slides.filter(':animated').length ) {
            opts.slides.stop(false, true);
            opts.API.trigger('cycle-transition-stopped', [ opts ]);
        }

        if ( opts._tx && opts._tx.stopTransition )
            opts._tx.stopTransition( opts );
    },

    // advance slide forward or back
    advanceSlide: function( val ) {
        var opts = this.opts();
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.nextSlide = opts.currSlide + val;
        
        if (opts.nextSlide < 0)
            opts.nextSlide = opts.slides.length - 1;
        else if (opts.nextSlide >= opts.slides.length)
            opts.nextSlide = 0;

        opts.API.prepareTx( true,  val >= 0 );
        return false;
    },

    buildSlideOpts: function( slide ) {
        var opts = this.opts();
        var val, shortName;
        var slideOpts = slide.data() || {};
        for (var p in slideOpts) {
            // allow props to be accessed sans 'cycle' prefix and log the overrides
            if (slideOpts.hasOwnProperty(p) && /^cycle[A-Z]+/.test(p) ) {
                val = slideOpts[p];
                shortName = p.match(/^cycle(.*)/)[1].replace(/^[A-Z]/, lowerCase);
                opts.API.log('['+(opts.slideCount-1)+']', shortName+':', val, '('+typeof val +')');
                slideOpts[shortName] = val;
            }
        }

        slideOpts = $.extend( {}, $.fn.cycle.defaults, opts, slideOpts );
        slideOpts.slideNum = opts.slideCount;

        try {
            // these props should always be read from the master state object
            delete slideOpts.API;
            delete slideOpts.slideCount;
            delete slideOpts.currSlide;
            delete slideOpts.nextSlide;
            delete slideOpts.slides;
        } catch(e) {
            // no op
        }
        return slideOpts;
    },

    getSlideOpts: function( index ) {
        var opts = this.opts();
        if ( index === undefined )
            index = opts.currSlide;

        var slide = opts.slides[index];
        var slideOpts = $(slide).data('cycle.opts');
        return $.extend( {}, opts, slideOpts );
    },
    
    initSlide: function( slideOpts, slide, suggestedZindex ) {
        var opts = this.opts();
        slide.css( slideOpts.slideCss || {} );
        if ( suggestedZindex > 0 )
            slide.css( 'zIndex', suggestedZindex );

        // ensure that speed settings are sane
        if ( isNaN( slideOpts.speed ) )
            slideOpts.speed = $.fx.speeds[slideOpts.speed] || $.fx.speeds._default;
        if ( !slideOpts.sync )
            slideOpts.speed = slideOpts.speed / 2;

        slide.addClass( opts.slideClass );
    },

    updateView: function( isAfter, isDuring ) {
        var opts = this.opts();
        if ( !opts._initialized )
            return;
        var slideOpts = opts.API.getSlideOpts();
        var currSlide = opts.slides[ opts.currSlide ];

        if ( ! isAfter && isDuring !== true ) {
            opts.API.trigger('cycle-update-view-before', [ opts, slideOpts, currSlide ]);
            if ( opts.updateView < 0 )
                return;
        }

        if ( opts.slideActiveClass ) {
            opts.slides.removeClass( opts.slideActiveClass )
                .eq( opts.currSlide ).addClass( opts.slideActiveClass );
        }

        if ( isAfter && opts.hideNonActive )
            opts.slides.filter( ':not(.' + opts.slideActiveClass + ')' ).hide();

        opts.API.trigger('cycle-update-view', [ opts, slideOpts, currSlide, isAfter ]);
        
        if ( isAfter )
            opts.API.trigger('cycle-update-view-after', [ opts, slideOpts, currSlide ]);
    },

    getComponent: function( name ) {
        var opts = this.opts();
        var selector = opts[name];
        if (typeof selector === 'string') {
            // if selector is a child, sibling combinator, adjancent selector then use find, otherwise query full dom
            return (/^\s*[\>|\+|~]/).test( selector ) ? opts.container.find( selector ) : $( selector );
        }
        if (selector.jquery)
            return selector;
        
        return $(selector);
    },

    stackSlides: function( curr, next, fwd ) {
        var opts = this.opts();
        if ( !curr ) {
            curr = opts.slides[opts.currSlide];
            next = opts.slides[opts.nextSlide];
            fwd = !opts.reverse;
        }

        // reset the zIndex for the common case:
        // curr slide on top,  next slide beneath, and the rest in order to be shown
        $(curr).css('zIndex', opts.maxZ);

        var i;
        var z = opts.maxZ - 2;
        var len = opts.slideCount;
        if (fwd) {
            for ( i = opts.currSlide + 1; i < len; i++ )
                $( opts.slides[i] ).css( 'zIndex', z-- );
            for ( i = 0; i < opts.currSlide; i++ )
                $( opts.slides[i] ).css( 'zIndex', z-- );
        }
        else {
            for ( i = opts.currSlide - 1; i >= 0; i-- )
                $( opts.slides[i] ).css( 'zIndex', z-- );
            for ( i = len - 1; i > opts.currSlide; i-- )
                $( opts.slides[i] ).css( 'zIndex', z-- );
        }

        $(next).css('zIndex', opts.maxZ - 1);
    },

    getSlideIndex: function( el ) {
        return this.opts().slides.index( el );
    }

}; // API

// default logger
$.fn.cycle.log = function log() {
    /*global console:true */
    if (window.console && console.log)
        console.log('[cycle2] ' + Array.prototype.join.call(arguments, ' ') );
};

$.fn.cycle.version = function() { return 'Cycle2: ' + version; };

// helper functions

function lowerCase(s) {
    return (s || '').toLowerCase();
}

// expose transition object
$.fn.cycle.transitions = {
    custom: {
    },
    none: {
        before: function( opts, curr, next, fwd ) {
            opts.API.stackSlides( next, curr, fwd );
            opts.cssBefore = { opacity: 1, display: 'block' };
        }
    },
    fade: {
        before: function( opts, curr, next, fwd ) {
            var css = opts.API.getSlideOpts( opts.nextSlide ).slideCss || {};
            opts.API.stackSlides( curr, next, fwd );
            opts.cssBefore = $.extend(css, { opacity: 0, display: 'block' });
            opts.animIn = { opacity: 1 };
            opts.animOut = { opacity: 0 };
        }
    },
    fadeout: {
        before: function( opts , curr, next, fwd ) {
            var css = opts.API.getSlideOpts( opts.nextSlide ).slideCss || {};
            opts.API.stackSlides( curr, next, fwd );
            opts.cssBefore = $.extend(css, { opacity: 1, display: 'block' });
            opts.animOut = { opacity: 0 };
        }
    },
    scrollHorz: {
        before: function( opts, curr, next, fwd ) {
            opts.API.stackSlides( curr, next, fwd );
            var w = opts.container.css('overflow','hidden').width();
            opts.cssBefore = { left: fwd ? w : - w, top: 0, opacity: 1, display: 'block' };
            opts.cssAfter = { zIndex: opts._maxZ - 2, left: 0 };
            opts.animIn = { left: 0 };
            opts.animOut = { left: fwd ? -w : w };
        }
    }
};

// @see: http://jquery.malsup.com/cycle2/api
$.fn.cycle.defaults = {
    allowWrap:        true,
    autoSelector:     '.cycle-slideshow[data-cycle-auto-init!=false]',
    delay:            0,
    easing:           null,
    fx:              'fade',
    hideNonActive:    true,
    loop:             0,
    manualFx:         undefined,
    manualSpeed:      undefined,
    manualTrump:      true,
    maxZ:             100,
    pauseOnHover:     false,
    reverse:          false,
    slideActiveClass: 'cycle-slide-active',
    slideClass:       'cycle-slide',
    slideCss:         { position: 'absolute', top: 0, left: 0 },
    slides:          '> img',
    speed:            500,
    startingSlide:    0,
    sync:             true,
    timeout:          4000,
    updateView:       -1
};

// automatically find and run slideshows
$(document).ready(function() {
    $( $.fn.cycle.defaults.autoSelector ).cycle();
});

})(jQuery);

/*! Cycle2 autoheight plugin; Copyright (c) M.Alsup, 2012; version: 20130304 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    autoHeight: 0 // setting this option to false disables autoHeight logic
});    

$(document).on( 'cycle-initialized', function( e, opts ) {
    var autoHeight = opts.autoHeight;
    var t = $.type( autoHeight );
    var resizeThrottle = null;
    var ratio;

    if ( t !== 'string' && t !== 'number' )
        return;

    // bind events
    opts.container.on( 'cycle-slide-added cycle-slide-removed', initAutoHeight );
    opts.container.on( 'cycle-destroyed', onDestroy );

    if ( autoHeight == 'container' ) {
        opts.container.on( 'cycle-before', onBefore );
    }
    else if ( t === 'string' && /\d+\:\d+/.test( autoHeight ) ) { 
        // use ratio
        ratio = autoHeight.match(/(\d+)\:(\d+)/);
        ratio = ratio[1] / ratio[2];
        opts._autoHeightRatio = ratio;
    }

    // if autoHeight is a number then we don't need to recalculate the sentinel
    // index on resize
    if ( t !== 'number' ) {
        // bind unique resize handler per slideshow (so it can be 'off-ed' in onDestroy)
        opts._autoHeightOnResize = function () {
            clearTimeout( resizeThrottle );
            resizeThrottle = setTimeout( onResize, 50 );
        };

        $(window).on( 'resize orientationchange', opts._autoHeightOnResize );
    }

    setTimeout( onResize, 30 );

    function onResize() {
        initAutoHeight( e, opts );
    }
});

function initAutoHeight( e, opts ) {
    var clone, height, sentinelIndex;
    var autoHeight = opts.autoHeight;

    if ( autoHeight == 'container' ) {
        height = $( opts.slides[ opts.currSlide ] ).outerHeight();
        opts.container.height( height );
    }
    else if ( opts._autoHeightRatio ) { 
        opts.container.height( opts.container.width() / opts._autoHeightRatio );
    }
    else if ( autoHeight === 'calc' || ( $.type( autoHeight ) == 'number' && autoHeight >= 0 ) ) {
        if ( autoHeight === 'calc' )
            sentinelIndex = calcSentinelIndex( e, opts );
        else if ( autoHeight >= opts.slides.length )
            sentinelIndex = 0;
        else 
            sentinelIndex = autoHeight;

        // only recreate sentinel if index is different
        if ( sentinelIndex == opts._sentinelIndex )
            return;

        opts._sentinelIndex = sentinelIndex;
        if ( opts._sentinel )
            opts._sentinel.remove();

        // clone existing slide as sentinel
        clone = $( opts.slides[ sentinelIndex ].cloneNode(true) );
        
        // #50; remove special attributes from cloned content
        clone.removeAttr( 'id name rel' ).find( '[id],[name],[rel]' ).removeAttr( 'id name rel' );

        clone.css({
            position: 'static',
            visibility: 'hidden',
            display: 'block'
        }).prependTo( opts.container ).addClass('cycle-sentinel cycle-slide').removeClass('cycle-slide-active');
        clone.find( '*' ).css( 'visibility', 'hidden' );

        opts._sentinel = clone;
    }
}    

function calcSentinelIndex( e, opts ) {
    var index = 0, max = -1;

    // calculate tallest slide index
    opts.slides.each(function(i) {
        var h = $(this).height();
        if ( h > max ) {
            max = h;
            index = i;
        }
    });
    return index;
}

function onBefore( e, opts, outgoing, incoming, forward ) {
    var h = $(incoming).outerHeight();
    var duration = opts.sync ? opts.speed / 2 : opts.speed;
    opts.container.animate( { height: h }, duration );
}

function onDestroy( e, opts ) {
    if ( opts._autoHeightOnResize ) {
        $(window).off( 'resize orientationchange', opts._autoHeightOnResize );
        opts._autoHeightOnResize = null;
    }
    opts.container.off( 'cycle-slide-added cycle-slide-removed', initAutoHeight );
    opts.container.off( 'cycle-destroyed', onDestroy );
    opts.container.off( 'cycle-before', onBefore );

    if ( opts._sentinel ) {
        opts._sentinel.remove();
        opts._sentinel = null;
    }
}

})(jQuery);

/*! caption plugin for Cycle2;  version: 20130306 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    caption:          '> .cycle-caption',
    captionTemplate:  '{{slideNum}} / {{slideCount}}',
    overlay:          '> .cycle-overlay',
    overlayTemplate:  '<div>{{title}}</div><div>{{desc}}</div>',
    captionModule:    'caption'
});    

$(document).on( 'cycle-update-view', function( e, opts, slideOpts, currSlide ) {
    if ( opts.captionModule !== 'caption' )
        return;
    var el;
    $.each(['caption','overlay'], function() {
        var name = this; 
        var template = slideOpts[name+'Template'];
        var el = opts.API.getComponent( name );
        if( el.length && template ) {
            el.html( opts.API.tmpl( template, slideOpts, opts, currSlide ) );
            el.show();
        }
        else {
            el.hide();
        }
    });
});

$(document).on( 'cycle-destroyed', function( e, opts ) {
    var el;
    $.each(['caption','overlay'], function() {
        var name = this, template = opts[name+'Template'];
        if ( opts[name] && template ) {
            el = opts.API.getComponent( 'caption' );
            el.empty();
        }
    });
});

})(jQuery);

/*! command plugin for Cycle2;  version: 20130707 */
(function($) {
"use strict";

var c2 = $.fn.cycle;

$.fn.cycle = function( options ) {
    var cmd, cmdFn, opts;
    var args = $.makeArray( arguments );

    if ( $.type( options ) == 'number' ) {
        return this.cycle( 'goto', options );
    }

    if ( $.type( options ) == 'string' ) {
        return this.each(function() {
            var cmdArgs;
            cmd = options;
            opts = $(this).data('cycle.opts');

            if ( opts === undefined ) {
                c2.log('slideshow must be initialized before sending commands; "' + cmd + '" ignored');
                return;
            }
            else {
                cmd = cmd == 'goto' ? 'jump' : cmd; // issue #3; change 'goto' to 'jump' internally
                cmdFn = opts.API[ cmd ];
                if ( $.isFunction( cmdFn )) {
                    cmdArgs = $.makeArray( args );
                    cmdArgs.shift();
                    return cmdFn.apply( opts.API, cmdArgs );
                }
                else {
                    c2.log( 'unknown command: ', cmd );
                }
            }
        });
    }
    else {
        return c2.apply( this, arguments );
    }
};

// copy props
$.extend( $.fn.cycle, c2 );

$.extend( c2.API, {
    next: function() {
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;
        
        var count = opts.reverse ? -1 : 1;
        if ( opts.allowWrap === false && ( opts.currSlide + count ) >= opts.slideCount )
            return;

        opts.API.advanceSlide( count );
        opts.API.trigger('cycle-next', [ opts ]).log('cycle-next');
    },

    prev: function() {
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;
        var count = opts.reverse ? 1 : -1;
        if ( opts.allowWrap === false && ( opts.currSlide + count ) < 0 )
            return;

        opts.API.advanceSlide( count );
        opts.API.trigger('cycle-prev', [ opts ]).log('cycle-prev');
    },

    destroy: function() {
        this.stop(); //#204

        var opts = this.opts();
        var clean = $.isFunction( $._data ) ? $._data : $.noop;  // hack for #184 and #201
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.stop();
        opts.API.trigger( 'cycle-destroyed', [ opts ] ).log('cycle-destroyed');
        opts.container.removeData();
        clean( opts.container[0], 'parsedAttrs', false );

        // #75; remove inline styles
        if ( ! opts.retainStylesOnDestroy ) {
            opts.container.removeAttr( 'style' );
            opts.slides.removeAttr( 'style' );
            opts.slides.removeClass( opts.slideActiveClass );
        }
        opts.slides.each(function() {
            $(this).removeData();
            clean( this, 'parsedAttrs', false );
        });
    },

    jump: function( index ) {
        // go to the requested slide
        var fwd;
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;
        var num = parseInt( index, 10 );
        if (isNaN(num) || num < 0 || num >= opts.slides.length) {
            opts.API.log('goto: invalid slide index: ' + num);
            return;
        }
        if (num == opts.currSlide) {
            opts.API.log('goto: skipping, already on slide', num);
            return;
        }
        opts.nextSlide = num;
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.log('goto: ', num, ' (zero-index)');
        fwd = opts.currSlide < opts.nextSlide;
        opts.API.prepareTx( true, fwd );
    },

    stop: function() {
        var opts = this.opts();
        var pauseObj = opts.container;
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.stopTransition();
        if ( opts.pauseOnHover ) {
            if ( opts.pauseOnHover !== true )
                pauseObj = $( opts.pauseOnHover );
            pauseObj.off('mouseenter mouseleave');
        }
        opts.API.trigger('cycle-stopped', [ opts ]).log('cycle-stopped');
    },

    reinit: function() {
        var opts = this.opts();
        opts.API.destroy();
        opts.container.cycle();
    },

    remove: function( index ) {
        var opts = this.opts();
        var slide, slideToRemove, slides = [], slideNum = 1;
        for ( var i=0; i < opts.slides.length; i++ ) {
            slide = opts.slides[i];
            if ( i == index ) {
                slideToRemove = slide;
            }
            else {
                slides.push( slide );
                $( slide ).data('cycle.opts').slideNum = slideNum;
                slideNum++;
            }
        }
        if ( slideToRemove ) {
            opts.slides = $( slides );
            opts.slideCount--;
            $( slideToRemove ).remove();
            if (index == opts.currSlide)
                opts.API.advanceSlide( 1 );
            else if ( index < opts.currSlide )
                opts.currSlide--;
            else
                opts.currSlide++;

            opts.API.trigger('cycle-slide-removed', [ opts, index, slideToRemove ]).log('cycle-slide-removed');
            opts.API.updateView();
        }
    }

});

// listen for clicks on elements with data-cycle-cmd attribute
$(document).on('click.cycle', '[data-cycle-cmd]', function(e) {
    // issue cycle command
    e.preventDefault();
    var el = $(this);
    var command = el.data('cycle-cmd');
    var context = el.data('cycle-context') || '.cycle-slideshow';
    $(context).cycle(command, el.data('cycle-arg'));
});


})(jQuery);

/*! hash plugin for Cycle2;  version: 20130905 */
(function($) {
"use strict";

$(document).on( 'cycle-pre-initialize', function( e, opts ) {
    onHashChange( opts, true );

    opts._onHashChange = function() {
        onHashChange( opts, false );
    };

    $( window ).on( 'hashchange', opts._onHashChange);
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts ) {
    if ( slideOpts.hash && ( '#' + slideOpts.hash ) != window.location.hash ) {
        opts._hashFence = true;
        window.location.hash = slideOpts.hash;
    }
});

$(document).on( 'cycle-destroyed', function( e, opts) {
    if ( opts._onHashChange ) {
        $( window ).off( 'hashchange', opts._onHashChange );
    }
});

function onHashChange( opts, setStartingSlide ) {
    var hash;
    if ( opts._hashFence ) {
        opts._hashFence = false;
        return;
    }
    
    hash = window.location.hash.substring(1);

    opts.slides.each(function(i) {
        if ( $(this).data( 'cycle-hash' ) == hash ) {
            if ( setStartingSlide === true ) {
                opts.startingSlide = i;
            }
            else {
                var fwd = opts.currSlide < i;
                opts.nextSlide = i;
                opts.API.prepareTx( true, fwd );
            }
            return false;
        }
    });
}

})(jQuery);

/*! loader plugin for Cycle2;  version: 20130307 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    loader: false
});

$(document).on( 'cycle-bootstrap', function( e, opts ) {
    var addFn;

    if ( !opts.loader )
        return;

    // override API.add for this slideshow
    addFn = opts.API.add;
    opts.API.add = add;

    function add( slides, prepend ) {
        var slideArr = [];
        if ( $.type( slides ) == 'string' )
            slides = $.trim( slides );
        else if ( $.type( slides) === 'array' ) {
            for (var i=0; i < slides.length; i++ )
                slides[i] = $(slides[i])[0];
        }

        slides = $( slides );
        var slideCount = slides.length;

        if ( ! slideCount )
            return;

        slides.hide().appendTo('body').each(function(i) { // appendTo fixes #56
            var count = 0;
            var slide = $(this);
            var images = slide.is('img') ? slide : slide.find('img');
            slide.data('index', i);
            // allow some images to be marked as unimportant (and filter out images w/o src value)
            images = images.filter(':not(.cycle-loader-ignore)').filter(':not([src=""])');
            if ( ! images.length ) {
                --slideCount;
                slideArr.push( slide );
                return;
            }

            count = images.length;
            images.each(function() {
                // add images that are already loaded
                if ( this.complete ) {
                    imageLoaded();
                }
                else {
                    $(this).load(function() {
                        imageLoaded();
                    }).error(function() {
                        if ( --count === 0 ) {
                            // ignore this slide
                            opts.API.log('slide skipped; img not loaded:', this.src);
                            if ( --slideCount === 0 && opts.loader == 'wait') {
                                addFn.apply( opts.API, [ slideArr, prepend ] );
                            }
                        }
                    });
                }
            });

            function imageLoaded() {
                if ( --count === 0 ) {
                    --slideCount;
                    addSlide( slide );
                }
            }
        });

        if ( slideCount )
            opts.container.addClass('cycle-loading');
        

        function addSlide( slide ) {
            var curr;
            if ( opts.loader == 'wait' ) {
                slideArr.push( slide );
                if ( slideCount === 0 ) {
                    // #59; sort slides into original markup order
                    slideArr.sort( sorter );
                    addFn.apply( opts.API, [ slideArr, prepend ] );
                    opts.container.removeClass('cycle-loading');
                }
            }
            else {
                curr = $(opts.slides[opts.currSlide]);
                addFn.apply( opts.API, [ slide, prepend ] );
                curr.show();
                opts.container.removeClass('cycle-loading');
            }
        }

        function sorter(a, b) {
            return a.data('index') - b.data('index');
        }
    }
});

})(jQuery);

/*! pager plugin for Cycle2;  version: 20130525 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    pager:            '> .cycle-pager',
    pagerActiveClass: 'cycle-pager-active',
    pagerEvent:       'click.cycle',
    pagerTemplate:    '<span>&bull;</span>'
});    

$(document).on( 'cycle-bootstrap', function( e, opts, API ) {
    // add method to API
    API.buildPagerLink = buildPagerLink;
});

$(document).on( 'cycle-slide-added', function( e, opts, slideOpts, slideAdded ) {
    if ( opts.pager ) {
        opts.API.buildPagerLink ( opts, slideOpts, slideAdded );
        opts.API.page = page;
    }
});

$(document).on( 'cycle-slide-removed', function( e, opts, index, slideRemoved ) {
    if ( opts.pager ) {
        var pagers = opts.API.getComponent( 'pager' );
        pagers.each(function() {
            var pager = $(this);
            $( pager.children()[index] ).remove();
        });
    }
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts ) {
    var pagers;

    if ( opts.pager ) {
        pagers = opts.API.getComponent( 'pager' );
        pagers.each(function() {
           $(this).children().removeClass( opts.pagerActiveClass )
            .eq( opts.currSlide ).addClass( opts.pagerActiveClass );
        });
    }
});

$(document).on( 'cycle-destroyed', function( e, opts ) {
    var pager = opts.API.getComponent( 'pager' );

    if ( pager ) {
        pager.children().off( opts.pagerEvent ); // #202
        if ( opts.pagerTemplate )
            pager.empty();
    }
});

function buildPagerLink( opts, slideOpts, slide ) {
    var pagerLink;
    var pagers = opts.API.getComponent( 'pager' );
    pagers.each(function() {
        var pager = $(this);
        if ( slideOpts.pagerTemplate ) {
            var markup = opts.API.tmpl( slideOpts.pagerTemplate, slideOpts, opts, slide[0] );
            pagerLink = $( markup ).appendTo( pager );
        }
        else {
            pagerLink = pager.children().eq( opts.slideCount - 1 );
        }
        pagerLink.on( opts.pagerEvent, function(e) {
            e.preventDefault();
            opts.API.page( pager, e.currentTarget);
        });
    });
}

function page( pager, target ) {
    /*jshint validthis:true */
    var opts = this.opts();
    if ( opts.busy && ! opts.manualTrump )
        return;

    var index = pager.children().index( target );
    var nextSlide = index;
    var fwd = opts.currSlide < nextSlide;
    if (opts.currSlide == nextSlide) {
        return; // no op, clicked pager for the currently displayed slide
    }
    opts.nextSlide = nextSlide;
    opts.API.prepareTx( true, fwd );
    opts.API.trigger('cycle-pager-activated', [opts, pager, target ]);
}

})(jQuery);


/*! prevnext plugin for Cycle2;  version: 20130709 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    next:           '> .cycle-next',
    nextEvent:      'click.cycle',
    disabledClass:  'disabled',
    prev:           '> .cycle-prev',
    prevEvent:      'click.cycle',
    swipe:          false
});

$(document).on( 'cycle-initialized', function( e, opts ) {
    opts.API.getComponent( 'next' ).on( opts.nextEvent, function(e) {
        e.preventDefault();
        opts.API.next();
    });

    opts.API.getComponent( 'prev' ).on( opts.prevEvent, function(e) {
        e.preventDefault();
        opts.API.prev();
    });

    if ( opts.swipe ) {
        var nextEvent = opts.swipeVert ? 'swipeUp.cycle' : 'swipeLeft.cycle swipeleft.cycle';
        var prevEvent = opts.swipeVert ? 'swipeDown.cycle' : 'swipeRight.cycle swiperight.cycle';
        opts.container.on( nextEvent, function(e) {
            opts.API.next();
        });
        opts.container.on( prevEvent, function() {
            opts.API.prev();
        });
    }
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts, currSlide ) {
    if ( opts.allowWrap )
        return;

    var cls = opts.disabledClass;
    var next = opts.API.getComponent( 'next' );
    var prev = opts.API.getComponent( 'prev' );
    var prevBoundry = opts._prevBoundry || 0;
    var nextBoundry = (opts._nextBoundry !== undefined)?opts._nextBoundry:opts.slideCount - 1;

    if ( opts.currSlide == nextBoundry )
        next.addClass( cls ).prop( 'disabled', true );
    else
        next.removeClass( cls ).prop( 'disabled', false );

    if ( opts.currSlide === prevBoundry )
        prev.addClass( cls ).prop( 'disabled', true );
    else
        prev.removeClass( cls ).prop( 'disabled', false );
});


$(document).on( 'cycle-destroyed', function( e, opts ) {
    opts.API.getComponent( 'prev' ).off( opts.nextEvent );
    opts.API.getComponent( 'next' ).off( opts.prevEvent );
    opts.container.off( 'swipeleft.cycle swiperight.cycle swipeLeft.cycle swipeRight.cycle swipeUp.cycle swipeDown.cycle' );
});

})(jQuery);

/*! progressive loader plugin for Cycle2;  version: 20130315 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    progressive: false
});

$(document).on( 'cycle-pre-initialize', function( e, opts ) {
    if ( !opts.progressive )
        return;

    var API = opts.API;
    var nextFn = API.next;
    var prevFn = API.prev;
    var prepareTxFn = API.prepareTx;
    var type = $.type( opts.progressive );
    var slides, scriptEl;

    if ( type == 'array' ) {
        slides = opts.progressive;
    }
    else if ($.isFunction( opts.progressive ) ) {
        slides = opts.progressive( opts );
    }
    else if ( type == 'string' ) {
        scriptEl = $( opts.progressive );
        slides = $.trim( scriptEl.html() );
        if ( !slides )
            return;
        // is it json array?
        if ( /^(\[)/.test( slides ) ) {
            try {
                slides = $.parseJSON( slides );
            }
            catch(err) {
                API.log( 'error parsing progressive slides', err );
                return;
            }
        }
        else {
            // plain text, split on delimeter
            slides = slides.split( new RegExp( scriptEl.data('cycle-split') || '\n') );
            
            // #95; look for empty slide
            if ( ! slides[ slides.length - 1 ] )
                slides.pop();
        }
    }



    if ( prepareTxFn ) {
        API.prepareTx = function( manual, fwd ) {
            var index, slide;

            if ( manual || slides.length === 0 ) {
                prepareTxFn.apply( opts.API, [ manual, fwd ] );
                return;
            }

            if ( fwd && opts.currSlide == ( opts.slideCount-1) ) {
                slide = slides[ 0 ];
                slides = slides.slice( 1 );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    setTimeout(function() {
                        opts.API.advanceSlide( 1 );
                    },50);
                });
                opts.API.add( slide );
            }
            else if ( !fwd && opts.currSlide === 0 ) {
                index = slides.length-1;
                slide = slides[ index ];
                slides = slides.slice( 0, index );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    setTimeout(function() {
                        opts.currSlide = 1;
                        opts.API.advanceSlide( -1 );
                    },50);
                });
                opts.API.add( slide, true );
            }
            else {
                prepareTxFn.apply( opts.API, [ manual, fwd ] );
            }
        };
    }

    if ( nextFn ) {
        API.next = function() {
            var opts = this.opts();
            if ( slides.length && opts.currSlide == ( opts.slideCount - 1 ) ) {
                var slide = slides[ 0 ];
                slides = slides.slice( 1 );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    nextFn.apply( opts.API );
                    opts.container.removeClass('cycle-loading');
                });
                opts.container.addClass('cycle-loading');
                opts.API.add( slide );
            }
            else {
                nextFn.apply( opts.API );    
            }
        };
    }
    
    if ( prevFn ) {
        API.prev = function() {
            var opts = this.opts();
            if ( slides.length && opts.currSlide === 0 ) {
                var index = slides.length-1;
                var slide = slides[ index ];
                slides = slides.slice( 0, index );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    opts.currSlide = 1;
                    opts.API.advanceSlide( -1 );
                    opts.container.removeClass('cycle-loading');
                });
                opts.container.addClass('cycle-loading');
                opts.API.add( slide, true );
            }
            else {
                prevFn.apply( opts.API );
            }
        };
    }
});

})(jQuery);

/*! tmpl plugin for Cycle2;  version: 20121227 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    tmplRegex: '{{((.)?.*?)}}'
});

$.extend($.fn.cycle.API, {
    tmpl: function( str, opts /*, ... */) {
        var regex = new RegExp( opts.tmplRegex || $.fn.cycle.defaults.tmplRegex, 'g' );
        var args = $.makeArray( arguments );
        args.shift();
        return str.replace(regex, function(_, str) {
            var i, j, obj, prop, names = str.split('.');
            for (i=0; i < args.length; i++) {
                obj = args[i];
                if ( ! obj )
                    continue;
                if (names.length > 1) {
                    prop = obj;
                    for (j=0; j < names.length; j++) {
                        obj = prop;
                        prop = prop[ names[j] ] || str;
                    }
                } else {
                    prop = obj[str];
                }

                if ($.isFunction(prop))
                    return prop.apply(obj, args);
                if (prop !== undefined && prop !== null && prop != str)
                    return prop;
            }
            return str;
        });
    }
});    

})(jQuery);
;
(function ($) {

Drupal.googleanalytics = {};

$(document).ready(function() {

  // Attach mousedown, keyup, touchstart events to document only and catch
  // clicks on all elements.
  $(document.body).bind("mousedown keyup touchstart", function(event) {

    // Catch the closest surrounding link of a clicked element.
    $(event.target).closest("a,area").each(function() {

      // Is the clicked URL internal?
      if (Drupal.googleanalytics.isInternal(this.href)) {
        // Skip 'click' tracking, if custom tracking events are bound.
        if ($(this).is('.colorbox')) {
          // Do nothing here. The custom event will handle all tracking.
          //console.info("Click on .colorbox item has been detected.");
        }
        // Is download tracking activated and the file extension configured for download tracking?
        else if (Drupal.settings.googleanalytics.trackDownload && Drupal.googleanalytics.isDownload(this.href)) {
          // Download link clicked.
          ga("send", "event", "Downloads", Drupal.googleanalytics.getDownloadExtension(this.href).toUpperCase(), Drupal.googleanalytics.getPageUrl(this.href));
        }
        else if (Drupal.googleanalytics.isInternalSpecial(this.href)) {
          // Keep the internal URL for Google Analytics website overlay intact.
          ga("send", "pageview", { "page": Drupal.googleanalytics.getPageUrl(this.href) });
        }
      }
      else {
        if (Drupal.settings.googleanalytics.trackMailto && $(this).is("a[href^='mailto:'],area[href^='mailto:']")) {
          // Mailto link clicked.
          ga("send", "event", "Mails", "Click", this.href.substring(7));
        }
        else if (Drupal.settings.googleanalytics.trackOutbound && this.href.match(/^\w+:\/\//i)) {
          if (Drupal.settings.googleanalytics.trackDomainMode != 2 || (Drupal.settings.googleanalytics.trackDomainMode == 2 && !Drupal.googleanalytics.isCrossDomain(this.hostname, Drupal.settings.googleanalytics.trackCrossDomains))) {
            // External link clicked / No top-level cross domain clicked.
            ga("send", "event", "Outbound links", "Click", this.href);
          }
        }
      }
    });
  });

  // Track hash changes as unique pageviews, if this option has been enabled.
  if (Drupal.settings.googleanalytics.trackUrlFragments) {
    window.onhashchange = function() {
      ga('send', 'pageview', location.pathname + location.search + location.hash);
    }
  }

  // Colorbox: This event triggers when the transition has completed and the
  // newly loaded content has been revealed.
  $(document).bind("cbox_complete", function () {
    var href = $.colorbox.element().attr("href");
    if (href) {
      ga("send", "pageview", { "page": Drupal.googleanalytics.getPageUrl(href) });
    }
  });

});

/**
 * Check whether the hostname is part of the cross domains or not.
 *
 * @param string hostname
 *   The hostname of the clicked URL.
 * @param array crossDomains
 *   All cross domain hostnames as JS array.
 *
 * @return boolean
 */
Drupal.googleanalytics.isCrossDomain = function (hostname, crossDomains) {
  /**
   * jQuery < 1.6.3 bug: $.inArray crushes IE6 and Chrome if second argument is
   * `null` or `undefined`, http://bugs.jquery.com/ticket/10076,
   * https://github.com/jquery/jquery/commit/a839af034db2bd934e4d4fa6758a3fed8de74174
   *
   * @todo: Remove/Refactor in D8
   */
  if (!crossDomains) {
    return false;
  }
  else {
    return $.inArray(hostname, crossDomains) > -1 ? true : false;
  }
};

/**
 * Check whether this is a download URL or not.
 *
 * @param string url
 *   The web url to check.
 *
 * @return boolean
 */
Drupal.googleanalytics.isDownload = function (url) {
  var isDownload = new RegExp("\\.(" + Drupal.settings.googleanalytics.trackDownloadExtensions + ")([\?#].*)?$", "i");
  return isDownload.test(url);
};

/**
 * Check whether this is an absolute internal URL or not.
 *
 * @param string url
 *   The web url to check.
 *
 * @return boolean
 */
Drupal.googleanalytics.isInternal = function (url) {
  var isInternal = new RegExp("^(https?):\/\/" + window.location.host, "i");
  return isInternal.test(url);
};

/**
 * Check whether this is a special URL or not.
 *
 * URL types:
 *  - gotwo.module /go/* links.
 *
 * @param string url
 *   The web url to check.
 *
 * @return boolean
 */
Drupal.googleanalytics.isInternalSpecial = function (url) {
  var isInternalSpecial = new RegExp("(\/go\/.*)$", "i");
  return isInternalSpecial.test(url);
};

/**
 * Extract the relative internal URL from an absolute internal URL.
 *
 * Examples:
 * - http://mydomain.com/node/1 -> /node/1
 * - http://example.com/foo/bar -> http://example.com/foo/bar
 *
 * @param string url
 *   The web url to check.
 *
 * @return string
 *   Internal website URL
 */
Drupal.googleanalytics.getPageUrl = function (url) {
  var extractInternalUrl = new RegExp("^(https?):\/\/" + window.location.host, "i");
  return url.replace(extractInternalUrl, '');
};

/**
 * Extract the download file extension from the URL.
 *
 * @param string url
 *   The web url to check.
 *
 * @return string
 *   The file extension of the passed url. e.g. "zip", "txt"
 */
Drupal.googleanalytics.getDownloadExtension = function (url) {
  var extractDownloadextension = new RegExp("\\.(" + Drupal.settings.googleanalytics.trackDownloadExtensions + ")([\?#].*)?$", "i");
  var extension = extractDownloadextension.exec(url);
  return (extension === null) ? '' : extension[1];
};

})(jQuery);
;
