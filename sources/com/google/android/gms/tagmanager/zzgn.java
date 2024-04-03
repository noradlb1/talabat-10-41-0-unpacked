package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class zzgn {
    public static zzdz<zzl> zza(zzdz<zzl> zzdz, int... iArr) {
        for (int i11 : iArr) {
            if (!(zzgj.zzh(zzdz.getObject()) instanceof String)) {
                zzdi.zzav("Escaping can only be applied to strings.");
            } else if (i11 != 12) {
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Unsupported Value Escaping: ");
                sb2.append(i11);
                zzdi.zzav(sb2.toString());
            } else {
                zzdz = zza(zzdz);
            }
        }
        return zzdz;
    }

    public static String zzbs(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static zzdz<zzl> zza(zzdz<zzl> zzdz) {
        try {
            return new zzdz<>(zzgj.zzi(zzbs(zzgj.zzc(zzdz.getObject()))), zzdz.zziu());
        } catch (UnsupportedEncodingException e11) {
            zzdi.zza("Escape URI: unsupported encoding", e11);
            return zzdz;
        }
    }
}
