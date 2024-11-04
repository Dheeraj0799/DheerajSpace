import java.sql.Time;
import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
        Actions builder = new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        builder.dragAndDrop(from, to).perform();
        String textTo = to.getText();
        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: File is dropped to target as expected");
        }else {
            System.out.println("FAIL: File couldn't be dropped to target as expected");
        }
        driver.close();
    }
}