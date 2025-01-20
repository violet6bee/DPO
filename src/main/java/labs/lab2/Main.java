package labs.lab2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "Guzel", "Urazova", 43, "Russia"));
        users.add(new User(2, "Adriano", "Celentano", 87, "Italia"));
        users.add(new User(3, "Misha", "Collins", 50, "USA"));
        users.add(new User(5, "Rustem", "Minnikhanov", 67, "Russia"));

        System.out.println("Сортировка пользователей по фамилии:");
        lastName(users);
        System.out.println();
        System.out.println("Сортировка пользователей по возрасту:");
        age(users);
        System.out.println();
        System.out.println("Все пользователи старше 7 лет?");
        System.out.println(sevenAge(users));
        System.out.println();
        System.out.println("Средний возраст пользователей: " );
        System.out.println(avgAge(users));
        System.out.println();
        System.out.println("Количество разных стран проживания: " );
        System.out.println(variantsOfCountry(users));
    }

    public static void lastName(ArrayList<User> users){
        users.stream().sorted(Comparator.comparing(User::getLastName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void age(ArrayList<User> users){
        users.stream().sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static boolean sevenAge(ArrayList<User> users) {
        return users.stream().allMatch(user -> user.getAge() >= 7);
    }

    public static int avgAge(ArrayList<User> users){
        OptionalDouble average = users.stream().mapToInt(User::getAge).average();
        return average.isPresent() ? (int) average.getAsDouble() : 0;
    }

    public static int variantsOfCountry(ArrayList<User> users) {
        return (int) users.stream().map(User::getCountry).distinct().count();
    }
}
