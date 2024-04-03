package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvw  reason: invalid package */
final class zzvw extends ThreadLocal {
    final /* synthetic */ zzvx zza;

    public zzvw(zzvx zzvx) {
        this.zza = zzvx;
    }

    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzvk.zzb.zza(this.zza.zzb);
            mac.init(this.zza.zzc);
            return mac;
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }
}
