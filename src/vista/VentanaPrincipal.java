/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import Controlador.ControladorUsuario;

import javax.swing.JMenu;

/**
 *
 * @author user
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentaLogin
     */
//    private ControladorEspacio controladorEspacio;
//    private ControladorTicket controladorTicket;
    private ControladorUsuario controladorUsuario;
//    private ControladorVehiculo controladorVehiculo;
    
    private VentanaRegistro ventanaRegistro;
    private VentanaLog ventanaLog;
//    private submenu1 s1;
//    private submenu2 s2;
//    private submenu3 s3;
//    private VentanaArrendar ventanaArrendar;
//    private VentanaFactura ventanaFactura;
    public VentanaPrincipal() {
        initComponents();
//        controladorVehiculo= new ControladorVehiculo();
//        controladorEspacio= new ControladorEspacio(controladorVehiculo);
//        controladorTicket= new ControladorTicket(controladorVehiculo,controladorEspacio);
        controladorUsuario=new ControladorUsuario();
//        ventanaArrendar= new VentanaArrendar(controladorTicket,controladorVehiculo,controladorEspacio);
        
        
        ventanaRegistro= new VentanaRegistro(controladorUsuario);
        ventanaLog=new VentanaLog(controladorUsuario,this);
//        s1= new submenu1(controladorTicket,controladorVehiculo,controladorEspacio);
//        s2= new submenu2(controladorTicket, controladorVehiculo, controladorEspacio);
//        s3= new submenu3(controladorTicket, controladorVehiculo, controladorEspacio);
//        ventanaFactura=new VentanaFactura(controladorUsuario,controladorVehiculo,controladorTicket);
        menuGestionar.setVisible(false);
        
    }
//
//    public VentanaFactura getVentanaFactura() {
//        return ventanaFactura;
//    }
//
//    public void setVentanaFactura(VentanaFactura ventanaFactura) {
//        this.ventanaFactura = ventanaFactura;
//    }
    

    public JMenu getMenuGestionar() {
        return menuGestionar;
    }

    public void setMenuGestionar(JMenu menuGestionar) {
        this.menuGestionar = menuGestionar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuRegistar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        abrir2 = new javax.swing.JMenuItem();
        menuGestionar = new javax.swing.JMenu();
        menuIngresoVehiculo = new javax.swing.JMenuItem();
        menuPagar = new javax.swing.JMenuItem();
        menuListar = new javax.swing.JMenuItem();
        menuArrendar = new javax.swing.JMenuItem();
        menuFacturar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        menuRegistar.setText("Registrar");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRegistar.add(jMenuItem1);

        jMenuBar1.add(menuRegistar);

        jMenu2.setText("Iniciar Sesion");

        abrir2.setText("abrir");
        abrir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir2ActionPerformed(evt);
            }
        });
        jMenu2.add(abrir2);

        jMenuBar1.add(jMenu2);

        menuGestionar.setText("Gestionar");

        menuIngresoVehiculo.setText("ingreso Vehiculo");
        menuIngresoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngresoVehiculoActionPerformed(evt);
            }
        });
        menuGestionar.add(menuIngresoVehiculo);

        menuPagar.setText("Pagar Ticket");
        menuPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPagarActionPerformed(evt);
            }
        });
        menuGestionar.add(menuPagar);

        menuListar.setText("Listar");
        menuListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarActionPerformed(evt);
            }
        });
        menuGestionar.add(menuListar);

        menuArrendar.setText("Arreandar");
        menuArrendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArrendarActionPerformed(evt);
            }
        });
        menuGestionar.add(menuArrendar);

        menuFacturar.setText("Facturar");
        menuFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFacturarActionPerformed(evt);
            }
        });
        menuGestionar.add(menuFacturar);

        jMenuBar1.add(menuGestionar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       jDesktopPane1.add(ventanaRegistro);
       ventanaRegistro.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void abrir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir2ActionPerformed
       jDesktopPane1.add(ventanaLog);
       ventanaLog.setVisible(true);
       menuGestionar.setVisible(false);
    }//GEN-LAST:event_abrir2ActionPerformed

    private void menuIngresoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngresoVehiculoActionPerformed
//       jDesktopPane1.add(s1);
//       s1.setVisible(true);
    }//GEN-LAST:event_menuIngresoVehiculoActionPerformed

    private void menuListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarActionPerformed
//      jDesktopPane1.add(s2);
//       s2.setVisible(true);
    }//GEN-LAST:event_menuListarActionPerformed

    private void menuPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagarActionPerformed
//       jDesktopPane1.add(s3);
//       s3.setVisible(true);
      
    }//GEN-LAST:event_menuPagarActionPerformed

    private void menuArrendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArrendarActionPerformed
//         jDesktopPane1.add(ventanaArrendar);
//       ventanaArrendar.setVisible(true);
    }//GEN-LAST:event_menuArrendarActionPerformed

    private void menuFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFacturarActionPerformed
//      jDesktopPane1.add(ventanaFactura);
//      ventanaFactura.setVisible(true);
    }//GEN-LAST:event_menuFacturarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuArrendar;
    private javax.swing.JMenuItem menuFacturar;
    private javax.swing.JMenu menuGestionar;
    private javax.swing.JMenuItem menuIngresoVehiculo;
    private javax.swing.JMenuItem menuListar;
    private javax.swing.JMenuItem menuPagar;
    private javax.swing.JMenu menuRegistar;
    // End of variables declaration//GEN-END:variables
}
