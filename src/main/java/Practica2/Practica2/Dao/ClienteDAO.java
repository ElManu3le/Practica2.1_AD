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

        //clienteDAO = new Cliente();

       
        /*System.out.println("Codigo de cliente nuevo");
        int codigo_cliente = Leer.pedirEnteroValidar();

        System.out.println("Dime el nombre del nuevo cliente");
        String nombre_cliente = Leer.pedirCadena();

        System.out.println("Dime el nombre del nuevo contacto");
        String nombre_contacto = Leer.pedirCadena();

        System.out.println("Dime el apllido del nuevo contacto");
        String apellido_contacto = Leer.pedirCadena();

        System.out.println("Dime el telefono");
        String telefono = Leer.pedirCadena();

        System.out.println("Dime el fax");
        String fax = Leer.pedirCadena();

        System.out.println("Dime la dirreción del cliente");
        String direccion1 = Leer.pedirCadena();

        System.out.println("Dime la ciudad");
        String ciudad = Leer.pedirCadena();

        System.out.println("Dime la region del cliente");
        String region = Leer.pedirCadena();

        System.out.println("Dime el pais del cliente");
        String pais = Leer.pedirCadena();

        System.out.println("Dime el codigo postal cliente");
        String codigo_postal = Leer.pedirCadena(); 

        clienteDAO.setCodigoCliente(codigo_cliente);
        clienteDAO.setNombreCliente(nombre_cliente);
        clienteDAO.setNombreContacto(nombre_contacto);
        clienteDAO.setApellidoContacto(apellido_contacto);
        clienteDAO.setTelefono(telefono);
        clienteDAO.setFax(fax);
        clienteDAO.setLineaDireccion1(direccion1);
        clienteDAO.setCiudad(ciudad);
        clienteDAO.setRegion(region);
        clienteDAO.setPais(pais);
        clienteDAO.setCodigoPostal(codigo_postal); */

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
