package com.google.android.gms.internal.consent_sdk;

final /* synthetic */ class zzbd implements Runnable {
    private final zzbe zza;
    private final String zzb;

    public zzbd(zzbe zzbe, String str) {
        this.zza = zzbe;
        this.zzb = str;
    }

    public final void run() {
        zzch.zza(this.zza, this.zzb);
    }
}
