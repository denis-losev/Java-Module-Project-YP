import java.util.List;
import java.util.Scanner;

public class Helper {

    public static String askForCarName(List<Car> cars) {

        Scanner name = new Scanner(System.in);
        System.out.printf("Введите название машины №%d:%n", cars.size() + 1);
        return name.next();
    }

    public static int askForSpeed(List<Car> cars) {

        Scanner inputSpeed = new Scanner(System.in);
        int currentSpeed;

        System.out.printf("Введите скорость машины №%d%n", cars.size() + 1);

        while (!inputSpeed.hasNextInt()) {
            inputSpeed.next();
            System.out.printf("Вы ввели некорректное значение! Допустимая скорость от 1 до 250км/ч%n" +
                    "Пожалуйста введите корректное значение скорости для машины №%d%n", cars.size() + 1);
        }

        currentSpeed = inputSpeed.nextInt();

        if (currentSpeed <= 0 || currentSpeed > 250) {
            System.out.printf("Вы ввели некорректное значение! Допустимая скорость от 1 до 250км/ч%n" +
                    "Пожалуйста введите корректное значение скорости для машины №%d%n", cars.size() + 1);
            askForSpeed(cars);
        }

        return currentSpeed;
    }
}
