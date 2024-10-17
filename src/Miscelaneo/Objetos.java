package Miscelaneo;

public class Objetos {

    private static int id;
    private String nombre;
    private double precio;
    private TypeMaterial typeMaterial;
    private int stock;
    private TipoIVA tipoIva;
    public Objetos(int id, String nombre, double precio, TypeMaterial typeMaterial, int stock, TipoIVA tipoIva) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.typeMaterial = typeMaterial;
        this.stock = stock;
        this.tipoIva = tipoIva;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMaterial() {
        return typeMaterial.toString();
    }

    public int getStock() {
        return stock;
    }

    public TipoIVA getTipoIva() {
        return tipoIva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio * getTipoIva().getPorcentaje();
    }

    public void setMaterial(String material) {
        this.typeMaterial = typeMaterial;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTipoIva(TipoIVA tipoIva) {
        this.tipoIva = tipoIva;
    }

    @Override
    public String toString() {
        return "Objects = " +
                " ID = " + id +
                "| Name= " + nombre +
                "| Price = " + precio +
                "| Material = " + typeMaterial + '\'' +
                "| Stock = " + stock +
                "| Type of VAT = " + tipoIva;

    }

}
