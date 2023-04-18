
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.time.chrono.MinguoDate;

import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TakesScreenshot;
import java.util.*;



public class ORIGINAL {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver;
		

		for (int k = 0; k < 3; k++) {

			Date date = new Date();
			String updatedDate = date.toString();

			String fixedDate = updatedDate.replace(":", "-");

			driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			Random rand = new Random();
			int indexsize = rand.nextInt(0, 6);

			driver.get("https://www.saucedemo.com");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();

			List<WebElement> addToCartButtons = driver.findElements(By.className("btn_primary"));
	
		
			for (int i = 0; i <= indexsize; i++) {
				addToCartButtons.get(i).click();

				driver.manage().window().maximize();
				
				
				//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			   //js.executeScript("window.scrollTo(0, document.body.scrollWidth)");
	
			 
		
				
				js.executeScript("window.scrollTo(0,2)");
			    TakesScreenshot scrShot = ((TakesScreenshot) driver);			    			    
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File(".//"+fixedDate+".png");
				FileUtils.copyFile(SrcFile, DestFile);
				
			}
		}

	}

	

}
