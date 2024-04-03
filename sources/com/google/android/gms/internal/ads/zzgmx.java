package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;

final class zzgmx implements Iterator<Map.Entry>, j$.util.Iterator {
    final /* synthetic */ zzgnb zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    public /* synthetic */ zzgmx(zzgnb zzgnb, zzgmw zzgmw) {
        this.zza = zzgnb;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        if (this.zzb + 1 < this.zza.zzb.size()) {
            return true;
        }
        if (this.zza.zzc.isEmpty()) {
            return false;
        }
        if (zza().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i11 = this.zzb + 1;
        this.zzb = i11;
        if (i11 < this.zza.zzb.size()) {
            return (Map.Entry) this.zza.zzb.get(this.zzb);
        }
        return zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzgnb zzgnb = this.zza;
                int i11 = this.zzb;
                this.zzb = i11 - 1;
                Object unused = zzgnb.zzl(i11);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
