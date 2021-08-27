let username = document.getElementById("username");
let password = document.getElementById("password");
let button = document.getElementById("loginButton");

function clickLogin(event) {

    event.preventDefault();

    console.log(username.value);
    console.log(password.value);
    console.log("Information received");

    const userInfo = {
        "username" : username.value,
        "password" : password.value
    }

    fetch("http://localhost:5000/login", {
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userInfo)
    }).then((response) => {
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 400) {
            console.log("Invalid Login")
           invalidLogin();
        }
    }).then((user) => {
        if (user.userRole.roleID === 1) {
            window.location.href = '/managerMenu.html'
        }
        else {
            window.location.href = '/employeeMenu.html';
        }   
        
    })
};

function invalidLogin() {
    let loginForm = document.getElementById('logform');

    let p = document.createElement('p');
    p.style.color = 'red';
    p.innerHTML = 'INVALID LOGIN!';

    loginForm.appendChild(p);
}

function checkIfCurrentlyLoggedIn(event) {
    fetch('http://localhost:5000/loggedInUser', {
        'credentials': 'include',
        'method' : 'GET'
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = '/employeeMenu.html';
        }
    });
}

button.addEventListener('click', clickLogin);
window.addEventListener('load', checkIfCurrentlyLoggedIn);