function register()
{
	var firstname = document.getElementById("fname").value;
	var lastname = document.getElementById("lname").value;
	var fatherName = document.getElementById("father_name").value;
	var email = document.getElementById("email").value;
	var studentclass = document.getElementById("class").value;
	var studentAge = document.getElementById("age").value;
	var letters = /^[a-zA-Z]+$/;
	var classOfStudent = /(^0?[1-9]$)|(^1[0-2]$)/;
	var age = /^\d*[1-9]\d*$/;
	
	if (firstname.length <= 2 || !(letters.test(firstname))) {
        document.getElementById("fname").style.borderColor = "red";
        document.getElementById("fname").style.borderWidth = "3px";
        alert("Enter valid Name.")
        return false;
    } else {
        document.getElementById("fname").style.borderColor = "dimgray";
        document.getElementById("fname").style.borderWidth = "0.5px";
    }
	if (lastname.length <= 2 || !(letters.test(lastname))) {
        document.getElementById("lname").style.borderColor = "red";
        document.getElementById("lname").style.borderWidth = "3px";
        alert("Enter valid Name.")
        return false;
    } else {
        document.getElementById("lname").style.borderColor = "dimgray";
        document.getElementById("lname").style.borderWidth = "0.5px";
    }
	if (fatherName.length <= 2 || !(letters.test(fatherName))) {
        document.getElementById("father_name").style.borderColor = "red";
        document.getElementById("father_name").style.borderWidth = "3px";
        alert("Enter valid Name.")
        return false;
    } else {
        document.getElementById("father_name").style.borderColor = "dimgray";
        document.getElementById("father_name").style.borderWidth = "0.5px";
    }
	if (email.length < 4 || !(email.includes("@")) || !(email.includes("."))) {

        document.getElementById("email").style.borderColor = "red";
        document.getElementById("email").style.borderWidth = "3px";
        alert("Enter valid Email id.")
        return false;
    } else {
        document.getElementById("email").style.borderColor = "dimgray";
        document.getElementById("email").style.borderWidth = "0.5px";
    }
	if (!(classOfStudent.test(studentclass))) {
        document.getElementById("class").style.borderColor = "red";
        document.getElementById("class").style.borderWidth = "3px";
        alert("Enter correct Class.")
        return false;
    } else {
        document.getElementById("class").style.borderColor = "dimgray";
        document.getElementById("class").style.borderWidth = "0.5px";
    }
	if (!(age.test(studentAge))) {
        document.getElementById("age").style.borderColor = "red";
        document.getElementById("age").style.borderWidth = "3px";
        alert("Enter correct Age.")
        return false;
    } else {
        document.getElementById("age").style.borderColor = "dimgray";
        document.getElementById("age").style.borderWidth = "0.5px";
    }
	document.getElementById("fieldset1").innerHTML = "Congratulations! " + firstName + " Added Successfully.";
	return true;
}