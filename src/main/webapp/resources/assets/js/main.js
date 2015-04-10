/*!
 * Rewards and Recognition portal 
 * Copyright 2014 CGI Group, Inc.(http://cgi.com/en)
 * Author: 
 */
 // Added by 25-Mar-2015---footer position 

	// console.log("yes");
	 $(document).ready(function(){
		adjustFooter()
	  });
	 
	$(window).resize(function(){
		adjustFooter();
	}); 

	function adjustFooter(){
		var hContent = $(document).height();
		var hWindow = $(window).height();
		if(hContent>hWindow) {
			$('.cgi-rnr-footer').css('position','relative');
			$('.cgi-rnr-footer').css('bottom','auto');
		}
		else{
			$('.cgi-rnr-footer').css('position','fixed');
			$('.cgi-rnr-footer').css('bottom','0');
		}
	}
 $(function(){
	/*$('.cgr-rnr-awardSelect').on('change',function () {
		alert('as');
		//window.open(this.options[this.selectedIndex].value,'_top')
	});*/
 	$('.cgi-rnr-gallery-thumbnail').on({
		mouseover: function(){
			$(this).find('.cgi-rnr-gallery-hover-content').show();
			$(this).find("span").removeClass( "cgi-rnr-gallery-overlay" ).addClass( "cgi-rnr-gallery-overlayNone" );
 		},
 		mouseout: function(){
 			$(this).find('.cgi-rnr-gallery-hover-content').hide();
			$(this).find("span").removeClass( "cgi-rnr-gallery-overlayNone" ).addClass( "cgi-rnr-gallery-overlay" );
		}
 	});
	$('a.internal[href^="#"]').on('click',function (e) {
	    e.preventDefault();

	    var target = this.hash,
	    $target = $(target);

	    $('html, body').stop().animate({
	        'scrollTop': $target.offset().top
	    }, 900, 'swing', function () {
	        $('.cgi-rnr-golbalNav').find('a').attr('tabindex','-1');
	    });
	});
	// Main Menu Script - On Hover Functionality
	$( ".cgi-rnr-golbalNav ul li.has-sub-menu" ).mouseenter(
		function(e) {
			e.preventDefault();
			$(this).find('ul.sub-menu').dequeue().stop().slideDown();
			$(this).children('a').toggleClass('active');
			if($(this).find('img').attr('src') == "assets/images/drop-down.png"){
				$(this).find('img').attr('src','assets/images/drop-down-active.png');
			}
			else if($(this).find('img').attr('src') == "assets/images/drop-down-active.png"){
				$(this).find('img').attr('src','assets/images/drop-down.png');
			}
			
		}
	);
	
	$( ".cgi-rnr-golbalNav ul li.has-sub-menu" ).mouseleave(
		function() {
			$(this).find('ul.sub-menu').dequeue().stop().slideUp();
			$(this).children('a').toggleClass('active');
			if($(this).find('img').attr('src') == "assets/images/drop-down.png"){
				$(this).find('img').attr('src','assets/images/drop-down-active.png');
			}
			else if($(this).find('img').attr('src') == "assets/images/drop-down-active.png"){
				$(this).find('img').attr('src','assets/images/drop-down.png');
			}
		}
	);
	$( ".cgi-rnr-golbalNav ul li a.active" ).click(function (event){
		event.preventDefault();
	});
	
	// Exapnd-Collapse Image Script
	$('.panel-collapse').on('hidden.bs.collapse', function () {
		$(this).parents('.panel')
		.find('.panel-title > span:last-child')
		.addClass('cgi-rnr-arrow-up')
		.removeClass('cgi-rnr-arrow-down');
	});
	$('.panel-collapse').on('shown.bs.collapse', function () {
		$(this).parents('.panel')
		.find('.panel-title > span:last-child')
		.addClass('cgi-rnr-arrow-down')
		.removeClass('cgi-rnr-arrow-up');
	});
	
	// Select dropdown list
	$('.select').find('li').click(function(){
		var elmtxt = $(this).text();
		$('#labelselect').text(elmtxt);
	});
});


	


