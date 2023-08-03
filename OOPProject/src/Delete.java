import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Delete  {
    Delete(){
        JFrame frame = new JFrame("Delete");

        //Image icon
        ImageIcon icon=new ImageIcon(Main.class.getResource("notebook.png"));
        frame.setIconImage(icon.getImage());
        ImageIcon frame_c= new ImageIcon(Main.class.getResource("delete.png"));
        JLabel imageicon3= new JLabel(frame_c);
        imageicon3.setBounds(50,45,40,35);

        JPanel panel = new JPanel();
        JPanel panel0 = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();


        JLabel headinglabel=new JLabel("Delete :");
        JLabel inst=new JLabel("Add name of the file you want to delete");
        JLabel name = new JLabel("File Name :");

        //creating text area for our content
        JTextField file_name = new JTextField();

        // Setting border thickness
        int file_namethickness=1;
        file_name.setBorder(BorderFactory.createLineBorder(Color.black, file_namethickness));

        // Setting font and color
        headinglabel.setFont(new Font("Serif",Font.BOLD,28));
        headinglabel.setForeground(Color.DARK_GRAY);

        // Creating button
        JButton delete= new JButton("Del");

        // Setting positions and sizes of components
        imageicon3.setBounds(50,45,40,35);
        headinglabel.setBounds(110, 35, 380, 50);
        name.setBounds(50, 100, 280, 50);
        name.setFont(new Font("Serif", Font.BOLD, 24));
        file_name.setBounds(170, 100, 300, 50);
        delete.setBounds(230, 170, 100, 50);


        // Setting font and color
        name.setFont(new Font("Serif",Font.BOLD,18));
        name.setForeground(Color.DARK_GRAY);

        // Adding components to the panel
        panel2.add(headinglabel);
        panel2.add(imageicon3);
        panel2.add(name);
        panel2.add(file_name);
        panel2.add(delete);

        // First panel
        panel0.add(panel1);
        int borderthickness=20;
        panel0.setBorder(BorderFactory.createLineBorder(new Color(118, 184,249), borderthickness));
        panel0.setLayout(null);

        // Second panel
        panel0.add(panel1);
        panel1.setSize(750,720);
        panel1.setBounds(42,35,750,700);
        panel1.setBackground(new Color(118, 184,249));
        panel1.setLayout(null);

        // Third panel
        panel1.add(panel2);
        panel2.setSize(670,620);
        panel2.setBounds(40,38,670,620);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(null);

        panel.setLayout(null);
        frame.add(panel0);
        frame.setSize(850, 820);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Action listener for the delete button
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = file_name.getText();
                if (!fileName.isEmpty()) {
                    File file = new File(fileName +".txt");
                    if (file.exists()) {
                        if (file.delete()) {
                            JOptionPane.showMessageDialog(frame, "Deleted");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Failed to delete the file.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "File does not exist.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a file name.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Delete();
    }
}
