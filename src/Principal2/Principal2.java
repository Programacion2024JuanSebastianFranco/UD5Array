package Principal2;
import java.util.Scanner;

public class Principal2 {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Grupo grupo = new Grupo("1KDAM", 2, 2);

        Principal2 principal2 = new Principal2();
        int opc;
        do {
            opc = principal2.mostrarMenu();
            switch (opc) {

                case 1 ->

                case 2 -> S


                case 3 ->


                case 4 ->


                case 5 ->


                case 6 ->


                case 7 ->

                case 8 ->


                case 9 ->


                case 10 ->

                case 11 ->

                case 12 ->

                case 13 ->

                case default -> System.out.println("Adios");

            }
        } while (opc != 16);
        System.out.println("Adios");
    }


    int mostrarMenu() {
        int opc;
        do {
            System.out.println("""
                    1- Leer Alumnos
                    2- Leer Notas Asignaturas
                    3- Mostrar Grupo y Notas
                    4- Ver asignaturas
                    5- Ver media asignaturas
                    6- Ver asignatura menor mínimo
                    7- Ver asignatura mayor máximo
                    8- Mostrar el alumno con mejor media
                    9- Muestra media de los alumnos
                    10- Muestra repetidores
                    11- Analiza Asignaturas
                    12- Analiza Curso
                    13- Salir""");
            opc = scan.nextInt();
        } while (opc < 1 || opc > 13);
        return opc;
    }
}
