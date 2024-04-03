package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
final class zzmq {
    final /* synthetic */ zzmr zza;
    private final Handler zzb = new Handler();
    private final AudioTrack.StreamEventCallback zzc;

    public zzmq(zzmr zzmr) {
        this.zza = zzmr;
        this.zzc = new zzmp(this, zzmr);
    }

    public final void zza(AudioTrack audioTrack) {
        audioTrack.registerStreamEventCallback(new zzmo(this.zzb), this.zzc);
    }

    public final void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages((Object) null);
    }
}
