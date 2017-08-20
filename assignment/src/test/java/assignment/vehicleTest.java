package assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import uk.co.assignment.ReadCSV;
import uk.co.assignment.ScanFolderForFiles;
import uk.co.assignment.Vehicle;

public class vehicleTest {
	List<Vehicle> vehicles;
	WebDriver driver;
	@Before
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void verifyVehicleDetails()
	{
		File[] files= new ScanFolderForFiles().getFilesByMimeType("text/csv");
		
		try {
			 vehicles = ReadCSV.mapFileToVehicles(files[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Unable to access supported files");
		}
		
		
		
		for(Vehicle v : vehicles)
		{
			driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
			driver.findElement(By.linkText("Start now")).click();
			driver.findElement(By.id("Vrm")).sendKeys(v.getRegistrationNumber());
			driver.findElement(By.name("Continue")).click();
			Assert.assertEquals("Verify Make is correct", v.getMake(), driver.findElement(By.xpath("//span[text()='Make']/../span[2]/strong[text()='"+ v.getMake() +"']")).getText());
			Assert.assertEquals("Verify Color is correct", v.getColour(), driver.findElement(By.xpath("//span[text()='Colour']/../span[2]/strong[text()='"+ v.getColour() +"']")).getText());
			
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
