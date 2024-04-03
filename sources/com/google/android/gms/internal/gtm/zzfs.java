package com.google.android.gms.internal.gtm;

import android.os.Handler;
import android.os.Message;

final class zzfs implements zzfr {
    private Handler handler;
    final /* synthetic */ zzfo zzapm;

    private zzfs(zzfo zzfo) {
        this.zzapm = zzfo;
        this.handler = new zzdj(zzfo.zzako.getMainLooper(), new zzft(this));
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfo.zzakn);
    }

    public final void cancel() {
        this.handler.removeMessages(1, zzfo.zzakn);
    }

    public final void zzh(long j11) {
        this.handler.removeMessages(1, zzfo.zzakn);
        this.handler.sendMessageDelayed(obtainMessage(), j11);
    }

    public final void zzjt() {
        this.handler.removeMessages(1, zzfo.zzakn);
        this.handler.sendMessage(obtainMessage());
    }

    public /* synthetic */ zzfs(zzfo zzfo, zzfp zzfp) {
        this(zzfo);
    }
}
