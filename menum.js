var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);

creador= parametros.get("creador");

var btnCrear = document.getElementById("btnCrear");
btnCrear.addEventListener("click",function(){
    window.location.replace("/crearCuestionario.html");
})

var btnRevisar = document.getElementById("btnRevisar");
btnRevisar.addEventListener("click",function(){
    asignarCuestionario(creador);
})

function asignarCuestionario(creador){
    let params = new URLSearchParams();
    params.append("creador", creador);
    window.location= "/cuestionarios.html?" + params; 
}