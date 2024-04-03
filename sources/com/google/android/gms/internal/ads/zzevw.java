package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;

public final class zzevw implements zzevm<Bundle> {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzevw(String str, int i11, int i12, int i13, boolean z11, int i14) {
        this.zza = str;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = z11;
        this.zzf = i14;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zza;
        boolean z11 = true;
        zzfeq.zzg(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzb);
        if (this.zzb == -2) {
            z11 = false;
        }
        zzfeq.zzf(bundle, "cnt", valueOf, z11);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle zza2 = zzfeq.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfeq.zza(zza2, SDKCoreEvent.Network.TYPE_NETWORK);
        zza2.putBundle(SDKCoreEvent.Network.TYPE_NETWORK, zza3);
        zza3.putInt("active_network_state", this.zzf);
        zza3.putBoolean("active_network_metered", this.zze);
    }
}
