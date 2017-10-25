/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textodelimitado;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oracle
 */
public class Product {
    
    private NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private String codigo;
    private String descripcion;
    private double precio;
    
    

    public Product() {
        codigo = "";
        descripcion = "";
        precio = 0;
    }

    public Product(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        
        return "Product{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + nf.format(precio) + '}';
    }

    
    
                 
                 
}
