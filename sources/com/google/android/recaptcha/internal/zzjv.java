package com.google.android.recaptcha.internal;

public final class zzjv extends RuntimeException {
    public zzjv(zzip zzip) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzhp zza() {
        return new zzhp(getMessage());
    }
}
