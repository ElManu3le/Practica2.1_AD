package Practica2.Practica2;

import javax.persistence.*;

@Entity
@Table(name = "pedido")

public class Pedido {

    @Id
    @Column(name = "codigo_pedido")
    private int codigo_pedido;

    @Column(name = "fecha_pedido")
    private String fecha_pedido;

    @Column(name = "fecha_esperada")
    private String fecha_esperada;

    @Column(name = "fecha_entrega")
    private String fecha_entrega;

    @Column(name = "estado")
    private String estado;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "codigo_cliente")
    private int codigo_cliente;

    public Pedido() {
        
    }

    public Pedido(int codigo_pedido, String fecha_pedido, String fecha_esperada, String fecha_entrega, String estado,
            String comentarios, int codigo_cliente) {
        this.codigo_pedido = codigo_pedido;
        this.fecha_pedido = fecha_pedido;
        this.fecha_esperada = fecha_esperada;
        this.fecha_entrega = fecha_entrega;
        this.estado = estado;
        this.comentarios = comentarios;
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(int codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getFecha_esperada() {
        return fecha_esperada;
    }

    public void setFecha_esperada(String fecha_esperada) {
        this.fecha_esperada = fecha_esperada;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    @Override
    public String toString() {
        return "Pedido [codigo_cliente=" + codigo_cliente + ", codigo_pedido=" + codigo_pedido + ", comentarios="
                + comentarios + ", estado=" + estado + ", fecha_entrega=" + fecha_entrega + ", fecha_esperada="
                + fecha_esperada + ", fecha_pedido=" + fecha_pedido + "]";
    }

}