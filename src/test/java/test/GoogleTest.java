package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest{

  // Optional. If not specified, WebDriver searches the PATH for chromedriver.
  // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
  public static void main(String[] args) throws InterruptedException {
    
  WebDriverManager.chromedriver().setup();
  WebDriver driver = new ChromeDriver();
  driver.get("http://www.google.com/"); 
  Thread.sleep(5000);  // Let the user actually see something!

  WebElement odrzucButton = driver.findElement(By.xpath("//div[text()='Odrzuć wszystko']"));
  odrzucButton.click();
  
  Thread.sleep(5000);  // Let the user actually see something!
  WebElement searchBox = driver.findElement(By.name("q"));
  searchBox.sendKeys("ChromeDriver");
  searchBox.submit(); 
  Thread.sleep(5000);  // Let the user actually see something!
  driver.quit();  
}
}
