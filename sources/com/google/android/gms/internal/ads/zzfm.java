package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class zzfm implements ThreadFactory {
    public final /* synthetic */ String zza = "ExoPlayer:Loader:ProgressiveMediaPeriod";

    public /* synthetic */ zzfm(String str) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
