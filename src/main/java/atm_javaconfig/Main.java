package atm_javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ATM_javaconfig.class);
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);
        atmSimulator.run();
    }
}
