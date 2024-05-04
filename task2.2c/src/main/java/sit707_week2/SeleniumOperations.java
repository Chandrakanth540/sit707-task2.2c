package sit707_week2;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\VE\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();    	
        driver.get(url);
        WebElement firstNameInput = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("lastname")));
        WebElement lastNameInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("firstname")));
        WebElement phoneNumberInput = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("email")));
        WebElement emailInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("phoneNumber")));
        WebElement passwordInput = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("confirmPassword")));
        WebElement confirmPasswordInput = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("password")));
        WebElement createButton = driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(By.id("confirmPassword")));

        firstNameInput.sendKeys("chandrakanth");
        lastNameInput.sendKeys("Kunapareddy");
        phoneNumberInput.sendKeys("0123456789");
        emailInput.sendKeys("chandra98au@gmail.com");
        passwordInput.sendKeys("Chandra#89");
        confirmPasswordInput.sendKeys("Chandra#89");
        createButton.click();

       
       sleep(8);



        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), new File("screenshot1.png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sleep(2);

        driver.quit();
    }

}
