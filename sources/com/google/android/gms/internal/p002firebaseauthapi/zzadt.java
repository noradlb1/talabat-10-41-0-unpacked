package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
public final class zzadt {
    public static long zza(String str) {
        Preconditions.checkNotEmpty(str);
        List zzd = zzab.zzb(zzj.zzb('.')).zzd(str);
        if (zzd.size() >= 2) {
            try {
                zzadu zza = zzadu.zza(new String(Base64Utils.decodeUrlSafeNoPadding((String) zzd.get(1)), "UTF-8"));
                return zza.zzb().longValue() - zza.zzc().longValue();
            } catch (UnsupportedEncodingException e11) {
                throw new RuntimeException("Unable to decode token", e11);
            }
        } else {
            throw new RuntimeException("Invalid idToken ".concat(String.valueOf(str)));
        }
    }
}
