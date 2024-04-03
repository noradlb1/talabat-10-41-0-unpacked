package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbv extends zzbt<Boolean> implements RandomAccess, zzdc, zzel {
    private static final zzbv zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzbv zzbv = new zzbv(new boolean[0], 0);
        zza = zzbv;
        zzbv.zzb();
    }

    public zzbv() {
        this(new boolean[10], 0);
    }

    public static zzbv zzd() {
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzc();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i11));
        }
        boolean[] zArr = this.zzb;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.zzb, i11, zArr2, i11 + 1, this.zzc - i11);
            this.zzb = zArr2;
        }
        this.zzb[i11] = booleanValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzc();
        zzdh.zza(collection);
        if (!(collection instanceof zzbv)) {
            return super.addAll(collection);
        }
        zzbv zzbv = (zzbv) collection;
        int i11 = zzbv.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.zzb;
            if (i13 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(zzbv.zzb, 0, this.zzb, this.zzc, zzbv.zzc);
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
        if (!(obj instanceof zzbv)) {
            return super.equals(obj);
        }
        zzbv zzbv = (zzbv) obj;
        if (this.zzc != zzbv.zzc) {
            return false;
        }
        boolean[] zArr = zzbv.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzf(i11);
        return Boolean.valueOf(this.zzb[i11]);
    }

    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + zzdh.zzf(this.zzb[i12]);
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == booleanValue) {
                return i12;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzc();
        zzf(i11);
        boolean[] zArr = this.zzb;
        boolean z11 = zArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }

    public final void removeRange(int i11, int i12) {
        zzc();
        if (i12 >= i11) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i12, zArr, i11, this.zzc - i12);
            this.zzc -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzc();
        zzf(i11);
        boolean[] zArr = this.zzb;
        boolean z11 = zArr[i11];
        zArr[i11] = booleanValue;
        return Boolean.valueOf(z11);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzdg zze(int i11) {
        if (i11 >= this.zzc) {
            return new zzbv(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzbv(boolean[] zArr, int i11) {
        this.zzb = zArr;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzc();
        int i11 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i11 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        zArr3[i12] = booleanValue;
        return true;
    }
}
