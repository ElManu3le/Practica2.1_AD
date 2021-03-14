package Practica2.Practica2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_pedido")
public class Detalles {

    @Id
    @Column(name = "codigo_pedido", insertable = false, updatable = false)
    private int cod_pedido;

    @Column(name = "codigo_producto")
    private int cod_producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unidad")
    private float udcost;

    @Column(name = "numero_linea")
    private int numlinea;

    public Detalles() {
        
    }

    public Detalles(int cod_pedido, int cod_producto, int cantidad, float udcost, int numlinea) {
        this.cod_pedido = cod_pedido;
        this.cod_producto = cod_producto;
        this.cantidad = cantidad;
        this.udcost = udcost;
        this.numlinea = numlinea;
    }

    @Override
    public String toString() {
        return "Detalles_pedido [cantidad=" + cantidad + ", cod_pedido=" + cod_pedido + ", cod_producto=" + cod_producto
                + ", numlinea=" + numlinea + ", udcost=" + udcost + "]";
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getUdcost() {
        return udcost;
    }

    public void setUdcost(float udcost) {
        this.udcost = udcost;
    }

    public int getNumlinea() {
        return numlinea;
    }

    public void setNumlinea(int numlinea) {
        this.numlinea = numlinea;
    }

}