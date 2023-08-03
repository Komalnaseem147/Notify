import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddList {

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);

        JTextField textField=new JTextField();
        textField.setLayout(new BorderLayout());


        JButton save_Button=new JButton("Save");

        //File Handling


        File note=new File("ali.txt");

        note.createNewFile();
        System.out.println("FFilee");


        FileWriter fileWriter=new FileWriter("ali.txt");
        String add= sc.nextLine();
        fileWriter.write(add);
        fileWriter.close();

        System.out.println("my name is komal");





}

}