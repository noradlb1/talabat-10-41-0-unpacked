package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzciz;
import java.util.concurrent.Callable;

public final class zzcf {
    @Deprecated
    public static <T> T zza(Context context, Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            T call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th2) {
            zzciz.zzh("Unexpected exception.", th2);
            zzcct.zza(context).zzd(th2, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
