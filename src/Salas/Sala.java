package Salas;

import Miscelaneo.Objetos;
import Miscelaneo.Pista;

import java.util.ArrayList;

public class Sala {

    private static int idCounter = 0;
    private int id;
    private String nombre;
    private TypeDifficulty typeDifficulty;
    private double precioSala;
    private ArrayList<Pista> pistas = new ArrayList<>();
    private ArrayList<Objetos> objetos = new ArrayList<>();

    public Sala(int id, String nombre, TypeDifficulty typeDifficulty, double precioSala, ArrayList<Pista> pistas, ArrayList<Objetos> objetos) {
        this.id = ++idCounter;
        this.nombre = nombre;
        this.typeDifficulty = typeDifficulty;
        this.precioSala = precioSala;
        this.pistas = pistas;
        this.objetos = objetos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDificultad() {
        return typeDifficulty.name();
    }

    public double getPrecioSala() {
        return precioSala;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDificultad(TypeDifficulty typeDifficulty) {
        this.typeDifficulty = typeDifficulty;
    }

    public void setPrecioSala(double precioSala) {
        this.precioSala = precioSala;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public ArrayList<Objetos> getObjetos() {
        return objetos;
    }

    public void setPistas(ArrayList<Pista> pistas) {
        this.pistas = pistas;
    }

    public void setObjetos(ArrayList<Objetos> objetos) {
        this.objetos = objetos;
    }

    @Override
    public String toString() {
        return "Room = " +
                " ID = " + id +
                "| Name = " + nombre +
                "| Difficulty level= " + typeDifficulty +
                "| Room price = " + precioSala +"\n"+
                "| Clues = " + pistas +"\n"+
                "| Objects = " + objetos+"\n";

    }

    public void setPrecio(double precioSala) {
        this.precioSala = precioSala;
    }
}
