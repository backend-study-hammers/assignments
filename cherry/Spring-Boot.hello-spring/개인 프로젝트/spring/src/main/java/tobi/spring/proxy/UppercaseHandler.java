package tobi.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {

    Object target;

    public UppercaseHandler(Object target) {
        // TODO Auto-generated constructor stub
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        Object object = method.invoke(target, args);

        if(object instanceof String) {
            return ((String) object).toUpperCase();
        }
        return object;
    }

}
