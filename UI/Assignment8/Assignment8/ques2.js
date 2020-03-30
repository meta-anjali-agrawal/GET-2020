var i;
var flag = 0;
var stringInput = prompt("enter the input string")

for (i = 0; i < stringInput.length - 1; i++) {
    var startPosition = i;
    while (stringInput.charAt(i) == stringInput.charAt(i + 1)) {
        flag = 1;
        i++;
    }
    if (flag == 1) {
        var substring = stringInput.substr(startPosition, i - startPosition + 1);
        stringInput = stringInput.replace(substring, '');
        i = -1;
        flag = 0;
    }
}

console.log(stringInput);