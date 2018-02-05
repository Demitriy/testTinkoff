package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

public class SelectOfSuppliers extends BaseTinkoffPage {
    public SelectOfSuppliers(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class = 'PaymentsCatalogHeader__regionSelect_3MRVi']")
    public Region region;
    public static class Region extends HtmlElement {
        public void click() {
            this.getWrappedElement().click();
        }
    }

    @FindBy(xpath = ".//*[@class = 'UILayoutSection__section_32gTj']")
    public Services services;
    public static class Services extends HtmlElement {
        @FindBy(xpath = ".//ul/li")
        public List<WebElement> services;

        public void selectByIndex(int index) {
            services.get(index - 1).click();
        }

        public String getNameByIndex(int index) {
            return services.get(index - 1).findElement(By.xpath(".//span[2]//*[@data-qa-node = 'WrapTag']")).getText();
        }
    }
}
