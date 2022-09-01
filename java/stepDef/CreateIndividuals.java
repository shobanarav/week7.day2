package stepDef;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateIndividuals extends SalesForceCommonFields{
	
	public String lastNameforVerification="";

	@Given("Click Individuals from App Launcher")
	public void clickOnIndividuals()
	{
		driver.findElement(By.xpath("//p[text()='Individuals']")).click();
	}
	
	@And("Click on the Dropdown icon in the Individuals tab")
	public void clickOnDropDownIcon() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
	}
	
	@And ("Click on New Individual ")
	public void clickOnNewIndividual()
	{
		driver.findElement(By.xpath("//span[text()='New Individual']")).click();
	}
	
	@And ("Enter the Last Name as (.*)$")
	public void entertheLastName(String lastName)
	{
		driver.findElement(By.xpath("//input[contains(@class,'lastName compoundBLRadius')]")).sendKeys(lastName);
		lastNameforVerification = lastName;
	}
	
	@Then ("Click save and verify Individuals Name")
	public void saveAndVerifyName()
	{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		String nameOfIndividual = driver.findElement(By.className("uiOutputText")).getText();
		
		if(nameOfIndividual.contains(lastNameforVerification))
		{
			System.out.println("New Individual name appears");
		}
		else
		{
			System.out.println("New Individual Name does not appear");
		}
	}
}
