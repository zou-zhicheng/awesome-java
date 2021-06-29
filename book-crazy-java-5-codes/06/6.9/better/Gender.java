

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
public enum Gender
{
	MALE, FEMALE;
	private String name;
	public void setName(String name)
	{
		switch (this)
		{
			case MALE:
				if (name.equals("男"))
				{
					this.name = name;
				}
				else
				{
					System.out.println("不能更换性别 男");
					return;
				}
				break;
			case FEMALE:
				if (name.equals("女"))
				{
					this.name = name;
				}
				else
				{
					System.out.println("不能更换性别 女");
					return;
				}
				break;
		}
	}
	public String getName()
	{
		return this.name;
	}
}
