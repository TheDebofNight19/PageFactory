package com.github.TheDebofNight19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBSPB {

    private WebDriver webDriver;


    @BeforeTest
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
        oneTimePassword.assertOneTimePasswordPage();
        oneTimePassword.insertOneTimePassword();
        mainMenu.assertMainMenuPage();
        mainMenu.interactWithMainMenu();
        mainMenu.compareText();
        mainMenu.checkMyBalanceElement();
    }

    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }
}
