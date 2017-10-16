import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddFlight {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   private JPanel controlPanel5;
   private JPanel controlPanel6;
   private JPanel controlPanel7;
   private JPanel controlPanel8;
   private JPanel controlPanel9;
   private JTextField type ;
   private JTextField number ;
   private JTextField source;
   private JTextField destination ;
   private JTextField date;
   private JTextField time;
   private JTextField classtype;
   private JTextField meal;
   private JTextField amount;
   
   public AddFlight(){
      prepareGUI();
   }
   
   public JFrame getFrame()
   {
   		return mainFrame;
   }
   
   public String getType()
   {
      return type.getText();
   }

    public String getNumber()
   {
      return number.getText();
   }
   public String getSource()
   {
      return source.getText();
   }
   public String getDestination()
   {
      return destination.getText();
   }
   public String getDate()
   {
      return date.getText();
   }
   public String getTime()
   {
      return time.getText();
   }
   public String getClassType()
   {
      return classtype.getText();
   }
   public String getMeal()
   {
      return meal.getText();
   }
   public String getAmount()
   {
      return amount.getText();
   }

  /* public static void main(String[] args){
      Register register= new Register();  
      register.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Admin Register");
      mainFrame.setSize(500,400);
      mainFrame.setLayout(new GridLayout(12,1));
     
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

       controlPanel6 = new JPanel();
      controlPanel6.setLayout(new FlowLayout());

       controlPanel7 = new JPanel();
      controlPanel7.setLayout(new FlowLayout());

       controlPanel8 = new JPanel();
      controlPanel8.setLayout(new FlowLayout());

       controlPanel9= new JPanel();
      controlPanel9.setLayout(new FlowLayout());


      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(controlPanel2);
      mainFrame.add(controlPanel3);
      mainFrame.add(controlPanel4);
      mainFrame.add(controlPanel5);
      mainFrame.add(controlPanel6);
      mainFrame.add(controlPanel7);
      mainFrame.add(controlPanel8);
      mainFrame.add(controlPanel9);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false);  
      
      headerLabel.setText("Please fill in flight details\n");

     
      JLabel typelabel = new JLabel("Type: ", JLabel.RIGHT);
      JLabel numberlabel = new JLabel("Number: ", JLabel.RIGHT);
      JLabel sourcelabel = new JLabel("Source: ", JLabel.RIGHT);
      JLabel destinationlabel = new JLabel("Destination: ", JLabel.RIGHT);
      JLabel datelabel = new JLabel("Date: ", JLabel.RIGHT);
      JLabel timelabel = new JLabel("Time: ", JLabel.RIGHT);
      JLabel classlabel = new JLabel("Class: ", JLabel.RIGHT);
      JLabel meallabel = new JLabel("Meal: ", JLabel.RIGHT);
      JLabel amountlabel = new JLabel("Amount: ", JLabel.RIGHT);

      
    type = new JTextField(20)  ;
    number = new JTextField(20);
    source = new JTextField(20);
    destination = new JTextField(20);
    date = new JTextField(20);
    time = new JTextField(20);
    classtype = new JTextField(20);
    meal = new JTextField(20);
    amount = new JTextField(20);

      JButton registerButton = new JButton("Add");
      JButton backButton = new JButton("Back");

      registerButton.setActionCommand("Add");
      backButton.setActionCommand("Backaddad");

      

      registerButton.addActionListener(ButtonHandling.getInstance()); 
      backButton.addActionListener(ButtonHandling.getInstance());  

      controlPanel.add(typelabel);
      controlPanel.add(type);
      controlPanel1.add(numberlabel);
      controlPanel1.add(number);
      controlPanel2.add(sourcelabel);       
      controlPanel2.add(source);
      controlPanel3.add(destinationlabel);
      controlPanel3.add(destination);
      controlPanel4.add(datelabel);
      controlPanel4.add(date);
      controlPanel5.add(timelabel);
      controlPanel5.add(time);
      controlPanel6.add(classlabel);
      controlPanel6.add(classtype);
      controlPanel7.add(meallabel);
      controlPanel7.add(meal);
      controlPanel8.add(amountlabel);
      controlPanel8.add(amount);


      controlPanel9.add(registerButton);
      controlPanel9.add(backButton);
             

      mainFrame.setVisible(false);  
   }

}
