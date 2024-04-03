package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbwk implements zzbsg {
    final /* synthetic */ zzbwl zza;
    private final zzbvn zzb;
    private final zzcjr zzc;

    public zzbwk(zzbwl zzbwl, zzbvn zzbvn, zzcjr zzcjr) {
        this.zza = zzbwl;
        this.zzb = zzbvn;
        this.zzc = zzcjr;
    }

    public final void zza(@Nullable String str) {
        zzbvn zzbvn;
        if (str == null) {
            try {
                this.zzc.zze(new zzbvw());
            } catch (IllegalStateException unused) {
                zzbvn = this.zzb;
            } catch (Throwable th2) {
                this.zzb.zzb();
                throw th2;
            }
        } else {
            this.zzc.zze(new zzbvw(str));
        }
        zzbvn = this.zzb;
        zzbvn.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        zzbvn zzbvn;
        try {
            this.zzc.zzd(this.zza.zza.zza(jSONObject));
            zzbvn = this.zzb;
        } catch (IllegalStateException unused) {
            zzbvn = this.zzb;
        } catch (JSONException e11) {
            this.zzc.zze(e11);
            zzbvn = this.zzb;
        } catch (Throwable th2) {
            this.zzb.zzb();
            throw th2;
        }
        zzbvn.zzb();
    }
}
