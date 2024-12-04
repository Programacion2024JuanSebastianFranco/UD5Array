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

        boolean introducido = false;

        if (listaNotas != null) {
            System.out.println("Notas ya introducidas desea introducirlas de nuevo(s/n)?");

            scan.nextLine();

            String opc = scan.nextLine();

            while (!opc.equalsIgnoreCase("s") && !opc.equalsIgnoreCase("n")) {

                scan.nextLine();

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
            System.out.println("Introduce la nota del alumno " + i);
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
}
