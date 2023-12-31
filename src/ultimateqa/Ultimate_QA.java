package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Ultimate_QA {
    //multi browser
    static String browser = "Chrome";
    //static  String browser = "Firefox";
    //static String browser = "Edge";

    static String baseUrl = "https://courses.ultimateqa.com/";
    //launch the browser
    static WebDriver driver;

    public void ultimateQATest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
    }

    public static void main(String[] args) {
        // creating an object for ultimateQATest
        Ultimate_QA obj = new Ultimate_QA();
        obj.ultimateQATest();

        //open the URl into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Print the title of the page: " + driver.getTitle());

        //Print the current URL
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //print the page source
        System.out.println("Print the page source: " + driver.getPageSource());

        //Click on ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //Print the current url
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc123@gmail.com");

        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("abc123");

        //Click on login button
        WebElement login = driver.findElement(By.xpath("(//button [@type='submit'])"));
        //WebElement login = driver.findElement(By.partialLinkText("Sign"));
        login.click();

        //Navigate to the base URL
        driver.navigate().to(baseUrl);
        System.out.println("Navigate to the baseUrl: " + driver.getCurrentUrl());

        //Navigate forward to Homepage.
        driver.navigate().forward();
        System.out.println("Forward to homepage: " + driver.getCurrentUrl());

        //Navigate back to baseUrl.
        driver.navigate().back();
        System.out.println("Back to the baseUrl: " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page: " + driver.getCurrentUrl());

        //Close the browser
        driver.quit();
    }
}
