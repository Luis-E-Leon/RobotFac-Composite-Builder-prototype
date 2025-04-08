public class Director {
    public void construirRobotBasico(RobotBuilder builder) {
        builder.reset();
        builder.construirCabeza();
        builder.construirCuerpo();
        builder.construirExtremidades();
    }
}
