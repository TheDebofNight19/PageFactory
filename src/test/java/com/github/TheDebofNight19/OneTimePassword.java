package com.github.TheDebofNight19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OneTimePassword {

    private final WebDriver webDriver;

    private final String OTP = "0000";
    private final String URL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    @FindBy(id = "otp-code")
    private WebElement oneTimePasswordField;

    @FindBy(id = "login-otp-button")
    private WebElement enterButton;

    public OneTimePassword(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void assertOneTimePasswordPage(){
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, URL);
    }

    public void insertOneTimePassword(){
        oneTimePasswordField.clear();
        oneTimePasswordField.sendKeys(OTP);
        enterButton.click();
    }

}
