package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
public final class zzok {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzoh zzb = zzoh.zza;
    @Nullable
    private Integer zzc = null;

    public final zzok zza(zzbt zzbt, int i11, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzom(zzbt, i11, str, str2, (zzol) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzok zzb(zzoh zzoh) {
        if (this.zza != null) {
            this.zzb = zzoh;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzok zzc(int i11) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i11);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzoo zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    int zza2 = ((zzom) arrayList.get(i11)).zza();
                    i11++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzoo zzoo = new zzoo(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzon) null);
            this.zza = null;
            return zzoo;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
