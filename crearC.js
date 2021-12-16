var btnRegistrarC = document.getElementById("btnRegistrarC");
btnRegistrarC.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearCuestionario", {
        nombre: document.getElementById("nombre").value,
        creador: document.getElementById("creador").value
    })
        .then(function (res) {
            alert("Usuario:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});
    


var btnPreguntas = document.getElementById("btnPreguntas");
btnPreguntas.addEventListener("click",function(){
    window.location.replace("/tablacuest.html");
})