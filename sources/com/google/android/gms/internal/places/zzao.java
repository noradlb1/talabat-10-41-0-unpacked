package com.google.android.gms.internal.places;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzao extends zzq<Double> implements zzcw, RandomAccess {
    private static final zzao zzex;
    private int size;
    private double[] zzey;

    static {
        zzao zzao = new zzao(new double[0], 0);
        zzex = zzao;
        zzao.zzab();
    }

    public zzao() {
        this(new double[10], 0);
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

    public final /* synthetic */ void add(int i11, Object obj) {
        zzd(i11, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzao)) {
            return super.addAll(collection);
        }
        zzao zzao = (zzao) collection;
        int i11 = zzao.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.zzey;
            if (i13 > dArr.length) {
                this.zzey = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(zzao.zzey, 0, this.zzey, this.size, zzao.size);
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
        if (!(obj instanceof zzao)) {
            return super.equals(obj);
        }
        zzao zzao = (zzao) obj;
        if (this.size != zzao.size) {
            return false;
        }
        double[] dArr = zzao.zzey;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Double.doubleToLongBits(this.zzey[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzf(i11);
        return Double.valueOf(this.zzey[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + zzbd.zzl(Double.doubleToLongBits(this.zzey[i12]));
        }
        return i11;
    }

    public final boolean remove(Object obj) {
        zzac();
        for (int i11 = 0; i11 < this.size; i11++) {
            if (obj.equals(Double.valueOf(this.zzey[i11]))) {
                double[] dArr = this.zzey;
                System.arraycopy(dArr, i11 + 1, dArr, i11, (this.size - i11) - 1);
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
            double[] dArr = this.zzey;
            System.arraycopy(dArr, i12, dArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i11, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzac();
        zzf(i11);
        double[] dArr = this.zzey;
        double d11 = dArr[i11];
        dArr[i11] = doubleValue;
        return Double.valueOf(d11);
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d11) {
        zzd(this.size, d11);
    }

    public final /* synthetic */ zzbh zzh(int i11) {
        if (i11 >= this.size) {
            return new zzao(Arrays.copyOf(this.zzey, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzao(double[] dArr, int i11) {
        this.zzey = dArr;
        this.size = i11;
    }

    private final void zzd(int i11, double d11) {
        int i12;
        zzac();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        double[] dArr = this.zzey;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.zzey, i11, dArr2, i11 + 1, this.size - i11);
            this.zzey = dArr2;
        }
        this.zzey[i11] = d11;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ Object remove(int i11) {
        zzac();
        zzf(i11);
        double[] dArr = this.zzey;
        double d11 = dArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d11);
    }
}
