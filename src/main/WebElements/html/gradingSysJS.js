function addClass() {
let valueOne =  document.getElementById("inputOne").value;
let valueTwo =  document.getElementById("inputTwo").value;
let valueThree =  document.getElementById("inputThree").value;

//displays class
let overall = valueOne + " | " + valueTwo + " | " + valueThree;

    document.getElementById("displayClass").innerText = overall;

    //outputs an error if not every box is filled.


console.log(valueOne + valueTwo + valueThree);

}


