package com.github.TheDebofNight19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private final WebDriver webDriver;

    /**
     * объявляем необходимиые для работы со страницей переменные и константы
     */

    private final static String URL = "https://idemo.bspb.ru";
    private final static String LOGIN = "demo";
    private final static String PASSWORD = "demo";

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void login(){

        webDriver.get(URL);
        loginField.clear();
        loginField.sendKeys(LOGIN);
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        enterButton.click();
    }

}
