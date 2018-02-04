package com.task.tinkoff.pages.payment;

import com.task.myTestFramework.Utils;
import com.task.myTestFramework.models.BasePage;
import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dima on 04.02.2018.
 */
public class SelectRegion extends BasePage {
    public SelectRegion(WebDriver webDriver) {
        super(webDriver);
    }

    public SelectRegion(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath = "//*[@class = 'Text__text_3WKsv Text__text_size_13_3uytC']")
    public List<WebElement> regions;

    public String getNameSelectedRegion() {
        String xpath1 = "//*[@class = 'Text__text_3WKsv Text__text_size_13_3uytC']";
        String xpath2 = "//*[contains(@class, 'ui-link_active')]//span[@class = 'ui-link__text']";
        Utils.sleepStatic(5);
        return webDriver.findElement(By.xpath(xpath + xpath1 + xpath2)).getText();
    }
}
