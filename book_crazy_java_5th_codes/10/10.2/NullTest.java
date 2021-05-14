
import java.util.*;

public class NullTest
{
	public static void main(String[] args)
	{
		Date d = null;
		try
		{
			System.out.println(d.after(new Date()));
		}
		catch (NullPointerException ne)
		{
			System.out.println("NullPointerException");
		}
		catch (Exception e)
		{
			System.out.println("Exception");
		}
	}
}
