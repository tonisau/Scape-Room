package Salas;

public enum TypeDifficulty {

    EASY,
    NORMAL,
    HARD;

    public String getDificultad() {
        switch (this) {
            case EASY:
                return "Easy";
            case NORMAL:
                return "Normal";
            case HARD:
                return "Hard";
            default:
                return null;
        }
    }
}
