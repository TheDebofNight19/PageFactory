package com.github.TheDebofNight19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestBSPB {

    private WebDriver webDriver;



    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }


    @Test
    public void testLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(webDriver);
        OneTimePassword oneTimePassword = new OneTimePassword(webDriver);
        MainMenu mainMenu = new MainMenu(webDriver);

        loginPage.login();
        oneTimePassword.assertOneTimePasswordPage()
                        .insertOneTimePassword();
        mainMenu.assertMainMenuPage()
                .interactWithMainMenu()
                .compareText()
                .checkMyBalanceElement();
    }

    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }
}
