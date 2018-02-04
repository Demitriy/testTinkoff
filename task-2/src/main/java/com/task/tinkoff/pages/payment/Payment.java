package com.task.tinkoff.pages.payment;

import com.task.tinkoff.pages.BaseTinkoffPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dima on 04.02.2018.
 */
public class Payment extends BaseTinkoffPage {
    public Payment(WebDriver webDriver) {
        super(webDriver);
    }

    public Payment(WebDriver webDriver, String xpath) {
        super(webDriver, xpath);
    }

    @FindBy(xpath = ".//*[@class='MainPageBlockStyles__container_3vY9h']")
    public ReducedListCategoriesPayment reducedListCategoriesPayment;

    @FindBy(xpath = ".//*[@class='UILayoutSection__section_32gTj']")
    public SelectOfSuppliers selectOfSuppliers;

    @FindBy(xpath = ".//*[@class = 'UiRegions__uiRegions__layout_2wFF-']")
    public SelectRegion selectRegion;

    @FindBy(xpath =  ".//*[@class = 'UIPageFrame__section_yDvRO']")
    public HSCMoscow hscMoscow;
}
