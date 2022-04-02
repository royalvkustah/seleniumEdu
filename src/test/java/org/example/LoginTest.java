package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("password"));
        loginPage.login();
        Assert.assertEquals("Не удаётся войти.", loginPage.getTextMessage());
    }
}
