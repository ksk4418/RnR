
//Disable the delete button. Enable it as long as there is at least 1 checkbox checked
$(document).ready(function () {
    // This applies only to questions of type QuestionComment
    $('.DeleteButton').attr('disabled', true);
    $('.CommentCheckBox').click(function () {
        var nbChecked = $('input:checkbox:checked').length;
        if (nbChecked > 0) {
            $('.DeleteButton').attr('disabled', false);
        }
        else {
            $('.DeleteButton').attr('disabled', true);
        }
    });

    // Replace <code>some text</code> by an image with tooltip
    $('code').each(function () {
        $(this).replaceWith('<img src="Media/ico_info_small.jpg" class="tooltip" tooltip="' + $(this).html() + '" />');
    });

    // Setup Navigation Menu 
    $('#NavigationMenu').superfish();
});

// Popup asking for confirmation about comment delete
function Confirm(question) {
    var answer = confirm(question);
//    if (answer == true) {
//        alert('true)';
//        for (i = 0; i < Page_Validators.length; i++) {
//            alert('val');
//            Page_Validators[i].enabled = false;
//        }
//    }
    return answer;
}

// Toggle Validators

// QuestionComment Validators

//Check to see if there is text in the comment text field.
//If so, enable the category dropdownlist validator
function ValidateCommentFromText(src, val) {
    var textbox = $('#' + src);
    var validator = $('#' + val)[0];

    if (textbox.val().length == 0)
        ValidatorEnable(validator, false);
    else {
        ValidatorEnable(validator, true);
    }
}

//Check to see if a category has been selected in the dropdownlist.
//If so, enable the comment text field validator
function ValidateCommentFromDropDown(ddlID, txtID, lblTextID, lblDdlID) {

    var dropdown = $('#' + ddlID);
    var textbox = $('#' + txtID);
    var lblErrorText = $('#' + lblTextID)[0];
    var lblErrorDDLCategory = $('#' + lblDdlID)[0];

    if (dropdown.prop("selectedIndex") == 0 && textbox.val().length >= 5)
    {
        lblErrorDDLCategory.style.display = 'block';
        lblErrorText.style.display = 'none';
        return false;
    }
    else if (dropdown.prop("selectedIndex") > 0)
    {
        if (textbox.val().length < 5)
        {
            lblErrorText.style.display = 'block';
            return false;
        }
        else
        {
            lblErrorDDLCategory.style.display = 'none';
            lblErrorText.style.display = 'none';
            return true;
        }
    }
    else
    {
        lblErrorDDLCategory.style.display = 'none';
        lblErrorText.style.display = 'none';
        return true;
    }
}

function ValidateAllComments(controlName, ddlName, txtName, lblTextName, lblDdlName)
{
    var valid = true;

    var i = 1;
    txtbox = document.getElementById(controlName + '_ctl0' + i + '_' + txtName);
    while (txtbox != null && valid)
    {
        prefix = controlName + '_ctl0' + i + '_';
        valid = ValidateCommentFromDropDown(prefix + ddlName, prefix + txtName, prefix + lblTextName, prefix + lblDdlName)
        i = i + 1;
        txtbox = document.getElementById(controlName + '_ctl0' + i + '_' + txtName);
    }
    return valid;
}

// END OF - QuestionComment Validators

//Toggle hide or show for groups depending on selected choice
function displayStrategicInitiativeGroup(DataControlName, GroupName, rblControlName, choiceIndex, questionThreshold, targetClientID, validatorID, lblWarningID) {
    var element = $('#' + targetClientID);
    //var validator = $('#' + validatorID)[0];
    var rbl = $('#' + targetClientID).find('input:radio');
    var i=0;
    var hide_lblWarningID = false;

    rblTemp = document.getElementById(DataControlName + '_ctl0' + i + '_' + GroupName + '_ctl00_' + rblControlName);
    while (rblTemp != null && !hide_lblWarningID) {
        var inputs = rblTemp.getElementsByTagName("input");
        var selected;
        for (var j = 0; j < inputs.length; j++) {
            if (inputs[j].checked && j >= questionThreshold) {
                hide_lblWarningID = true;
                break;
            }
        }
        i = i + 1;
        rblTemp = document.getElementById(DataControlName + '_ctl0' + i + '_' + GroupName + '_ctl00_' + rblControlName);
    }


    if (choiceIndex >= questionThreshold) {
        rbl.removeAttr('checked');
        //element.css("visibility", "visible");
        document.getElementById(targetClientID).style.display = 'block';
        if (hide_lblWarningID) {
            document.getElementById(lblWarningID).style.display = 'none';
        }
        //ValidatorEnable(validator, true);

    }
    else {
        //element.css("visibility", "hidden");
        document.getElementById(targetClientID).style.display = 'none';
        if (!hide_lblWarningID) {
            document.getElementById(lblWarningID).style.display = 'block';
        }
        //ValidatorEnable(validator, false);
    }
}

//Deselects every radio button in a RadioButtonList
function ResetRadioButtonListSelection(targetClientID) {
    var rbl = $('#' + targetClientID).find('input:radio');
    rbl.removeAttr('checked');
}

//Blanks all texts fields contained in a repeater
function ResetTextBoxes(DataControlName, childTextBoxName)
{
    var i = 1;

    txtbox = document.getElementById(DataControlName + '_ctl0' + i + '_' + childTextBoxName);
    while (txtbox != null) {
        txtbox.value = '';
        if (i > 1)
        {
            txtbox.disabled = true;
        }
        i = i + 1;
        txtbox = document.getElementById(DataControlName + '_ctl0' + i + '_' + childTextBoxName);
    }
}

//Blanks text field
function ResetTextBox(DataControlName)
{
    txtbox = document.getElementById(DataControlName);
    if (txtbox != null)
    {
        txtbox.value = '';
    }
}

// Code for tooltips
$(document).ready(function () {
    var offsetY = -20;
    var offsetX = 40;

    $('img.tooltip').hover(function (e) {
        
        // Begin mouseover function
        var text = $(this).attr('tooltip');

        // Create a variable that will hold the HTML for the pop up.
        var html = '<div id="info">';
        html += '<p>' + text + '</p>';
        html += '</div>';

        // Append the variable to the body and the select itself and its children and hide them, so you
        // can then add a fadeIn effect.
        $('body')
                    .append(html)
                    .children('#info')
                    .hide()
                    .fadeIn(400);

        // This is where the popup offesets away from your cursor. The variables set up top will decide 
        //how far away the pop up strays away from your cursor.
        $('#info')
                .css('top', e.pageY + offsetY)
                .css('left', e.pageX + offsetX);

    },
            function () {
                // Begin mouseout function

                // Remove on mouse out
                $('#info').remove();
            });

    // Whenever the mouse moves the popup will follow using the offsets set up top.
    $('img.tooltip').mousemove(function (e) {
        $('#info')
                .css('top', e.pageY + offsetY)
                .css('left', e.pageX + offsetX);
    });
});
function doKeypress(control, targetClientID) {
    maxLength = control.attributes["maxLength"].value;
    value = control.value;
    if (maxLength && value.length > maxLength - 1) {
        event.returnValue = false;
        maxLength = parseInt(maxLength);
    }
    if (value.length > 0) {
        var tbFreeText = document.getElementById(targetClientID);
        if (tbFreeText != null)
            tbFreeText.disabled = false;
    }
}

// Cancel default behavior
function doBeforePaste(control) {
    maxLength = control.attributes["maxLength"].value;
    if (maxLength) {
        event.returnValue = false;
    }
}

// Cancel default behavior and create a new paste routine
function doPaste(control) {
    maxLength = control.attributes["maxLength"].value;
    value = control.value;
    if (maxLength) {
        event.returnValue = false;
        maxLength = parseInt(maxLength);
        var oTR = control.document.selection.createRange();
        var iInsertLength = maxLength - value.length + oTR.text.length;
        var sData = window.clipboardData.getData("Text").substr(0, iInsertLength);
        oTR.text = sData;
    }
}

// Slider Helper functions
// Initial values of checkboxes
function InitCheckboxStates(index) {
    //var nbCheckboxes = $(".chkboxDontKnowClass").length;///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //for (index = 0; index < nbCheckboxes; index++) {
    //   checkboxState[index] = document.getElementById(GetCheckboxID(index)).checked;///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //}
}

// Move checkbox states in global var 
function ResetCheckboxStates() {
    var nbCheckboxes = $(".chkboxDontKnowClass").length;
    for (index = 0; index < nbCheckboxes; index++) {
        checkboxState[index] = document.getElementById(GetCheckboxID(index)).checked;
    }
}

// Careful, this resets the global var to the present state of the checkboxes
function GetFocusedCheckboxIndex() {
    var index = 0;
    for (index = 0; index < checkboxState.length; index++) {
        if (document.activeElement == document.getElementById(GetCheckboxID(index))) {
            break;
        }
    }

    ResetCheckboxStates();
    return index;
}

function GetCheckboxID(index) {
    var checkboxID = "ctl00_ContentPlaceHolder1_Question_qqqqq_rptQuestions_ctl00_chkboxDontKnow";
    var questionID = $(".chkboxDontKnowClass:eq(" + index + ")").attr("QuestionId");
    var firstReplace = checkboxID.replace("qqqqq", questionID);
    return firstReplace;
}

function GetFocusedSliderSelector() {
    var index = GetFocusedSliderIndex();
    return ".range-slider:eq(" + index + ")";
}

function GetFocusedSliderIndex() {
    for (var index = 0; index < $currentSlider.length; index++) {
        if ($(".range-slider:eq(" + index + ") .ui-state-focus").length)
            break;
    }

    return index;
}

function FlipSliderState(checkbox) {
    sleep(100)
    var Div = $(checkbox).closest("td").prev("td").find(".range-slider")
    var IsActive = Div.find(".DivIsSliderEnabled input[type=hidden]");
    var SliderChanged = Div.find(".DivWasSliderChanged input[type=hidden]");

    if (IsActive.val() == "true")
    {
        IsActive.val("false");
        Div.slider("disable");
    }
    else if (IsActive.val() == "false")
    {
        
        IsActive.val("true");
        Div.slider("enable");
    }
}

function EnableSlider(index) {
    var isSliderEnabled = $(".DivIsSliderEnabled:eq(" + index + ") input[type=hidden]").val();
    if (isSliderEnabled == "true") {
        $(".range-slider:eq(" + index + ")").slider("enable");
    }
    else {
        $(".range-slider:eq(" + index + ")").slider("disable");
    }
}

function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > milliseconds) {
            break;
        }
    }
}


function ValidateSlider(source, arguments) {
    var Div = $("#" + source.id).closest("tr").next("tr").find("td.QuestionData");
    var DivQuestionError = $("#" + source.id).closest("tr").parent().find('[id*=ScaleHeaderRow]').find("td.ErrorLabel").find("span");
    var DivSubQuestionError = $("#" + source.id).closest("tr").next("tr").find("td.QuestionNumber").find(".ErrorLabel");

    if ((Div.find(".DivIsSliderEnabled input[type=hidden]").val() == "true")
        && (Div.find(".DivWasSliderChanged input[type=hidden]").val() == "false")
        && (Div.find(".DivSliderHidden input[type=hidden]").val() == "false")) {

        DivSubQuestionError.css("display", "block");
        DivSubQuestionError.css("visibility", "visible");
        arguments.IsValid = false;
    }
    else {
        DivSubQuestionError.css("display", "none");
        DivSubQuestionError.css("visibility", "hidden");
        arguments.IsValid = true;
    }
    
    
    
    //if one slider is not valid display top error label
    var OnError = false;
    var sliders = $("#" + source.id).closest("tr").parent().find('.range-slider');
    for (var i = 0; i < sliders.length; i++) {
        if (($(sliders[i]).find(".DivIsSliderEnabled input[type=hidden]").val() == "true")
            && ($(sliders[i]).find(".DivWasSliderChanged input[type=hidden]").val() == "false")
            && (Div.find(".DivSliderHidden input[type=hidden]").val() == "false")) {
            OnError = true;
        }
    }

    if (OnError) {
        DivQuestionError.css("visibility", "visible");
        DivQuestionError.css("display", "block");
    }
    else {
        DivQuestionError.css("display", "none");
        DivQuestionError.css("visibility", "hidden");
    }

    return arguments.IsValid;
}

function GetErrorLabelID(index) {
}

//Deselects every radio button in a RadioButtonList
function ResetDisableSlider(targetClientID) {
    var sliderEnabled = $('#' + targetClientID).find('.DivIsSliderEnabled input[type=hidden]');
    sliderEnabled.val(false);
    var divSlider = $('#' + targetClientID).find('.DivSliderHidden input[type=hidden]');
    divSlider.val(true);
}
function ResetEnableSlider(targetClientID) {
    var sliderEnabled = $('#' + targetClientID).find('.DivIsSliderEnabled input[type=hidden]');
    sliderEnabled.val(true);
    var divSlider = $('#' + targetClientID).find('.DivSliderHidden input[type=hidden]');
    divSlider.val(false);
}


function doKeypressValidLength(control, targetClientID) {
        maxLength = control.attributes["maxLength"].value;
        value = control.value;
        if (maxLength && value.length > maxLength - 1) {
            event.returnValue = false;
            maxLength = parseInt(maxLength);
        }
    }

    function onChangetxtClient(controlID, currentID) {
        //detect change line
        var hfIsChanged = $('[id=' + controlID + currentID + '_hfCompanyIsChanged]');
        hfIsChanged.val(true);
    }

    function onChangeTxtCountry(controlID, currentID) {
        //detect change line
        var hfIsChanged = $('[id=' + controlID + currentID + '_hfCountryIsChanged]');
        hfIsChanged.val(true);
    }

    function ClientItemSelected(sender, e) {
        var hfID = $(sender._element.parentElement).find('[id*=hfCountryID]')
        var hfIsSelected = $(sender._element.parentElement).find('[id*=hfIsItemSelected]')
        //hiddenField.Value = e.get_value();
        if (hfID != null) {
            $(hfID).val(e.get_value());
            $(hfIsSelected).val(true);
        }
    }

   