/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assassinscreedfratellanzadelleombre;

/**
 *
 * @author bianconi.yurinabil
 */
public class Nemico {
    private String nome;
    private int vita;
    private int attacco;
    

    public Nemico(String nome, int vita, int attacco) {
        this.nome = nome;
        this.vita = vita;
        this.attacco = attacco;
    }
    
    public void attacca(Personaggio p){
        p.subisciDanno(attacco);
    }
    
    public void subisciDanno(int danno){
        vita = vita - danno;
        
        if (vita < 0){
            vita = 0;
        }
    }
    
    public boolean isMorto(){
        if (vita > 0 ){
            return false;
        }
        return true;
    }

    public int getVita() {
        return vita;
    }

    public String getNome() {
        return nome;
    }

    public int getAttacco() {
        return attacco;
    }

}
