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
public class Hormigas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GUI asdf = new GUI();
        asdf.setVisible(true);
        
        //valores de ejemplo, crear objetos necesarios
        double ciudades = 5;
        String aux;
        int j = 0;
        int k = 0;
        int m = 0;
        int n = 0;
        int o = 0;
        double feromonaInicial = 1 / ciudades;
        Algoritmos algoritmos = new Algoritmos();
        
        //valores de distancia se pueden alterar para probar otras probabilidades
        /*Arista a = new Arista("a", feromonaInicial, 1);
        Arista b = new Arista("b", feromonaInicial, 2);
        Arista c = new Arista("c", feromonaInicial, 3);
        Arista d = new Arista("d", feromonaInicial, 4);
        Arista e = new Arista("e", feromonaInicial, 5);
        
        //arraylist de aristas elegibles para considerar
        ArrayList<Arista> aristas = new ArrayList<>();
        aristas.add(a);
        aristas.add(b);
        aristas.add(c);
        aristas.add(d);
        aristas.add(e);
        
        //i = numero de veces que corremos la probabilidad, por razones de prueba solamente, este for no hace falta
        for (int i = 0; i < 1000; i++) {
            
            aux = algoritmos.movimiento(aristas); //llamamos el calculo
            
            if (aux == "a") { //de nuevo, solo para comprobabr las probabilidades funcionen correctamente
                j++;
            }
            if (aux == "b") {
                k++;
            }
            if (aux == "c") {
                m++;
            }
            if (aux == "d") {
                n++;
            }
            if (aux == "e") {
                o++;
            }
            
            //imprimir seleccion
            System.out.println(aux);
            
        }
        
        //imprimir veces que se selecciono cada arista
        System.out.println(j);
        System.out.println(k);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);*/
        
        
    }
    
}
