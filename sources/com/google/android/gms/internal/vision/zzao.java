package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

final class zzao extends ContentObserver {
    public zzao(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z11) {
        zzal.zzew.set(true);
    }
}
