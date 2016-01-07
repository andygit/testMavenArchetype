package test.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.spring.aop.aspectj.ICustomerService;

/**
 * Created by andy on 2015/12/28.
 */
public class AspectjTest {
    @Test
    public void aspectjTest(){
            ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"Spring-AOP-AspectJ.xml" });
            ICustomerService customer=(ICustomerService)appContext.getBean("customerService");

        System.out.println("-------------------------------------------");
        customer.addCustomer();
        System.out.println("-------------------------------------------");
        customer.deleteCustomer();
        System.out.println("-------------------------------------------");

    }
}
