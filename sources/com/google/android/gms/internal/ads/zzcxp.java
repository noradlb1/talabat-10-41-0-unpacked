package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxp implements zzaya {
    private zzcop zza;
    private final Executor zzb;
    private final zzcxb zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcxe zzg = new zzcxe();

    public zzcxp(Executor executor, zzcxb zzcxb, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcxb;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcxo(this, zza2));
            }
        } catch (JSONException e11) {
            zze.zzb("Failed to call video active view js", e11);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    public final void zzc(zzaxz zzaxz) {
        boolean z11;
        zzcxe zzcxe = this.zzg;
        if (this.zzf) {
            z11 = false;
        } else {
            z11 = zzaxz.zzj;
        }
        zzcxe.zza = z11;
        zzcxe.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzaxz;
        if (this.zze) {
            zzg();
        }
    }

    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zze(boolean z11) {
        this.zzf = z11;
    }

    public final void zzf(zzcop zzcop) {
        this.zza = zzcop;
    }
}
