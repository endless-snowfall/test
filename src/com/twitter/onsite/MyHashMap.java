package com.twitter.onsite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MyHashMap<K, V> implements Map<K, V> {

    @AllArgsConstructor
    @Getter
    public static class Entry<K, V> {

        private K key;
        @Setter private V value;
    }

    private static final int DEFAULT_SIZE = 10;

    private List<List<Entry<K, V>>> entries;
    private int size;

    public MyHashMap() {
        entries = new ArrayList<>(DEFAULT_SIZE);
        IntStream.range(0, DEFAULT_SIZE).forEach(i -> entries.add(new LinkedList<>()));
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }

        int bucket = getBucket(key);
        Entry<K, V> entry = fetch(bucket, key);
        return entry == null ? null : entry.getValue();
    }

    @Override
    public V put(K key, V value) {
        int bucket = getBucket(key);
        Entry<K, V> entry = fetch(bucket, key);

        if (entry != null) {
            V result = entry.getValue();
            entry.setValue(value);
            return result;
        }

        entries.get(bucket).add(new Entry<K, V>(key, value));
        size++;
        return null;
    }

    private int getBucket(Object key) {
        return Math.abs(key.hashCode() % entries.size());
    }

    private Entry<K, V> fetch(int bucket, Object key) {
        for (Entry<K, V> entry : entries.get(bucket)) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
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
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    }

    @Override
    public void clear() {
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return null;
    }
}
