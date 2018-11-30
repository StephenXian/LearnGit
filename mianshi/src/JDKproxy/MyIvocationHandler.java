package JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIvocationHandler implements InvocationHandler {
    //这里只是作为一个演示用的是Object,其实在真正运用的时候用的是被代理的那个对象
    //private AService AServiceImpl;
    private Object target;

    MyIvocationHandler(){
        super();
    }
    public MyIvocationHandler(Object target) {
        super();
        this.target = target;
    }

    //当我们利用代理对象来调用一个方法的时候,用的是invoke方法,下面这个
    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        Object invokeMethodObject = method.invoke(target, method, args);
        System.out.println("后置增强");
        return invokeMethodObject;
    }
}
