package dao;

import entidades.Producto;
import java.util.ArrayList;

public class ProductoDAO extends DAO {

    public ArrayList<Producto> listarProductos() {

        ArrayList<Producto> productos = new ArrayList();
        try {
            String query = "SELECT codigo, nombre, precio, codigo_fabricante FROM producto";
            consultarBd(query);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBd();
        }
        return productos;
    }

    public ArrayList<Producto> listarProductosPortatiles() {

        ArrayList<Producto> productos = new ArrayList();
        try {
            String query = "SELECT codigo, nombre, precio, codigo_fabricante FROM producto WHERE nombre LIKE '%portatil%'";
            consultarBd(query);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBd();
        }
        return productos;
    }

    public void ingresarProducto(String sql) {

        try {
            String query = sql;
            insertarModificarEliminar(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

}
