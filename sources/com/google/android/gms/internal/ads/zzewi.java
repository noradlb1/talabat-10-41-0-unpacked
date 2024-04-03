package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

public final class zzewi implements zzevn<zzewj> {
    private final Executor zza;
    private final String zzb;
    @Nullable
    private final PackageInfo zzc;
    private final zzcic zzd;

    public zzewi(zzcic zzcic, Executor executor, String str, @Nullable PackageInfo packageInfo, int i11, byte[] bArr) {
        this.zzd = zzcic;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final /* synthetic */ zzfxa zza(Throwable th2) throws Exception {
        return zzfwq.zzi(new zzewj(this.zzb));
    }

    public final zzfxa<zzewj> zzb() {
        return zzfwq.zzg(zzfwq.zzm(zzfwq.zzi(this.zzb), zzewg.zza, this.zza), Throwable.class, new zzewh(this), this.zza);
    }
}
