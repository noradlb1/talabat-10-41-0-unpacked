package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.RandomAccess;

final class zziq<E> extends zzex<E> implements RandomAccess {
    private static final zziq<Object> zzzq;
    private int size;
    private E[] zzlu;

    static {
        zziq<Object> zziq = new zziq<>(new Object[0], 0);
        zzzq = zziq;
        zziq.zzdp();
    }

    public zziq() {
        this(new Object[10], 0);
    }

    private final void zzae(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
    }

    private final String zzaf(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public static <E> zziq<E> zzhr() {
        return zzzq;
    }

    public final boolean add(E e11) {
        zzdq();
        int i11 = this.size;
        E[] eArr = this.zzlu;
        if (i11 == eArr.length) {
            this.zzlu = Arrays.copyOf(eArr, ((i11 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzlu;
        int i12 = this.size;
        this.size = i12 + 1;
        eArr2[i12] = e11;
        this.modCount++;
        return true;
    }

    public final E get(int i11) {
        zzae(i11);
        return this.zzlu[i11];
    }

    public final E remove(int i11) {
        zzdq();
        zzae(i11);
        E[] eArr = this.zzlu;
        E e11 = eArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(eArr, i11 + 1, eArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return e11;
    }

    public final E set(int i11, E e11) {
        zzdq();
        zzae(i11);
        E[] eArr = this.zzlu;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        this.modCount++;
        return e12;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zziq(Arrays.copyOf(this.zzlu, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zziq(E[] eArr, int i11) {
        this.zzlu = eArr;
        this.size = i11;
    }

    public final void add(int i11, E e11) {
        int i12;
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        E[] eArr = this.zzlu;
        if (i12 < eArr.length) {
            System.arraycopy(eArr, i11, eArr, i11 + 1, i12 - i11);
        } else {
            E[] eArr2 = new Object[(((i12 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i11);
            System.arraycopy(this.zzlu, i11, eArr2, i11 + 1, this.size - i11);
            this.zzlu = eArr2;
        }
        this.zzlu[i11] = e11;
        this.size++;
        this.modCount++;
    }
}
