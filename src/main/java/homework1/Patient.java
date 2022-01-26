package homework1;

import java.util.Random;

public class Patient {


     private Registry registry;

    private int numberPatient;

    public void goToRegistry(){
        Random random = new Random();
        numberPatient = random.nextInt();
        System.out.printf("Пациет № %d пошел к врачу%n", numberPatient);
        registry.takePatient(this);
    }

    public int getNumberPatient() {
        return numberPatient;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
