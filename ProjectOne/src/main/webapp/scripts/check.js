let user = {};
var output = "";

function populateUser() {
	// send a GET request to localhost:7001/ProjectOne/session
	// localhost:7001 = hostname and port
	// ProjectOne = route path
	fetch("http://localhost:7001/ProjectOne/session").then(function(response) {
		return response.json();
	}).then (function(data) {
		// check whether there was a valid session returned
		// define behavior for no user returned
		if (data.session === null) {
			window.location = "http://localhost:7001/ProjectOne/login";
		} else {
			// define behavior for user returned
			container = document.getElementById("container");
			user = data;
			username = user.username;
			firstname = user.firstname;
			lastname = user.lastname;
			email = user.email;
			
			
			output += `
            <div class="blurb">
                <div class="jumbotron">
                    <h1> Hello, ${firstname}! </h1>
                    <p> Welcome to the Employee Homepage! <p>
                </div>
			</div>
			`;
			container.innerHTML = output;
		}
    });
}

window.onload = function() {
	populateUser();
}
	let view_indicator = document.getElementById("view-indicator");
	let request_count = document.getElementById("request-count");

