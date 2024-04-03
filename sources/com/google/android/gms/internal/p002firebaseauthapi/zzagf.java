package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
public final class zzagf extends IOException {
    public zzagf() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzagf(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzagf(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
