package ayd1.practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VerVinculos extends javax.swing.JFrame {
    ConexionDB conexion = new ConexionDB();
    public VerVinculos() {
        initComponents();
    }
    
    
    public void cargarVinculos()
    {
        jcb_vinculos.removeAllItems();
        try
        {
            ArrayList socios = new ArrayList();
            Class.forName("org.postgresql.Driver");
            //Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:8080/Analisis","postgres", "123456");
            Connection c = DriverManager.getConnection("jdbc:postgresql://10.56.22.175:8080/Analisis","postgres", "123456");
            c.setAutoCommit(false);
            Statement stm = c.createStatement()
            ;String sql = "SELECT S1.dpi \"dpi_principal\", S1.nombre \"nombrePrincipal\" , S2.dpi \"dpi_secundario\", S2.nombre \"nombreSecundario\" " +
                          "FROM SOCIO S1, SOCIO S2,VINCULO V " +
                          "WHERE S1.dpi=V.dpi_principal and S2.dpi=V.dpi_secundario;";
            System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            String nombrePrincipal, nombreSecundario;
            int dpi1,dpi2;
            while(rs.next())
            {
                nombrePrincipal = rs.getString("nombrePrincipal");
                dpi1 = rs.getInt("dpi_principal");
                nombreSecundario = rs.getString("nombreSecundario");
                dpi2 = rs.getInt("dpi_secundario");
                socios.add(nombrePrincipal+"("+dpi1+ ") | " + nombreSecundario+"("+dpi2+")");
            }
            if(!socios.isEmpty())
            {
                java.util.Collections.sort(socios);
                for(int i=0; i<socios.size(); i++)
                {
                    this.jcb_vinculos.addItem(socios.get(i));
                }
            }
            rs.close();
            stm.close();
            c.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error Cargando Socios: " + e.getMessage());
            this.jcb_vinculos.removeAllItems();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jcb_vinculos = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcb_vinculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jScrollPane1.setViewportView(jcb_vinculos);

        jButton1.setText("Atras");
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
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vincular vincular = new Vincular();
        vincular.setVisible(true);
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
            java.util.logging.Logger.getLogger(VerVinculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerVinculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerVinculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerVinculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerVinculos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcb_vinculos;
    // End of variables declaration//GEN-END:variables
}
