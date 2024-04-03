package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
public final class zzay {
    public static int zza(Set set) {
        int i11;
        int i12 = 0;
        for (Object next : set) {
            if (next != null) {
                i11 = next.hashCode();
            } else {
                i11 = 0;
            }
            i12 += i11;
        }
        return i12;
    }
}
