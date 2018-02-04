package com.task.myTestFramework.factory;

import com.task.myTestFramework.decorators.MyAnnotationsHandler;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class MyLocatorFactory implements ElementLocatorFactory {
    private final SearchContext searchContext;
    private final String xpath;

    public MyLocatorFactory(SearchContext searchContext, String xpath) {
        this.searchContext = searchContext;
        this.xpath = xpath;
    }

    public ElementLocator createLocator(Field field) {
        return new AjaxElementLocator(this.searchContext, 5, new MyAnnotationsHandler(field, xpath));
    }
}
