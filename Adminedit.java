import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Adminedit {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   private JPanel controlPanel5;
   
   public Adminedit(){
      prepareGUI();
   }
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }

  /* public static void main(String[] args){
      Register register= new Register();  
      register.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Admin Register");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(8,1));
     
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

      controlPanel2 = new JPanel();
      controlPanel2.setLayout(new FlowLayout());

      controlPanel3 = new JPanel();
      controlPanel3.setLayout(new FlowLayout());

      controlPanel4 = new JPanel();
      controlPanel4.setLayout(new FlowLayout());

      controlPanel5 = new JPanel();
      controlPanel5.setLayout(new FlowLayout());


      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      mainFrame.add(controlPanel3);
      mainFrame.add(controlPanel4);
      mainFrame.add(controlPanel5);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
      headerLabel.setText("Please fill in your details\n"); 

      JLabel idlabel = new JLabel("Admin_ID: ", JLabel.RIGHT);
      JLabel namelabel = new JLabel("Name: ", JLabel.RIGHT);
      JLabel emaillabel = new JLabel("Email id: ", JLabel.RIGHT);
      JLabel passwordlabel = new JLabel("Password: ", JLabel.RIGHT);
      JLabel contactlabel = new JLabel("Contact Number: ", JLabel.RIGHT);

      JTextField id = new JTextField(20);
      JTextField name = new JTextField(20);
      JTextField email = new JTextField(20);
      JPasswordField password = new JPasswordField(20);
      JTextField contact = new JTextField(20);

      JButton registerButton = new JButton("Save");
      JButton backButton = new JButton("Back");

      registerButton.setActionCommand("Saveeditad");
      backButton.setActionCommand("Backeditad");

      

      registerButton.addActionListener(ButtonHandling.getInstance()); 
      backButton.addActionListener(ButtonHandling.getInstance());  

      controlPanel.add(idlabel);
      controlPanel.add(id);
      controlPanel1.add(namelabel);
      controlPanel1.add(name);
      controlPanel2.add(emaillabel);       
      controlPanel2.add(email);
      controlPanel3.add(passwordlabel);
      controlPanel3.add(password);
      controlPanel4.add(contactlabel);
      controlPanel4.add(contact);

      controlPanel5.add(registerButton);
      controlPanel5.add(backButton);
             

      mainFrame.setVisible(false);  
   }

}
