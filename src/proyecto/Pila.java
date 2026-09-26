package proyecto;
import java.util.ArrayList;
import java.util.List;

public class Pila{
	List<String> pila = new ArrayList<>();
	
	
	public List<String> añadir(String simbolo){ 
		pila.add(simbolo);
		return pila;
	}

	public List<String> eliminar(int posicion){
		pila.remove(posicion);
		return pila;
	}
	
	public List<String> vaciarEnCola(Pila pila, Cola cola){
	    while(!pila.pila.isEmpty()) {
	        pasarACola(pila,cola);
	    }
	    return cola.cola;
	}
	public List<String> pasarACola(Pila pila, Cola cola){
		cola.añadir(pila.getUltimoSimbolo());
        pila.eliminar(pila.pila.size()-1);
        
        return cola.cola;
	}
	
	public List<String> vaciarHastaPrioridad(String simboloNuevo, List<String> cola){
	    while(!pila.isEmpty() && debeVaciar(simboloNuevo)) {
	        cola.add(getUltimoSimbolo());
	        eliminar(pila.size()-1);
	    }
	    return cola;
	}

	private boolean debeVaciar(String simboloNuevo) {
	    String tope = getUltimoSimbolo();
	    int prioridadNuevo = NotacionPolacaInversa.mayorPrioridad(simboloNuevo, tope);
	    int prioridadTope = NotacionPolacaInversa.mayorPrioridad(tope, simboloNuevo);

	    if(NotacionPolacaInversa.esAsociativoDerecha(simboloNuevo)) {
	        return prioridadTope == 1;
	    } else {
	        return prioridadTope == 1 || (prioridadNuevo == 0 && prioridadTope == 0);
	    }
	}
	
	public List<String> vaciar(List<String> pila){
		while(!pila.isEmpty()) {
			pila.remove(pila.size()-1);
		}
		return pila;
	}
	
	public String getUltimoSimbolo(){
		if (pila.size()>0) {
			return pila.get(pila.size()-1);
		}
		return "";
	}
	
}
