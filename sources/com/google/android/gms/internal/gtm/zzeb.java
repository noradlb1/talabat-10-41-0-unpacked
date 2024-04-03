package com.google.android.gms.internal.gtm;

import android.util.Log;

public final class zzeb implements zzew {
    private boolean zzani = true;
    private int zzyr = 5;

    private final boolean isLoggable(int i11) {
        if (!this.zzani || !Log.isLoggable("GoogleTagManager", i11)) {
            return !this.zzani && this.zzyr <= i11;
        }
        return true;
    }

    public final void zza(String str, Throwable th2) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str, th2);
        }
    }

    public final void zzab(String str) {
        isLoggable(2);
    }

    public final void zzac(String str) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str);
        }
    }

    public final void zzav(String str) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str);
        }
    }

    public final void zzaw(String str) {
        if (isLoggable(4)) {
            Log.i("GoogleTagManager", str);
        }
    }

    public final void zzb(String str, Throwable th2) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str, th2);
        }
    }
}
