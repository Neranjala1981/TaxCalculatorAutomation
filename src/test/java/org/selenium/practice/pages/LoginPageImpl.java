package org.selenium.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.selenium.practice.controller.WebDriverController;

import java.time.Duration;

public class LoginPageImpl implements LoginPage{
    WebDriver driver;
    Wait<WebDriver> wait;
public LoginPageImpl(WebDriverController driver){
    this.driver=driver.getDriver();
    wait = new FluentWait<>(this.driver) .withTimeout(Duration.ofSeconds(10)) .pollingEvery(Duration.ofSeconds(2)) .ignoring(NoSuchElementException.class);
}
    @Override
    public void login(String username, String password) {
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("btn-success")).click();
    }

    @Override
    public String readErrorMessage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("label-warning")));

        String error=element.getText();
        return error;
    }
}
