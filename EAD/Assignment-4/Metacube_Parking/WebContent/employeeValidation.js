function employeeRegistration() {
	var name = document.getElementById("FullName").value;
	var email = document.getElementById("Email").value;
	var contact = document.getElementById("Contact").value;
	var filterName = new RegExp('\\d');
	if (name.length <= 2) {
		document.getElementById('invalidName').style.color = "red";
    	document.getElementById('invalidName').innerHTML = "Insert name greater than 2 character";
        return false;
	} else if (filterName.test(name)) {
		document.getElementById('invalidName').style.color = "red";
    	document.getElementById('invalidName').innerHTML = "Numeric value not allowed";
        return false;
	} else {
		document.getElementById("invalidName").innerHTML = "";
	}
	var filterEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (email == "") {
		document.getElementById('invalidEmail').style.color = "red";
    	document.getElementById('invalidEmail').innerHTML = "Insert a email id";
        return false;
	}
	if (!filterEmail.test(email)) {
		document.getElementById('invalidEmail').style.color = "red";
    	document.getElementById('invalidEmail').innerHTML = "Insert a Valid Email";
        return false;
	} else {
		document.getElementById("invalidEmail").innerHTML = "";
	}
	var filterContact = new RegExp('([a-zA-Z!@#$%^&*()_+])');
	
	if (!(contact.length <= 10 && contact.length >= 8)) {
		document.getElementById('invalidContact').style.color = "red";
    	document.getElementById('invalidContact').innerHTML = "Insert Number Between 8 to 10";
        return false;
	} else if (filterContact.test(contact)) {
		document.getElementById('invalidContact').style.color = "red";
    	document.getElementById('invalidContact').innerHTML = "Numeric value only allowed";
        return false;
	} else {
		document.getElementById("invalidContact").innerHTML = "";
	}
	return true;
}
