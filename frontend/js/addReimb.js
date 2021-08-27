let reimbMoney = document.getElementById("reimbAmount")
let reimbType = document.getElementById("type")
let reimbDescription = document.getElementById("description")
let submitButton = document.getElementById("reimbSubmit")

function checkIfCurrentlyLoggedIn(event) {
    fetch('http://localhost:5000/loggedInUser', {
        'credentials': 'include',
        'method' : 'GET'
    }).then((response) => {
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 401) {
            window.location.href = '/index.html';
        }
    });
}

function newSubmission(event) {
    event.preventDefault();

    const newReimb = {
        'reimbAmount' : reimbMoney.value,
        'reimbType' : reimbType.value,
        'reimbDesc' : reimbDescription.value
    };

    fetch("http://localhost:5000/loggedInUser", {
        method: 'GET',
        credentials: 'include',
    }).then((response) => {
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 400) {
            window.location.href === 'index.html';
        }
    }).then((user) => {
        return fetch(`http://localhost:5000/User/${user.userID}/Reimbursement`, {
            'method' : 'POST',
            'credentials' : 'include',
            headers : {
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify(newReimb)
        });
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = 'employeeMenu.html';
        } else if (response.status === 401){
            alert("Reimbursement could not be added.");
            window.location.reload(true);
        }
    })
};

submitButton.addEventListener('click', newSubmission);
window.addEventListener('load', checkIfCurrentlyLoggedIn);