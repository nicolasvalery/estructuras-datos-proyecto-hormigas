/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;
import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class Algoritmos {
    
    //valores default de alpha y beta, en el final tendran que tener el chance de ser modificados
    int a = 1;
    int b = 2;
    
    //recibe la lista de aristas
    String movimiento(ArrayList input){
        
        ArrayList<Arista> aristas = input; //se convierten aristas de nuevo porque al pasar input los objetos Arista se convierten en Object???
        ArrayList<Double> factor = new ArrayList<>(); //para guardar las probabilidades para cada arista
        int size = aristas.size(); //veces que se necesita correr cada for
        
        //variedad de auxiliares
        Arista auxArista;
        double numerador = 0;
        double denominador = 0;        
        double calculo = 0;
        int seleccion = -1;
        int posicion = 0;
        double auxFeromona = 0;
        int auxDistancia = 1;        
        
        for (int i = 0; i < size; i++) {
            
            //recibe una arista, su feromona y distancia
            auxArista = aristas.get(i);
            auxFeromona = auxArista.getFeromona();
            auxDistancia = 1 / auxArista.getDistancia(); //calcula q/distancia, pero q siempre va a ser 1
            
            numerador = Math.pow(auxFeromona, a) * Math.pow(auxDistancia, b); //corresponde a t(r,s)^alpha * n(r,s)^beta
            factor.add(numerador); //se guarda en arraylist
            denominador = denominador + numerador; //va armando lo que corresponde a sumatoria r(r,u)^alpha * n(r,u)^beta de todos los viajes posibles
            
        }
        
        for (int i = 0; i < size; i++) {
            
            calculo = factor.get(i) / denominador; //a cada numerador lo divide por el denominador que es el mismo para todas las aristas
            factor.set(i, calculo); //y se guardan, sobreescribiendo los numeradores que ya no hacen falta
            
        }
        
        calculo = Math.random(); //reusamos la variable para obtener un numero aleatorio entre 0 y 1
        
        //esta parte determina a cual arista corresponde el valor aleatorio generado
        while(seleccion == -1){
            
            calculo = calculo - factor.get(posicion); //resta del numero aleatorio cada probabilidad hasta caer debajo de cero...
            
            if (calculo <= 0) { //permite salida del while
                seleccion = posicion;  //asigna a seleccion el 'ganador'
            }
            
            posicion++;
            
        }
        
        auxArista = aristas.get(seleccion); //recoge la arista correspondiente a la seleccion
        String resultado = auxArista.getNombre();
        
        return resultado;
        
    }
    
}
