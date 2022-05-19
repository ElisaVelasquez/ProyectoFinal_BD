
package presentacion;

import Control.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Jarol, Daniel y Elisa.
 */
public class FrmPrincipal extends javax.swing.JFrame {

    PanelCliente panelClientes = new PanelCliente();
    PanelCasting panelCastings = new PanelCasting();
    BuscarCasting panelBuscarCastings = new BuscarCasting();
    PanelPerfil panelPerfil = new PanelPerfil();
    PanelTablaCasting panelTabla = new PanelTablaCasting();
    PanelAgenteCasting panelAgentes = new PanelAgenteCasting();

    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Principal");
    }

    public void despliegaPanelPerfil() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelTabla.desplegarPanel(), BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        this.setTitle("Registar Perfil");
    }

    public void despliegaPanelCliente() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelClientes.despliegaPanel(), BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        this.setTitle("Registar Cliente");
    }

    public void despliegaPanelCasting() {
        if (FabricaLogica.dameInstancia().existenClientes()) {
            panelPrincipal.removeAll();
            panelPrincipal.add(panelCastings.despliegaPanel(), BorderLayout.CENTER);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            this.setTitle("Registar Casting");
        } else {
            int result = JOptionPane.showConfirmDialog(this, "No existe ningun cliente registrado \n ¿Desea ingresar uno?", "Error", JOptionPane.ERROR_MESSAGE);
            if (result == 0) {
                despliegaPanelCliente();
            }
        }

    }

    public void despliegaPanelBuscar() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelBuscarCastings.despliegaPanel(), BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        this.setTitle("Buscar Casting");
    }

    public void despliegaPanelAgente() {
        panelPrincipal.removeAll();
        panelPrincipal.add(panelAgentes.despliegaPanel(), BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        this.setTitle("Registrar Agente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRegistrarCliente = new javax.swing.JMenuItem();
        MenuCastings = new javax.swing.JMenu();
        menuRegistrarCasting = new javax.swing.JMenuItem();
        menuRegistrarPerfil = new javax.swing.JMenuItem();
        menuBuscarCasting = new javax.swing.JMenuItem();
        menuRegistrarAgente = new javax.swing.JMenuItem();
        MenuItemSalir = new javax.swing.JMenuItem();
        opInformacion = new javax.swing.JMenu();
        opSalir2 = new javax.swing.JMenu();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(174, 198, 207));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1160, 598));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 36)); // NOI18N
        jLabel1.setText("Sistema general para generacion de castings para empresas");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("Menu");

        menuRegistrarCliente.setText("Registrar Cliente");
        menuRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegistrarCliente);

        MenuCastings.setText("Casting");

        menuRegistrarCasting.setText("Registrar Casting");
        menuRegistrarCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarCastingActionPerformed(evt);
            }
        });
        MenuCastings.add(menuRegistrarCasting);

        menuRegistrarPerfil.setText("Registrar Perfil");
        menuRegistrarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarPerfilActionPerformed(evt);
            }
        });
        MenuCastings.add(menuRegistrarPerfil);

        menuBuscarCasting.setText("Buscar casting");
        menuBuscarCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBuscarCastingActionPerformed(evt);
            }
        });
        MenuCastings.add(menuBuscarCasting);

        menuRegistrarAgente.setText("Registrar Agente");
        menuRegistrarAgente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarAgenteActionPerformed(evt);
            }
        });
        MenuCastings.add(menuRegistrarAgente);

        jMenu1.add(MenuCastings);

        MenuItemSalir.setText("Salir");
        MenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemSalir);

        jMenuBar1.add(jMenu1);

        opInformacion.setText("Información");
        opInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opInformacionMouseClicked(evt);
            }
        });
        jMenuBar1.add(opInformacion);

        opSalir2.setText("Salir");
        opSalir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opSalir2MouseClicked(evt);
            }
        });
        opSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSalir2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(opSalir2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void menuRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarClienteActionPerformed

        despliegaPanelCliente();

    }//GEN-LAST:event_menuRegistrarClienteActionPerformed

    private void menuRegistrarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarPerfilActionPerformed
        despliegaPanelPerfil();

    }//GEN-LAST:event_menuRegistrarPerfilActionPerformed

    private void menuRegistrarCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarCastingActionPerformed
        despliegaPanelCasting();
    }//GEN-LAST:event_menuRegistrarCastingActionPerformed

    private void menuBuscarCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBuscarCastingActionPerformed
        despliegaPanelBuscar();
    }//GEN-LAST:event_menuBuscarCastingActionPerformed

    private void MenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MenuItemSalirActionPerformed

    private void menuRegistrarAgenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarAgenteActionPerformed
        despliegaPanelAgente();
    }//GEN-LAST:event_menuRegistrarAgenteActionPerformed

    private void opInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opInformacionMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Este programa es un sistema de registro de castings. \nAutores:"
                + "\nJarol Francisco Tellez Castro. ID:00000228188. \nChristian Daniel Acedo Chaidez. ID:00000228373. \nDianey Elisa Velasquez Busani. ID:00000228270.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_opInformacionMouseClicked

    private void opSalir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opSalir2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_opSalir2MouseClicked

    private void opSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSalir2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_opSalir2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrmPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCastings;
    private javax.swing.JMenuItem MenuItemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menuBuscarCasting;
    private javax.swing.JMenuItem menuRegistrarAgente;
    private javax.swing.JMenuItem menuRegistrarCasting;
    private javax.swing.JMenuItem menuRegistrarCliente;
    private javax.swing.JMenuItem menuRegistrarPerfil;
    private javax.swing.JMenu opInformacion;
    private javax.swing.JMenu opSalir2;
    public static javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
