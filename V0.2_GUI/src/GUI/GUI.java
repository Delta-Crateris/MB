/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import V02_GUI.CONSULTA;
import V02_GUI.INDEX;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.solr.client.solrj.SolrServerException;

/**
 *
 * @author Delta-Crateris
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    String cadena = "";
    
    public GUI() {
        initComponents();
        areaTexto.setEditable(false);
        //MostrarTExto(cadena);
        

    }
/**
 * 
 * @param evt
 * 
 * Se lanza la GUI con un seleccionador de ficheros. 
 * Una vez que se selecciona el fichero a indexar y se pulsa el boton "Abrir"
 * El método guarda en el parametro "fichero" la ruta absoluta del fichero seleccionado.
 * 
 * Una vez que hay un fichero válido, la ruta se envía al método indexar(fichero)
 * para que indexe el contenido del mismo y devuelva una cadena de caracteres
 * que se mostrará por pantalla en función del contenido del fichero.
 */

    public void MostrarTexto(String cadena) {
        areaTexto.setEditable(false);
        areaTexto.append(cadena);
        areaTexto.setEditable(false);
    }
    public void MostrarTexto2(String cadena)
    {
        areaTexto.setEditable(false);
        areaTexto.append(cadena);
        areaTexto.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        NuevaOp = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Logo1 = new javax.swing.JLabel();
        Fichero = new javax.swing.JFileChooser();
        Resultado = new javax.swing.JLabel();
        mb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        consulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel1.setBackground(new java.awt.Color(255, 255, 255));

        NuevaOp.setText("Nueva operación");
        NuevaOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaOpActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoETSIUHU.jpg"))); // NOI18N

        Fichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FicheroActionPerformed(evt);
            }
        });

        Resultado.setText("Resultado de la operación:");

        mb.setText("Ingeniería Informática. MB");

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        consulta.setText("Realizar una consulta");
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NuevaOp)
                        .addGap(18, 18, 18)
                        .addComponent(consulta)
                        .addGap(137, 137, 137)
                        .addComponent(Logo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mb)
                        .addGap(73, 73, 73)
                        .addComponent(Salir))
                    .addComponent(Fichero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(Resultado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(Fichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Logo1)
                    .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NuevaOp)
                        .addComponent(Salir)
                        .addComponent(consulta))
                    .addComponent(mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * 
 * @param evt
 * 
 * Se lanza la GUI con un seleccionador de ficheros. 
 * Una vez que se selecciona el fichero a indexar y se pulsa el boton "Abrir"
 * El método guarda en el parametro "fichero" la ruta absoluta del fichero seleccionado.
 * 
 * Una vez que hay un fichero válido, la ruta se envía al método indexar(fichero)
 * para que indexe el contenido del mismo y devuelva una cadena de caracteres
 * que se mostrará por pantalla en función del contenido del fichero.
 */
    private void FicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FicheroActionPerformed
        String fichero = Fichero.getSelectedFile().getAbsolutePath();
      if (fichero.isEmpty()) {
            JOptionPane.showConfirmDialog(Panel1, "No se ha seleccionado ninguna ruta");
        } else {
            INDEX index = new INDEX(this);
            try {
                //areaTexto.setEditable(false);
                //areaTexto.setText(fichero);
                
                index.indexar(fichero);
                //MostrarTexto(index.getCadena());
                
            } catch (SolrServerException ex) {

            } catch (IOException ex) {

            }
        }
        
    }//GEN-LAST:event_FicheroActionPerformed

    private void NuevaOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaOpActionPerformed
        
        dispose();
        GUI g = new GUI();
        g.setVisible(true);
        g.setTitle("SRI Versión V01.1.2");
       
    }//GEN-LAST:event_NuevaOpActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

        int opc = JOptionPane.showConfirmDialog(Panel1, "¿Está seguro de que desea cerrar el programa?");
        if (opc == 0) {
            dispose();
      } 
    }//GEN-LAST:event_SalirActionPerformed

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
       CONSULTA consul = new CONSULTA (this);
        try {
           try {
               areaTexto.setText("");
               consul.RealizarConsulta();
           } catch (FileNotFoundException ex) {
              
           } catch (SolrServerException ex) {
              
           }
        } catch (IOException ex) {
        }
       
    }//GEN-LAST:event_consultaActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI g = new GUI();
                g.setVisible(true);
                g.setTitle("SRI Versión V01.1.2");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser Fichero;
    private javax.swing.JLabel Logo1;
    private javax.swing.JButton NuevaOp;
    private javax.swing.JPanel Panel1;
    private javax.swing.JLabel Resultado;
    private javax.swing.JButton Salir;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton consulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mb;
    // End of variables declaration//GEN-END:variables
}
