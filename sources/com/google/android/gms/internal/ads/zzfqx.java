package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfqx extends zzftn {
    final /* synthetic */ zzfqz zza;

    public zzfqx(zzfqz zzfqz) {
        this.zza = zzfqz;
    }

    public final boolean contains(@CheckForNull Object obj) {
        Set entrySet = this.zza.zza.entrySet();
        entrySet.getClass();
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Iterator<Map.Entry> iterator() {
        return new zzfqy(this.zza);
    }

    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        entry.getClass();
        zzfrm.zzo(this.zza.zzb, entry.getKey());
        return true;
    }

    public final Map zza() {
        return this.zza;
    }
}
