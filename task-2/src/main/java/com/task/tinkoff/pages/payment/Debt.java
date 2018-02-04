package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dima on 05.02.2018.
 */
public class Debt extends BaseTinkoffPage {
    public Debt(WebDriver webDriver) {
        super(webDriver);
    }

    public Debt(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath =  ".//*[@class = 'UIPageFrame__section_yDvRO']")
    public HSCMoscow hscMoscow;
}
