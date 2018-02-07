package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HSCMoscow extends BaseTinkoffPage {
    public HSCMoscow(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[contains(@class, 'Link__link_3Y7f2')]")
    public WebElement btnBack;

    @FindBy(xpath = "(.//li[@class = 'HeaderMenuItem__item_2v2UK'])[3]")
    public WebElement payment;

    @FindBy(xpath = ".//span[text() = 'Оплатить ЖКУ в Москве']")
    public WebElement payForHSCMoscowButton;

    @FindBy(xpath = "(.//*[@class='ui-input__field'])[1]")
    public WebElement codePayer;

    @FindBy(xpath = "(.//*[@class='ui-input__field'])[2]")
    public WebElement period;

    @FindBy(xpath = ".//*[contains(@class, 'Input__value_2Kx90')]/input")
    public WebElement sumInsurance;

    @FindBy(xpath = ".//*[@class='Input__value_2Kx90']/input")
    public WebElement sumPayment;

    @FindBy(xpath = ".//*[@class = 'ui-form__component']/button")
    public WebElement payForHSCMoscowBigButton;
}
