import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //coment
        int totalElements = 100000;
        int elementsToInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        measureFill(arrayList, totalElements, "ArrayList");
        measureFill(linkedList, totalElements, "LinkedList");

        measureRandomAccess(arrayList, totalElements, "ArrayList");
        measureRandomAccess(linkedList, totalElements, "LinkedList");

        measureSequentialAccess(arrayList, totalElements, "ArrayList");
        measureSequentialAccess(linkedList, totalElements, "LinkedList");

        measureInsertAtBeginning(arrayList, elementsToInsert, "ArrayList");
        measureInsertAtBeginning(linkedList, elementsToInsert, "LinkedList");

        measureInsertAtEnd(arrayList, elementsToInsert, "ArrayList");
        measureInsertAtEnd(linkedList, elementsToInsert, "LinkedList");

        measureInsertInMiddle(arrayList, elementsToInsert, "ArrayList");
        measureInsertInMiddle(linkedList, elementsToInsert, "LinkedList");
    }

    private static void measureFill(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        System.out.printf("Fill %s: %d ms%n", listType, System.currentTimeMillis() - time);
        System.out.printf("Number of elements in the list: %d%n", list.size());
        System.out.printf("Number of inserted elements: %d%n", count);
    }

    private static void measureRandomAccess(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(count);
            list.get(index);
        }
        System.out.printf("Random access in %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureSequentialAccess(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (Integer value : list) {
            // Accessing elements sequentially
        }
        System.out.printf("Sequential access in %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertAtBeginning(List<Integer> list, int elementsToInsert, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < elementsToInsert; i++) {
            list.add(0, i);
        }
        System.out.printf("Insert at the beginning of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertAtEnd(List<Integer> list, int elementsToInsert, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < elementsToInsert; i++) {
            list.add(i);
        }
        System.out.printf("Insert at the end of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void measureInsertInMiddle(List<Integer> list, int elementsToInsert, String listType) {
        long time = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator(list.size() / 2);
        for (int i = 0; i < elementsToInsert; i++) {
            iterator.add(i);
        }
        System.out.printf("Insert in the middle of %s: %d ms%n", listType, System.currentTimeMillis() - time);
    }
}
