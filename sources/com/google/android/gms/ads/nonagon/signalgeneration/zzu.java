package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfwm;

final class zzu implements zzfwm<zzah> {
    final /* synthetic */ zzv zza;

    public zzu(zzv zzv) {
        this.zza = zzv;
    }

    public final void zza(Throwable th2) {
        zzt.zzo().zzs(th2, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzv.zzy(this.zza, "sgf", "sgf_reason", th2.getMessage());
        zzciz.zzh("Failed to initialize webview for loading SDKCore. ", th2);
    }

    public final /* synthetic */ void zzb(@Nullable Object obj) {
        zzah zzah = (zzah) obj;
        zzciz.zze("Initialized webview successfully for SDKCore.");
    }
}
