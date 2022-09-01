package stepDef;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CreateNewDashboard extends SalesForceCommonFields{
	
	public  String dashName ="";

	@Given("Click Dashboards from App Launcher")
	public void clickOnDashboard()
	{
		driver.findElement(By.xpath("//p[text()='Dashboards']")).click();
	}
	
	@And("Click on the New Dashboard option")
	public void clickOnNewDashboardOption() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
	}
	
	@And("Enter Name as (.*)$")
	public void clickOnNameforDashboard(String dashboardName) throws InterruptedException
	{
		Thread.sleep(7000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.id("dashboardNameInput")).sendKeys(dashboardName);
		dashName= dashboardName;
	}
	
	@And ("Click on Create")
	public void clickOnCreate()
	{
		driver.findElement(By.id("submitBtn")).click();
	}
	
	@And ("Click on Save")
	public void clickonSave() throws InterruptedException
	{
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
	}
	
	@And(" Verify Dashboard name")
	public void verfiyDashboardName()
	{
		String title = driver.getTitle();
		
		if(title.contains(dashName))
		{
			System.out.println("Dasboard Name appears");
		}
		else
		{
			System.out.println("Dashboard name is wrong");
		}
	}
}
