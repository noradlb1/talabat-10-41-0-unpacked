package com.google.android.libraries.places.internal;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzaek {
    final Unsafe zza;

    public zzaek(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j11);

    public abstract float zzb(Object obj, long j11);

    public abstract void zzc(Object obj, long j11, boolean z11);

    public abstract void zzd(Object obj, long j11, byte b11);

    public abstract void zze(Object obj, long j11, double d11);

    public abstract void zzf(Object obj, long j11, float f11);

    public abstract boolean zzg(Object obj, long j11);

    public final int zzh(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzi(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzj(Object obj, long j11) {
        return this.zza.getInt(obj, j11);
    }

    public final long zzk(Object obj, long j11) {
        return this.zza.getLong(obj, j11);
    }

    public final long zzl(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzm(Object obj, long j11) {
        return this.zza.getObject(obj, j11);
    }

    public final void zzn(Object obj, long j11, int i11) {
        this.zza.putInt(obj, j11, i11);
    }

    public final void zzo(Object obj, long j11, long j12) {
        this.zza.putLong(obj, j11, j12);
    }

    public final void zzp(Object obj, long j11, Object obj2) {
        this.zza.putObject(obj, j11, obj2);
    }
}
