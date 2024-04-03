package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzahg;
import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciy;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjr;
import com.google.android.gms.internal.ads.zzfxa;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbs {
    @Deprecated
    public static final zzbn<Void> zza = new zzbk();
    private static zzagv zzb;
    private static final Object zzc = new Object();

    public zzbs(Context context) {
        zzagv zzagv;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzblj.zzc(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcX)).booleanValue()) {
                        zzagv = zzbb.zzb(context);
                        zzb = zzagv;
                    }
                }
                zzagv = zzahz.zza(context, (zzahg) null);
                zzb = zzagv;
            }
        }
    }

    public final zzfxa<zzago> zza(String str) {
        zzcjr zzcjr = new zzcjr();
        zzb.zza(new zzbr(str, (Map<String, String>) null, zzcjr));
        return zzcjr;
    }

    public final zzfxa<String> zzb(int i11, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        String str2 = str;
        zzbp zzbp = new zzbp((zzbo) null);
        zzbl zzbl = new zzbl(this, str2, zzbp);
        zzciy zzciy = new zzciy((String) null);
        zzbm zzbm = new zzbm(this, i11, str, zzbp, zzbl, bArr, map, zzciy);
        if (zzciy.zzl()) {
            try {
                zzciy.zzd(str2, "GET", zzbm.zzl(), zzbm.zzx());
            } catch (zzaga e11) {
                zzciz.zzj(e11.getMessage());
            }
        }
        zzb.zza(zzbm);
        return zzbp;
    }
}
