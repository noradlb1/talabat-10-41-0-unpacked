package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

final class zabh extends zau {
    final /* synthetic */ zabi zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zabh(zabi zabi, Looper looper) {
        super(looper);
        this.zaa = zabi;
    }

    public final void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            ((zabg) message.obj).zab(this.zaa);
        } else if (i11 != 2) {
            Log.w("GACStateManager", "Unknown message id: " + i11);
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
