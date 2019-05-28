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
        Arista aux;
        int size = aristas.size(); //veces que se necesita correr cada for
        double numerador = 0;
        double denominador = 0;
        double n = 0;
        double auxFeromona = 0;
        float auxDistancia = 1;        
        
        for (int i = 0; i < size; i++) {
            
            //recibe una arista, su feromona y distancia
            aux = aristas.get(i);
            auxFeromona = aux.getFeromona();
            auxDistancia = 1 / aux.getDistancia(); //calcula q/distancia, pero q siempre va a ser 1
            
            numerador = Math.pow(auxFeromona, a) * Math.pow(auxDistancia, b); //corresponde a t(r,s)^alpha * n(r,s)^beta
            factor.add(numerador); //se guarda en arraylist
            denominador = denominador + numerador; //va armando lo que corresponde a sumatoria r(r,u)^alpha * n(r,u)^beta de todos los viajes posibles
            
        }
        
        for (int i = 0; i < size; i++) {
            n = factor.get(i) / denominador; //a cada numerador lo divide por el denominador que es el mismo para todas las aristas
            factor.set(i, n); //y se guardan, sobreescribiendo los numeradores que ya no hacen falta
        }
        
        n = Math.random(); //reusamos el n para obtener un numero aleatorio entre 0 y 1
        
        //esta parte determina a cual arista corresponde el valor aleatorio
        for (int i = 0; i < size; i++) {
            
            n = n - factor.get(i); //resta de n cada probabilidad hasta caer debajo de cero...
            
            if (n <= 0) {
                n = i + 1; //deberia usar una nueva variable pero por ahora esto funciona
            }
        }
        
        n = Math.ceil(n) - 1; //si uso Math.floor(n) se rompe el programa, pero Math.ceil(n) - 1 no??? y segun my logica deberia ser solo Math.ceil(n)?? pero esta funcionando la vaina bien asi
        //si no le sumo 1 a n y se lo quito en la linea anterior las probabilidades no salen bien y no se porque, CAMBIAR
        int cast = (int) n; //casteo n de double a int, en teoria sin perdida de informacion pues lo lleve a un numero entero
        aux = aristas.get(cast); //recoge la arista
        String resultado = aux.getNombre();
        
        return resultado;
    }
    
}
