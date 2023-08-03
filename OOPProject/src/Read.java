import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Read {

    Read() {

        // JFrame
        JFrame frame = new JFrame("Read and Display File");

        // Image icon
        ImageIcon icon = new ImageIcon(Main.class.getResource("notebook.png"));
        frame.setIconImage(icon.getImage());

        // ImageIcon
        ImageIcon frame_c = new ImageIcon(Main.class.getResource("read.png"));
        JLabel imageicon3 = new JLabel(frame_c);
        imageicon3.setBounds(50, 45, 40, 35);

        // JPanels
        JPanel panel = new JPanel();
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        // JLabels
        JLabel headinglabel = new JLabel("Read ");
        JLabel fileLabel = new JLabel("File Name :");

        // JTextField
        JTextField fileField = new JTextField(20);

        // JTextArea
        JTextArea contentArea = new JTextArea(40, 20);
        JScrollPane scrollPane=new JScrollPane(contentArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // JButton
        JButton openButton = new JButton("Open");

        // Setting positions and sizes of components
        headinglabel.setBounds(110, 35, 180, 50);
        fileLabel.setBounds(40, 115, 150, 50);
        fileLabel.setFont(new Font("Serif", Font.BOLD, 24));
        fileField.setBounds(170, 115, 300, 50);
        scrollPane.setBounds(120, 200, 440, 350);
        openButton.setBounds(480, 115, 80, 50);

        // Setting font and border thickness
        headinglabel.setFont(new Font("Serif", Font.BOLD, 28));
        headinglabel.setForeground(Color.DARK_GRAY);
        int filefieldthickness = 1;
        fileField.setBorder(BorderFactory.createLineBorder(Color.black, filefieldthickness));
        int contentareathickness = 1;
        contentArea.setBorder(BorderFactory.createLineBorder(Color.black, contentareathickness));

        // Adding components to the panel
        panel2.add(fileLabel);
        panel2.add(imageicon3);
        panel2.add(headinglabel);
        panel2.add(fileField);
        panel2.add(scrollPane);
        panel2.add(openButton);

        // First panel
        panel0.add(panel1);
        int borderthickness = 20;
        panel0.setBorder(BorderFactory.createLineBorder(new Color(184, 149, 218), borderthickness));
        panel0.setLayout(null);

        // Second panel
        panel0.add(panel1);
        panel1.setSize(750, 720);
        panel1.setBounds(42, 35, 750, 700);
        panel1.setBackground(new Color(184, 149, 218));
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

        // Action listener for the open button
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileField.getText();

                try {
                    File file = new File(fileName +".txt");
                    if (file.exists()) {
                        StringBuilder content = new StringBuilder();
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        reader.close();
                        contentArea.setText(content.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "File not found.");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred while reading the file.");
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Read();
    }
}
