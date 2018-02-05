package com.task.tinkoff.pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        init(webDriver);
    }

    private void init(WebDriver webDriver) {
        HtmlElementLoader.populatePageObject(this, webDriver);
    }
}
