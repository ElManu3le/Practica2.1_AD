package Practica2.Practica2;

import Practica2.Practica2.Dao.ClienteDAO;
import Practica2.Practica2.Dao.DetallesDAO;
import Practica2.Practica2.Dao.PedidoDAO;
import Practica2.Practica2.Dao.ProductosDAO;

public class App {

    public static void main(String[] args) {

        try {
            HibernateUtil.setUp();
        } catch (Exception e) {

        }

        ClienteDAO mCliente = new ClienteDAO();
        Cliente cliente = new Cliente();

        PedidoDAO mPedido = new PedidoDAO();
        Pedido pedido = new Pedido();

        DetallesDAO mDetalles = new DetallesDAO();
        Detalles detalles = new Detalles();

        ProductosDAO mProducto = new ProductosDAO();
        Producto productos = new Producto();

        int opcion = 0;

        do {

            MenuT();
            System.out.print("Elige una opcion para realizar: ");
            opcion = Leer.pedirEnteroValidar();

            switch (opcion) {

            case 1:

                try {

                    cliente = guardarDatos();
                    mCliente.save(cliente); 

                    //mCliente.save(cliente);
                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                break;
            case 2:

                try {
                    mCliente.getAll();
                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println(e.getMessage());

                }

                break;

            case 3:
                try {

                    mCliente.get(opcion);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                break;
            case 4:

                try {
                    mCliente.buscar();

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                break;
            case 5:
                try {

                    mProducto.update(productos);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                break;
            case 6:

                try {
                    mDetalles.getAll();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());

                }
                break;

            default:
                break;
            }

        } while (opcion != 0);

        HibernateUtil.shutDown();

    }

    private static void MenuT() {
        System.out.println("\n1. Anyadir a un cliente nuevo \n" + "2. Mostrar a todos los clientes \n"
                + "3. Mostrar a un cliente (Use client_ID) \n"
                + "4. Buscar a un cliente (Introducir cadena para nombreCli,nombreCont,apellCont) \n"
                + "5. Editar un producto (Introduce producto ID) \n"
                + "6. Mostrar todos lo detalles de los pedidos \n");

    }

    private static Cliente guardarDatos(){

        System.out.println("Codigo de cliente nuevo");
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

        System.out.println("Dime el pais del cliente");
        String codigoEmpleadoPepVentas = Leer.pedirCadena();

        System.out.println("Dime el codigo postal cliente");
        String limiteCredito = Leer.pedirCadena();

        Cliente cliente;

        return new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto,
         telefono, fax, direccion1, ciudad, region, pais, codigo_postal, codigoEmpleadoPepVentas, limiteCredito);
       
            /*cliente = new Cliente(codigo_cliente, nombre_cliente, nombre_contacto, 
            apellido_contacto, telefono, fax, 
            direccion1, ciudad, region, 
            pais, codigo_postal, codigoEmpleadoPepVentas, limiteCredito);

            cliente.setCodigoCliente(codigo_cliente);
            cliente.setNombreCliente(nombre_cliente);
            cliente.setNombreContacto(nombre_contacto);
            cliente.setApellidoContacto(apellido_contacto);
            cliente.setTelefono(telefono);
            cliente.setFax(fax);
            cliente.setLineaDireccion1(direccion1);
            cliente.setCiudad(ciudad);
            cliente.setRegion(region);
            cliente.setPais(pais);
            cliente.setCodigoPostal(codigo_postal);*/



            

            

        

        /*clienteDAO.setCodigoCliente(codigo_cliente);
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

    }

}
