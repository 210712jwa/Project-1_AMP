let log_out = document.getElementById("logoutBtn");

function logoutUser() {
    fetch('http://localhost:5000/logout', {
        'credentials' : 'include',
        'method' : 'POST'
    }).then((response) => {
        if (response.status === 200) {
            window.alert("You have been logged out.");
            window.location.href = "/index.html";
        } else if (response.status === 400) {
            console.log("The user is already logged out.");
            window.location.href = "/index.html";
        }
    });
}

log_out.addEventListener("click", logoutUser);