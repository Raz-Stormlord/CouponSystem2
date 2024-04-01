function getUsername() {
    var username = localStorage.getItem('username');

    var usernameDisplay = document.getElementById('username');
    if (username) {
        usernameDisplay.textContent = 'Welcome, ' + username + '!';
    } else {
        usernameDisplay.textContent = 'Welcome!';
    }
}

function getCustomerCoupons(){
    const token = localStorage.getItem("token");
    const url = `http://localhost:8080/api/customer/all/purchased/${token}`;
    fetch(url ).then( response =>{
        if(response.status >= 400){
            console.log(response)
            throw new Error()
        }
        return response.json(); // convert json to js object
    } ).then( data => {
        console.log("coupon list", data)
    }).catch( err => {
        console.log(err);
        alert("Error retrieving the coupons")
    })
}
getUsername();
getCustomerCoupons();