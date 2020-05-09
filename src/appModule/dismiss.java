package appModule;

import org.openqa.selenium.WebDriver;
import pageObject.Homepage2;

public class dismiss {

	public static void execute(WebDriver driver)
	{
		driver.get("http://shop.demoqa.com/");
		Homepage2 hp2 = new Homepage2(driver);
		hp2.removeDismiss();
	}
	
}
