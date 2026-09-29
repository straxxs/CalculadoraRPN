package proyecto;

public class PruebasCalculadora {

    public static void main(String[] args) {

        NotacionPolacaInversa npi = new NotacionPolacaInversa();
        Calculadora calculadora = new Calculadora();

        int correctas = 0;
        int incorrectas = 0;

        // Expresión, resultado esperado
        String[][] pruebas = {
            // === GRUPO NUEVO 1: BÁSICAS CON NEGATIVOS ===
            {"-5+3", "-2.0"},
            {"-5-3", "-8.0"},
            {"-5*3", "-15.0"},
            {"-5/3", "-1.6666666666666667"},
            {"3+-5", "-2.0"},
            {"3*-5", "-15.0"},
            {"3/-5", "-0.6"},
            {"3--5", "8.0"},
            {"(-3+5)*2", "4.0"},

            // === GRUPO NUEVO 2: NEGATIVO ENVOLVIENDO POTENCIAS (debe cubrir toda la cadena) ===
            {"-3^2", "-9.0"},
            {"-3^2^2", "-81.0"},
            {"-2^3^2", "-512.0"},
            {"(-3)^2", "9.0"},
            {"-2.5^2", "-6.25"},

            // === GRUPO NUEVO 3: NEGATIVO COMO EXPONENTE PUNTUAL (pegado al número) ===
            {"2^-3", "0.125"},
            {"2^-2^3", "0.00390625"},
            {"5^-1", "0.2"},
            {"10^-2", "0.01"},

            // === GRUPO NUEVO 4: TETRACIÓN CON NEGATIVOS ===
            {"-2#2", "-4.0"},
            {"2#-2", "2.0"},
            {"-1*(3#2)", "-27.0"},
            {"(3#2)*-1", "-27.0"},
            {"-4#2/-4", "64.0"},

            // === GRUPO NUEVO 5: DECIMALES Y COMBINACIONES ===
            {"3.5/-2", "-1.75"},
            {"-3.5/-2", "1.75"},
            {"-2*3+4*-5", "-26.0"},
            {"(-2+3)*(-4+5)", "1.0"},
            {"-2^2+-3^2", "-13.0"},
            {"10/-2/-5", "1.0"},
            {"-1.5*(-2+4)^2", "-6.0"},
            {"((-2)^2-4)*-3", "0.0"},
            {"2^2^2^-1", "2.665144142690225"},
        };

        for (String[] prueba : pruebas) {

            String expresion = prueba[0];
            String esperado = prueba[1];

            try {
                Cola cola = npi.polaca_inversa(expresion);
                String resultado = calculadora.Calcular(cola);

                if (sonIguales(resultado, esperado)) {
                    System.out.println("OK   | " + expresion + " = " + resultado);
                    correctas++;
                } else {
                    System.out.println("ERROR| " + expresion);
                    System.out.println("     Esperado: " + esperado);
                    System.out.println("     Obtenido: " + resultado);
                    incorrectas++;
                }

            } catch (Exception e) {
                System.out.println("ERROR| " + expresion);
                System.out.println("     Excepción: " + e.getMessage());
                incorrectas++;
            }
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("Pruebas correctas:   " + correctas);
        System.out.println("Pruebas incorrectas: " + incorrectas);
        System.out.println("================================");
    }

    private static boolean sonIguales(String resultado, String esperado) {

        try {
            double numResultado = Double.parseDouble(resultado);
            double numEsperado = Double.parseDouble(esperado);

            return Math.abs(numResultado - numEsperado) < 0.0000000001;

        } catch (NumberFormatException e) {
            // Para números demasiado grandes que no conviene comparar como double
            return resultado.equals(esperado);
        }
    }
}