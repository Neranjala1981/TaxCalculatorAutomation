package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // setup web driver
        WebDriverManager.chromedriver().setup(); // ( web driver = web site)
        // open web driver
        WebDriver driver = new ChromeDriver();
        // maximize window
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Wait<WebDriver> wait = new FluentWait<>(driver) .withTimeout(Duration.ofSeconds(10)) .pollingEvery(Duration.ofSeconds(2)) .ignoring(NoSuchElementException.class);
        // navigate to amazon.com
        driver.get("https://buggy.justtestit.org");
        driver.findElement(By.name("login")).sendKeys("neranji123");
        driver.findElement(By.name("password")).sendKeys("neranji123");
        driver.findElement(By.className("btn-success")).click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("label-warning")));

        String error=element.getText();
        System.out.println(error);
        //Close driver
        driver.quit();

    }
}