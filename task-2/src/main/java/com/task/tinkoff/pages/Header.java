package com.task.tinkoff.pages;

import com.task.myTestFramework.models.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dima on 04.02.2018.
 */
public class Header extends BasePage {

    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    public Header(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath = "/ul/li[3]")
    public WebElement payment;
}
