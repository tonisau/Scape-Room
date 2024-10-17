package Miscelaneo;

public enum TypeMaterial {
    Madera,
    Metal,
    Plastico,
    Vidrio;

    public String getMaterial() {
        switch (this) {
            case Madera:
                return "Wood";
            case Metal:
                return "Metal";
            case Plastico:
                return "Plastic";
            case Vidrio:
                return "Glass";
            default:
                return null;
        }
    }


}
