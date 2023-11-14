package orangehrmlive;
/*Project-2 - ProjectName : com-orangehrmlive
BaseUrl = https://opensource-demo.orangehrmlive.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Forgot your password?’ link.
7. Print the current url.
8. Navigate back to the login page.
9. Refresh the page.
10. Enter the email to email field.
11. Enter the password to password field.
12. Click on Login Button.
13. Close the browser.
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHRMTest {

    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {      // Setting up multibrowser
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        // Open the url into the browser
        driver.get(baseUrl);
        Thread.sleep(5000);

        //Maximise the browser
        driver.manage().window().maximize();

        // We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get Current Url
        System.out.println("The current Url " + driver.getCurrentUrl());

        // Get Page source
        System.out.println(driver.getPageSource());

        // Get Click on  forgot password link? link.
        WebElement forgotYourPassword = driver.findElement(By.className("orangehrm-login-forgot"));
        forgotYourPassword.click();
        Thread.sleep(5000);

        // Get current url
        driver.getCurrentUrl();

        // Navigate back to Login page
        driver.navigate().back();
        Thread.sleep(5000);

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);

        // Enter the Email to the email field
        WebElement emailId = driver.findElement(By.name("username"));
        emailId.sendKeys("Admin");
        Thread.sleep(5000);

        // Enter the Password in the password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(5000);

        // Click on Login Button.
        WebElement login = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        login.click();
        Thread.sleep(5000);

        // Close the Browser
        driver.quit();
    }
}