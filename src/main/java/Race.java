import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {

    private final List<Car> cars;

    private Map<Car, Integer> carsAndDistance;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    private void getCarsDistance() {

        carsAndDistance = cars.stream()
                .collect(Collectors.toMap(
                        car -> car, car -> car.getSpeed() * 24));
    }

    public void calculateRaceWinner() {

        getCarsDistance();
        carsAndDistance = carsAndDistance.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        boolean isSpeedEquals = carsAndDistance.values().stream().distinct().count() == 1;

        if (isSpeedEquals) {
            System.out.printf("Все участники имеют одинаковые показатели, победителя нет!%n");
        } else {
            Map.Entry<Car, Integer> entry = carsAndDistance.entrySet().iterator().next();

            Car winner = entry.getKey();
            int winnersDistance = entry.getValue();

            System.out.printf("Самый быстрый автомобиль - %s%n" +
                            "Его скорость составляет %dкм/ч и за 24 часа он проедет %dкм%n",
                    winner.getName(),
                    winner.getSpeed(),
                    winnersDistance);
        }
    }
}
