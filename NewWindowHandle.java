package task11;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//a[text()=\"Click Here\"]")).click();
		
		//Get the set of windows
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		//convert Set to List
		
		List<String> windows = new ArrayList<String>(windowhandles);
		
		//Pick up the particular window and switch to it 
		
		driver.switchTo().window(windows.get(1));
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		File dest = new File("C:\\Users\\siddh\\eclipse-workspace\\Seleniumstarts\\snap\\NEWPage.png");
		
		FileUtils.copyFile(source, dest);
		
		Thread.sleep(3000);
		
		driver.close();		
		
		driver.quit();
		
	}

}
