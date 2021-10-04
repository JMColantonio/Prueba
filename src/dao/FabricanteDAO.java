package dao;

import entidades.Fabricante;
import entidades.Producto;
import java.util.ArrayList;

public class FabricanteDAO extends DAO {

    public ArrayList<Fabricante> listarFabricantes() {

        ArrayList<Fabricante> fabricantes = new ArrayList();
        try {
            String query = "SELECT codigo, nombre FROM fabricante";
            consultarBd(query);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));

                fabricantes.add(fabricante);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            desconectarBd();
        }
        return fabricantes;
    }
}
