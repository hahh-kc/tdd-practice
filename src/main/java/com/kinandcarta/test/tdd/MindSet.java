package com.kinandcarta.test.tdd;

import java.util.Arrays;

public class MindSet {

    public Object[] items = new Object[]{};


    public boolean isEmpty() {
        return items != null && items.length==0;
    }

    public void add(Object item) {
        int size = items.length;
        if (!contains(item)) {
            items = Arrays.copyOf(items, items.length + 1);
            items[size] = item;
        }
    }

    public boolean contains(Object item) {
        return indexOf(item) > -1;
    }


    public int indexOf(Object item) {
        for (int i = 0; i< items.length;i++) {
            Object o = items[i];
            if (isEquals(o,item)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isEquals(Object a,Object b) {
        if (a==null || b==null) return false;
        return  (a.equals(b) || a.hashCode() == b.hashCode());
    }


    public int size() {
        return items.length;
    }

    public void remove(Object item) {
        if (contains(item)) {
           items = Arrays.stream(items).filter((a)-> !isEquals(a,item)).toArray(Object[]::new);
        }
    }
}
