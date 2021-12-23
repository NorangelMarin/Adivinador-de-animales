package proyecto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenderson Quintero y Norangel Marin.
 */
public class Txt {

    String dir = "test\\adivinador.txt";
    File txt = new File(dir);

    /**
     * Constructor del txt
     */
    public Txt() {
        try {
            if (txt.exists()) {
            } else {
                txt.createNewFile();
            }
        } catch (IOException e) {
        }
    }

    /**
     * Escribe los datos ingresados por el usuario en el txt.
     *
     * @param dato
     */
    public void escribirTxt(String dato) {
        try (BufferedWriter escribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txt, true)))) {
            escribe.write(dato);
            escribe.close();
        } catch (IOException e) {
        }
    }

    /**
     * Elimina al txt, si existe.
     */
    public void vaciarTxt() {
        try{
            PrintWriter p = new PrintWriter(txt);
            p.print("");
            JOptionPane.showMessageDialog(null, "Base de datos borrada con éxito", "Sin conocimientos...", 1);
        } catch(FileNotFoundException e){  
            JOptionPane.showMessageDialog(null, "No se ha podido borrar la base de datos", "Error" + e, 0);
        }
    }

    /**
     * Almacena el contenido del txt en un String.
     *
     * @return String
     */
    public String leerTxt() {
        String texto = "";
        try {
            BufferedReader bF = new BufferedReader(new FileReader(dir));
            String temp = "";
            String bfRead;
            while ((bfRead = bF.readLine()) != null) {
                temp += temp + bfRead;
            }
            texto = temp;
        } catch (IOException e) {
        }
        return texto;
    }

    /**
     * Almacena los datos del txt en un Arreglo.
     *
     * @return String[]
     */
    public String[] cargarTxt() {
        String[] partes = leerTxt().split(",");
        return partes;
    }

}
