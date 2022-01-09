package com.test.other;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 董佳俊
 * @version 1.0
 * @date 2021/12/17 19:20
 */
class FatherType{
    public FatherType(){
        System.out.println("father");
    }
    private void show(){
        System.out.println("father's function show.");
    }
    public void display(){
        show();
    }
}

class SonType extends FatherType{
    public SonType(){
        System.out.println("son");
    }
}
public class ExtendsTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class clazz = SonType.class;

        Constructor[] constructors = clazz.getConstructors();
        Method[] methods = clazz.getMethods();

        for(Method method:methods)
            System.out.println(method);
        for(Constructor constructor:constructors)
            System.out.println(constructor);

        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("display");
        method.invoke(obj);


    }
}
