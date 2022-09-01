package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CreateAccount extends SalesForceCommonFields{
	
	public String accountName="";
	
	@Given("Click Sales from App Launcher")
	public void clickOnSales()
	{
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
	}
	
	@And ("Click on Accounts tab")
	public void clickOnAccountsTab() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement accountsTab = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accountsTab);
	}
	
	@And ("Click on New button")
	public void clickOnNewButton() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}
	
	@And ("Enter your name as (.*)$")
	public void entername(String accName)
	{
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(accName);
		accountName = accName;
	}
	
	@And("Select Ownership as Public")
	public void selectOwnership()
	{
		WebElement ownership = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].click();", ownership);
		driver.findElement(By.xpath("(//span[text()='Public'])[1]")).click();
	}
	
	@And("Click save and verify Account name")
	public void clickSaveAndVerifyAccName()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String accountNameDerived = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		Assert.assertEquals(accountNameDerived, accountName);
	}

}
