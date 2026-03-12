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

    public Personaggio(String nome, int vita, int attacco, int furtivita, int energia, int livello, int dannoSpeciale, int energiaRichiesta) {
        this.nome = nome;
        this.vita = vita;
        this.attacco = attacco;
        this.furtivita = furtivita;
        this.dannoSpeciale = dannoSpeciale;
        this.energiaRichiesta = energiaRichiesta;
        this.energia = 0;
        this.cureDisponibili = 2;
        this.livello = 1;
        this.esperienza = 0;
    }
    
    public boolean usaSpeciale (Nemico n){
        if (energia >= energiaRichiesta) {
            energia = energia - energiaRichiesta;
            n.subisciDanno(dannoSpeciale);
            return true;
        }
        return false;
    }

    public void subisciDanno(int danno) {
        vita = vita - danno;
        
        if (vita < 0){
            vita = 0;
        }
    }
    
    public boolean curati() {
        
        if(cureDisponibili > 0){
            cureDisponibili--;
            vita = vita + 25;
            if (vita > 100){
                vita = 100;
            }
            return true;
        }
        return false;
    }
    
    public void attacca(Nemico n){
        n.subisciDanno(attacco);
        energia = energia + 10;
    }
    
    public void aggiungiVita(){
        cureDisponibili++;
    }
    
    public void aumentaEnergia(int aumento){
        energia = energia + aumento;
    }
    
    public void aumentaAttacco(int aumento){
        attacco = attacco + aumento;
    }

    public String getNome() {
        return nome;
    }

    public int getVita() {
        return vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public int getFurtivita() {
        return furtivita;
    }

    public int getEnergia() {
        return energia;
    }

    public int getCureDisponibili() {
        return cureDisponibili;
    }

    public int getDannoSpeciale() {
        return dannoSpeciale;
    }

    public int getEnergiaRichiesta() {
        return energiaRichiesta;
    }

    public int getLivello() {
        return livello;
    }

    public int getEsperienza() {
        return esperienza;
    }

}
