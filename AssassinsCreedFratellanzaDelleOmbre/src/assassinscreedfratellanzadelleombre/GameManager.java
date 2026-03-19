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
    private int numeroNemiciSconfitti = 0;
    boolean partitaFinita = false;
    
    public void selezionaPersonaggio(String scelta){
        if(scelta.equals("EZIO")){
        
            giocatore = new Ezio();
        }
        
        if(scelta.equals("SHAY")){
            
            giocatore = new Shay();
        }
        
        if(scelta.equals("KASSANDRA")){
            
            giocatore = new Kassandra();
        }
    }

    
    public void attaccoGiocatore() {
        
        giocatore.attacca(nemico);
        if(nemico.isMorto()) {
            giocatore.attacca(nemico);
            numeroNemiciSconfitti++;
            generaDrop();
            generaNemico();
            giocatore.guadagnaEsperienza(50);
        }
        nemico.attacca(giocatore);
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
    
    public void usaAbilita(){
        // instanceof serve per controllare se l'oggetto è di quella classe
        if(giocatore instanceof Ezio){
            ((Ezio)giocatore).attaccoFurtivo(nemico); 
        }
        if(giocatore instanceof Shay){
            ((Shay)giocatore).colpoBrutale(nemico);
        }
        if(giocatore instanceof Kassandra){
            ((Kassandra)giocatore).rigenerazione(nemico);
        }
    }
    
    public void generaNemico(){
        Random ran = new Random();
        int tipo = ran.nextInt(3);
        int vitaBase = 70 + (numeroNemiciSconfitti * 10);
        int forzaBase = 10 + (numeroNemiciSconfitti * 2);
        
        if (numeroNemiciSconfitti >= 10){
            nemico = new Nemico("L'Intendente",250,35);
            return;
        }    
        
        
        if(tipo == 0){
            nemico = new Nemico("Spia Occulta",vitaBase,forzaBase);
        }
        
        if(tipo == 1){
            nemico = new Nemico("Guerriero Occulto",vitaBase + 10 ,forzaBase + 3);
        }
        
        if(tipo == 2){
            nemico = new Nemico ("Assassino Occulto",vitaBase + 20,forzaBase + 5);
        }
        
        if (nemico.isMorto() && nemico.getNome().equals("L'Intendente")){
            partitaFinita = true;
        }
    }
    
}
