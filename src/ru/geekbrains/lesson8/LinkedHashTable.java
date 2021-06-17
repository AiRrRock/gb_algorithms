package ru.geekbrains.lesson8;

import lesson8.HashTable;
import lesson8.HashTableImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class LinkedHashTable<K, V> implements HashTable<K, V> {
    private int size =0;
    private LinkedList<Item<K,V>>[] data;
    private final LinkedHashTable.Item<K, V> emptyItem = new LinkedHashTable.Item<>(null, null);


    public LinkedHashTable(int size) {
        this.data = new LinkedList[size];
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        LinkedList<Item<K,V>> currentItems = data[index];
        if (currentItems == null) {
           currentItems = new LinkedList<>();
        }

        boolean found = false;
        if(!currentItems.isEmpty()){

            for(Item<K,V> item: currentItems){
                if (isKeysEqual(item, key)){
                    item.value=value;
                    found = true;
                    break;
                }
            }


        }
        if(!found){
            currentItems.add(new Item<>(key,value));
            data[index]=currentItems;
            size++;
        }
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        LinkedList<Item<K,V>> currentItems = data[index];
        if (currentItems != null && !currentItems.isEmpty()) {
            for(Item<K,V> item: currentItems){
                if (isKeysEqual(item, key)){
                    return item.value;
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        LinkedList<Item<K,V>> currentItems = data[index];
        Item<K,V> current = null;
        if (currentItems != null && !currentItems.isEmpty()) {
            for(Item<K,V> item: currentItems){
                if (isKeysEqual(item, key)){
                    current = item;
                    break;
                }
            }
            if(current!=null) {
                currentItems.remove(current);
                size--;
            }
        }
        return current == null ? null : current.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        Arrays.stream(data).filter(Objects::nonNull).forEach(System.out::println);
    }

    protected int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    private boolean isKeysEqual(LinkedHashTable.Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }


    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
