package ayd1.practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Registrar extends javax.swing.JFrame {

    ConexionDB conexion = new ConexionDB();
    public Registrar() {
        initComponents();
    }

    public Boolean consultarDPI()
    {
        try
        {
            ArrayList socios = new ArrayList();
            Class.forName("org.postgresql.Driver");
            //Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:8080/Analisis","postgres", "123456");
            Connection c = DriverManager.getConnection("jdbc:postgresql://10.56.22.175:8080/Analisis","postgres", "123456");
            c.setAutoCommit(false);
            Statement stm = c.createStatement();
            String sql = "SELECT nombre FROM socio WHERE dpi = "+this.dpi_Txf.getText()+ " ";
            ResultSet rs = stm.executeQuery(sql);
            int contador=0;
            while(rs.next())
            {
                contador++;
            }
            rs.close();
            stm.close();
            c.close();
            if(contador!=0)
            {
                JOptionPane.showMessageDialog(this, "Existe un usuario con ese DPI registrado");
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error Consultado Socios: " + e.getMessage());
            return false;
        }
    }
    
    private void registrarSocio()
    {
        String dpi,nombre,correo,domicilio,telefono,nacimiento,fecha_inicio;
        nombre = "'"+this.nombre_Txf.getText()+"'";
        dpi = this.dpi_Txf.getText();
        domicilio = "'"+this.domicilio_Txf.getText()+"'";
        correo = "'"+this.correo_Txf.getText()+"'";
        telefono = this.telefono_Txf.getText();
        nacimiento = "'"+this.nacimiento_Txf.getText()+"'";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        fecha_inicio = "'"+dateFormat.format(date)+"'"; //2014/08/06 15:59:48
        String consulta = "INSERT INTO socio(nombre, telefono, correo, nacimiento, domicilio, fecha_inicio,dpi)"
                        + "VALUES(" + nombre + "," + telefono + "," + correo + ", " + nacimiento + ", "+ domicilio + "," + fecha_inicio + "," + dpi + ")";
        conexion.guardarRegistro(consulta);
        this.nombre_Txf.setText("");
        this.dpi_Txf.setText("");
        this.domicilio_Txf.setText("");
        this.correo_Txf.setText("");
        this.telefono_Txf.setText("");
        this.nacimiento_Txf.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresar_Btn = new javax.swing.JButton();
        aceptar_Btn = new javax.swing.JButton();
        dpi_Txf = new javax.swing.JTextField();
        nombre_Txf = new javax.swing.JTextField();
        domicilio_Txf = new javax.swing.JTextField();
        telefono_Txf = new javax.swing.JTextField();
        correo_Txf = new javax.swing.JTextField();
        nacimiento_Txf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regresar_Btn.setText("Regresar");
        regresar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_BtnActionPerformed(evt);
            }
        });

        aceptar_Btn.setText("Aceptar");
        aceptar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_BtnActionPerformed(evt);
            }
        });

        nacimiento_Txf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacimiento_TxfActionPerformed(evt);
            }
        });

        jLabel1.setText("DPI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Telefono");

        jLabel4.setText("Correo");

        jLabel5.setText("Nacimiento");

        jLabel6.setText("Domicilio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar_Btn)
                        .addGap(56, 56, 56)
                        .addComponent(aceptar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGap(65, 65, 65)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correo_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefono_Txf)
                                .addComponent(nacimiento_Txf)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6))
                            .addGap(73, 73, 73)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dpi_Txf)
                                .addComponent(nombre_Txf)
                                .addComponent(domicilio_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpi_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(domicilio_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefono_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correo_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nacimiento_Txf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar_Btn)
                    .addComponent(aceptar_Btn))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nacimiento_TxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacimiento_TxfActionPerformed
        
    }//GEN-LAST:event_nacimiento_TxfActionPerformed

    private void regresar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_BtnActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresar_BtnActionPerformed

    private void aceptar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_BtnActionPerformed
        if(!consultarDPI())
        {
            registrarSocio();
        }
    
    }//GEN-LAST:event_aceptar_BtnActionPerformed
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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar_Btn;
    private javax.swing.JTextField correo_Txf;
    private javax.swing.JTextField domicilio_Txf;
    private javax.swing.JTextField dpi_Txf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nacimiento_Txf;
    private javax.swing.JTextField nombre_Txf;
    private javax.swing.JButton regresar_Btn;
    private javax.swing.JTextField telefono_Txf;
    // End of variables declaration//GEN-END:variables
}
