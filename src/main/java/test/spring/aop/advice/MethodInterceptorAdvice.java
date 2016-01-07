package test.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * Created by andy on 2015/12/24.
 */
public class MethodInterceptorAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MethodInterceptorAdvice:Method name : " + methodInvocation.getMethod().getName());
        System.out.println("MethodInterceptorAdvice:Method arguments : " + Arrays.toString(methodInvocation.getArguments()));

        // 相当于  MethodBeforeAdvice
        System.out.println("MethodInterceptorAdvice: Before method hijacked!");

        try {
            // 调用原方法，即调用CustomerService中的方法
            Object result = methodInvocation.proceed();

            // 相当于 AfterReturningAdvice
            System.out.println("MethodInterceptorAdvice: After method hijacked!");

            return result;

        } catch (IllegalArgumentException e) {
            // 相当于 ThrowsAdvice
            System.out.println("MethodInterceptorAdvice: Throw exception hijacked!");
            throw e;
        }
    }
}
