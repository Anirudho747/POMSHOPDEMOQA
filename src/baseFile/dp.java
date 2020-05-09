package baseFile;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class dp {
 
	public static WebDriver driver;
	
 @BeforeClass
 public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromeDriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://shop.demoqa.com/checkout/");
	 
	 
	    driver.get("http://shop.demoqa.com/");
		driver.findElement(By.xpath("/html/body/p/a")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebElement dress = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/h3/a"));
		js.executeScript("arguments[0].scrollIntoView", dress);
		dress.click();
		Select Color = new Select(driver.findElement(By.xpath("//*[@id=\"pa_color\"]")));
		Color.selectByIndex(1);
		Select Size = new Select(driver.findElement(By.xpath("//*[@id=\"pa_size\"]")));
		Size.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
 }
	
	
  @Test(dataProvider = "datapro")
  public void f(String Fname,String Lname,String Address,String City,String State,String PostCode,String Phone,String Email) {
	  
	  driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).clear();
	  driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).clear();

	  driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys(Fname);
	  driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys(Lname);
	  driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys(Address);
	  driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys(City);
	  driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys(PostCode);
	  driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys(Phone);
	  driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys(Email);
	  Select state = new Select (driver.findElement(By.xpath("//*[@id=\"billing_state\"]")));
	  state.selectByVisibleText(State);
  }

  @DataProvider
  public Object[][] datapro() throws IOException {
   FileInputStream FIS = new FileInputStream("C:\\Users\\Admin\\Desktop\\POI.xlsx");
   XSSFWorkbook wb = new XSSFWorkbook(FIS);
   XSSFSheet sheet = wb.getSheetAt(7);
   XSSFCell cell = null;
   
   int rc=sheet.getLastRowNum()-sheet.getFirstRowNum();
   
   String rs[][]= new String[rc+1][8];
   
   for(int i=1;i<=rc;i++)
   {
	   Row row = sheet.getRow(i);
	   for(int j=0;j<8;j++)
	   {
		   cell = sheet.getRow(i).getCell(j);
		   cell.setCellType(CellType.STRING);
		   String Celldata = cell.getStringCellValue();
		   rs[i][j] = Celldata;
	   }
   }

   return rs;
  }
  

  @AfterClass
  public void afterClass() {
  }

}
