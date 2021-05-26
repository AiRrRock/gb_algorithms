package ru.geekbrains.lesson2;

import java.util.Arrays;

public class HomeworkArrayImpl<E extends Comparable<? super E>> implements Array<E> {


    private static final int DEFAULT_CAPACITY = 8;

    protected E[] data;
    protected int size;

    public HomeworkArrayImpl() {
        this.data = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public HomeworkArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public HomeworkArrayImpl(Array<E> copy) {
        this.data = (E[]) new Comparable[copy.size()];
        for (int i = 0; i < copy.size(); i++) {
            add(copy.get(i));
        }
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size] = value;
        size++;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, size == 0 ? 1 : size * 2);
        }
    }


    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errorMsg = String.format("Incorrect 'index': %d; max value is %d",
                    index, size - 1);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        checkAndShrink();
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        checkAndShrink();
        return removedValue;
    }

    protected void checkAndShrink() {
        if (data.length >= size / 2 + size % 2) {
            data = Arrays.copyOf(data, size - size / 4);
        }
    }


    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    E temp = data[j];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int newIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[newIndex]) < 0) {
                    newIndex = j;
                }
            }
            E temp = data[newIndex];
            data[newIndex] = data[i];
            data[i] = temp;
        }
    }


    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].compareTo(temp) >= 0) {
                data[j] = data[--j];
            }
            data[j] = temp;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size -1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }

        sb.append("]");
        return sb.toString();
    }
}
