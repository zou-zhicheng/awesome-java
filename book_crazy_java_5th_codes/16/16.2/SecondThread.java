

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
// 通过实现Runnable接口来创建线程类
public class SecondThread implements Runnable
{
	private int i;
	// run方法同样是线程执行体
	public void run()
	{
		for ( ; i < 100; i++)
		{
			// 当线程类实现Runnable接口时，
			// 如果想获取当前线程，只能用Thread.currentThread()方法。
			System.out.println(Thread.currentThread().getName()
				+ " " + i);
		}
	}

	public static void main(String[] args)
	{
		for (var i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ " " + i);
			if (i == 20)
			{
				var st = new SecondThread();     // ①
				// 通过new Thread(target, name)方法创建新线程
				// 可以多个线程共享同一个target对象， 所以非常适合多个相同线程来处理同一份资源的情况， 
				// 从而可以将CPU，代码和数据分开， 形成清晰的模型， 较好地体现了面向对象的思想
				new Thread(st, "新线程1").start();
				new Thread(st, "新线程2").start();
			}
		}
	}
}

