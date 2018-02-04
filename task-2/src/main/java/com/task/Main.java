package com.task;

import com.task.myTestFramework.factory.MyPageFactory;
import com.task.tinkoff.pages.BaseTinkoffPage;
import com.task.tinkoff.pages.payment.Payment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.02.2018.
 */
public class Main{


    public static void main(String[] args) throws NoSuchFieldException {
        System.setProperty("webdriver.gecko.driver", "D:\\Folder For Study\\IdeaProjects\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.tinkoff.ru/");
/*        BaseTinkoffPage baseTinkoffPage = new BaseTinkoffPage(webDriver, "");
        MyPageFactory.initElements(webDriver, "", payment);*/
        Payment payment = new Payment(webDriver, "");
        MyPageFactory.initElements(webDriver, "", payment);
        payment.header.payment.click();
        payment.reducedListCategoriesPayment.communalPayments.click();
        payment.reducedListCategoriesPayment.openAllRegion.click();
        //System.out.println(payment.selectRegion.getNameSelectedRegion());
/*        System.out.println(payment.selectOfSuppliers.HCSMoscow.getName());
        payment.selectOfSuppliers.HCSMoscow.click();
        payment.hscMoscow.payForHSCMoscow.click();*/
    }
}

