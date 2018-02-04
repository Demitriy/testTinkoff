package com.task.myTestFramework.decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

public class MyAnnotationsHandler extends Annotations {
    private final String xpath;

    public MyAnnotationsHandler(Field field, String xpath) {
        super(field);
        this.xpath = xpath;
    }

    public By buildBy() {
        return By.xpath(xpath + ((FindBy)getField().getAnnotation(FindBy.class)).xpath());
    }
}
