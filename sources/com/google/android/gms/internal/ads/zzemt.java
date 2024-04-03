package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzdgb;
import java.util.Iterator;

public final class zzemt<AdT, AdapterT, ListenerT extends zzdgb> implements zzeht<AdT> {
    private final zzehv<AdapterT, ListenerT> zza;
    private final zzeib<AdT, AdapterT, ListenerT> zzb;
    private final zzfie zzc;
    private final zzfxb zzd;

    public zzemt(zzfie zzfie, zzfxb zzfxb, zzehv<AdapterT, ListenerT> zzehv, zzeib<AdT, AdapterT, ListenerT> zzeib) {
        this.zzc = zzfie;
        this.zzd = zzfxb;
        this.zzb = zzeib;
        this.zza = zzehv;
    }

    @VisibleForTesting
    public static final String zze(String str, int i11) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 31);
        sb2.append("Error from: ");
        sb2.append(str);
        sb2.append(", code: ");
        sb2.append(i11);
        return sb2.toString();
    }

    public final zzfxa<AdT> zza(zzfdz zzfdz, zzfdn zzfdn) {
        zzehw<AdapterT, ListenerT> zzehw;
        Iterator<String> it = zzfdn.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzehw = null;
                break;
            }
            try {
                zzehw = this.zza.zza(it.next(), zzfdn.zzw);
                break;
            } catch (zzfek unused) {
            }
        }
        if (zzehw == null) {
            return zzfwq.zzh(new zzekv("Unable to instantiate mediation adapter class."));
        }
        zzcjr zzcjr = new zzcjr();
        zzehw.zzc.zza(new zzems(this, zzehw, zzcjr));
        if (zzfdn.zzJ) {
            Bundle bundle = zzfdz.zza.zza.zzd.zzm;
            Class<AdMobAdapter> cls = AdMobAdapter.class;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfie zzfie = this.zzc;
        return zzfho.zzd(new zzemr(this, zzfdz, zzfdn, zzehw), this.zzd, zzfhy.ADAPTER_LOAD_AD_SYN, zzfie).zzb(zzfhy.ADAPTER_LOAD_AD_ACK).zzd(zzcjr).zzb(zzfhy.ADAPTER_WRAP_ADAPTER).zze(new zzemq(this, zzfdz, zzfdn, zzehw)).zza();
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        return !zzfdn.zzu.isEmpty();
    }

    public final /* synthetic */ Object zzc(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw, Void voidR) throws Exception {
        return this.zzb.zza(zzfdz, zzfdn, zzehw);
    }

    public final /* synthetic */ void zzd(zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) throws Exception {
        this.zzb.zzb(zzfdz, zzfdn, zzehw);
    }
}
