var correo = document.getElementById("correo").value

var btnIniciar = document.getElementById("login-button");
btnIniciar.addEventListener("click", () => {
    axios.get("http://localhost:4567/validarUsuario")
    .then(function (res) {
        let json = res.data;
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                if(document.getElementById("correo").value == json[clave].correo){
                    console.log(json[clave].nombre)
                    console.log("Hola");
                    if (json.hasOwnProperty(clave)){
                        idUsuarios = json[clave].id;
                        console.log(idUsuarios);
                        asignarCuestionario(idUsuarios);
                    }
                }  
            }
        }
    })
    .catch()
});


btnIniciar.addEventListener("click", () => {
    axios.post("http://localhost:4567/validarUsuario", {
        correo: document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value
    })
    .then(function (res) {
        if(res.data == 1){
            //window.location.replace("/verCuestionarios.html");
            alert("Alumno");
            
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

function asignarCuestionario(idUsuarios){
    let params = new URLSearchParams();
    params.append("idUsuario", idUsuarios);
    window.location= "/verCuestionarios.html?" + params; 
}
