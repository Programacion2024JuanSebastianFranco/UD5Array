package Principal2;
import Principal1.Asignatura;

import java.util.Arrays;
import java.util.Scanner;

public class Grupo {
    // Variables de clase
    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    int totalAlumnos;
    int totalAsignaturas;

    // Constructor de la clase Grupo
    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas) {
        this.nombreGrupo = nombreGrupo;
        this.totalAlumnos = totalAlumnos;
        this.totalAsignaturas = totalAsignaturas;
        this.alumnos = new String[this.totalAlumnos];
        this.asignaturas = new Asignatura[this.totalAsignaturas];
    }

    /**
     * Lee los nombres de los alumnos desde la entrada del usuario.
     */
    public void leerAlumnos() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Indica el nombre del alumno: ");
            // El nombre del alumno se almacena en la posición i
            alumnos[i] = sc.next();
            // Imprime el nombre del alumno y su posición
            System.out.println(alumnos[i] + i);
        }
        // Ordena los nombres de los alumnos alfabéticamente
        Arrays.sort(alumnos);
    }

    /**
     * Muestra todos los alumnos que se han introducido.
     */
    public void mostrarAlumnos() {
        System.out.println(Arrays.toString(alumnos));
    }

    /**
     * Lee el nombre de las asignaturas y las notas de los alumnos.
     */
    public void leerAsignaturas() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < totalAsignaturas; i++) {
            System.out.println("Indica el nombre de la asignatura: ");
            // Crea una nueva asignatura y la almacena
            asignaturas[i] = new Asignatura(sc.next());
            System.out.println("Introduzca las notas de los alumnos");
            asignaturas[i].leerNotas(totalAlumnos); // Asigna notas a los alumnos
        }
    }

    /**
     * Muestra todas las asignaturas que se han introducido.
     */
    public void mostrarAsignaturas() {
        for (int i = 0; i < asignaturas.length; i++) {
            // Imprime el nombre de cada asignatura
            System.out.println(asignaturas[i].getNombreAsignatura());
        }
    }

    /**
     * Devuelve un resumen del grupo con los nombres de los alumnos y las notas de las asignaturas.
     *
     * @return Una cadena con el formato del grupo, incluyendo alumnos y sus notas.
     */
    public String toString() {
        String forma = String.format("%-15s", "Alumno");
        // Recorrimos las asignaturas y las mostramos en el formato adecuado
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].getNombreAsignatura());
        }
        forma += "\n";

        // Recorremos los alumnos y mostramos sus notas
        for (int i = 0; i < totalAlumnos; i++) {
            forma += String.format("%-15s", alumnos[i]);
            for (int j = 0; j < totalAsignaturas; j++) {
                forma += String.format("%-12s", asignaturas[j].notaAlumno(i));
            }
            forma += "\n";
        }
        return forma;
    }

    /**
     * Muestra las medias de las asignaturas.
     */
    public void mostrarMedias() {
        String forma = "";
        // Añade el nombre de cada asignatura
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].getNombreAsignatura());
        }
        forma += "\n";

        // Muestra la media de cada asignatura
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].media());
        }
        forma += "\n";
        System.out.println(forma);
    }

    /**
     * Devuelve el nombre de la asignatura con la nota más baja.
     *
     * @return El nombre de la asignatura con la nota mínima.
     */
    public String dameAsignaturaMinima() {
        Asignatura asignaturaMin = asignaturas[0];
        double notaMin = asignaturas[0].minimo();
        for (int i = 0; i < totalAsignaturas; i++) {
            double nota = asignaturas[i].minimo();
            if (nota < notaMin) {
                notaMin = nota;
                asignaturaMin = asignaturas[i];
            }
        }
        return asignaturaMin.getNombreAsignatura();
    }

    /**
     * Devuelve el nombre de la asignatura con la nota más alta.
     *
     * @return El nombre de la asignatura con la nota máxima.
     */
    public String dameAsignaturaMaxima() {
        Asignatura asignaturaMax = asignaturas[0];
        double notaMax = asignaturas[0].maximo();
        for (int i = 0; i < totalAsignaturas; i++) {
            double nota = asignaturas[i].minimo();
            if (nota > notaMax) {
                notaMax = nota;
                asignaturaMax = asignaturas[i];
            }
        }
        return asignaturaMax.getNombreAsignatura();
    }

    /**
     * Devuelve la media de una asignatura según su posición en el array.
     *
     * @param posicion La posición de la asignatura en el array.
     * @return La media de la asignatura en la posición indicada.
     */
    public double dameMediaAsignatura(int posicion) {
        return asignaturas[posicion].media();
    }

    /**
     * Devuelve la media de un alumno según su posición.
     *
     * @param posicion La posición del alumno en el array.
     * @return La media del alumno en todas las asignaturas.
     */
    public double dameAlumnoMedia(int posicion) {
        double media = 0;
        for (int i = 0; i < totalAsignaturas; i++) {
            media += asignaturas[i].notaAlumno(posicion);
        }
        return media / totalAsignaturas;
    }

    /**
     * Devuelve el número de asignaturas suspensas de un alumno.
     *
     * @param posicion La posición del alumno en el array.
     * @return El número de asignaturas suspensas del alumno.
     */
    public double dameAlumnoSuspensos(int posicion) {
        double suspenso = 0;
        for (int i = 0; i < totalAsignaturas; i++) {
            if (asignaturas[i].notaAlumno(posicion) < 5) {
                suspenso++;
            }
        }
        return suspenso;
    }

    /**
     * Devuelve el nombre del alumno con la mejor media.
     *
     * @return El nombre del alumno con la mejor media.
     */
    public String dameMejorAlumnoMedia() {
        String nombre = "";
        double mejorNota = 0;
        for (int i = 0; i < totalAsignaturas; i++) {
            if ((asignaturas[i].notaAlumno(i) / totalAsignaturas) > mejorNota) {
                nombre = alumnos[i];
                mejorNota = asignaturas[i].notaAlumno(i);
            }
        }
        return nombre;
    }

    /**
     * Muestra la media de los alumnos en sus respectivas asignaturas.
     */
    public void mustraMediaAlumnos() {
        double nota = 0;
        String forma = String.format("%-12s", "Asignatura");
        // Encabezado con los nombres de las asignaturas
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].getNombreAsignatura());
        }
        forma += "\n";

        // Notas de los alumnos
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", alumnos[i]);
            for (int j = 0; j < totalAsignaturas; j++) {
                forma += String.format("%-12s", (asignaturas[j].notaAlumno(i)));
            }
            forma += "\n";
        }

        // Medias de las asignaturas
        forma += String.format("%-12s", "Media");
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", dameMediaAsignatura(i));
        }
        System.out.println(forma);
    }

    /**
     * Muestra las notas de los alumnos junto con sus medias.
     */
    public void dameAlumnoMedia() {
        String forma = String.format("%-12s", "Asignatura");
        // Encabezado con los nombres de las asignaturas
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].getNombreAsignatura());
        }
        forma += "\n";

        // Notas de los alumnos
        for (int i = 0; i < totalAlumnos; i++) {
            forma += String.format("%-12s", alumnos[i]);
            for (int j = 0; j < totalAsignaturas; j++) {
                forma += String.format("%-12s", asignaturas[j].notaAlumno(i));
            }
            // Media de alumnos
            forma += String.format("%-12s", dameAlumnoMedia(i));
            forma += "\n";
        }
        // Medias de las asignaturas
        forma += String.format("%-12s", "Media");
        for (int i = 0; i < totalAsignaturas; i++) {
            forma += String.format("%-12s", asignaturas[i].media());
        }
        System.out.println(forma);
    }

    /**
     * Muestra los alumnos que repetirán debido a un alto número de suspensos.
     */
    public void muestraRepetidores() {
        String alumno = "";
        for (int i = 0; i < totalAlumnos; i++) {
            if (dameAlumnoSuspensos(i) > 2) {
                alumno += alumnos[i];
                alumno += "\n";
            }
        }
        System.out.println(alumno);
    }

    /**
     * Analiza las asignaturas y muestra su estado actual.
     */
    public void analizaAsignaturas() {
        String resultado = "";
        for (int i = 0; i < totalAsignaturas; i++) {
            resultado += asignaturas[i].getNombreAsignatura() + " " + asignaturas[i].analizaGrupo();
            resultado += "\n";
        }
        System.out.println(resultado);
    }

    /**
     * Analiza el estado general del curso y la situación de los alumnos.
     */
    public void analizaCurso() {
        for (int i = 0; i < totalAlumnos; i++) {
            System.out.println(alumnos[i]);
            if (dameAlumnoSuspensos(i) > 2) {
                System.out.println("Repetirá");
            } else {
                System.out.println("Aprobado");
            }
        }
    }
}
