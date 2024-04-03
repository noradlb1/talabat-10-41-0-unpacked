package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgb extends zzex<Double> implements zzio, RandomAccess {
    private static final zzgb zzst;
    private int size;
    private double[] zzsu;

    static {
        zzgb zzgb = new zzgb(new double[0], 0);
        zzst = zzgb;
        zzgb.zzdp();
    }

    public zzgb() {
        this(new double[10], 0);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzdq();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzaf(i11));
        }
        double[] dArr = this.zzsu;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.zzsu, i11, dArr2, i11 + 1, this.size - i11);
            this.zzsu = dArr2;
        }
        this.zzsu[i11] = doubleValue;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzdq();
        zzgt.checkNotNull(collection);
        if (!(collection instanceof zzgb)) {
            return super.addAll(collection);
        }
        zzgb zzgb = (zzgb) collection;
        int i11 = zzgb.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.zzsu;
            if (i13 > dArr.length) {
                this.zzsu = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(zzgb.zzsu, 0, this.zzsu, this.size, zzgb.size);
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
        if (!(obj instanceof zzgb)) {
            return super.equals(obj);
        }
        zzgb zzgb = (zzgb) obj;
        if (this.size != zzgb.size) {
            return false;
        }
        double[] dArr = zzgb.zzsu;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Double.doubleToLongBits(this.zzsu[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzae(i11);
        return Double.valueOf(this.zzsu[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzgt.zzab(Double.doubleToLongBits(this.zzsu[i12]));
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzdq();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Double.valueOf(this.zzsu[i11]))) {
                double[] dArr = this.zzsu;
                System.arraycopy(dArr, i11 + 1, dArr, i11, (this.size - i11) - 1);
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
            double[] dArr = this.zzsu;
            System.arraycopy(dArr, i12, dArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzdq();
        zzae(i11);
        double[] dArr = this.zzsu;
        double d11 = dArr[i11];
        dArr[i11] = doubleValue;
        return Double.valueOf(d11);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzgz zzag(int i11) {
        if (i11 >= this.size) {
            return new zzgb(Arrays.copyOf(this.zzsu, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzc(double d11) {
        zzdq();
        int i11 = this.size;
        double[] dArr = this.zzsu;
        if (i11 == dArr.length) {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            this.zzsu = dArr2;
        }
        double[] dArr3 = this.zzsu;
        int i12 = this.size;
        this.size = i12 + 1;
        dArr3[i12] = d11;
    }

    private zzgb(double[] dArr, int i11) {
        this.zzsu = dArr;
        this.size = i11;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzdq();
        zzae(i11);
        double[] dArr = this.zzsu;
        double d11 = dArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d11);
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzc(((Double) obj).doubleValue());
        return true;
    }
}
