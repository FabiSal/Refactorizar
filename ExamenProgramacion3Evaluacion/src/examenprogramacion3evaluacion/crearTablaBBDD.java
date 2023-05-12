/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenprogramacion3evaluacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DAW
 */
public class crearTablaBBDD {
//funciones para comprobar y lanzar excepciones
    public static void comprueba(int resultado) throws Exception {
        if (resultado == 1) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }

    public static void comprueba(boolean resultado) throws Exception {
        if (!resultado) {
            System.out.println("Hecho");
        } else {
            throw new Exception("Error en el proceso");
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.230.108.162:3306?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
//----------------------------------conection-------------------------------------------------------------
            int nr;
            boolean ex = true;

            //entra en la base de datos recien creada
            ex = stmt.execute("USE AGENDA;");
            System.out.println("USE AGENDA");
            comprueba(ex);

//crear tabla----------------------------
            ex = stmt.execute("create table contactos("
                    + "id integer(8) PRIMARY KEY,"
                    + "nombre varchar(30),"
                    + "telefono integer(9));");
            
            System.out.println("create table contactos("
                    + "id integer(8) PRIMARY KEY,"
                    + "nombre varchar(30),"
                    + "telefono integer(9));");
            comprueba(ex);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

}
