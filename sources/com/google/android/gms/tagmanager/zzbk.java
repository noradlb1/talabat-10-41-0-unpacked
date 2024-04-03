package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzbk extends zzbq {
    private static final String ID = zza.ENCODE.toString();
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzagt = zzb.NO_PADDING.toString();
    private static final String zzagu = zzb.INPUT_FORMAT.toString();
    private static final String zzagv = zzb.OUTPUT_FORMAT.toString();

    public zzbk() {
        super(ID, zzags);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        String str2;
        int i11;
        byte[] bArr;
        String str3;
        String str4;
        String str5;
        zzl zzl = map.get(zzags);
        if (zzl == null || zzl == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzl);
        zzl zzl2 = map.get(zzagu);
        if (zzl2 == null) {
            str = "text";
        } else {
            str = zzgj.zzc(zzl2);
        }
        zzl zzl3 = map.get(zzagv);
        if (zzl3 == null) {
            str2 = "base16";
        } else {
            str2 = zzgj.zzc(zzl3);
        }
        zzl zzl4 = map.get(zzagt);
        if (zzl4 == null || !zzgj.zzg(zzl4).booleanValue()) {
            i11 = 2;
        } else {
            i11 = 3;
        }
        try {
            if ("text".equals(str)) {
                bArr = zzc.getBytes();
            } else if ("base16".equals(str)) {
                bArr = zzo.decode(zzc);
            } else if ("base64".equals(str)) {
                bArr = Base64.decode(zzc, i11);
            } else if ("base64url".equals(str)) {
                bArr = Base64.decode(zzc, i11 | 8);
            } else {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str5 = "Encode: unknown input format: ".concat(valueOf);
                } else {
                    str5 = new String("Encode: unknown input format: ");
                }
                zzdi.zzav(str5);
                return zzgj.zzkc();
            }
            if ("base16".equals(str2)) {
                str3 = zzo.encode(bArr);
            } else if ("base64".equals(str2)) {
                str3 = Base64.encodeToString(bArr, i11);
            } else if ("base64url".equals(str2)) {
                str3 = Base64.encodeToString(bArr, i11 | 8);
            } else {
                String valueOf2 = String.valueOf(str2);
                if (valueOf2.length() != 0) {
                    str4 = "Encode: unknown output format: ".concat(valueOf2);
                } else {
                    str4 = new String("Encode: unknown output format: ");
                }
                zzdi.zzav(str4);
                return zzgj.zzkc();
            }
            return zzgj.zzi(str3);
        } catch (IllegalArgumentException unused) {
            zzdi.zzav("Encode: invalid input:");
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
