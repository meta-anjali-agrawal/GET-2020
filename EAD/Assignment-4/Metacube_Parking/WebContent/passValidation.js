function changeCurrency(){
    var sign = document.getElementsByClassName('sign');
    for (var i = 0; i < sign.length; i++) {
        sign[i].innerText = document.getElementById('price').value
    }
    var type = document.getElementById("vehicleType").value;
    var money = document.getElementById(type).querySelectorAll('.money');
    var x = document.getElementById(type).querySelectorAll(".p");
    switch (document.getElementById('price').value) {
        case "USD":
            for (var i = 0; i < money.length; i++) {
            	var number = parseInt(x[i].value, 10);
                money[i].innerText = number;
            }
            break;
        case "YEN":
            for (var i = 0; i < money.length; i++) {
            	var number = parseInt(x[i].value, 10);
                money[i].innerText = number * 109.69;
            }
            break;
        case "INR":
            for (var i = 0; i < money.length; i++) {
            	var number = parseInt(x[i].value, 10);
                money[i].innerText = number * 71.30;
            }
            break;
    }
}
function takeGetPass() {
    var checkvlaueSelect = 0;
    var type = document.getElementById("vehicleType").value;
    var x = document.getElementById(type).querySelectorAll(".p");
    for (var i = 0; i < x.length; i++) {
        if (x[i].checked == true) {
            checkvlaueSelect = 1;
        }
    }
    if (checkvlaueSelect == 0) {
        document.getElementById("error-message").innerHTML = "Select Price";
        return false;
    }
    return true;
}