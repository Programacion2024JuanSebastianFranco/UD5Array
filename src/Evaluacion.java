import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Evaluacion para gestionar las notas de los alumnos en una asignatura.
 * Proporciona métodos para ingresar, analizar, modificar y obtener estadísticas
 * sobre las notas de los alumnos.
 */
public class Evaluacion {

    // Atributos
    private Scanner scan = new Scanner(System.in); // Escáner para entrada del usuario
    private String nombreAsignatura; // Nombre de la asignatura
    private double[] listaNotas;    // Array para almacenar las notas de los alumnos

    // Constructores

    /**
     * Constructor con el nombre de la asignatura.
     *
     * @param nombreAsignatura Nombre de la asignatura.
     */
    public Evaluacion(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Constructor con el nombre de la asignatura y una lista inicial de notas.
     *
     * @param nombreAsignatura Nombre de la asignatura.
     * @param listaNotas       Array con las notas iniciales de los alumnos.
     */
    public Evaluacion(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }

    // Métodos

    /**
     * Permite al usuario introducir o reintroducir notas para un número determinado de alumnos.
     *
     * @param totalAlumnos Número total de alumnos de la asignatura.
     */
    public void leerNotas(int totalAlumnos) {
        if (listaNotas != null) {
            // Preguntar si desea reintroducir las notas
            scan.nextLine();
            System.out.println("Notas ya introducidas. ¿Desea introducirlas de nuevo (s/n)?");
            String opc = scan.nextLine();

            while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n")) {
                System.out.println("Por favor, elija una opción válida (s/n):");
                opc = scan.nextLine();
            }

            if (opc.equalsIgnoreCase("s")) {
                // Crear un nuevo array y permitir ingresar las notas
                listaNotas = new double[totalAlumnos];
                ingresarNota(listaNotas);
            } else if (opc.equalsIgnoreCase("n")) {
                System.out.println("No se han modificado las notas.");
            }
        } else {
            // Si no hay notas existentes, permitir su ingreso
            listaNotas = new double[totalAlumnos];
            ingresarNota(listaNotas);
        }
    }

    /**
     * Permite ingresar las notas de los alumnos, verificando que estén dentro del rango válido.
     *
     * @param listaNotas Array en el que se almacenarán las notas ingresadas.
     */
    public void ingresarNota(double[] listaNotas) {
        double nota;
        for (int i = 0; i < listaNotas.length; ) {
            System.out.println("Introduce la nota del alumno " + (i + 1) + ":");
            nota = scan.nextDouble();
            if (nota >= 0 && nota <= 10) {
                listaNotas[i] = nota; // Agregar nota válida
                i++;
            } else {
                System.out.println("Nota no válida. Introduzca una nota entre 0 y 10.");
            }
        }
        this.listaNotas = listaNotas; // Guardar las notas en el atributo de la clase
    }

    /**
     * Calcula la media de las notas de los alumnos.
     *
     * @return La media de las notas o 0.0 si no hay notas disponibles.
     */
    public double media() {
        double suma = 0;

        if (this.listaNotas == null || this.listaNotas.length == 0) {
            System.out.println("No hay notas disponibles para calcular la media.");
            return 0.0;
        }

        for (double nota : this.listaNotas) {
            suma += nota; // Sumar todas las notas
        }

        return suma / this.listaNotas.length; // Dividir la suma entre el número de notas
    }

    /**
     * Encuentra la nota más baja entre los alumnos.
     *
     * @return La nota más baja.
     */
    public double minimo() {
        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("No hay notas disponibles.");
            return -1;
        }

        double minimo = listaNotas[0];
        for (double nota : this.listaNotas) {
            if (nota < minimo) {
                minimo = nota; // Actualizar el mínimo si se encuentra una nota más baja
            }
        }
        return minimo;
    }

    /**
     * Encuentra la nota más alta entre los alumnos.
     *
     * @return La nota más alta.
     */
    public double maximo() {
        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("No hay notas disponibles.");
            return -1;
        }

        double maximo = listaNotas[0];
        for (double nota : this.listaNotas) {
            if (nota > maximo) {
                maximo = nota; // Actualizar el máximo si se encuentra una nota más alta
            }
        }
        return maximo;
    }

    /**
     * Calcula cuántos alumnos han suspendido.
     *
     * @return Número de alumnos con nota menor a 5.
     */
    public int suspensos() {
        int suspensos = 0;

        for (double nota : listaNotas) {
            if (nota < 5) {
                suspensos++; // Incrementar el contador de suspensos
            }
        }

        return suspensos;
    }

    /**
     * Calcula cuántos alumnos han aprobado.
     *
     * @return Número de alumnos con nota igual o mayor a 5.
     */
    public int aprobados() {
        int aprobados = 0;

        for (double nota : listaNotas) {
            if (nota >= 5) {
                aprobados++; // Incrementar el contador de aprobados
            }
        }

        return aprobados;
    }

    /**
     * Cambia la nota de un alumno específico.
     *
     * @param nuevaNota    Nueva nota para el alumno.
     * @param indiceAlumno Índice del alumno (1 basado).
     */
    public void cambiarNota(double nuevaNota, int indiceAlumno) {
        if (listaNotas == null) {
            System.out.println("El array de notas no puede ser nulo.");
            return;
        }

        if (indiceAlumno < 1 || indiceAlumno > listaNotas.length) {
            System.out.println("El índice del alumno está fuera del rango permitido.");
            return;
        }

        listaNotas[indiceAlumno - 1] = nuevaNota; // Cambiar la nota en el índice especificado
    }

    /**
     * Devuelve la representación en texto del estado de la asignatura y las notas.
     *
     * @return String con el nombre de la asignatura y las notas de los alumnos.
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Asignatura: ").append(nombreAsignatura).append("\n");

        if (listaNotas != null && listaNotas.length > 0) {
            resultado.append("Notas de los alumnos:\n");
            for (int i = 0; i < listaNotas.length; i++) {
                resultado.append("Alumno ").append(i + 1).append(": ").append(listaNotas[i]).append("\n");
            }
        } else {
            resultado.append("Sin notas por el momento.");
        }

        return resultado.toString();
    }
}
