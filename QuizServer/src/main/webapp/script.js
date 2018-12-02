/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
var question;
var alternative1;
var alternative2;
var alternative3;
var alternative4;
var correctAnswer;
var category;
*/



function addQuestion() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/QuizServer/api/quiz/addQuestion", true);
    xhttp.setRequestHeader("content-type", "application/json");

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("send Question ok");
        }
    };
    var question = document.getElementById("question").value;
    var alternative1 = document.getElementById("alternative1").value;
    var alternative2 = document.getElementById("alternative2").value;
    var alternative3 = document.getElementById("alternative3").value;
    var alternative4 = document.getElementById("alternative4").value;
    var correctAnswer = document.getElementById("correctAnswer").value;
    var categoryQuestion = document.getElementById("categoryQuestion").value;
    xhttp.send(JSON.stringify({
        question: question,
        alternative1: alternative1,
        alternative2: alternative2,
        alternative3: alternative3,
        alternative4: alternative4,
        correctAnswer: correctAnswer,
        category: categoryQuestion
    }));
}

function addCategory() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/QuizServer/api/quiz/addCategory", true);
    xhttp.setRequestHeader("content-type", "application/json");

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("send Category ok");
        }
    };
   
    var category = document.getElementById("category").value;
    
    xhttp.send(JSON.stringify({
        categoryName: category
    }));
}

function addHighscore() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/QuizServer/api/quiz/addHighscore", true);
    xhttp.setRequestHeader("content-type", "application/json");

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("send score ok");
        }
    };
   
    var score = document.getElementById("highscore").value;
    var username = document.getElementById("username").value;
    var category2 = document.getElementById("category2").value;
    xhttp.send(JSON.stringify({
        highscore: parseInt(score),
        username : username,
        category : category2
    }));
}
