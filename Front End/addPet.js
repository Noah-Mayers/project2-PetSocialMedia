function addPet() {
    let aname = document.getElementById("newpetname").value;
    let atag = document.getElementById("newpettag").value;
    let abio = document.getElementById("newpetbio").value;

    let pet = {
        name : aname,
        tag : atag,
        bio : abio
    }
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let user = JSON.parse(this.responseText);
            console.log(pet.name + " Created Succesfully")
            }
    }
    xhttp.open("POST", "http://localhost:8080/pets", true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(pet));
}