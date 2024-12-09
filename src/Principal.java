import java.util.Scanner;

public class Principal {

    final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Principal principal = new Principal();

        int opc;

        Evaluacion evaluacion = new Evaluacion("Matematicas");

        do {
            opc = principal.mostrarMenu();
            switch (opc) {

                case 1 -> {
                    System.out.println("numero de alumnos: ");
                    int num = scan.nextInt();
                    evaluacion.leerNotas(num);
                    System.out.println(evaluacion);
                }
                case 2 -> {
                    double media = evaluacion.media();
                    System.out.println("La media del curso fue de: " + media);
                }
                case 3 -> {
                    double minimo = evaluacion.minimo();
                    System.out.println("La nota minima de un estudiante fue de: " + minimo);
                }
                case 4 -> {
                    double minimo = evaluacion.maximo();
                    System.out.println("La nota maxima de un estudiante fue de: " + minimo);
                }
                case 5 ->{
                    double suspensos = evaluacion.suspensos();
                    System.out.println("El total de suspensos fue: " + suspensos);
                }
                case 6 ->{
                    double aprobados = evaluacion.aprobados();
                    System.out.println("El total de aprobados fue: " + aprobados);
                }
                case 7 ->{

                }
            }
        } while (opc != 12);
    }


    int mostrarMenu() {
        int opc;

        do {
            System.out.println("MENU\n1. Probar Notas\n2. Probar Media\n3. Nota Minima\n4. Nota Maxima\n" +
                    "5. Total Suspensos\n6. Total Aprobados");
            opc = scan.nextInt();

        } while (opc < 1 || opc > 12);
        return opc;
    }
}
