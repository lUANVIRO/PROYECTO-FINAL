package mx.uv;
import com.google.gson.*;

import spark.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.*;
import static spark.Spark.*;

import mx.uv.db.UsuarioDAO;
import mx.uv.db.Video;
import mx.uv.db.Cuestionario;
import mx.uv.db.Respuesta;
import mx.uv.db.Pregunta;
import mx.uv.db.VideoDao;
import mx.uv.db.Asignacion;
import mx.uv.db.AsignacionDAO;
import mx.uv.db.CuestionarioDAO;
import mx.uv.db.PreguntaDAO;
import mx.uv.db.RespuestaAlumno;
import mx.uv.db.RespuestaAlumnoDAO;
import mx.uv.db.RespuestaDAO;
import mx.uv.db.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    public static void main( String[] args )
    {
        File uploadDir = new File("upload");
        uploadDir.mkdir(); 
        staticFiles.externalLocation("upload");
        port(getHerokuAssignedPort());

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });

        post("/usuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);
            //usuarios.put(id, u);

            UsuarioDAO dao = new UsuarioDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            return respuesta;
        });
        post("/crearCuestionario", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
            Cuestionario u = gson.fromJson(json, Cuestionario.class);
            //usuarios.put(id, u);

            CuestionarioDAO dao = new CuestionarioDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarCuestionario(u));
            return respuesta;
        });
        post("/crearPregunta", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
            Pregunta u = gson.fromJson(json, Pregunta.class);
            //usuarios.put(id, u);

            PreguntaDAO dao = new PreguntaDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarPregunta(u));
            return respuesta;
        });
        post("/crearAsignacion", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
             Asignacion u = gson.fromJson(json, Asignacion.class);
            //usuarios.put(id, u);

            AsignacionDAO dao = new AsignacionDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.crearAsignacion(u));
            return respuesta;
        });
        post("/crearRespuestaA", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
            Respuesta u = gson.fromJson(json, Respuesta.class);
            //usuarios.put(id, u);

            RespuestaDAO dao = new RespuestaDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarRespuesta(u));
            return respuesta;
        });
        post("/crearRespuestaC", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
            Respuesta u = gson.fromJson(json, Respuesta.class);
            //usuarios.put(id, u);

            RespuestaDAO dao = new RespuestaDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarRespuesta(u));
            return respuesta;
        });
        
        post("/crearAsignacion", (req, res) -> {
            System.out.println("Ahí vamos");
            // Insertamos un nuevo usuario
            String json = req.body();
            Asignacion u = gson.fromJson(json, Asignacion.class);
            //usuarios.put(id, u);

            AsignacionDAO dao = new AsignacionDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.crearAsignacion(u));
            return respuesta;
        });
        
        post("/validarUsuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario usuario = gson.fromJson(json, Usuario.class);
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            int resultado = usuarioDAO.validarUsuario(usuario);
            System.out.println(resultado);
            return resultado;
    
        });
        get("/usuarios", (req, res) -> {
            before((req2, res2) -> res.type("application/json"));
            UsuarioDAO dao = new UsuarioDAO();
            return gson.toJson(dao.listadoUsuario());
        });

        get("/resultados",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            RespuestaAlumnoDAO dao = new RespuestaAlumnoDAO();
            return gson.toJson(dao.listadoRespuestas(Integer.parseInt(req.queryParams("idUsuario")),Integer.parseInt(req.queryParams("idCuestionario"))));
        });

        get("/cuestionarios",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            CuestionarioDAO dao = new CuestionarioDAO();
            return gson.toJson(dao.listadoCuestionario(req.queryParams("creador")));
        });

        get("/validarUsuario",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            UsuarioDAO dao = new UsuarioDAO();
            return gson.toJson(dao.listadoUsuarios());
        });
        
        get("/cuestionariosp",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            CuestionarioDAO dao = new CuestionarioDAO();
            return gson.toJson(dao.listadoCuestionarios());
        });
        get("/listalumnos",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            UsuarioDAO dao = new UsuarioDAO();
            return gson.toJson(dao.listadoAlumnos());
        });
        get("/asignacion",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            AsignacionDAO dao = new AsignacionDAO();
            return gson.toJson(dao.listadoAsignacion(Integer.parseInt(req.queryParams("idCuestionario"))));
        });
        
        get("/asignacionPorUsuario",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            AsignacionDAO dao = new AsignacionDAO();
            return gson.toJson(dao.asignacionPorUsuario(Integer.parseInt(req.queryParams("idUsuario"))));
        });

        get("/preguntas",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            PreguntaDAO dao = new PreguntaDAO();
            return gson.toJson(dao.listadoPregunta((Integer.parseInt(req.queryParams("idCuestionario")))));
        });
        
        get("/respuestas",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            RespuestaDAO dao = new RespuestaDAO();
            return gson.toJson(dao.listadoRespuestas((Integer.parseInt(req.queryParams("idPregunta")))));
        });

        post("/guardarRespuestas", (req,res)->{
            String json = req.body();
            RespuestaAlumno re = gson.fromJson(json, RespuestaAlumno.class);
            RespuestaAlumnoDAO dao = new RespuestaAlumnoDAO();
            dao.insertarRespuestaAlumno(re);
            return dao;
        });

        post("/guardarVideo", (req,res)->{
            String json = req.body();
            Video vi = gson.fromJson(json, Video.class);
            VideoDao dao = new VideoDao();
            dao.insertarVideo(vi);
            return dao;
        });
        
        post("/crearC", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Cuestionario c = gson.fromJson(json, Cuestionario.class);
            //usuarios.put(id, u);

            CuestionarioDAO dao = new CuestionarioDAO();
            JsonObject respuesta = new JsonObject();
            System.out.println("Ahí vamos");
            respuesta.addProperty("status", dao.insertarCuestionario(c));
            return respuesta;
        });

        get("/video",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            VideoDao dao = new VideoDao();
            int idUsuario = Integer.parseInt(req.queryParams("idUsuario"));
            int idCuestionario = Integer.parseInt(req.queryParams("idCuestionario"));

            return gson.toJson(dao.listadoVideos(idUsuario,idCuestionario));
        });

        get("/", (req, res) ->
                  "<form method='post' enctype='multipart/form-data'>" // note the enctype
                + "    <input type='file' name='videoGrabado' accept='.png'>" // make sure to call getPart using the same "name" in the post
                + "    <button>Upload picture</button>"
                + "</form>"
        );

        post("/", (req, res) -> {

            Path tempFile = Files.createTempFile(uploadDir.toPath(), "", "");

            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            try (InputStream input = req.raw().getPart("videoGrabado").getInputStream()) { // getPart needs to use same "name" as input field in form
                Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
            }

            logInfo(req, tempFile);
            return "<h1>You uploaded this image:<h1><img src='" + tempFile.getFileName() + "'>";

        });
    }
    private static void logInfo(Request req, Path tempFile) throws IOException, ServletException {
        System.out.println("Uploaded file '" + getFileName(req.raw().getPart("uploaded_file")) + "' saved as '" + tempFile.toAbsolutePath() + "'");
    }

    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
    }
}
