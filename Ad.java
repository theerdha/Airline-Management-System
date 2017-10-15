import java.io.*;
public class Ad implements Serializable
{
	private transient String id;
	private transient String name;
	private transient String email;
	private transient String password;
	private transient String contact;

	public String getName()
	{
		return this.name;
	}

	public String getPassword()
	{
		return this.password;
	}


	public Ad(String id,String name,String email,String password,String contact)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}
}