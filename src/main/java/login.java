import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class login {

    public static void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //login intoapplication
        Thread.sleep(20000);
        driver.findElement(By.xpath("//input[@name= 'username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        driver.close();

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
//        List<WebElement> dropdowns = driver.findElements(By.className("oxd-userdropdown-name"));
//        Select select = new Select(dropdowns.get(3)); // Index 1 for the second dropdown
//        select.selectByVisibleText("logout");
//        driver.findElement(By.xpath("//a[@class= 'oxd-userdropdown-link']")).click();
//        WebElement contactLink = driver.findElement(By.partialLinkText("logout"));
//        contactLink.click();
//        Select select = new Select((WebElement) By.xpath("//a[@class= 'oxd-userdropdown-link']"));
//        select.selectByVisibleText("logout");
    }

    public static void main(String args[]) throws InterruptedException {
//        login();
        logout();
    }
}

