package com.task.tinkoff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\DSVETYSHOV\\IdeaProjects\\geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

 /*   @AfterClass
    public void tearDown() {
       webDriver.quit();
       webDriver = null;
    }*/

    public void openPageByUrl(String url) {
        webDriver.get(url);
    }

    public <T> T initPages(Class<T> clazz) {
        return initPages(clazz, webDriver);
    }

    private <T> T initPages(Class<T> clazz, WebDriver webDriver) {
        T pages = null;
        try {
            pages = clazz.newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                Object page;
                Constructor constructor = field.getType().getConstructor(WebDriver.class);
                page = constructor.newInstance(webDriver);
                field.set(pages, page);
            }
        } catch (Exception e) {}
        return pages;
    }
}
