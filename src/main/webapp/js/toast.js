


function myFunction(value) {
  
    if(value == false && performance.navigation.type == 2) return;


    var x = document.getElementById("snackbar");

    x.className = "show";
  
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);


}