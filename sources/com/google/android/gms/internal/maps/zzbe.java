package com.google.android.gms.internal.maps;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzbe extends zzba {
    final transient Object zza;

    public zzbe(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzbb(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    public final int zza(Object[] objArr, int i11) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzbf zzd() {
        return new zzbb(this.zza);
    }
}
