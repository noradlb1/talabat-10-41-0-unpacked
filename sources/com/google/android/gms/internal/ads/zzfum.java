package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzfum<E> extends zzftc<E> {
    static final zzfum<Object> zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzfum(objArr, 0, objArr, 0, 0);
    }

    public zzfum(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.zzb = objArr;
        this.zze = i11;
        this.zzc = objArr2;
        this.zzf = i12;
        this.zzg = i13;
    }

    public final boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zzb2 = zzfsk.zzb(obj);
        while (true) {
            int i11 = zzb2 & this.zzf;
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzb2 = i11 + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, i11, this.zzg);
        return i11 + this.zzg;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final int zzc() {
        return 0;
    }

    public final zzfuu<E> zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final Object[] zzg() {
        return this.zzb;
    }

    public final zzfss<E> zzi() {
        return zzfss.zzk(this.zzb, this.zzg);
    }

    public final boolean zzo() {
        return true;
    }
}
