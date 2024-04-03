package com.google.android.gms.internal.ads;

final class zzmu implements zzlw {
    final /* synthetic */ zzmv zza;

    public /* synthetic */ zzmu(zzmv zzmv, zzmt zzmt) {
        this.zza = zzmv;
    }

    public final void zza(Exception exc) {
        zzep.zza("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    public final void zzb() {
        if (this.zza.zzl != null) {
            this.zza.zzl.zzb();
        }
    }
}
