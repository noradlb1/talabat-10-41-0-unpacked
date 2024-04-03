package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Map;

public final class zzduj implements zzbrt<Object> {
    @Nullable
    private final zzbpm zza;
    private final zzduy zzb;
    private final zzgpl<zzduf> zzc;

    public zzduj(zzdqn zzdqn, zzdqc zzdqc, zzduy zzduy, zzgpl<zzduf> zzgpl) {
        this.zza = zzdqn.zzc(zzdqc.zzy());
        this.zzb = zzduy;
        this.zzc = zzgpl;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zza.zze(this.zzc.zzb(), str);
        } catch (RemoteException e11) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40);
            sb2.append("Failed to call onCustomClick for asset ");
            sb2.append(str);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            zzciz.zzk(sb2.toString(), e11);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzi("/nativeAdCustomClick", this);
        }
    }
}
