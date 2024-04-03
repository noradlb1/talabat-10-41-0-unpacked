package com.google.android.recaptcha.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzkb extends AbstractList implements RandomAccess, zzhx {
    /* access modifiers changed from: private */
    public final zzhx zza;

    public zzkb(zzhx zzhx) {
        this.zza = zzhx;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzhw) this.zza).get(i11);
    }

    public final Iterator iterator() {
        return new zzka(this);
    }

    public final ListIterator listIterator(int i11) {
        return new zzjz(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzhx zze() {
        return this;
    }

    public final Object zzf(int i11) {
        return this.zza.zzf(i11);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzfi zzfi) {
        throw new UnsupportedOperationException();
    }
}
