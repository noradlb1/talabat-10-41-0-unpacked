package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

public final class zzff implements zzdz {
    public final zzei zza(Looper looper, @Nullable Handler.Callback callback) {
        return new zzfi(new Handler(looper, callback));
    }
}
