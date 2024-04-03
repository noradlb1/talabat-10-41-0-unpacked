package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzehy {
    private final List<zzbfm> zza = Collections.synchronizedList(new ArrayList());
    private final Map<String, zzbfm> zzb = DesugarCollections.synchronizedMap(new HashMap());
    private zzfdq zzc = null;
    private zzfdn zzd = null;

    public final zzdek zza() {
        return new zzdek(this.zzd, "", this, this.zzc);
    }

    public final List<zzbfm> zzb() {
        return this.zza;
    }

    public final void zzc(zzfdn zzfdn) {
        String str = zzfdn.zzx;
        if (!this.zzb.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzfdn.zzw.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzfdn.zzw.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzbfm zzbfm = new zzbfm(zzfdn.zzF, 0, (zzbew) null, bundle);
            this.zza.add(zzbfm);
            this.zzb.put(str, zzbfm);
        }
    }

    public final void zzd(zzfdn zzfdn, long j11, @Nullable zzbew zzbew) {
        String str = zzfdn.zzx;
        if (this.zzb.containsKey(str)) {
            if (this.zzd == null) {
                this.zzd = zzfdn;
            }
            zzbfm zzbfm = this.zzb.get(str);
            zzbfm.zzb = j11;
            zzbfm.zzc = zzbew;
        }
    }

    public final void zze(zzfdq zzfdq) {
        this.zzc = zzfdq;
    }
}
