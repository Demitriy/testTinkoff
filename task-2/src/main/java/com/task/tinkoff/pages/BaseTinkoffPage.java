package com.task.tinkoff.pages;

import com.google.gson.annotations.Expose;
import com.task.myTestFramework.models.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dima on 04.02.2018.
 */
public class BaseTinkoffPage extends BasePage {

    public BaseTinkoffPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BaseTinkoffPage(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath = ".//*[contains(@class,'ui-product-block-header-menu__menuContainer_No9bB')]")
    public Header header;
}
