import java.util.ArrayList;
import java.util.List;

class ModuloCompuesto implements ComponenteRobot {
    private String nombre;
    private List<ComponenteRobot> componentes = new ArrayList<>();

    public ModuloCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public void agregarComponente(ComponenteRobot componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponenteRobot componente) {
        componentes.remove(componente);
    }

    public String getNombre() {
        return nombre;
    }
    
    public List<ComponenteRobot> getComponentes() {
        return componentes;
    }
    

    @Override
    public void mostrarDetalles() {
        System.out.println("Modulo: " + nombre);
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