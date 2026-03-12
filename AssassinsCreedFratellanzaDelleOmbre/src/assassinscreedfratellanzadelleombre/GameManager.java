/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;
import java.util.Random;

/**
 *
 * @author bianconi.yurinabil
 */
public class GameManager {
    private Personaggio giocatore;
    private Nemico nemico;
    
    public void selezionaPersonaggio(String scelta){
        if(scelta.equals("EZIO")){
        
            giocatore = new Personaggio(
            "EZIO",
            100,
            20,
            50,
            40,
            30
            );
        }
        
        if(scelta.equals("SHAY")){
            giocatore = new Personaggio(
            "SHAY",
            120,
            25,
            25,
            50,
            35
            );
        }
        
        if(scelta.equals("KASSANDRA")){
            giocatore = new Personaggio(
            "KASSANDRA",
            110,
            22,
            35,
            45,
            30
            );
        }
    }
    
    public void generaNemico(){
        
        Random rand = new Random();
        int tipo = rand.nextInt(3);
        
        if(tipo == 0){
            nemico = new Nemico("Spia Occulta",70,10);
        }
        
        if(tipo == 1){
            nemico = new Nemico("Guerriero Occulto",100,15);
        }
        
        if(tipo == 2){
            nemico = new Nemico ("Assassino Occulto",90,18);
        }
    }
    
    public void attaccoGiocatore() {
        
        giocatore.attacca(nemico);
        
        if(nemico.getVita() > 0) {
            nemico.attacca(giocatore);
        }
        
        generaDrop();
        generaNemico();
    }
    
    public void generaDrop(){
        
        Random rand = new Random();
        int drop = rand.nextInt(3);
        
        if(drop == 0){
            giocatore.aggiungiVita();
            System.out.println("Hai trovato una cura!");
        }
        
        if(drop == 1){
            giocatore.aumentaAttacco(5);
            System.out.println("Hai trovato un upgrade per la tua lama!");
        }
        
        if(drop == 2){
            giocatore.aumentaEnergia(10);
            System.out.println("Hai trovato del cibo e hai recuperato energia!");
        }
    }

    public Personaggio getGiocatore() {
        return giocatore;
    }

    public Nemico getNemico() {
        return nemico;
    }
    
}
