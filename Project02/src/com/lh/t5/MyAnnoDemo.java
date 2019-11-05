package com.lh.t5;

import java.lang.reflect.Method;
/*
* 自定义注解，反射机制创建对象执行方法
* */
//@MyAnnotation(className = "com.lh.t4.Animal",methodName = "eat")
public class MyAnnoDemo {
    public static void main(String[] args) throws Exception {
//        MyAnnotation annotation = MyAnnoDemo.class.getAnnotation(MyAnnotation.class);
//        String className = annotation.className();
//        String methodName = annotation.methodName();
//        Class<?> cls = Class.forName(className);
//        Object obj = cls.getDeclaredConstructor().newInstance();
//        cls.getMethod(methodName).invoke(obj);
        buildAnimal();
        buildDog();
    }

    @MyAnnotation(className = "com.lh.t4.Animal",methodName = "eat")
    public static void buildAnimal() throws Exception{
        MyAnnotation annotation = MyAnnoDemo.class.getMethod("buildAnimal").getAnnotation(MyAnnotation.class);
//        MyAnnotation annotation = Method.class.getAnnotation(MyAnnotation.class);
//        MyAnnotation annotation = MyAnnoDemo.class.getAnnotation(MyAnnotation.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        Class<?> cls = Class.forName(className);
        Object obj = cls.getDeclaredConstructor().newInstance();
        cls.getMethod(methodName).invoke(obj);
    }

    @MyAnnotation(className = "com.lh.t4.Dog",methodName = "sleep")
    public static void buildDog() throws Exception{
        MyAnnotation annotation = MyAnnoDemo.class.getMethod("buildDog").getAnnotation(MyAnnotation.class);
//        MyAnnotation annotation = Method.class.getAnnotation(MyAnnotation.class);
//        MyAnnotation annotation = MyAnnoDemo.class.getAnnotation(MyAnnotation.class);
        String className = annotation.className();
        String methodName = annotation.methodName();
        Class<?> cls = Class.forName(className);
        Object obj = cls.getDeclaredConstructor().newInstance();
        cls.getMethod(methodName).invoke(obj);
    }
}
