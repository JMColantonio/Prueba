package Service;

import dao.ProductoDAO;
import entidades.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoService {
    
    Scanner sc = new Scanner (System.in);

    ProductoDAO pd = new ProductoDAO();

    ArrayList<Producto> productos = pd.listarProductos();

    public void mostrarProductos() {
        System.out.println("Se muestra la lista de productos");

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void mostrarNombreYprecio() {
        System.out.println("Se muestra el nombre y el precio de cada producto");

        for (Producto producto : productos) {
            System.out.println("");
            System.out.println(producto.getNombre());
            System.out.println(producto.getPrecio());
            System.out.println("");
        }
    }

    public void mostrarProductoEnRangoDePrecio() {
        System.out.println("Se muestra el nombre y el precio de los productos con precio entre 120$ y 202$");

        for (Producto producto : productos) {

            if (producto.getPrecio() > 120 && producto.getPrecio() < 202) {
                System.out.println("");
                System.out.println(producto.getNombre());
                System.out.println(producto.getPrecio());
                System.out.println("");
            }
        }
    }

    public void productoMasBarato() {
        System.out.println("Se muestra el nombre y el precio del producto mas barato de la tienda");
        double precioBajo = 0;
        for (Producto producto : productos) {
            if (producto.getPrecio() < precioBajo || precioBajo == 0) {
                precioBajo = producto.getPrecio();
            }
        }
        for (Producto producto : productos) {
            if (producto.getPrecio() == precioBajo) {
                System.out.println("");
                System.out.println(producto.getNombre());
                System.out.println(producto.getPrecio());
                System.out.println("");
            }
        }
    }

    public void productoPortatiles() {
        System.out.println("Se muestran todos los productos portatiles de la tienda");

        ArrayList<Producto> productosP = pd.listarProductosPortatiles();
        
        for (Producto producto : productosP) {
            System.out.println(producto);
        }
    }
    
    public void ingresarProducto(){
        System.out.println("Ingrese el nombre del producto");
        String producto = sc.next();
        System.out.println("Ingrese el precio del producto");
        Double precio = sc.nextDouble();
        System.out.println("Ingrese el codigo del fabricante");
        Integer fabricante = sc.nextInt();
        
        String sql = "   INSERT INTO producto (nombre,precio,codigo_fabricante) VALUES ( '" + producto + "'," + precio + "," + fabricante + ")";
        
        ProductoDAO pD = new ProductoDAO();
        pD.ingresarProducto(sql);
  
    }
           
}
