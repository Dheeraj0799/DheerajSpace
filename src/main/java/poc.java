import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class poc {

    public static void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //login intoapplication
        Thread.sleep(20000);
        driver.findElement(By.xpath("//input[@name= 'username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
//        driver.close();

    }
    public static void logout() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //login intoapplication
        Thread.sleep(15000);
        driver.findElement(By.xpath("//input[@name= 'username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        //navigating to dropdown
        Thread.sleep(4000);
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("/web/index.php/auth/logout"));

    }
    public static void screenshot() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //login intoapplication
        Thread.sleep(15000);
        driver.findElement(By.xpath("//input[@name= 'username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        //navigating to dropdown
        Thread.sleep(4000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenshot.png");
        FileHandler.copy(screenshotFile, destinationFile);

        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
    }

    public static void dropndown()
    {
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
    public static void main(String args[]) throws InterruptedException, IOException {
//        login();
//        logout();
//        screenshot();
        dropndown();
    }
}

