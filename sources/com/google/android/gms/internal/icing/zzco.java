package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzco extends zzbt<Double> implements RandomAccess, zzdd, zzel {
    private static final zzco zza;
    private double[] zzb;
    private int zzc;

    static {
        zzco zzco = new zzco(new double[0], 0);
        zza = zzco;
        zzco.zzb();
    }

    public zzco() {
        this(new double[10], 0);
    }

    public static zzco zzd() {
        return zza;
    }

    private final void zzf(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
    }

    private final String zzg(int i11) {
        int i12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i11);
        sb2.append(", Size:");
        sb2.append(i12);
        return sb2.toString();
    }

    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        int i12;
        double doubleValue = ((Double) obj).doubleValue();
        zzc();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        double[] dArr = this.zzb;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.zzb, i11, dArr2, i11 + 1, this.zzc - i11);
            this.zzb = dArr2;
        }
        this.zzb[i11] = doubleValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzc();
        zzdh.zza(collection);
        if (!(collection instanceof zzco)) {
            return super.addAll(collection);
        }
        zzco zzco = (zzco) collection;
        int i11 = zzco.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.zzb;
            if (i13 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(zzco.zzb, 0, this.zzb, this.zzc, zzco.zzc);
            this.zzc = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzco)) {
            return super.equals(obj);
        }
        zzco zzco = (zzco) obj;
        if (this.zzc != zzco.zzc) {
            return false;
        }
        double[] dArr = zzco.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (Double.doubleToLongBits(this.zzb[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzf(i11);
        return Double.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + zzdh.zze(Double.doubleToLongBits(this.zzb[i12]));
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == doubleValue) {
                return i12;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzc();
        zzf(i11);
        double[] dArr = this.zzb;
        double d11 = dArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Double.valueOf(d11);
    }

    public final void removeRange(int i11, int i12) {
        zzc();
        if (i12 >= i11) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i12, dArr, i11, this.zzc - i12);
            this.zzc -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzc();
        zzf(i11);
        double[] dArr = this.zzb;
        double d11 = dArr[i11];
        dArr[i11] = doubleValue;
        return Double.valueOf(d11);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzdg zze(int i11) {
        if (i11 >= this.zzc) {
            return new zzco(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzco(double[] dArr, int i11) {
        this.zzb = dArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzc();
        int i11 = this.zzc;
        double[] dArr = this.zzb;
        if (i11 == dArr.length) {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        dArr3[i12] = doubleValue;
        return true;
    }
}
