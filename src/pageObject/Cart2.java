package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart2 {
	
	WebDriver driver;
	
	By qty              = By.xpath("//*[@id=\"noo-quantity-1765\"]");
	By cancelItem       = By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[6]/a");
	By clearCart        = By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[2]/td/a[1]");
	By updateCart       = By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[2]/td/input[1]");
	By continueShopping = By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[2]/td/a[2]");
	By enterCoupon      = By.xpath("//*[@id=\"noo_coupon_code\"]");
	By applyCoupon      = By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[1]/button");
	By checkout         = By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a");
	
	public Cart2(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void updateqty(String q)
	{
		driver.findElement(qty).clear();
		driver.findElement(qty).sendKeys(q);
	}
	
	public void clickCancelItem()
	{
		driver.findElement(cancelItem).click();
	}
	
	public void clickClearCart()
	{
		driver.findElement(clearCart).click();
	}
	
	public void clickUpdateCart()
	{
		driver.findElement(updateCart).click();
	}
	
	public void clickContinueShopping()
	{
		driver.findElement(continueShopping).click();
	}
	
	public void fillCoupon(String Coupcode)
	{
		driver.findElement(enterCoupon).clear();
		driver.findElement(enterCoupon).sendKeys(Coupcode);
	}
	
	public void clickApplyCoupon()
	{
		driver.findElement(applyCoupon).click();
	}
	
	public void clickCheckOut()
	{
		driver.findElement(checkout).click();
	}
}
