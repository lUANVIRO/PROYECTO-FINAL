var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);
idCuestionarios= parametros.get("Cuestionario");

axios.get("http://localhost:4567/listalumnos")
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaAlumnos");
        var num =1;
        
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {             
                let fila = document.createElement("tr");
                var col1 = document.createElement("th");
                col1.innerHTML = json[clave].id;
                idUsuarios  = json[clave].id;
                //col1.innerHTML = num;
                var col2 = document.createElement("td");
                col2.innerHTML = json[clave].nombre;
                nombre = json[clave].nombre;
                console.log(nombre);
                var col3 = document.createElement("td");
                col3.innerHTML = `<a type="button" onclick="revisarCuestionario(`+json[clave].id+`,`+idCuestionarios+`)"class="btn btn-info">Asignar</a>`

                tablaRespuestas.appendChild(fila);
                fila.appendChild(col1);
                fila.appendChild(col2);
                fila.appendChild(col3);
                num = num +1;
            }
        }
    })
    .catch()

    function revisarCuestionario(idUsuario,idCuestionario){
        let params = new URLSearchParams();
        params.append("Usuario", idUsuario);
        params.append("Cuestionario", idCuestionario);
        window.location= "http://127.0.0.1:5501/ProyectoSW/asignarB.html?" + params; 
    }
