package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzrd extends zzpo<Integer> implements zzsv, RandomAccess {
    private static final zzrd zzbbf;
    private int size;
    private int[] zzbbg;

    static {
        zzrd zzrd = new zzrd(new int[0], 0);
        zzbbf = zzrd;
        zzrd.zzmi();
    }

    public zzrd() {
        this(new int[10], 0);
    }

    private final void zzah(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
    }

    private final String zzai(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public static zzrd zzpo() {
        return zzbbf;
    }

    private final void zzq(int i11, int i12) {
        int i13;
        zzmz();
        if (i11 < 0 || i11 > (i13 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
        int[] iArr = this.zzbbg;
        if (i13 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i13 - i11);
        } else {
            int[] iArr2 = new int[(((i13 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.zzbbg, i11, iArr2, i11 + 1, this.size - i11);
            this.zzbbg = iArr2;
        }
        this.zzbbg[i11] = i12;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzq(i11, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzrd)) {
            return super.addAll(collection);
        }
        zzrd zzrd = (zzrd) collection;
        int i11 = zzrd.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.zzbbg;
            if (i13 > iArr.length) {
                this.zzbbg = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(zzrd.zzbbg, 0, this.zzbbg, this.size, zzrd.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrd)) {
            return super.equals(obj);
        }
        zzrd zzrd = (zzrd) obj;
        if (this.size != zzrd.size) {
            return false;
        }
        int[] iArr = zzrd.zzbbg;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzbbg[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    public final int getInt(int i11) {
        zzah(i11);
        return this.zzbbg[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + this.zzbbg[i12];
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzmz();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Integer.valueOf(this.zzbbg[i11]))) {
                int[] iArr = this.zzbbg;
                System.arraycopy(iArr, i11 + 1, iArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzmz();
        if (i12 >= i11) {
            int[] iArr = this.zzbbg;
            System.arraycopy(iArr, i12, iArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzmz();
        zzah(i11);
        int[] iArr = this.zzbbg;
        int i12 = iArr[i11];
        iArr[i11] = intValue;
        return Integer.valueOf(i12);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzrj zzaj(int i11) {
        if (i11 >= this.size) {
            return new zzrd(Arrays.copyOf(this.zzbbg, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzbm(int i11) {
        zzq(this.size, i11);
    }

    private zzrd(int[] iArr, int i11) {
        this.zzbbg = iArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzmz();
        zzah(i11);
        int[] iArr = this.zzbbg;
        int i12 = iArr[i11];
        int i13 = this.size;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i12);
    }
}
