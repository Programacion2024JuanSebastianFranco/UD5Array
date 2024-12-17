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

    public Grupo(){
        //this("1k",4,3);
        nombreGrupo="1K";
        totalAlumnos=3;
        totalAsignaturas=3;

        this.alumnos=new String[totalAlumnos];
        alumnos[0]="Pepe";
        alumnos[1]="Maria";
        alumnos[2]="Juan";

        this.asignaturas=new Asignatura[totalAsignaturas];
        double[] notas1={2.5,5.5,10};
        asignaturas[0]=new Asignatura("Matematicas",notas1);

        double[] notas2={2.5,6,1};
        asignaturas[1]=new Asignatura("Programación",notas2);
        double[] notas3={7,5.5,10};
        asignaturas[2]=new Asignatura("Inglés",notas3);
    }

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

        StringBuilder resultado = new StringBuilder();

        resultado.append(Arrays.toString(asignaturas)).append("\n");

            for (int i = 0; i < totalAlumnos; i++) {
                resultado.append(Arrays.toString(alumnos)).append(i).append("%-30s");
            }

            resultado.append("\n");

        return resultado.toString();
    }

}