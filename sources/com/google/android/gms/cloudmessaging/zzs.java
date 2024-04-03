package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzs {
    @GuardedBy("MessengerIpcClient.class")
    @Nullable
    private static zzs zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    @GuardedBy("this")
    private zzm zzd = new zzm(this, (zzl) null);
    @GuardedBy("this")
    private int zze = 1;

    @VisibleForTesting
    public zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzs zzb(Context context) {
        zzs zzs;
        synchronized (zzs.class) {
            if (zza == null) {
                zze.zza();
                zza = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzs = zza;
        }
        return zzs;
    }

    private final synchronized int zzf() {
        int i11;
        i11 = this.zze;
        this.zze = i11 + 1;
        return i11;
    }

    private final synchronized <T> Task<T> zzg(zzp<T> zzp) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzp);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append("Queueing ");
            sb2.append(valueOf);
        }
        if (!this.zzd.zzg(zzp)) {
            zzm zzm = new zzm(this, (zzl) null);
            this.zzd = zzm;
            zzm.zzg(zzp);
        }
        return zzp.zzb.getTask();
    }

    public final Task<Void> zzc(int i11, Bundle bundle) {
        return zzg(new zzo(zzf(), 2, bundle));
    }

    public final Task<Bundle> zzd(int i11, Bundle bundle) {
        return zzg(new zzr(zzf(), 1, bundle));
    }
}
