package com.google.android.libraries.places.api;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzcu;
import com.google.android.libraries.places.internal.zzcv;
import com.google.android.libraries.places.internal.zzcw;
import com.google.android.libraries.places.internal.zzcy;
import com.google.android.libraries.places.internal.zzdf;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzfm;
import java.util.Locale;

public final class Places {
    private static final zzcy zza = new zzcy();
    @Nullable
    private static volatile zzcw zzb;

    private Places() {
    }

    @RecentlyNonNull
    public static synchronized PlacesClient createClient(@RecentlyNonNull Context context) {
        PlacesClient zza2;
        synchronized (Places.class) {
            try {
                zzfm.zzc(context, "Context must not be null.");
                zza2 = zza(context, zzdf.zzd(context).zze());
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
        return zza2;
    }

    public static synchronized void deinitialize() {
        synchronized (Places.class) {
            zza.zzc();
        }
    }

    public static void initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        try {
            zzb(context, str, (Locale) null, false);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public static synchronized boolean isInitialized() {
        boolean zzf;
        synchronized (Places.class) {
            try {
                zzf = zza.zzf();
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
        return zzf;
    }

    public static synchronized PlacesClient zza(Context context, zzdf zzdf) {
        PlacesClient zzb2;
        synchronized (Places.class) {
            try {
                zzfm.zzc(context, "Context must not be null.");
                zzfm.zzi(isInitialized(), "Places must be initialized first.");
                zzcv zza2 = zzcu.zza();
                zza2.zzc(context);
                zza2.zza(zza);
                zza2.zzb(zzdf);
                zzb2 = zza2.zzd().zzb();
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
        return zzb2;
    }

    public static synchronized void zzb(@RecentlyNonNull Context context, @RecentlyNonNull String str, @Nullable Locale locale, boolean z11) {
        synchronized (Places.class) {
            try {
                zzfm.zzc(context, "Application context must not be null.");
                zzfm.zzc(str, "API Key must not be null.");
                zzfm.zze(!str.isEmpty(), "API Key must not be empty.");
                zzdh.zza(context.getApplicationContext(), false);
                zza.zzd(str, locale, false);
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
    }

    public static synchronized void initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str, @Nullable Locale locale) {
        synchronized (Places.class) {
            try {
                zzb(context, str, locale, false);
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
    }
}
