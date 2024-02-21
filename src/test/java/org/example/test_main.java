package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test_main {
    public static void main(String[] args) throws MalformedURLException {

        WebDriver driver;
        String baseUrl , nodeUrl;
        baseUrl = "https://www.facebook.com";
        nodeUrl = "http://localhost:8083/wd/hub/";

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new RemoteWebDriver(new URL(nodeUrl),capability);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.get(baseUrl);
    }
}
