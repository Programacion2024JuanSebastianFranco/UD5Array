package Principal2;

import Principal1.Asignatura;

public class Grupo {
    private String nombreGrupo;
    private String[] alumnos;
    private Asignatura[] asignaturas;
    private int totalAlumnos;
    private int totalAsignaturas;



    public Grupo(String nombreGrupo, int totalAlumnos, int totalAsignaturas) {
        this.nombreGrupo = "DAM 1K";
        this.alumnos = new String[24];
        this.asignaturas = new Asignatura[5];
    }



}
