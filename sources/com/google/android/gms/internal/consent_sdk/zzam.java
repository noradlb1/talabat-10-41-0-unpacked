package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

public final class zzam implements zzcp<zzaj> {
    private final zzct<Application> zza;
    private final zzct<zzal> zzb;
    private final zzct<Executor> zzc;

    public zzam(zzct<Application> zzct, zzct<zzal> zzct2, zzct<Executor> zzct3) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
    }

    public final /* synthetic */ Object zza() {
        return new zzaj(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
