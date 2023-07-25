import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public void dragAndDrop() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("123")));
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            Thread.sleep(2000);
            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions action = new Actions(driver);
            action.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();
            Thread.sleep(2000);
            action.dragAndDropBy(element1, 200, 200).build().perform();
            Thread.sleep(2000);
            action.dragAndDrop(element1,element2).build().perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }

    }
}
