package j$.util;

import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;

public final /* synthetic */ class DesugarArrays {
    public static IntStream stream(int[] iArr) {
        return StreamSupport.b(Spliterators.k(iArr, 0, iArr.length));
    }

    public static <T> Stream<T> stream(T[] tArr) {
        return StreamSupport.stream(Spliterators.m(tArr, 0, tArr.length), false);
    }
}
