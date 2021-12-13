package homework1;

import java.util.Random;

public class Route {
    public Route(int numberPatient) {
        Random random = new Random();
        System.out.printf("Пациент № %d должен пойти к доктору в кабинет № %d%n",numberPatient, random.nextInt());
    }
}
