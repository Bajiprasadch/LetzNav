package interviewtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login_AddRole_AddUser {

	public static void main(String[] args) throws InterruptedException {
		
		//Open Chrome Browser and Enter URL 
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://letz-interview.herokuapp.com/login");
		
		//verify page title........
		String expTitle="letzNav Admin"; 
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expTitle)){
			System.out.println("HomePage opened successfully");
		}
		Thread.sleep(5000);
		
		//print no of links on home page 
		int linkCount=driver.findElements(By.tagName("a")).size();
		System.out.println(" The number of links in letzNav homepage are " + linkCount);
		
		//Enter userName and Password and click on the Login button.... 
		driver.findElement(By.name("username")).sendKeys("admin@letznav.com");
		driver.findElement(By.name("password")).sendKeys("letznav@123");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
		Thread.sleep(5000);
		
		//Click on System Settings 
		driver.findElement(By.xpath("//a[@href='/admin/system-settings']")).click();
		Thread.sleep(2000);
				
		//Click on Roles Section under SS 
		driver.findElement(By.xpath("//span[contains(text(),'Roles')]")).click(); 
		Thread.sleep(3000);
		
		//Click on Add Role  
		driver.findElement(By.xpath("(//*[contains(.,'Add Role')])[12]")).click(); 
		Thread.sleep(2000); 
		
		driver.findElement(By.id("role_name")).sendKeys("Test Interview");
		driver.findElement(By.id("role_desc")).sendKeys("This is Test Interview purpose");
		Thread.sleep(5000); 
		WebElement ele = driver.findElement(By.xpath("//div[@class='mat-select-trigger']")); 
		ele.click();
		WebElement view = driver.findElement(By.xpath("//md-option[@id='md-option-127']")); 
		Thread.sleep(2000);
		view.click(); 
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		//Click on Users Section under SS  
		driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
		Thread.sleep(3000);
		
		//Click on Add User 
		driver.findElement(By.xpath("(//*[contains(.,'Add User')])[12]")).click(); 
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click(); 
		driver.findElement(By.name("full_name")).sendKeys("Baji Prasad CH");
		driver.findElement(By.name("email")).sendKeys("bajiprasadch@gmail.com");
		Thread.sleep(6000);
		Actions dropdown = new Actions(driver);
		WebElement w1= driver.findElement(By.xpath("//md-select/div/span"));
		dropdown.moveToElement(w1).doubleClick().build().perform();
		Thread.sleep(6000);
		WebElement w2= driver.findElement(By.xpath("//md-option[11]"));
		dropdown.moveToElement(w2).doubleClick().build().perform();
		driver.findElement(By.xpath("//div[@class='mat-radio-label-content']")).click(); 
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		driver.close(); 
				
	}
}