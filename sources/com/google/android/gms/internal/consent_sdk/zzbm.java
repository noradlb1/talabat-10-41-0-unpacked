package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

final /* synthetic */ class zzbm implements Executor {
    private final Handler zza;

    private zzbm(Handler handler) {
        this.zza = handler;
    }

    public static Executor zza(Handler handler) {
        return new zzbm(handler);
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
