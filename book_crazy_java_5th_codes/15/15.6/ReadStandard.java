import java.io.*;
import java.util.*;

// 定义一个ReadStandard类，该类可以接受标准输入，
// 并将标准输入写入out.txt文件。
public class ReadStandard
{
	public static void main(String[] args)
	{
		try (
			// 使用System.in创建Scanner对象，用于获取标准输入
			var sc = new Scanner(System.in);
			var ps = new PrintStream(new FileOutputStream("out.txt")))
		{
			// 增加下面一行将只把回车作为分隔符
			sc.useDelimiter("\n");
			// 判断是否还有下一个输入项
			while (sc.hasNext())
			{
				// 输出输入项
				ps.println("键盘输入的内容是：" + sc.next());
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
