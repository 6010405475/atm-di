package atm_annotation_database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("config_annotation_database.xml");
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);

        atmSimulator.run();
    }
}
