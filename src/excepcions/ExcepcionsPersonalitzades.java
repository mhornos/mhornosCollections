package excepcions;

public class ExcepcionsPersonalitzades {

    //excepcio quan es supera el limit de productes
    public static class LimitProductesException extends Exception {
        private static final String MISSATGE = "Error! No es poden afegir mes productes al carro";

        public LimitProductesException() {
            super(MISSATGE);
        }
    }

    //excepcio quan una data de caducitat no es valida
    public static class DataCaducitatException extends Exception {
        private static final String MISSATGE = "Error! La data de caducitat no pot ser anterior a avui";

        public DataCaducitatException() {
            super(MISSATGE);
        }
    }

    //excepcio quan el valor es negatiu
    public static class NegatiuException extends Exception {
        private static final String MISSATGE = "Error! El valor no pot ser negatiu";

        public NegatiuException() {
            super(MISSATGE);
        }
    }

    //excepcio quan un text supera el limit de caracters
    public static class LimitCaracteresException extends Exception {
        private static final String MISSATGE = "Error! El text supera el limit de caracters permes";

        public LimitCaracteresException() {
            super(MISSATGE);
        }
    }

    //excepcio per errors amb enums
    public static class EnumFailException extends Exception {
        private static final String MISSATGE = "Error en l'us de l'enumeració!";

        public EnumFailException() {
            super(MISSATGE);
        }
    }
}
