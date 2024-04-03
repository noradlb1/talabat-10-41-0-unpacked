package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz  reason: invalid package */
final class zzvz extends ThreadLocal {
    public final /* synthetic */ Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
