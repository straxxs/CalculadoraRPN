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
		String ultimoToken = ""; 

		String[] simbolos = cadena_inicial.split("");

		for(String i : simbolos) {

			if(i.equals("(")) {
				pila.añadir(i);
				buffer = "";
				ultimoToken = "(";
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
				ultimoToken = ")";
				continue;
			}

			if(i.equals("-") && buffer.isEmpty() &&
			(ultimoToken.isEmpty() || ultimoToken.equals("(") || esOperador(ultimoToken))) {
				if(ultimoToken.equals("^") || ultimoToken.equals("#")) {
					buffer = "-";
					cola.añadir(buffer);
					ultimoToken = "numero";
				} else {
					int prioridadSigno = mayorPrioridad("neg", pila.getUltimoSimbolo());
					if(prioridadSigno == 1) {
						pila.añadir("neg");
					} else {
						pila.vaciarHastaPrioridad("neg", cola.cola);
						pila.añadir("neg");
					}
					buffer = "";
					ultimoToken = "-";
				}
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
				ultimoToken = "numero";
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
			ultimoToken = i;

		}

		for(String i : pila.pila) {
			if(i.equals("(")) {
				throw new IllegalArgumentException("Paréntesis Faltante");
			}
		}
		pila.vaciarEnCola(pila, cola);
		
		return cola;
	}

	private static boolean esOperador(String simbolo) {
		return simbolo.equals("+") || simbolo.equals("-") || simbolo.equals("*") ||
			simbolo.equals("/") || simbolo.equals("^") || simbolo.equals("#");
	}

	public static boolean esNumero(String texto) {
    	return texto != null && texto.matches("-?\\d+");
	}

	public static int mayorPrioridad(String simbolo, String ultimoSimbolo) {
		HashMap<String, Integer> p = new HashMap<>();
		p.put("+", 0); p.put("-", 0); p.put("*", 1); p.put("/", 1); p.put("neg", 2); p.put("^", 2); p.put("#", 2);
		if(p.getOrDefault(simbolo, -1) > p.getOrDefault(ultimoSimbolo, -1)) {
			return 1;
		} else {
			return 0;
		}
	}

	public static boolean esAsociativoDerecha(String simbolo) {
		return simbolo.equals("^") || simbolo.equals("#") || simbolo.equals("neg");
	}

	public static boolean esNumeroCompleto(String texto) {
	    return texto != null && texto.matches("-?\\d+(\\.\\d+)?");
	}
}