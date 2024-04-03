package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zznu extends Handler {
    final /* synthetic */ zznw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zznu(zznw zznw, Looper looper) {
        super(looper);
        this.zza = zznw;
    }

    public final void handleMessage(Message message) {
        zznw.zza(this.zza, message);
    }
}
