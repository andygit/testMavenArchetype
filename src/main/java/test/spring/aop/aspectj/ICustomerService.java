package test.spring.aop.aspectj;

/**
 * Created by andy on 2015/12/28.
 */
public interface ICustomerService {
    void addCustomer();
    void deleteCustomer();
    String AddCustomerReturnValue();
    void addCustomerThrowException() throws Exception;
    void addCustomerAround(String name);

}