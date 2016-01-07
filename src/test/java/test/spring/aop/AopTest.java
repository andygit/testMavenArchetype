package test.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.spring.aop.service.CustomerService;

/**
 * Created by andy on 2015/12/23.
 */

public class AopTest {

    @Test
    public void aoptest1() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "Spring-AOP-Advice.xml" });

        CustomerService cust = (CustomerService) appContext.getBean("customerService");

        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");
        try {
            cust.printThrowException();
        } catch (Exception e) {
            System.out.println("exception:"+e.getMessage());
        }

    }

    @Test
    public void aoptest2(){
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "Spring-AOP-Advice.xml" });

        CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy");

        System.out.println("使用Spring AOP 如下");
        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");

        try {
            cust.printThrowException();
        } catch (Exception e) {
            System.out.println("exception:"+e.getMessage());
        }
    }

}