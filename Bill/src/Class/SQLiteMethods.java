/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Baxi
 */
public class SQLiteMethods {
    public static SQLiteMethods instance = null;
    
    public static SQLiteMethods getInstance() {
        if (instance == null) {
            return instance = new SQLiteMethods();
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
            rs.close();
            stmt.close();
            conn.close();
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
        String query = "UPDATE Clientes SET Activo = 'F' WHERE ID = " + id;
        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            conn.close();
            return true;
        }
            catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public String addClient(String name, String export, String direction, String telephone){
        String query = "INSERT INTO Clientes(Cliente, Exporte, Direccion, Telefono, Activo) values "
                + "('" + name  + "' , '" + export + "', '" + direction + "', '" + telephone +"' , 'T')";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return "Registro de cliente realizado con éxito";
        }
        catch (SQLException e) {
            return e.getMessage();
        }  
    }
    
    public void addEmail(int id, String email){
        String query = "INSERT INTO Emails(Cliente, Email) VALUES"
                + "(" + id + ", '" + email + "')";
    }
    
     public String addNotifyTo(String name,String direction, String telephone,String email, int Cliente_id){
        String query = "INSERT INTO Notificar_a(Nombre, Direccion, Telefono, Email, Notifica_a) values "
                + "('" + name  + "' , '" + direction + "', '" + telephone +"' , '"+ email + "', " + Cliente_id + ")";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return "Registro de notificado realizado con éxito";
        }
        catch (SQLException e) {
            return e.getMessage();
        }  
    }
    
    public DefaultListModel getClientList(){
        String query = "SELECT * FROM Clientes WHERE Activo = 'T'";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                int clientId = rs.getInt("ID");
                String clientName = rs.getString("Cliente");
                model.addElement(clientId + ") " + clientName);
            }
            rs.close();
            stmt.close();
            conn.close();
            return model;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void getClient(int idBuscado){
        String query = "SELECT * FROM Clientes WHERE ID = " + idBuscado;
        try (          
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            while (rs.next()) {
                Methods.getInstance().client.setClient(rs.getString("Cliente"));
                Methods.getInstance().client.setExporte(rs.getString("Exporte"));
                Methods.getInstance().client.setDireccion(rs.getString("Direccion"));
                Methods.getInstance().client.setTelefono(rs.getString("Telefono"));
                Methods.getInstance().client.setEmail(getEmails(idBuscado));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getNotifyTo(int idNotify){
        String query = "SELECT * FROM Notificar_a WHERE Notifica_a = " + idNotify;
        try (
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            while (rs.next()) {
                Methods.getInstance().clientNotify.setClient(rs.getString("Nombre"));
                Methods.getInstance().clientNotify.setExporte("");
                Methods.getInstance().clientNotify.setDireccion(rs.getString("Direccion"));
                Methods.getInstance().clientNotify.setEmail(rs.getString("Email"));
                Methods.getInstance().clientNotify.setTelefono(rs.getString("Telefono"));
            }
            rs.close();
            stmt.close();
            conn.close();
    
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
            rs.close();
            stmt.close();
            conn.close();
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
            rs.close();
            stmt.close();
            conn.close();
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
            rs.close();
            stmt.close();
            conn.close();
            return priceList;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
    
    public String getEmails(int idClient){
        String query = "SELECT * FROM Emails WHERE Cliente = " + idClient;
        String emails = "";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            while (rs.next()) {
                if(emails.length() == 0){
                    emails += rs.getString("Email"); 
                }
                else{
                    emails += "\n" + rs.getString("Email"); 
                }
            }
            rs.close();
            stmt.close();
            conn.close();
            return emails;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return " - ";  // No posee emails registrados en el sistema
        }
    }
    
   public DefaultListModel getPortsList(){
        String query = "SELECT * FROM Puertos WHERE Activo = 'T'";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getInt("ID") + ") "+ rs.getString("Nombre"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
   

   
   public DefaultListModel getCountriesList(){
        String query = "SELECT * FROM Paises WHERE Activo = 'T'";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getInt("ID") + ") "+ rs.getString("Nombre"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
   
   public boolean deleteCountry(int id){
       String query = "UPDATE Paises SET Activo = 'F' WHERE ID = " + id;
       try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            conn.close();
            return true;
        }
            catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
   
        }
    }

    public boolean deletePort(int id) {
        String query = "UPDATE Puertos SET Activo = 'F' WHERE ID = " + id;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public String addPort(String name){
        String query = "INSERT INTO Puertos(Nombre) values "
                + "('" + name + "')";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return "Registro de puerto " + name + " realizado con éxito";
        }
        catch (SQLException e) {
            return e.getMessage();
        }  
    }
    
     public String addCountry(String name) {
        String query = "INSERT INTO Paises(Nombre) values "
                + "('" + name + "')";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return "Registro de pais " + name + " realizado con éxito";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
     public DefaultListModel getNotifyToList(){
        String query = "SELECT * FROM Notificar_a WHERE Activo = 'T'";
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getInt("ID") + ") "+ rs.getString("Nombre"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return model;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
    }
     
    private int getPlantID(String description, int height){
        String query = "SELECT ID FROM Plantas WHERE Descripcion = '"+ description + "' AND Altura = " + height;
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(query)){
            int id = 0;
            while (rs.next()) {
                id = rs.getInt("ID");
            }
            rs.close();
            stmt.close();
            conn.close();
            return id;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } 
    }
    
    public String addPrice(String plantName, int height, double price){
        int plantId = getPlantID(plantName, height);
        String query = "INSERT INTO Precios(" + price + "," + plantId + ")";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();         
            pstmt.close();
            conn.close();
            return "Registro de precio realizado con éxito";
        }
        catch (SQLException e) {
            return e.getMessage();
        }  
    }
   
     public boolean deleteNotifyTo(int id) {
        String query = "UPDATE Notificar_a SET Activo = 'F' WHERE ID = " + id;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}