function getNotPurchasedCustomerCoupons(){
    const token = localStorage.getItem("token");
    const url = `http://localhost:8080/api/customer/all/not-purchased/${token}`;
    fetch(url ).then( response =>{
        if(response.status >= 400){
            console.log(response)
            throw new Error()
        }
        return response.json();
    } ).then( data => {
        console.log("coupon list", data)
        const coupons = document.getElementById('coupons');
        for(c of data){
            const div = document.createElement('div');
            const detailsDiv = document.createElement('div');
            const h2 = document.createElement('h2');
            h2.innerText = c.name;
            const expiration = document.createElement('p')
            expiration.innerHTML = `<strong>Expiration Date:</strong> ${c.expirationDate}`;
            const quantity = document.createElement('span')
            quantity.innerHTML = `<strong>Quantity:</strong> ${c.quantity}`;
            detailsDiv.appendChild(h2);
            detailsDiv.appendChild(expiration);
            detailsDiv.appendChild(quantity);
            div.appendChild(detailsDiv);
            div.classL ist.add("coupon")
            coupons.appendChild(div)
        }
    }).catch( err => {
        console.log(err);
        alert("Error retrieving the coupons")
    })
}
getNotPurchasedCustomerCoupons();