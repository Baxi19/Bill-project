/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.math.BigDecimal;

/**
 *
 * @author Baxi
 */
public class Item {
    public int box;
    public int quantity;
    public String description;
    public String spec;
    public int size;
    public String priceUnit;
    public BigDecimal total;

    public Item() {
    }

    public Item(int box, int quantity, String description, String spec, int size, String priceUnit, BigDecimal  total) {
        this.box = box;
        this.quantity = quantity;
        this.description = description;
        this.spec = spec;
        this.size = size;
        this.priceUnit = priceUnit;
        this.total = total;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal  getTotal() {
        return total;
    }

    public void setTotal(BigDecimal  total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "\nCajas: " + box + "\nCantidad: " + quantity + 
                "\nDescripción: " + description + "\nSpec: " + spec + "\nTamaño: " + size + "\nPrecio unitario: " + priceUnit + "\nTotal de Item: " + total;
    }
    
    
}
