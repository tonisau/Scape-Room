package Inventario;

import Excepciones.NoHayObjetosDisponiblesException;
import Excepciones.ObjetoNoDisponibleException;
import Miscelaneo.Objetos;
import Miscelaneo.TipoIVA;
import Miscelaneo.TypeMaterial;
import Salas.Sala;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static Inventario.GestorSalas.*;

public class GestorObjetos {

    private static final Objetos hacha = new Objetos(1, "AXE", 10.0, TypeMaterial.Madera, 10, TipoIVA.IVA_21);
    private static Objetos martillo = new Objetos(2, "HAMMER", 20.0, TypeMaterial.Metal, 5, TipoIVA.IVA_21);
    private static Objetos pala = new Objetos(3, "SHOVEL", 30.0, TypeMaterial.Madera, 15, TipoIVA.IVA_21);
    private static Objetos llave = new Objetos(4, "KEY", 2.0, TypeMaterial.Metal, 20, TipoIVA.IVA_21);
    private static Objetos laser = new Objetos(5, "LASER", 10.0, TypeMaterial.Plastico, 20, TipoIVA.IVA_21);
    private static Objetos boligrafo = new Objetos(6, "PEN", 1.0, TypeMaterial.Plastico, 15, TipoIVA.IVA_21);



    public static ArrayList<Objetos> inventarioObjetos = new ArrayList<>(List.of(hacha, martillo, pala, llave, laser, boligrafo));


    public static void añadirObjetosSala() {
        Sala sala = escogerSala();
        ArrayList<Objetos> objetos = new ArrayList<>();
        objetos = añadirAlCarritoObjetos();
        sala.setObjetos(objetos);
        double precioSala = obtenerPrecioSala(sala.getObjetos(), sala.getPistas());
        sala.setPrecio(precioSala);
        System.out.println("Added Items");
        System.out.println(sala);
    }

    private static ArrayList<Objetos> añadirAlCarritoObjetos() {
        ArrayList<Objetos> objetos = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Add Object.");
                System.out.println("2. Exit.");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        try {
                            Objetos objeto = escogerObjeto();
                            objetos.add(objeto);
                        } catch (NoHayObjetosDisponiblesException | ObjetoNoDisponibleException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        return objetos;
                    default:
                        System.out.println("Invalid option. Please select 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: An integer was expected. Please try again.");
                scanner.next();
            }
        }
    }


    private static Objetos escogerObjeto() {
        if (inventarioObjetos.isEmpty()) {
            throw new NoHayObjetosDisponiblesException("There are no items available.");
        }

        while (true) {
            try {
                for (int i = 0; i < inventarioObjetos.size(); i++) {
                    System.out.println((i + 1) + ". " + inventarioObjetos.get(i).getNombre());
                }
                System.out.println("Choose an object: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion > 0 && opcion <= inventarioObjetos.size()) {
                    if (inventarioObjetos.get(opcion - 1).getStock() == 0) {
                        throw new ObjetoNoDisponibleException("The object is not available.");
                    }

                    inventarioObjetos.get(opcion - 1).setStock(inventarioObjetos.get(opcion - 1).getStock() - 1);
                    return inventarioObjetos.get(opcion - 1);
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
