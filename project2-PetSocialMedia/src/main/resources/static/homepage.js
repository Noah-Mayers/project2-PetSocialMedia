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
            
            //Will set pictures for pets
            //The following will Set the picture of the pet
              let petpicurl = null;
              if(petinput[i].profilePicture == null ){
              petpicurl = "avatar.png";
              }
              else{
           petpicurl = petinput[i].profilePicture.url;
              }


            outputHtml +=  `<div style="display:flex">
            <img src="${petpicurl}" class="image-avatar" style="width:10%">
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

        //Evaluates Author and Sets Post Profile Picture

        let picurl = null;
        if(input[i-1].author.profilePicture == null ){
            picurl = "avatar.png";
        }
        else{
            picurl = input[i-1].author.profilePicture.url;
        }

        //Evaluates if Post has image, or else sets default(WILL EVENTUALLY NOT ALLOW NULL POSTS)
        let postpic = null;

        if(input[i-1].picture == null ){
            postpic = "test-post.png";
        }
        else{
            postpic = input[i-1].picture.url;
        }
        
        //Actual Post 
        
        //Starts Post    
        outputHtml += `<div class="pane-post">`;
        
        outputHtml +=  `<div style="font-size:xx-large;">`;
        //Sets Poster Image
        outputHtml +=  `<img style="width:5%;" class="image-avatar" src="${picurl}">`;
        //Sets Poster Username
        outputHtml += `<label>${input[i-1].author.username}</label>
            </div>`;
        //Sets Caption of Post
        outputHtml += `<h1 style="font-size: large;">${input[i-1].caption}</h1>
            <hr>`;
        //Sets Post Picture
        outputHtml += `<img class="image-post" src="${postpic}">
            <hr>`;
        //Sets Tag
        outputHtml += `<div style="display:flex; font-size: large;">
                With: <label style="color:#FFB27F"><u>${pets}</u></label>`
        //Sets Likes


        
        outputHtml += `<div style="text-align: right; font-size: large;">
                    <img onclick="likeunlike(${input[i-1].id})" src=logo-grey.png style="width:5%">
                    <label id="${postlike}"> ${counter} </label>
                    &emsp;
                    <img onclick="showCommentButtonClicked(${input[i-1].id})" src=comment.png style="width:5%">
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


//uploads image before post is made, returns newpost
function post(){

    let fileInput = document.getElementById("fileupload");
    let fileValue = fileInput.value;
    let inputFiles = fileInput.files;
    console.log(fileValue);
    console.log(inputFiles);
    let formData = new FormData();
    formData.append("file", fileupload.files[0]);
    
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let = uploadedImage = JSON.parse(this.responseText);
            

            //The goal here is to get the tagged pets to be added to the post
            let thepets = [];
            let acaption = null;
            if(document.getElementById("usercaption").value == null || document.getElementById("usercaption").value == undefined ){
                acaption = "";
            }
            else{
                acaption = document.getElementById("usercaption").value;
            }
            //Checks which pets are tagged
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
                picture: uploadedImage,
                author: sessionuser,
                pets: thepets,
            }
        
            let xhttp2 = new XMLHttpRequest();
            xhttp2.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    let newpost = JSON.parse(this.responseText);
                    console.log(newpost);
                }
            }
            xhttp2.open("POST", "http://localhost:8080/posts", true);
            xhttp2.setRequestHeader('Content-Type', 'application/json');
            xhttp2.send(JSON.stringify(post));
        }	
    }
    xhttp.open("Post", "http://localhost:8080/images", true);
    //xhttp.setRequestHeader("Content-Type", "multipart/form-data");
    xhttp.send(formData);
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Comments code

///////////////////////////////////////////////////////////////////////////////////////////////////
//Getting comments and GUI code:
var commentSectionPost;
var commentList;

/////////////////////////////////////////////////////////
//Functions called when users clicks buttons (comment, close comments, and post comment So far)
/*
*function activated when the comment button on a post is clicked
*/
function showCommentButtonClicked(postId){
    console.log("user clicked the show comment button with the post  Id of:");
    console.log(postId);
    getPostWithPostId(postId);
    // console.log("out of the get postwith id method now the commentSectionPost is... ");
    // console.log(commentSectionPost);
    // beginCommentSectionSetUp();
}

function beginCommentSectionSetUp(){
    if(commentSectionPost == null || commentSectionPost == undefined){
        return;
    }
    console.log("beginning comment section setup");
    console.log("this is the post :")
    console.log(commentSectionPost);
    console.log("this is the comments :")
    console.log(commentList);
    clearCommentGUIList();
    console.log("making header");
    setUpCommentSectionHeader(commentSectionPost.author);
    console.log("making body");
    setUpCommentSectionBody();
    console.log("making visible");
    //makeCommentSectionVisible();
    console.log("done");
}

/*
*function activated when the close button inside of the comment section is clicked
*/
function closeCommentSection(){
    clearCommentGUIList();
    let entireCommentSection = document.getElementById("commentsSection");
    //entireCommentSection.style.visibility='hidden';
}

/////////////////////////////////////////////////////////
//AJax calls for getting comments and GUI

//AJAX call to get the list of comments for a post
function getCommentsForPost(postId){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("Recieved comment List...");
            console.log(this.response);
            let comments = JSON.parse(this.responseText);
            console.log(comments);
            commentList = comments;
            beginCommentSectionSetUp();
        }
        else{
            return null;
        }
    }
    xhttp.open("GET", "http://localhost:8080/comments/post/" + postId, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send();
}

function getPostWithPostId(postId){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("Recieved post...");
            console.log(this.response);
            let postGotten = JSON.parse(this.responseText);
            console.log(postGotten);
            commentSectionPost = postGotten;
            getCommentsForPost(commentSectionPost.id);
        }
        else{
            return null;
        }
    }
    xhttp.open("GET", "http://localhost:8080/posts/" + postId, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send();
}


/////////////////////////////////////////////////////////
// Functions that effect entire comment section (make visible and clear the list)


//Empties the div that will hold the list of comments
function clearCommentGUIList(){
    let commentBodyDiv = document.getElementById("whereToAddComments");
    commentBodyDiv.innerHTML = "";
}

//makes the whole comment section visible
function makeCommentSectionVisible(){
    let entireCommentSection = document.getElementById("commentsSection");
    entireCommentSection.style.visibility='visible';
}



/////////////////////////////////////////////////////////
// GUI constructor functions 

//Makes header that indicates the author of post 
function setUpCommentSectionHeader(authorOfPost){
    console.log("in set up comment section header");
    console.log(authorOfPost);
    let usernameLable = document.getElementById("authorOfSelectedPost");
    usernameLable.innerHTML = authorOfPost.username;
    let closeButtom = document.getElementById("closeCommentsButton");
    closeButtom.addEventListener("click", closeCommentSection());
    console.log("finished setting up header");
}



//Adds the comments to where comments are shown using the rest of the functions in the section
function setUpCommentSectionBody(){
    console.log("int he setting up of the body");
    console.log("the comment list again is... ");
    console.log(commentList);
   let commentBodyDiv = document.getElementById("whereToAddComments");
   if(Array.isArray(commentList)){
        for (let i =0; i < commentList.length; i++){
            console.log("in the  iteration of i equal to " + i);
            commentBodyDiv.appendChild(makeSingularCommentDivFor(i));
            let x = document.createElement("BR");
            commentBodyDiv.appendChild(x);
        }
   }
   else {
    commentBodyDiv.innerHTML = "";
   }
}


function makeSingularCommentDivFor(CommentposToInject){
    let CommentToInject = commentList[CommentposToInject];
    console.log("in the making a single comment div for. the comment here is : ");
    console.log(CommentToInject);
    let outterMostPaneDiv = document.createElement("div");
    outterMostPaneDiv.className = "pane-comment";
    
    
    let commentHead = makeSingularCommentHeaderDiv(CommentToInject.author);
    let commentBody = makeSingularCommentBodyDiv(CommentToInject);

    outterMostPaneDiv.appendChild(commentHead);
    outterMostPaneDiv.appendChild(commentBody);
    return outterMostPaneDiv;
}


function makeSingularCommentHeaderDiv(authorOfClient){
    let innerCommentHeaderDiv = document.createElement("div");
    innerCommentHeaderDiv.className = "pane-comment-header";

    let commentAuthorImg = document.createElement("IMG");
    commentAuthorImg.className = "image-avatar";
    commentAuthorImg.style.width = "6%"; //width:
    commentAuthorImg.src = getCommentAuthorImage(authorOfClient);

    let commentHeaderLabel = document.createElement("LABEL");
    commentHeaderLabel.style.textIndent = "10%";
    commentHeaderLabel.innerHTML = authorOfClient.username;

    innerCommentHeaderDiv.appendChild(commentAuthorImg);
    
    innerCommentHeaderDiv.appendChild(commentHeaderLabel);
    return innerCommentHeaderDiv;

}

function makeSingularCommentBodyDiv(commentToInject){
    let innerCommentBodyDiv = document.createElement("div");
    innerCommentBodyDiv.className = "pane-comment-body";

    let commentBodyLabel = document.createElement("LABEL");
    commentBodyLabel.style.verticalAlign = "center";
    commentBodyLabel.innerHTML = commentToInject.body;

    innerCommentBodyDiv.appendChild(commentBodyLabel);
    return innerCommentBodyDiv;
}

function getCommentAuthorImage(commentAuthor){
    if(commentAuthor.profilePicture == undefined ||commentAuthor.profilePicture == null){
        return "avatar.png";
    }
    return commentAuthor.profilePicture.url;
}





//////////////////////////////////////////////////////////
//Posting Comments code


/*
*Active when user clicks the button to submit the comment. 
*/
function submitComment(){
    console.log("comment button clicked!!! ");
    bodyOfcommentToPost =  document.getElementById("commentTextArea").value;
    document.getElementById("commentTextArea").value = "";
    if(bodyOfcommentToPost == "" || bodyOfcommentToPost == null || bodyOfcommentToPost == undefined){
        return;
    }
    saveCommentToServer(bodyOfcommentToPost);
}


function saveCommentToServer(commentString){
    let commentToPost = {
        post:commentSectionPost, 
        body:commentString
    };
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("comment posted sucessfully...\nRecieving comment from Server");
            console.log(this.response);
            let returnedComment = JSON.parse(this.responseText);
            console.log(returnedComment);
            showCommentButtonClicked(commentSectionPost.id);
        }
        else{
            return null;
        }
    }
    xhttp.open("POST", "http://localhost:8080/comments", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(commentToPost));
}

function makeCommentObjectForSending(postObject, bodyOfComment){
    let commentObject = {
        post:postObject,
        body:bodyOfComment
    };
    return commentObject;
}









