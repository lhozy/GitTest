package com.lh.t3;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("p.properties");
        pro.load(is);
        String className = pro.getProperty("className");
        String methonName = pro.getProperty("methodName");
        Class aClass = aClass = Class.forName(className);
        Object obj = aClass.getDeclaredConstructor().newInstance();
//        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methonName);
        method.invoke(obj);
    }
}
