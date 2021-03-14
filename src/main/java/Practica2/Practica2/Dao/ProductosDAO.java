package Practica2.Practica2.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Practica2.Practica2.HibernateUtil;
import Practica2.Practica2.Leer;
import Practica2.Practica2.Producto;

public class ProductosDAO implements Dao<Producto> {

    Session session;
    Producto productoDAO = new Producto();

    @Override
    public Producto get(long id) {
        session = HibernateUtil.geeSession();

        System.out.println("Dime el id del cliente para buscarlo");
        productoDAO = session.find(Producto.class, Leer.pedirEnteroValidar());
        System.out.println("Productos founded");
        System.out.println(productoDAO);
        return productoDAO;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        session = HibernateUtil.geeSession();
        Query q = session.createQuery("select e from Producto e order by codigo_producto");
        List<Producto> todosLosProductos = q.getResultList();
        for (Producto producto : todosLosProductos) {
            System.out.println(producto);
        }
        return todosLosProductos;
    }

    @Override
    public void save(Producto t) throws Exception {
        session = HibernateUtil.geeSession();

        productoDAO = new Producto();

        System.out.println("Codigo del producto");
        int codigo_producto = Leer.pedirEnteroValidar();/**
                                                         * el .pediCadena no hara falta hacer un Scanner teclado= new
                                                         * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
                                                         */

        System.out.println("Dime el nombre del producto");
        String nombre_producto = Leer.pedirCadena();

        System.out.println("Dime la gamma del producto");
        String gama = Leer.pedirCadena();

        System.out.println("Dime las dimensiones del producto");
        String dimensiones = Leer.pedirCadena();

        System.out.println("Dime el proveedor");
        String proveedor = Leer.pedirCadena();

        System.out.println("Dime una descripcion");
        String descripcion = Leer.pedirCadena();

        System.out.println("Dime la cantidad de Stock");
        int cantidad_en_stock = Leer.pedirEnteroValidar();

        System.out.println("Dime los comentarios");
        Float precio_venta = Leer.pedirFloat();

        System.out.println("Dime el precio del proveedor");
        Float precio_proveedor = Leer.pedirFloat();

        productoDAO.setCodigo_producto(codigo_producto);
        productoDAO.setNombre_producto(nombre_producto);
        productoDAO.setGama(gama);
        productoDAO.setDimensiones(dimensiones);
        productoDAO.setProveedor(proveedor);
        productoDAO.setDescripcion(descripcion);
        productoDAO.setCantidad_en_stock(cantidad_en_stock);
        productoDAO.setPrecio_venta(precio_venta);
        productoDAO.setPrecio_proveedor(precio_proveedor);

        session.getTransaction().begin();
        session.persist(productoDAO);
        session.getTransaction().commit();

    }

    
    public void update(Producto productoUpdate) {
        session = HibernateUtil.geeSession();

        Transaction transaction = session.beginTransaction();
		
		System.out.println("Dime el id del producto para modificarlo");
		productoUpdate = session.find(Producto.class, Leer.pedirCadena());
		
		productoUpdate = session.load(Producto.class, session);
		
		// PEDIMOS LOS DATOS PARA ACTUALIZAR EL PRODUCTO
		System.out.println("Nuevo nombre del producto");
		productoUpdate.setNombre_producto(Leer.pedirCadena());
		
		System.out.println("Nueva gama del producto: ");
		String nuevaGama = Leer.pedirCadena();
		if (nuevaGama.equalsIgnoreCase("")) {
			nuevaGama = productoUpdate.getGama();
		}
		productoUpdate.setGama(nuevaGama);

		System.out.println("Nuevas dimensiones del producto: ");
		String nuevasDimensiones = Leer.pedirCadena();
		if (nuevasDimensiones.equalsIgnoreCase("")) {
			nuevasDimensiones = productoUpdate.getDimensiones();
		}
		productoUpdate.setDimensiones(nuevasDimensiones);

		System.out.println("Nuevo proveedor del producto: ");
		String nuevoProveedor = Leer.pedirCadena();
		if (nuevoProveedor.equalsIgnoreCase("")) {
			nuevoProveedor = productoUpdate.getProveedor();
		}
		productoUpdate.setProveedor(nuevoProveedor);

		System.out.println("Nueva descripcion del producto: ");
		String nuevaDescripcion = Leer.pedirCadena();
		if (nuevaDescripcion.equalsIgnoreCase("")) {
			nuevaDescripcion = productoUpdate.getDescripcion();
		}
		productoUpdate.setDescripcion(nuevaDescripcion);

		System.out.println("Nueva cantidad en stock del producto: ");
		productoUpdate.setCantidad_en_stock(Leer.pedirEnteroValidar());

		System.out.println("Nuevo precio de venta del producto: ");
		productoUpdate.setPrecio_venta(Leer.pedirFloat());

		System.out.println("Nuevo precio de proveedor del producto: ");
		productoUpdate.setPrecio_proveedor(Leer.pedirFloat());
		
		session.update(productoUpdate);
		transaction.commit();
		System.out.println("Producto actualizado");

        

    }

    @Override
    public void delete(Producto t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Producto t, String[] params) {
        // TODO Auto-generated method stub
        
    }

}
