import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JTextField name;
   private JPasswordField password ;

   public String getName()
   {
      return name.getText();
   }

   public String getPassword()
   {
      return password.getText();
   }

   public Login(){
      prepareGUI();
   }

   public void set(String str)
   {
      statusLabel.setText(str);
   }
   
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }
  /* public static void main(String[] args){
      Login login = new Login();  
      login.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Login");
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


      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
      headerLabel.setText("Please fill in your details\n"); 

      JLabel namelabel = new JLabel("Name: ", JLabel.RIGHT);
      JLabel passwordlabel = new JLabel("Password: ", JLabel.RIGHT);

      name = new JTextField(20);
      password = new JPasswordField(20);

      JButton loginButton = new JButton("Login");
      JButton backButton = new JButton("Back");
      
      loginButton.setActionCommand("portal");
      backButton.setActionCommand("Backlog");
 
      loginButton.addActionListener(ButtonHandling.getInstance()); 
      backButton.addActionListener(ButtonHandling.getInstance());  

   

      controlPanel.add(namelabel);
      controlPanel.add(name);
      controlPanel1.add(passwordlabel);
      controlPanel1.add(password);
      controlPanel2.add(loginButton);
      controlPanel2.add(backButton);
             

      mainFrame.setVisible(false); 
   }

  
}
