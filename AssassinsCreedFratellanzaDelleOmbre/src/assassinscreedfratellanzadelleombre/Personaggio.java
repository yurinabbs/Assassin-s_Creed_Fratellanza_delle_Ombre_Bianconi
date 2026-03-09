/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

/**
 *
 * @author bianconi.yurinabil
 */
public class Personaggio {
    private String nome;
    private int vita;
    private int attacco;
    private int furtivita;
    private int energia;
    private int cureDisponibili;
    private int dannoSpeciale;
    private int energiaRichiesta;
    private int livello;
    private int esperienza;

    public Personaggio(String nome, int vita, int attacco, int furtivita, int energia, int livello, int esperienza) {
        this.nome = nome;
        this.vita = vita;
        this.attacco = attacco;
        this.furtivita = furtivita;
        this.energia = 0;
        this.cureDisponibili = cureDisponibili;
        this.dannoSpeciale = dannoSpeciale;
        this.energiaRichiesta = 2;
        this.livello = 1;
        this.esperienza = 0;
    }
    
    public int usaSpeciale (int furtivita, int energia, int energiaRichiesta){
        if (energia > energiaRichiesta) {
            energia = energia - energiaRichiesta;
            
        }
    }
}
