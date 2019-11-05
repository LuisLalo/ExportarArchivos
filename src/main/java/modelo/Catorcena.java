/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author UABC-16653387
 */
public class Catorcena {
    
    private String catorcena;

    public Catorcena(String catorcena) {
        this.catorcena = catorcena;
    }
    
    public String getCatorcena() {
        return catorcena;
    }

    public void setCatorcena(String catorcena) {
        this.catorcena = catorcena;
    }

    @Override
    public String toString() {
        return getCatorcena();
    }
}