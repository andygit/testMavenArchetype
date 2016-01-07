package test.spring.aop.aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by andy on 2015/12/28.
 */

@Aspect
public class CustomerAspect {

    @Before("execution(public * test.spring.aop.aspectj.CustomerService.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(this.getClass().getSimpleName()+":"+"logBefore() is running ...");
        System.out.println(this.getClass().getSimpleName()+":"+"hijacked:"+joinPoint.getSignature().getName());
        System.out.println(this.getClass().getSimpleName()+":"+"**********");
    }

    @After("execution(public * test.spring.aop.aspectj.CustomerService.deleteCustomer(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println(this.getClass().getSimpleName()+":"+"logAfter() is running ...");
        System.out.println(this.getClass().getSimpleName()+":"+"hijacked:"+joinPoint.getSignature().getName());
        System.out.println(this.getClass().getSimpleName()+":"+"**********");
    }
}