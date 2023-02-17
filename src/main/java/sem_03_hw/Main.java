package sem_03_hw;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = new MyLinkedList<>();

        System.out.println("Добавляем в конец по очереди числа...");
        numbers.add(4);
        numbers.add(8);
        numbers.add(35);
        System.out.println("Список: " + numbers + ". Длина: " + numbers.size());

        System.out.println("---");
        System.out.println("Добавляем по очереди с указанием индекса...");
        numbers.add(1, 11);
        numbers.add(0, 99);
        numbers.add(10, 88);
        System.out.println("Список: " + numbers + ". Длина: " + numbers.size());

        System.out.println("---");
        System.out.println("Добавляем несколько элементов сразу в конец...");
        numbers.addAll(List.of(200, 300));
        System.out.println("Список: " + numbers + ". Длина: " + numbers.size());

        System.out.println("---");
        System.out.println("Добавляем несколько элементов сразу с указанием индекса...");
        numbers.addAll(2, List.of(600, 400));
        System.out.println("Список: " + numbers + ". Длина: " + numbers.size());

        System.out.println("---");
        System.out.println("Элемент по индексу 3: " + numbers.get(3));
        System.out.println("Индекс элемента 88: " + numbers.indexOf(88));
        System.out.println("Индекс элемента 2342: " + numbers.indexOf(2342));

        System.out.println("---");
        System.out.println("Содержит ли список число 600: " + numbers.contains(600));
        System.out.println("Содержит ли список число 1: " + numbers.contains(1));
        System.out.println("Содержит ли список числа 600, 11 и 300: " + numbers.containsAll(List.of(600, 11, 300)));
        System.out.println("Содержит ли список числа 4 и 30: " + numbers.containsAll(List.of(4, 30)));

        System.out.println("---");
        System.out.println("Удаляем элемент по индексу 5: " + numbers.remove(5));
        System.out.println("Список после удаления: " + numbers + ". Длина: " + numbers.size());

        System.out.println("---");
        System.out.println("Меняем элемент по индексу 3 на число 111: " + numbers.set(3, 111));
        System.out.println("Список после изменения: " + numbers);

        System.out.println("---");
        System.out.println("Проверка на итерируемость:");
        for (int number: numbers) {
            System.out.println(number);
        }
    }
}
