package Interceptor;

public class test {
    public static void main(String []args){
        IUser u = new User("");
        IUser proxy = (IUser)MyInvocationHandler.bind(u,MyInterceptor.class);
        proxy.getName();
    }
}
