public class ParteSimple implements ComponenteRobot {
    private String nombre;

    public ParteSimple(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Parte: " + nombre);
    }
    @Override
    public String obtenerDetalles() {
        return "Parte: " + nombre + "\n";
    }

    public String getNombre() {
        return nombre;
    }
    
}
