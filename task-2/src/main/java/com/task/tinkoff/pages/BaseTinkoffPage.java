package com.task.tinkoff.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by Dima on 04.02.2018.
 */
public class BaseTinkoffPage extends BasePage {

    public BaseTinkoffPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[contains(@class,'ui-product-block-header-menu__menuContainer_No9bB')]")
    public Header header;
    public static class Header extends HtmlElement {

        @FindBy(xpath = "./ul/li")
        public List<WebElement> tabs;

        public void selectTabByName(String name) {
            for (WebElement tab : tabs) {
                WebElement element = tab.findElement(By.xpath(".//span[@data-qa-node = 'SeoTagName']"));
                if (element.getText().equals(name)) {
                    element.click();
                    break;
                }
            }
        }
    }
}
