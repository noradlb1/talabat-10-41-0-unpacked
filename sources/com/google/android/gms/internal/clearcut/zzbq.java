package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbq extends zzav<Double> implements RandomAccess {
    private static final zzbq zzgj;
    private int size;
    private double[] zzgk;

    static {
        zzbq zzbq = new zzbq();
        zzgj = zzbq;
        zzbq.zzv();
    }

    public zzbq() {
        this(new double[10], 0);
    }

    private zzbq(double[] dArr, int i11) {
        this.zzgk = dArr;
        this.size = i11;
    }

    private final void zzc(int i11, double d11) {
        int i12;
        zzw();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
        double[] dArr = this.zzgk;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.zzgk, i11, dArr2, i11 + 1, this.size - i11);
            this.zzgk = dArr2;
        }
        this.zzgk[i11] = d11;
        this.size++;
        this.modCount++;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
    }

    private final String zzh(int i11) {
        int i12 = this.size;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        zzc(i11, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof zzbq)) {
            return super.addAll(collection);
        }
        zzbq zzbq = (zzbq) collection;
        int i11 = zzbq.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.zzgk;
            if (i13 > dArr.length) {
                this.zzgk = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(zzbq.zzgk, 0, this.zzgk, this.size, zzbq.size);
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
        if (!(obj instanceof zzbq)) {
            return super.equals(obj);
        }
        zzbq zzbq = (zzbq) obj;
        if (this.size != zzbq.size) {
            return false;
        }
        double[] dArr = zzbq.zzgk;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.zzgk[i11] != dArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzg(i11);
        return Double.valueOf(this.zzgk[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzci.zzl(Double.doubleToLongBits(this.zzgk[i12]));
        }
        return i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzw();
        zzg(i11);
        double[] dArr = this.zzgk;
        double d11 = dArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, i12 - i11);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d11);
    }

    public final boolean remove(Object obj) {
        zzw();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Double.valueOf(this.zzgk[i11]))) {
                double[] dArr = this.zzgk;
                System.arraycopy(dArr, i11 + 1, dArr, i11, this.size - i11);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    public final void removeRange(int i11, int i12) {
        zzw();
        if (i12 >= i11) {
            double[] dArr = this.zzgk;
            System.arraycopy(dArr, i12, dArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzw();
        zzg(i11);
        double[] dArr = this.zzgk;
        double d11 = dArr[i11];
        dArr[i11] = doubleValue;
        return Double.valueOf(d11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d11) {
        zzc(this.size, d11);
    }

    public final /* synthetic */ zzcn zzi(int i11) {
        if (i11 >= this.size) {
            return new zzbq(Arrays.copyOf(this.zzgk, i11), this.size);
        }
        throw new IllegalArgumentException();
    }
}
