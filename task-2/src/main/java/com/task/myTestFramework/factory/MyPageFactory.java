package com.task.myTestFramework.factory;

import com.task.myTestFramework.models.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MyPageFactory {

    public static void initElements(WebDriver driver, String xpath, Object object) {
        try {
            Field[] fields = object.getClass().getFields();
            for (Field field : fields) {
                Class clazz = field.getType();
                field.setAccessible(true);
                if (isChildBasePage(clazz)) {
                    String tmp = xpath + ((FindBy)field.getAnnotation(FindBy.class)).xpath();
                    Constructor constructor = clazz.getConstructor(WebDriver.class, String.class);
                    Object obj = constructor.newInstance(driver, tmp);
                    field.set(object, obj);
                    initElements(driver, tmp, obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isChildBasePage(Class clazz) {
        while (clazz != null && clazz != Object.class) {
            if (clazz == BasePage.class) return true;
            clazz = clazz.getSuperclass();
        }
        return false;
    }

    public static void initElements(WebDriver driver, Object page, String xpath) {
        initElements((ElementLocatorFactory)(new MyLocatorFactory(driver, xpath)), (Object)page);
    }

    public static void initElements(ElementLocatorFactory factory, Object page) {
        initElements((FieldDecorator)(new DefaultFieldDecorator(factory)), (Object)page);
    }

    public static void initElements(FieldDecorator decorator, Object page) {
        for(Class proxyIn = page.getClass(); proxyIn != Object.class; proxyIn = proxyIn.getSuperclass()) {
            proxyFields(decorator, page, proxyIn);
        }
    }

    private static void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
        Field[] fields = proxyIn.getDeclaredFields();
        Field[] var4 = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = var4[var6];
            if (field.getType().isAssignableFrom(WebElement.class)) {
                Object value = decorator.decorate(page.getClass().getClassLoader(), field);
                if (value != null) {
                    try {
                        field.setAccessible(true);
                        field.set(page, value);
                    } catch (IllegalAccessException var10) {
                        throw new RuntimeException(var10);
                    }
                }
            }
        }

    }
}