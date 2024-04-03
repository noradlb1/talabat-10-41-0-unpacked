package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzagw;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzciy;
import java.util.Collections;
import java.util.Map;

final class zzbm extends zzahx {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzciy zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbm(zzbs zzbs, int i11, String str, zzagx zzagx, zzagw zzagw, byte[] bArr, Map map, zzciy zzciy) {
        super(i11, str, zzagx, zzagw);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzciy;
    }

    public final Map<String, String> zzl() throws zzaga {
        Map<String, String> map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzaga {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
