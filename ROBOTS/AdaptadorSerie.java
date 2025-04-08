public class AdaptadorSerie implements GeneradorSerie {
    private GeneradorSerieHexadecimal adaptee;

    public AdaptadorSerie() {
        this.adaptee = new GeneradorSerieHexadecimal();
    }

    @Override
    public String generarSerie(String nombre) {
        return adaptee.convertirNombreASerie(nombre);
    }
}
