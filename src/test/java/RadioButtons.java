import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class RadioButtons {
  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    WebDriver driver = new ChromeDriver();

    driver.get("https://formy-project.herokuapp.com/radiobutton");

    WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
    radioButton1.click();
    Thread.sleep(1000);

    WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
    radioButton2.click();
    Thread.sleep(1000);

    WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
    radioButton3.click();
    Thread.sleep(1000);

    driver.get("https://formy-project.herokuapp.com/checkbox");

    WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
    checkbox1.click();
    Thread.sleep(1000);

    WebElement cb2 = driver.findElement(By.cssSelector("input[value='checkbox-2']"));
    cb2.click();
    Thread.sleep(1000);

    WebElement cb3 = driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]"));
    cb3.click();
    Thread.sleep(1000);

    driver.quit();
  }
}
