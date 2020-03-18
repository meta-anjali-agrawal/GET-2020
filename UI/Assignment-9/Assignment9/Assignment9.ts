var employeeId :number = 0;
var vehicleType : string;
var inputField : string = "fname";
var fname : string;
var currency : string = "inr";

function empRegister() {

    switch (inputField) {

        case "fname":
            fname = (<HTMLInputElement>document.getElementById("fname")).value;
            if (validations()) {
                inputField = "empGender";
            } else {
                return false;
            }
            document.getElementById("messages").innerText = "Hi " + fname + ". May I know your gender?";
            document.getElementById("fname").style.display = "none";
            document.getElementById("empGender").style.display = "block";
            break;

        case "empGender":
            if (validations()) {
                inputField = "empEmail";
            } else {
                return false;
            }
            document.getElementById("messages").innerText = "Hi " + fname + ". May I know your E-mail?";
            document.getElementById("empGender").style.display = "none";
            document.getElementById("empMail").style.display = "block";
            break;

        case "empEmail":
            if (validations()) {
                inputField = "empPassword";
            } else {
                return false;
            }
            document.getElementById("messages").innerText = "Hi " + fname + ". May I know your Password?";
            document.getElementById("empMail").style.display = "none";
            document.getElementById("Password").style.display = "block";
            break;

        case "empPassword":
            if (validations()) {
                inputField = "confirmPassword";
            } else {
                return false;
            }
            document.getElementById("messages").innerText = "Hi " + fname + ". Retype your Password";
            document.getElementById("Password").style.display = "none";
            document.getElementById("empConfirmPassword").style.display = "block";
            break;

        case "confirmPassword":
            if (validations()) {
                inputField = "empPhoneNumber";
            } else {
                return false;
            }
            document.getElementById("messages").innerText = "Hi " + fname + ". May I know your Phone Number?";
            document.getElementById("empConfirmPassword").style.display = "none";
            document.getElementById("empNumber").style.display = "block";
            break;

        case "empPhoneNumber":
            if (validations()) {
                inputField = "vehicleName";
                employeeId++;
            } else {
                return false;
            }
            document.getElementById("fieldset1").innerHTML = "Thanks! " + name + " for registration. Your Employee Id is M20/" + employeeId;
            (<HTMLInputElement>document.getElementById("employeeId")).value = "M20/ " + employeeId;
            document.getElementById("fieldset2").style.display = "block";
            break;


    }

}

function passwordValidation() {
    var password = (<HTMLInputElement>document.getElementById("empPassword")).value;
    var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");

    if (password.match(strongRegex)) {
        document.getElementById("empPassword").style.borderColor = "green";
        document.getElementById("empPassword").style.borderWidth = "3px";
    } else if (password.match(mediumRegex)) {
        document.getElementById("empPassword").style.borderColor = "orange";
        document.getElementById("empPassword").style.borderWidth = "3px";
    } else {
        document.getElementById("empPassword").style.borderColor = "red";
        document.getElementById("empPassword").style.borderWidth = "3px";
    }
}

function validations() {

    switch (inputField) {

        case "fname":
            var name = (<HTMLInputElement>document.getElementById("fname")).value;
            var letters = /^[a-zA-Z]+ [a-zA-Z]+$/;
            if (name.length <= 2 || !(letters.test(name))) {

                document.getElementById("fname").style.borderColor = "red";
                document.getElementById("fname").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("fname").style.borderColor = "dimgray";
                document.getElementById("fname").style.borderWidth = "0.5px";
                return true;
            }
            break;

        case "empGender":
            if (!(<HTMLInputElement>document.getElementById("Male")).checked && !(<HTMLInputElement>document.getElementById("Female")).checked && !(<HTMLInputElement>document.getElementById("Other")).checked) {
                alert("Select an option");
                return false;
            } else {
                return true;
            }
            break;

        case "empEmail":
            // email.length < 4 || !(email.includes("@"))
            var email = (<HTMLInputElement>document.getElementById("empEmail")).value;
            var mailRegex = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}/;
            if (!(email.match(mailRegex))) {

                document.getElementById("empEmail").style.borderColor = "red";
                document.getElementById("empEmail").style.borderWidth = "3px";
                alert("Enter valid Email id.")
                return false;
            } else {
                document.getElementById("empEmail").style.borderColor = "dimgray";
                document.getElementById("empEmail").style.borderWidth = "0.5px";
            }
            break;

        case "empPassword":
            var password = (<HTMLInputElement>document.getElementById("empPassword")).value;
            var regexPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,}$/;
            if (!(password.match(regexPassword))) {
                document.getElementById("empPassword").style.borderColor = "red";
                document.getElementById("empPassword").style.borderWidth = "3px";
                alert("Enter a password with atleast one lowercase character, one uppercase character, one alphanumeric character and minimum length of 8.")
                return false;
            } else {
                document.getElementById("empPassword").style.borderColor = "dimgray";
                document.getElementById("empPassword").style.borderWidth = "0.5px";
            }
            break;

        case "confirmPassword":
            var password = (<HTMLInputElement>document.getElementById("empPassword")).value;
            var confirmPassword = (<HTMLInputElement>document.getElementById("confirmPassword")).value;
            if (password != confirmPassword) {
                alert("passwords do not match");
                document.getElementById("confirmPassword").style.borderColor = "red";
                document.getElementById("confirmPassword").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("confirmPassword").style.borderColor = "dimgray";
                document.getElementById("confirmPassword").style.borderWidth = "0.5px";
            }
            break;

        case "empPhoneNumber":
            var phoneNumber = (<HTMLInputElement>document.getElementById("empPhoneNumber")).value;
            var numbers = /^[+]?[0-9]+$/;
            if (phoneNumber.length < 8 || !(phoneNumber.match(numbers))) {
                document.getElementById("empPhoneNumber").style.borderColor = "red";
                document.getElementById("empPhoneNumber").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("empPhoneNumber").style.borderColor = "dimgray";
                document.getElementById("empPhoneNumber").style.borderWidth = "0.5px";
            }
            break;

        case "vehicleName":
            var name = (<HTMLInputElement>document.getElementById("vehicleName")).value;
            if (name.length <= 2) {
                document.getElementById("vehicleName").style.borderColor = "red";
                document.getElementById("vehicleName").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("vehicleName").style.borderColor = "dimgray";
                document.getElementById("vehicleName").style.borderWidth = "0.5px";
                return true;
            }
            break;

        case "vehicleType":
            var type = (<HTMLInputElement>document.getElementById("type")).value;
            if (type != "Cycle" && type != "MotorCycle" && type != "Four Wheelers") {
                alert("Select an option");
                return false;
            } else {
                return true;
            }
            break;

        case "vehicleNumber":
            var number = (<HTMLInputElement>document.getElementById("vehicleNumber")).value;
            if (number.length <= 4) {
                document.getElementById("vehicleNumber").style.borderColor = "red";
                document.getElementById("vehicleNumber").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("vehicleNumber").style.borderColor = "dimgray";
                document.getElementById("vehicleNumber").style.borderWidth = "0.5px";
                return true;
            }
            break;

        case "identification":
            var identity = (<HTMLInputElement>document.getElementById("identification")).value;
            if (identity.length <= 10) {
                document.getElementById("identification").style.borderColor = "red";
                document.getElementById("identification").style.borderWidth = "3px";
                return false;
            } else {
                document.getElementById("identification").style.borderColor = "dimgray";
                document.getElementById("identification").style.borderWidth = "0.5px";
                return true;
            }
            break;

        default:
            break;

    }

    return true;
}

function vehicleRegister() {

    switch (inputField) {

        case "vehicleName":
            if (validations()) {
                inputField = "vehicleType";
            } else {
                return false;
            }
            document.getElementById("vehicleMessages").innerText = "Hi " + fname + ". May I know your Vehicle Type?";
            document.getElementById("vehicleName").style.display = "none";
            document.getElementById("vehicleType").style.display = "block";
            break;

        case "vehicleType":
            if (validations()) {
                inputField = "vehicleNumber";
            } else {
                return false;
            }
            document.getElementById("vehicleMessages").innerText = "Hi " + fname + ". May I know your Vehicle Number?";
            document.getElementById("vehicleType").style.display = "none";
            document.getElementById("vNumber").style.display = "block";
            break;

        case "vehicleNumber":
            if (validations()) {
                inputField = "identification";
            } else {
                return false;
            }
            document.getElementById("vehicleMessages").innerText = "Hi " + fname + ". Enter your vehicle identification";
            document.getElementById("vNumber").style.display = "none";
            document.getElementById("identity").style.display = "block";
            break;

        case "identification":
            if (validations()) {
                inputField = "identification";
            } else {
                return false;
            }
            vehicleType = (<HTMLInputElement>document.getElementById("type")).value;
            var vehicleNumber = (<HTMLInputElement>document.getElementById("vehicleNumber")).value;
            document.getElementById("fieldset2").innerHTML = "Vehicle number " + vehicleNumber + " registered successfully.";
            document.getElementById("fieldset3").style.display = "block";
            displayChargers(currency);
            break;
    }

    // vehicleType = document.getElementById("type").value;
    // var vehicleNumber = document.getElementById("vehicleNumber").value;
    // document.getElementById("fieldset2").innerHTML = "Vehicle number " + vehicleNumber + " registered successfully.";
    // document.getElementById("fieldset3").style.display = "block";
    // displayChargers();
}

function displayChargers(currency) {
    var factor = 1;

    if (currency == "inr") {
        factor = 1;
    } else if (currency == "usd") {
        factor = 0.014;
    } else if (currency == "yen") {
        factor = 0.65;
    }

    if (vehicleType == "Cycle") {
        (<HTMLInputElement>document.getElementById("daily")).value = (5 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("monthly")).value = (100 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("yearly")).value = (500 * factor).toFixed(2);
    } else if (vehicleType == "MotorCycle") {
        (<HTMLInputElement>document.getElementById("daily")).value = (10 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("monthly")).value = (200 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("yearly")).value = (1000 * factor).toFixed(2);

    } else if (vehicleType == "Four Wheelers") {
        (<HTMLInputElement>document.getElementById("daily")).value = (20 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("monthly")).value = (500 * factor).toFixed(2);
        (<HTMLInputElement>document.getElementById("yearly")).value = (3500 * factor).toFixed(2);

    }
}

function getPass() {
    var pass;
    if ((<HTMLInputElement>document.getElementById('daily_r')).checked) {
        pass = (<HTMLInputElement>document.getElementById("daily")).value;
    } else if ((<HTMLInputElement>document.getElementById('monthly_r')).checked) {
        pass = (<HTMLInputElement>document.getElementById("monthly")).value;
    } else if ((<HTMLInputElement>document.getElementById('yearly_r')).checked) {
        pass = (<HTMLInputElement>document.getElementById("yearly")).value;
    }
    document.getElementById("fieldset3").innerHTML = "Pay: " + pass;
}