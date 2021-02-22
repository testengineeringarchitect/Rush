package test.automation.development;
import java.awt.Frame;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumJavaAmazonTest {

	public static void main(String[] args) throws InterruptedException {
		
		// Open Chrome Browser and go to AMAZON
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome Driver\\88ver_chromdriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get ("http://amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Search for product & submit search
		WebElement amazonTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		amazonTextBox.sendKeys("2021 Flagship HP Laptop");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Find your exact product and select it
		WebElement laptop = driver.findElement(By.xpath("//span[.='2021 Flagship HP Laptop 14 Computer 14\" Diagonal HD Display Intel Celeron N4020 4GB RAM 64GB eMMC + 256GB SD Card Intel UHD Graphics 600 USB-C HDMI Wifi5 Bluetooth Win10 + iCarp Wireless Mouse']"));
		laptop.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Select 'Add to Cart'
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// locate Wrapped Element 'No Coverage'  iFrame ------------------------------------------------
		List <WebElement> totalFrames=driver.findElements(By.tagName("iframe"));
			System.out.println("FrameName_0 = " + Frame.getFrames());
			System.out.println("frameName_1 = " + totalFrames);
			System.out.println("Total Frames:-> " + totalFrames.size());
			
		//----- Switch to iframe	
	    System.out.println("---------------------------------------------");
		//System.out.println("FrameName_2 = " + Frame.getFrames());
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"siNoCoverage\"]")).getText());
		driver.findElement(By.xpath("//button[@class=\"a-button-text\"]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//----- Click the Cart button to view your cart
		driver.findElement(By.id("hlb-view-cart-announce")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//----- delete product from cart
		//driver.findElement(By.xpath("//span[@class=\"a-declarative\"]")).submit();
		//driver.findElement(By.xpath("//input[@name=\\\"submit.delete.C6cafb236-108f-4538-be2e-ffbdc7a8e9d8\\\"]")).submit();
		//driver.findElement(By.xpath("//span[@class=\"a-size-small sc-action-delete\"]")).submit();
		System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"][class=\"a-color-link\"]")).getText());
		WebElement delete = driver.findElement(By.cssSelector("input[type=\"submit\"][class=\"a-color-link\"]"));
		delete.click();
		System.out.println(driver.findElement(By.cssSelector("input[type=\"submit\"][class=\"a-color-link\"]")).getText());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class=\"a-declarative\"]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class=\"a-size-small sc-action-delete\"]")));
				
		System.out.println("---------------------------------------------Test Completed Successfully");		
		
		//Thread.sleep(5000);
		
		driver.close();	
	}
}