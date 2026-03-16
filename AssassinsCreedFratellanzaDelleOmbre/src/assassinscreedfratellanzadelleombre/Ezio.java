/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

/**
 *
 * @author bianconi.yurinabil
 */
public class Ezio extends Personaggio{
    
    public Ezio(){
        super("KASSANDRA",100,20,50,40,30);
    }
    
    public void attaccoFurtivo(Nemico n){
        
        int danno  = getAttacco() * 2;
        n.subisciDanno(danno);
        //EZIO CHE COLPISCE DA UN CESPUGLIO CON LA LAMA
    }
    
}
