package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgu extends zzex<Integer> implements zzio, RandomAccess {
    private static final zzgu zzxf;
    private int size;
    private int[] zzxg;

    static {
        zzgu zzgu = new zzgu(new int[0], 0);
        zzxf = zzgu;
        zzgu.zzdp();
    }

    public zzgu() {
        this(new int[10], 0);
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

    public static zzgu zzgl() {
        return zzxf;
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        int intValue = ((Integer) obj).intValue();
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        int[] iArr = this.zzxg;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i12 - i11);
        } else {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.zzxg, i11, iArr2, i11 + 1, this.size - i11);
            this.zzxg = iArr2;
        }
        this.zzxg[i11] = intValue;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgu)) {
            return super.addAll(collection);
        }
        zzgu zzgu = (zzgu) collection;
        int i11 = zzgu.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.zzxg;
            if (i13 > iArr.length) {
                this.zzxg = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(zzgu.zzxg, 0, this.zzxg, this.size, zzgu.size);
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
        if (!(obj instanceof zzgu)) {
            return super.equals(obj);
        }
        zzgu zzgu = (zzgu) obj;
        if (this.size != zzgu.size) {
            return false;
        }
        int[] iArr = zzgu.zzxg;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzxg[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    public final int getInt(int i11) {
        zzae(i11);
        return this.zzxg[i11];
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + this.zzxg[i12];
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Integer.valueOf(this.zzxg[i11]))) {
                int[] iArr = this.zzxg;
                System.arraycopy(iArr, i11 + 1, iArr, i11, (this.size - i11) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzdq();
        if (i12 >= i11) {
            int[] iArr = this.zzxg;
            System.arraycopy(iArr, i12, iArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzdq();
        zzae(i11);
        int[] iArr = this.zzxg;
        int i12 = iArr[i11];
        iArr[i11] = intValue;
        return Integer.valueOf(i12);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zzgu(Arrays.copyOf(this.zzxg, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzbl(int i11) {
        zzdq();
        int i12 = this.size;
        int[] iArr = this.zzxg;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.zzxg = iArr2;
        }
        int[] iArr3 = this.zzxg;
        int i13 = this.size;
        this.size = i13 + 1;
        iArr3[i13] = i11;
    }

    private zzgu(int[] iArr, int i11) {
        this.zzxg = iArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        zzae(i11);
        int[] iArr = this.zzxg;
        int i12 = iArr[i11];
        int i13 = this.size;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i12);
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzbl(((Integer) obj).intValue());
        return true;
    }
}
