package test.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by andy on 2015/12/24.
 */
public class HijackThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.println("HijackThrowsAdvice: throw exception hijacked! "+e.getMessage());
    }
}
