package com.google.android.gms.internal.icing;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public final class zzbi<T> {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    @Nullable
    private static volatile zzbh zzc = null;
    private static volatile boolean zzd = false;
    private static final AtomicReference<Collection<zzbi<?>>> zze = new AtomicReference<>();
    private static final zzbk zzf = new zzbk(zzbg.zza);
    private static final AtomicInteger zzg = new AtomicInteger();

    @Deprecated
    public static void zza(Context context) {
        synchronized (zzb) {
            zzbh zzbh = zzc;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzbh == null || zzbh.zza() != context) {
                zzbe.zza();
                zzbj.zza();
                zzc = new zzbd(context, zzbo.zza(new zzbf(context)));
                zzg.incrementAndGet();
            }
        }
    }
}
