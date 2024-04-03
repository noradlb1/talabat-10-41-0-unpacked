package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzaoy extends Handler {
    final /* synthetic */ zzaoz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaoy(zzaoz zzaoz, Looper looper) {
        super(looper);
        this.zza = zzaoz;
    }

    public final void handleMessage(Message message) {
        this.zza.zzs(message);
    }
}
