package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzciy;
import com.google.android.gms.internal.ads.zzcjr;
import java.util.Map;

public final class zzbr extends zzags<zzago> {
    private final zzcjr<zzago> zza;
    private final zzciy zzb;

    public zzbr(String str, Map<String, String> map, zzcjr<zzago> zzcjr) {
        super(0, str, new zzbq(zzcjr));
        this.zza = zzcjr;
        zzciy zzciy = new zzciy((String) null);
        this.zzb = zzciy;
        zzciy.zzd(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    public final zzagy<zzago> zzh(zzago zzago) {
        return zzagy.zzb(zzago, zzahp.zzb(zzago));
    }

    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzago zzago = (zzago) obj;
        this.zzb.zzf(zzago.zzc, zzago.zza);
        zzciy zzciy = this.zzb;
        byte[] bArr = zzago.zzb;
        if (zzciy.zzl() && bArr != null) {
            zzciy.zzh(bArr);
        }
        this.zza.zzd(zzago);
    }
}
