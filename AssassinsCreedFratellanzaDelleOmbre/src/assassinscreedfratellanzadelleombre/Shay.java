/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

/**
 *
 * @author bianconi.yurinabil
 */
public class Shay extends Personaggio{
    
    public Shay(){
        super("SHAY",120,22,25,50,35);
    }
    
    public void colpoBrutale(Nemico n){
        
        int danno  = getAttacco() + 30;
        n.subisciDanno(danno);
        //SHAY HA UN PROIETTILE SPECIALE CHE PERFORA IL NEMICO
    }
}
