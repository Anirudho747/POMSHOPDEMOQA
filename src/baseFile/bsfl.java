package baseFile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class bsfl {
  
	public static WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromeDriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	  }
	
	
	@Test
  public void Login() throws IOException {
		driver.get("http://shop.demoqa.com/");
		driver.findElement(By.xpath("/html/body/p/a")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebElement dress = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/h3/a"));
		js.executeScript("arguments[0].scrollIntoView", dress);
		dress.click();
		WebElement pic = driver.findElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[1]/div[2]/div/div/div/div[3]/img"));
		pic.click();
		TakesScreenshot tss = ((TakesScreenshot)driver);
		File Srcfile = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Srcfile, new File("C:\\Users\\Admin\\Desktop\\Screenshot\\Try7.png"));
		Select Color = new Select(driver.findElement(By.xpath("//*[@id=\"pa_color\"]")));
		Color.selectByIndex(1);
		Select Size = new Select(driver.findElement(By.xpath("//*[@id=\"pa_size\"]")));
		Size.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Rishabh");
		driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Sengupta");
		driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("Neelkamal");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Chennai");
		Select State = new Select(driver.findElement(By.xpath("//*[@id=\"billing_state\"]")));
		State.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("600016");
		driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("89776");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("hvhj");
		
		//driver.manage().window().maximize();
		

	//	WebElement cb = driver.findElement(By.cssSelector("#terms"));
	//	WebDriverWait wait1 = new WebDriverWait(driver,70);
	//	wait1.until(ExpectedConditions.elementToBeClickable(cb));
		//*[@id="terms"]
		//js.executeScript("arguments[0].scrollIntoView", cb);
	//	cb.click();
	/*	WebElement PO = driver.findElement(By.xpath("//*[@id=\"place_order\"]"));
		js.executeScript("arguments[0].scrollIntoView", PO);
		PO.click();*/
  }
  

  @AfterClass
  public void afterClass() {
  }

}
