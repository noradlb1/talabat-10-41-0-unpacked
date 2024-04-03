package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzff extends zzex<Boolean> implements zzio, RandomAccess {
    private static final zzff zzrs;
    private int size;
    private boolean[] zzrt;

    static {
        zzff zzff = new zzff(new boolean[0], 0);
        zzrs = zzff;
        zzff.zzdp();
    }

    public zzff() {
        this(new boolean[10], 0);
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

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        boolean[] zArr = this.zzrt;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.zzrt, i11, zArr2, i11 + 1, this.size - i11);
            this.zzrt = zArr2;
        }
        this.zzrt[i11] = booleanValue;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzff)) {
            return super.addAll(collection);
        }
        zzff zzff = (zzff) collection;
        int i11 = zzff.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.zzrt;
            if (i13 > zArr.length) {
                this.zzrt = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(zzff.zzrt, 0, this.zzrt, this.size, zzff.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z11) {
        zzdq();
        int i11 = this.size;
        boolean[] zArr = this.zzrt;
        if (i11 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            this.zzrt = zArr2;
        }
        boolean[] zArr3 = this.zzrt;
        int i12 = this.size;
        this.size = i12 + 1;
        zArr3[i12] = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzff)) {
            return super.equals(obj);
        }
        zzff zzff = (zzff) obj;
        if (this.size != zzff.size) {
            return false;
        }
        boolean[] zArr = zzff.zzrt;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzrt[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzae(i11);
        return Boolean.valueOf(this.zzrt[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzgt.zzm(this.zzrt[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Boolean.valueOf(this.zzrt[i11]))) {
                boolean[] zArr = this.zzrt;
                System.arraycopy(zArr, i11 + 1, zArr, i11, (this.size - i11) - 1);
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
            boolean[] zArr = this.zzrt;
            System.arraycopy(zArr, i12, zArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzdq();
        zzae(i11);
        boolean[] zArr = this.zzrt;
        boolean z11 = zArr[i11];
        zArr[i11] = booleanValue;
        return Boolean.valueOf(z11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zzff(Arrays.copyOf(this.zzrt, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzff(boolean[] zArr, int i11) {
        this.zzrt = zArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        zzae(i11);
        boolean[] zArr = this.zzrt;
        boolean z11 = zArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }

    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
