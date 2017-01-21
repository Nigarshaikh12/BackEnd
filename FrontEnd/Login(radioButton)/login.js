

var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if (( username == "AmitSingh" && password == "9823@amit")||(username == "PurvaNiket" && password == "purva#1234")||(username == "OmPuranik" && password == "om&777")){
alert ("LOGIN SUCCESSFULL !!!");
window.location = "test2.html"; // Redirecting to other page.
return false;
}
else{
alert("Login FAILED !!!");
attempt --;// Decrementing by one.
alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
if( attempt == 0){
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
}
}
}

