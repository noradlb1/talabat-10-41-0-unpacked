package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;

public final /* synthetic */ class zzbrd implements zzfpv {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbrd(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzbrt<zzcop> zzbrt = zzbrs.zza;
        if (str2 != null) {
            if (zzbmw.zzf.zze().booleanValue()) {
                String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                String host = Uri.parse(str).getHost();
                int i11 = 0;
                while (true) {
                    if (i11 < 3) {
                        if (host.endsWith(strArr[i11])) {
                            break;
                        }
                        i11++;
                    } else {
                        break;
                    }
                }
            }
            String zze = zzbmw.zza.zze();
            String zze2 = zzbmw.zzb.zze();
            if (!TextUtils.isEmpty(zze)) {
                str = str.replace(zze, str2);
            }
            if (!TextUtils.isEmpty(zze2)) {
                Uri parse = Uri.parse(str);
                if (TextUtils.isEmpty(parse.getQueryParameter(zze2))) {
                    return parse.buildUpon().appendQueryParameter(zze2, str2).toString();
                }
            }
        }
        return str;
    }
}
