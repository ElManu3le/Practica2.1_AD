package Practica2.Practica2.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Practica2.Practica2.HibernateUtil;
import Practica2.Practica2.Leer;
import Practica2.Practica2.Pedido;

public class PedidoDAO implements Dao<Pedido> {

    Session session;
    Pedido pedidoDAO = new Pedido();

    @Override
    public Pedido get(long id) {
        session = HibernateUtil.geeSession();

        System.out.println("Dime el id del cliente para buscarlo");
        pedidoDAO = session.find(Pedido.class, Leer.pedirEnteroValidar());
        System.out.println("Cliente founded");
        System.out.println(pedidoDAO);
        return pedidoDAO;

    }

    @Override
    public List<Pedido> getAll() throws Exception {
        session = HibernateUtil.geeSession();
        Query q = session.createQuery("select e from Cliente e order by nombre_cliente");
        List<Pedido> todosLosPedidos = q.getResultList();
        for (Pedido pedido : todosLosPedidos) {
            System.out.println(pedido);
        }
        return todosLosPedidos;
    }

    @Override
    public void save(Pedido t) throws Exception {
        session = HibernateUtil.geeSession();

        pedidoDAO = new Pedido();

        System.out.println("Codigo de pedido nuevo");
        int codigo_pedido = Leer.pedirEnteroValidar();/**
                                                       * el .pediCadena no hara falta hacer un Scanner teclado= new
                                                       * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
                                                       */

        System.out.println("Dime la fecha del pedido");
        String fecha_pedido = Leer.pedirCadena();

        System.out.println("Dime la fecha esperada");
        String fecha_esperada = Leer.pedirCadena();

        System.out.println("Dime la fecha de entrega");
        String fecha_entrega = Leer.pedirCadena();

        System.out.println("Dime el estado");
        String estado = Leer.pedirCadena();

        System.out.println("Dime los comentarios");
        String comentarios = Leer.pedirCadena();

        System.out.println("Dime el codigo dee cliente");
        int codigo_cliente = Leer.pedirEnteroValidar();

        pedidoDAO.setCodigo_cliente(codigo_cliente);
        pedidoDAO.setCodigo_pedido(codigo_pedido);
        pedidoDAO.setFecha_pedido(fecha_pedido);
        pedidoDAO.setFecha_esperada(fecha_esperada);
        pedidoDAO.setFecha_entrega(fecha_entrega);
        pedidoDAO.setComentarios(comentarios);
        pedidoDAO.setEstado(estado);

        session.getTransaction().begin();
        session.persist(pedidoDAO);
        session.getTransaction().commit();

    }

    @Override
    public void update(Pedido t, String[] params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Pedido t) {
        // TODO Auto-generated method stub

    }

}
