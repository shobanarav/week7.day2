package stepDef;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateNewOpportunity extends SalesForceCommonFields{

String opportunityName = "";

    @Given("Click Sales from App Launcher")
    public void clickonSales()
    {
    	driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
    }
	
	@And("Click on Opportunity tab")
	public void clickOpportunityTab()
	{
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Opportunities']")));
	}
	
	@And("Click on New button")
	public void clickonNewButton()
	{
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}
	
	@And("Enter Opportunity name as (.*)$")
	public void enterOpportunityName(String name)
	{
		opportunityName = name;
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]")).sendKeys(opportunityName);
	}
	
	@And("Choose close date as Today")
	public void chooseDayAsToday()
	{
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();

	}
	
	@And("Select Stage as (.*)$")
	public void selectStage(String stage)
	{
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

	}
	
	@Then("Click Save and Verify Oppurtunity Name")
	public void clickSaveAndVerifyOpportunity()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		String oppNameCaptured = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();

		Assert.assertEquals(oppNameCaptured, opportunityName);
		if(oppNameCaptured.equals(opportunityName))
		{
			System.out.println("Opportunity name is verified");
		}
		else
		{
			System.out.println("Opportunity Name has mis-match");
		} 

	}
	
}
