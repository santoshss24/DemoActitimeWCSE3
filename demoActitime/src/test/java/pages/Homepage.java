package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage 
{
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	@FindBy(xpath = "(//div[text()='Calls'])[1]")
	private WebElement Task;
	
	@FindBy(xpath = "//div[text()='ACTIONS']")
	private WebElement ActionsButton;
	
	@FindBy(xpath = "//div[text()='Copy to']")
	private WebElement CopyToButton;
	
	@FindBy(xpath = "//div[text()='- Select Customer -']")
	private WebElement selectCustomerDropdown;
	
	@FindBy(xpath = "//div[text()='Big Bang Company']")
	private WebElement selectCustomerOption;
	
	@FindBy(xpath = "//div[text()='- Select Project -']")
	private WebElement selectProjectDropdown;
	
	@FindBy(xpath = "//div[text()='Flight operations']")
	private WebElement selectProjectOption;
	
	@FindBy(xpath = "//div[text()='Copy']")
	private WebElement taskCopyButton;

	public Homepage(WebDriver driver, library.webActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	public void clickOnLogout()
	{
		webActionUtil.clickOnElement(logoutLink);
	}
	
	public void clickOnTask()
	{
		webActionUtil.clickOnElement(Task);
	}
	
	public void ClickOncopyTask()
	{
		webActionUtil.clickOnElement(ActionsButton);
		webActionUtil.clickOnElement(CopyToButton);
	}
	
	public void selectCutomer()
	{
		webActionUtil.clickOnElement(selectCustomerDropdown);
		webActionUtil.clickOnElement(selectCustomerOption);
	}
	
	public void selectProject()
	{
		webActionUtil.clickOnElement(selectProjectDropdown);
		webActionUtil.clickOnElement(selectProjectOption);
	}
	
	public void taskCopyButton()
	{
		webActionUtil.clickOnElement(taskCopyButton);
		
	}
	

}
