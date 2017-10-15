import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   private JTextField name;
   private JTextField email;
   private JPasswordField password;
   private JTextField passport;


   
   public Register(){
      prepareGUI();
   }
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }

   public String getName()
   {
      return name.getText();
   }
   public String getEmail()
   {
      return email.getText();
   }
   public String getPassword()
   {
      return password.getText();
   }
   public String getPassport()
   {
      return passport.getText();
   }

  /* public static void main(String[] args){
      Register register= new Register();  
      register.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Register");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(7,1));
     
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

      controlPanel.setBackground(Color.pink);

      controlPanel1 = new JPanel();
      controlPanel1.setLayout(new FlowLayout());

      controlPanel1.setBackground(Color.orange);

      controlPanel2 = new JPanel();
      controlPanel2.setLayout(new FlowLayout());

      controlPanel2.setBackground(Color.pink);

      controlPanel3 = new JPanel();
      controlPanel3.setLayout(new FlowLayout());

      controlPanel3.setBackground(Color.orange);

      controlPanel4 = new JPanel();
      controlPanel4.setLayout(new FlowLayout());

      controlPanel4.setBackground(Color.pink);


      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      mainFrame.add(controlPanel3);
      mainFrame.add(controlPanel4);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
      headerLabel.setText("Please fill in your details\n"); 

      JLabel namelabel = new JLabel("Name: ", JLabel.RIGHT);
      JLabel emaillabel = new JLabel("Email id: ", JLabel.RIGHT);
      JLabel passwordlabel = new JLabel("Password: ", JLabel.RIGHT);
      JLabel passportlabel = new JLabel("Passport Number: ", JLabel.RIGHT);

      name = new JTextField(20);
      email = new JTextField(20);
      password = new JPasswordField(20);
      passport = new JTextField(20);

      JButton registerButton = new JButton("Register");
      JButton backButton = new JButton("Back");

      registerButton.setActionCommand("Register");
      backButton.setActionCommand("BackReg");

      

      registerButton.addActionListener(ButtonHandling.getInstance()); 
      backButton.addActionListener(ButtonHandling.getInstance());  

   

      controlPanel.add(namelabel);
      controlPanel.add(name);
      controlPanel1.add(emaillabel);       
      controlPanel1.add(email);
      controlPanel2.add(passwordlabel);
      controlPanel2.add(password);
      controlPanel3.add(passportlabel);
      controlPanel3.add(passport);

      controlPanel4.add(registerButton);
      controlPanel4.add(backButton);
             

      mainFrame.setVisible(false);  
   }

}
