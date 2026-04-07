/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

/**
 *
 * @author bianconi.yurinabil
 */
public class FileManager {
    public static void salvaPunteggio(String nome, int punteggio){
        try {
            java.io.FileWriter writer = new java.io.FileWriter("classifica.txt", true);
            writer.write(nome + ";" + punteggio + "\n");
            writer.close();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
