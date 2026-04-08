/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;
import java.util.Random;
import java.io.Serializable;

/**
 *
 * @author bianconi.yurinabil
 */
public class GameManager implements Serializable {
    private static final long serialVersionUID = 1L;
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

        if (giocatore.isMorto()) return;

        giocatore.attacca(nemico);

        if(nemico.isMorto()) {
            
            if (nemico.getNome().equals("L'Intendente")){
            partitaFinita = true;
            return;
            }
            
            numeroNemiciSconfitti++;
            giocatore.aggiungiPunteggio(100);
            generaDrop();
            generaNemico();
            return;
        }

        nemico.attacca(giocatore);

        if (giocatore.isMorto()) {
            partitaFinita = true;
        }
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
    
    public boolean usaAbilita(){
        return giocatore.usaSpeciale(nemico);
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
            nemico = new Nemico("Spia",vitaBase,forzaBase);
        }
        
        if(tipo == 1){
            nemico = new Nemico("Guerriero",vitaBase + 10 ,forzaBase + 3);
        }
        
        if(tipo == 2){
            nemico = new Nemico ("Assassino",vitaBase + 20,forzaBase + 5);
        }
        
    }
    
    public boolean isPartitaFinita() {
        return partitaFinita || giocatore.isMorto();
    }
    
    public boolean isVittoria() {
       return partitaFinita && !giocatore.isMorto();
    }
    
    public int getNumeroNemiciSconfitti() {
        return numeroNemiciSconfitti;
    }
    
        public void caricaPartita(Object[] dati) {
        
        String nome = (String) dati[0];
        int vita = (int) dati[1];
        int energia = (int) dati[2];
        int punteggio = (int) dati[3];
        int nemici = (int) dati[4];
        
        selezionaPersonaggio(nome);
        
        giocatore.setVita(vita);
        giocatore.setEnergia(energia);
        giocatore.setPunteggio(punteggio);
        
        this.numeroNemiciSconfitti = nemici;
        
        generaNemico();
    }
}
