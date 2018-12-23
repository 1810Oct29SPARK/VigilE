/**
 * 
 */

let user = {};
var output = "";

window.onload = function() {
	populateUser();
	populateExistingRequests();
}

function populateUser() {
	// send a GET request to localhost:7001/SessionMgmtDemo/session
	// localhost:7001 = hostname and port
	// SessionMgmtDemo = route path
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
			var role = user.id;
			var username = user.username;
			var firstname = user.firstname;
			var lastname = user.lastname;
			var email = user.email;
			
			if (role < 4) {
				role = "Manager";
			} else {
				role = "Employee";
			}
			
			output += `
            <div class="blurb">
                <div class="jumbotron">
                    <h1> Hello, ${firstname}! </h1>
                    <p> Welcome to the ${role} Homepage! <p>
                </div>
			</div>
			`;
			container.innerHTML = output;
		}
    });
}

function populateExistingRequests() {
	let result = "";
	fetch ("http://localhost:7001/ProjectOne/reimbursements").then(function(response) {
		return response.json();
	}).then(function(data) {
		if (data.session === null) {
			output += `
			<div class="jumbotron"> 
			<p> You have not made any Reimbursement requests. </p>
			</div>
			`;
		} else {
			reimbursements = data;
			let tableBody = $("#pending-body");
			for (i = 0; i < reimbursements.length; i++) {
				let reimbursement = reimbursements[i];
				id = reimbursement.reimb_id;
				amt = reimbursement.amount;
				desc = reimbursement.description;
//				emp_id = reimbursement.emp_id;
//				status = reimbursement.stat;
//				resolver = reimbursement.reimb_resolver;
				
				reimb_array = {id, amt, desc};
				
				console.log(reimb_array);
//				if (status == 1) {
//					status = "pending";
//				}
					result += `
			    			<tr scope = "row">
			    			<td> ${id} </td>
			    			<td> ${amt} </td>
			    			<td> ${desc} </td>
			    			</tr>
			    	`;
//				 else {
//					continue;
//				}
			 	
			}
			
			tableBody.innerHTML = result;
			
		}
	});
}
	
