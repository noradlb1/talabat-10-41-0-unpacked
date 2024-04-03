package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import java.util.Locale;

public final class zzcy {
    @Nullable
    private volatile String zza;
    @Nullable
    private volatile Locale zzb;
    private volatile boolean zzc;

    public final synchronized String zza() {
        zzfm.zzi(zzf(), "ApiConfig must be initialized.");
        return this.zza;
    }

    public final synchronized Locale zzb() {
        Locale locale;
        zzfm.zzi(zzf(), "ApiConfig must be initialized.");
        if (this.zzb == null) {
            locale = Locale.getDefault();
        } else {
            locale = this.zzb;
        }
        return locale;
    }

    public final synchronized void zzc() {
        this.zza = null;
        this.zzb = null;
    }

    public final synchronized void zzd(String str, @Nullable Locale locale, boolean z11) {
        zzfm.zzc(str, "API Key must not be null.");
        zzfm.zze(!str.isEmpty(), "API Key must not be empty.");
        this.zza = str;
        this.zzb = locale;
        this.zzc = false;
    }

    public final boolean zze() {
        return false;
    }

    public final synchronized boolean zzf() {
        return this.zza != null;
    }
}
