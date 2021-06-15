
import java.util.concurrent.*;
/**
 * Description:
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 5.0
 */

public class ThirdThread
{
	public static void main(String[] args)
	{
		// 创建Callable对象
		var rt = new ThirdThread();
		// 先使用Lambda表达式创建Callable<Integer>对象
		// 使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
			var i = 0;
			for ( ; i < 100; i++)
			{
				System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
			}
			// call()方法可以有返回值
			return i;
		});
		FutureTask<Integer> task2 = new FutureTask<>((Callable<Integer>)() -> {
			var i = 0;
			for ( ; i < 100; i++)
			{
				System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
			}
			// call()方法可以有返回值
			return i;
		});
		for (var i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ " 的循环变量i的值：" + i);
			if (i == 20)
			{
				// 实质还是以Callable对象来创建、并启动线程
				new Thread(task, "有返回值的线程").start();
				// JamesZOU测试, 加上下面这条并没有执行
				// new Thread(task, "线程2").start();
				// JamesZOU: 再新建一个task,就可以执行
				new Thread(task2, "有返回值的线程2").start();
			}
		}
		try
		{
			// 获取线程返回值
			System.out.println("子线程的返回值：" + task.get());
			System.out.println("子线程2的返回值：" + task2.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

