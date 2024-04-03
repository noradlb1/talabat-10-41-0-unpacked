package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

final class zzaxa implements ThreadFactory {
    final /* synthetic */ String zza = "Loader:ExtractorMediaPeriod";

    public zzaxa(String str) {
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
