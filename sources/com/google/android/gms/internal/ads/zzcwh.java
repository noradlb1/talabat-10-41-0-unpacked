package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

public final class zzcwh implements zzcvr {
    private final CookieManager zza;

    public zzcwh(Context context) {
        this.zza = zzt.zzq().zzl(context);
    }

    public final void zza(Map<String, String> map) {
        String str;
        if (this.zza != null) {
            if (map.get("clear") != null) {
                String str2 = (String) zzbgq.zzc().zzb(zzblj.zzaC);
                String cookie = this.zza.getCookie(str2);
                if (cookie != null) {
                    List<String> zzf = zzfqp.zzc(zzfps.zzb(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)).zzf(cookie);
                    int i11 = 0;
                    while (i11 < zzf.size()) {
                        CookieManager cookieManager = this.zza;
                        Iterator<String> it = zzfqp.zzc(zzfps.zzb(SignatureVisitor.INSTANCEOF)).zzd(zzf.get(i11)).iterator();
                        it.getClass();
                        if (it.hasNext()) {
                            String valueOf = String.valueOf(it.next());
                            String valueOf2 = String.valueOf((String) zzbgq.zzc().zzb(zzblj.zzar));
                            if (valueOf2.length() != 0) {
                                str = valueOf.concat(valueOf2);
                            } else {
                                str = new String(valueOf);
                            }
                            cookieManager.setCookie(str2, str);
                            i11++;
                        } else {
                            StringBuilder sb2 = new StringBuilder(91);
                            sb2.append("position (0) must be less than the number of elements that remained (");
                            sb2.append(0);
                            sb2.append(")");
                            throw new IndexOutOfBoundsException(sb2.toString());
                        }
                    }
                    return;
                }
                return;
            }
            String str3 = map.get("cookie");
            if (!TextUtils.isEmpty(str3)) {
                this.zza.setCookie((String) zzbgq.zzc().zzb(zzblj.zzaC), str3);
            }
        }
    }
}
