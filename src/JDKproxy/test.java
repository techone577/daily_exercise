package JDKproxy;

import java.lang.reflect.Proxy;

public class test {

    public static void main(String []args){
        IUser u = new User();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(u);
        IUser proxy = (IUser) Proxy.newProxyInstance(u.getClass().getClassLoader(),u.getClass().getInterfaces(),invocationHandler);
        System.out.print(proxy.getName("hello"));
    }
}
