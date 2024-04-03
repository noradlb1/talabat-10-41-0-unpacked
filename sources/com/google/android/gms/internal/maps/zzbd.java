package com.google.android.gms.internal.maps;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzbd extends zzba {
    static final zzbd zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzbd(objArr, 0, objArr, 0, 0);
    }

    public zzbd(Object[] objArr, int i11, Object[] objArr2, int i12, int i13) {
        this.zzb = objArr;
        this.zze = i11;
        this.zzc = objArr2;
        this.zzf = i12;
        this.zzg = i13;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int zza2 = zzav.zza(obj.hashCode());
                while (true) {
                    int i11 = zza2 & this.zzf;
                    Object obj2 = objArr[i11];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    zza2 = i11 + 1;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    public final int zza(Object[] objArr, int i11) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final int zzc() {
        return 0;
    }

    public final zzbf zzd() {
        return zzg().listIterator(0);
    }

    public final Object[] zze() {
        return this.zzb;
    }

    public final zzaz zzh() {
        return zzaz.zzg(this.zzb, this.zzg);
    }

    public final boolean zzj() {
        return true;
    }
}
