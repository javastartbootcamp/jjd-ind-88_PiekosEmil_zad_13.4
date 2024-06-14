package pl.javastart.task;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {

    private Object[] objects;
    private int listSize = 1;
    private int index;

    public CustomList() {
        this.objects = new Object[listSize];
    }

    //Pobieranie elementu po indeksie - get(int index)
    public Object get(int index) {
        return objects[index];
    }

    //Dodawanie elementu (na koniec listy) - add(element)
    public void add(Object element) {
        if (listSize == objects.length) {
            objects = Arrays.copyOf(objects, objects.length * 2);
        }
        objects[index] = element;
        index++;
        listSize++;
    }

    //Wstawianie elementu w wybrane miejsce (i przesuwanie pozostałych elementów "dalej") - add(int index, element)
    public void add(int index, Object element) {
        for (int i = listSize - 1; i >= index; i--) {
            if (listSize == objects.length) {
                objects = Arrays.copyOf(objects, objects.length * 2);
            }
            objects[i + 1] = objects[i];
        }
        objects[index] = element;
        listSize++;
    }

    //Usuwanie elementu po indeksie - remove(int index)
    public void remove(int index) {
        objects[index] = null;
        for (int i = index; i < objects.length; ) {
            if (objects[i + 1] != null) {
                objects[i] = objects[i + 1];
                objects[i + 1] = null;
                i++;
            } else {
                break;
            }
        }
    }

    //Zwracanie informacji o rozmiarze listy - size()
    public int size() {
        int counter = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    //Wyświetlanie elementów w formacie [element1, element2, element3] - nadpisując metodę toString()

    @Override
    public String toString() {
        int i = 0;
        System.out.print("[");
        for (Object object : objects) {
            if (i < size() - 1) {
                System.out.print(object + ", ");
            } else if (i <= size() - 1) {
                System.out.print(object);
            }
            i++;
        }
        return "]";
    }
}