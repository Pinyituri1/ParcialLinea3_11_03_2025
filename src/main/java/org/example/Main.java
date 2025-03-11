package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CabinaTelefonica> cabinas = new ArrayList<>();
        CabinaTelefonica cabinaSeleccionada = null;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear cabina telefónica");
            System.out.println("2. Registrar llamada");
            System.out.println("3. Mostrar información por cabina");
            System.out.println("4. Mostrar información de todas las cabinas");
            System.out.println("5. Reiniciar cabina");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 6) {
                System.out.println("Saliendo...");
                sc.close();
                return;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID de la cabina: ");
                    String idCabina = sc.nextLine();
                    CabinaTelefonica nuevaCabina = new CabinaTelefonica(idCabina);
                    cabinas.add(nuevaCabina);
                    System.out.println("Cabina creada correctamente.");
                    break;

                case 2:
                    System.out.println("Ingrese el ID de la cabina a seleccionar: ");
                    idCabina = sc.nextLine();
                    cabinaSeleccionada = buscarCabina(cabinas, idCabina);
                    if (cabinaSeleccionada != null) {
                        System.out.println("Ingrese el tipo de llamada (local, larga_distancia, celular): ");
                        String tipo = sc.nextLine();
                        int duracion = (int) (Math.random() * 10) + 1;
                        System.out.println("\nDuracion en minutos: " + duracion);
                        cabinaSeleccionada.registrarLlamada(tipo, duracion);
                    } else {
                        System.out.println("No hay ninguna cabina seleccionada.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la cabina a seleccionar: ");
                    idCabina = sc.nextLine();
                    cabinaSeleccionada = buscarCabina(cabinas, idCabina);
                    if (cabinaSeleccionada != null) {
                        System.out.println(cabinaSeleccionada.obtenerInforme());
                    } else {
                        System.out.println("No hay ninguna cabina seleccionada.");
                    }
                    break;
                case 4:
                    if (!cabinas.isEmpty()) {
                        for (CabinaTelefonica c : cabinas) {
                            System.out.println(c.obtenerInforme());
                        }
                    } else {
                        System.out.println("No hay cabinas registradas.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el ID de la cabina a seleccionar: ");
                    idCabina = sc.nextLine();
                    cabinaSeleccionada = buscarCabina(cabinas, idCabina);
                    if (cabinaSeleccionada != null) {
                        cabinaSeleccionada.reiniciarCabina();
                        System.out.println("Cabina reiniciada.");
                    } else {
                        System.out.println("No hay ninguna cabina seleccionada.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static CabinaTelefonica buscarCabina(ArrayList<CabinaTelefonica> cabinas, String idCabina) {
        for (CabinaTelefonica cabina : cabinas) {
            if (cabina.getIdCabina().equals(idCabina)) {
                return cabina;
            }
        }
        System.out.println("Cabina no encontrada.");
        return null;
    }
}