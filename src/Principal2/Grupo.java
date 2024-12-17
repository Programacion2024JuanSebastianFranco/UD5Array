package Principal2;

import Principal1.Asignatura;

import java.util.Arrays;
import java.util.Scanner;

public class Grupo {
    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;
    private Scanner scan = new Scanner(System.in);



    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas) {
        this.nombreGrupo = "DAM 1K";
        this.alumnos = new String[totalAlumnos];
        this.asignaturas = new Asignatura[totalAsignaturas];
        this.totalAlumnos = totalAlumnos;
        this.totalAsignaturas = totalAsignaturas;
    }

    public void leerAlumnos(){
        if (alumnos != null) {
            for (int i = 0; i < totalAlumnos; i++) {
                System.out.println("Nombre del alumno " + (i + 1) + ": ");
                String alumno = scan.nextLine();
                alumnos[i] = alumno;
            }
            Arrays.sort(alumnos);
        }
        else {
            System.out.println("Sin alumnos asignados");
        }
    }

    public void mostrarAlumnos(){
        System.out.println(Arrays.toString(alumnos));
    }

    public void leerAsignaturas(){
        if (asignaturas != null) {
            for (int i = 0; i < totalAsignaturas; i++) {
                System.out.println("Nombre de la asignatura: ");
                String asignatura = scan.nextLine();
                asignaturas[i] = new Asignatura(asignatura);
                asignaturas[i].leerNotas(totalAlumnos);
            }

        }
        else {
            System.out.println("Sin asignaturas asignadas");
        }
    }

    public void mostrarAignaturas(){
        System.out.println(Arrays.toString(asignaturas));
    }




    @Override
    public String toString() {
        // Construir la cadena con los nombres de los alumnos
        StringBuilder nombresFormateados = new StringBuilder();
        for (String nombre : alumnos) {
            nombresFormateados.append(String.format("%-30s", nombre)); // Alinea los nombres a la izquierda, con un ancho de 30 caracteres
        }

        // Crear una cadena para las notas de los alumnos en cada asignatura
        StringBuilder notasFormateadas = new StringBuilder();
        for (int i = 0; i < totalAsignaturas; i++) {
            double[] notas = asignaturas[i].getListaNotas(); // Obtener las notas de la asignatura i
            notasFormateadas.append(String.format("%-30s", asignaturas[i].nombreAsignatura)); // Añadir el nombre de la asignatura

            // Formatear y añadir las notas de los alumnos para esa asignatura
            for (double nota : notas) {
                notasFormateadas.append(String.format("%-15.2f", nota)); // Formatear cada nota con 2 decimales
            }
            notasFormateadas.append("\n"); // Añadir un salto de línea entre asignaturas
        }

        // Devolver la cadena formateada con los nombres y las notas
        return nombresFormateados.toString() + "\n" + notasFormateadas.toString();
    }

}
