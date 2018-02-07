package com.task.myTest;

import com.task.myTest.helpers.Checker;
import com.task.myTest.helpers.Executor;
import com.task.myTest.models.Model;
import com.task.myTest.models.Pages;
import com.task.tinkoff.BaseTest;
import org.testng.annotations.Test;

public class tests extends BaseTest {

    private Executor executor;
    private Checker checker;

    @Test
    public void precondition() {
        Pages pages = initPages(Pages.class);
        executor = new Executor();
        executor.setPages(pages);
        checker = new Checker();
        checker.setPages(pages);
        openPageByUrl("https://www.tinkoff.ru/");
    }

    @Test(dependsOnMethods = "precondition")
    public void goToHCSMoscow() {
        executor.goToPayment();
        executor.goToSelectionSupplierOfHSC();
        executor.goToSelectRegion();
        if (executor.isSelectedRegion(Model.regionMoscow)) {
            executor.goToPaymentFromSelectRegion();
            executor.goToSelectionSupplierOfHSC();
        }
        else executor.changeRegion(Model.regionMoscow);
        executor.saveAndGoToFirstService();
        executor.goToPayForSCHMoscow();
    }

    @Test(dependsOnMethods = "goToHCSMoscow")
    public void verifyRequiredFields() {

    }

    @Test(dependsOnMethods = "verifyRequiredFields")
    public void verifySupplierIsFirst() throws InterruptedException {
        executor.goToHSCFromHSCMoscow();
        executor.setHCSMoscowInSearch();

        checker.checkSelectedProviderIsFirst();
    }
}