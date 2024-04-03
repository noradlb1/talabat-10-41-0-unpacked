package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfpj;

public final class zzf extends zzfpj {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e11) {
            zzt.zzo().zzs(e11, "AdMobHandler.handleMessage");
        }
    }

    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th2) {
            zzt.zzp();
            zzt.zzP(zzt.zzo().zzc(), th2);
            throw th2;
        }
    }
}
