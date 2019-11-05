package com.lh.t4;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
/*
* 反射Demo
* 通过反射创建对象，运行方法
* */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties p = new Properties();
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("prop.properties");
        p.load(is);
        //读取配置文件中的类全名和方法名
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");
        //获取字节码文件
        Class cls = Class.forName(className);
        //使用字节码文件创建对象
//        Object obj = cls.newInstance();//newInstance过时
        Object obj = cls.getDeclaredConstructor().newInstance();
        //调用方法
        Method method = cls.getMethod(methodName);
        method.invoke(obj);


    }
}
