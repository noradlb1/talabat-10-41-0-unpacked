package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzfkb {
    private final zzfki zza;
    private final zzfki zzb;
    private final zzfkf zzc;
    private final zzfkh zzd;

    private zzfkb(zzfkf zzfkf, zzfkh zzfkh, zzfki zzfki, zzfki zzfki2, boolean z11) {
        this.zzc = zzfkf;
        this.zzd = zzfkh;
        this.zza = zzfki;
        if (zzfki2 == null) {
            this.zzb = zzfki.zzc;
        } else {
            this.zzb = zzfki2;
        }
    }

    public static zzfkb zza(zzfkf zzfkf, zzfkh zzfkh, zzfki zzfki, zzfki zzfki2, boolean z11) {
        zzfli.zzb(zzfkh, "ImpressionType is null");
        zzfli.zzb(zzfki, "Impression owner is null");
        if (zzfki == zzfki.zzc) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfkf == zzfkf.DEFINED_BY_JAVASCRIPT && zzfki == zzfki.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfkh != zzfkh.DEFINED_BY_JAVASCRIPT || zzfki != zzfki.NATIVE) {
            return new zzfkb(zzfkf, zzfkh, zzfki, zzfki2, true);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzflg.zzg(jSONObject, "impressionOwner", this.zza);
        if (this.zzd != null) {
            zzflg.zzg(jSONObject, "mediaEventsOwner", this.zzb);
            zzflg.zzg(jSONObject, "creativeType", this.zzc);
            zzflg.zzg(jSONObject, "impressionType", this.zzd);
        } else {
            zzflg.zzg(jSONObject, "videoEventsOwner", this.zzb);
        }
        zzflg.zzg(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
