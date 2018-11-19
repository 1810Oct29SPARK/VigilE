// weather API
/* 
let tampaWeather = ();

// send a GET request to this endpoint to get Tampa weather
let weatherApiURL = 'api.openweathermap.org/data/2.5/weather?q=Tampa,fl';

function getTampaWeather () {
    fetch(weatherApiURL).then((reponse) => {tampaWeather = response.json()}
    .then (data) => {tampaWeather = data});
    console.log( "")
}

function updateWeather {
    let newPara = document.createElement('p');
    newPara.innerText = 'the temperature is: ' + tampaWeather.main.temp + 'degrees';
    // add new p element as a child of div
    document.getElementById('weatherDiv').appendChild(newPara);
}
function getTampaWeatherWithAjax {
    // first: obtain xhr
    var xhr = new XMLHttpRequest();
    // second: define onreadystatechange
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    // third: prepare request
    xhr.open ("GET", url, true);
    // finally: send
    xhr.send();
}

function getTampaWeatherWithAjax(xhr) {
    // JSON.parse() will convert JSON-formatted string to a JS object
    var res = JSON.parse(xhr.responseText);
    console.log (res);
}

/*
    Fetch with POST requests 
    first, get a token for Artsy API
*/
/*
let artsyToken = ' ';

function getArtsyToken() {
    let artsyUrl = ;
    let clientId = '41225acd0944bc290c11';
    let clientSecret = 'b7d2cfec25c5c4c616e0ae6edf2007ae';
    fetch (artsyUrl, {method: "POST"})
    .then((response) => )
}
*/

let magic = {};
let apiUrl = 'https://docs.magicthegathering.io/#api_v1cards_list'

function getMagicData() {
    fetch (apiUrl).then((response) => {magic = response.json())}
    .then(data) => {magic = data});
    console.log(data);
}