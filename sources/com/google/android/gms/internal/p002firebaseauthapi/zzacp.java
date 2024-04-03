package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacp  reason: invalid package */
final class zzacp extends zzady {
    private final String zza;
    private final String zzb;

    public zzacp(@Nullable String str, @Nullable String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzady) {
            zzady zzady = (zzady) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzady.zzb()) : zzady.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzady.zza()) : zzady.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        String str = this.zza;
        int i12 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return ((i11 ^ 1000003) * 1000003) ^ i12;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "RecaptchaEnforcementState{provider=" + str + ", enforcementState=" + str2 + "}";
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    @Nullable
    public final String zzb() {
        return this.zza;
    }
}
