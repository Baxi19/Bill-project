/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;


/**
 *
 * @author Baxi
 */
public class SQLLiteMethods {
    public static SQLLiteMethods instance = null;
    
    public static SQLLiteMethods getInstance() {
        if (instance == null) {
            return instance = new SQLLiteMethods();
        }
        return instance;
    }
    
    public DefaultListModel getUnitPrice(String height, String description){
        DefaultListModel modelo = new DefaultListModel();
        try {
            
        } catch (Exception e) {
        
        }
        return modelo;
    }
    
    private Connection connect() {
        // SQLite connection string
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        String url = "jdbc:sqlite:" + filePath+"\\Database\\PlantasHermanosArayaBD.db";
        System.out.println(url);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;       
    }
    
    public boolean deleteClient(int id){
        String query = "DELETE FROM Clientes WHERE ID = " + id;
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(query);
            return true;
        }
            catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean addClient(String name, String export, String direction, String telephone){
        String query = "INSERT INTO Clientes(Cliente, Exporte, Direccion, Telefono) values "
                + "(" + name + "," + export + "," + direction + "," + telephone +")";
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(query);
            return true;
        }
            catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public DefaultListModel getClientList(){
        String query = "SELECT * FROM Clientes";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                int clientId = rs.getInt("ID");
                String clientName = rs.getString("Cliente");
                model.addElement(clientId + ") " + clientName);
            }
            return model;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public DefaultListModel getNotificationList(int client){
        String query = "select Notificar_a.ID,Notificar_a.Nombre, Notificar_a.Direccion, Notificar_a.Telefono, Notificar_a.Email " +
                       "from Clientes inner join Notificar_a "+ "on Clientes.ID = Notificar_a.Notifica_a where Clientes.ID = " + client;
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                int clientId = rs.getInt("ID");
                String clientName = rs.getString("Nombre");
                model.addElement(clientId + ") " + clientName);
            }
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
