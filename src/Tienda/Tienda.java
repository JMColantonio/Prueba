package Tienda;

import Service.FabricanteService;
import Service.ProductoService;

public class Tienda {

    public static void main(String[] args) {

        ProductoService ps = new ProductoService();
        FabricanteService fs = new FabricanteService();

//        ps.mostrarProductos();
//        ps.mostrarNombreYprecio();
//        ps.mostrarProductoEnRangoDePrecio();
//        ps.productoPortatiles();
//        ps.productoMasBarato();
          ps.ingresarProducto();
    }

}
