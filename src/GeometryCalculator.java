import java.util.Scanner;

/**
 * Programa de línea de comandos que actúa como una calculadora de área y perímetro
 * para figuras geométricas básicas como círculo, cuadrado, triángulo, rectángulo y pentágono.
 * Permite al usuario elegir la figura y la operación, solicitar los datos necesarios
 * y mostrar el resultado del cálculo.
 */
public class GeometryCalculator {
    // Constante para el valor de PI, utilizada en los cálculos de círculo.
    private static final double PI = 3.1416;

    /**
     * Método principal para ejecutar la calculadora de geometría.
     * Solicita al usuario una figura y una operación, calcula el resultado y lo imprime.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicializa un objeto Scanner para leer la entrada del usuario desde la consola.
        Scanner input = new Scanner(System.in);

        // Solicita al usuario que elija una figura.
        String shape = askShape(input);
        // Solicita al usuario que elija una operación (área o perímetro).
        String operation = askOperation(input);

        // Realiza el cálculo basado en la figura y la operación seleccionadas.
        double result = calculate(shape, operation, input);
        // Imprime el resultado del cálculo.
        System.out.println("Resultado: " + result);

        // Cierra el recurso Scanner para liberar los recursos del sistema.
        input.close();
    }

    /**
     * Solicita al usuario que ingrese el nombre de una figura geométrica.
     * @param input El objeto Scanner para leer la entrada del usuario.
     * @return El nombre de la figura ingresado por el usuario, sin espacios al inicio/final y en minúsculas.
     */
    private static String askShape(Scanner input) {
        System.out.println("Figura (circulo, cuadrado, triangulo, rectangulo, pentagono):");
        return input.nextLine().trim().toLowerCase();
    }

    /**
     * Solicita al usuario que ingrese el tipo de operación a realizar (área o perímetro).
     * @param input El objeto Scanner para leer la entrada del usuario.
     * @return La operación ingresada por el usuario, sin espacios al inicio/final y en minúsculas.
     */
    private static String askOperation(Scanner input) {
        System.out.println("Operacion (area, perimetro):");
        return input.nextLine().trim().toLowerCase();
    }

    /**
     * Calcula el área o el perímetro de una figura dada basándose en la operación seleccionada.
     * @param shape La figura para la cual calcular (ej. "circulo", "cuadrado").
     * @param operation La operación a realizar ("area" o "perimetro").
     * @param input El objeto Scanner para leer las dimensiones necesarias de la figura.
     * @return El resultado calculado, o 0 si la figura no es reconocida.
     */
    private static double calculate(String shape, String operation, Scanner input) {
        // Utiliza un switch expression para determinar qué cálculo realizar según la figura.
        return switch (shape) {
            case "circulo" -> operation.equals("area") ? circleArea(input) : circlePerimeter(input);
            case "cuadrado" -> operation.equals("area") ? squareArea(input) : squarePerimeter(input);
            case "triangulo" -> operation.equals("area") ? triangleArea(input) : trianglePerimeter(input);
            case "rectangulo" -> operation.equals("area") ? rectangleArea(input) : rectanglePerimeter(input);
            case "pentagono" -> operation.equals("area") ? pentagonArea(input) : pentagonPerimeter(input);
            default -> 0; // Retorna 0 para figuras no reconocidas.
        };
    }

    /**
     * Calcula el área de un círculo.
     * Solicita al usuario el radio del círculo.
     * @param input El objeto Scanner para leer el radio.
     * @return El área calculada del círculo.
     */
    private static double circleArea(Scanner input) {
        System.out.println("Radio:");
        double radius = input.nextDouble();
        return PI * radius * radius;
    }

    /**
     * Calcula el perímetro de un círculo.
     * Solicita al usuario el radio del círculo.
     * @param input El objeto Scanner para leer el radio.
     * @return El perímetro calculado del círculo.
     */
    private static double circlePerimeter(Scanner input) {
        System.out.println("Radio:");
        double radius = input.nextDouble();
        return 2 * PI * radius;
    }

    /**
     * Calcula el área de un cuadrado.
     * Solicita al usuario la longitud del lado del cuadrado.
     * @param input El objeto Scanner para leer la longitud del lado.
     * @return El área calculada del cuadrado.
     */
    private static double squareArea(Scanner input) {
        System.out.println("Lado:");
        double side = input.nextDouble();
        return side * side;
    }

    /**
     * Calcula el perímetro de un cuadrado.
     * Solicita al usuario la longitud del lado del cuadrado.
     * @param input El objeto Scanner para leer la longitud del lado.
     * @return El perímetro calculado del cuadrado.
     */
    private static double squarePerimeter(Scanner input) {
        System.out.println("Lado:");
        double side = input.nextDouble();
        return 4 * side;
    }

    /**
     * Calcula el área de un triángulo.
     * Solicita al usuario la base y la altura del triángulo.
     * @param input El objeto Scanner para leer la base y la altura.
     * @return El área calculada del triángulo.
     */
    private static double triangleArea(Scanner input) {
        System.out.println("Base:");
        double base = input.nextDouble();
        System.out.println("Altura:");
        double height = input.nextDouble();
        return 0.5 * base * height;
    }

    /**
     * Calcula el perímetro de un triángulo.
     * Solicita al usuario las longitudes de los tres lados del triángulo.
     * @param input El objeto Scanner para leer las longitudes de los lados.
     * @return El perímetro calculado del triángulo.
     */
    private static double trianglePerimeter(Scanner input) {
        System.out.println("Lado 1:");
        double a = input.nextDouble();
        System.out.println("Lado 2:");
        double b = input.nextDouble();
        System.out.println("Lado 3:");
        double c = input.nextDouble();
        return a + b + c;
    }

    /**
     * Calcula el área de un rectángulo.
     * Solicita al usuario la base y la altura del rectángulo.
     * @param input El objeto Scanner para leer la base y la altura.
     * @return El área calculada del rectángulo.
     */
    private static double rectangleArea(Scanner input) {
        System.out.println("Base:");
        double base = input.nextDouble();
        System.out.println("Altura:");
        double height = input.nextDouble();
        return base * height;
    }

    /**
     * Calcula el perímetro de un rectángulo.
     * Solicita al usuario la base y la altura del rectángulo.
     * @param input El objeto Scanner para leer la base y la altura.
     * @return El perímetro calculado del rectángulo.
     */
    private static double rectanglePerimeter(Scanner input) {
        System.out.println("Base:");
        double base = input.nextDouble();
        System.out.println("Altura:");
        double height = input.nextDouble();
        return 2 * (base + height);
    }

    /**
     * Calcula el área de un pentágono regular.
     * Solicita al usuario la longitud del lado y la apotema del pentágono.
     * @param input El objeto Scanner para leer la longitud del lado y la apotema.
     * @return El área calculada del pentágono.
     */
    private static double pentagonArea(Scanner input) {
        System.out.println("Lado:");
        double side = input.nextDouble();
        System.out.println("Apotema:");
        double apothem = input.nextDouble();
        return (5 * side * apothem) / 2;
    }

    /**
     * Calcula el perímetro de un pentágono regular.
     * Solicita al usuario la longitud del lado del pentágono.
     * @param input El objeto Scanner para leer la longitud del lado.
     * @return El perímetro calculado del pentágono.
     */
    private static double pentagonPerimeter(Scanner input) {
        System.out.println("Lado:");
        double side = input.nextDouble();
        return 5 * side;
    }
}