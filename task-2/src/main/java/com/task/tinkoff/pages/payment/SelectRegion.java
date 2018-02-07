package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class SelectRegion extends BaseTinkoffPage {
    public SelectRegion(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//span[@class = 'HeaderMenuItem__itemContainer_3Qu__' and text() = 'Платежи']")
    public WebElement payment;

    @FindBy(xpath = ".//*[@class= 'UiRegions__uiRegions__layout_2wFF-']")
    public Regions regions;
    public static class Regions extends HtmlElement {
        @FindBy(xpath = ".//*[@class = 'UiRegions__uiRegions__item_3ZlOB']")
        public List<WebElement> regions;

        public void selectRegionByName(String name) {
            String xpath = ".//*[@data-qa-node = 'WrapTag']";
            regions.stream().filter((a) -> a.findElement(By.xpath(xpath)).equals(name)).findFirst().get().click();
        }

        public boolean isSelected(String name) {
            String xpath = ".//*[contains(@class, 'ui-link_active')]//*[@data-qa-node = 'WrapTag']";
            return getWrappedElement().findElement(By.xpath(xpath)).getText().equals(name);
        }
    }
}
