package com.task.myTest.helpers;

import com.task.myTest.models.Model;
import com.task.myTest.models.Pages;
import org.testng.Assert;

public class Checker {

    private Pages pages;

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public void checkSelectedProviderIsFirst() {
        Assert.assertEquals(Model.serviceName, pages.payment.dropDownList.selectElementByIndex(1));
    }
}
