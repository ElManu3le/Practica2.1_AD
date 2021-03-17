package Practica2.Practica2.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Practica2.Practica2.Cliente;
import Practica2.Practica2.HibernateUtil;
import Practica2.Practica2.Leer;

public class ClienteDAO implements Dao<Cliente> {

    Session session;
    Cliente clienteDAO = new Cliente();

    @Override
    public Cliente get(long id) {

        session = HibernateUtil.geeSession();

        System.out.println("Dime el id del cliente para buscarlo");
        clienteDAO = session.find(Cliente.class, Leer.pedirEnteroValidar());
        System.out.println("Cliente founded");
        System.out.println(clienteDAO);
        return clienteDAO;

    }

    @Override
    public List<Cliente> getAll() throws Exception {
        session = HibernateUtil.geeSession();
        Query q = session.createQuery("select e from Cliente e order by nombre_cliente");
        List<Cliente> todosLosClientes = q.getResultList();
        for (Cliente cliente : todosLosClientes) {
            System.out.println(cliente);
        }
        return todosLosClientes;
    }

    @Override
    public void save(Cliente t) throws Exception {
        session = HibernateUtil.geeSession();

        session.getTransaction().begin();
        session.persist(t);
        session.getTransaction().commit();

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Cliente> buscar() {
        session = HibernateUtil.geeSession();
        System.out.println("Dime el nombre, el contacto o el apellido del cliente");
        String busqueda = Leer.pedirCadena();
        Query q = session.createQuery(
                "select e from Cliente e where nombre_cliente = '" + busqueda + "'" + " or nombre_contacto = '"
                        + busqueda + "' or apellido_contacto = '" + busqueda + "' order by nombre_cliente");
        List<Cliente> todosLosClientes = q.getResultList();
        for (Cliente cliente : todosLosClientes) {
            System.out.println(cliente);
        }
        return todosLosClientes;
    }

    @Override
    public void update(Cliente t, String[] params) {

    }

    @Override
    public void delete(Cliente t) {

    }

}
