package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzgnk extends AbstractList<String> implements RandomAccess, zzgld {
    /* access modifiers changed from: private */
    public final zzgld zza;

    public zzgnk(zzgld zzgld) {
        this.zza = zzgld;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzglc) this.zza).get(i11);
    }

    public final Iterator<String> iterator() {
        return new zzgnj(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zzgni(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzgld zze() {
        return this;
    }

    public final Object zzf(int i11) {
        return this.zza.zzf(i11);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzgjf zzgjf) {
        throw new UnsupportedOperationException();
    }
}
