package Principal1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Principal1.Evaluacion para gestionar las notas de los alumnos en una asignatura.
 * Proporciona métodos para ingresar, analizar, modificar y obtener estadísticas
 * sobre las notas de los alumnos.
 */
public class Asignatura {

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
    public Asignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Constructor con el nombre de la asignatura y una lista inicial de notas.
     *
     * @param nombreAsignatura Nombre de la asignatura.
     * @param listaNotas       Array con las notas iniciales de los alumnos.
     */
    public Asignatura(String nombreAsignatura, double[] listaNotas) {
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
            suma = 0.0;
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

        double maximo = listaNotas[0];

        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("No hay notas disponibles.");
            return -1;
        }

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
            System.out.println("El array de notas no puede ser nulo");
        }

        if (indiceAlumno < 1 || indiceAlumno > listaNotas.length) {
            System.out.println("El indice del alumno esta fuera del rango permitido");
        }

        listaNotas[indiceAlumno - 1] = nuevaNota; // Cambiar la nota en el índice especificado
    }

    /**
     * Encuentra el índice del alumno con la nota más alta.
     *
     * @return Índice del alumno con la nota más alta (1 basado).
     */
    public int mejorAlumno() {
        int indiceMejor = 0;

        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("El array de notas no puede estar vacío o ser nulo");
            indiceMejor = -1;
        }

        double maxNota = maximo();


        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == maxNota) {
                indiceMejor = i;
            }
        }

        return indiceMejor + 1;
    }

    /**
     * Encuentra el índice del alumno con la nota más baja.
     *
     * @return Índice del alumno con la nota más baja (1 basado).
     */
    public int peorAlumno() {
        int indicePeor = 0;

        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("El array de notas no puede estar vacío o ser nulo");
            indicePeor =  -1;
        }

        double minNota = minimo();

        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == minNota) {
                indicePeor = i;
            }
        }

        return indicePeor + 1;
    }

    /**
     * Devuelve la nota de un alumno específico.
     *
     * @param indiceAlumno Índice del alumno (0 basado).
     * @return La nota del alumno o -1 si el índice es inválido.
     */
    public double notaAlumno(int indiceAlumno) {
        double resultado = -1;

        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("El array de notas no puede estar vacío o ser nulo");
        } else if (indiceAlumno >= 0 && indiceAlumno < listaNotas.length) {
            resultado = listaNotas[indiceAlumno];
        } else {
            System.out.println("Indice del alumno fuera del rango");
        }
        return resultado;
    }

    /**
     * Devuelve los índices de los alumnos aprobados.
     *
     * @return Array de índices de los alumnos con notas mayores o iguales a 5.
     */
    public int[] dameAprobados() {
        int totalAprobados = aprobados();
        int[] resultado;

        if (totalAprobados == 0) {
            System.out.println("No hay alumnos aprobados");
            resultado = new int[0];
        } else {
            int[] indicesAprobados = new int[totalAprobados];
            int casilla = 0;

            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] >= 5) {
                    indicesAprobados[casilla] = i;
                    casilla++;
                }
            }
            resultado = indicesAprobados;
        }

        return resultado;
    }


    /**
     * Devuelve los índices de los alumnos suspensos.
     *
     * @return Array de índices de los alumnos con notas menores a 5.
     */
    public int[] dameSuspensos() {
        int totalSuspensos = suspensos();
        int[] resultado;

        if (totalSuspensos == 0) {
            System.out.println("No hay alumnos suspensos");
            resultado = new int[0];
        } else {
            int[] indicesSuspensos = new int[totalSuspensos];
            int index = 0;

            for (int i = 0; i < listaNotas.length; i++) {
                if (listaNotas[i] < 5) {
                    indicesSuspensos[index] = i;
                    index++;
                }
            }
            resultado = indicesSuspensos;
        }

        return resultado;
    }

    /**
     * Encuentra el índice del primer alumno cuya nota es menor que un valor dado.
     *
     * @param nota Valor de referencia para comparar.
     * @return Índice del primer alumno con nota menor o -1 si no hay coincidencias.
     */
    public int primerMenor(double nota) {

        int vuelta = -1;

        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] < nota) {
                vuelta = i;
            }
        }
        return vuelta; // Si no se encuentra ninguna nota menor
    }

    /**
     * Devuelve un array con las notas ordenadas de menor a mayor.
     *
     * @return Array con las notas ordenadas.
     */
    public double[] ordenar() {
        double[] notasOrdenadas = Arrays.copyOf(listaNotas, listaNotas.length);
        Arrays.sort(notasOrdenadas);
        return notasOrdenadas;
    }

    /**
     * Analiza las notas del grupo y sugiere acciones en función del rendimiento.
     * Las categorías son:
     * - Más de 2/3 del grupo con nota mayor a 7: "VAMOS FENOMENAL".
     * - Más de 2/3 del grupo con nota entre 5 y 7: "REPASAR EJERCICIOS CON DIFICULTAD".
     * - Más de 2/3 del grupo con nota menor a 5: "VAMOS MAL... REPETIR EL TEMARIO".
     * - Otros casos: "HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD".
     */
    public void analizaGrupo() {
        int totalAlumnos = listaNotas.length;
        int mayores7 = 0;
        int entre5y7 = 0;
        int menores5 = 0;

        // Clasificar las notas en diferentes categorías
        for (double nota : listaNotas) {
            if (nota > 7) {
                mayores7++;
            } else if (nota >= 5 && nota <= 7) {
                entre5y7++;
            } else {
                menores5++;
            }
        }

        // Análisis del grupo
        if (mayores7 >= (2.0 / 3.0) * totalAlumnos) {
            System.out.println("VAMOS FENOMENAL");
        } else if (entre5y7 >= (2.0 / 3.0) * totalAlumnos) {
            System.out.println("REPASAR EJERCICIOS CON DIFICULTAD");
        } else if (menores5 >= (2.0 / 3.0) * totalAlumnos) {
            System.out.println("VAMOS MAL... REPETIR EL TEMARIO");
        } else {
            System.out.println("HACER SUBGRUPOS CON TAREAS DE DIFERENTE DIFICULTAD");
        }
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