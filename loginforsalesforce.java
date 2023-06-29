
package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginforsalesforce {

	private static RemoteWebDriver driver;
	
	@Test
	public void CreateAccountSalesForce() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
       driver.get("https://login.salesforce.com/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
       driver.findElement(By.id("password")).sendKeys("Leaf@1234");
       driver.findElement(By.id("Login")).click();
       Thread.sleep(4000);
       driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
       Thread.sleep(4000);
       driver.findElement(By.xpath("//button[text()='View All']")).click();
       Thread.sleep(4000);
       driver.findElement(By.xpath("//p[text()='Sales']")).click();
       Thread.sleep(6000);
       JavascriptExecutor jc = (JavascriptExecutor) driver;
       jc.executeScript("arguments[0].click();", driver.findElement(By.xpath("//one-app-nav-bar-item-root/a/span[text()='Accounts']")));
       driver.findElement(By.xpath("//div[@title='New']")).click();
       driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Sudarshan1");
       jc.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")));
       driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
       driver.findElement(By.xpath("//span[text()='Public']")).click();
       driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
       String av= driver.findElement(By.xpath("//div[@role=\"alertdialog\"]//following-sibling::div//div/div/span")).getText();
       System.out.println(av);
       Assert.assertEquals(av, "Account \"Sudarshan1\" was created.");
       
       
       
       
       
       
       
        
        
	}

}
