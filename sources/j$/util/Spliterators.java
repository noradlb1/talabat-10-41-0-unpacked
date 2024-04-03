package j$.util;

import java.util.Iterator;
import java.util.Objects;

public final class Spliterators {

    /* renamed from: a  reason: collision with root package name */
    private static final Spliterator f28575a = new V();

    /* renamed from: b  reason: collision with root package name */
    private static final D f28576b = new T();

    /* renamed from: c  reason: collision with root package name */
    private static final G f28577c = new U();

    /* renamed from: d  reason: collision with root package name */
    private static final A f28578d = new S();

    private static void a(int i11, int i12, int i13) {
        if (i12 > i13) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i12 + ") > fence(" + i13 + ")");
        } else if (i12 < 0) {
            throw new ArrayIndexOutOfBoundsException(i12);
        } else if (i13 > i11) {
            throw new ArrayIndexOutOfBoundsException(i13);
        }
    }

    public static A b() {
        return f28578d;
    }

    public static D c() {
        return f28576b;
    }

    public static G d() {
        return f28577c;
    }

    public static Spliterator e() {
        return f28575a;
    }

    public static PrimitiveIterator$OfDouble f(A a11) {
        Objects.requireNonNull(a11);
        return new O(a11);
    }

    public static PrimitiveIterator$OfInt g(D d11) {
        Objects.requireNonNull(d11);
        return new M(d11);
    }

    public static PrimitiveIterator$OfLong h(G g11) {
        Objects.requireNonNull(g11);
        return new N(g11);
    }

    public static Iterator i(Spliterator spliterator) {
        Objects.requireNonNull(spliterator);
        return new L(spliterator);
    }

    public static A j(double[] dArr, int i11, int i12) {
        Objects.requireNonNull(dArr);
        a(dArr.length, i11, i12);
        return new Q(dArr, i11, i12, 1040);
    }

    public static D k(int[] iArr, int i11, int i12) {
        Objects.requireNonNull(iArr);
        a(iArr.length, i11, i12);
        return new W(iArr, i11, i12, 1040);
    }

    public static G l(long[] jArr, int i11, int i12) {
        Objects.requireNonNull(jArr);
        a(jArr.length, i11, i12);
        return new Y(jArr, i11, i12, 1040);
    }

    public static Spliterator m(Object[] objArr, int i11, int i12) {
        Objects.requireNonNull(objArr);
        a(objArr.length, i11, i12);
        return new P(objArr, i11, i12, 1040);
    }

    public static <T> Spliterator<T> spliteratorUnknownSize(Iterator<? extends T> it, int i11) {
        Objects.requireNonNull(it);
        return new X((Iterator) it, i11);
    }
}
