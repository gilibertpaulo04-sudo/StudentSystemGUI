import javax.swing.*;
import java.util.ArrayList;

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class StudentSystemGUI {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setBounds(120, 10, 300, 25);
        frame.add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 25);
        frame.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 90, 100, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 90, 200, 25);
        frame.add(idField);

        // Buttons
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 130, 80, 30);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View");
        viewBtn.setBounds(140, 130, 80, 30);
        frame.add(viewBtn);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(230, 130, 90, 30);
        frame.add(searchBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(330, 130, 90, 30);
        frame.add(deleteBtn);

        // Text Area
        JTextArea area = new JTextArea();
        area.setBounds(50, 180, 370, 150);
        frame.add(area);

        // Footer
        JLabel footer = new JLabel("© 2026 Student System - Java Swing");
        footer.setBounds(140, 360, 300, 25);
        frame.add(footer);

        // ADD
        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());

                students.add(new Student(name, id));
                area.setText("Student Added!");
            } catch(Exception ex) {
                area.setText("Invalid input!");
            }
        });

        // VIEW
        viewBtn.addActionListener(e -> {
            if(students.isEmpty()) {
                area.setText("No students found!");
            } else {
                String data = "";
                for(Student s : students) {
                    data += "Name: " + s.name + " | ID: " + s.id + "\n";
                }
                area.setText(data);
            }
        });

        // SEARCH
        searchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());

                for(Student s : students) {
                    if(s.id == id) {
                        area.setText("Found: " + s.name);
                        return;
                    }
                }
                area.setText("Student not found!");
            } catch(Exception ex) {
                area.setText("Enter valid ID!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());

                for(int i = 0; i < students.size(); i++) {
                    if(students.get(i).id == id) {
                        students.remove(i);
                        area.setText("Student deleted!");
                        return;
                    }
                }
                area.setText("Student not found!");
            } catch(Exception ex) {
                area.setText("Enter valid ID!");
            }
        });

        frame.setVisible(true);
    }
}