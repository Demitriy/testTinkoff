package com.task;

import com.task.tinkoff.pages.BaseTinkoffPage;
import com.task.tinkoff.pages.payment.Payment;
import com.task.tinkoff.pages.payment.SelectOfSuppliers;
import com.task.tinkoff.pages.payment.SelectRegion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Dima on 03.02.2018.
 */
public class Main{


    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Folder For Study\\IdeaProjects\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.tinkoff.ru/");
/*        BaseTinkoffPage baseTinkoffPage = new BaseTinkoffPage(webDriver, "");
        MyPageFactory.initElements(webDriver, "", payment);*/
        //BaseTinkoffPage baseTinkoffPage = new BaseTinkoffPage(webDriver);
        Payment payment = new Payment(webDriver);
        SelectOfSuppliers selectOfSuppliers = new SelectOfSuppliers(webDriver);
        SelectRegion selectRegion = new SelectRegion(webDriver);
        payment.header.selectTabByName("ПЛАТЕЖИ");
        payment.reducedListCategoriesPayment.services.selectServiceByName("ЖКХ");
        //selectOfSuppliers.region.click();
        //System.out.println(selectRegion.regions.isSelected("г. Москва"));
        System.out.println(selectOfSuppliers.services.getNameByIndex(1));
        selectOfSuppliers.services.selectByIndex(1);
        //System.out.println(payment.selectRegion.getNameSelectedRegion());
/*        System.out.println(payment.selectOfSuppliers.HCSMoscow.getName());
        payment.selectOfSuppliers.HCSMoscow.click();
        payment.hscMoscow.payForHSCMoscow.click();*/
    }
}

