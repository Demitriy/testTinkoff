package com.task.myTest.helpers;

import com.task.myTest.models.Model;
import com.task.myTest.models.Pages;

public class Executor {

    private Pages pages;

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public void goToPayment() {
        pages.payment.header.selectTabByName("ПЛАТЕЖИ");
    }

    public void goToHSCFromHSCMoscow() {
        pages.hscMoscow.payment.click();
    }

    public void goToPaymentFromSelectRegion() {
        pages.selectRegion.payment.click();
    }

    public void goToSelectionSupplierOfHSC() {
        pages.payment.reducedListCategoriesPayment.services.selectServiceByName("ЖКХ");
    }

    public void goToSelectRegion() {
        pages.selectOfSuppliers.region.click();
    }

    public void changeRegion(String region) {
        pages.selectRegion.regions.selectRegionByName(region);
    }

    public boolean isSelectedRegion(String region) {
        return pages.selectRegion.regions.isSelected(region);
    }

    public void saveAndGoToFirstService() {
        Model.serviceName = pages.selectOfSuppliers.services.getNameByIndex(1);
        pages.selectOfSuppliers.services.selectByIndex(1);
    }

    public void goToPayForSCHMoscow() {
        pages.hscMoscow.payForHSCMoscowButton.click();
    }

    public void setHCSMoscowInSearch() {
        pages.payment.search.sendKeys(Model.serviceName);
    }
}