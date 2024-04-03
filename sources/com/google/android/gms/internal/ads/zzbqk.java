package com.google.android.gms.internal.ads;

final class zzbqk extends zzbpl {
    final /* synthetic */ zzbqn zza;

    public /* synthetic */ zzbqk(zzbqn zzbqn, zzbqj zzbqj) {
        this.zza = zzbqn;
    }

    public final void zze(zzbpc zzbpc, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzbpc), str);
        }
    }
}
