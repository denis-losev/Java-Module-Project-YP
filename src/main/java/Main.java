import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Car> carsArray = new ArrayList<>();

        while (carsArray.size() < 3) {
            String name = Helper.askForCarName(carsArray);
            int speed = Helper.askForSpeed(carsArray);
            carsArray.add(new Car(name, speed));
        }

        System.out.println("Результат:");

        new Race(carsArray).calculateRaceWinner();
    }
}