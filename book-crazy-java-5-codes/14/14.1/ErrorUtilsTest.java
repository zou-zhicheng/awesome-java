
import java.util.*;

public class ErrorUtilsTest
{
	public static void main(String[] args)
	{
		// Exception in thread "main" java.lang.ClassCastException: 
		// class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
		// at ErrorUtils.faultyMethod(ErrorUtils.java:25)
		// at ErrorUtilsTest.main(ErrorUtilsTest.java:8)
		ErrorUtils.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!")); 
	}
}


