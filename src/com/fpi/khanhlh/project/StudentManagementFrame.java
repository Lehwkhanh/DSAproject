package com.fpi.khanhlh.project;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentManagementFrame extends JFrame {
    private StudentManager studentManager;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    public StudentManagementFrame() {
        this.studentManager = new StudentManager("students.dat"); // Gán đúng vào biến instance
        initComponents();
        setupUI();
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
     private void setupUI() {
        setTitle("Student Score Management");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Student Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0xFF6A00)); // FPT Orange color
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(titleLabel, gbc);

        // Student ID
        gbc.gridwidth = 1;
        JLabel idLabel = new JLabel("Student ID");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        idLabel.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(idLabel, gbc);

        JTextField idField = new JTextField(20);
        gbc.gridx = 1;
        add(idField, gbc);

        // Student Name
        JLabel nameLabel = new JLabel("Full name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameLabel.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Major
        JLabel majorLabel = new JLabel("Major");
        majorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        majorLabel.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(majorLabel, gbc);

        String[] majors = {"Information Technology", "Graphic Design", "Business"};
        JComboBox<String> majorComboBox = new JComboBox<>(majors);
        gbc.gridx = 1;
        add(majorComboBox, gbc);

        // Score 1
        JLabel score1Label = new JLabel("score 1");
        score1Label.setFont(new Font("Arial", Font.PLAIN, 14));
        score1Label.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(score1Label, gbc);

        JTextField score1Field = new JTextField(20);
        gbc.gridx = 1;
        add(score1Field, gbc);

        // Score 2
        JLabel score2Label = new JLabel("score 2");
        score2Label.setFont(new Font("Arial", Font.PLAIN, 14));
        score2Label.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(score2Label, gbc);

        JTextField score2Field = new JTextField(20);
        gbc.gridx = 1;
        add(score2Field, gbc);

        // Score 3
        JLabel score3Label = new JLabel("score 3");
        score3Label.setFont(new Font("Arial", Font.PLAIN, 14));
        score3Label.setForeground(new Color(0x0066B3)); // FPT Blue color
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(score3Label, gbc);

        JTextField score3Field = new JTextField(20);
        gbc.gridx = 1;
        add(score3Field, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("ADD");
        JButton editButton = new JButton("UPDATE");
        JButton deleteButton = new JButton("DELETE");
        JButton sortButton = new JButton("SORT");
        
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("SEARCH");
        
        // Add JComboBox for search criteria (Name or ID)
        String[] searchOptions = {"Search by name", "Search by ID"};
        JComboBox<String> searchCriteriaComboBox = new JComboBox<>(searchOptions);
        
        // Style buttons with FPT colors
        addButton.setBackground(new Color(0xFF6A00)); // FPT Orange color
        addButton.setForeground(Color.WHITE);
        editButton.setBackground(new Color(0x34B233)); // FPT Green color
        editButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(0xFF6A00)); // FPT Orange color
        deleteButton.setForeground(Color.WHITE);
        sortButton.setBackground(new Color(0x34B233)); // FPT Green color
        sortButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(0x0066B3)); // FPT Blue color
        searchButton.setForeground(Color.WHITE);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(new JLabel("Search:"));
        buttonPanel.add(searchField);
        buttonPanel.add(searchCriteriaComboBox);
        buttonPanel.add(searchButton);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);

        // Table Model
        String[] columnNames = {"ID", "Full name", "Major", "score 1", "score 2", "score 3", "Average score", "Ranking"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        // Add Student
        addButton.addActionListener(e -> {
            try {
                String id = idField.getText().trim();
                // Check if ID already exists
                if (studentManager.searchStudentById(id) != null) {
                    JOptionPane.showMessageDialog(this, "This student ID already exists!", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText().trim();
                String major = (String) majorComboBox.getSelectedItem();
                double score1 = parseScore(score1Field.getText());
                double score2 = parseScore(score2Field.getText());
                double score3 = parseScore(score3Field.getText());

                Student student;
                switch (major) {
                    case "Information Technology" -> student = new ITStudent(id, name, score1, score2, score3);
                    case "Graphic Design" -> student = new GDStudent(id, name, score1, score2, score3);
                    case "Business" -> student = new BusStudent(id, name, score1, score2, score3);
                    default -> student = new Student(id, name, major, score1, score2, score3);
                }

                studentManager.addStudent(student);
                updateTable();
                JOptionPane.showMessageDialog(this, "Student has been added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter correct score format (0–10)!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Edit Student
        editButton.addActionListener(e -> {
            int row = studentTable.getSelectedRow();
            if (row != -1) {
                String id = (String) studentTable.getValueAt(row, 0);
                Student student = studentManager.searchStudentById(id);
                if (student != null) {
                    studentManager.removeStudent(id);
                    idField.setText(student.getId());
                    nameField.setText(student.getName());
                    majorComboBox.setSelectedItem(student.getMajor());
                    score1Field.setText(String.valueOf(student.getScore1()));
                    score2Field.setText(String.valueOf(student.getScore2()));
                    score3Field.setText(String.valueOf(student.getScore3()));
                    updateTable();
                }
            }
        });

        // Delete Student
        deleteButton.addActionListener(e -> {
            int row = studentTable.getSelectedRow();
            if (row != -1) {
                String id = (String) studentTable.getValueAt(row, 0);
                studentManager.removeStudent(id);
                updateTable();
                JOptionPane.showMessageDialog(this, "Student has been deleted!");
            }
        });

        // Sort
        sortButton.addActionListener(e -> {
            String[] options = {"Sort by name", "Sort by score", "Sort by ID"};
            String choice = (String) JOptionPane.showInputDialog(this, "Select sort method", "Sort",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice.equals("Sort by name")) {
                studentManager.sortStudentsByName();
            } else if (choice.equals("Sort by score")) {
                studentManager.sortStudentsByScore();
            } else if (choice.equals("Sort by ID")) {
                studentManager.sortStudentsById();
            }
            updateTable();
        });

        // Search by name or ID based on selection and input change
        searchCriteriaComboBox.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            String selectedSearchOption = (String) searchCriteriaComboBox.getSelectedItem();

            if (selectedSearchOption != null && !keyword.isEmpty()) {
                List<Student> results;
                if (selectedSearchOption.equals("Search by name")) {
                    results = studentManager.searchStudentsByName(keyword);
                } else if (selectedSearchOption.equals("Search by ID")) {
                    results = studentManager.searchStudentsById(keyword);
                } else {
                    results = studentManager.getStudents(); // Default, in case something goes wrong
                }

                tableModel.setRowCount(0); // Clear the table
                for (Student student : results) {
                    tableModel.addRow(new Object[] {
                        student.getId(),
                        student.getName(),
                        student.getMajor(),
                        student.getScore1(),
                        student.getScore2(),
                        student.getScore3(),
                        student.getAverageScore(),
                        student.getRank()  // Add ranking to the table
                    });
                }
            } else {
                updateTable(); // If no keyword, show all students
            }
        });

        // Search Button - Can be used for instant search, depending on needs
        searchButton.addActionListener(e -> {
            searchCriteriaComboBox.getActionListeners()[0].actionPerformed(null);
        });
    }

    private double parseScore(String input) throws NumberFormatException {
        input = input.trim().replace(",", ".");
        double score = Double.parseDouble(input);
        if (score < 0 || score > 10) {
            throw new NumberFormatException();
        }
        return score;
    }

    private void updateTable() {
        tableModel.setRowCount(0); // Clear the table

        for (Student student : studentManager.getStudents()) {
            tableModel.addRow(new Object[] {
                student.getId(),
                student.getName(),
                student.getMajor(),
                student.getScore1(),
                student.getScore2(),
                student.getScore3(),
                student.getAverageScore(),
                student.getRank()  // Add ranking to the table
            });
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementFrame().setVisible(true));
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

