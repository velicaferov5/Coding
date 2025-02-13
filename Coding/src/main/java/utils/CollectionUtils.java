package main.java.utils;

import java.util.LinkedList;
import java.util.List;

public class CollectionUtils {
    public static <T> LinkedList<T> toLinkedList(List<T> list) {
        return new LinkedList<>(list);
    }

}
