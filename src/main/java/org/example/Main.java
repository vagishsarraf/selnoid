package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
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