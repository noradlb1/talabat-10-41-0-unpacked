package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzli extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        byte[] bArr;
        String str2;
        String str3;
        zzog zzog;
        zzog zzog2;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzog zzog3 = zzoaArr[0];
        zzog zzog4 = zzog.zzaum;
        if (zzog3 == zzog4) {
            return zzog4;
        }
        String zzd = zzha.zzd(zzog3);
        String str4 = "MD5";
        if (zzoaArr.length > 1 && (zzog2 = zzoaArr[1]) != zzog4) {
            str4 = zzha.zzd(zzog2);
        }
        if (zzoaArr.length <= 2 || (zzog = zzoaArr[2]) == zzog4) {
            str = "text";
        } else {
            str = zzha.zzd(zzog);
        }
        if ("text".equals(str)) {
            bArr = zzd.getBytes();
        } else if ("base16".equals(str)) {
            bArr = zzdp.decode(zzd);
        } else {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3 = "Hash: Unknown input format: ".concat(valueOf);
            } else {
                str3 = new String("Hash: Unknown input format: ");
            }
            throw new RuntimeException(str3);
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str4);
            instance.update(bArr);
            return new zzom(zzdp.encode(instance.digest()));
        } catch (NoSuchAlgorithmException e11) {
            String valueOf2 = String.valueOf(str4);
            if (valueOf2.length() != 0) {
                str2 = "Hash: Unknown algorithm: ".concat(valueOf2);
            } else {
                str2 = new String("Hash: Unknown algorithm: ");
            }
            throw new RuntimeException(str2, e11);
        }
    }
}
