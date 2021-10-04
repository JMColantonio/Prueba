package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;

    private final String user = "root";
    private final String pass = "root";
    private final String database = "tienda";

    protected void conectarBd() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlDB = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            conexion = DriverManager.getConnection(urlDB, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void consultarBd(String query) {
        try {
            conectarBd();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(query);     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void desconectarBd() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) { 
                sentencia.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        protected void insertarModificarEliminar(String query) throws Exception {
        try {
            //Creo la conexión con la base
            conectarBd();
            //Creo la sentencia
            sentencia = conexion.createStatement();
            //Ejecuto la sentencia con el sql pasado como parámetro
            sentencia.executeUpdate(query);

        } catch (SQLException ex) {
            try {
                //En caso de error retorno toda módificación para atras
                conexion.rollback();
            } catch (SQLException ex1) {
                throw new Exception("Error de Sistemas");
            }
            throw new Exception("Error de Sistemas");
        } finally {
            desconectarBd();
        }
    }
}
