package com.google.android.gms.internal.consent_sdk;

final class zzcm extends zzci {
    private final zzcl zza = new zzcl();

    public final void zza(Throwable th2, Throwable th3) {
        if (th3 == th2) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th3);
        } else if (th3 != null) {
            this.zza.zza(th2, true).add(th3);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
