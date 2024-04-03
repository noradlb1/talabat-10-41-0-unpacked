package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzahb;
import com.google.android.gms.internal.ads.zzahg;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzaho;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzaht;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzcis;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

public final class zzbb extends zzahh {
    private final Context zzc;

    private zzbb(Context context, zzahg zzahg) {
        super(zzahg);
        this.zzc = context;
    }

    public static zzagv zzb(Context context) {
        zzagv zzagv = new zzagv(new zzaho(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzbb(context, new zzaht((zzahs) null, (SSLSocketFactory) null)), 4);
        zzagv.zzd();
        return zzagv;
    }

    public final zzago zza(zzags<?> zzags) throws zzahb {
        String str;
        String str2;
        if (zzags.zza() == 0) {
            if (Pattern.matches((String) zzbgq.zzc().zzb(zzblj.zzcY), zzags.zzk())) {
                zzbgo.zzb();
                if (zzcis.zzn(this.zzc, 13400000)) {
                    zzago zza = new zzbtm(this.zzc).zza(zzags);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzags.zzk());
                        if (valueOf.length() != 0) {
                            str2 = "Got gmscore asset response: ".concat(valueOf);
                        } else {
                            str2 = new String("Got gmscore asset response: ");
                        }
                        zze.zza(str2);
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzags.zzk());
                    if (valueOf2.length() != 0) {
                        str = "Failed to get gmscore asset response: ".concat(valueOf2);
                    } else {
                        str = new String("Failed to get gmscore asset response: ");
                    }
                    zze.zza(str);
                }
            }
        }
        return super.zza(zzags);
    }
}
