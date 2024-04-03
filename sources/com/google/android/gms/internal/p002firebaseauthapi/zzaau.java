package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
public final class zzaau {
    @Nullable
    private static Boolean zza;

    public static boolean zza(Context context) {
        if (zza == null) {
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            boolean z11 = true;
            if (!(isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2)) {
                z11 = false;
            }
            zza = Boolean.valueOf(z11);
        }
        return zza.booleanValue();
    }
}
