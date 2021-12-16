var btnRegistrarP = document.getElementById("btnRegistrarP");
var querystring = window.location.search;
let CkAbierta = document.getElementById("RadioAbierta").checked;
let CkCerrada = document.getElementById("RadioCerrada").checked;
console.log(querystring);
var parametros = new URLSearchParams(querystring);
idCuestionarios= parametros.get("Cuestionario");
console.log(idCuestionarios);

btnRegistrarP.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearPregunta", {
        id: document.getElementById("idPregunta").value,
        idCuestionario: idCuestionarios,
        tipo:  document.getElementById("outputBox").value,
        pregunta: document.getElementById("pregunta").value
    })
        .then(function (res) {
            alert("Cuestionario:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});

function mostrar() {
    div = document.getElementById('flotante');
    div.style.display = '';
  }
  
  function cerrar() {
    div = document.getElementById('flotante');
    div.style.display = 'none';
  }
  
  function PreguntaCerrada() {
    div = document.getElementById('preguntaabierta');
    div.style.display = 'none';
    div = document.getElementById('preguntacerrada');
    div.style.display = '';
    tipoPregunta();
  }

  function tipoPregunta(){
    var order = "";
    if (document.getElementById('RadioAbierta').checked == true) {
      order = "Abierta";
    } else if (document.getElementById('RadioCerrada').checked == true) {
      order = "Cerrada";
    } 
    document.getElementById('outputBox').innerHTML = order;
  }

  function PreguntaAbierta() {
    div = document.getElementById('preguntacerrada');
    div.style.display = 'none';
    div = document.getElementById('preguntaabierta');
    div.style.display = '';
    tipoPregunta();
  }

var btnAgregar = document.getElementById("btnAgregar");
btnAgregar.addEventListener("click",function(){
    document.getElementById("idPregunta").value = "";
    document.getElementById("outputBox").value = "";
    document.getElementById("pregunta").value = "";
    document.getElementById("RadioAbierta").checked = false;
    document.getElementById("RadioCerrada").checked = false;
    document.getElementById("opcion1").value = "";
    document.getElementById("opcion2").value = "";
    document.getElementById("opcion3").value = "";
    document.getElementById("respAbierta").value = "";
    
    //window.location.replace("/ProyectoSW/crearPreguntas.html");
})

function revisarCuestionario(id){
  let params = new URLSearchParams();
  params.append("Cuestionario", id);
  window.location= "http://127.0.0.1:5501/crearPreguntas.html?" + params; 
}

var btnAsignar = document.getElementById("btnAsignar");
btnAsignar.addEventListener("click",function(){
  window.location= "http://127.0.0.1:5501/tablacuest.html"
})
  