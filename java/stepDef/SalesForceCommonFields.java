package stepDef;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.datatable.DataTable;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class SalesForceCommonFields extends AbstractTestNGCucumberTests{
	
	public ChromeDriver driver;
	public int i=0;
	
	@BeforeMethod
	public void loginIntoSalesForce(DataTable data) throws InterruptedException
	{
		//disabling notificaitons
		ChromeOptions notification = new ChromeOptions();
		notification.addArguments("--disable-notifications");
		driver = new ChromeDriver(notification);
		
		//Logging in
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<String> rowlist = data.row(1);
		
		driver.findElement(By.id("username")).sendKeys(rowlist.get(1));
		driver.findElement(By.id("password")).sendKeys(rowlist.get(2));
		driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
		
		//Toggle to menu in the left corner
        driver.findElement(By.xpath("//button[contains(@class,'slds-icon-waffle')]")).click();
		
		Thread.sleep(5000);
		//click on view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
	}
	
	@AfterMethod
	public void closeWindow()
	{
		driver.close();
	}

}
