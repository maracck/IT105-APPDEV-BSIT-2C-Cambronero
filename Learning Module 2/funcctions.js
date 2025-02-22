function twoNums(){
    let num1 = prompt("Enter First Number: ");
    let num2 = prompt("Enter Second Number: ");

    var sum = parseInt(num1) + parseInt(num2);
    
    if((!isNaN(num1) || !isNaN(num2)) && (num1!== "" && num2!== "") && (num1 !== null || num2 !== null)) {
        console.log("Correct data!")
        document.getElementById("firstNum").innerHTML = "The First Number = " + num1;
        document.getElementById("secondNum").innerHTML = "The Second Number = " + num2;
        document.getElementById("sum").innerHTML = "The Sum of Two Numbers = " + sum;
    
        alert("The sum of " + num1 + " and " + num2 + " is equal to = " + sum);
        console.log("Sum = " + sum);
    } else {
        alert("Please enter valid data!");
        console.log("Hayst, mali na pindot!!")
   }
}

