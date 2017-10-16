import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminManagePassenger {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JPanel controlPanel1;

	public JFrame getFrame()
   {
   		return mainFrame;
   }

   public AdminManagePassenger(){
      prepareGUI();
   }
  /* public static void main(String[] args){
      Viewall viewall = new Viewall();  
      viewall.showEventDemo();       
   }*/
   private void prepareGUI(){
      mainFrame = new JFrame("Flights portal");
      mainFrame.setSize(500,400);
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

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel1);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(false); 
      
      headerLabel.setText("All Passengers\n"); 

      JButton submitButton = new JButton("Back");
      
      

      final DefaultListModel flights = new DefaultListModel();
      flights.addElement("sree");
      flights.addElement("theerdha");
      flights.addElement("sree1234");
      flights.addElement("theerdha2345");


      final JList flightList = new JList(flights);
      flightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      flightList.setSelectedIndex(0);
      flightList.setVisibleRowCount(4);        

      JScrollPane flightListScrollPane = new JScrollPane(flightList);  



      submitButton.setActionCommand("Backpassengeradmin");

      submitButton.addActionListener(ButtonHandling.getInstance());

      controlPanel.add(flightListScrollPane); 
      controlPanel1.add(submitButton);
             

      mainFrame.setVisible(false);   
   }
}
