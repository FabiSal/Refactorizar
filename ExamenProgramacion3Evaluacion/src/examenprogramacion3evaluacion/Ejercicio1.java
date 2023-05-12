/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenprogramacion3evaluacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            //conectar con la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.230.108.162:3306?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();

            //escanner------------------------
            Scanner cs = new Scanner(System.in);
            int id, telefono;
            String nombre;
            boolean ex = true;

//            ex = stmt.execute("USE AGENDA;");
//            System.out.println("USE AGENDA;");
//menu---------
            System.out.println("opcion 1 mostrar contactos");
            System.out.println("opcion 2 insertar contactos");
            System.out.println("opcion 3 editar");
            System.out.println("opcion 4 borrar");
            System.out.println("introduce 5 para terminar");
            int opcion = cs.nextInt();
            do {
//switch case-------------------
                switch (opcion) {
                    //mostrar contactos
                    case 1:
                        ex = stmt.execute("USE AGENDA;");
                        ResultSet contacto = stmt.executeQuery("select * from contactos;");
                        while (contacto.next()) {
                            System.out.println(contacto.getInt("id") + contacto.getString("nombre") + contacto.getInt("telefono"));
                            break;
                        }
                        break;
                    //insertar contacto
                    case 2:
                        ex = stmt.execute("USE AGENDA;");
                        System.out.println("introduce id maximo 8 digitos");
                        id = cs.nextInt();
                        System.out.println("introduce nombre maximo 30 digitos");
                        nombre = cs.nextLine();
                        cs.next();//sino , el salto de linea se queda congelado
                        System.out.println("introduce telefono maximo 9 digitos");
                        telefono = cs.nextInt();
                        stmt.executeUpdate("insert into contactos (id,nombre,telefono)"
                                + "value(" + id + "," + nombre + "," + telefono + ")");
                        break;
                    //editar contacto
                    case 3:
                        ex = stmt.execute("USE AGENDA;");
                        System.out.println("introduce id a cambiar");
                        id = cs.nextInt();
                        System.out.println("introduce un nombre a cambiar");
                        nombre = cs.nextLine();
                        System.out.println("introduce un telefono a cambiar");
                        telefono = cs.nextInt();
                        stmt.execute("UPDATE contactos SET id = "+id+ ",nombre="+nombre + ",telefono="+telefono);
                        break;
                    //borra contacto
                    case 4:
                        ex = stmt.execute("USE AGENDA;");
                        System.out.println("introduce el nombre del registro que se requiere borrar");
                        String borrarNombre = cs.nextLine();
                        stmt.executeUpdate("DELETE FROM contactos WHERE nombre='" + borrarNombre + "');");
                        break;
                }
                stmt.close();
                conn.close();
            } while (opcion != 5);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
