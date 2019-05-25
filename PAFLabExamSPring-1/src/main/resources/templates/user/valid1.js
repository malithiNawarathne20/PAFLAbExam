$(document).on("click", "#btnsubmit", function()
{

var result = isValidFormLogin(); // use client-Model
if (result == "true")
 {
	$("#formLogin").serialize(),
 }

else
 {
 $("#divStsMsgLogin").html(result);
 }
});

function isValidFormLogin()
{
if($.trim($('#name').val())=="")
	{
	return "Enter name";
	}

if(($.trim($('#mobile').val())==""))
	{
	return "Enter phone number";
	}

	
}