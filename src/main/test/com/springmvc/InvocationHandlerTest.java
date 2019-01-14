package com.springmvc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * create by  geson at 2019/1/9 11:02
 * email: pypiguo@gmail.com
 */
public class InvocationHandlerTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        public void sayHello() {
            System.out.println("Hello!");
        }
    }

    static class DynamicProxyTest implements InvocationHandler {
        Object obj;

        public Object bind(Object originalObj) {
            this.obj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Start invocation");
            method.invoke(obj, args);
            System.out.println("Finish invocation");
            return null;
        }
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxyTest().bind(new Hello());
        hello.sayHello();

    }
}
