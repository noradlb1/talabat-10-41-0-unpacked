package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

public final class zzbsa implements zzbrt<zzcop> {
    static final Map<String, Integer> zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzb zzb;
    private final zzcak zzc;
    private final zzcar zzd;

    public zzbsa(zzb zzb2, zzcak zzcak, zzcar zzcar) {
        this.zzb = zzb2;
        this.zzc = zzcak;
        this.zzd = zzcar;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        int intValue = zza.get((String) map.get("a")).intValue();
        int i11 = 6;
        boolean z11 = true;
        if (intValue != 5) {
            if (intValue != 7) {
                if (!this.zzb.zzc()) {
                    this.zzb.zzb((String) null);
                    return;
                } else if (intValue == 1) {
                    this.zzc.zzb(map);
                    return;
                } else if (intValue == 3) {
                    new zzcan(zzcop, map).zzb();
                    return;
                } else if (intValue == 4) {
                    new zzcai(zzcop, map).zzc();
                    return;
                } else if (intValue != 5) {
                    if (intValue == 6) {
                        this.zzc.zza(true);
                        return;
                    } else if (intValue != 7) {
                        zzciz.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            z11 = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        }
        if (zzcop == null) {
            zzciz.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i11 = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            if (z11) {
                i11 = -1;
            } else {
                i11 = zzt.zzq().zzg();
            }
        }
        zzcop.zzas(i11);
    }
}
