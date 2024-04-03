package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzpq extends zzpo<Boolean> implements zzsv, RandomAccess {
    private static final zzpq zzavv;
    private int size;
    private boolean[] zzavw;

    static {
        zzpq zzpq = new zzpq(new boolean[0], 0);
        zzavv = zzpq;
        zzpq.zzmi();
    }

    public zzpq() {
        this(new boolean[10], 0);
    }

    private final void zza(int i11, boolean z11) {
        int i12;
        zzmz();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i11));
        }
        boolean[] zArr = this.zzavw;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.zzavw, i11, zArr2, i11 + 1, this.size - i11);
            this.zzavw = zArr2;
        }
        this.zzavw[i11] = z11;
        this.size++;
        this.modCount++;
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

    public final /* synthetic */ void add(int i11, Object obj) {
        zza(i11, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzpq)) {
            return super.addAll(collection);
        }
        zzpq zzpq = (zzpq) collection;
        int i11 = zzpq.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.zzavw;
            if (i13 > zArr.length) {
                this.zzavw = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(zzpq.zzavw, 0, this.zzavw, this.size, zzpq.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void addBoolean(boolean z11) {
        zza(this.size, z11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpq)) {
            return super.equals(obj);
        }
        zzpq zzpq = (zzpq) obj;
        if (this.size != zzpq.size) {
            return false;
        }
        boolean[] zArr = zzpq.zzavw;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzavw[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzah(i11);
        return Boolean.valueOf(this.zzavw[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzre.zzk(this.zzavw[i12]);
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzmz();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Boolean.valueOf(this.zzavw[i11]))) {
                boolean[] zArr = this.zzavw;
                System.arraycopy(zArr, i11 + 1, zArr, i11, (this.size - i11) - 1);
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
            boolean[] zArr = this.zzavw;
            System.arraycopy(zArr, i12, zArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzmz();
        zzah(i11);
        boolean[] zArr = this.zzavw;
        boolean z11 = zArr[i11];
        zArr[i11] = booleanValue;
        return Boolean.valueOf(z11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzrj zzaj(int i11) {
        if (i11 >= this.size) {
            return new zzpq(Arrays.copyOf(this.zzavw, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzpq(boolean[] zArr, int i11) {
        this.zzavw = zArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzmz();
        zzah(i11);
        boolean[] zArr = this.zzavw;
        boolean z11 = zArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }
}
