package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

public class zzfpj extends Handler {
    public zzfpj() {
    }

    public final void dispatchMessage(Message message) {
        zza(message);
    }

    @CallSuper
    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzfpj(Looper looper) {
        super(looper);
    }
}
