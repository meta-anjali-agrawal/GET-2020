function checkPasswordValidation() {
	var password = document.getElementById('Password').value;
	var confirmPassword = document.getElementById('ConfirmPassword').value;
	var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	if (password.length <= 8 || !filterPassword.test(password)) {
		document.getElementById('invalidPassword').style.color = 'red';
		document.getElementById('invalidPassword').innerHTML = 'Contains Uppercase, Lowercase Numeric, Alphanumeric, 8 character';
		document.getElementById("Submit").disabled = true;
	} else {
		document.getElementById('invalidPassword').innerHTML = '';
		document.getElementById("Submit").disabled = false;
	}
}

function checkPasswordEqual() {
	var password = document.getElementById('Password').value;
	var confirmPassword = document.getElementById('ConfirmPassword').value;
	var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
	if (password.length >= 8 || filterPassword.test(password)) {
		if (password == confirmPassword) {
			document.getElementById("ConfirmPassword").style.borderColor = "#ccc";
			document.getElementById("Submit").disabled = false;
		} else {
			document.getElementById("ConfirmPassword").style.outline = "none";
			document.getElementById("ConfirmPassword").style.borderColor = "red";
			document.getElementById("Submit").disabled = true;
		}
	}
	else{
		document.getElementById("Submit").disabled = true;
	}
}
