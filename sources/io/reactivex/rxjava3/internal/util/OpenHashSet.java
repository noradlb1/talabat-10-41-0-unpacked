package io.reactivex.rxjava3.internal.util;

public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;

    /* renamed from: a  reason: collision with root package name */
    public final float f23195a;

    /* renamed from: b  reason: collision with root package name */
    public int f23196b;

    /* renamed from: c  reason: collision with root package name */
    public int f23197c;

    /* renamed from: d  reason: collision with root package name */
    public int f23198d;

    /* renamed from: e  reason: collision with root package name */
    public T[] f23199e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public static int a(int i11) {
        int i12 = i11 * INT_PHI;
        return i12 ^ (i12 >>> 16);
    }

    public boolean add(T t11) {
        T t12;
        T[] tArr = this.f23199e;
        int i11 = this.f23196b;
        int a11 = a(t11.hashCode()) & i11;
        T t13 = tArr[a11];
        if (t13 != null) {
            if (t13.equals(t11)) {
                return false;
            }
            do {
                a11 = (a11 + 1) & i11;
                t12 = tArr[a11];
                if (t12 == null) {
                }
            } while (!t12.equals(t11));
            return false;
        }
        tArr[a11] = t11;
        int i12 = this.f23197c + 1;
        this.f23197c = i12;
        if (i12 >= this.f23198d) {
            b();
        }
        return true;
    }

    public void b() {
        T t11;
        T[] tArr = this.f23199e;
        int length = tArr.length;
        int i11 = length << 1;
        int i12 = i11 - 1;
        T[] tArr2 = new Object[i11];
        int i13 = this.f23197c;
        while (true) {
            int i14 = i13 - 1;
            if (i13 != 0) {
                do {
                    length--;
                    t11 = tArr[length];
                } while (t11 == null);
                int a11 = a(t11.hashCode()) & i12;
                if (tArr2[a11] != null) {
                    do {
                        a11 = (a11 + 1) & i12;
                    } while (tArr2[a11] != null);
                }
                tArr2[a11] = tArr[length];
                i13 = i14;
            } else {
                this.f23196b = i12;
                this.f23198d = (int) (((float) i11) * this.f23195a);
                this.f23199e = tArr2;
                return;
            }
        }
    }

    public boolean c(int i11, T[] tArr, int i12) {
        int i13;
        T t11;
        this.f23197c--;
        while (true) {
            int i14 = i11 + 1;
            while (true) {
                i13 = i14 & i12;
                t11 = tArr[i13];
                if (t11 == null) {
                    tArr[i11] = null;
                    return true;
                }
                int a11 = a(t11.hashCode()) & i12;
                if (i11 <= i13) {
                    if (i11 >= a11 || a11 > i13) {
                        break;
                    }
                    i14 = i13 + 1;
                } else {
                    if (i11 >= a11 && a11 > i13) {
                        break;
                    }
                    i14 = i13 + 1;
                }
            }
            tArr[i11] = t11;
            i11 = i13;
        }
    }

    public Object[] keys() {
        return this.f23199e;
    }

    public boolean remove(T t11) {
        T t12;
        T[] tArr = this.f23199e;
        int i11 = this.f23196b;
        int a11 = a(t11.hashCode()) & i11;
        T t13 = tArr[a11];
        if (t13 == null) {
            return false;
        }
        if (t13.equals(t11)) {
            return c(a11, tArr, i11);
        }
        do {
            a11 = (a11 + 1) & i11;
            t12 = tArr[a11];
            if (t12 == null) {
                return false;
            }
        } while (!t12.equals(t11));
        return c(a11, tArr, i11);
    }

    public int size() {
        return this.f23197c;
    }

    public OpenHashSet(int i11) {
        this(i11, 0.75f);
    }

    public OpenHashSet(int i11, float f11) {
        this.f23195a = f11;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        this.f23196b = roundToPowerOfTwo - 1;
        this.f23198d = (int) (f11 * ((float) roundToPowerOfTwo));
        this.f23199e = new Object[roundToPowerOfTwo];
    }
}
