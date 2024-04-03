package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbe extends zzq<Integer> implements zzbi, zzcw, RandomAccess {
    private static final zzbe zzjc;
    private int size;
    private int[] zzjd;

    static {
        zzbe zzbe = new zzbe(new int[0], 0);
        zzjc = zzbe;
        zzbe.zzab();
    }

    public zzbe() {
        this(new int[10], 0);
    }

    public static zzbe zzbo() {
        return zzjc;
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    private final String zzg(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    private final void zzp(int i11, int i12) {
        int i13;
        zzac();
        if (i11 < 0 || i11 > (i13 = this.size)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        int[] iArr = this.zzjd;
        if (i13 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i13 - i11);
        } else {
            int[] iArr2 = new int[(((i13 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.zzjd, i11, iArr2, i11 + 1, this.size - i11);
            this.zzjd = iArr2;
        }
        this.zzjd[i11] = i12;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzp(i11, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbe)) {
            return super.addAll(collection);
        }
        zzbe zzbe = (zzbe) collection;
        int i11 = zzbe.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.zzjd;
            if (i13 > iArr.length) {
                this.zzjd = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(zzbe.zzjd, 0, this.zzjd, this.size, zzbe.size);
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
        if (!(obj instanceof zzbe)) {
            return super.equals(obj);
        }
        zzbe zzbe = (zzbe) obj;
        if (this.size != zzbe.size) {
            return false;
        }
        int[] iArr = zzbe.zzjd;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzjd[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    public final int getInt(int i11) {
        zzf(i11);
        return this.zzjd[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + this.zzjd[i12];
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzac();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Integer.valueOf(this.zzjd[i11]))) {
                int[] iArr = this.zzjd;
                System.arraycopy(iArr, i11 + 1, iArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzac();
        if (i12 >= i11) {
            int[] iArr = this.zzjd;
            System.arraycopy(iArr, i12, iArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzac();
        zzf(i11);
        int[] iArr = this.zzjd;
        int i12 = iArr[i11];
        iArr[i11] = intValue;
        return Integer.valueOf(i12);
    }

    public final int size() {
        return this.size;
    }

    public final void zzac(int i11) {
        zzp(this.size, i11);
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= this.size) {
            return new zzbe(Arrays.copyOf(this.zzjd, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbe(int[] iArr, int i11) {
        this.zzjd = iArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        zzf(i11);
        int[] iArr = this.zzjd;
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
