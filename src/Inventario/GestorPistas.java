package Inventario;

import Excepciones.NoSalaDisponibleException;
import Miscelaneo.Pista;
import Miscelaneo.TipoIVA;
import Salas.Sala;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static Inventario.GestorSalas.*;

public class GestorPistas {

    private static Pista pista1 = new Pista(1, "CLUE 1", 10.0, "60 min.", "FEAR", TipoIVA.IVA_10);
    private static Pista pista2 = new Pista(2, "CLUE 2", 15.0, "30 min.", "FE", TipoIVA.IVA_10);
    private static Pista pista3 = new Pista(3, "CLUE 3", 20.0, "200 min.", "ACTION", TipoIVA.IVA_10);
    private static Pista pista4 = new Pista(4, "CLUE 4", 25.0, "150 min.", "ACTION", TipoIVA.IVA_10);
    private static Pista pista5 = new Pista(5, "CLUE 5", 30.0, "100 min.", "ADVENTURE", TipoIVA.IVA_10);

    public static ArrayList<Pista> inventarioPistas = new ArrayList<>(List.of(pista1, pista2, pista3, pista4, pista5));

    public static void añadirPistaSala() {
        Sala sala = null;
        boolean salaSeleccionada = false;

        while (!salaSeleccionada) {
            try {
                sala = escogerSala();
                salaSeleccionada = true;
            } catch (NoSalaDisponibleException e) {
                System.out.println("Error: No rooms available.");
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: The selected room does not exist. Please try again.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: An integer was expected. Please try again.");
                scanner.nextLine();
            }
        }
        ArrayList<Pista> pistas;
        pistas = añadirAlCarritoPistas();
        //TODO posible nullpointerException
        sala.setPistas(pistas);
        double precioSala = obtenerPrecioSala(sala.getObjetos(), sala.getPistas());
        sala.setPrecio(precioSala);
        System.out.println("Added clues");
        System.out.println(sala);
    }

    private static ArrayList<Pista> añadirAlCarritoPistas() {
        ArrayList<Pista> pistas = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Add clue.");
                System.out.println("2. Exit.");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        Pista pista = escogerPista();
                        if (pista != null) {
                            pistas.add(pista);
                        }
                    }
                    case 2 -> {
                        return pistas;
                    }
                    default -> System.out.println("Invalid option. Please select 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: An integer was expected. Please try again.");
                scanner.next();
            }
        }
    }

    private static Pista escogerPista() {

        while (true) {
            try {
                for(int i = 0; i < inventarioPistas.size(); i++) {
                    System.out.println((i + 1) + ". " + inventarioPistas.get(i).getNombre());
                }
                System.out.println("Choose an option: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion > 0 && opcion <= inventarioPistas.size()) {
                    return inventarioPistas.get(opcion - 1);
                } else {
                    System.out.println("Invalid option. Please select one of the options.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: An integer was expected. Please try again.");
                scanner.next();
            }
        }
    }
}
