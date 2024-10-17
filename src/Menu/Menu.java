package Menu;

import Excepciones.NoSalaDisponibleException;
import Excepciones.SalaExistente;
import Inventario.Inventario;

import javax.naming.Name;
import java.util.InputMismatchException;
import java.util.Scanner;
import static Inventario.Inventario.*;
import static Inventario.GestorObjetos.*;

import static Inventario.GestorPistas.*;
import static Inventario.GestorSalas.*;

public class Menu {


    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion=0;

        do {

            try {
                System.out.println("*************\n" +
                        "MAIN MENU\n" +
                        "*************\n" +
                        "Select an option: \n" +
                        "-----------------\n" +
                        "1. Create new room.\n" +
                        "2. Add clues to a room.\n" +
                        "3. Add objects to a room.\n" +
                        "4. Show inventory.\n" +
                        "5. Remove elements from the inventory.\n" +
                        "6. Show available rooms.\n" +
                        "7. Exit.");
                opcion = scanner.nextInt();
                scanner.nextLine();
                String respuesta = "";

                switch (opcion) {
                    case 1:
                        respuesta("Create new room");
                        crearSala();
                        break;
                    case 2:
                        respuesta("Add clues to a room");
                        añadirPistaSala();
                        break;
                    case 3:
                        respuesta("Add objects to a room");
                        añadirObjetosSala();
                        break;
                    case 4:
                        respuesta("Show inventory");
                        mostrarInventario();
                        break;
                    case 5:
                        respuesta("Remove elements from the inventory");
                        retirarObjetosInventario();
                        break;
                    case 6:
                        respuesta("Show available rooms");
                        try {
                            mostrarSalas();
                        } catch (NoSalaDisponibleException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 7:
                        respuesta("Exit");
                        break;
                    default:
                        respuesta("Invalid option. Please select a valid option.");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println();
                System.out.println("Invalid entry. Please enter a number from the list.");
                scanner.nextLine();
            }
            catch(SalaExistente e){
                System.out.println();
                System.out.println("The room already exists. \n");

            }
        } while (opcion != 7);
    }

    private String respuesta(String respuesta){
        System.out.println(respuesta);
        return respuesta;
    }
}

