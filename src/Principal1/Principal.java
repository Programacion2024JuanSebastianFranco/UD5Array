package Principal1;

import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Principal principal = new Principal();
        int opc;

        Asignatura evaluacion = new Asignatura("Matematicas");

        do {
            opc = principal.mostrarMenu();
            switch (opc) {

                case 1 -> {
                    System.out.println("Numero de alumnos: ");
                    int num = scan.nextInt();
                    evaluacion.leerNotas(num);
                    System.out.println(evaluacion);
                }

                case 2 -> System.out.println("La media del curso fue de: " + evaluacion.media());


                case 3 -> System.out.println("La nota minima de un estudiante fue de: " + evaluacion.minimo());


                case 4 -> System.out.println("La nota maxima de un estudiante fue de: " + evaluacion.maximo());


                case 5 -> System.out.println("El total de suspensos fue: " + evaluacion.suspensos());


                case 6 -> System.out.println("El total de aprobados fue: " + evaluacion.aprobados());


                case 7 -> {
                    System.out.println("Introduce la nota: ");
                    double nota = scan.nextDouble();
                    System.out.println("¿Que alumno? (indice)");
                    int alumno = scan.nextInt();
                    evaluacion.cambiarNota(nota, alumno);
                }

                case 8 -> System.out.println("El alumno con mejor nota fue el alumno " + evaluacion.mejorAlumno());


                case 9 -> System.out.println("El alumno con peor nota fue el alumno " + evaluacion.peorAlumno());


                case 10 -> {
                    int[] totalAprobados = evaluacion.dameAprobados();
                    if (totalAprobados != null) {
                        System.out.println("Aprobados: " + Arrays.toString(totalAprobados));
                    } else {
                        System.out.println("No hay alumnos aprobados");
                    }
                }

                case 11 -> {
                    int[] totalSuspensos = evaluacion.dameSuspensos();
                    if (totalSuspensos != null) {
                        System.out.println("Suspensos: " + Arrays.toString(totalSuspensos));
                    } else {
                        System.out.println("No hay alumnos suspensos");
                    }
                }

                case 12 -> {
                    System.out.println("Introduce una nota para buscar el primer alumno con nota menor: ");
                    double nota = scan.nextDouble();
                    int indice = evaluacion.primerMenor(nota);
                    if (indice != -1) {
                        System.out.println("El primer alumno con nota menor a " + nota + " es el alumno " + (indice + 1));
                    } else {
                        System.out.println("No hay alumnos con nota menor a " + nota);
                    }
                }

                case 13 -> {
                    double[] ordenadas = evaluacion.ordenar();
                    System.out.println("Notas ordenadas: " + Arrays.toString(ordenadas));
                }

                case 14 -> {
                    evaluacion.analizaGrupo();
                }

                case 15 -> {
                    System.out.println("Introduce el indice del alumno para consultar su nota: ");
                    int indice = scan.nextInt();
                    double nota = evaluacion.notaAlumno(indice - 1);
                    if (nota != -1) {
                        System.out.println("La nota del alumno " + indice + " es: " + nota);
                    } else {
                        System.out.println("Indice invalido o fuera de rango");
                    }
                }
            }
        } while (opc != 16);
        System.out.println("Adios");
    }



    int mostrarMenu() {
        int opc;
        do {
            System.out.println("""
                    MENU
                    1. Probar Notas
                    2. Probar Media
                    3. Nota Minima
                    4. Nota Maxima
                    5. Total Suspensos
                    6. Total Aprobados
                    7. Cambiar Nota
                    8. Mejor Alumno
                    9. Peor Alumno
                    10. Mostrar Indices de Aprobados
                    11. Mostrar Indices de Suspensos
                    12. Buscar Primer Alumno con Nota Menor
                    13. Mostrar Notas Ordenadas
                    14. Analizar Grupo
                    15. Nota Alumno
                    16. Salir""");
            opc = scan.nextInt();
        } while (opc < 1 || opc > 16);
        return opc;
    }
}
