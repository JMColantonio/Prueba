
package Service;

import dao.FabricanteDAO;
import entidades.Fabricante;
import java.util.ArrayList;

public class FabricanteService {
    
    FabricanteDAO fd = new FabricanteDAO();
    
    public void mostrarFabricantes(){
        System.out.println("Se muestran los fabricantes");
        
        ArrayList<Fabricante> fabricantes = fd.listarFabricantes();
        
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante);
        }
    }
    
}