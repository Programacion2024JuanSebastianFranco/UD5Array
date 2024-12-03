import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Principal principal = new Principal();

        int opc;

        do {
            opc = principal.mostrarMenu();
            switch (opc) {

                case 1 -> System.out.print("");


            }
        } while (opc != 5);
    }


    int mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        int opc;

        do {

            System.out.println("MENU\n1. Probar Cliente Vip\n2. Probar Superficie\n3. Probar Tarea\n4. Probar MI clase\n5. Salir");
            opc = scan.nextInt();

        } while (opc < 1 || opc > 5);
        return opc;
    }
    }
}