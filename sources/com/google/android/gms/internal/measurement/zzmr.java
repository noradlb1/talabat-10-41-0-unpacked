package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzmr extends zzjl implements RandomAccess {
    private static final zzmr zza = new zzmr(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    public zzmr() {
        this(new Object[10], 0, true);
    }

    public static zzmr zze() {
        return zza;
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

    public final void add(int i11, Object obj) {
        int i12;
        zzbW();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
        Object[] objArr = this.zzb;
        if (i12 < objArr.length) {
            System.arraycopy(objArr, i11, objArr, i11 + 1, i12 - i11);
        } else {
            Object[] objArr2 = new Object[(((i12 * 3) / 2) + 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i11);
            System.arraycopy(this.zzb, i11, objArr2, i11 + 1, this.zzc - i11);
            this.zzb = objArr2;
        }
        this.zzb[i11] = obj;
        this.zzc++;
        this.modCount++;
    }

    public final Object get(int i11) {
        zzg(i11);
        return this.zzb[i11];
    }

    public final Object remove(int i11) {
        zzbW();
        zzg(i11);
        Object[] objArr = this.zzb;
        Object obj = objArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(objArr, i11 + 1, objArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i11, Object obj) {
        zzbW();
        zzg(i11);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzli zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzmr(Arrays.copyOf(this.zzb, i11), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzmr(Object[] objArr, int i11, boolean z11) {
        super(z11);
        this.zzb = objArr;
        this.zzc = i11;
    }

    public final boolean add(Object obj) {
        zzbW();
        int i11 = this.zzc;
        Object[] objArr = this.zzb;
        if (i11 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i11 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        objArr2[i12] = obj;
        this.modCount++;
        return true;
    }
}
