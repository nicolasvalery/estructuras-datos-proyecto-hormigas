/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Hormiga {
    
    //Inicializamos las variables
    int ubicacion;
    int inicio;
    String recorrido;
    ArrayList<String> visitados = new ArrayList<String>();
    ArrayList<Arista> aristas = new ArrayList<Arista>();
    Arista[][] matriz;
    
    //Constructor
    public Hormiga(Arista[][] matriz, int idHormiga) {
        
        //Determinamos aleatoriamente donde empieza la hormiga
        this.matriz = matriz;
        this.ubicacion = (int) Math.round(Math.random() * (matriz.length - 1));
        this.inicio = ubicacion;
        recorrido = "Hormiga " + String.valueOf(idHormiga + 1) + ": Desde " + matriz[ubicacion][ubicacion].getInicio() + ",";
        
        //Guardamos una lista de aristas al cual puede viajar la hormiga
        for (int i = 0; i < matriz.length; i++) {                        
            if (i != ubicacion) {
                aristas.add(matriz[ubicacion][i]);
            }            
        }
        
        //Guardamos los nombres de las ciudades que ha visitado la hormiga
        visitados.add(aristas.get(0).getInicio());
        
    }
    
    //Recibe una arista que ha determinado la formula a la cual viajara la hormiga
    public void actualizarAristas(Arista movimiento){
        
        //Actualizamos la ubicacion de la hormiga
        for (int i = 0; i < matriz.length; i++) {
            if (movimiento.getFin().equals(matriz[0][i].getFin())) {
                ubicacion = i;            
            }
        }
        
        //Actualizamos la lista de aristas a la cual se puede viajar desde la ubicacion actual
        aristas.clear();
        
        for (int i = 0; i < matriz.length; i++) {                        
            if (i != ubicacion) {
                aristas.add(matriz[ubicacion][i]);
            }            
        }
        
        //Actualizamos las ciudades que ha visitado la hormiga
        visitados.add(aristas.get(0).getInicio());
        
        //A la lista de aristas, le borramos las aristas que conducen a ciudades que ya ha visitado la hormiga
        for (int k = 0; k < visitados.size(); k++) {
            for (int i = 0; i < aristas.size(); i++) {
                for (int j = 0; j < visitados.size(); j++) {
                    if (aristas.get(i).getFin().equals(visitados.get(j))) {                        
                        aristas.remove(i);
                        i = 20;
                        j = 20;
                    }
                }
            }
        }
        
        //Continuamos actualizando la historia del recorrido de la hormiga
        recorrido = recorrido + " " + String.valueOf(movimiento.getDistancia()) + " unidades hasta " + movimiento.getFin() + ",";
        
    }
    
    //getters
    public ArrayList<Arista> getAristas() {
        return aristas;
    }    

    public int getInicio() {
        return inicio;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public int getUbicacion() {
        return ubicacion;
    }
    
    //setters
    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }   
               
}
