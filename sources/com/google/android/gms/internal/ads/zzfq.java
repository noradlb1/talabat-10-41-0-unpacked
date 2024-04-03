package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class zzfq extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzfs zza;
    private final zzfr zzb;
    private final Handler zzc;

    public zzfq(zzfs zzfs, Handler handler, zzfr zzfr) {
        this.zza = zzfs;
        this.zzc = handler;
        this.zzb = zzfr;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
