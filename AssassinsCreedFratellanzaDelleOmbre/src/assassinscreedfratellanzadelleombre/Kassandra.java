package assassinscreedfratellanzadelleombre;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bianconi.yurinabil
 */
public class Kassandra extends Personaggio{
    
    public Kassandra(){
        super("KASSANDRA",110,22,35,45,30);
    }
    
    public void rigenerazione(Nemico n){
        
        subisciDanno(-20);
        //KASSANDRA CHE SI CURA MANGIANDO QUALCOSA
    }
}
