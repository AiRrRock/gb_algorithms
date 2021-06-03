package ru.geekbrains.lesson4;

import lesson3.deque.Deque;
import lesson4.LinkedQueueImpl;

import java.util.Iterator;

public class LinkedDequeImpl<E> extends LinkedQueueImpl<E> implements Deque<E>, Iterable<E>{

    public LinkedDequeImpl() {
        super();
    }

    @Override
    public boolean insertLeft(E value) {
        this.data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        return this.data.removeLast();
    }


}
