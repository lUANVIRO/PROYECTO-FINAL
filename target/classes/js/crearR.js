var btnRegistrarRA = document.getElementById("btnRegistrarRA");
btnRegistrarRA.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearRespuestaA", {
        idPregunta: document.getElementById("idPregunta").value,
        respuesta:  document.getElementById("respAbierta").value
    })
        .then(function (res) {
            alert("Respuesta:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});

var btnRegistrarRC = document.getElementById("btnRegistrarRC");
btnRegistrarRC.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearRespuestaC", {
        idPregunta: document.getElementById("idPregunta").value,
        respuesta:  document.getElementById("opcion2").value,
    })
        .then(function (res) {
            alert("Respuesta:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});

btnRegistrarRC.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearRespuestaC", {
        idPregunta: document.getElementById("idPregunta").value,
        respuesta:  document.getElementById("opcion3").value,
    })
        .then(function (res) {
            alert("Respuesta:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});

btnRegistrarRC.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearRespuestaC", {
        idPregunta: document.getElementById("idPregunta").value,
        respuesta:  document.getElementById("opcion1").value,
    })
        .then(function (res) {
            alert("Respuesta:" + res.data.status + " id:" + res.data.id);
        })
        .catch(function (error) {
            console.log(error)
        })
});