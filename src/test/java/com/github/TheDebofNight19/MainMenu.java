package com.github.TheDebofNight19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {

    private final WebDriver webDriver;

    public MainMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private static final String URL = "https://idemo.bspb.ru/welcome";
    private static final String TEXT = "Финансовая свобода";

    @FindBy(xpath = "//a[@id=\"bank-overview\"]")
    private WebElement overview;

    @FindBy(xpath = "//div[@id=\"header-container\"]//span[@class=\"amount\"]")
    private WebElement amount;


    @FindBy(xpath = "//div[@id = \"header-container\"]//span[@class = \"text\"]")
    private WebElement text;

    @FindBy(xpath = "//div[@id=\"header-container\"]//small[@class=\"my-assets\"]")
    private WebElement myBalance;



    public MainMenu assertMainMenuPage(){
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, URL);
        return this;
    }

    public MainMenu interactWithMainMenu(){
        overview.click();
        return this;
    }

    public MainMenu compareText() throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(text.getText(), TEXT);
        Pattern pat = Pattern.compile("[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(amount.getText());
        Assert.assertTrue(mat.matches());
        return this;
    }

    public MainMenu checkMyBalanceElement(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(myBalance).build().perform();
        String s = myBalance.getText();
        Pattern pat = Pattern.compile("Моих\\sсредств\\s[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(s);
        Assert.assertTrue(mat.matches());
        return this;
    }




}
