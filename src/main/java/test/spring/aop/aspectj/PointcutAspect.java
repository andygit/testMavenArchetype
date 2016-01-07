package test.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by andy on 2016/1/7.
 */
@Aspect
public class PointcutAspect {
    /**
     注释：
     1.       @Before和@After使用PointcutsDefinition中的方法签名代替Pointcut表达式找到相应的切入点，即通过签名找到PointcutsDefinition中customerLog签名上的Pointcut表达式，表达式指定切入点为CustomerBo类中的所有方法。所以此例中Advice类LoggingAdvice，为CustomerBo中的所有方法都加入了@Before和@After两种类型的两种操作。
     2.       对于PointcutsDefinition来说，主要职责是定义Pointcut，可以在其中第一多个切入点，并且可以用便于记忆的方法签名进行定义。
     3.       单独定义Pointcut的好处是，一是通过使用有意义的方法名，而不是难读的Pointcut表达式，使代码更加直观；二是Pointcut可以实现共享，被多个Advice直接调用。若有多个Advice调用某个Pointcut，而这个Pointcut的表达式在将来有改变时，只需修改一个地方，维护更加方便。
    */
    @Before("test.spring.aop.aspectj.PointcutDefinition.customerLog()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println(this.getClass().getSimpleName()+":"+"logBefore() is running ...");
        System.out.println(this.getClass().getSimpleName()+":"+"hijacked:"+joinPoint.getSignature().getName());
        System.out.println(this.getClass().getSimpleName()+":"+"**********");
    }

    @After("test.spring.aop.aspectj.PointcutDefinition.customerLog()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println(this.getClass().getSimpleName()+":"+"logAfter() is running ...");
        System.out.println(this.getClass().getSimpleName()+":"+"hijacked:"+joinPoint.getSignature().getName());
        System.out.println(this.getClass().getSimpleName()+":"+"**********");
    }
}