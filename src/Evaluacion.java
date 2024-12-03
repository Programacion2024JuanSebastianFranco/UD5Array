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

    public void leerNotas(int totalALumnos){

        double nota;

        if (listaNotas != null) {

            System.out.print("Notas ya introducidas desea introducirlas de nuevo(s/n)?");
            String opc = scan.nextLine();

            if (opc.equalsIgnoreCase("s")){

                for (int i = 0; i < listaNotas.length; i++){
                    System.out.print("Introduce la nota del alumno " + i);
                    nota = scan.nextDouble();
                    if (nota >= 0 && nota <= 10)
                        listaNotas[i] = nota;
                    else
                        System.out.print("Nota no valida, maxima 10 y minima 0");

                }
            }

            else if (opc.equalsIgnoreCase("n")) {
                double[] listaNotas = new double[totalALumnos];
            }

            else {
                System.err.print("Porfavor, (s/n)");
            }
        }
        else {
            double[] listaNotas = new double[totalALumnos];
        }
    }


    @Override
    public String toString() {
        return "Evaluacion:\n" +
                "nombreAsignatura: " + nombreAsignatura + '\'' + "\n" +
                "listaNotas=" + Arrays.toString(listaNotas);
    }
}
