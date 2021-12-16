package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RespuestaAlumnoDAO {
    private Conexion conexion = new Conexion();

    public String insertarRespuestaAlumno(RespuestaAlumno ra) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO respuestaAlumno (idPregunta, respuesta, idUsuario) VALUES (?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, ra.getIdPregunta());
            prestm.setString(2, ra.getRespuesta());
            prestm.setInt(3, ra.getIdUsuario());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario agregado";
            else
                msj = "No se agregó el usuario";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;
    }

    public List<RespuestaAlumno> listadoRespuestas( int idUsuario,int idCuestionario) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<RespuestaAlumno> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT pregunta.pregunta, respuesta FROM respuestaAlumno inner join pregunta on respuestaAlumno.idPregunta = pregunta.id where idUsuario="+ idUsuario +" and idCuestionario="+idCuestionario;
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                RespuestaAlumno ra = new RespuestaAlumno(rs.getString("pregunta"), rs.getString("respuesta"));
                resultado.add(ra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
