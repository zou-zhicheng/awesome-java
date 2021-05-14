
public class ThreadExceptionTest implements Runnable
{
	public void run()
	{
		// firstMethod();
		// tested by JamesZOU
		try{
			firstMethod();
		}catch(Exception err){
			System.out.println("-----------------err.getMessage()-----------------");
			System.out.println(err.getMessage());
			System.out.println("-----------------err.printStackTrace()-----------------");
			err.printStackTrace();
		}finally{
			System.out.println("-----------------Finally-----------------");
		}
		
	}
	public void firstMethod()
	{
		secondMethod();
	}
	public void secondMethod()
	{
		var a = 5;
		var b = 0;
		var c = a / b;
	}
	public static void main(String[] args)
	{
		new Thread(new ThreadExceptionTest()).start();
	}
}
