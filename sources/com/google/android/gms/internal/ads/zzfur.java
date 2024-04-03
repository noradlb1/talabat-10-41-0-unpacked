package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class zzfur<E> extends zzftc<E> {
    final transient E zza;

    public zzfur(E e11) {
        e11.getClass();
        this.zza = e11;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzftd(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public final int zza(Object[] objArr, int i11) {
        objArr[i11] = this.zza;
        return i11 + 1;
    }

    public final zzfss<E> zzd() {
        return zzfss.zzp(this.zza);
    }

    public final zzfuu<E> zze() {
        return new zzftd(this.zza);
    }

    public final boolean zzf() {
        throw null;
    }
}
