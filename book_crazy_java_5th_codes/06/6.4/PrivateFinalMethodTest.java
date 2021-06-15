
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
class PrivateFinalMethodTestSup
{
	private final void test(){
		System.out.println("PrivateFinalMethodTest");
	}
}

class PrivateFinalMethodTest extends PrivateFinalMethodTestSup
{
	// 下面方法定义将不会出现问题
	public void test(){
		System.out.println("Sub");
	}
	
	public static void main(String[] args){
		// 这样使用会出错, 不能使用test()方法
		// PrivateFinalMethodTestSup pt = new PrivateFinalMethodTest();
		PrivateFinalMethodTest pt = new PrivateFinalMethodTest();
		pt.test();
	}
}
