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

            let picurl = null;
        if(sessionuser.profilePicture == null ){
            picurl = "avatar.png";
        }
        else{
            picurl = sessionuser.profilePicture.url;
        }
        
        document.getElementById("userdefault").innerHTML = `<img src="${picurl}" class="image-avatar" style="width:40%">` ;


            loadpets();
            loadUser();

        }
    }
    
    xhttp.open("GET", "http://localhost:8080/login", true);
    xhttp.send();
    }

    //The following function will load the user information in order to allow them to edit it
    function loadUser(){
        let picurl = null;
        if(sessionuser.profilePicture == null ){
            picurl = "avatar.png";
        }
        else{
            picurl = sessionuser.profilePicture.url;
        }


      document.getElementById("sessUserEdit").innerHTML = `<div class="pane-post" style="border-radius: 40px;">
            <div style="display:flex">
                <img class="image-avatar" src="${picurl}" style="width:25%;">
            <div class="form-group m-2">
                <label for="fileupload">Change Profile Picture</label>
                <input id="fileupload" class="form-control-file" type="file" name="fileupload" /> 
                <button type="button" class="btn btn-primary btn-sm ms-5" onclick="submitImage()">Change Pic</button>
            </div>
                <div style="margin-left:5%;">
                    <label style="font-size: xx-large;"> ${sessionuser.email}</label> <br><br>
                    <div style="display:flex">
                       <input type="text" class="edit-bar" value="${sessionuser.username}">
                       <img src="edit.png" class="image-icon-edit" onclick="changeUser()">
                    </div><br>
                    <div style="display:flex">
                        <input type="password" class="edit-bar" value="${sessionuser.password}">
                     </div>
                </div>
            </div>
        </div><br><Br></Br>`;
    }

// Loads the pets on the left panel and editable in the middle panel
    function loadpets(){
        let xhttp = new XMLHttpRequest();
    
        xhttp.onreadystatechange = function (){
            if(this.readyState == 4 && this.status==200){
                petinput = JSON.parse(xhttp.responseText);
                leftpets = petinput;
        
                //The following will iterate through all pets and display them
                for (let i =0; i < petinput.length; i++){
                //This will set the picture of the pet on the left pane
             let petpicurl = null;
                  if(petinput[i].profilePicture == null ){
              petpicurl = "avatar.png";
              }
                  else{
              petpicurl = petinput[i].profilePicture.url;
              }


                let output = document.getElementById("allthepets");
                let outputHtml = output.innerHTML;
      
                outputHtml +=  `<div style="display:flex">
                <img src="${petpicurl}" class="image-avatar" style="width:10%">
                <button class="dash-button"><u>${petinput[i].name}</u></button>
            </div><br>`;
    
                output.innerHTML = outputHtml;    
                }
                //This displays the pet and will allow the user to edit
                for (let i =0; i < petinput.length; i++){
                    let output = document.getElementById("editthepets");
                    let outputHtml = output.innerHTML;

                    //The following will Set the picture of the pet
                    let petpicurl = null;
                    if(petinput[i].profilePicture == null ){
                    petpicurl = "avatar.png";
                    }
                    else{
                 petpicurl = petinput[i].profilePicture.url;
                    }
                    
                    //This is what sets the editable fields
                    outputHtml += `<div class="pane-post" style="border-radius: 40px;">
                    <div style="display:flex">
                        <img class="image-avatar" src="${petpicurl}" style="width:17%;">
                        <div class="form-group m-2">
                        <label for="fileupload${i}">Change Profile Picture</label>
                        <input id="fileupload${i}" class="form-control-file" type="file" name="fileupload${i}" /> 
                        <button type="button" class="btn btn-primary btn-sm ms-5" onclick="submitPetImage(${i})">Change Pic</button>
                    </div>

                        <div style="margin-left:5%;">
                            <label style="font-size: xx-large;">@${petinput[i].tag}</label> <br><br>
                            <div style="display:flex">
                               <input type="text" class="edit-bar" value="${petinput[i].name}" >
                               <img src="edit.png" class="image-icon-edit" onclick="changePet()">
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

//Will change pet name that will display
    function changePet(){

    }
//Will update User: Will be called by submit Image if they need to
    function changeUser(){

    }
//Will upload User Image
    function submitImage(){
        let formData = new FormData();
        formData.append("file", fileupload.files[0]);
        
        
        
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                //THIS IS WHERE THE USER GETS UPDATED
                let newimage = JSON.parse(this.responseText);

                let user = {
                    "id": sessionuser.id,
                    "email": sessionuser.email,
                    "username": sessionuser.username,
                    "password": sessionuser.password,
                    "bio": null,
                    "profilePicture": newimage
                }
                let xhttp2 = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        //WILL REFRESH PAGE
                        Refresh();
                    }
                }
                xhttp2.open("PUT", "http://localhost:8080/users/" + sessionuser.id);
                xhttp2.setRequestHeader('Content-Type', 'application/json');
                xhttp2.send(JSON.stringify(user));
            }	}
        xhttp.open("Post", "http://localhost:8080/images", true);
        //xhttp.setRequestHeader("Content-Type", "multipart/form-data");
        xhttp.send(formData);
    }
    
    
    //Will upload new pet image 
    function submitPetImage(x){
        let fileInput = document.getElementById("fileupload" + x);
        let inputFiles = fileInput.files[0];


        let formData = new FormData();
        formData.append("file", inputFiles);
        //Starts XHTTP
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                //THIS IS WHERE THE USER GETS UPDATED
                let newimage = JSON.parse(this.responseText);
                //SETS UPDATED PET
                let pet = {
                    "id": petinput[x].id,
                    "name": petinput[x].name,
                    "tag": petinput[x].tag,
                    "profilePicture": newimage, 
                    "owner": petinput[x].owner
                }
                let xhttp2 = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        //WILL REFRESH PAGE
                        Refresh();
                    }
                }
                xhttp2.open("PUT", "http://localhost:8080/pets/" + petinput[x].id);
                xhttp2.setRequestHeader('Content-Type', 'application/json');
                xhttp2.send(JSON.stringify(pet));
            }	}
        xhttp.open("Post", "http://localhost:8080/images", true);
        //xhttp.setRequestHeader("Content-Type", "multipart/form-data");
        xhttp.send(formData);
    }

    function addPet() {
        let aname = document.getElementById("newpetname").value;
        let atag = document.getElementById("newpettag").value;
        // let abio = document.getElementById("newpetbio").value;
        let abio = document.getElementById("newpetbio").value;
    
        let pet = {
            name : aname,
            tag : atag,
            bio : abio,
            owner: sessionuser
        }
        let xhttp = new XMLHttpRequest();
    
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                let user = JSON.parse(this.responseText);
                console.log(pet.name + " Created Succesfully")
                window.location.href = "http://localhost:8080/account-settings.html";
                }
        }
        xhttp.open("POST", "http://localhost:8080/pets", true);
        xhttp.setRequestHeader('Content-Type', 'application/json');
        xhttp.send(JSON.stringify(pet));
    }



  