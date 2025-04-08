public class RobotHumanoideBuilder implements RobotBuilder {
    private ComponenteRobot estructura;
    private String nombre;
    private GeneradorSerie adaptador = new AdaptadorSerie();

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void reset() {
        estructura = null;
    }

    @Override
    public void construirCabeza() {
        estructura = new ModuloCompuesto("Cabeza");
        ((ModuloCompuesto) estructura).agregarComponente(new ParteSimple("Sensor"));
    }

    @Override
    public void construirCuerpo() {
        ((ModuloCompuesto) estructura).agregarComponente(new ParteSimple("Cuerpo metálico"));
    }

    @Override
    public void construirExtremidades() {
        ((ModuloCompuesto) estructura).agregarComponente(new ParteSimple("Piernas hidráulicas"));
    }

    public RobotHumanoide obtenerRobot() {
        String numeroSerie = adaptador.generarSerie(nombre);
        return new RobotHumanoide(estructura, nombre, numeroSerie);
    }
}
