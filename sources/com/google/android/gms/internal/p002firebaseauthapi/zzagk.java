package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagk  reason: invalid package */
final class zzagk extends zzafg implements RandomAccess, zzaim {
    private static final zzagk zza = new zzagk(new double[0], 0, false);
    private double[] zzb;
    private int zzc;

    public zzagk() {
        this(new double[10], 0, true);
    }

    private final String zzf(int i11) {
        int i12 = this.zzc;
        return "Index:" + i11 + ", Size:" + i12;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
    }

    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i11));
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

    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzahg.zzd;
        collection.getClass();
        if (!(collection instanceof zzagk)) {
            return super.addAll(collection);
        }
        zzagk zzagk = (zzagk) collection;
        int i11 = zzagk.zzc;
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
            System.arraycopy(zzagk.zzb, 0, this.zzb, this.zzc, zzagk.zzc);
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
        if (!(obj instanceof zzagk)) {
            return super.equals(obj);
        }
        zzagk zzagk = (zzagk) obj;
        if (this.zzc != zzagk.zzc) {
            return false;
        }
        double[] dArr = zzagk.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (Double.doubleToLongBits(this.zzb[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i11) {
        zzg(i11);
        return Double.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zzb[i12]);
            byte[] bArr = zzahg.zzd;
            i11 = (i11 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
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
        zza();
        zzg(i11);
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
        zza();
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
        zza();
        zzg(i11);
        double[] dArr = this.zzb;
        double d11 = dArr[i11];
        dArr[i11] = doubleValue;
        return Double.valueOf(d11);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzahf zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzagk(Arrays.copyOf(this.zzb, i11), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d11) {
        zza();
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
        dArr3[i12] = d11;
    }

    private zzagk(double[] dArr, int i11, boolean z11) {
        super(z11);
        this.zzb = dArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
