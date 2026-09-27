package proyecto;
import java.util.HashMap;

public class NotacionPolacaInversa {

	public Cola polaca_inversa(String cadena_inicial) {
		if(cadena_inicial.isEmpty()) {
			throw new IllegalArgumentException("Valores no ingresados");
		}
		Pila pila = new Pila();
		Cola cola = new Cola();
		String buffer = "";

		String[] simbolos = cadena_inicial.split("");

		for(String i : simbolos) {

			if(i.equals("(")) {
				pila.añadir(i);
				buffer = "";
				continue;
			}
			else if(i.equals(")")) {
				while(!pila.getUltimoSimbolo().equals("(")) {
					if(pila.pila.isEmpty()) {
						throw new IllegalArgumentException("Paréntesis Faltante");
					}
					pila.pasarACola(pila, cola);
				}
				pila.eliminar(pila.pila.size()-1);
				buffer = "";
				continue;
			}

			if(esNumero(i)) {
				if(!buffer.isEmpty()) {
					buffer = buffer.concat(i);
					cola.eliminar(cola.cola.size()-1);
				} else {
					buffer = i;
				}
				cola.añadir(buffer);
				continue;
			}

			if(i.equals(".")) {
				if(!esNumero(buffer)) {
					throw new IllegalArgumentException("Punto decimal mal colocado");
				}
				buffer = buffer.concat(i);
				cola.eliminar(cola.cola.size()-1);
				cola.añadir(buffer);
				continue;
			}
			
			int prioridad = mayorPrioridad(i, pila.getUltimoSimbolo());
			if(prioridad == 1) {
				pila.añadir(i);
			} else {
				pila.vaciarHastaPrioridad(i, cola.cola);
				pila.añadir(i);
			}
			buffer = "";
		}

		for(String i : pila.pila) {
			if(i.equals("(")) {
				throw new IllegalArgumentException("Paréntesis Faltante");
			}
		}
		pila.vaciarEnCola(pila, cola);
		return cola;
	}

	public static boolean esNumero(String texto) {
		try {
			Integer.parseInt(texto);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static int mayorPrioridad(String simbolo, String ultimoSimbolo) {
		HashMap<String, Integer> p = new HashMap<>();
		p.put("+", 0); p.put("-", 0); p.put("*", 1); p.put("/", 1); p.put("^", 2); p.put("#", 3);
		if(p.getOrDefault(simbolo, -1) > p.getOrDefault(ultimoSimbolo, -1)) {
			return 1;
		} else {
			return 0;
		}
	}

	public static boolean esAsociativoDerecha(String simbolo) {
		return simbolo.equals("^") || simbolo.equals("#");
	}

	public static boolean esNumeroCompleto(String texto) {
	    try {
	        Double.parseDouble(texto);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}