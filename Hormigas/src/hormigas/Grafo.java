/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

/**
 *
 * @author Alejandro
 */
public class Grafo {
    private int maxNodos;
    public int numVertices=4;
    private int matrizAdy [][];
    public Arista arista;
    double feromonaInicial = 1 / numVertices;
    

    public Grafo() {
        this.maxNodos = 20;
        this.numVertices = 4;
        this.matrizAdy = new int[20][20];
    }
    
    public void insertarVertice(){
        if(numVertices<maxNodos){
            for(int i=0; i<numVertices+1; i++){
                for(int j=numVertices; j<numVertices+1; j++){
                    matrizAdy[i][j]=matrizAdy[j][i];
                }
            }
            numVertices=numVertices+1;
        }else{
            System.out.println("maximo numero de nodos alcansado");
        }
    }
    
    public void distanciaAristas(){
        for(int i=0; i<numVertices; i++){
            for(int j=0; j<numVertices; j++){
                int calculo = 1+(int)(Math.random()*10);
                this.arista = new Arista("a", this.feromonaInicial, calculo);
                matrizAdy[i][j]=calculo;
                matrizAdy[j][i]=matrizAdy[i][j];
                if(i==j){
                    matrizAdy[i][j]=0;
                }
            }
        }
    }
    
    public void imprimir(){
        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                System.out.print(matrizAdy[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    
}
