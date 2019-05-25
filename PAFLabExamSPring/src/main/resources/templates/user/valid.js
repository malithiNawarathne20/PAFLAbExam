$(document).on("click", "#btnsubmit", function()
{
 $("#divStsMsgLogin").html("");
var result = isValidFormLogin(); // use client-Model
if (result == "true")
 {
 $.ajax(
 {
 type : "post",
 url : "UserLogin",
 data : $("#formLogin").serialize(),
 complete : function(response, status)
 {
 onLogingComplete(response.responseText, status);
 }
 });
 }
else
 {
 $("#divStsMsgLogin").html(result);
 }
});
function onLogingComplete(response, status)
{
if (status == "success")
 {
 if (response == "SUCCESS")
 {
 document.location = "next.jsp";
 }
 else
 {
 $("#divStsMsgLogin").html(response);
 }
 }
else if (status == "error")
 {
 $("#divStsMsgLogin").html("Error while authenticating");
 }
else
 {
 $("#divStsMsgLogin").html("Unknown error while authenticating");
 }
}