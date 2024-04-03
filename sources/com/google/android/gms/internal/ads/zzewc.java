package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzewc implements zzevn<zzewd> {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final zzcic zze;

    public zzewc(zzcic zzcic, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i11, byte[] bArr) {
        this.zze = zzcic;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i11;
    }

    public final /* synthetic */ zzewd zza(Throwable th2) {
        String str;
        zzbgo.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        return new zzewd((AdvertisingIdClient.Info) null, str);
    }

    public final zzfxa<zzewd> zzb() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaI)).booleanValue()) {
            return zzfwq.zzh(new Exception("Did not ad Ad ID into query param."));
        }
        return zzfwq.zzf((zzfwh) zzfwq.zzo(zzfwq.zzm(zzfwh.zzw(this.zze.zza(this.zza, this.zzd)), zzewb.zza, this.zzc), ((Long) zzbgq.zzc().zzb(zzblj.zzaJ)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzewa(this), this.zzc);
    }
}
