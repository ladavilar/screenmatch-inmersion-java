import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenidos a la inmersión Java");
        //System.out.println("Película Matrix");

        // Declaración de variables
        int fechaLanzamiento = 1999;
        double evaluacion = 4.5;  //0 a 5
        boolean incluidoPlanBasico = true;
        String nombre = "Matrix";
        String sinopsis = """
                La mejor pelicula del fin del milenio
                """;

        System.out.println("Película: " + nombre);
        System.out.println(fechaLanzamiento);
        System.out.println(evaluacion);
        System.out.println(incluidoPlanBasico);

        double mediaEvaluacion = (4.5 + 4.8 + 3) / 3;
        System.out.println("Media de la evaluación de Matrix: " + mediaEvaluacion);

        if (fechaLanzamiento >= 2023) {
            System.out.println("Película popular en el momento");
        } else {
            System.out.println("Película Retro que vale la pena ver");
        }

        double mediaEvaluacionUsuario = 0.0;
        for (int i = 0; i < 3; i++) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingresa la nota que le darías a Matrix:");
            double notaMatrix = teclado.nextDouble();
            mediaEvaluacionUsuario += notaMatrix;
        }
        System.out.println("Evaluación Media Matrix Usuario: " + mediaEvaluacionUsuario / 3);

    }
}