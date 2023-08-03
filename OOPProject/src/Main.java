import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        // JFrame
        JFrame frame = new JFrame("Personal Productivity Application");

        // Image icon
        ImageIcon icon = new ImageIcon(Main.class.getResource("notebook.png"));
        frame.setIconImage(icon.getImage());

        // JPanels
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        // JLabels
        JLabel label1 = new JLabel(" N O T E S ");
        JLabel label2 = new JLabel("Create :");
        JLabel label3 = new JLabel("Read :");
        JLabel label4 = new JLabel("Schedule :");
        JLabel label5 = new JLabel("Delete :");

        // Image labels
        ImageIcon frame_a = new ImageIcon(Main.class.getResource("notes.jpg"));
        JLabel imageicon1 = new JLabel(frame_a);
        imageicon1.setBounds(60, 55, 50, 50);

        ImageIcon frame_b = new ImageIcon(Main.class.getResource("read.png"));
        JLabel imageicon2 = new JLabel(frame_b);
        imageicon2.setBounds(20, 15, 40, 35);

        ImageIcon frame_c = new ImageIcon(Main.class.getResource("create.png"));
        JLabel imageicon3 = new JLabel(frame_c);
        imageicon3.setBounds(20, 15, 40, 35);

        ImageIcon frame_d = new ImageIcon(Main.class.getResource("calendar.png"));
        JLabel imageicon4 = new JLabel(frame_d);
        imageicon4.setBounds(20, 15, 40, 35);

        ImageIcon frame_e = new ImageIcon(Main.class.getResource("delete.png"));
        JLabel imageicon5 = new JLabel(frame_e);
        imageicon5.setBounds(20, 15, 40, 35);

        ImageIcon frame_f = new ImageIcon(Main.class.getResource("plus.png"));
        JLabel imageicon6 = new JLabel(frame_f);
        imageicon6.setBounds(130, 63, 100, 100);

        ImageIcon frame_g = new ImageIcon(Main.class.getResource("plus1.png"));
        JLabel imageicon7 = new JLabel(frame_g);
        imageicon7.setBounds(127, 60, 100, 100);

        ImageIcon frame_h = new ImageIcon(Main.class.getResource("plus2.png"));
        JLabel imageicon8 = new JLabel(frame_h);
        imageicon8.setBounds(127, 60, 100, 100);

        ImageIcon frame_i = new ImageIcon(Main.class.getResource("plus3.png"));
        JLabel imageicon9 = new JLabel(frame_i);
        imageicon9.setBounds(127, 60, 100, 100);

        // Labels properties
        label1.setBounds(130, 57, 200, 40);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Serif", Font.BOLD, 30));

        label2.setBounds(75, 10, 200, 40);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Serif", Font.BOLD, 20));

        label3.setBounds(75, 10, 200, 40);
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Serif", Font.BOLD, 20));

        label4.setBounds(75, 10, 200, 40);
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("Serif", Font.BOLD, 20));

        label5.setBounds(75, 10, 200, 40);
        label5.setForeground(Color.BLACK);
        label5.setFont(new Font("Serif", Font.BOLD, 20));

        // First panel
        panel0.add(panel1);
        int borderthickness = 20;
        panel0.setBorder(BorderFactory.createLineBorder(Color.lightGray, borderthickness));
        panel0.setLayout(null);

        // Second panel
        panel0.add(panel1);
        panel1.setSize(750, 720);
        panel1.setBounds(42, 35, 750, 700);
        panel1.setBackground(Color.lightGray);
        panel1.setLayout(null);

        // Third panel
        panel1.add(panel2);
        panel2.setSize(670, 620);
        panel2.setBounds(40, 38, 670, 620);
        panel2.add(label1);
        panel2.add(imageicon1);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(null);

        // Fourth panel
        panel2.add(panel3);
        panel3.setBackground((new Color(26, 219, 200)));
        panel3.setSize(250, 180);
        panel3.add(imageicon3);
        panel3.add(label2);
        panel3.add(imageicon6);
        panel3.setBounds(60, 150, 250, 180);
        panel3.setLayout(null);

        // Fifth panel
        panel2.add(panel4);
        panel4.setBackground(new Color(184, 149, 218));
        panel4.setSize(250, 180);
        panel4.add(imageicon2);
        panel4.add(label3);
        panel4.add(imageicon7);
        panel4.setBounds(360, 150, 250, 180);
        panel4.setLayout(null);

        // Sixth panel
        panel2.add(panel5);
        panel5.setBackground(new Color(118, 184, 249));
        panel5.setSize(250, 180);
        panel5.add(imageicon5);
        panel5.add(label5);
        panel5.add(imageicon8);
        panel5.setBounds(360, 380, 250, 180);
        panel5.setLayout(null);

        // Seventh panel
        panel2.add(panel6);
        panel6.setBackground(new Color(235, 186, 185));
        panel6.setSize(250, 180);
        panel6.add(imageicon4);
        panel6.add(label4);
        panel6.add(imageicon9);
        panel6.setBounds(60, 380, 250, 180);
        panel6.setLayout(null);

        // Add panels to frame
        frame.add(panel0);
        frame.setSize(850, 820);
        frame.setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Event listeners for image icons
        imageicon6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Create();
            }
        });

        imageicon7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Read();
            }
        });

        imageicon9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Schedule();
            }
        });

        imageicon8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Delete();
            }
        });
    }
}
















