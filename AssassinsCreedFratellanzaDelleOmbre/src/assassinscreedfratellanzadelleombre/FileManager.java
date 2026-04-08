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
        } 
        catch (IOException e) {
            return new String[0]; 
        }
    }
    
    public static void salvaGiocoSerializzato (GameManager gm) {
        try {
            java.io.FileOutputStream file = new java.io.FileOutputStream("salvataggio.dat"); //creo il file per salvare
            java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(file); //creo una sorta di canale per salvare gli oggetti
            output.writeObject(gm); //scrivo dentro il gamemanager tutto l gioco
            output.close();
            file.close();
            
            System.out.println("Gioco salvato correttamente");
        }
        catch (Exception e){
            System.out.println("Errore durante il salvataggio del gioco");
        }
    }
    
    public static GameManager caricaGiocoSerializzato() {
        try {
            java.io.FileInputStream file = new java.io.FileInputStream("salvataggio.dat"); //apro il file da cui leggere 
            java.io.ObjectInputStream input = new java.io.ObjectInputStream(file); //creo il canale per leggere oggetti
            GameManager gm = (GameManager) input.readObject();
            
            input.close();
            file.close();
            
            System.out.println("gioco caricato correttamente");
             return gm;
        }
        catch (Exception e) {
            System.out.println("errore durante il caricamento");
            return null;
        }
    }
}
