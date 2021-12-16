var querystring = window.location.search;
var parametros = new URLSearchParams(querystring);

//idCuestionarios=  parametros.get("id");

axios.get("http://localhost:4567/cuestionariosp")
    .then(function (res) {
        let json = res.data;
        let tablaRespuestas = document.getElementById("tablaCuestionarios");
        var num =1;
        
        for (var clave in json) {
            if (json.hasOwnProperty(clave)) {
                
                let fila = document.createElement("tr");
                var col1 = document.createElement("th");
                col1.innerHTML = json[clave].id;
                idCuestionarios  = json[clave].id;
                //col1.innerHTML = num;
                var col2 = document.createElement("td");
                col2.innerHTML = json[clave].nombre;
                var col3 = document.createElement("td");
                col3.innerHTML = `<a type="button" onclick="revisarCuestionario(`+idCuestionarios+`)" class="btn btn-info">Asignar</a>`
                var col4 = document.createElement("td");
                col4.innerHTML = `<a type="button" onclick="asignarCuestionario(`+idCuestionarios+`)" class="btn btn-info">Asignar</a>`

                tablaRespuestas.appendChild(fila);
                fila.appendChild(col1);
                fila.appendChild(col2);
                fila.appendChild(col3);
                fila.appendChild(col4);
                num = num +1;
            }
        }
    })
    .catch()

function revisarCuestionario(id){
    let params = new URLSearchParams();
    params.append("Cuestionario", id);
    window.location= "/crearPreguntas.html?" + params; 
}

function asignarCuestionario(id){
    let params = new URLSearchParams();
    params.append("Cuestionario", id);
    window.location= "/asignarCuest.html?" + params; 
}