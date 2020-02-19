function vehicleRegister() {
    var vName = document.getElementById("vehicleName").value;
    var type = document.getElementById("vehicleType").value;
    var vehicleNum = document.getElementById("vehicleNumber").value;
    var identity = document.getElementById("identification").value;
    if (vName.length <= 2) {
    	document.getElementById('invalidVehicleName').style.color = "red";
    	document.getElementById('invalidVehicleName').innerHTML = "Insert name greater then 2 word";
        return false;
    }
    else{
    	document.getElementById("invalidVehicleName").innerHTML = "";
    }
    if (type == "none") {
    	document.getElementById('invalidType').style.color = "red";
    	document.getElementById('invalidType').innerHTML = "Select Type Of Your Vehicle";
        return false;
    }
    else{
    	document.getElementById("invalidType").innerHTML = "";
    }
    if (vehicleNum.length <= 4) {
    	document.getElementById('invalidVehicleNumber').style.color = "red";
    	document.getElementById('invalidVehicleNumber').innerHTML = "Valid Vehicle Number required";
        return false;
    } 
    else{
    	document.getElementById("invalidVehicleNumber").innerHTML = "";
    }
    if (identity.length <= 8) {
    	document.getElementById('invalidIdentity').style.color = "red";
    	document.getElementById('invalidIdentity').innerHTML = "Identity field is required";
        return false;
    }
    else{
    	document.getElementById("invalidIdentity").innerHTML = "";
    }
    return true;
}