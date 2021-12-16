var btnIniciar = document.getElementById("btnIniciar");
btnIniciar.addEventListener("click", () => {
    axios.post("http://localhost:4567/validarUsuario", {
        correo: document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value
    })
    .then(function (res) {
        if(res.data == 1){
            //window.location.replace("/menum.html");
            alert("Maestro");
        }else if(res.data == 0){
            alert("NO");
        }else if(res.data == -1){
            alert("Usuario o contraseñas invalidos");
        }
    })
    .catch(function (error) {
        console.log(error)
    })
});

var btnIniciar = document.getElementById("btnIniciar");
btnIniciar.addEventListener("click", () => {
    axios.get("http://localhost:4567/validarUsuario")
    .then(function (res) {
        let json = res.data;
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                if(document.getElementById("correo").value == json[clave].correo){
                    console.log(json[clave].nombre)
                    console.log("Hola");
                    nombres = json[clave].nombre
                    /*if (json.hasOwnProperty(clave)){
                        nombres = json[clave].nombre;
                        idUsuarios = json[clave].id;
                        console.log(idUsuarios);
                        asignarCuestionario(nombres);
                    }*/
                    asignarCuestionario(nombres);
                }  
            }
        }
    })
    .catch()
});

function asignarCuestionario(nombre){
    let params = new URLSearchParams();
    params.append("creador", nombre);
    window.location= "/menum.html?" + params; 
}