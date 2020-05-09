package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DressLandingPage2 {
	
	WebDriver driver;
	
	By snap1 = By.xpath("//*[@id=\"product-1162\"]/div[1]/div[1]/div[2]/div/div/div/div[1]/img");
	By snap2 = By.xpath("//*[@id=\"product-1162\"]/div[1]/div[1]/div[2]/div/div/div/div[2]/img");
	By snap3 = By.xpath("//*[@id=\"product-1162\"]/div[1]/div[1]/div[2]/div/div/div/div[4]/img");
	By qty   = By.xpath("//input[@name=\"quantity\"]");
	By color = By.xpath("//*[@id=\"pa_color\"]");
	By size  = By.xpath("//*[@id=\"pa_size\"]");
	By add2cart = By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button");
	By viewcart = By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a");
	
	public DressLandingPage2(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickSnap1()
	{
		driver.findElement(snap1).click();
	}
	
	public void clickSnap2()
	{
		driver.findElement(snap2).click();
	}
	
	public void clickSnap3()
	{
		driver.findElement(snap3).click();
	}
	
	public void updateqty(String q)
	{
		driver.findElement(qty).clear();
		driver.findElement(qty).sendKeys(q);
	}
	
	public void updatecolor(int ind)
	{
		Select col = new Select (driver.findElement(color));
		col.selectByIndex(ind);
	}

	public void updateSize(String ind)
	{
		Select siz = new Select (driver.findElement(size));
		siz.selectByVisibleText(ind);
	}
	
	public void clickadd2Cart()
	{
		driver.findElement(add2cart).click();
	}
	
	public void clickviewcart()
	{
		driver.findElement(viewcart).click();
	}
}
