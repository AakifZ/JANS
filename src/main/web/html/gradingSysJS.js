function addClass(inputString) {
const valueOne =  document.getElementById("inputOne").value;
const valueTwo =  document.getElementById("inputTwo").value;
const valueThree =  document.getElementById("inputThree").value;

const overall = valueOne + " | " + valueTwo + " | " + valueThree;



if(inputString == null) {
    document.getElementById("displayClass").innerText = "Make sure all fields are entered.";
} else {
    document.getElementById("displayClass").innerText = overall;
}


console.log(valueOne + valueTwo + valueThree);

}


