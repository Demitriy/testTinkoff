package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

public class Payment extends BaseTinkoffPage {
    public Payment(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class = 'MainPageBlockStyles__container_3vY9h']")
    public ReducedListCategoriesPayment reducedListCategoriesPayment;
    public static class ReducedListCategoriesPayment extends HtmlElement {
        @FindBy(xpath = ".//*[@class = 'UIPayments__categories_3Ziyk']")
        public Services services;
        public static class Services extends HtmlElement {
            @FindBy(xpath = "./ul/li")
            public List<WebElement> services;
            public void selectServiceByName(String name) {
                for (WebElement service : services) {
                    WebElement element = service.findElement(By.xpath(".//span[2]//span[@data-qa-node = 'WrapTag']"));
                    if (element.getText().equals(name)) {
                        element.click();
                        break;
                    }
                }
            }
        }
    }

}