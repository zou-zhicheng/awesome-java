

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

class MyClass<E>
{
	public <T> MyClass(T t)
	{
		System.out.println("t参数的值为：" + t);
	}
}
public class GenericDiamondTest
{
	public static void main(String[] args)
	{
		// MyClass类声明中的E形参是String类型。
		// 泛型构造器中声明的T形参是Integer类型
		MyClass<String> mc1 = new MyClass<>(5);
		MyClass<String> mc2 = new MyClass<String>(5);
		// 显式指定泛型构造器中声明的T形参是Integer类型，
		MyClass<String> mc3 = new <Integer> MyClass<String>(5);
		// MyClass类声明中的E形参是String类型。
		// 如果显式指定泛型构造器中声明的T形参是Integer类型
		// 此时就不能使用"菱形"语法，下面代码是错的。
		// 错误: 无法推断MyClass<E>的类型参数
		// MyClass<String> mc4 = new <Integer> MyClass<>(5);
		//                                            ^
		// 原因: 不能将 '<>' 与构造器的显式类型参数一起使用
		// 其中, E是类型变量:
		// 	E扩展已在类 MyClass中声明的Object
		// 1 个错误
		// MyClass<String> mc4 = new <Integer> MyClass<>(5);
	}
}
