package homework1;

import java.util.Random;

public class Ticket {
    public Ticket(int number) {
        Random random = new Random();
        System.out.printf("Талон: %d, пациента : %d%n", random.nextInt(), number);
    }
}
