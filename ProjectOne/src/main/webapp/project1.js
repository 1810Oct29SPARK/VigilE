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


//async function getJson() {
//	  try {
//	    let response = await fetch('/users.json');
//	    let json = await response.json();
//	    console.log(json);
//	  }
//	  catch(e) {
//	    console.log('Error!', e);
//	  }
//	}

function populateExistingRequests() {
	result = "";
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
			let tableBody = document.getElementById("pending-body");
			for (i = 0; i < reimbursements.length; i++) {
				let reimbursement = reimbursements[i];
				id = reimbursement.reimb_id;
				amt = reimbursement.amount;
				desc = reimbursement.description;
				emp_id = reimbursement.employee_id.id;
				status = reimbursement.stat;
				resolver = reimbursement.reimb_resolver;
				
				reimbursement_arr = {id, amt, desc, emp_id, status, resolver};
				console.log(reimbursement_arr);
//				if (status == 1) {
//					status = "pending";
//				}
					result += `
			    			<tr scope = "row">
			    			<td> ${id} </td>
			    			<td> ${desc} </td>
			    			<td> ${amt} </td>
			    			<td> ${status} </td>
			    			<td> ${resolver} </td>
			    			</tr>
			    	`;
					console.log(result);
//				 else {
//					continue;
//				}
			 	
			}
			
			tableBody.innerHTML = result;
			
		}
	});
}