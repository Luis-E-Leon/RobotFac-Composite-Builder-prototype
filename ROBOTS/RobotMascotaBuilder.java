public class RobotMascotaBuilder implements RobotBuilder {
    private ModuloCompuesto robot;

    @Override
    public void reset() {
        robot = new ModuloCompuesto("Robot Mascota");
    }

    @Override
    public void construirCabeza() {
        robot.agregarComponente(new ParteSimple("Cabeza de Mascota"));
    }

    @Override
    public void construirCuerpo() {
        robot.agregarComponente(new ParteSimple("Cuerpo de Mascota"));
    }

    @Override
    public void construirExtremidades() {
        robot.agregarComponente(new ParteSimple("Patas de Mascota"));
    }

    public RobotMascota obtenerRobot() {
        return new RobotMascota(robot);
    }
}
