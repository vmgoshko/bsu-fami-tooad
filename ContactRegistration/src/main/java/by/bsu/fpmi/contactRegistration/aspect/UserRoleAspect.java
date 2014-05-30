package by.bsu.fpmi.contactRegistration.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Map;

@Aspect
public class UserRoleAspect {

    @Before("@annotation(by.bsu.fpmi.contactRegistration.aspect.SecurityRole)")
    public void beforeAdvice(JoinPoint joinPoint) throws Throwable{
        Map<String, Object> model = (Map<String, Object>) joinPoint.getArgs()[0];
        if (!model.get("role").equals("admin")) {
            throw new NullPointerException();
        }
    }
}
