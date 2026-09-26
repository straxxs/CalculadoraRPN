package proyecto;

public class ConexionCalculadora {
    public static String procesar(String expresion) {
        NotacionPolacaInversa NPI = new NotacionPolacaInversa();
        Calculadora calc = new Calculadora();
        try {
        	Cola resultadoPolaca = NPI.polaca_inversa(expresion);
        	double resultado = calc.Calcular(resultadoPolaca);
            return String.valueOf(resultado);
    
        } catch(IllegalArgumentException e) {
        	String error = "Error: " + e.getMessage();
            return error;
        }
    }
}
/*CAMBIOS A REALIZAR EN LA CALCULADORA:
 * 1. EN VEZ DE HACER RAIZ HACEMOS TETRACIÓN "#"
 */
