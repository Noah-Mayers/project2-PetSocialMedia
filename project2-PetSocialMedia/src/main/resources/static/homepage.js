function sessInfo() {
let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        console.log(this.responseText);
        sessionuser = JSON.parse(this.responseText);

        document.getElementById("sessUser").innerHTML = sessionuser.username;
    }
}

xhttp.open("GET", "http://localhost:8080/login", true);
xhttp.send();
}

function logout(){
    let xhttp = new XMLHttpRequest();
        
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("Logging out")
            window.location.replace('http://localhost:8080');
        }
      }
    
    xhttp.open("POST", "http://localhost:8080/logout", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(sessionuser));
}