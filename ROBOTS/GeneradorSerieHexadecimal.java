public class GeneradorSerieHexadecimal {
    public String convertirNombreASerie(String nombre) {
        return Integer.toHexString(nombre.hashCode()).toUpperCase();
    }
}
