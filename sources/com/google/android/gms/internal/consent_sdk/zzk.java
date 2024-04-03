package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.FormError;

public final class zzk extends Exception {
    private final int zza;

    public zzk(int i11, String str) {
        super(str);
        this.zza = i11;
    }

    public final String getMessage() {
        return super.getMessage();
    }

    public final FormError zza() {
        if (getCause() == null) {
            Log.w("UserMessagingPlatform", getMessage());
        } else {
            Log.w("UserMessagingPlatform", getMessage(), getCause());
        }
        return new FormError(this.zza, getMessage());
    }

    public zzk(int i11, String str, Throwable th2) {
        super(str, th2);
        this.zza = i11;
    }
}
