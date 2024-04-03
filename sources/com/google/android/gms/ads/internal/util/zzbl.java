package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzagw;
import com.google.android.gms.internal.ads.zzahb;
import com.google.android.gms.internal.ads.zzciz;
import org.apache.commons.lang3.StringUtils;

final class zzbl implements zzagw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbp zzb;

    public zzbl(zzbs zzbs, String str, zzbp zzbp) {
        this.zza = str;
        this.zzb = zzbp;
    }

    public final void zza(zzahb zzahb) {
        String str = this.zza;
        String obj = zzahb.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(obj).length());
        sb2.append("Failed to load URL: ");
        sb2.append(str);
        sb2.append(StringUtils.LF);
        sb2.append(obj);
        zzciz.zzj(sb2.toString());
        this.zzb.zza(null);
    }
}
