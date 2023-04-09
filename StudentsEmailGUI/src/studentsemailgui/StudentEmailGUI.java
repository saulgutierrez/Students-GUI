/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsemailgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Greatest
 */
public class StudentEmailGUI extends JFrame {
    // Constants:
    
    // GUI Component:
    JTextArea studentTextArea = new JTextArea();
    JLabel idLabel = new JLabel("ID: ");
    JTextField idTextField = new JTextField(10);
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameTextField = new JTextField(10);
    
    JButton testDataButton = new JButton("Test Data");
    JButton addButton = new JButton("Add");
    JButton deleteButton = new JButton("Delete");
    JButton editButton = new JButton("Edit");
    JButton editSaveButton = new JButton("Save");
    JButton displayAllButton = new JButton("Display All");
    JButton exitButton = new JButton("Exit");
    
    // Class Instance Data:
    private LinkedList<StudentEmail> studentLinkedList = new LinkedList<StudentEmail>();
    private int editIndex;
    
    public StudentEmailGUI() {
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel flowLayoutPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel gridPanel = new JPanel(new GridLayout(2, 1));
        
        studentTextArea.setEditable(false);
        
        flowLayoutPanel.add(idLabel);
        flowLayoutPanel.add(idTextField);
        flowLayoutPanel.add(nameLabel);
        flowLayoutPanel.add(nameTextField);
        
        flowLayoutPanel2.add(testDataButton);
        flowLayoutPanel2.add(addButton);
        flowLayoutPanel2.add(editButton);
        flowLayoutPanel2.add(editSaveButton);
        flowLayoutPanel2.add(deleteButton);
        flowLayoutPanel2.add(displayAllButton);
        flowLayoutPanel2.add(exitButton);
        
        gridPanel.add(flowLayoutPanel);
        gridPanel.add(flowLayoutPanel2);
        
        editSaveButton.setEnabled(false);
        
        add(studentTextArea, BorderLayout.CENTER);
        add(gridPanel, BorderLayout.SOUTH);
    
        addButton.addActionListener(event -> addStudent());
        displayAllButton.addActionListener(event -> displayAll());
        editButton.addActionListener(event -> editStudent());
        editSaveButton.addActionListener(event -> editSaveStudent());
        exitButton.addActionListener(event -> exitApplication());
        deleteButton.addActionListener(event -> deleteStudent());
        testDataButton.addActionListener(event -> addTestData());
        
        setTitle("Student Linked List - v0.002");
    }
    
    private boolean isStudentIdInLinkedList(String idStr) {
         boolean inList = false;
        
        for(StudentEmail stud : studentLinkedList) {
            if(stud.getId().compareToIgnoreCase(idStr) == 0) {
                inList = true;
            }
        }
        
        return inList;
    }
    
    private void addStudent() {
        if(isStudentIdInLinkedList(idTextField.getText()) == true) {
            JOptionPane.showMessageDialog(StudentEmailGUI.this, "Error: student ID is already in the database");
        } else {
            studentLinkedList.add(new StudentEmail(nameTextField.getText(), idTextField.getText()));
            displayAll();
            
            nameTextField.setText("");
            idTextField.setText("");
        }
    }
    
    private void deleteStudent() {
        if(studentLinkedList.size() == 0) {
            JOptionPane.showMessageDialog(StudentEmailGUI.this, "Error: Database is empty");
        } else if(isStudentIdInLinkedList(idTextField.getText()) == false) {
            JOptionPane.showMessageDialog(StudentEmailGUI.this, "Error: Student ID is not in the database");
        } else {
            for (int i = 0; i < studentLinkedList.size(); i++) {
                
                String currId = studentLinkedList.get(i).getId();
                if(currId.compareToIgnoreCase(idTextField.getText()) == 0) {
                    studentLinkedList.remove(i);
                }
            }
        displayAll();
        
        nameTextField.setText("");
        idTextField.setText("");
        }
    }
    
    private void editStudent() {
        if(studentLinkedList.size() == 0) {
            JOptionPane.showMessageDialog(StudentEmailGUI.this, "Error: Database is empty");
        } else if(isStudentIdInLinkedList(idTextField.getText()) == false) {
            JOptionPane.showMessageDialog(StudentEmailGUI.this, "Error: Student ID is not in the database");
        } else {
            editIndex = -1;
            for (int i = 0; i < studentLinkedList.size(); i++) {
                
                String currId = studentLinkedList.get(i).getId();
                if(currId.compareToIgnoreCase(idTextField.getText()) == 0) {
                    editIndex = i;
                    i = studentLinkedList.size(); // Exit Loop
                }
            }
            
            // Index cannot be lees than 0, because we checked if the Stud Id was in
            // the linked list before we looped above.
            if (editIndex >= 0) {
                editSaveButton.setEnabled(true);
                editButton.setEnabled(false);
                testDataButton.setEnabled(false);
                addButton.setEnabled(false);
                deleteButton.setEnabled(false);
                displayAllButton.setEnabled(false);
                exitButton.setEnabled(false);
                
                nameTextField.setText(studentLinkedList.get(editIndex).getName());
                //idTextField.setText(studentLinkedList.get(editIndex).getId());
            }
        }
    }
    
    private void editSaveStudent() {
        // This code will preserve the changes the user made to the student
        // they were editing - and save them back into the Linked List
        studentLinkedList.get(editIndex).setName(nameTextField.getText());
        studentLinkedList.get(editIndex).setID(idTextField.getText());
        
        displayAll();
        
        nameTextField.setText("");
        idTextField.setText("");
        
        editSaveButton.setEnabled(false);
        
        editButton.setEnabled(true);
        testDataButton.setEnabled(true);
        addButton.setEnabled(true);
        deleteButton.setEnabled(true);
        displayAllButton.setEnabled(true);
        exitButton.setEnabled(true);
    }
    
    private void addTestData() {
        nameTextField.setText("Moose");
        idTextField.setText("s123");
        addStudent();
        
        nameTextField.setText("Frankie");
        idTextField.setText("s111");
        addStudent();
        
        nameTextField.setText("Bella");
        idTextField.setText("s789");
        addStudent();
    }
    
    private void displayAll() {
        studentTextArea.setText("");
        for(StudentEmail stud : studentLinkedList) {
            studentTextArea.append(stud +  "\n");
        }
    }
    
    private void exitApplication() {
        System.exit(0);
    }
}