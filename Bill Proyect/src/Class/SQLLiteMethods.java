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
import java.util.ArrayList;
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
    
    public DefaultListModel getUnitPrice(String plantName, int height){
        DefaultListModel model = new DefaultListModel();
        String query = " SELECT Precio FROM Plantas INNER JOIN Precios " +
                        " on Plantas.ID = Precios.Planta_id " +
                        " WHERE Plantas.Descripcion = '" + plantName + "' AND Plantas.Altura = " + height;
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            
            while (rs.next()) {
                //model.addElement(rs.getDouble("Precio"));
                model.addElement(rs.getString("Precio"));
            }
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            //return null;
        }  
        return model;
    }
    
    private Connection connect() {
        // SQLite connection string
        String filePath = new File("").getAbsolutePath();
        String url = "jdbc:sqlite:" + filePath+"\\Database\\PlantasHermanosArayaBD.db";
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
    
    public void getClient(int idBuscado){
        String query = "SELECT * FROM Clientes";
        try (
            
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            while (rs.next()) {
                int clientId = rs.getInt("ID");
                if(clientId == idBuscado){
                    Methods.getInstance().client.setClient(rs.getString("Cliente"));
                    Methods.getInstance().client.setExporte(rs.getString("Exporte"));
                    Methods.getInstance().client.setDireccion(rs.getString("Direccion"));
                    Methods.getInstance().client.setExporte(rs.getString("Telefono"));
                    Methods.getInstance().client.setExporte(rs.getString("Email"));
                }
 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getNotifyTo(int idClient){
        String query = "select Notificar_a.ID,Notificar_a.Nombre, Notificar_a.Direccion, Notificar_a.Telefono, Notificar_a.Email " +
                       "from Clientes inner join Notificar_a "+ "on Clientes.ID = Notificar_a.Notifica_a where Clientes.ID = " + idClient;
        try (
            
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            while (rs.next()) {
                int clientId = rs.getInt("ID");
                if(clientId == idClient){
                    Methods.getInstance().clientNotify.setClient(rs.getString("Cliente"));
                    Methods.getInstance().clientNotify.setExporte(rs.getString("Exporte"));
                    Methods.getInstance().clientNotify.setDireccion(rs.getString("Direccion"));
                    Methods.getInstance().clientNotify.setExporte(rs.getString("Telefono"));
                    Methods.getInstance().clientNotify.setExporte(rs.getString("Email"));
                }
 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    
    public DefaultListModel getPlantsList(){
        String query = "SELECT DISTINCT descripcion FROM Plantas";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getString("Descripcion"));
            }
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
    public ArrayList<Double> getPrice(int height){
        String query = "SELECT DISTINCT precio FROM Plantas INNER JOIN Precios " +
                       "on Plantas.ID = Precios.Planta_id WHERE Altura = " + height;
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            ArrayList<Double> priceList = new ArrayList<>();
            while (rs.next()) {
                priceList.add(rs.getDouble("Precio"));
            }
            return priceList;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
}