package com.quickfixfitters.garits.GUI;

import com.quickfixfitters.garits.database.DBConnectivity;
import com.quickfixfitters.garits.entities.Employee;
import java.util.Stack;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Garits {
    
    private Stack<JFrame> openScreens;

    public Garits() {
        
        //Starting connection with Database
        SessionFactory sessionFactory = DBConnectivity.getSessionFactory();
        
        openScreens = new Stack<>();
        JFrame home = new Home(this);
        this.putOnScreen(home);
    }
    
    // Puts the parameter 'frame' on the screen maximised.
    public void putOnScreen(JFrame frame){
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    
    // Opens the help file. Method is activated by clicking
    // on the help button at the top of the screen.
    // If the help file is unavailable, a message box opens.
    public void openHelp(JFrame frame) throws IOException{
        File file = new File("C:/Users/ccram/Desktop/UniWork/Year2/TeamProject"
                + "/Team-Project---GARITS-master/Team-Project---GARITS/src/GUI/"
                + "help.txt");
        Desktop desktop = Desktop.getDesktop();
        
        if (file.exists()){
            desktop.open(file);
        } else{
            JOptionPane.showMessageDialog(frame, "Help file not available");
        }
    }
    
    // Opens a new screen and closes the old one.
    public void openNewScreen(JFrame frame, JFrame newFrame){
        this.getOpenScreens().push(frame);
        this.putOnScreen(newFrame);
        frame.dispose();
    }
    
    // Pops the most last screen from the stack, puts it on
    // screen then closes the current one.
    public void backButton(JFrame frame){
        this.putOnScreen(this.getOpenScreens().pop());
        frame.dispose();
    }
    
    // Logs the user out of the system.
    // It does this by clearing the stack of screens,
    // then creating a new Home page.
    public void logout(JFrame frame){
        frame.dispose();
        this.getOpenScreens().clear();
        JFrame home = new Home(this);
        this.putOnScreen(home);
    }
    
    // Getter for the stack of sceens that the user could go back to.
    public Stack<JFrame> getOpenScreens(){
        return openScreens;
    }
    
    public static void main(String[] args){
        new Garits();
    }
    
}
