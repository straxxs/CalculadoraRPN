package proyecto;

public class Main {
    public static void main(String[] args) {
        NotacionPolacaInversa NPI = new NotacionPolacaInversa();
        Calculadora calc = new Calculadora();
        try {
        	Cola resultadoPolaca = NPI.polaca_inversa("2+3+2+3+2+3+2+3+2+3+2+3+2+3+2+32+32+32+32+32+32+32+3");
        	double resultado = calc.Calcular(resultadoPolaca);
        	System.out.println(resultado);
    
        } catch(IllegalArgumentException e) {
        	System.out.println("Error: " + e.getMessage());
        }
    }
}
/*CAMBIOS A REALIZAR EN LA CALCULADORA:
 * 1. EN VEZ DE HACER RAIZ HACEMOS TETRACIÓN "#"
 */
