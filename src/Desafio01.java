import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Desafio01 {

    // Crear un diccionario de películas con un entero como clave y un array de objetos como valor
    public static Map<Integer, Object[]> peliculas = new HashMap<>();

    public static void main(String[] args) {

        // Obtenemos el dictionario de películas
        obtenerPeliculas(peliculas);

        // Mostramos el catálogo de películas
        listarPeliculas(peliculas);

        // Obtenemos la pelicula escogida por el usuario
        escogerPeliculaUsuario();

        // ponderar pelicula escogida
        ponderarPelicula();

    }

    public static void obtenerPeliculas(Map<Integer, Object[]> peliculas){
        // Agregar películas
        peliculas.put(1, new Object[]{"Matrix", 1999, true, "Un programador descubre la realidad es una simulación y se une a rebeldes para luchar contra las máquinas."});
        peliculas.put(2, new Object[]{"The Gladiator", 2000, true, "Un general romano traicionado se convierte en gladiador, buscando venganza contra el emperador corrupto."});
        peliculas.put(3, new Object[]{"The Godfather", 1972, true, "La saga sigue la familia Corleone en el crimen organizado, especialmente el ascenso de Michael Corleone."});
        peliculas.put(4, new Object[]{"Fasts & Furiosts 10", 2023, true, "Aventuras de corredores callejeros en misiones peligrosas, destacando autos rápidos, acción y temas de familia."});
    }

    public static void imprimirPelicula(int clave){
        // Acceder a la información de una película por su clave
        Object[] infoPelicula = peliculas.get(clave);
        String titulo = (String) infoPelicula[0];
        int anio = (int) infoPelicula[1];

        Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
        String comentario;
        if (anio >= year - 1) {
            comentario = "Película popular en el momento";
        } else {
            comentario = "Película Retro que vale la pena ver";
        }
        boolean incluidoPlanBase = (boolean) infoPelicula[2];
        String esPlanBase = incluidoPlanBase == true ? "Sí" : "No";

        String sinopsis = (String) infoPelicula[3];

        System.out.println("*****************************");
        System.out.println("INFORMACION DE LA PELICULA");
        System.out.println("*****************************");
        System.out.println("Título: " + titulo);
        System.out.println("Año: " + anio);
        System.out.println("Incluido en el plan Base: " + esPlanBase);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Comentario: " + comentario);
    }

    public static void listarPeliculas(Map<Integer, Object[]> peliculas) {
        System.out.println("*****************************");
        System.out.println("LISTADO DE PELICULAS");
        System.out.println("*****************************");
        for (Map.Entry<Integer, Object[]> entry : peliculas.entrySet()) {
            int clave = entry.getKey();
            Object[] infoPelicula = entry.getValue();
            String titulo = (String) infoPelicula[0];
            System.out.println("Película Nro " + clave + " -> Título: " + titulo);
        }

    }

    public static void escogerPeliculaUsuario(){
        System.out.println("*****************************");
        Scanner teclado = new Scanner(System.in);
        int nroPelicula;
        do {
            System.out.print("Ingrese Nro. Película: ");
            nroPelicula = teclado.nextInt();
            if (nroPelicula < 1 || nroPelicula > 4){
                System.out.println("ERROR! No existe Nro. Pelicula: " + nroPelicula);
            }
        } while ( nroPelicula < 1 || nroPelicula > 4 );

        // Imprimir información de la película escogida por el usuario
        imprimirPelicula(nroPelicula);
    }

    public static void ponderarPelicula(){
        System.out.println("*****************************");
        System.out.println("PONDERACION PELICULA");
        System.out.println("*****************************");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cant. Notas: ");
        int cantNotas = teclado.nextInt();
        double sumaNotas = 0.0;
        double nota = 0.0;
        int intentos = 0;

        while(intentos < cantNotas){
            do {
                System.out.print("Ingrese nota de la película (1 al 5): ");
                nota = teclado.nextInt();
                if ( nota < 1 || nota > 5 ) {
                    System.out.println("ERROR! Nota Incorrecta: " + nota);
                }else{
                    sumaNotas += nota;
                }
            } while( nota < 1 || nota > 5 );
            intentos += 1;
        }

        System.out.println("La valoración media de la película es: " + (sumaNotas / cantNotas));

    }
}
