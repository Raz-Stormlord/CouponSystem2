function getUsername() {
    var username = localStorage.getItem('username');

    var usernameDisplay = document.getElementById('username');
    if (username) {
        usernameDisplay.textContent = 'Welcome, ' + username + '!';
    } else {
        usernameDisplay.textContent = 'Welcome!';
    }
}
getUsername()