package homework1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Patient patient1 = context.getBean("newPatient", Patient.class);
        patient1.goToRegistry();
        Patient patient2 = context.getBean("newPatient", Patient.class);
        patient2.goToRegistry();
    }
}
