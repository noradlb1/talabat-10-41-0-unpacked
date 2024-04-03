package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

final class zzbv extends zzbq {
    private static final String ID = zza.HASH.toString();
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzagu = zzb.INPUT_FORMAT.toString();
    private static final String zzagx = zzb.ALGORITHM.toString();

    public zzbv() {
        super(ID, zzags);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        String str2;
        byte[] bArr;
        String str3;
        String str4;
        zzl zzl = map.get(zzags);
        if (zzl == null || zzl == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzl);
        zzl zzl2 = map.get(zzagx);
        if (zzl2 == null) {
            str = "MD5";
        } else {
            str = zzgj.zzc(zzl2);
        }
        zzl zzl3 = map.get(zzagu);
        if (zzl3 == null) {
            str2 = "text";
        } else {
            str2 = zzgj.zzc(zzl3);
        }
        if ("text".equals(str2)) {
            bArr = zzc.getBytes();
        } else if ("base16".equals(str2)) {
            bArr = zzo.decode(zzc);
        } else {
            String valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str4 = "Hash: unknown input format: ".concat(valueOf);
            } else {
                str4 = new String("Hash: unknown input format: ");
            }
            zzdi.zzav(str4);
            return zzgj.zzkc();
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return zzgj.zzi(zzo.encode(instance.digest()));
        } catch (NoSuchAlgorithmException unused) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str3 = "Hash: unknown algorithm: ".concat(valueOf2);
            } else {
                str3 = new String("Hash: unknown algorithm: ");
            }
            zzdi.zzav(str3);
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
