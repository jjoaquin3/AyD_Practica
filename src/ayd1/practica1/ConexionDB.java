/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ayd1.practica1;

import com.sun.rowset.CachedRowSetImpl;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Elio
 */
public class ConexionDB {
    
     public CachedRowSet Function(String sql)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            //Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres","postgres", "123456");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres","postgres", "123456");
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= s.executeQuery(sql);
            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);
            rs.close();
            s.close();
            con.close();
            return crs;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void StoreProcedure(String sql)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres","postgres", "123456");
            Statement s = con.createStatement();
            s.execute(sql);
            s.close();
            con.close();
        }
        catch(Exception e)
        { 
            System.out.println(e.getMessage());
        } 
    }
    
    public void guardarRegistro(String sql)
    {
        try
        {
            Class.forName("org.postgresql.Driver");            
            Connection c = DriverManager.getConnection("jdbc:postgresql://10.56.22.175:8080/Analisis","postgres", "123456");
            //Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:8080/Analisis","postgres", "123456");
            Statement stm = c.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            c.close();
            JOptionPane.showMessageDialog(new JFrame(), "Registro Creado Exitosamente!");
        }
        
        catch( ClassNotFoundException | SQLException | HeadlessException e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Error Creando Socio: " + e.getMessage());
        }
    }
}
