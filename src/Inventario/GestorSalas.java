package Inventario;

import Excepciones.SalaExistente;
import Miscelaneo.Objetos;
import Miscelaneo.Pista;
import Salas.Sala;
import Salas.TypeDifficulty;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GestorSalas {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Sala> salas = new ArrayList<>();
    private static int idCounter = 1;

    public static void crearSala()  throws SalaExistente{
        String nombre;
        TypeDifficulty typeDifficulty = null;

        try {
            System.out.println("Tell me the name of the room:");
            nombre = scanner.nextLine();

            for (Sala sala : salas) {
                if (sala.getNombre().equalsIgnoreCase(nombre)) {
                    throw new SalaExistente("The room '" + nombre + "' already exists.");
                }
            }
            System.out.println("Tell me the level of the room: (HARD, NORMAL, EASY)");
            String nivelDificultad = scanner.nextLine().toUpperCase().substring(0, 1);
            switch (nivelDificultad) {
                case "H":
                    typeDifficulty = TypeDifficulty.HARD;
                    break;
                case "N":
                    typeDifficulty = TypeDifficulty.NORMAL;
                    break;
                case "E":
                    typeDifficulty = TypeDifficulty.EASY;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid difficulty level");
            }

            ArrayList<Pista> pistas = new ArrayList<>();
            ArrayList<Objetos> objetos = new ArrayList<>();
            double precioSala = obtenerPrecioSala(objetos, pistas);
            Sala sala = new Sala(idCounter++, nombre, typeDifficulty, precioSala, pistas, objetos);
            salas.add(sala);
            System.out.println("Room created");
            System.out.println(sala+"\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double obtenerPrecioSala(ArrayList<Objetos> objetos, ArrayList<Pista> pistas) {
        double precioSala = 0;
        for (Objetos objeto : objetos) {
            precioSala += objeto.getPrecio() * objeto.getTipoIva().getPorcentaje();
        }
        for (Pista pista : pistas) {
            precioSala += pista.getPrecio() + pista.getPrecio() * pista.getTipoIVA().getPorcentaje();
        }
        return precioSala;
    }

    public static Sala escogerSala() {
        System.out.println("Choose a room");

        IntStream.range(0, salas.size())
                .forEach(i -> System.out.println((i + 1) + ". " + salas.get(i).getNombre()));
        int salaEscogida;
        try {
            salaEscogida = scanner.nextInt() - 1;
        } catch (InputMismatchException e) {
            scanner.next();
            throw new InputMismatchException("Error: An integer was expected to select the room.");
        }
        if (salaEscogida < 0 || salaEscogida >= salas.size()) {
            throw new IndexOutOfBoundsException("Error: The room number entered is out of range.");
        }
        return salas.get(salaEscogida);
    }
}
