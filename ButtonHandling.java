import java.awt.*;
import java.util.*;	
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class ButtonHandling implements ActionListener{
		private static HashMap hash;
		private static DataBase db = DataBase.getInstance();
		private static ButtonHandling instance = new ButtonHandling();
		private String currentFrame = "swingmain";
		private ButtonHandling(){
			
		}
		public static void updateHash(HashMap ha){
			hash = ha;
		}
		public static ButtonHandling getInstance(){
			return instance;
		}
		public static void updateDataBase(DataBase db){
			ButtonHandling.db = db;
		}
		public static ButtonHandling getInstance(HashMap hs){
			hash = hs;
			return instance;
		}

		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("Passenger")){
				
				JFrame temp1 = ((Passenger)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((swing) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			if(command.equals("Backexit"))
			{
				db.updateFile("Passenger.txt");
				System.exit(0);
			}
			if(command.equals("click")){
				
				JFrame temp1 = ((swing)hash.get("swing")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((swingmain) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "swing";
			}
			if(command.equals("Admin")){
				
				JFrame temp1 = ((Admin)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((swing) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			if(command.equals("addflight")){
				
				JFrame temp1 = ((AddFlight)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminManageFlight) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}

			if(command.equals("Add")){
		        AddFlight r1 = ((AddFlight) hash.get(currentFrame));
		
				Flight f = new Flight(r1.getType(),r1.getNumber(),r1.getSource(),r1.getDestination(),r1.getDate(),r1.getTime(),r1.getClassType(),r1.getMeal(),r1.getAmount());

				 db.addflight(f,"Flight.txt");

				JFrame temp1 = ((AdminManageFlight)hash.get("manageflight")).getFrame();
				temp1.setVisible(true);

				r1.getFrame().setVisible(false);

				currentFrame = "manageflight";
			}

			if(command.equals("Backaddad")){
				
				JFrame temp1 = ((AdminManageFlight)hash.get("manageflight")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AddFlight) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "manageflight";
			}
			else if(command.equals("register")){

				JFrame temp1 = ((Register)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Passenger) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("Register")){

				Register r = (Register) hash.get(currentFrame);
				Pass p = new Pass(r.getName(),r.getEmail(),r.getPassword(),r.getPassport());
				    db.addpassenger(p,"Passenger.txt");
				//System.out.println(r.getPassword());

				JFrame temp1 = ((Passenger)hash.get("Passenger")).getFrame();
				temp1.setVisible(true);

				//JFrame temp = ((Register) hash.get(currentFrame)).getFrame();
				r.getFrame().setVisible(false);

				currentFrame = "Passenger";
			}
			else if(command.equals("Registerad")){

				AdminRegister r2 = (AdminRegister) hash.get(currentFrame);
				Ad p2 = new Ad(r2.getId(),r2.getName(),r2.getEmail(),r2.getPassword(),r2.getContact());
				   db.addadmin(p2,"Admin.bin");
				//System.out.println(r.getPassword());

				JFrame temp1 = ((Admin)hash.get("Admin")).getFrame();
				temp1.setVisible(true);

				//JFrame temp = ((Register) hash.get(currentFrame)).getFrame();
				r2.getFrame().setVisible(false);

				currentFrame = "Admin";
			}
			else if(command.equals("adminregister")){
				JFrame temp1 = ((AdminRegister)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Admin) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("login")){
				JFrame temp1 = ((Login)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Passenger) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("loginad")){
				JFrame temp1 = ((AdminLogin)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Admin) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("portal")){
				Login ob = (Login)hash.get("login");

				String username = ob.getName();
				String password = ob.getPassword();
				Portal pl =	(Portal)hash.get(command);

				if(db.searchpassenger(username,password) != null){
					JFrame temp = ob.getFrame();

					JFrame temp1 = (pl).getFrame();
					temp1.setVisible(true);
					temp.setVisible(false);

					currentFrame = command;
				}	
				else ob.set("Invalid Username/Password");
			}
			else if(command.equals("adminportal")){
				
				AdminLogin ap = (AdminLogin) hash.get(currentFrame);

				String username = ap.getName();
				String password = ap.getPassword();

				if(db.searchadmin(username,password) != null){
					JFrame temp = (ap).getFrame();
					

					JFrame temp1 = ((AdminPortal)hash.get(command)).getFrame();
					temp1.setVisible(true);
					temp.setVisible(false);

					currentFrame = command;
				}
				else ap.set("Invalid Username/password");
			}
			else if(command.equals("view")){
				JFrame temp1 = ((View)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Portal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("viewall")){
				
				View v = (View) hash.get(currentFrame);
				JFrame temp = (v).getFrame();

				String source = v.getSource();
				String destination = v.getDestination();
				String date = v.getDate();
				String time = v.getTime();

				ArrayList<Flight> f = db.searchflight(source,destination,date,time);
				//String[] l1 = f.get(0).getlist();

				if(f.size() == 0)
				{
					v.set("No Flights matching with your Journey plan");
				}
				


     			// String data[][]={ {l1[0],l1[1],l1[2],l1[3],l1[4],l1[5],l1[6],l1[7],l1[8]},    
        //                       {"102","Jai","780000","a","a","a","a","a","a"},    
        //                       {"101","Sachin","700000","a","a","a","a","a","a"}};
				// String data[][]={ l1,    
    //                           {"102","Jai","780000","a","a","a","a","a","a"},    
    //                           {"101","Sachin","700000","a","a","a","a","a","a"}};
				else{
					String[][] data = new String[f.size()][9];
					int i;
					for(i = 0; i < f.size(); i++)
					{
						data[i] = f.get(i).getlist();
					}

					Viewall va = (Viewall)hash.get(command);
					va.setArray(data);
					//va.setArray(l1[0]);

					JFrame temp1 = (va).getFrame();
					temp1.setVisible(true);
					temp.setVisible(false);

					currentFrame = command;
				}
			}

			else if(command.equals("viewad")){
				JFrame temp1 = ((ViewallAdmin)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminPortal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}

			else if(command.equals("manageflight")){
				JFrame temp1 = ((AdminManageFlight)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminPortal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}

			else if(command.equals("managepassenger")){
				JFrame temp1 = ((AdminManagePassenger)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminPortal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			
			else if(command.equals("ViewBooked")){
				JFrame temp1 = ((ViewBooked)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Portal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("Edit")){
				JFrame temp1 = ((Edit)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Portal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}

			else if(command.equals("Editad")){
				JFrame temp1 = ((Adminedit)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminPortal) hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			
			else if(command.equals("Backall")){
				JFrame temp1 = ((Portal)hash.get("portal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Viewall)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "portal";
			}

			else if(command.equals("Backview")){
				JFrame temp1 = ((Portal)hash.get("portal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((View)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "portal";
			}

			else if(command.equals("Backalladmin")){
				JFrame temp1 = ((AdminPortal)hash.get("adminportal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((ViewallAdmin)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "adminportal";
			}

			else if(command.equals("Backflightadmin")){
				JFrame temp1 = ((AdminPortal)hash.get("adminportal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminManageFlight)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "adminportal";
			}

			else if(command.equals("Backpassengeradmin")){
				JFrame temp1 = ((AdminPortal)hash.get("adminportal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminManagePassenger)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "adminportal";
			}

			else if(command.equals("BackRegad")){
				JFrame temp1 = ((Admin)hash.get("Admin")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminRegister)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "Admin";
			}
			
			else if(command.equals("Logout")){
				JFrame temp1 = ((Login)hash.get("login")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Portal)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "login";
			}

			else if(command.equals("Logoutad")){
				JFrame temp1 = ((AdminLogin)hash.get("loginad")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminPortal)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "loginad";
			}
			
			else if(command.equals("Backlog")){
				JFrame temp1 = ((Passenger)hash.get("Passenger")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Login)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "Passenger";
			}

			else if(command.equals("Backportalad")){
				JFrame temp1 = ((AdminLogin)hash.get("loginad")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminLogin)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "loginad";
			}
			
			else if(command.equals("backpass")){
				JFrame temp1 = ((swing)hash.get("swing")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Passenger)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "swing";
			}
			else if(command.equals("backad")){
				JFrame temp1 = ((swing)hash.get("swing")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Admin)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "swing";
			}
			
			else if(command.equals("Backbooked")){
				JFrame temp1 = ((Portal)hash.get("portal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((ViewBooked)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "portal";
			}
			else if(command.equals("Backedit")){
				JFrame temp1 = ((Portal)hash.get("portal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Edit)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "portal";
			}
			else if(command.equals("Backeditad")){
				JFrame temp1 = ((AdminPortal)hash.get("adminportal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Adminedit)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "adminportal";
			}
			else if(command.equals("Saveedit")){
				JFrame temp1 = ((Portal)hash.get("portal")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Edit)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "portal";
			}
			else if(command.equals("BackReg")){
				JFrame temp1 = ((Passenger)hash.get("Passenger")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Register)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "Passenger";
			}
			else if(command.equals("Reservenext")){
				/*Reservenext rn = ((Reservenext)hash.get(command));
				Reserved rd = new Reserved(rn.getSeats(),rn.getSource(),rn.getDestin(),rn.getDate(),rn.getTime());

				try
				    {
						FileOutputStream fs = new FileOutputStream("Reserved.bin");
						ObjectOutputStream os = new ObjectOutputStream(fs);
						os.writeObject(rd);
						os.close();
						//System.out.println("done");
					}

				catch(IOException ioe)
					{
						System.out.println(ioe);
					}
				

				JFrame temp = ((Reserve)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				rn.getFrame().setVisible(false);

				currentFrame = command;*/
			}

			else if(command.equals("Reserve")){
				JFrame temp1 = ((Reserve)hash.get(command)).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((Portal)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = command;
			}
			else if(command.equals("Backlogad")){
				JFrame temp1 = ((Admin)hash.get("Admin")).getFrame();
				temp1.setVisible(true);

				JFrame temp = ((AdminLogin)hash.get(currentFrame)).getFrame();
				temp.setVisible(false);

				currentFrame = "Admin";
			}
		}
	}
