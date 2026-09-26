package proyecto;

public class Main {
    public static void main(String[] args) {
        String expresion = "2+";
        String resultado = ConexionCalculadora.procesar(expresion);
        System.out.println("Resultado: " + resultado);
    }
}
