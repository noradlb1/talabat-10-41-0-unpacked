package org.mockito.internal.util.collections;

import java.util.Collection;
import java.util.LinkedList;

public final class ListUtil {

    public interface Converter<FromT, To> {
        To convert(FromT fromt);
    }

    public interface Filter<T> {
        boolean isOut(T t11);
    }

    private ListUtil() {
    }

    public static <FromT, To> LinkedList<To> convert(Collection<FromT> collection, Converter<FromT, To> converter) {
        LinkedList<To> linkedList = new LinkedList<>();
        for (FromT convert : collection) {
            linkedList.add(converter.convert(convert));
        }
        return linkedList;
    }

    public static <T> LinkedList<T> filter(Collection<T> collection, Filter<T> filter) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T next : collection) {
            if (!filter.isOut(next)) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }
}
