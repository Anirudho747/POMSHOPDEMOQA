package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Homepage2 {
	
	WebDriver driver;
	
	By dismiss         = By.xpath("/html/body/p/a");
	By blackcrossdress = By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/h3/a");

	public Homepage2(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void removeDismiss()
	{
		driver.findElement(dismiss).click();
	}
	
	public void clickBlackcrossdress()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView", driver.findElement(blackcrossdress));
		driver.findElement(blackcrossdress).click();
	}
	
}
