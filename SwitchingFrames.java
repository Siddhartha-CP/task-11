package task11;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		 driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        driver.switchTo().frame("frame-top");
        
        int frameCount = driver.findElements(By.cssSelector("frame")).size();
        
        if (frameCount == 3) {
            System.out.println("Verified three frames in the top frame.");
        } else {
        	
            System.out.println("Top frame does not contain three frames. Found: " + frameCount);
        }
        
        driver.switchTo().frame("frame-left");
        
        String leftText =driver.findElement(By.xpath("//body")).getText();
        
        if(leftText.equals("LEFT")) {
        	 System.out.println("Verified text in left frame as 'LEFT'.");
        } else {
            System.out.println("Left frame text verification failed. Found: " + leftText);
        }
        
        driver.switchTo().parentFrame();
        
        driver.switchTo().frame("frame-middle");
        
        String MiddleText =driver.findElement(By.xpath("//body")).getText();
        
        if(MiddleText.equals("MIDDLE")) {
        	 System.out.println("Verified text in left frame as 'MIDDLE'.");
        } else {
            System.out.println("Left frame text verification failed. Found: " + MiddleText);
        }
        
        driver.switchTo().parentFrame();
        
        driver.switchTo().frame("frame-right");
        
        String RightText =driver.findElement(By.xpath("//body")).getText();
        
        if(RightText.equals("RIGHT")) {
        	 System.out.println("Verified text in left frame as 'RIGHT'.");
        } else {
            System.out.println("Left frame text verification failed. Found: " + RightText);
        }
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame("frame-bottom");		
        String BottomText =driver.findElement(By.xpath("//body")).getText();
        
        if(BottomText.equals("BOTTOM")) {
        	 System.out.println("Verified text in left frame as 'BOTTOM'.");
        } else {
            System.out.println("Left frame text verification failed. Found: " + BottomText);
        }
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://the-internet.herokuapp.com/nested_frames")) {
            System.out.println("Page URL verified as: " + currentUrl);
        } else {
            System.out.println("Page URL verification failed. Found: " + currentUrl);
        }
        
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\siddh\\eclipse-workspace\\Seleniumstarts\\snap\\nested_frames.png");
		
		FileUtils.copyFile(source, dest);
	}
}
