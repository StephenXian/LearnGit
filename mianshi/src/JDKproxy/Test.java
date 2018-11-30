package JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
       AService aService = new AServiceImpl();
       MyIvocationHandler myIvocationHandler = new MyIvocationHandler(aService);
       Proxy.newProxyInstance(aService.getClass().getClassLoader(), aService.getClass().getInterfaces(), myIvocationHandler/*new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               return null;
           }
       }*/);

    }
}
