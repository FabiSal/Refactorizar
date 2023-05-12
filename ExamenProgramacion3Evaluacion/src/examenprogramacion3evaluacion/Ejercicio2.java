/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenprogramacion3evaluacion;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//ruta donde esta guardado el ARCHIVO TXT DESCARGADO DE LA PROFE
//ruta "C:\\Users\\DAW\\Documents\\NetBeansProjects\\Aparcamientos.txt"
        String filePath = "C:\\Users\\DAW\\Documents\\NetBeansProjects\\Aparcamientos.txt";
        File file = new File(filePath);
        //BUFFER 

        int numMixtos = 0;
        int numResidentes = 0;
        int numDisuasorios = 0;

        try ( FileReader fileReader = new FileReader(file);  BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals("MIXTO")) {
                        numMixtos++;
                    } else if (word.equals("RESIDENTE")) {
                        numResidentes++;
                    } else if (word.equals("DISUASORIO")) {
                        numDisuasorios++;
                    }
                }
                System.out.printf("MIXTOS: %d, RESIDENTES: %d, DISUASORIOS: %d\n", numMixtos, numResidentes, numDisuasorios);
                numMixtos = 0;
                numResidentes = 0;
                numDisuasorios = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
