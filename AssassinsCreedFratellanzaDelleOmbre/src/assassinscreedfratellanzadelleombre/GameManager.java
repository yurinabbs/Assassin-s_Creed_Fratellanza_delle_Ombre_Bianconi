/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

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
        
    }
    
    public void attaccoGiocatore() {
        
        giocatore.attacca(nemico);
        
        if(nemico.getVita() > 0) {
            nemico.attacca(giocatore);
        }
    }
}
