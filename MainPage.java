import java.awt.*;
import java.util.*;	
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class MainPage{	
	public static void main(String[] args){
			HashMap frames = new HashMap();
			
     		DataBase.createInstance("Passenger.txt","Admin.bin","Flight.bin","Reserved.bin");
     		DataBase db = DataBase.getInstance();
			 Flight fl1 = new Flight("Domestic","1234","Hyderabad","Kolkata","10-04-2017","12:00","bussiness","Veg/NonVeg","10000");
			db.addflight(fl1,"Flight.bin");

			Flight fl2 = new Flight("Domestic","9364","Hyderabad","Kolkata","10-04-2017","12:00","Regular","Veg","6000");
			db.addflight(fl2,"Flight.bin");

			Flight fl3 = new Flight("Domestic","6354","Hyderabad","Kolkata","10-04-2017","12:00","bussiness","NonVeg","9000");

			db.addflight(fl3,"Flight.bin");

			Flight fl4 = new Flight("Domestic","12354","Bombay","Kolkata","19-04-2017","12:00","bussiness","Veg/NonVeg","10000");
			db.addflight(fl4,"Flight.bin");

			Flight fl5 = new Flight("Domestic","93647","Bombay","Kolkata","19-04-2017","12:00","Regular","Veg","6000");
			db.addflight(fl5,"Flight.bin");

			Flight fl6 = new Flight("Domestic","63542","Bombay","Kolkata","19-04-2017","12:00","bussiness","NonVeg","9000");

			db.addflight(fl6,"Flight.bin");

			Flight fl7 = new Flight("International","123412","Hyderabad","Europe","20-04-2017","12:00","bussiness","Veg/NonVeg","10000");
			db.addflight(fl7,"Flight.bin");

			Flight fl8 = new Flight("International","94364","Hyderabad","Europe","20-04-2017","12:00","Regular","Veg","6000");
			db.addflight(fl8,"Flight.bin");

			Flight fl9 = new Flight("International","63554","Hyderabad","Europe","20-04-2017","12:00","bussiness","NonVeg","9000");

			db.addflight(fl9,"Flight.bin");

			frames.put("swingmain",new swingmain());
			frames.put("swing",new swing());
			frames.put("Passenger",new Passenger());
			frames.put("register", new Register());
			frames.put("Reserve", new Reserve());
			frames.put("login", new Login());
			frames.put("portal", new Portal());
			frames.put("view", new View());
			frames.put("viewall", new Viewall());
			frames.put("viewad", new ViewallAdmin());
			frames.put("ViewBooked", new ViewBooked());
			frames.put("Edit", new Edit());
			frames.put("Reservenext", new Reservenext());
			frames.put("Admin", new Admin());
			frames.put("loginad", new AdminLogin());
			frames.put("adminportal", new AdminPortal());
			frames.put("Editad", new Adminedit());
			frames.put("adminregister", new AdminRegister());
			frames.put("manageflight", new AdminManageFlight());
			frames.put("managepassenger", new AdminManagePassenger());
			frames.put("addflight", new AddFlight());

			ButtonHandling.updateHash(frames);

			
			

			
			//ChangeHandling.updateHash(frames);
			//ChangeHandling.updateHash(frames);
	}
}
