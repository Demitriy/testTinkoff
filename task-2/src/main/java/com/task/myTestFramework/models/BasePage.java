package com.task.myTestFramework.models;

import com.task.myTestFramework.factory.MyLocatorFactory;
import com.task.myTestFramework.factory.MyPageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by Dima on 04.02.2018.
 */
public class BasePage {

    protected WebDriver webDriver;
    protected String xpath;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.xpath = "";
        init();
    }

    public BasePage(WebDriver webDriver, String xpath) {
        this.webDriver = webDriver;
        this.xpath = xpath;
        init();
    }

    private void init() {
        PageFactory.initElements((ElementLocatorFactory)(new MyLocatorFactory(webDriver, xpath)), (Object)this);
    }
}
