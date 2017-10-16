

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminPortal {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel1;
   private JPanel controlPanel2;
   private JPanel controlPanel3;
   private JPanel controlPanel4;
   private JPanel controlPanel5;
   private JPanel controlPanel6;
   private JPanel controlPanel7;

	public JFrame getFrame()
   {
   		return mainFrame;
   }

   public AdminPortal(){
      prepareGUI();
   }
  /* public static void main(String[] args){
      Portal portal = new Portal();  
      portal.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Admin Portal");
      mainFrame.setSize(400,300);
      mainFrame.setLayout(new GridLayout(1	,1));
     
      headerLabel = new JLabel("",JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    

      controlPanel1 = new JPanel();
      controlPanel1.setLayout(new GridLayout(6,1));

	  //mainFrame.add(headerLabel);
      mainFrame.add(controlPanel1);
      //mainFrame.add(statusLabel);
      mainFrame.setVisible(false);
      
      JButton editButton = new JButton("Edit Your Details");
      JButton viewAllButton = new JButton("View All Flights");
      JButton manageFlightsButton = new JButton("Manage Flights");
      JButton managePassengerButton = new JButton("Manage Paasenger");
      JButton logoutButton = new JButton("Logout");
      JButton backButton = new JButton("Back");

      editButton.setActionCommand("Editad");
      viewAllButton.setActionCommand("viewad");
      manageFlightsButton.setActionCommand("manageflight");
      managePassengerButton.setActionCommand("managepassenger");
      logoutButton.setActionCommand("Logoutad");
      backButton.setActionCommand("Backportalad");

      editButton.addActionListener(ButtonHandling.getInstance());
      viewAllButton.addActionListener(ButtonHandling.getInstance());
      manageFlightsButton.addActionListener(ButtonHandling.getInstance());
      managePassengerButton.addActionListener(ButtonHandling.getInstance());
      logoutButton.addActionListener(ButtonHandling.getInstance());
      backButton.addActionListener(ButtonHandling.getInstance());


      controlPanel1.add(editButton);
      controlPanel1.add(viewAllButton);
      controlPanel1.add(manageFlightsButton);
      controlPanel1.add(managePassengerButton);
      controlPanel1.add(logoutButton);
      //controlPanel7.add(backButton);

      mainFrame.setVisible(false);    
   }

  
}
