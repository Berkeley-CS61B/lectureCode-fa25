import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * SHAPE PARTY - A Pull Request Demo
 * * INSTRUCTIONS:
 * 1. Compile everything: javac *.java
 * 2. Run: java ShapeParty
 */
public class ShapeParty extends JPanel implements ActionListener {

    // ==========================================
    //           CORE ENGINE LOGIC
    // ==========================================

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final List<FloatingShape> shapes = new ArrayList<>();
    private final Timer timer;

    public ShapeParty(List<PartyShape> plugins) {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.DARK_GRAY);

        Random rand = new Random();

        // Wrap the raw shape definitions in a "Floating" container
        // that manages physics (position, rotation, velocity)
        for (PartyShape p : plugins) {
            shapes.add(new FloatingShape(p, 
                rand.nextInt(WIDTH), rand.nextInt(HEIGHT), 
                rand.nextDouble() * 4 - 2, rand.nextDouble() * 4 - 2));
        }

        // Animation loop (60 FPS)
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Enable anti-aliasing for smoother lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw all shapes
        for (FloatingShape fs : shapes) {
            fs.render(g2d);
        }
        
        // Draw Overlay Info
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Loaded Shapes: " + shapes.size(), 10, 20);
        g2d.drawString("Create a java file implementing 'PartyShape' to join!", 10, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update physics
        for (FloatingShape fs : shapes) {
            fs.update();
        }
        repaint();
    }

    // A container that moves the student's shape around the screen
    private static class FloatingShape {
        private final PartyShape shapeLogic;
        private double x, y;
        private double dx, dy;
        private double rotation = 0;
        private double rotationSpeed;

        public FloatingShape(PartyShape shapeLogic, double x, double y, double dx, double dy) {
            this.shapeLogic = shapeLogic;
            this.x = x;
            this.y = y;
            this.dx = (dx == 0) ? 1 : dx;
            this.dy = (dy == 0) ? 1 : dy;
            this.rotationSpeed = (Math.random() * 4) - 2;
        }

        public void update() {
            x += dx;
            y += dy;
            rotation += rotationSpeed;

            // Bounce off walls
            if (x < 0 || x > WIDTH) dx = -dx;
            if (y < 0 || y > HEIGHT) dy = -dy;
        }

        public void render(Graphics2D g2d) {
            // Save current transform
            java.awt.geom.AffineTransform old = g2d.getTransform();

            // Move to shape position and rotate
            g2d.translate(x, y);
            g2d.rotate(Math.toRadians(rotation));

            // Create a turtle bound to this specific graphics context
            Turtle t = new Turtle(g2d);
            
            // Let the student code draw
            try {
                shapeLogic.draw(t);
            } catch (Exception e) {
                // If student code crashes, draw a red X
                g2d.setColor(Color.RED);
                g2d.drawLine(-20, -20, 20, 20);
                g2d.drawLine(20, -20, -20, 20);
            }

            // Restore transform so next shape isn't messed up
            g2d.setTransform(old);
        }
    }

    // ==========================================
    //           DYNAMIC CLASS LOADER
    // ==========================================

    public static void main(String[] args) {
        System.out.println("Starting ShapeParty...");
        
        List<PartyShape> plugins = new ArrayList<>();
        
        // 1. Add the built-in default
        plugins.add(new DefaultSquare());

        // 2. Scan for external Student implementations
        try {
            File currentDir = new File(System.getProperty("user.dir"));
            System.out.println("Scanning directory: " + currentDir.getAbsolutePath());
            
            // Create a class loader for the current directory
            URL[] urls = new URL[]{currentDir.toURI().toURL()};
            URLClassLoader loader = new URLClassLoader(urls);

            File[] files = currentDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".class") && !file.getName().contains("$")) {
                        String className = file.getName().replace(".class", "");
                        
                        try {
                            Class<?> cls = loader.loadClass(className);
                            
                            // Check if this class implements PartyShape
                            if (PartyShape.class.isAssignableFrom(cls) 
                                && !cls.isInterface() 
                                && !Modifier.isAbstract(cls.getModifiers())) {
                                
                                // Avoid re-adding the internal Main/Default classes if they appear in scan
                                if (cls.getName().equals(ShapeParty.class.getName()) || 
                                    cls.getName().equals(DefaultSquare.class.getName())) {
                                    continue;
                                }

                                System.out.println("Found Student Shape: " + className);
                                plugins.add((PartyShape) cls.getDeclaredConstructor().newInstance());
                            }
                        } catch (Exception e) {
                            // Ignore files that aren't valid shapes or fail to load
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error scanning for plugins: " + e.getMessage());
            e.printStackTrace();
        }

        // 3. Launch GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Classroom Shape Party");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ShapeParty(plugins));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}