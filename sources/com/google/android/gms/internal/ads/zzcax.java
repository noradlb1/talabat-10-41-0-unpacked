package com.google.android.gms.internal.ads;

final class zzcax extends zzbpl {
    final /* synthetic */ zzcba zza;

    public /* synthetic */ zzcax(zzcba zzcba, zzcaw zzcaw) {
        this.zza = zzcba;
    }

    public final void zze(zzbpc zzbpc, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzbpc), str);
        }
    }
}
