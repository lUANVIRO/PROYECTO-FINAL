var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);
idUsuarios = parametros.get("Usuario");
console.log(idUsuarios);
idCuestionarios= parametros.get("Cuestionario");
console.log(idCuestionarios);

nombre= parametros.get("Nombre");
nombre = parametros.get("Nombre");

btnAsignar.addEventListener("click", () => {
    axios.post("http://localhost:4567/crearAsignacion", {
        idUsuario: idUsuarios,
        idCuestionario: idCuestionarios
    })
    .then(function (res) {
        alert("Cuestionario ASIGNADO:" + res.data.status + " id:" + res.data.id);
    })
    .catch(function (error) {
        console.log(error)
    })
});
