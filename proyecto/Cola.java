package proyecto;
import java.util.ArrayList;
import java.util.List;

public class Cola{
	List<String> cola = new ArrayList<>();
	
	public List<String> añadir(String simbolo){ 
		cola.add(simbolo);
		return cola;
	}
	
	public List<String> eliminar(int posicion){
		cola.remove(posicion);
		return cola;
	}
	
}
