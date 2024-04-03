package j$.util;

import java.util.Collections;
import java.util.Comparator;

/* renamed from: j$.util.d  reason: case insensitive filesystem */
enum C0138d implements Comparator, Comparator {
    ;

    private C0138d() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    public final Comparator reversed() {
        return Collections.reverseOrder();
    }
}
