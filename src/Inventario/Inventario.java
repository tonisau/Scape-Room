package Inventario;

import Excepciones.NoHayObjetosDisponiblesException;
import Excepciones.NoSalaDisponibleException;
import Miscelaneo.Objetos;
import Miscelaneo.Pista;
import Salas.Sala;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

import static Inventario.GestorObjetos.inventarioObjetos;
import static Inventario.GestorPistas.inventarioPistas;
import static Inventario.GestorSalas.salas;

public class Inventario {

    static Scanner scanner = new Scanner(System.in);

    public static void mostrarInventario() {
        System.out.println("Inventory:");
        mostrarPistas();
        mostrarObjetos();
    }

    private static void mostrarPistas() {
        System.out.println("These are the available clues: ");
        IntStream.range(0, inventarioPistas.size())
                .forEach(i -> System.out.println((i + 1) + ". " + inventarioPistas.get(i).toString()));
    }

    private static void mostrarObjetos() {
        System.out.println("These are the available items: ");
        if (inventarioObjetos.isEmpty()) {
            throw new NoHayObjetosDisponiblesException("No items available.");
        }
        IntStream.range(0, inventarioObjetos.size())
                .forEach(i -> System.out.println((i + 1) + ". " + inventarioObjetos.get(i).toString()));
    }

    public static void retirarObjetosInventario() {
        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Remove item from inventory.");
                System.out.println("2. Exit.");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        retirarObjeto();
                        break;
                    case 2:
                        System.out.println("Leaving...");
                        return;
                    default:
                        System.out.println("Invalid option. Please select 1 or 2.");
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Error: An integer was expected. Please try again..");
            }
        }
    }

    private static void retirarObjeto() {
        while (true) {
            try {
                if (inventarioObjetos.isEmpty()) {
                    throw new NoHayObjetosDisponiblesException("No items available.");
                }
                IntStream.range(0, inventarioObjetos.size())
                        .forEach(i -> System.out.println((i + 1) + ". " + inventarioObjetos.get(i).getNombre()));
                System.out.println("Choose an object: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion > 0 && opcion <= inventarioObjetos.size()) {
                    inventarioObjetos.remove(opcion - 1);
                    System.out.println("Object removed.");
                    return;
                } else {
                    System.out.println("Invalid option. Please select one of the options.");
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Error: An integer was expected. Please try again..");
            }
        }
    }

    public static void mostrarSalas() {
        if (salas.isEmpty()) {
            throw new NoSalaDisponibleException("There are no rooms available.");
        }
        System.out.println("These are the available rooms:");
        IntStream.range(0, salas.size())
                .forEach(i -> System.out.println((i + 1) + ". " + salas.get(i).toString()));
    }
}
