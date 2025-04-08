public class RobotHumanoide implements PrototipoHumanoide {
    private ComponenteRobot estructura;
    private String nombre;
    private String serie;

    public RobotHumanoide(ComponenteRobot estructura, String nombre, String serie) {
        this.estructura = estructura;
        this.nombre = nombre;
        this.serie = serie;
    }

    public void mostrarDetalles() {
        System.out.println(obtenerDetalles());
    }

    public String obtenerDetalles() {
        return "Robot Humanoide\nNombre: " + nombre + "\nSerie: " + serie + "\nComponentes:\n" + estructura.obtenerDetalles();
    }

    @Override
    public PrototipoHumanoide clonar() {
        ComponenteRobot estructuraClonada = clonarComp(estructura);
        return new RobotHumanoide(estructuraClonada, nombre, serie); // mantiene serie
    }

    private ComponenteRobot clonarComp(ComponenteRobot original) {
        if (original instanceof ParteSimple) {
            ParteSimple parte = (ParteSimple) original;
            return new ParteSimple(parte.getNombre());
        } else if (original instanceof ModuloCompuesto) {
            ModuloCompuesto originalModulo = (ModuloCompuesto) original;
            ModuloCompuesto nuevoModulo = new ModuloCompuesto(originalModulo.getNombre());
            for (ComponenteRobot sub : originalModulo.getComponentes()) {
                nuevoModulo.agregarComponente(clonarComp(sub));
            }
            return nuevoModulo;
        }
        return null;
    }
}
