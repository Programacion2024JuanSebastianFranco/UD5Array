import java.util.Arrays;
import java.util.Scanner;

public class Evaluacion {

    Scanner scan = new Scanner(System.in);

    private String nombreAsignatura;
    private double[] listaNotas;


    // Constructores


    public Evaluacion(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Evaluacion(String nombreAsignatura, double[] listaNotas) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaNotas = listaNotas;
    }

    // Metodos

    public void leerNotas(int totalALumnos) {

        if (listaNotas != null) {
            scan.nextLine();
            System.out.println("Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            String opc = scan.nextLine();

            while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n")) {
                System.out.println("Porfavor, (s/n)");
                opc = scan.nextLine();
            }

            if (opc.equalsIgnoreCase("s")) {
                listaNotas = new double[totalALumnos];
                ingresarNota(listaNotas);
            } else if (opc.equalsIgnoreCase("n")) {
                System.out.println("Adios");
            }
        } else {
            listaNotas = new double[totalALumnos];
            ingresarNota(listaNotas);
        }
    }

    public void ingresarNota(double listaNotas[]) {

        double nota;

        for (int i = 0; i < listaNotas.length; ) {
            System.out.println("Introduce la nota del alumno " + (i + 1));
            nota = scan.nextDouble();
            if (nota >= 0 && nota <= 10) {
                listaNotas[i] = nota;
                i++;
            } else
                System.out.println("Nota no valida, maxima 10 y minima 0");
        }
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "listaNotas=" + Arrays.toString(listaNotas) +
                '}';
    }



    // Metodos

    public double media() {

        double suma = 0;

        if (this.listaNotas == null || this.listaNotas.length == 0) {
            System.out.println("No hay notas disponibles para calcular la media.");
            return 0.0;
        }

        for (double nota : this.listaNotas) {
            suma += nota;
        }

        return suma / this.listaNotas.length;
    }

    public double minimo(){

        double minimo;

        minimo = listaNotas.length;

        for (double nota : this.listaNotas) {
            if (nota < minimo) {
                minimo = nota;
            }
        }

        return minimo;
    }

    public double maximo(){

        double maximo;

        maximo = listaNotas.length;

        for (double nota : this.listaNotas) {
            if (nota > maximo)
                maximo = nota;
        }

        return maximo;
    }

    public int suspensos(){

        int suspensos = 0;

        for (double nota : listaNotas) {
            if (nota < 5) {
                suspensos++;
            }
        }

        return suspensos;
    }

    public int aprobados(){

        int aprobados = 0;

        for (double nota : listaNotas) {
            if (nota >= 5) {
                aprobados++;
            }
        }

        return aprobados;
    }

    public void cambiarNota(double nuevaNota, int indiceAlumno) {

        if (listaNotas == null) {
            System.out.println("El array de notas no puede ser nulo");
        }

        if (indiceAlumno < 0 || indiceAlumno >= listaNotas.length + 1) {
            System.out.println("El indice del alumno esta fuera del rango permitido");
        }

        listaNotas[indiceAlumno - 1] = nuevaNota;
    }

    public int mejorAlumno() {
        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("El array de notas no puede estar vacío o ser nulo");
        }

        double maxNota = maximo();
        int indiceMejor = 0;

        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == maxNota) {
                indiceMejor = i;
            }
        }

        return indiceMejor + 1;
    }

    public int peorAlumno() {
        if (listaNotas == null || listaNotas.length == 0) {
            System.out.println("El array de notas no puede estar vacío o ser nulo");
        }

        double minNota = minimo();
        int indicePeor = 0;

        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] == minNota) {
                indicePeor= i;
            }
        }

        return indicePeor + 1;
    }

    public void notaAlumno(int indiceAlumno){
        indiceAlumno = listaNotas;

        return indiceAlumno;
    }
}
