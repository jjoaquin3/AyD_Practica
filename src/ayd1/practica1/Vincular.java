package ayd1.practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Vincular extends javax.swing.JFrame {
    ConexionDB conexion = new ConexionDB();
    public Vincular() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jcb_socio1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jcb_socio2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cancelar_Btn = new javax.swing.JButton();
        vincular_Btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcb_socio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jScrollPane1.setViewportView(jcb_socio1);

        jcb_socio2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jScrollPane2.setViewportView(jcb_socio2);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Vincular Socio");

        cancelar_Btn.setText("Cancelar");
        cancelar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_BtnActionPerformed(evt);
            }
        });

        vincular_Btn.setText("Vincular");
        vincular_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vincular_BtnActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Vinculos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar_Btn)
                        .addGap(18, 18, 18)
                        .addComponent(vincular_Btn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar_Btn)
                    .addComponent(vincular_Btn)
                    .addComponent(jButton1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarSociosPrincipales()
    {
        jcb_socio1.removeAllItems();
        try
        {
            ArrayList socios = new ArrayList();
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:8080/Analisis","postgres", "123456");
            c.setAutoCommit(false);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM socio");
            String nombre, dpi;
            while(rs.next())
            {
                nombre = rs.getString("nombre");
                dpi = rs.getInt("dpi") + "";
                socios.add(nombre + "|" + dpi);
            }
            if(!socios.isEmpty())
            {
                java.util.Collections.sort(socios);
                for(int i=0; i<socios.size(); i++)
                {
                    this.jcb_socio1.addItem(socios.get(i));
                }
            }
            rs.close();
            stm.close();
            c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error Cargando Socios: " + e.getMessage());
            this.jcb_socio1.removeAllItems();
        }
    }
    
    public void cargarSociosSecundarios()
    {
        jcb_socio2.removeAllItems();
        try
        {
            ArrayList socios = new ArrayList();
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:8080/Analisis","postgres", "123456");
            c.setAutoCommit(false);
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM socio");
            String nombre, dpi;
            while(rs.next())
            {
                nombre = rs.getString("nombre");
                dpi = rs.getInt("dpi") + "";
                nombre = nombre.substring(0, nombre.length());
                dpi = dpi.substring(0, dpi.length());
                socios.add(nombre + "|" + dpi);
            }
            if(!socios.isEmpty())
            {
                java.util.Collections.sort(socios);
                for(int i=0; i<socios.size(); i++)
                {
                    this.jcb_socio2.addItem(socios.get(i));
                }
            }
            rs.close();
            stm.close();
            c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error Cargando Socios: " + e.getMessage());
            this.jcb_socio2.removeAllItems();
        }
    }
    
    public void vincular()
    {
        if(jcb_socio1.getItemCount()!=0 && jcb_socio2.getItemCount()!=0 )
        {
            String dpi1 = jcb_socio1.getSelectedItem().toString();
            String dpi2 = jcb_socio2.getSelectedItem().toString();
            String[] separado = dpi1.split("\\|");
            dpi1 = separado[1];
            separado = dpi2.split("\\|");
            dpi2 = separado[1];
            String consulta = "INSERT INTO vinculo(dpi_principal,dpi_secundario)"
                            + "VALUES("+dpi1+","+dpi2+")";
            conexion.guardarRegistro(consulta);
        }
    }
    
    private void cancelar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_BtnActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelar_BtnActionPerformed

    private void vincular_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vincular_BtnActionPerformed
        vincular();
        
    }//GEN-LAST:event_vincular_BtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VerVinculos verVinculos = new VerVinculos();
        verVinculos.cargarVinculos();
        verVinculos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Vincular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vincular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vincular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vincular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vincular().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar_Btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcb_socio1;
    private javax.swing.JComboBox jcb_socio2;
    private javax.swing.JButton vincular_Btn;
    // End of variables declaration//GEN-END:variables
}
