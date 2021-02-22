function sessInfo() {
let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        console.log(this.responseText);
        sessionuser = JSON.parse(this.responseText);
        document.getElementById("sessUser").innerHTML = sessionuser.username;
        loadpets();
        loadposts();
    }
}

xhttp.open("GET", "http://localhost:8080/login", true);
xhttp.send();
}


function loadpets(){
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status==200){
            petinput = JSON.parse(xhttp.responseText);
            leftpets = petinput;
    
            //The following will iterate through all posts
            for (let i =0; i < petinput.length; i++){
            let output = document.getElementById("allthepets");
            let outputHtml = output.innerHTML;
  
            outputHtml +=  `<div style="display:flex">
            <img src="avatar.png" class="image-avatar" style="width:10%">
            <button class="dash-button" data-toggle="modal" data-target="#post-popup" onclick="console.log(69)"><u>${petinput[i].name}</u></button>
            </div><br>`;

            output.innerHTML = outputHtml;    
            }
        }
    }

xhttp.open("GET", "http://localhost:8080/users/" + sessionuser.id + "/pets", true);
xhttp.send();
}

function loadposts() {
    let xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function (){
    if(this.readyState == 4 && this.status==200){
        input = JSON.parse(xhttp.responseText);
        posts = input;

        //The following will iterate through all posts
        for (let i =input.length; i > 0; i--){
            let output = document.getElementById("allPosts");
            let outputHtml = output.innerHTML;
            
            let pets = "";
        for(let j = 0; j < input[i-1].pets.length ; j++){
            pets += `${input[i-1].pets[j].name} `;
        }
        let postlike = "like" + input[i-1
        ].id;
        let counter = input[i-1].likes.length;
        //Actual Post 
        
        //Starts Post    
        outputHtml += `<div class="pane-post">`;
        
        outputHtml +=  `<div style="font-size:xx-large;">`;
        //Sets Poster Image
        outputHtml +=  `<img style="width:5%;" class="image-avatar" src="avatar.png">`;
        //Sets Poster Username
        outputHtml += `<label>${input[i-1].author.username}</label>
            </div>`;
        //Sets Caption of Post
        outputHtml += `<p style="font-size: large;">${input[i-1].caption}</p>
            <hr>`;
        //Sets Post Picture
        outputHtml += `<img class="image-post" src="https://proj2buck.s3.amazonaws.com/1.jpg">
            <hr>`;
        //Sets Tag
        outputHtml += `<div style="display:flex; font-size: x-large;">
                With: <label style="color:#FFB27F"><u>${pets}</u></label>`
        //Sets Likes
        outputHtml += `<div style="text-align: right; font-size: large;">
                    <img onclick="likeunlike(${input[i-1].id})" src=logo-grey.png style="width:5%">
                    <label id="${postlike}"> ${counter} </label>
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
        
        //Will Load Dynamic Checkboxes for doing a Post
        petinput.length;
        for(let f = 0; f < petinput.length; f++){
            let secoutput = document.getElementById("petselection");
            let secoutputHtml = secoutput.innerHTML;
            let check = "check" + petinput[f].id;
            secoutputHtml += `<div style="display:flex">
            <input type="checkbox" id="${f}" name="${petinput[f].tag}" value="${petinput[f].id}">
            <img src="avatar.png" class="image-avatar image-avatar-checkbox">
            <label>${petinput[f].name}</label>
        </div><br>`;

        secoutput.innerHTML = secoutputHtml;
        }

    }
}

xhttp.open("GET", "http://localhost:8080/posts", true);
xhttp.send();
}


function likeunlike(x){
    let xhttp = new XMLHttpRequest();
        
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          let post = JSON.parse(xhttp.responseText);
            check = false;
            if(post.likes.length != 0){
                for(let c = 0; c < post.likes.length; c++){
                 if(post.likes[c].id == sessionuser.id){
                    check = true;
                 }
                }
                if(check == true){
                    unlike(x);
                }
                else{
                    like(x);
                }
            }
            else{
                like(x);
            }
            }
      }
    //Will retrieve Post
    xhttp.open("GET", "http://localhost:8080/posts/" + x, true);
    xhttp.send(JSON.stringify(sessionuser));
    
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

function like(x){
    let xhttp = new XMLHttpRequest();
        
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         console.log("Liking the post...");
         let post = JSON.parse(this.responseText);
         //Changes the number of the like counter
         document.getElementById("like"+post.id).innerHTML = post.likes.length;
         
        }
      }
    
    xhttp.open("POST", "http://localhost:8080/posts/" + x + "/like", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(sessionuser));
}

function unlike(x){
    let xhttp = new XMLHttpRequest();
        
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         console.log("Unliking the post...");
         let post = JSON.parse(this.responseText);
         document.getElementById("like"+post.id).innerHTML = post.likes.length;
        }
      }
    
    xhttp.open("DELETE", "http://localhost:8080/posts/" + x + "/like", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(sessionuser));
}


// //Will Load Dynamic Checkboxes for doing a Post
// function doPost(){
//         petinput.length;
//         for(let f = 0; f < petinput.length; f++){
//             let secoutput = document.getElementById("petselection");
//             let secoutputHtml = output.innerHTML;
//             let check = "check" + petinput[f].id;
//             secoutputHtml += `<div style="display:flex">
//             <input type="checkbox" id="${f}" name="${petinput[f].tag}" value="${petinput[f].id}">
//             <img src="avatar.png" class="image-avatar image-avatar-checkbox">
//             <label>${petinput[f].name}</label>
//         </div><br>`;

//         secoutput.innerHTML = outputHtml;
//         }

// }


//Will Make Post
function post(){

    //The goal here is to get the tagged pets to be added to the post
    let thepets = [];
    let acaption = null;
    if(document.getElementById("usercaption").value == null || document.getElementById("usercaption").value == undefined ){
        acaption = "";
    }
    else{
        acaption = document.getElementById("usercaption").value;
    }

    for(let n = 0; n < petinput.length; n++){
        if(document.getElementById(`${n}`).checked == true){
            console.log("It is checked");
            thepets.push(petinput[n]); 
            console.log("Pet being tagged: " + JSON.stringify(petinput[n]));
        }
        else{
            console.log("It is unchecked");
        }
    }

    let post = {
        id: 0,
        caption: acaption,
        author: sessionuser,
        pets: thepets,
    }

    let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
                let newpost = JSON.parse(this.responseText);
                console.log(newpost);
				}
		}
		xhttp.open("POST", "http://localhost:8080/posts", true);
		xhttp.setRequestHeader('Content-Type', 'application/json');
		xhttp.send(JSON.stringify(post));
}