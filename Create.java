import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

class Create{
    Create() {

        // JFrame
        JFrame frame = new JFrame("Create and Save");

        // Image icon
        ImageIcon icon = new ImageIcon(Main.class.getResource("notebook.png"));
        frame.setIconImage(icon.getImage());

        // JPanels
        JPanel panel = new JPanel();
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        // JLabels
        JLabel create = new JLabel("Create file");
        JLabel save = new JLabel("Save");
        JLabel createandsavelabel = new JLabel("Create :");
        JLabel name = new JLabel("File Name :");

        // Text field for the create field
        JTextField create_field = new JTextField(20);

        // Creating text area for our content
        JTextArea save_area = new JTextArea(40, 20);

        // Buttons
        JButton create_button = new JButton("Create");
        JButton save_button = new JButton("Save");

        // Image labels
        ImageIcon frame_c = new ImageIcon(Main.class.getResource("create.png"));
        JLabel imageicon3 = new JLabel(frame_c);
        imageicon3.setBounds(50, 45, 40, 35);

        // Adding a scroll pane to the save area
        JScrollPane saveScrollPane = new JScrollPane(save_area);
        saveScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



        // Setting positions and sizes of components
        createandsavelabel.setBounds(110, 35, 380, 50);
        name.setBounds(40, 105, 200, 50);
        name.setFont(new Font("Serif", Font.BOLD, 22));
        create_field.setBounds(170, 105, 300, 50);
        create_button.setBounds(480, 105, 80, 50);
        saveScrollPane.setBounds(120, 180, 440, 350);
        save_button.setBounds(120, 540, 80, 50);



        // Setting borders and fonts
        int textfieldthickness = 1;
        create_field.setBorder(BorderFactory.createLineBorder(Color.black, textfieldthickness));
        int textareathickness = 1;
        save_area.setBorder(BorderFactory.createLineBorder(Color.black, textareathickness));
        createandsavelabel.setFont(new Font("Serif", Font.BOLD, 28));
        createandsavelabel.setForeground(Color.DARK_GRAY);

        // Adding components to the panel
        panel2.add(createandsavelabel);
        panel2.add(imageicon3);
        panel2.add(create_field);
        panel2.add(create_button);
        panel2.add(saveScrollPane);
        panel2.add(save_button);
        panel2.add(name);


        // First panel
        panel0.add(panel1);
        int borderthickness = 20;
        panel0.setBorder(BorderFactory.createLineBorder(new Color(26, 219, 200), borderthickness));
        panel0.setLayout(null);

        // Second panel
        panel0.add(panel1);
        panel1.setSize(750, 720);
        panel1.setBounds(42, 35, 750, 700);
        panel1.setBackground(new Color(26, 219, 200));
        panel1.setLayout(null);

        // Third panel
        panel1.add(panel2);
        panel2.setSize(670, 620);
        panel2.setBounds(40, 38, 670, 620);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(null);

        panel.setLayout(null);
        frame.add(panel0);
        frame.setSize(850, 820);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Action listener for the create button
        create_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = create_field.getText();

                if (!create_field.getText().isEmpty()) {
                    File file = new File(fileName + ".txt");
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill the name of file before creating the file.");
                }
            }
        });

        // Action listener for the save button
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = create_field.getText();
                String content = save_area.getText();

                if (!content.isEmpty()) {
                    try {
                        FileWriter write = new FileWriter(fileName + ".txt", true);
                        write.write(content);
                        write.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please add a note before saving the file.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Create();
    }
}
