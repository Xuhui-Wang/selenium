import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TestSample  {
  private static void GoogleSearch(WebDriver driver) {
        // And now use this to visit Google
    driver.get("https://www.google.com");

    // Find the text input element by its name
    WebElement element = driver.findElement(By.name("q"));

    // Enter something to search for
    element.sendKeys("Cheese!");

    // Now submit the form
    element.submit();

  }

  private static void clickButton(WebDriver driver) throws InterruptedException {

    driver.get("https://formy-project.herokuapp.com/keypress");
    WebElement name = driver.findElement(By.id("name"));
    name.click();
    name.sendKeys("Meaghan Lewis");

    Thread.sleep(1000);
    WebElement button = driver.findElement(By.id("button"));
    button.click();
  }

  private static void autoComplete(WebDriver driver) throws InterruptedException {

    driver.get("https://formy-project.herokuapp.com/autocomplete");

    WebElement autocomplete = driver.findElement(By.id("autocomplete"));
    autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");
    Thread.sleep(1000);

    WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
    autocompleteResult.click();
  }

  private static void scrollToClass(WebDriver driver) throws InterruptedException {

    driver.get("https://formy-project.herokuapp.com/scroll");

    WebElement name = driver.findElement(By.id("name"));
    Actions actions = new Actions(driver);
    Thread.sleep(1000);
    actions.moveToElement(name);
    name.sendKeys("Meaghan Lewis");

    WebElement date = driver.findElement(By.id("date"));
    date.sendKeys("01/01/2020");

    Thread.sleep(1000);
  }

  private static void SwitchToActiveWindow(WebDriver driver) throws InterruptedException {

    driver.get("https://formy-project.herokuapp.com/switch-window");

    WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
    newTabButton.click();

    String originalHandle = driver.getWindowHandle();

    for(String handle1: driver.getWindowHandles()) {
      driver.switchTo().window(handle1);
      Thread.sleep(1000);
    }

    Thread.sleep(1000);
    driver.switchTo().window(originalHandle);
  }

  private static void SwitchToAlert(WebDriver driver) throws InterruptedException {

    driver.get("https://formy-project.herokuapp.com/switch-window");

    WebElement alertButton = driver.findElement(By.id("alert-button"));
    alertButton.click();

    Thread.sleep(1000);
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  private static void ExecuteJS(WebDriver driver) throws InterruptedException {
    driver.get("https://formy-project.herokuapp.com/modal");

    WebElement modalButton = driver.findElement(By.id("modal-button"));
    modalButton.click();

    WebElement closeButton = driver.findElement(By.id("close-button"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    Thread.sleep(1000);
    js.executeScript("arguments[0].click();", closeButton);
  }

  private static void DragAndDrop(WebDriver driver) {

    driver.get("https://formy-project.herokuapp.com/dragdrop");

    WebElement image = driver.findElement(By.id("image"));

    WebElement box = driver.findElement(By.id("box"));

    Actions actions = new Actions(driver);
    actions.dragAndDrop(image,box).build().perform();
  }
  public static void main(String[] args) throws InterruptedException {

    // Set the property for webdriver.chrome.driver to be the location to your local download of chromedriver
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    // Create new instance of ChromeDriver
    WebDriver driver = new ChromeDriver();

//    clickButton(driver);

//    autoComplete(driver);

//    scrollToClass(driver);

//    SwitchToActiveWindow(driver);
//    SwitchToAlert(driver);

//    ExecuteJS(driver);

    DragAndDrop(driver);

    //Close the browser
    driver.quit();
  }
}


