/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hormigas;

import java.awt.Frame;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Simulacion extends javax.swing.JDialog {

    /**
     * Creates new form Simulacion
     */
    
    //Inicializamos las variables
    float alpha = 1;
    float beta = 2;
    double rho = 0.5;
    int iteraciones = 1;
    int iteracionesHechas = 0;
    int numHormigas = 20;
    Algoritmos algoritmos;
    Arista[][] matriz;
    
    //Constructor basico
    public Simulacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }        
    
    //Constructor con todo lo necesario para ejecutar una iteracion
    public Simulacion(java.awt.Frame parent, boolean modal, float alpha, float beta, double rho, int iteraciones, int numHormigas, Arista[][] matriz) {
        
        super(parent, modal);
        this.alpha = alpha;
        this.beta = beta;
        this.rho = rho;
        this.iteraciones = iteraciones;
        this.numHormigas = numHormigas;
        this.matriz = matriz;
        initComponents();
        
        //Escribimos lista de distancias entre ciudades
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i > j) {
                    jTextArea4.append("Entre " + matriz[j][i].getInicio() + " y " + matriz[j][i].getFin() + ": " + String.valueOf(matriz[j][i].getDistancia()) + " unidades de distancia");
                    jTextArea4.append("\r\n");
                }
            }
        }
        
    }
    
    //Metodo que ejecuta la iteracion
    public void correrIteracion(){
        
        //Instanciamos Algoritmos con sus valores
        algoritmos = new Algoritmos(alpha, beta, rho);
        
        //Instanciamos las hormigas an un ArrayList
        ArrayList<Hormiga> hormigas = new ArrayList<>();        
        for (int i = 0; i < numHormigas; i++) {
            Hormiga auxHormiga = new Hormiga(matriz, i);
            hormigas.add(auxHormiga);
        }
        
        //Loop por cada ciudad que debemos visitar
        for (int j = 0; j < matriz.length - 1; j++) {
            
            //Loop por cada hormiga en la cimulacion
            for (int k = 0; k < hormigas.size(); k++) {
                
                //Recibimos las aristas disponibles para la hormiga
                ArrayList<Arista> auxArista = hormigas.get(k).getAristas();

                if (auxArista.size() > 0) {
                    
                    //Se determina y ejecuta el movimiento de una hormiga
                    Arista movimiento = algoritmos.movimiento(auxArista);
                    movimiento.setFeromona(algoritmos.actualizacion(movimiento));
                    hormigas.get(k).actualizarAristas(movimiento);
                    
                    //Se actualizan las feromonas en la arista transitada por la hormiga
                    for (int l = 0; l < matriz.length; l++) {
                        for (int m = 0; m < matriz.length; m++) {
                            if ((matriz[l][m].getInicio().equals(movimiento.getInicio())) && (matriz[l][m].getFin().equals(movimiento.getFin())) && (matriz[l][m].getDistancia() == movimiento.getDistancia())) {
                                matriz[l][m].setFeromona(movimiento.getFeromona());
                                matriz[m][l].setFeromona(movimiento.getFeromona());
                            }
                        }
                    }

                }

            }

        }
        
        //El ultimo viaje siempre sera a la ciudad de la cual partio inicialmente
        for (int j = 0; j < hormigas.size(); j++) {
            
            //No hace falta la determinacion de la ciudad a visitar mediante la formula sino a traves de valores previamente guardados
            int auxInicio = hormigas.get(j).getInicio();
            int auxUbicacion = hormigas.get(j).getUbicacion();
            Arista movimiento = matriz[auxInicio][auxUbicacion];
            hormigas.get(j).actualizarAristas(movimiento);
            
            //De nuevo, se actualizan las feromonas
            for (int l = 0; l < matriz.length; l++) {
                    for (int m = 0; m < matriz.length; m++) {
                        if ((matriz[l][m].getInicio().equals(movimiento.getInicio())) && (matriz[l][m].getFin().equals(movimiento.getFin())) && (matriz[l][m].getDistancia() == movimiento.getDistancia())) {
                            matriz[l][m].setFeromona(movimiento.getFeromona());
                            matriz[m][l].setFeromona(movimiento.getFeromona());
                        }
                    }
                }

        }            
        
        //Al culminar la iteracion, se corre la evaporacion de las feromonas
        for (int j = 0; j < matriz.length; j++) {
            for (int k = 0; k < matriz.length; k++) {
                matriz[j][k].setFeromona(algoritmos.evaporacion(matriz[j][k]));
            }
        }
        
        //Aseguramos que los TextArea esten vacios
        jTextArea2.setText("");
        jTextArea3.setText("");
        
        //Escribimos las rutas de todas la hormigas simuladas
        for (int j = 0; j < numHormigas; j++) {
            jTextArea2.append(hormigas.get(j).getRecorrido());
            jTextArea2.append("\r\n");
        }
        
        //Escribimos las feromonas en todas las aristas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i > j) {
                    jTextArea3.append("Entre " + matriz[i][j].getFin() + " y " + matriz[i][j].getInicio() + ": " + String.valueOf(matriz[i][j].getFeromona()) + " feromonas");
                    jTextArea3.append("\r\n");
                }
            }
        }
                   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setText("Iteracion");

        jLabel2.setText(String.valueOf(iteracionesHechas)
        );

        jLabel3.setText("de");

        jLabel4.setText(String.valueOf(iteraciones)
        );

        jButton1.setText("Siguiente iteracion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel5.setText("Trayectorias de hormigas");

        jLabel6.setText("Feromonas entre ciudades");

        jLabel7.setText("Numero de hormigas");

        jTextField1.setText(String.valueOf(numHormigas));

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel8.setText("Distancias entre ciudades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Inicia una iteracion del algoritmo                  
        
        //Verificamos que no hemos excedido la cantidad de iteraciones previamente establecida
        if (iteraciones > 0) {
            
            //Actualizamos la pantalla y corremos una iteracion
            iteraciones--;    
            iteracionesHechas++;
            correrIteracion();
            jLabel2.setText(String.valueOf(iteracionesHechas));
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Simulacion dialog = new Simulacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
