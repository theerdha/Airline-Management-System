import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Edit {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   
   public Edit(){
      prepareGUI();
   }
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }

   /*public static void main(String[] args){
      Edit edit = new Edit();  
      edit.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Edit");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(7,1));
      
     
      headerLabel = new JLabel("            ",JLabel.CENTER);

     
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


      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      mainFrame.add(controlPanel3);
      mainFrame.add(controlPanel4);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
       headerLabel.setText("Edit your details\n"); 

      JLabel namelabel = new JLabel("Name: ", JLabel.RIGHT);
      JLabel emaillabel = new JLabel("Email id: ", JLabel.RIGHT);
      JLabel passwordlabel = new JLabel("Password: ", JLabel.RIGHT);
      JLabel passportlabel = new JLabel("Passport Number: ", JLabel.RIGHT);

      String s = "theerdha";

      JTextField name = new JTextField(s,20);
      JTextField email = new JTextField(s,20);
      JPasswordField password = new JPasswordField(s,20);
      JTextField passport = new JTextField(s,20);

      JButton saveButton = new JButton("Save");
      JButton backButton = new JButton("Back");

      saveButton.setActionCommand("Saveedit");
      backButton.setActionCommand("Backedit");

      

      saveButton.addActionListener(ButtonHandling.getInstance()); 
      backButton.addActionListener(ButtonHandling.getInstance());  

   

      controlPanel.add(namelabel);
      controlPanel.add(name);
      controlPanel1.add(emaillabel);       
      controlPanel1.add(email);
      controlPanel2.add(passwordlabel);
      controlPanel2.add(password);
      controlPanel3.add(passportlabel);
      controlPanel3.add(passport);

      controlPanel4.add(saveButton);
      controlPanel4.add(backButton);
             

      mainFrame.setVisible(false);  
   }

}
