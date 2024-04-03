package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzebo {
    private final zzebb zza;
    private final zzdwt zzb;
    private final Object zzc = new Object();
    @GuardedBy("lock")
    private final List<zzebn> zzd;
    @GuardedBy("lock")
    private boolean zze;

    public zzebo(zzebb zzebb, zzdwt zzdwt) {
        this.zza = zzebb;
        this.zzb = zzdwt;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List<zzbtn> list) {
        String zzcab;
        synchronized (this.zzc) {
            if (!this.zze) {
                for (zzbtn next : list) {
                    List<zzebn> list2 = this.zzd;
                    String str = next.zza;
                    zzdws zza2 = this.zzb.zza(str);
                    if (zza2 == null) {
                        zzcab = "";
                    } else {
                        zzcab zzcab2 = zza2.zzb;
                        if (zzcab2 == null) {
                            zzcab = "";
                        } else {
                            zzcab = zzcab2.toString();
                        }
                    }
                    String str2 = zzcab;
                    boolean z11 = next.zzb;
                    list2.add(new zzebn(str, str2, z11 ? 1 : 0, next.zzd, next.zzc));
                }
                this.zze = true;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzs()) {
                    zzd(this.zza.zzf());
                } else {
                    zzc();
                    return jSONArray;
                }
            }
            for (zzebn zza2 : this.zzd) {
                jSONArray.put((Object) zza2.zza());
            }
            return jSONArray;
        }
    }

    public final void zzc() {
        this.zza.zzr(new zzebm(this));
    }
}
