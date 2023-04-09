/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsemailgui;

import javax.swing.JFrame;

/**
 *
 * @author Greatest
 */
public class StudentsEmailGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StudentEmailGUI app = new StudentEmailGUI();
        app.setVisible(true);
        app.setSize(500, 500);
        app.setLocation(200, 100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
