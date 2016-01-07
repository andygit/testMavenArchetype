package test.spring.aop.aspectj;

/**
 * Created by andy on 2015/12/28.
 */
public class CustomerService implements ICustomerService {

    public void addCustomer() {
        System.out.println(this.getClass().getSimpleName()+":"+"addCustomer() is running ...");
    }

    public void deleteCustomer() {
        System.out.println(this.getClass().getSimpleName()+":"+"deleteCustomer() is running ...");
    }

    public String AddCustomerReturnValue() {
        System.out.println(this.getClass().getSimpleName()+":"+"AddCustomerReturnValue() is running ...");
        return "abc";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println(this.getClass().getSimpleName()+":"+"addCustomerThrowException() is running ...");
        throw new Exception(this.getClass().getSimpleName()+":"+"Generic Error");
    }

    public void addCustomerAround(String name) {
        System.out.println(this.getClass().getSimpleName()+":"+"addCustomerAround() is running ,args:"+name);

    }

}