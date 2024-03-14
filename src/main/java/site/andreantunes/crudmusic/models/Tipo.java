package site.andreantunes.crudmusic.models;

public enum Tipo {
    SOLO("Solo"),
    DUPLA("Dupla"),
    BANDA("Banda");

    private String tipoString;

    Tipo(String tipoString) {
        this.tipoString = tipoString;
    }

    public static Tipo converteTipo(String text) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.tipoString.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo invalido: " + text);
    }
}
