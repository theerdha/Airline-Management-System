import java.io.*;
import java.util.*;

public class DataBase{
	private static ArrayList<Pass> passdata = new ArrayList<Pass>();
	private static ArrayList<Ad> admindata = new ArrayList<Ad>();
	private static ArrayList<Flight> flightdata = new ArrayList<Flight>();
	private static ArrayList<Reserved> reserveddata = new ArrayList<Reserved>();
	private static DataBase variable;
	public static void createInstance(String file1,String file2,String file3,String file4){
		variable = new DataBase(file1,file2,file3,file4);
	}
	public static DataBase getInstance(){
		return variable;
	}
	private DataBase(String file1,String file2,String file3,String file4){
		try{
			FileInputStream fs1 = new FileInputStream(file1);
			ObjectInputStream os1 = new ObjectInputStream(fs1);
			try{	
				while(true){
					Pass temp = (Pass)os1.readObject();
					passdata.add(temp);
					System.out.println(temp.getName());
				}
			}
			catch(Exception e){	
				System.out.println("File reading done");
			}
			os1.close();
		}
		catch(FileNotFoundException ee){
			try{
				File fp = new File(file1);
				fp.createNewFile();
			}
			catch(Exception e){}
		}
		catch(Exception e){
			//System.out.println(e);
		}

		try{
			FileInputStream fs2 = new FileInputStream(file2);
			ObjectInputStream os2 = new ObjectInputStream(fs2);
			try{	
				while(true){
					admindata.add((Ad) os2.readObject());
				}
			}
			catch(Exception e){	
				//System.out.println("File reading done");
			}
			os2.close();
		}
		catch(Exception e){
			//System.out.println(e);
		}
		try{
			FileInputStream fs3 = new FileInputStream(file3);
			ObjectInputStream os3 = new ObjectInputStream(fs3);
			try{	
				while(true){
					flightdata.add((Flight) os3.readObject());
				}
			}
			catch(Exception e){	
				//System.out.println("File reading done");
			}
			os3.close();
		}
		catch(Exception e){
			//System.out.println(e);
		}
		try{
			FileInputStream fs4 = new FileInputStream(file4);
			ObjectInputStream os4 = new ObjectInputStream(fs4);
			try{	
				while(true){
					reserveddata.add((Reserved) os4.readObject());
				}
			}
			catch(Exception e){	
				//System.out.println("File reading done");
			}
			os4.close();
		}
		catch(Exception e){
			//System.out.println(e);
		}
	}

	/*public void updateFile(String file){
		try{
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			for(Employee gd : data){
				os.writeObject(gd);
			}
			os.close();	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}*/

	public void updateFile(String file){
		try{
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			for(Pass gd : passdata){
				os.writeObject(gd);
			}
			os.close();	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void addpassenger(Pass pass,String file){
		passdata.add(pass);
		try{
			FileOutputStream fs = new FileOutputStream(file,true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(pass);
			os.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void addadmin(Ad as,String file){
		admindata.add(as);
		try{
			FileOutputStream fs = new FileOutputStream(file,true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(as);
			os.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void addflight(Flight as,String file){
		flightdata.add(as);
		try{
			FileOutputStream fs = new FileOutputStream(file,true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(as);
			os.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void addreserved(Reserved as,String file){
		reserveddata.add(as);
		try{
			FileOutputStream fs = new FileOutputStream(file,true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(as);
			os.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	/*public boolean search(Employee ee){
		for(Employee i : data){
			if(i == ee) return true;
		}
		return false;
	}*/

	public Pass searchpassenger(String userName,String password){
		for(Pass i : passdata){
			if(i.getName().equals(userName) && i.getPassword().equals(password)) return i;
		}
		return null;
	}
	public Ad searchadmin(String userName,String password){
		for(Ad i : admindata){
			if(i.getName().equals(userName) && i.getPassword().equals(password)) return i;
		}
		return null;
	}

	public ArrayList<Flight> searchflight(String source,String destination,String date,String time){
		ArrayList<Flight> fl = new ArrayList<Flight>();
		for(Flight i : flightdata){
			if(i.getSource().equals(source) && i.getDestination().equals(destination) && i.getDate().equals(date) && i.getTime().equals(time)) fl.add(i);
		}
		return fl;
	}


	
}