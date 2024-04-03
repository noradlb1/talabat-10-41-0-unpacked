package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

final class zzas extends ContentObserver {
    private final /* synthetic */ zzaq zzfq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzas(zzaq zzaq, Handler handler) {
        super((Handler) null);
        this.zzfq = zzaq;
    }

    public final void onChange(boolean z11) {
        this.zzfq.zzv();
    }
}
