/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Baxi
 */
public class Client {
    public String client;
    public String exporte;
    public String direccion;
    public String telefono;
    public String email;

    public Client() {
    }
    
    public Client(String client, String exporte, String direccion, String telefono, String email) {
        this.client = client;
        this.exporte = exporte;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getExporte() {
        return exporte;
    }

    public void setExporte(String exporte) {
        this.exporte = exporte;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "client=" + client + ", exporte=" + exporte + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
    
    
    
}
