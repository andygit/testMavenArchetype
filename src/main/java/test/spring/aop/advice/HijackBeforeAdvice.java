package test.spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by andy on 2015/12/24.
 */
public class HijackBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("HijackBeforeAdvice : Before method hijacked! methodName:" + method.getName());

    }

}