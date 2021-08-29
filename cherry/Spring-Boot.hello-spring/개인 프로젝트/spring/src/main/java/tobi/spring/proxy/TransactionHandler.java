package tobi.spring.proxy;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {

    private Object target;
    private PlatformTransactionManager transactionManager;
    //트랜잭션을 적용할 메서드 이름 패턴
    private String pattern;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {

        if(method.getName().startsWith(pattern)) {
            return invokeInTransaction(method, arg);
        } else {
            return method.invoke(target, arg);
        }

    }

    private Object invokeInTransaction(Method method, Object[] args) throws Throwable {
        TransactionStatus status =
                this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            Object object = method.invoke(target, args);
            this.transactionManager.commit(status);
            return object;

        } catch(InvocationTargetException e) {

            this.transactionManager.rollback(status);
            throw e.getTargetException();
        }

    }


}
