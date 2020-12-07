package testcases;

import org.testng.annotations.Test;

import pages.Homepage;

public class TC001 extends BaseTest 
{
	
	@Test
	public void copyTask()
	{
		Homepage homepage=new Homepage(driver, webActionUtil);
		homepage.clickOnTask();
		homepage.ClickOncopyTask();
		homepage.selectCutomer();
		homepage.selectProject();
		homepage.taskCopyButton();
	}
}
