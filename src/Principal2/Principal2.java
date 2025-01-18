package Principal2;

import java.util.Scanner;

/**
 * Clase Principal2 que gestiona el menú de opciones y las acciones relacionadas con los alumnos, asignaturas y notas.
 */
public class Principal2 {
    static final Scanner scan = new Scanner(System.in); // Scanner para leer entradas del usuario.
    static Grupo Alumno1 = new Grupo("DAM 1K", 5, 5); // Instancia de la clase Grupo con datos iniciales.

    /**
     * Método principal que muestra el menú y ejecuta las opciones elegidas por el usuario.
     */
    public static void main(String[] args) {
        Principal2 principal = new Principal2(); // Instancia de la clase Principal2.
        int opcion;
        do {
            opcion = mostrarMenu(); // Llama a la función que muestra el menú y guarda la opción seleccionada.
            switch (opcion) {
                case 1 -> principal.probarLeerAlumnos();
                case 2 -> principal.probarMostrarAlumnos();
                case 3 -> principal.probarLeerNotas();
                case 4 -> principal.probarMostrarGrupoYNotas();
                case 5 -> principal.probarMostrarMedias();
                case 6 -> principal.probarAsignaturaMin();
                case 7 -> principal.probarAsignaturaMax();
                case 8 -> principal.probarDameMediaAsignatura();
                case 9 -> principal.probarDameAlumnoMedia();
                case 10 -> principal.probardameAlumnoSuspensos();
                case 11 -> principal.probaMejorAlumnoMedia();
                case 12 -> principal.probarMustraMediaAlumnos();
                case 13 -> principal.probarDameAlumnoMedia1();
                case 14 -> principal.probarmuestraRepetidores();
                case 15 -> principal.probarAnalizaAsignaturas();
                case 16 -> principal.probarAnalizaCurso();
                case 17 -> System.out.println("Adios");
                default -> System.out.println("Valor incorrecto");
            }

        } while (opcion != 17); // El ciclo continúa hasta que se elige la opción 17 para salir.
    }

    /**
     * Muestra el menú de opciones y obtiene la selección del usuario.
     *
     * @return La opción seleccionada por el usuario.
     */
    private static int mostrarMenu() {
        int opcion;
        do { // Imprime el menú hasta que el usuario elija una opción válida.
            System.out.println("Elige una opción");
            System.out.println("""
                    1. Leer Alumnos
                    2. Mostrar Alumnos
                    3. Leer Notas Asignaturas
                    4. Mostrar Grupo y Notas
                    5. Mostrar Medias
                    6. Mostrar Asignatura Mínima
                    7. Mostrar Asignatura Máxima
                    8. Mostrar Media Asignatura
                    9. Mostrar el alumno con mejor media
                    10. Muestra Número de Asignaturas Suspensas
                    11. Muestra el nombre del alumno con mejor media
                    12. Mostrar medias
                    13. Media del alumno de las asignaturas
                    14. Muestra los repetidores
                    15. Analiza Asignaturas
                    16. Analizar Curso
                    17. Salir
                    """);
            // Valida que la entrada sea un número entero
            while (!scan.hasNextInt()) {
                System.out.println("Entrada invalida, ingrese un numero entero:");
                scan.next(); // Consume la entrada inválida.
            }

            opcion = scan.nextInt(); // Lee la opción seleccionada.

        } while (opcion < 1 || opcion > 17); // Asegura que la opción esté dentro del rango válido.
        return opcion;
    }

    /**
     * Llama al método para leer los datos de los alumnos.
     */
    private void probarLeerAlumnos() {
        Alumno1.leerAlumnos();
    }

    /**
     * Muestra los datos de los alumnos.
     */
    private void probarMostrarAlumnos() {
        Alumno1.mostrarAlumnos();
    }

    /**
     * Llama al método para leer las notas de las asignaturas y luego las muestra.
     */
    private void probarLeerNotas() {
        Alumno1.leerAsignaturas();
        Alumno1.mostrarAsignaturas();
    }

    /**
     * Muestra el grupo de alumnos junto con sus notas.
     */
    private void probarMostrarGrupoYNotas() {
        System.out.println(Alumno1.toString());
    }

    /**
     * Muestra las medias de los alumnos.
     */
    private void probarMostrarMedias() {
        Alumno1.mostrarMedias();
    }

    /**
     * Muestra la asignatura con la nota mínima.
     */
    private void probarAsignaturaMin() {
        System.out.println(Alumno1.dameAsignaturaMinima());
    }

    /**
     * Muestra la asignatura con la nota máxima.
     */
    private void probarAsignaturaMax() {
        System.out.println(Alumno1.dameAsignaturaMaxima());
    }

    /**
     * Muestra la media de una asignatura dada su posición en el listado.
     */
    private void probarDameMediaAsignatura() {
        System.out.println(Alumno1.dameMediaAsignatura(0)); // 0 es un ejemplo de índice.
    }

    /**
     * Muestra la media de un alumno, seleccionando el alumno por su posición.
     */
    private void probarDameAlumnoMedia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posicion del alumno");
        int alumno = sc.nextInt(); // Lee el índice del alumno.
        System.out.println(Alumno1.dameAlumnoMedia(alumno));
    }

    /**
     * Muestra el número de asignaturas suspensas de un alumno.
     */
    private void probardameAlumnoSuspensos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posicion del alumno");
        int alumno = sc.nextInt(); // Lee el índice del alumno.
        System.out.println(Alumno1.dameAlumnoSuspensos(alumno));
    }

    /**
     * Muestra el nombre del mejor alumno según su media.
     */
    private void probaMejorAlumnoMedia() {
        System.out.println(Alumno1.dameMejorAlumnoMedia());
    }

    /**
     * Muestra las medias de todos los alumnos.
     */
    private void probarMustraMediaAlumnos() {
        Alumno1.mustraMediaAlumnos();
    }

    /**
     * Muestra la media de un alumno específico.
     */
    private void probarDameAlumnoMedia1() {
        Alumno1.dameAlumnoMedia();
    }

    /**
     * Muestra los repetidores (alumnos con asignaturas suspendidas).
     */
    private void probarmuestraRepetidores() {
        Alumno1.muestraRepetidores();
    }

    /**
     * Analiza las asignaturas para obtener información relevante.
     */
    private void probarAnalizaAsignaturas() {
        Alumno1.analizaAsignaturas();
    }

    /**
     * Analiza el curso y muestra la información relacionada.
     */
    private void probarAnalizaCurso() {
        Alumno1.analizaCurso();
    }
}
