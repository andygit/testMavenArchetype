package test.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by andy on 2016/1/7.
 */
@Aspect
public class PointcutDefinition {

    /**解释：

     1. 类声明前加入@Aspect注释，以便被框架扫描到。
     2. @Pointcut是切入点声明，指定需要注入的代码的位置，如上例中指定切入点为CustomerBo类中的所有方法，在实际业务中往往是指定切入点到一个逻辑层，例如 execution (* com.lei.business.service.*.*(..)），表示aop切入点为service包中所有类的所有方法，具体的表达式后边会有介绍。
     3. 方法customerLog是一个签名，在Advice中可以用此签名代替切入点表达式，所以不需要在方法体内编写实际代码，只起到助记功能，例如此处代表操作CustomerBo类时需要的切入点。
    */
    @Pointcut("execution(* test.spring.aop.aspectj.CustomerService.*(..))")
    public void customerLog() {
    }

    /**
     三、     切入点表达式

     Spring3.0.5帮助文档中的切入点表达式如下：



     Some examples of common pointcut expressions are given below.



     the execution of any public method:

     execution(public * *(..))


     the execution of any method with a name beginning with "set":

     execution(* set*(..))


     the execution of any method defined by the AccountService interface:

     execution(* com.xyz.service.AccountService.*(..))


     the execution of any method defined in the service package:

     execution(* com.xyz.service.*.*(..))


     the execution of any method defined in the service package or a sub-package:

     execution(* com.xyz.service..*.*(..))


     any join point (method execution only in Spring AOP) within the service package:

     within(com.xyz.service.*)


     any join point (method execution only in Spring AOP) within the service package or a sub-package:

     within(com.xyz.service..*)


     any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:

     this(com.xyz.service.AccountService)

     'this' is more commonly used in a binding form :- see the following section on advice for how to make the proxy object available in the advice body.



     any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:

     target(com.xyz.service.AccountService)

     'target' is more commonly used in a binding form :- see the following section on advice for how to make the target object available in the advice body.



     any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:

     args(java.io.Serializable)
     'args' is more commonly used in a binding form :- see the following section on advice for how to make the method arguments available in the advice body.

     Note that the pointcut given in this example is different to execution(* *(java.io.Serializable)): the args version matches if the argument passed at runtime is Serializable, the execution version matches if the method signature declares a single parameter of type Serializable.



     any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:

     @target(org.springframework.transaction.annotation.Transactional)

     '@target' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.



     any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:

     @within(org.springframework.transaction.annotation.Transactional)

     '@within' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.



     any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:

     @annotation(org.springframework.transaction.annotation.Transactional)

     '@annotation' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.



     any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the@Classified annotation:

     @args(com.xyz.security.Classified)

     '@args' can also be used in a binding form :- see the following section on advice for how to make the annotation object(s) available in the advice body.



     any join point (method execution only in Spring AOP) on a Spring bean named 'tradeService':

     bean(tradeService)


     any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression '*Service':

     bean(*Service)
     */
}