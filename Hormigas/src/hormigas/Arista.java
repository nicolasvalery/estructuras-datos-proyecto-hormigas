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
    float distancia;
    String nombre;

    //getters
    public double getFeromona() {
        return feromona;
    }

    public float getDistancia() {
        return distancia;
    }

    public String getNombre() {
        return nombre;
    }   
    
    //setters
    public void setFeromona(double feromona) {
        this.feromona = feromona;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //constructor
    public Arista(String nombre, double feromona, float distancia) {
        this.nombre = nombre;
        this.feromona = feromona;
        this.distancia = distancia;
    }   
            
}
