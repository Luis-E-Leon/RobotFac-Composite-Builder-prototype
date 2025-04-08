import java.util.ArrayList;
import java.util.List;

class ModuloCompuesto implements ComponenteRobot {
    private String nombre;
    private String serie; // Nueva propiedad
    private List<ComponenteRobot> componentes = new ArrayList<>();

    public ModuloCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public List<ComponenteRobot> getComponentes() {
        return componentes;
    }

    public void agregarComponente(ComponenteRobot componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponenteRobot componente) {
        componentes.remove(componente);
    }

    @Override
    public void establecerSerie(String serie) {
        this.serie = serie;
        for (ComponenteRobot componente : componentes) {
            componente.establecerSerie(serie); // Propagar la serie
        }
    }

    @Override
    public String obtenerSerie() {
        return serie;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Modulo: " + nombre );
        for (ComponenteRobot componente : componentes) {
            componente.mostrarDetalles();
        }
    }

    @Override
    public String obtenerDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Módulo: ").append(nombre).append("\n");
        for (ComponenteRobot c : componentes) {
            sb.append("  ").append(c.obtenerDetalles());
        }
        return sb.toString();
    }
}