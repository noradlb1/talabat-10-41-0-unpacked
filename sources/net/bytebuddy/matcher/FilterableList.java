package net.bytebuddy.matcher;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.matcher.FilterableList;

public interface FilterableList<T, S extends FilterableList<T, S>> extends List<T> {

    public static abstract class AbstractBase<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        private static final int ONLY = 0;

        public abstract S a(List<T> list);

        public S filter(ElementMatcher<? super T> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (elementMatcher.matches(next)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() == size()) {
                return this;
            }
            return a(arrayList);
        }

        public T getOnly() {
            if (size() == 1) {
                return get(0);
            }
            throw new IllegalStateException("size = " + size());
        }

        public S subList(int i11, int i12) {
            return a(super.subList(i11, i12));
        }
    }

    public static class Empty<T, S extends FilterableList<T, S>> extends AbstractList<T> implements FilterableList<T, S> {
        public S filter(ElementMatcher<? super T> elementMatcher) {
            return this;
        }

        public T get(int i11) {
            throw new IndexOutOfBoundsException("index = " + i11);
        }

        public T getOnly() {
            throw new IllegalStateException("size = 0");
        }

        public int size() {
            return 0;
        }

        public S subList(int i11, int i12) {
            if (i11 == i12 && i12 == 0) {
                return this;
            }
            if (i11 > i12) {
                throw new IllegalArgumentException("fromIndex(" + i11 + ") > toIndex(" + i12 + ")");
            }
            throw new IndexOutOfBoundsException("fromIndex = " + i11);
        }
    }

    S filter(ElementMatcher<? super T> elementMatcher);

    T getOnly();

    S subList(int i11, int i12);
}
