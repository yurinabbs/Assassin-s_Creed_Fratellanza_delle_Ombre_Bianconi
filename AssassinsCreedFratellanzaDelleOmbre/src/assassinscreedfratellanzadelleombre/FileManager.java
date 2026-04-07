/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    
    public static void salvaGioco (Personaggio p, int nemiciSconfitti) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("salvataggio.txt");
            
            writer.write(p.getNome() + "\n");
            writer.write(p.getVita() + "\n");
            writer.write(p.getEnergia() + "\n");
            writer.write(p.getPunteggio() + "\n");
            writer.write(nemiciSconfitti + "\n");
            
            writer.close();
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object[] caricaGioco() {
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("salvataggio.txt"));
            
            String nome = br.readLine();
            int vita = Integer.parseInt(br.readLine());
            int energia = Integer.parseInt(br.readLine());
            int punteggio = Integer.parseInt(br.readLine());
            int nemici = Integer.parseInt(br.readLine());
            
            br.close();
            
            return new Object[]{nome, vita, energia, punteggio, nemici};
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String[] leggiClassifica() {
    try {
        return Files.readAllLines(Paths.get("classifica.txt")).toArray(new String[0]);
    } catch (IOException e) {
        return new String[0]; 
    }
}
    
}
