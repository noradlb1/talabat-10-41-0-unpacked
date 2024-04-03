package j$.util.stream;

import j$.lang.Iterable;
import j$.util.Spliterator;
import java.util.Arrays;

abstract class Y2 extends C0214e implements Iterable, Iterable {

    /* renamed from: e  reason: collision with root package name */
    Object f29070e = newArray(16);

    /* renamed from: f  reason: collision with root package name */
    Object[] f29071f;

    Y2() {
    }

    Y2(int i11) {
        super(i11);
    }

    public Object b() {
        long count = count();
        if (count < 2147483639) {
            Object newArray = newArray((int) count);
            c(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public void c(int i11, Object obj) {
        long j11 = (long) i11;
        long count = count() + j11;
        if (count > ((long) s(obj)) || count < j11) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f29133c == 0) {
            System.arraycopy(this.f29070e, 0, obj, i11, this.f29132b);
        } else {
            for (int i12 = 0; i12 < this.f29133c; i12++) {
                Object obj2 = this.f29071f[i12];
                System.arraycopy(obj2, 0, obj, i11, s(obj2));
                i11 += s(this.f29071f[i12]);
            }
            int i13 = this.f29132b;
            if (i13 > 0) {
                System.arraycopy(this.f29070e, 0, obj, i11, i13);
            }
        }
    }

    public final void clear() {
        Object[] objArr = this.f29071f;
        if (objArr != null) {
            this.f29070e = objArr[0];
            this.f29071f = null;
            this.f29134d = null;
        }
        this.f29132b = 0;
        this.f29133c = 0;
    }

    public void d(Object obj) {
        for (int i11 = 0; i11 < this.f29133c; i11++) {
            Object obj2 = this.f29071f[i11];
            r(obj2, 0, s(obj2), obj);
        }
        r(this.f29070e, 0, this.f29132b, obj);
    }

    public abstract Object newArray(int i11);

    /* access modifiers changed from: protected */
    public abstract void r(Object obj, int i11, int i12, Object obj2);

    /* access modifiers changed from: protected */
    public abstract int s(Object obj);

    public abstract Spliterator spliterator();

    /* access modifiers changed from: protected */
    public final int t(long j11) {
        if (this.f29133c == 0) {
            if (j11 < ((long) this.f29132b)) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j11));
        } else if (j11 < count()) {
            for (int i11 = 0; i11 <= this.f29133c; i11++) {
                if (j11 < this.f29134d[i11] + ((long) s(this.f29071f[i11]))) {
                    return i11;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j11));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j11));
        }
    }

    /* access modifiers changed from: protected */
    public final void u(long j11) {
        long j12;
        int i11 = this.f29133c;
        if (i11 == 0) {
            j12 = (long) s(this.f29070e);
        } else {
            j12 = ((long) s(this.f29071f[i11])) + this.f29134d[i11];
        }
        if (j11 > j12) {
            if (this.f29071f == null) {
                Object[] v11 = v();
                this.f29071f = v11;
                this.f29134d = new long[8];
                v11[0] = this.f29070e;
            }
            int i12 = this.f29133c;
            while (true) {
                i12++;
                if (j11 > j12) {
                    Object[] objArr = this.f29071f;
                    if (i12 >= objArr.length) {
                        int length = objArr.length * 2;
                        this.f29071f = Arrays.copyOf(objArr, length);
                        this.f29134d = Arrays.copyOf(this.f29134d, length);
                    }
                    int i13 = this.f29131a;
                    if (!(i12 == 0 || i12 == 1)) {
                        i13 = Math.min((i13 + i12) - 1, 30);
                    }
                    int i14 = 1 << i13;
                    this.f29071f[i12] = newArray(i14);
                    long[] jArr = this.f29134d;
                    int i15 = i12 - 1;
                    jArr[i12] = jArr[i15] + ((long) s(this.f29071f[i15]));
                    j12 += (long) i14;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object[] v();

    /* access modifiers changed from: protected */
    public final void w() {
        long j11;
        if (this.f29132b == s(this.f29070e)) {
            if (this.f29071f == null) {
                Object[] v11 = v();
                this.f29071f = v11;
                this.f29134d = new long[8];
                v11[0] = this.f29070e;
            }
            int i11 = this.f29133c;
            int i12 = i11 + 1;
            Object[] objArr = this.f29071f;
            if (i12 >= objArr.length || objArr[i12] == null) {
                if (i11 == 0) {
                    j11 = (long) s(this.f29070e);
                } else {
                    j11 = ((long) s(objArr[i11])) + this.f29134d[i11];
                }
                u(j11 + 1);
            }
            this.f29132b = 0;
            int i13 = this.f29133c + 1;
            this.f29133c = i13;
            this.f29070e = this.f29071f[i13];
        }
    }
}
