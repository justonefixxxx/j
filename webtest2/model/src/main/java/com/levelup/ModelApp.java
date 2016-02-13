package com.levelup;

import com.levelup.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class ModelApp
{
    public static void main( String[] args )
    {
       ModelApp m = new ModelApp();
        m.test();
    }


    public void test(){
        try {
            Class aClass = Class.forName("com.levelup.model.User");
            Constructor[] contsructors = aClass.getConstructors();
            Field[] fields = aClass.getDeclaredFields();
            Method[] methods = aClass.getDeclaredMethods();

            Field idField = aClass.getDeclaredField("id");
            Annotation[] annotations = idField.getDeclaredAnnotations();
            User obj = (User) aClass.newInstance();
            obj.setId(1L);
            obj.setName("Name1");
            obj.setRole("Role1");
            for (Field f: fields){
                String name = f.getName();
                name = name.replace(name.charAt(0),Character.toUpperCase(name.charAt(0)));
                String methodName = "get"+name;
                Method m = aClass.getDeclaredMethod(methodName,null);

                System.out.println(m.invoke(obj,null));
            }
            annotations.toString();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchFieldException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}


