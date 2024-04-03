package com.google.android.gms.internal.ads;

import com.facebook.internal.security.CertificateUtil;

public final class zzgpe extends zzgpj {
    final String zza;

    public zzgpe(String str) {
        this.zza = str;
    }

    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb2.append(str2);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(str);
    }
}
