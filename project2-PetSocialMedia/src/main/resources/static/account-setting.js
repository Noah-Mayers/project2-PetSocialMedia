// For loggin out, will redirect to login page
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

//Retrieves the user session and pets for the left panel
function sessInfo() {
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function (){
        if(this.readyState == 4 && this.status==200){
            console.log(this.responseText);
            sessionuser = JSON.parse(this.responseText);
            document.getElementById("sessUser").innerHTML = sessionuser.username;
            loadpets();
            loadUser();

        }
    }
    
    xhttp.open("GET", "http://localhost:8080/login", true);
    xhttp.send();
    }

    //The following function will load the user information in order to allow them to edit it
    function loadUser(){
      document.getElementById("sessUserEdit").innerHTML = `<div class="pane-post" style="border-radius: 40px;">
            <div style="display:flex">
                <img class="image-avatar" src="avatar.png" style="width:25%;">
                <div style="margin-left:5%;">
                    <label style="font-size: xx-large;"> ${sessionuser.email}</label> <br><br>
                    <div style="display:flex">
                       <input type="text" class="edit-bar" value="${sessionuser.name}">
                       <img src="edit.png" class="image-icon-edit">
                    </div><br>
                    <div style="display:flex">
                        <input type="password" class="edit-bar" value="${sessionuser.password}">
                        <img src="edit.png" class="image-icon-edit">
                     </div>
                </div>
            </div>
        </div><br><Br></Br>`;
    }

// Loads the pets on the left panel
    function loadpets(){
        let xhttp = new XMLHttpRequest();
    
        xhttp.onreadystatechange = function (){
            if(this.readyState == 4 && this.status==200){
                petinput = JSON.parse(xhttp.responseText);
                leftpets = petinput;
        
                //The following will iterate through all pets and display them
                for (let i =0; i < petinput.length; i++){
                let output = document.getElementById("allthepets");
                let outputHtml = output.innerHTML;
      
                outputHtml +=  `<div style="display:flex">
                <img src="avatar.png" class="image-avatar" style="width:10%">
                <button class="dash-button"><u>${petinput[i].name}</u></button>
            </div><br>`;
    
                output.innerHTML = outputHtml;    
                }
                //This displays the pet and will allow the user to edit
                for (let i =0; i < petinput.length; i++){
                    let output = document.getElementById("editthepets");
                    let outputHtml = output.innerHTML;
          
                    outputHtml += `<div class="pane-post" style="border-radius: 40px;">
                    <div style="display:flex">
                        <img class="image-avatar" src="avatar.png" style="width:17%;">
                        <div style="margin-left:5%;">
                            <label style="font-size: xx-large;">${petinput[i].name}</label> <br><br>
                            <div style="display:flex">
                               <input type="text" class="edit-bar" value="${petinput[i].name}" >
                               <img src="edit.png" class="image-icon-edit">
                            </div><br>
                        </div>
                    </div>
                </div>
                <br><br>`;
        
                    output.innerHTML = outputHtml;    
                    }

            }
        }
    
    xhttp.open("GET", "http://localhost:8080/users/" + sessionuser.id + "/pets", true);
    xhttp.send();
    }