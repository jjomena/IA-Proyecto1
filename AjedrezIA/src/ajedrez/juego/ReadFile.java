/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kristalduran
 */
public class ReadFile {
    
    /**
     *  Read the file with the configuration
     * @param fileName
     * @return
     */
    public ArrayList<String> readFile(String fileName) throws FileNotFoundException, IOException{
        File file = new File(fileName); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        ArrayList<String> comandos = new ArrayList<>();
        String st; 
        while ((st = br.readLine()) != null){
          comandos.add(st);
          System.out.println(st);
        }
        return comandos;
    }
    
    public void setPosition(String color, String piece, char column, int row) {
        
    }
}
