package appTest;

import org.testng.annotations.Test;

import appUtilities.constant;
import pageObject.Cart2;
import pageObject.Checkout2;
import pageObject.DressLandingPage2;
import pageObject.Homepage2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import appModule.dismiss;

public class FnlClass2 {
	
	public static WebDriver driver = null;
	
	@BeforeClass
	  public void beforeClass() {
		System.setProperty(constant.arg0, constant.arg1);
		driver = new ChromeDriver();
		driver.get(constant.url);  
	}
	
	  @Test(priority=1)
	  public static void main() throws IOException {
      Homepage2 hp2 = new Homepage2(driver);
      DressLandingPage2 dp2 = new DressLandingPage2(driver);
      Cart2 c2 = new Cart2(driver);  
      
      dismiss.execute(driver);
      hp2.clickBlackcrossdress();
      TakesScreenshot tss = ((TakesScreenshot)driver);
      File Srcfile = tss.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(Srcfile, new File("C:\\Users\\Admin\\Desktop\\Screenshot\\Try8.png"));
      dp2.clickSnap2();
      File Srcfile1 = tss.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(Srcfile1, new File("C:\\Users\\Admin\\Desktop\\Screenshot\\Try9.png"));
      dp2.clickSnap3();
      File Srcfile2 = tss.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(Srcfile2, new File("C:\\Users\\Admin\\Desktop\\Screenshot\\Try10.png"));
      dp2.updatecolor(1);
      dp2.updateSize("Medium");
      dp2.updateqty("2");
      dp2.clickadd2Cart();
      dp2.clickviewcart();
      c2.clickCheckOut();
      
	}
	
	
	
  @Test(dataProvider = "dp",priority=2)
  public void f(String Fname,String Lname,String Address,String City,String State,String PostCode,String Phone,String Email) {
	  Checkout2 co2 = new Checkout2(driver);
	  
	  co2.enterFname(Fname);
	  co2.enterLname(Lname);
	  co2.enteraddress(Address);
	  co2.entercity(City);
	  co2.enterpostcode(PostCode);
	  co2.enterphone(Phone);
	  co2.enteremail(Email);
	  co2.enterstate(State);
  }

  @DataProvider
  public Object[][] dp() throws IOException,FileNotFoundException{
    
	  FileInputStream FIS = new FileInputStream("C:\\Users\\Admin\\Desktop\\POI.xlsx");
	    XSSFWorkbook wb = new XSSFWorkbook(FIS);
	    XSSFSheet sheet = wb.getSheetAt(8);
	    XSSFCell cell = null;
	    
	    int rc = sheet.getLastRowNum()-sheet.getFirstRowNum();
		  
		  System.out.println(rc);
	    
	    String rs[][] = new String[rc+1][8];
	    System.out.println(rc);
	    
	    for (int i=0,i1=0;i<=rc;i++,i1++)
	    {
	    	Row row = sheet.getRow(i);
	 
	    	for(int j=0;j<8;j++)
	    	{
	    		cell = sheet.getRow(i).getCell(j);
	    		cell.setCellType(CellType.STRING);                   //Cell=cell.getCellType();
	    		String Celldata = cell.getStringCellValue();         //cell.getBooleanCellValue() cell.getDateCellValue() cell.getErrorCellValue() cell.getNumericCellValue() cell.getStringCellValue()
	    		rs[i1][j] = Celldata;
	    	}
	    }
	    
	    return rs;
	  
  }
  

  @AfterClass
  public void afterClass() {
  }

}
