import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Schedule {

    Schedule(){

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
        JLabel headinglabel = new JLabel("Schedule files :");
        JLabel create = new JLabel("Create file");
        JLabel save = new JLabel("Save");

        // JTextFields
        JTextField create_field = new JTextField(20);

        // JTextArea
        JTextArea save_area = new JTextArea(40, 20);

        // JButtons
        JButton create_button = new JButton("Create");
        JButton save_button = new JButton("Save");
        JButton schedule = new JButton("Schedule");

        // ImageIcon
        ImageIcon frame_d = new ImageIcon(Main.class.getResource("calendar.png"));
        JLabel imageicon4 = new JLabel(frame_d);
        imageicon4.setBounds(50,40,40,35);

        // Setting positions and sizes of components
        create_field.setBounds(80, 110, 400, 50);
        create_button.setBounds(80, 170, 80, 50);
        headinglabel.setBounds(95,30,350,50);
        save_area.setBounds(80, 250, 400, 250);
        save_button.setBounds(80, 510, 80, 50);
        schedule.setBounds(180,510,100,50);



        // Setting border thickness
        int createfieldthickness=1;
        create_field.setBorder(BorderFactory.createLineBorder(Color.black, createfieldthickness));
        int saveareathickness=1;
        save_area.setBorder(BorderFactory.createLineBorder(Color.black, saveareathickness));
        headinglabel.setFont(new Font("Serif",Font.BOLD,28));
        headinglabel.setForeground(Color.DARK_GRAY);

        // Adding components to the panel
        panel2.add(headinglabel);
        panel2.add(imageicon4);
        panel2.add(create_field);
        panel2.add(create_button);
        panel2.add(save_area);
        panel2.add(save_button);
        panel2.add(schedule);

        // First panel
        panel0.add(panel1);
        int borderthickness=20;
        panel0.setBorder(BorderFactory.createLineBorder(new Color(235, 186, 185), borderthickness));
        panel0.setLayout(null);

        // Second panel
        panel0.add(panel1);
        panel1.setSize(750, 720);
        panel1.setBounds(42, 35, 750, 700);
        panel1.setBackground(new Color(235, 186, 185));
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

                if (!save_area.getText().isEmpty()) {
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
                    JOptionPane.showMessageDialog(frame, "Please fill the note before saving the file.");
                }
            }
        });

        // Action listener for the schedule button
        schedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = create_field.getText();
                File file = new File(fileName + ".txt");
                if (file.exists()) {
                    String scheduleTime = JOptionPane.showInputDialog(frame, "Enter the desired time (format: HH:mm:ss)");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    try {
                        Date scheduleDate = sdf.parse(scheduleTime);

                        // Get the current date and time
                        Date currentDate = new Date();

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(scheduleDate);
                        int scheduleHour = calendar.get(Calendar.HOUR_OF_DAY);
                        int scheduleMinute = calendar.get(Calendar.MINUTE);
                        int scheduleSecond = calendar.get(Calendar.SECOND);

                        calendar.setTime(currentDate);
                        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                        int currentMinute = calendar.get(Calendar.MINUTE);
                        int currentSecond = calendar.get(Calendar.SECOND);

                        calendar.set(Calendar.HOUR_OF_DAY, scheduleHour);
                        calendar.set(Calendar.MINUTE, scheduleMinute);
                        calendar.set(Calendar.SECOND, scheduleSecond);
                        scheduleDate = calendar.getTime();

                        long delay = scheduleDate.getTime() - currentDate.getTime();
                        if (delay > 0) {
                            TimerTask openFileTask = new TimerTask() {
                                @Override
                                public void run() {
                                    try {
                                        Desktop.getDesktop().open(file);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            };

                            Timer timer = new Timer();
                            timer.schedule(openFileTask, delay);
                            JOptionPane.showMessageDialog(frame, "File will open at the scheduled time.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid schedule time. Please enter a future time.");
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid time format. Please use HH:mm:ss");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "File does not exist. Create and save the file first.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Schedule();
    }
}
