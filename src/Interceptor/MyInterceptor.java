package Interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before (Object proxy, Object target, Method method, Object[] args) {
        System.out.print("before");
        if (checkProperties(target))
            return true;
        return false;
    }

    @Override
    public void around (Object proxy, Object target, Method method, Object[] args) {
        System.out.println("around");
    }

    @Override
    public void after (Object proxy, Object target, Method method, Object[] args) {
        System.out.println("After");
    }

    private boolean checkProperties (Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(object).equals(""))
                    return false;
            }
        } catch (Exception e) {

        }
        return true;
    }
}
