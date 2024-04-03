package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbws implements zzbsg {
    final /* synthetic */ zzbwt zza;
    private final zzcjr zzb;

    public zzbws(zzbwt zzbwt, zzcjr zzcjr) {
        this.zza = zzbwt;
        this.zzb = zzcjr;
    }

    public final void zza(@Nullable String str) {
        if (str == null) {
            try {
                this.zzb.zze(new zzbvw());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zze(new zzbvw(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzd(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e11) {
            this.zzb.zze(e11);
        }
    }
}
