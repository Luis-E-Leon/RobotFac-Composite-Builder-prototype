
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.util.Scanner;

public class main {
    private static RobotHumanoide ultimoHumanoideCreado = null;

    public static void main(String[] args) {
        String[] opciones = {"Consola", "Interfaz Gráfica"};
        int seleccion = JOptionPane.showOptionDialog(null,
                "¿Cómo desea ingresar la información?",
                "Modo de Entrada",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion == 0) {
            iniciarPorConsola();
        } else if (seleccion == 1) {
            SwingUtilities.invokeLater(() -> {
                try {
                    Test frame = new Test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else {
            System.out.println("No se seleccionó ninguna opción.");
        }
    }

    private static void iniciarPorConsola() {
        Scanner scanner = new Scanner(System.in);
        Director director = new Director();
        RobotHumanoideBuilder humanoideBuilder = new RobotHumanoideBuilder();
        RobotMascotaBuilder mascotaBuilder = new RobotMascotaBuilder();

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Construir Robot Humanoide");
            System.out.println("2. Construir Robot Mascota");
            System.out.println("3. Clonar Último Robot Humanoide");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                System.out.print("Ingresa el nombre del Robot Humanoide: ");
                scanner.nextLine(); 
                String nombre = scanner.nextLine();
            
                humanoideBuilder.establecerNombre(nombre); 
            
                director.construirRobotBasico(humanoideBuilder);
                ultimoHumanoideCreado = humanoideBuilder.obtenerRobot();
                System.out.println("Robot Humanoide construido:");
                ultimoHumanoideCreado.mostrarDetalles();
                break;
            
                case 2:
                    director.construirRobotBasico(mascotaBuilder);
                    RobotMascota mascota = mascotaBuilder.obtenerRobot();
                    System.out.println("Robot Mascota construido:");
                    mascota.mostrarDetalles();
                    break;
                case 3:
                    if (ultimoHumanoideCreado != null) {
                        RobotHumanoide clon = (RobotHumanoide) ultimoHumanoideCreado.clonar();
                        System.out.println("Robot Humanoide clonado:");
                        clon.mostrarDetalles();
                    } else {
                        System.out.println("No hay robot humanoide para clonar.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

class Test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RobotHumanoide ultimoHumanoideCreado;

    public Test() {
        setTitle("Constructor de Robots");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 565, 447);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(70, 130, 180));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Robot Factory");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 36));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(133, 27, 276, 68);
        contentPane.add(lblNewLabel);

        JButton btnHumanoide = new JButton("Construir Robot Humanoide");
        btnHumanoide.setFont(new Font("Roboto Light", Font.BOLD, 13));
        btnHumanoide.setBackground(new Color(70, 130, 180));
        btnHumanoide.setBounds(170, 168, 200, 30);
        contentPane.add(btnHumanoide);

        JButton btnMascota = new JButton("Construir Robot Mascota");
        btnMascota.setFont(new Font("Roboto Light", Font.BOLD, 13));
        btnMascota.setBackground(new Color(70, 130, 180));
        btnMascota.setBounds(170, 209, 200, 30);
        contentPane.add(btnMascota);

        JButton btnClonar = new JButton("Clonar Último Humanoide");
        btnClonar.setFont(new Font("Roboto Light", Font.BOLD, 13));
        btnClonar.setBackground(new Color(70, 130, 180));
        btnClonar.setBounds(170, 250, 200, 30);
        contentPane.add(btnClonar);

        JLabel lblImagen = new JLabel("");
        lblImagen.setBounds(0, 259, 160, 149);
        contentPane.add(lblImagen);
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Imagen/Robot.png"));
        Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(160, 149, Image.SCALE_SMOOTH);
        Icon iconoFinal = new ImageIcon(imagenRedimensionada);
        lblImagen.setIcon(iconoFinal);

        btnHumanoide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingresa el nombre del Robot Humanoide:");
                if (nombre == null || nombre.isEmpty()) return;
        
                Director director = new Director();
                RobotHumanoideBuilder builder = new RobotHumanoideBuilder();
                builder.establecerNombre(nombre);
                director.construirRobotBasico(builder);
                ultimoHumanoideCreado = builder.obtenerRobot();
                mostrarDetallesConImagen(ultimoHumanoideCreado.obtenerDetalles());
            }
        });

        btnMascota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Director director = new Director();
                RobotMascotaBuilder builder = new RobotMascotaBuilder();
                director.construirRobotBasico(builder);
                RobotMascota robot = builder.obtenerRobot();
                JOptionPane.showMessageDialog(null, "Robot Mascota construido exitosamente.");
                mostrarDetallesConImagenMascota(robot.obtenerDetalles()); 
            }
        });
        

        btnClonar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ultimoHumanoideCreado != null) {
                    RobotHumanoide clon = (RobotHumanoide) ultimoHumanoideCreado.clonar();
                    mostrarDetallesConImagen(clon.obtenerDetalles());
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debes construir un Robot Humanoide.");
                }
            }
        });
        
    }
    private void mostrarDetallesConImagen(String detalles) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/Robot.png"));
        Image imagenRedimensionada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Icon iconoFinal = new ImageIcon(imagenRedimensionada);
    
        JTextArea textArea = new JTextArea(detalles);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(300, 150));
    
        JOptionPane.showMessageDialog(this, scrollPane, "Detalles del Robot", JOptionPane.INFORMATION_MESSAGE, iconoFinal);
    }
    private void mostrarDetallesConImagenMascota(String detalles) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/perro.png"));
        Image imagenRedimensionada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Icon iconoFinal = new ImageIcon(imagenRedimensionada);
    
        JTextArea textArea = new JTextArea(detalles);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(300, 150));
    
        JOptionPane.showMessageDialog(this, scrollPane, "Detalles del Robot", JOptionPane.INFORMATION_MESSAGE, iconoFinal);
    }
    
}
