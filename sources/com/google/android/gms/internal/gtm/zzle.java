package com.google.android.gms.internal.gtm;

import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;

public final class zzle extends zzhb {
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        String str4;
        String str5;
        String str6;
        boolean z12 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        String zzd = zzha.zzd(zzoaArr[0]);
        if (zzoaArr.length > 1) {
            str = zzha.zzd(zzoaArr[1]);
        } else {
            str = "text";
        }
        int i11 = 2;
        if (zzoaArr.length > 2) {
            str2 = zzha.zzd(zzoaArr[2]);
        } else {
            str2 = "base16";
        }
        if (zzoaArr.length <= 3 || !zzha.zza(zzoaArr[3])) {
            z12 = false;
        }
        if (z12) {
            i11 = 3;
        }
        try {
            if ("text".equals(str)) {
                bArr = zzd.getBytes();
            } else if ("base16".equals(str)) {
                bArr = zzdp.decode(zzd);
            } else if ("base64".equals(str)) {
                bArr = Base64.decode(zzd, i11);
            } else if ("base64url".equals(str)) {
                bArr = Base64.decode(zzd, i11 | 8);
            } else {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str6 = "Encode: unknown input format: ".concat(valueOf);
                } else {
                    str6 = new String("Encode: unknown input format: ");
                }
                throw new UnsupportedOperationException(str6);
            }
            if ("base16".equals(str2)) {
                str4 = zzdp.encode(bArr);
            } else if ("base64".equals(str2)) {
                str4 = Base64.encodeToString(bArr, i11);
            } else if ("base64url".equals(str2)) {
                str4 = Base64.encodeToString(bArr, i11 | 8);
            } else {
                String valueOf2 = String.valueOf(str2);
                if (valueOf2.length() != 0) {
                    str5 = "Encode: unknown output format: ".concat(valueOf2);
                } else {
                    str5 = new String("Encode: unknown output format: ");
                }
                throw new RuntimeException(str5);
            }
            return new zzom(str4);
        } catch (IllegalArgumentException unused) {
            String valueOf3 = String.valueOf(str);
            if (valueOf3.length() != 0) {
                str3 = "Encode: invalid input:".concat(valueOf3);
            } else {
                str3 = new String("Encode: invalid input:");
            }
            throw new RuntimeException(str3);
        }
    }
}
