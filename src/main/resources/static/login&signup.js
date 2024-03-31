
function loadCoupons(){
    const coupons = document.getElementById("coupons");
    fetch("http://localhost:8080/api/customer/test", {
        method: 'GET'
    }).then( (data) => {
        return data.json();
    } ).then( (couponList) => {
        console.log(couponList);
        for(let i = 0; i < couponList.length; i++){
            const isoDate = couponList[i].expirationDate.split("-").reverse().join("/");

            coupons.innerHTML += `<p>${couponList[i].name}, ${couponList[i].quantity} ${isoDate}</p>`
        }
    })
}

function onLogin(){
    const url = "http://localhost:8080/api/customer/login"

    const username = document.getElementById("username");
    const password = document.getElementById("password");
    fetch(url, {
        method:"POST",
        headers:{'content-type':'application/json'},
        body:JSON.stringify({username:username.value, password:password.value})
    }).then(resp => {
        if(resp.status >= 400){
            alert('encountered an error')
            throw new Error()
        }
        return resp.json();
    }).then( token => {
        localStorage.setItem("token", token);
        localStorage.setItem("username", username.value);
        window.location.href='/home.html'
    }).catch(() => {
    });
}

function onSignup(){
    const url = "http://localhost:8080/api/customer/signup"

    const username = document.getElementById("username");
    const password = document.getElementById("password");
    fetch(url, {
        method:"POST",
        headers:{'content-type':'application/json'},
        body:JSON.stringify({username:username.value, password:password.value})
    }).then(resp => resp.json()).then( token => {
        console.log('the token is', token);
        localStorage.setItem("token", token);
        localStorage.setItem("username", username.value);
        window.location.href='/home.html'
    });

}