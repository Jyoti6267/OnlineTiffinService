


function myFunction() {
  
    const entries = performance.getEntriesByType("navigation");
    entries.forEach((entry) => {
       if(entry.type=="back_forward") return;
    });


    var x = document.getElementById("snackbar");

    x.className = "show";
  
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);


}