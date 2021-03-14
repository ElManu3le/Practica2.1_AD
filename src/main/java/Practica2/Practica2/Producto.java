package Practica2.Practica2;

import javax.persistence.*;

//import org.hibernate.annotations.Entity;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "codigo_producto")
    private int codigo_producto;

    @Column(name = "nombre")
    private String nombre_producto;

    @Column(name = "gama")
    private String gama;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "proveedor")
    private String proveedor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad_en_stock")
    private int cantidad_en_stock;

    @Column(name = "precio_venta")
    private float precio_venta;

    @Column(name = "precio_proveedor")
    private float precio_proveedor;

    public Producto() {
    }

    public Producto(int codigo_producto, String nombre_producto, String gama, String dimensiones, String proveedor,
            String descripcion, int cantidad_en_stock, float precio_venta, float precio_proveedor) {
        this.codigo_producto = codigo_producto;
        this.nombre_producto = nombre_producto;
        this.gama = gama;
        this.dimensiones = dimensiones;
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidad_en_stock = cantidad_en_stock;
        this.precio_venta = precio_venta;
        this.precio_proveedor = precio_proveedor;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public void setCantidad_en_stock(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getPrecio_proveedor() {
        return precio_proveedor;
    }

    public void setPrecio_proveedor(float precio_proveedor) {
        this.precio_proveedor = precio_proveedor;
    }

    @Override
    public String toString() {
        return "Producto [cantidad_en_stock=" + cantidad_en_stock + ", codigo_producto=" + codigo_producto
                + ", descripcion=" + descripcion + ", dimensiones=" + dimensiones + ", gama=" + gama
                + ", nombre_producto=" + nombre_producto + ", precio_proveedor=" + precio_proveedor + ", precio_venta="
                + precio_venta + ", proveedor=" + proveedor + "]";
    }

}