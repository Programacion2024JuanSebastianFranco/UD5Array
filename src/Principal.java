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
                    int num = scan.nextInt();
                    evaluacion.leerNotas(num);
                    System.out.println(evaluacion);
                }
            }
        } while (opc != 5);
    }


    int mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        int opc;

        do {

            System.out.println("MENU\n1. Probar Notas\n2. Salir");
            opc = scan.nextInt();

        } while (opc < 1 || opc > 5);
        return opc;
    }
}
