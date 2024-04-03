package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzba implements zzdj {
    private int zzyr = 5;

    public final void setLogLevel(int i11) {
        this.zzyr = i11;
    }

    public final void zza(String str, Throwable th2) {
        if (this.zzyr <= 6) {
            Log.e("GoogleTagManager", str, th2);
        }
    }

    public final void zzab(String str) {
    }

    public final void zzac(String str) {
        if (this.zzyr <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public final void zzav(String str) {
        if (this.zzyr <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public final void zzaw(String str) {
        if (this.zzyr <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public final void zzax(String str) {
    }

    public final void zzb(String str, Throwable th2) {
        if (this.zzyr <= 5) {
            Log.w("GoogleTagManager", str, th2);
        }
    }
}
