package com.google.android.recaptcha.internal;

import java.io.IOException;

public final class zzfr extends IOException {
    public zzfr() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzfr(String str, Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th2);
    }

    public zzfr(Throwable th2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
    }
}
