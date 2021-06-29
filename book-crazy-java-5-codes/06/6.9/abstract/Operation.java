

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
public enum Operation
{
	// 定义每个枚举值时必须为抽象方法提供实现， 否则将出现编译错误。
	PLUS
	{
		public double eval(double x, double y)
		{
			return x + y;
		}
	},
	MINUS
	{
		public double eval(double x, double y)
		{
			return x - y;
		}
	},
	TIMES
	{
		public double eval(double x, double y)
		{
			return x * y;
		}
	},
	DIVIDE
	{
		public double eval(double x, double y)
		{
			return x / y;
		}
	};
	// 为枚举类定义一个抽象方法
	// 这个抽象方法由不同的枚举值提供不同的实现
	public abstract double eval(double x, double y);
	public static void main(String[] args)
	{
		System.out.println(Operation.PLUS.eval(3, 4));
		System.out.println(Operation.MINUS.eval(5, 4));
		System.out.println(Operation.TIMES.eval(5, 4));
		System.out.println(Operation.DIVIDE.eval(5, 4));
	}
}

