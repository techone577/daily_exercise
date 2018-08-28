package Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    private Class clazz;

    public MyInvocationHandler(Object t,Class c){
        this.target = t;
        this.clazz = c;
    }

    public static Object bind(Object target,Class clazz){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new MyInvocationHandler(target,clazz));
    }

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
        if(this.clazz==null)
            return method.invoke(target,args);
        Object result=null;
        Interceptor interceptor = (Interceptor) clazz.newInstance();
        if(interceptor.before(proxy,target,method,args)){
            result = method.invoke(target,args);
        }else{
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
