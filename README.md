# Calculadora RPN (Notación Polaca Inversa)

Una calculadora de escritorio desarrollada en Java Swing que evalúa expresiones matemáticas mediante Notación Polaca Inversa (RPN). Cuenta con una interfaz gráfica personalizada de estética oscura y soporte para hiperoperaciones de crecimiento rápido como la tetración.


## Qué es la RPN

En la notación tradicional los operadores van entre los operandos y hacen falta paréntesis y reglas de precedencia: `(3 + 4) * 2`. En RPN el operador va después de los operandos, por lo que se evalúa de izquierda a derecha sin ambigüedades:

* Infija: `(3 + 4) * 2`
* RPN: `3 4 + 2 *`

La calculadora convierte internamente lo que el usuario ingresa a RPN y lo resuelve con una pila, sin necesidad de manejar precedencias por separado.


## Características Principales

* **Diseño Moderno:** Interfaz oscura con botones diferenciados por color según su función.
* **Display Claro:** Alineado a la derecha, muestra el resultado o el error correspondiente.
* **Motor Propio:** Conversión y evaluación en RPN con estructuras de pila y cola hechas desde cero.
* **Manejo de Errores:** Detecta paréntesis faltantes, división por cero y expresiones inválidas.
* **Portabilidad:** Distribuible como un único `.jar` ejecutable.


## Tetración (#)

Además de suma, resta, multiplicación, división y potencia, incluye tetración, representada como $^{b}a$ y en la interfaz con el botón `#`.

* Entrada: `3 # 3`
* Operación interna: $3^{3^3} = 3^{27}$

Al igual que la potencia, es asociativa por derecha.


## Cómo Descargar y Ejecutar

Solo hace falta tener Java instalado.

1. Andá a **Releases**: `https://github.com/straxxs/CalculadoraRPN/releases`.
2. Descargá el `.jar` de la última versión.
3. Ejecutalo con doble clic, o desde terminal:
   \`\`\`
   java -jar CalculadoraRPN.jar
   \`\`\`

