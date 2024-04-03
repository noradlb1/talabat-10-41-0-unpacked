package com.google.android.gms.internal.icing;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzfm {
    final Unsafe zza;

    public zzfm(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j11, byte b11);

    public abstract boolean zzb(Object obj, long j11);

    public abstract void zzc(Object obj, long j11, boolean z11);

    public abstract float zzd(Object obj, long j11);

    public abstract void zze(Object obj, long j11, float f11);

    public abstract double zzf(Object obj, long j11);

    public abstract void zzg(Object obj, long j11, double d11);

    public final long zzh(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzi(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzj(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzk(Object obj, long j11) {
        return this.zza.getInt(obj, j11);
    }

    public final void zzl(Object obj, long j11, int i11) {
        this.zza.putInt(obj, j11, i11);
    }

    public final long zzm(Object obj, long j11) {
        return this.zza.getLong(obj, j11);
    }

    public final void zzn(Object obj, long j11, long j12) {
        this.zza.putLong(obj, j11, j12);
    }

    public final Object zzo(Object obj, long j11) {
        return this.zza.getObject(obj, j11);
    }

    public final void zzp(Object obj, long j11, Object obj2) {
        this.zza.putObject(obj, j11, obj2);
    }
}
