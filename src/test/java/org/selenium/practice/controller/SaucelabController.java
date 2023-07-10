package org.selenium.practice.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SaucelabController implements WebDriverController{
    private WebDriver driver;
    public SaucelabController(){
        setupController();
    }
    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {

    }

    @Override
    public void setupController() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-neranji.dil-5cb50");
        sauceOptions.put("accessKey", "c1fdb7cf-f3f9-4001-8b4d-bc014643b3da");
        sauceOptions.put("build", "selenium-build-4FY6N");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = null;
        try {
            url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new RemoteWebDriver(url, browserOptions);

    }
}
