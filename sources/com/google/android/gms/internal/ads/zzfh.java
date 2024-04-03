package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;

final class zzfh implements zzeh {
    @Nullable
    private Message zza;
    @Nullable
    private zzfi zzb;

    private zzfh() {
    }

    public /* synthetic */ zzfh(zzfg zzfg) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzfi.zzk(this);
    }

    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        zzd();
    }

    public final zzfh zzb(Message message, zzfi zzfi) {
        this.zza = message;
        this.zzb = zzfi;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        zzd();
        return sendMessageAtFrontOfQueue;
    }
}
