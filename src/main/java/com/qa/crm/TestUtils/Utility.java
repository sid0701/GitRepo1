package com.qa.crm.TestUtils;

import com.qa.crm.TestBase.Base;

public class Utility extends Base{

	public static long pageloadtimeout = 30;
	public static long implicitywait = 30;
	
	public static void switchToFrame(String fname)
	{
		driver.switchTo().frame(fname);
	}
	
}
