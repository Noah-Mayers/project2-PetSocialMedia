function sessInfo() {
let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        console.log(this.responseText);
        sessionuser = JSON.parse(this.responseText);
        document.getElementById("sessUser").innerHTML = sessionuser.username;
        loadposts();
    }
}

xhttp.open("GET", "http://localhost:8080/login", true);
xhttp.send();
}

function loadposts() {
    let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        input = JSON.parse(xhttp.responseText);
        posts = input;

        //The following will iterate through all posts
        for (let i =0; i < input.length; i++){
            let output = document.getElementById("allPosts");
            let outputHtml = output.innerHTML;
            
            let pets = "";
        for(let j = 0; j < input[i].pets.length ; j++){
            pets += `${input[i].pets[j].name} `;
        }
            //Actual Post 
        outputHtml += `<div class="pane-post">
            <div style="font-size:xx-large;">
                <img style="width:5%;" class="image-avatar" src="avatar.png">
                <label>${input[i].author.username}</label>
            </div>
            <p style="font-size: large;">${input[i].caption}</p>
            <hr>
            <img class="image-post" src="https://proj2buck.s3.amazonaws.com/1.jpg">
            <hr>
            <div style="display:flex; font-size: x-large;">
                With: <label style="color:#FFB27F"><u>${pets}</u></label>
                <div style="text-align: right; font-size: large;">
                    <img src=logo-grey.png style="width:5%">
                    <label> 0 </label>
                    &emsp;
                    <img src=comment.png style="width:5%">
                    <label> 0 </label>
                </div>
            </div>
        </div>

        <br>
        <br></br>`;
        
        output.innerHTML = outputHtml;
        }
    }
}

xhttp.open("GET", "http://localhost:8080/posts", true);
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