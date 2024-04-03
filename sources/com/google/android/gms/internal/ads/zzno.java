package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

public final /* synthetic */ class zzno implements Runnable {
    public final /* synthetic */ MediaCodec zza;

    public /* synthetic */ zzno(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    public final void run() {
        this.zza.start();
    }
}
