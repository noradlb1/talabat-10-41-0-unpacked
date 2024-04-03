package com.google.android.gms.internal.ads;

final class zzfml extends zzfmi {
    private String zza;
    private Boolean zzb;
    private Boolean zzc;

    public final zzfmi zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfmi zzb(boolean z11) {
        this.zzc = Boolean.TRUE;
        return this;
    }

    public final zzfmi zzc(boolean z11) {
        this.zzb = Boolean.valueOf(z11);
        return this;
    }

    public final zzfmj zzd() {
        Boolean bool;
        String str = this.zza;
        if (str != null && (bool = this.zzb) != null && this.zzc != null) {
            return new zzfmn(str, bool.booleanValue(), this.zzc.booleanValue(), (zzfmm) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" clientVersion");
        }
        if (this.zzb == null) {
            sb2.append(" shouldGetAdvertisingId");
        }
        if (this.zzc == null) {
            sb2.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
