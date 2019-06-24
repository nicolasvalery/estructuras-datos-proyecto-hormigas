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
    String inicio;
    String fin;
    
    public void feromonaInicial(int numCiudad){
        float aux = 1 / numCiudad;
        setFeromona(aux);
    }

    //getters
    public double getFeromona() {
        return feromona;
    }

    public float getDistancia() {
        return distancia;
    }

    public String getInicio() {
        return inicio;
    }
    
    public String getFin() {
        return fin;
    }   
    
    //setters
    public void setFeromona(double feromona) {
        this.feromona = feromona;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }
    
    public void setFin(String fin) {
        this.fin = fin;
    }
    
    //constructor
    public Arista(String inicio, String fin, double feromona, float distancia) {
        this.inicio = inicio;
        this.fin = fin;
        this.feromona = feromona;
        this.distancia = distancia;
    }   
            
}
