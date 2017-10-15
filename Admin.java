

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;


   public Admin(){
      prepareGUI();
   }
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }
   /*public static void main(String[] args){
     Passenger passenger = new Passenger();  
      passenger.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Admin Portal");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(4,1));
     
      headerLabel = new JLabel("",JLabel.CENTER);

     
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      controlPanel1 = new JPanel();
      controlPanel1.setLayout(new FlowLayout());

      controlPanel1.add(Box.createHorizontalGlue());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
      headerLabel.setText("What do you want to do\n"); 

      JButton loginButton = new JButton("Login");
      JButton registerButton = new JButton("Register");
      JButton backButton = new JButton("Back");

      loginButton.setActionCommand("loginad");
      registerButton.setActionCommand("adminregister");
      backButton.setActionCommand("backad");
      

      loginButton.addActionListener(ButtonHandling.getInstance()); 
      registerButton.addActionListener(ButtonHandling.getInstance());
      backButton.addActionListener(ButtonHandling.getInstance());  

      controlPanel.add(loginButton);
      controlPanel.add(registerButton);
      controlPanel1.add(backButton);
             

      mainFrame.setVisible(false);  
   }

   
   
}
