package complex;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {
  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    WebDriver driver = new ChromeDriver();

    driver.get("https://formy-project.herokuapp.com/form");

    driver.findElement(By.id("first-name")).sendKeys("John");

    driver.findElement(By.id("last-name")).sendKeys("Doe");

    driver.findElement(By.id("job-title")).sendKeys("QA Engineer");

    driver.findElement(By.id("radio-button-2")).click();

    driver.findElement(By.id("checkbox-2")).click();

    driver.findElement(By.cssSelector("option[value='1']")).click();

    driver.findElement(By.id("datepicker")).sendKeys("05/28/2019");
    driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

    Thread.sleep(2000);

    driver.quit();
  }
}
