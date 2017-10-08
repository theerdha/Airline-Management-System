import java.io.*;
public class Pass implements Serializable
{
	private transient String name;
	private transient String email;
	private transient String password;
	private transient String passport;

	public Pass(String name,String email,String password,String passport)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.passport = passport;
	}

	public String getName()
	{
		return name;
	}
	public String getemail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public String getpassport()
	{
		return passport;
	}

}