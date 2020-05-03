/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

//import com.itextpdf.*;
//import com.sun.javafx.font.FontFactory;
//import java.io.*; 
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.sun.java.util.jar.pack.Attribute.Layout.Element;
//import java.util.ArrayList;
//import javafx.scene.text.Font;
//import sun.font.FontFamily;
//import com.itextpdf.text.Paragraph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kristalduran
 */
public class GenerarArchivo{
    
    public static void writePDF(String contenido) {
        try {
            String ruta = "./src/Files/filename.txt";
            File file = new File(ruta);
            file.getAbsolutePath();
            System.out.println(file.getAbsolutePath());
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(contenido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
