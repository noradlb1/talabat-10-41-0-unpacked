package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

final class zzmg extends Thread {
    final /* synthetic */ AudioTrack zza;
    final /* synthetic */ zzmr zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzmg(zzmr zzmr, String str, AudioTrack audioTrack) {
        super("ExoPlayer:AudioTrackReleaseThread");
        this.zzb = zzmr;
        this.zza = audioTrack;
    }

    public final void run() {
        try {
            this.zza.flush();
            this.zza.release();
        } finally {
            this.zzb.zze.open();
        }
    }
}
