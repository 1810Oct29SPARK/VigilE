let state = {
    joke: ''
 };
 
 const apiUrl = 'https://icanhazdadjoke.com/';
 
 //long form of
 //function getJokeWithFetch(){...}
 let getJokeWithFetch = function() {
    n=0;
 for(i=0; i < 10; i++){
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json();
    })
        //utilize unwrapped promise a javascript object
    .then((data) => {
        state.joke = data.joke;
        updateContent();
    })
 let updateContent = function() {
    console.log(state);
    //select joke
    const jokeElement = document.getElementById(n);
    jokeElement.innerText = state.joke;
    n++;
 }
 }
 }
 document.getElementById('new-joke-button').addEventListener('click',getJokeWithFetch);