package com.task.tinkoff.pages.payment;

import com.task.myTestFramework.Utils;
import com.task.myTestFramework.factory.MyLocatorFactory;
import com.task.myTestFramework.factory.MyPageFactory;
import com.task.myTestFramework.models.BasePage;
import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dima on 04.02.2018.
 */
public class SelectOfSuppliers extends BasePage {
    public SelectOfSuppliers(WebDriver webDriver) {
        super(webDriver);
    }

    public SelectOfSuppliers(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath = "/ul/li[1]")
    public Supplier HCSMoscow;

    public static class Supplier extends BasePage {
        public Supplier(WebDriver webDriver) {
            super(webDriver);
        }

        public Supplier(WebDriver webDriver, String xpath) {
            super(webDriver, xpath);
        }

        public String getName() {

            return webDriver.findElement(By.xpath(xpath + "//span[contains(@class, 'ui-menu__link')]//span")).getText();
        }

        public void click() {
            webDriver.findElement(By.xpath(xpath + "//span[contains(@class, 'ui-menu__link')]//span")).click();
        }
    }
}
