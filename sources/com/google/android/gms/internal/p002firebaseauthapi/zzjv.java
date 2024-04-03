package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjv  reason: invalid package */
public final class zzjv implements zzca {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzjv(Context context, String str, String str2) {
        if (str != null) {
            this.zzb = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public final void zzb(zzrt zzrt) throws IOException {
        if (!this.zza.putString(this.zzb, zzvt.zza(zzrt.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public final void zzc(zztk zztk) throws IOException {
        if (!this.zza.putString(this.zzb, zzvt.zza(zztk.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
