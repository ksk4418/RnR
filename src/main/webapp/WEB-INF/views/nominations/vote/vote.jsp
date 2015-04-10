<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<SCRIPT type="text/javascript" src=<c:url value ="/resources/vote/jquery-1.9.0.js" />></SCRIPT>

<SCRIPT type="text/javascript" src=<c:url value ="/resources/vote/jquery-ui.min.js" />></SCRIPT>
<SCRIPT type="text/javascript" src=<c:url value ="/resources/vote/jquery-ui-slider-pips.min.js" />></SCRIPT>
<LINK id="ctl00_ctl02" rel="stylesheet" type="text/css" href=<c:url value ="/resources/vote/jquery-ui.css" />>
<LINK id="ctl00_ctl05" rel="stylesheet" type="text/css" href=<c:url value ="/resources/vote/jquery-ui-slider-pips.css"/>>
<LINK id="ctl00_ctl07" rel="stylesheet" type="text/css" href=<c:url value ="/resources/vote/main2.css" />>

<LINK rel="stylesheet" type="text/css" href=<c:url value ="/resources/vote/sp_2015_v2.css" />>
      <DIV class="sliders-cont" align="right">
      <DIV id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_slider211" 
      class="range-slider">
      <DIV id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_ctl00" 
      class="DivSliderValue"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_SliderValue" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$SliderValue" 
      type="hidden"></DIV>
      <DIV class="DivSliderMinValue"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_SliderMinValue" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$SliderMinValue" 
      value="1" type="hidden"></DIV>
      <DIV class="DivSliderMaxValue"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_SliderMaxValue" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$SliderMaxValue" 
      value="10" type="hidden"></DIV>

      <DIV class="DivIsSliderEnabled"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_IsSliderEnabled" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$IsSliderEnabled" 
      value="true" type="hidden"></DIV>
      <DIV class="DivWasSliderChanged"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_WasSliderChanged" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$WasSliderChanged" 
      value="false" type="hidden"></DIV>
      <DIV class="DivSliderHidden"><INPUT id="ctl00_ContentPlaceHolder1_Question_75502_rptQuestions_ctl00_SliderHidden" 
      name="ctl00$ContentPlaceHolder1$Question_75502$rptQuestions$ctl00$SliderHidden" 
      value="false" type="hidden"></DIV>
<SCRIPT type="text/javascript">

                                                var checkboxState = [];

                                                // Setting range and step of slider
                                                var index = $(".range-slider").slider().length - 1;
                                                var minVal = $('.DivSliderMinValue:eq(' + index + ') input[type=hidden]').val();
                                                var maxVal = $('.DivSliderMaxValue:eq(' + index + ') input[type=hidden]').val();

                                                var $currentSlider = $('.range-slider:eq(' + index + ')').slider({ step: 1, min: 1, max: maxVal });
                                                // var index = $currentSlider.length - 1;

                                                var selector = ".range-slider:eq(" + index + ")";

                                                // Setting as a pips slider
                                                $(selector).slider("pips",
                                                {
                                                    rest: "label",
                                                    change: function (event, ui) {alert("KSK"); }
                                                });

                                                var val = $(".DivSliderValue:eq(" + index + ") input[type=hidden]").val();
                                                // Setting value of slider
                                                if (parseInt(val) >= parseInt(minVal) && parseInt(val) <= parseInt(maxVal)) {
                                                    val = Math.round(val);
                                                    $(selector).slider({ value: val });
                                                    $(selector).find("a").addClass("waschanged");
                                                    $(selector).find(".DivSliderValue input[type=hidden]").val(val);
                                                    $(selector).find(".ui-slider-pip-" + val.toString()).find(".ui-slider-label").addClass("InitColor");
                                                }
                                               

                                                EnableSlider(index);

                                                $currentSlider.on("slidechange", function (event, ui) {
                                                    val = $(this).slider("option", "value");
                                                    val = Math.round(val);
                                                    $(this).find(".DivSliderValue input[type=hidden]").val(val);
                                                    $(this).find(".DivWasSliderChanged input[type=hidden]").val("true");
                                                    $(this).find(".InitColor").removeClass("InitColor");
                                                    $(this).find(".ui-slider-pip-" + val.toString()).find(".ui-slider-label").addClass("InitColor");
                                                    $(this).find("a").addClass("waschanged");
                                                });

                                            </SCRIPT>
      </DIV></DIV>

