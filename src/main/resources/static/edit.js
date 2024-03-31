function editDetails() {
    const token = localStorage.getItem("token")
    const url = "http://localhost:8080/api/customer/details/" + token
    fetch(url).then(ok => {
        return ok.json()
    }).then(ok => {
        console.log(ok)
    })
}