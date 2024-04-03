package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zzm extends zzgh {
    private static final String ID;
    private static final String URL = zzb.URL.toString();
    private static final String zzadw = zzb.ADDITIONAL_PARAMS.toString();
    private static final String zzadx = zzb.UNREPEATABLE.toString();
    private static final String zzady;
    private static final Set<String> zzadz = new HashSet();
    private final zza zzaea;
    private final Context zzrm;

    public interface zza {
        zzbx zzgx();
    }

    static {
        String zza2 = com.google.android.gms.internal.gtm.zza.ARBITRARY_PIXEL.toString();
        ID = zza2;
        StringBuilder sb2 = new StringBuilder(String.valueOf(zza2).length() + 17);
        sb2.append("gtm_");
        sb2.append(zza2);
        sb2.append("_unrepeatable");
        zzady = sb2.toString();
    }

    public zzm(Context context) {
        this(context, new zzn(context));
    }

    private final synchronized boolean zzak(String str) {
        Set<String> set = zzadz;
        if (set.contains(str)) {
            return true;
        }
        if (!this.zzrm.getSharedPreferences(zzady, 0).contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }

    public final void zzd(Map<String, zzl> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = zzadx;
        if (map.get(str5) != null) {
            str = zzgj.zzc(map.get(str5));
        } else {
            str = null;
        }
        if (str == null || !zzak(str)) {
            Uri.Builder buildUpon = Uri.parse(zzgj.zzc(map.get(URL))).buildUpon();
            zzl zzl = map.get(zzadw);
            if (zzl != null) {
                Object zzh = zzgj.zzh(zzl);
                if (!(zzh instanceof List)) {
                    String valueOf = String.valueOf(buildUpon.build().toString());
                    if (valueOf.length() != 0) {
                        str4 = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(valueOf);
                    } else {
                        str4 = new String("ArbitraryPixel: additional params not a list: not sending partial hit: ");
                    }
                    zzdi.zzav(str4);
                    return;
                }
                for (Object next : (List) zzh) {
                    if (!(next instanceof Map)) {
                        String valueOf2 = String.valueOf(buildUpon.build().toString());
                        if (valueOf2.length() != 0) {
                            str3 = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(valueOf2);
                        } else {
                            str3 = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: ");
                        }
                        zzdi.zzav(str3);
                        return;
                    }
                    for (Map.Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.zzaea.zzgx().zzay(uri);
            String valueOf3 = String.valueOf(uri);
            if (valueOf3.length() != 0) {
                str2 = "ArbitraryPixel: url = ".concat(valueOf3);
            } else {
                str2 = new String("ArbitraryPixel: url = ");
            }
            zzdi.zzab(str2);
            if (str != null) {
                synchronized (zzm.class) {
                    zzadz.add(str);
                    zzft.zza(this.zzrm, zzady, str, "true");
                }
            }
        }
    }

    @VisibleForTesting
    private zzm(Context context, zza zza2) {
        super(ID, URL);
        this.zzaea = zza2;
        this.zzrm = context;
    }
}
