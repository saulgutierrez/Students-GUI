/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsemailgui;

/**
 *
 * @author Greatest
 */
public class StudentEmail {
    public static final String EMAIL_STUB = "@my.email";
    private String name;
    private String id;
    
    public StudentEmail() {
        name = "";
        id = "";
    }
    
    public StudentEmail(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return id + "\t" + name + "\t" + id + EMAIL_STUB;
    }
}
