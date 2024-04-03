package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzlb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb = "_err";
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzlc zzd;

    public zzlb(zzlc zzlc, String str, String str2, Bundle bundle) {
        this.zzd = zzlc;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zzd.zza.zzF((zzau) Preconditions.checkNotNull(this.zzd.zza.zzv().zzz(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzax().currentTimeMillis(), false, true)), this.zza);
    }
}
