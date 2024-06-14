package pl.javastart.task;

import java.util.Arrays;

public class CustomList<T> {

    private Object[] objects;
    private int listSize = 1;
    private int index;

    public CustomList() {
        this.objects = new Object[listSize];
    }

    public T get(int index) {
        return (T) objects[index];
    }

    public void add(Object element) {
        if (listSize == objects.length) {
            objects = Arrays.copyOf(objects, objects.length * 2);
        }
        objects[index] = element;
        index++;
        listSize++;
    }

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

    public int size() {
        int counter = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                counter++;
            }
        }
        return counter;
    }

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