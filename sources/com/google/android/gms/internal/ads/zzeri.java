package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

public final class zzeri implements zzevn {
    private static final Object zza = new Object();
    private final String zzb;
    private final String zzc;
    private final zzdci zzd;
    private final zzffd zze;
    private final zzfef zzf;
    private final zzg zzg = zzt.zzo().zzh();

    public zzeri(String str, String str2, zzdci zzdci, zzffd zzffd, zzfef zzfef) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzdci;
        this.zze = zzffd;
        this.zzf = zzfef;
    }

    public final /* synthetic */ void zza(Bundle bundle, Bundle bundle2) {
        String str;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdZ)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdY)).booleanValue()) {
                synchronized (zza) {
                    this.zzd.zzg(this.zzf.zzd);
                    bundle2.putBundle("quality_signals", this.zze.zzb());
                }
            } else {
                this.zzd.zzg(this.zzf.zzd);
                bundle2.putBundle("quality_signals", this.zze.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzb);
        if (this.zzg.zzL()) {
            str = "";
        } else {
            str = this.zzc;
        }
        bundle2.putString("session_id", str);
    }

    public final zzfxa zzb() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdZ)).booleanValue()) {
            this.zzd.zzg(this.zzf.zzd);
            bundle.putAll(this.zze.zzb());
        }
        return zzfwq.zzi(new zzerh(this, bundle));
    }
}
