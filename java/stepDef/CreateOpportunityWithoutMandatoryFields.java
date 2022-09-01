package stepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class CreateOpportunityWithoutMandatoryFields extends SalesForceCommonFields{

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
	
	@And("Choose Close date as Tomorrow Date")
	public void chooseCloseDateAsTomorrow()
	{
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		
	}
	
	@And("Click on save and Verify the Alert message displayed")
	public void clickSaveAndCerifyAlertMessage()
	{
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		List<WebElement> errors = driver.findElements(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a"));

		boolean name = false;
		boolean stage = false;

		for (WebElement eachError : errors) {
			String text = eachError.getText();
			if(text.equals("Opportunity Name"))
				name = true;
			else if(text.equals("Stage"))
				stage = true;
		}

		if (name&&stage)
			System.out.println("Alert message is verified");
		else
			System.out.println("Alert message is NOT verified");

	}

	
}
