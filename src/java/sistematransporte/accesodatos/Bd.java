/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematransporte.accesodatos;

//import jakarta.jms.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


/**
 *
 * @author user
 */
public class Bd {
    private Connection conn;
    
    public Connection getconn(){
        return conn;
    }
    
    public Bd(){
        
    }
    public Bd(String DB_URL, String DB_USER, String DB_PASSWORD) throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
