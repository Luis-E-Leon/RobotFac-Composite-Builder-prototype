public class ParteSimple implements ComponenteRobot {
    private String nombre;
    private String serie; // Nueva propiedad

    public ParteSimple(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Parte: " + nombre );
    }

    @Override
    public String obtenerDetalles() {
        return "Parte: " + nombre + "\n";
    }

    @Override
    public void establecerSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String obtenerSerie() {
        return serie;
    }

    public String getNombre() {
        return nombre;
    }
}