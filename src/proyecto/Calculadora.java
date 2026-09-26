package proyecto;

public class Calculadora {
	public double Calcular(Cola cola) {
		Pila pila = new Pila();
		if(cola.cola.isEmpty()) {
	        throw new IllegalArgumentException("Cola vacía");
	    }
		for(String i : cola.cola) {
			if(NotacionPolacaInversa.esNumeroCompleto(i)) {
				pila.añadir(i);
			}else {
				if(pila.pila.size()<2) {throw new IllegalArgumentException("Calculo Invalido");}
				double num1 = Double.parseDouble(pila.pila.get(pila.pila.size()-2));
				double num2 = Double.parseDouble(pila.pila.get(pila.pila.size()-1));
				double res = switch(i) {
					case "+" -> num1 + num2;
				    case "-" -> num1 - num2;
				    case "*" -> num1 * num2;
				    case "/" -> {
				    	if(num2 == 0) {
				    		throw new IllegalArgumentException("División por cero");
				    	}
				    	yield num1 / num2;
				    }
				    case "^" -> Math.pow(num1, num2);
				    case "#" -> {
				        long base = (long) num1; 
				        long altura = (long) num2;
				        
				        yield (double) calcularTetracion(base, altura);
				    }
				    default -> throw new IllegalArgumentException("Operador no válido: " + i);
				};
				pila.eliminar(pila.pila.size()-2);
				pila.eliminar(pila.pila.size()-1);
				pila.añadir(String.valueOf(res));
			}
		}
		return Double.parseDouble(pila.pila.get(0));
	}
	public static long calcularTetracion(long base, long altura) {
	    if (altura == 0) return 1;
	    
	    long resultado = base;
	    for (long i = 1; i < altura; i++) {
	        resultado = (long) Math.pow(base, resultado);
	    }
	    return resultado;
	}

}
