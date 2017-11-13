import java.io.*;
public class Flight implements Serializable
{
	private String type;
	private String number;
	private String source;
	private String destination;
	private String date;
	private String time;
	private String classtype;
	private String meal;
	private String amount;
	//private String place[10];

	public String getSource()
	{
		return this.source;
	}

	public String[] getlist()
	{
		String[] mylist = new String[9];
		mylist[0] = type;
		mylist[1] = number;
		mylist[2] = source;
		mylist[3] = destination;
		mylist[4] = date;
		mylist[5] = time;
		mylist[6] = classtype;
		mylist[7] = meal;
		mylist[8] = amount;

		return mylist;


	}

	public String getType()
	{
		return this.type;
	}

	public String getNumber()
	{
		return this.number;
	}

	public String getClasstype()
	{
		return this.classtype;
	}
	public String getMeal()
	{
		return this.meal;
	}
	public String getAmount()
	{
		return this.amount;
	}
	public String getDestination()
	{
		return this.destination;
	}

	public String getDate()
	{
		return this.date;
	}

	public String getTime()
	{
		return this.time;
	}



	public Flight(String type,String number,String source,String destination,String date,String time,String classtype,String meal,String amount)
	{
		this.type = type;
		this.number = number;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.classtype = classtype;
		this.meal = meal;
		this.amount = amount;
	}
}