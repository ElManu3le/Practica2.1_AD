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

                    mCliente.save(cliente);
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
                + "5. Editar un producto (Introduce producto ID) \n" + "6. Mostrar todos lo detalles de los pedidos \n"
                + "7.  \n" + "8. \n" + "9. \n" + "10. \n");

    }

}
