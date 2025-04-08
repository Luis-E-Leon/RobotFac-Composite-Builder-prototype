public class RobotMascota {
    private ComponenteRobot estructura;

    public RobotMascota(ComponenteRobot estructura) {
        this.estructura = estructura;
    }

    public void mostrarDetalles() {
        estructura.mostrarDetalles();
    }
    public String obtenerDetalles() {
        return estructura.obtenerDetalles(); 
    }
}
