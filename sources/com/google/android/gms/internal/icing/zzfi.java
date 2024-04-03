package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzfi extends AbstractList<String> implements RandomAccess, zzdo {
    /* access modifiers changed from: private */
    public final zzdo zza;

    public zzfi(zzdo zzdo) {
        this.zza = zzdo;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzdn) this.zza).get(i11);
    }

    public final Iterator<String> iterator() {
        return new zzfh(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zzfg(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zzf(zzcf zzcf) {
        throw new UnsupportedOperationException();
    }

    public final Object zzg(int i11) {
        return this.zza.zzg(i11);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }

    public final zzdo zzi() {
        return this;
    }
}
