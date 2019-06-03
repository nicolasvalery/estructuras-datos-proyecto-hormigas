/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

/**
 *
 * @author Nico
 */
public class Arista {
    
    double feromona; //todo tiene que ser double por alguna puta razon
    int distancia;
    String nombre;

    //getters
    public double getFeromona() {
        return feromona;
    }

    public int getDistancia() {
        return distancia;
    }

    public String getNombre() {
        return nombre;
    }   
    
    //constructor
    public Arista(String nombre, double feromona, int distancia) {
        this.nombre = nombre;
        this.feromona = feromona;
        this.distancia = distancia;
    }   
            
}
