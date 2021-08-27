let log_out = document.getElementById("logoutBtn");
// let newReimb = document.getElementById("addReimbButton");
// let statChange = document.getElementById("resolver");

function logoutUser(event) {
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

// function onLoad(event) {
//     fetch('http://localhost:5000/loggedInUser', {
//         'credentials' : 'include',
//         'method' : 'GET'
//     }).then((response) => {
//         if (response.status === 401) {
//             window.location.href = '/index.html';
//         } else if (response.status === 200) {
//                 return response.json();
//             }
//     }).then((user) => {
//         return fetch(`http://localhost:5000/Reimbursement/${statChange}`, {
//             'method' : 'GET',
//             'credentials' : 'include'
//     });
//     }).then((response) => {
//         return response.json();
//     }).then((reimbursements) => {
//         populateReimbursements(reimbursements);
//     })
// }

function populateReimbursements(reimbArray) {
    let tbody = document.querySelector('#reimbursements tbody');

    for (const reimb of reimbArray) {

                    // <th>ID</th>
                    // <th>Amount</th>
                    // <th>Author</th>
                    // <th>Status</th>
                    // <th>Type</th>
                    // <th>Description</th>
                    // <th>SubmitTime</th>
                    // <th>ResolveTime</th>

        let tr = document.createElement('tr');
        
        let reimbIdTd = document.createElement('td');
        reimbIdTd.innerHTML = reimb.reimbID;

        let reimbAmountTd = document.createElement('td');
        reimbAmountTd.innerHTML = reimb.reimbAmount;

        let reimbAuthorTd = document.createElement('td');
        reimbAuthorTd.innerHTML = reimb.author.username;

        // let reimbStatusTd = document.createElement('td');
        // reimbStatusTd.innerHTML = 1 //reimb.status.status;

        // let reimbTypeTd = document.createElement('td');
        // reimbTypeTd.innerHTML = 1 //reimb.typeID.type;

        let reimbDescTd = document.createElement('td');
        reimbDescTd.innerHTML = reimb.reimbDesc;

        let reimbSubTimeTd = document.createElement('td');
        reimbSubTimeTd.innerHTML = reimb.submitTime;

        let reimbResolveTimeTd = document.createElement('td');
        reimbResolveTimeTd.innerHTML = reimb.resolveTime;

        tr.appendChild(reimbIdTd);
        // tr.appendChild(reimbAmountTd);
        // tr.appendChild(reimbAuthorTd);
        // tr.appendChild(reimbStatusTd);
        // tr.appendChild(reimbTypeTd);
        // tr.appendChild(reimbDescTd);
        // tr.appendChild(reimbSubTimeTd);
        // tr.appendChild(reimbResolveTimeTd);

        tbody.appendChild(tr);
    }
}

function toNewReimbPage(event) {
    window.location.href = '/addReimbursement.html';
}

function nothing(event) {

}

// window.addEventListener('load', onLoad);
log_out.addEventListener("click", logoutUser);
// statChange.addEventListener("click", nothing);
// newReimb.addEventListener('click', toNewReimbPage);