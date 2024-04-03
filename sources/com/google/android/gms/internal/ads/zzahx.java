package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import datamodels.TypesAliasesKt;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class zzahx extends zzags<String> {
    private final Object zza = new Object();
    @GuardedBy("mLock")
    @Nullable
    private final zzagx<String> zzb;

    public zzahx(int i11, String str, zzagx<String> zzagx, @Nullable zzagw zzagw) {
        super(i11, str, zzagw);
        this.zzb = zzagx;
    }

    public final zzagy<String> zzh(zzago zzago) {
        String str;
        try {
            byte[] bArr = zzago.zzb;
            Map<String, String> map = zzago.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = map.get("Content-Type");
                if (str3 != null) {
                    String[] split = str3.split(TypesAliasesKt.separator, 0);
                    int i11 = 1;
                    while (true) {
                        if (i11 >= split.length) {
                            break;
                        }
                        String[] split2 = split[i11].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i11++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzago.zzb);
        }
        return zzagy.zzb(str, zzahp.zzb(zzago));
    }

    /* renamed from: zzz */
    public void zzo(String str) {
        zzagx<String> zzagx;
        synchronized (this.zza) {
            zzagx = this.zzb;
        }
        zzagx.zza(str);
    }
}
