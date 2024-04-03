package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;

final class zzfr implements zzfq {
    private Handler handler;
    final /* synthetic */ zzfn zzakz;

    private zzfr(zzfn zzfn) {
        this.zzakz = zzfn;
        this.handler = new zzdj(zzfn.zzako.getMainLooper(), new zzfs(this));
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfn.zzakn);
    }

    public final void cancel() {
        this.handler.removeMessages(1, zzfn.zzakn);
    }

    public final void zzh(long j11) {
        this.handler.removeMessages(1, zzfn.zzakn);
        this.handler.sendMessageDelayed(obtainMessage(), j11);
    }

    public final void zzjt() {
        this.handler.removeMessages(1, zzfn.zzakn);
        this.handler.sendMessage(obtainMessage());
    }

    public /* synthetic */ zzfr(zzfn zzfn, zzfo zzfo) {
        this(zzfn);
    }
}
