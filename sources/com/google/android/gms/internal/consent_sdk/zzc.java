package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import androidx.annotation.GuardedBy;

public abstract class zzc {
    @GuardedBy("AppComponent.class")
    private static zzc zza;

    public interface zza {
        zza zza(Application application);

        zzc zza();
    }

    public static zzc zza(Context context) {
        zzc zzc;
        synchronized (zzc.class) {
            if (zza == null) {
                zza = new zzai((zzaf) null).zza((Application) context.getApplicationContext()).zza();
            }
            zzc = zza;
        }
        return zzc;
    }

    public abstract zzj zza();

    public abstract zzaz zzb();
}
