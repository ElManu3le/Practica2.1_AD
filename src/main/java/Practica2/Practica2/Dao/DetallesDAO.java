package Practica2.Practica2.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Practica2.Practica2.HibernateUtil;
import Practica2.Practica2.Leer;

import Practica2.Practica2.Detalles;

public class DetallesDAO implements Dao<Detalles> {

    Session session;
    Detalles detalleDAO = new Detalles();

    @Override
    public Detalles get(long id) {
        session = HibernateUtil.geeSession();

        System.out.println("Dime el id del cliente para buscarlo");
        detalleDAO = session.find(Detalles.class, Leer.pedirEnteroValidar());
        System.out.println("Detalles founded");
        System.out.println(detalleDAO);
        return detalleDAO;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Detalles> getAll() throws Exception {
        session = HibernateUtil.geeSession();
        System.out.println("Inserta el id del cliente para ver sus pedidos");
        int id = Leer.pedirEnteroValidar();

        Query q = session.createQuery(
                "select e from Detalles e where codigo_pedido in ( select codigo_pedido from Pedido where codigo_cliente= "
                        + id + " group by codigo_pedido");
        Query q2 = session.createQuery(
                "select sum(cantidad*precio_unidad) as total from Detalles e where codigo_pedido in ( select codigo_pedido from Pedido where codigo_cliente = "
                        + id + ")");

        List<Detalles> todosLosDetallesPedidos = q.getResultList();
        List<Detalles> sumaDetallesPedidos = q2.getResultList();

        System.out.println("La suma total es:" + sumaDetallesPedidos);

        return todosLosDetallesPedidos;
    }

    @Override
    public void save(Detalles t) throws Exception {
        session = HibernateUtil.geeSession();

        detalleDAO = new Detalles();

        System.out.println("Codigo de cliente nuevo");
        int cod_pedido = Leer.pedirEnteroValidar();/**
                                                    * el .pediCadena no hara falta hacer un Scanner teclado= new
                                                    * Scanner(Sysmten.in) ya que ya te piede una cadena ?? int
                                                    */

        System.out.println("Dime el nombre del nuevo cliente");
        int cod_producto = Leer.pedirEnteroValidar();

        System.out.println("Dime el nombre del nuevo contacto");
        int cantidad = Leer.pedirEnteroValidar();

        System.out.println("Dime el apllido del nuevo contacto");
        int udcost = Leer.pedirEnteroValidar();

        System.out.println("Dime el telefono");
        int numlinea = Leer.pedirEnteroValidar();

        detalleDAO.setCod_producto(cod_producto);
        detalleDAO.setCod_pedido(cod_pedido);
        detalleDAO.setCantidad(cantidad);
        detalleDAO.setUdcost(udcost);
        detalleDAO.setNumlinea(numlinea);

        session.getTransaction().begin();
        session.persist(detalleDAO);
        session.getTransaction().commit();

    }

    @Override
    public void update(Detalles t, String[] params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Detalles t) {
        // TODO Auto-generated method stub

    }

}
