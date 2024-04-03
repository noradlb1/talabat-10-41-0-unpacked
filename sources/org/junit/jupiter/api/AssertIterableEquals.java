package org.junit.jupiter.api;

import j$.util.Iterator;
import j$.util.function.Supplier;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

class AssertIterableEquals {

    public static final class Pair {
        private final Object left;
        private final Object right;

        public Pair(Object obj, Object obj2) {
            this.left = obj;
            this.right = obj2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Pair.class != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            if (!Objects.equals(this.left, pair.left) || !Objects.equals(this.right, pair.right)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.left, this.right});
        }
    }

    public enum Status {
        UNDER_INVESTIGATION,
        CONTAIN_SAME_ELEMENTS
    }

    private AssertIterableEquals() {
    }

    private static void assertIterableElementsEqual(Object obj, Object obj2, Deque<Integer> deque, Object obj3, Map<Pair, Status> map) {
        if (!Objects.equals(obj, obj2)) {
            if (!(obj instanceof Iterable) || !(obj2 instanceof Iterable)) {
                assertIterablesNotNull(obj, obj2, deque, obj3);
                failIterablesNotEqual(obj, obj2, deque, obj3);
                return;
            }
            Pair pair = new Pair(obj, obj2);
            Status status = map.get(pair);
            Status status2 = Status.CONTAIN_SAME_ELEMENTS;
            if (status != status2) {
                Status status3 = Status.UNDER_INVESTIGATION;
                if (status == status3) {
                    deque.removeLast();
                    failIterablesNotEqual(obj, obj2, deque, obj3);
                }
                map.put(pair, status3);
                assertIterableEquals((Iterable) obj, (Iterable) obj2, deque, obj3, map);
                map.put(pair, status2);
            }
        }
    }

    private static void assertIterableEquals(Iterable<?> iterable, Iterable<?> iterable2, Deque<Integer> deque, Object obj) {
        assertIterableEquals(iterable, iterable2, deque, obj, new LinkedHashMap());
    }

    private static void assertIterablesNotNull(Object obj, Object obj2, Deque<Integer> deque, Object obj3) {
        if (obj == null) {
            failExpectedIterableIsNull(deque, obj3);
        }
        if (obj2 == null) {
            failActualIterableIsNull(deque, obj3);
        }
    }

    private static void assertIteratorsAreEmpty(Iterator<?> it, Iterator<?> it2, int i11, Deque<Integer> deque, Object obj) {
        if (it.hasNext() || it2.hasNext()) {
            AtomicInteger atomicInteger = new AtomicInteger(i11);
            Iterator.EL.forEachRemaining(it, new b(atomicInteger));
            AtomicInteger atomicInteger2 = new AtomicInteger(i11);
            Iterator.EL.forEachRemaining(it2, new c(atomicInteger2));
            AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
            message.reason("iterable lengths differ" + AssertionUtils.l(deque)).expected(Integer.valueOf(atomicInteger.get())).actual(Integer.valueOf(atomicInteger2.get())).buildAndThrow();
        }
    }

    public static void c(Iterable<?> iterable, Iterable<?> iterable2) {
        d(iterable, iterable2, (String) null);
    }

    public static void d(Iterable<?> iterable, Iterable<?> iterable2, String str) {
        assertIterableEquals(iterable, iterable2, new ArrayDeque(), str);
    }

    public static void e(Iterable<?> iterable, Iterable<?> iterable2, Supplier<String> supplier) {
        assertIterableEquals(iterable, iterable2, new ArrayDeque(), supplier);
    }

    private static void failActualIterableIsNull(Deque<Integer> deque, Object obj) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
        message.reason("actual iterable was <null>" + AssertionUtils.l(deque)).buildAndThrow();
    }

    private static void failExpectedIterableIsNull(Deque<Integer> deque, Object obj) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj);
        message.reason("expected iterable was <null>" + AssertionUtils.l(deque)).buildAndThrow();
    }

    private static void failIterablesNotEqual(Object obj, Object obj2, Deque<Integer> deque, Object obj3) {
        AssertionFailureBuilder message = AssertionFailureBuilder.assertionFailure().message(obj3);
        message.reason("iterable contents differ" + AssertionUtils.l(deque)).expected(obj).actual(obj2).buildAndThrow();
    }

    private static void assertIterableEquals(Iterable<?> iterable, Iterable<?> iterable2, Deque<Integer> deque, Object obj, Map<Pair, Status> map) {
        if (iterable != iterable2) {
            assertIterablesNotNull(iterable, iterable2, deque, obj);
            java.util.Iterator<?> it = iterable.iterator();
            java.util.Iterator<?> it2 = iterable2.iterator();
            int i11 = 0;
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                Object next2 = it2.next();
                deque.addLast(Integer.valueOf(i11));
                assertIterableElementsEqual(next, next2, deque, obj, map);
                deque.removeLast();
                i11++;
            }
            assertIteratorsAreEmpty(it, it2, i11, deque, obj);
        }
    }
}
