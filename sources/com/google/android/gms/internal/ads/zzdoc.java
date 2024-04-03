package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public final class zzdoc implements zzdgf, zzo {
    @Nullable
    @VisibleForTesting
    IObjectWrapper zza;
    private final Context zzb;
    @Nullable
    private final zzcop zzc;
    private final zzfdn zzd;
    private final zzcjf zze;
    private final zzbbg zzf;

    public zzdoc(Context context, @Nullable zzcop zzcop, zzfdn zzfdn, zzcjf zzcjf, zzbbg zzbbg) {
        this.zzb = context;
        this.zzc = zzcop;
        this.zzd = zzfdn;
        this.zze = zzcjf;
        this.zzf = zzbbg;
    }

    public final void zzb() {
        zzcop zzcop;
        if (this.zza != null && (zzcop = this.zzc) != null) {
            zzcop.zzd("onSdkImpression", new ArrayMap());
        }
    }

    public final void zzbK() {
    }

    public final void zzbS() {
    }

    public final void zzbz() {
    }

    public final void zze() {
    }

    public final void zzf(int i11) {
        this.zza = null;
    }

    public final void zzn() {
        zzcbn zzcbn;
        zzcbo zzcbo;
        zzcbo zzcbo2;
        zzbbg zzbbg = this.zzf;
        if ((zzbbg == zzbbg.REWARD_BASED_VIDEO_AD || zzbbg == zzbbg.INTERSTITIAL || zzbbg == zzbbg.APP_OPEN) && this.zzd.zzQ && this.zzc != null && zzt.zzh().zzi(this.zzb)) {
            zzcjf zzcjf = this.zze;
            int i11 = zzcjf.zzb;
            int i12 = zzcjf.zzc;
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append(i11);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            sb2.append(i12);
            String sb3 = sb2.toString();
            String zza2 = this.zzd.zzS.zza();
            if (this.zzd.zzS.zzb() == 1) {
                zzcbn = zzcbn.zzc;
                zzcbo = zzcbo.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzV == 2) {
                    zzcbo2 = zzcbo.UNSPECIFIED;
                } else {
                    zzcbo2 = zzcbo.BEGIN_TO_RENDER;
                }
                zzcbo = zzcbo2;
                zzcbn = zzcbn.HTML_DISPLAY;
            }
            IObjectWrapper zza3 = zzt.zzh().zza(sb3, this.zzc.zzI(), "", "javascript", zza2, zzcbo, zzcbn, this.zzd.zzaj);
            this.zza = zza3;
            if (zza3 != null) {
                zzt.zzh().zzg(this.zza, (View) this.zzc);
                this.zzc.zzar(this.zza);
                zzt.zzh().zzh(this.zza);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
