package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzedg implements zzeef {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzech zzb;
    private final zzfxb zzc;
    private final zzfef zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzegl zzf;

    public zzedg(zzfef zzfef, zzech zzech, zzfxb zzfxb, ScheduledExecutorService scheduledExecutorService, zzegl zzegl) {
        this.zzd = zzfef;
        this.zzb = zzech;
        this.zzc = zzfxb;
        this.zze = scheduledExecutorService;
        this.zzf = zzegl;
    }

    public final zzfxa<zzfdz> zzb(zzcdq zzcdq) {
        zzfxa<zzfdz> zzn = zzfwq.zzn(this.zzb.zzb(zzcdq), new zzedd(this), this.zzc);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdV)).booleanValue()) {
            Class<TimeoutException> cls = TimeoutException.class;
            zzn = zzfwq.zzg(zzfwq.zzo(zzn, (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdW)).intValue(), TimeUnit.SECONDS, this.zze), cls, zzede.zza, zzcjm.zzf);
        }
        zzfwq.zzr(zzn, new zzedf(this), zzcjm.zzf);
        return zzn;
    }

    public final /* synthetic */ zzfxa zzc(InputStream inputStream) throws Exception {
        return zzfwq.zzi(new zzfdz(new zzfdw(this.zzd), zzfdy.zza(new InputStreamReader(inputStream))));
    }
}
