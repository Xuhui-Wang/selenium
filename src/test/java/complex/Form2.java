package complex;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form2 {
  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    WebDriver driver = new ChromeDriver();

    driver.get("https://formy-project.herokuapp.com/form");

    FormPage.submitForm(driver);

    ConfirmationPage.waitForAlertBanner(driver);

    assertEquals("The form was successfully submitted!", ConfirmationPage.getAlertBannerText(driver));

    driver.quit();
  }
}
