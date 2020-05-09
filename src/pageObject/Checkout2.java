package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout2 {
	
	WebDriver driver;
	
	By fname = By.xpath("//*[@id=\"billing_first_name\"]");
	By lname = By.xpath("//*[@id=\"billing_last_name\"]");
	By address = By.xpath("//*[@id=\"billing_address_1\"]");
	By city = By.xpath("//*[@id=\"billing_city\"]");
	By state = By.xpath("//*[@id=\"billing_state\"]");
	By postcode = By.xpath("//*[@id=\"billing_postcode\"]");
	By phone = By.xpath("//*[@id=\"billing_phone\"]");
	By emailID = By.xpath("//*[@id=\"billing_email\"]");
	
	public Checkout2(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterFname(String firstname)
	{
		driver.findElement(fname).clear();
		driver.findElement(fname).sendKeys(firstname);
	}
	
	public void enterLname(String lastname)
	{
		driver.findElement(lname).clear();
		driver.findElement(lname).sendKeys(lastname);
	}
	
	public void enteraddress(String addr)
	{
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(addr);
	}
	
	public void entercity(String cty)
	{
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(cty);
	}
	
	public void enterstate(String stte)
	{
		Select stt = new Select (driver.findElement(state));
		stt.selectByVisibleText(stte);
	}
	
	public void enterpostcode(String pcode)
	{
		driver.findElement(postcode).clear();
		driver.findElement(postcode).sendKeys(pcode);
	}
	
	public void enterphone(String phon)
	{
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(phon);
	}
	
	public void enteremail(String eid)
	{
		driver.findElement(emailID).clear();
		driver.findElement(emailID).sendKeys(eid);
	}

}


