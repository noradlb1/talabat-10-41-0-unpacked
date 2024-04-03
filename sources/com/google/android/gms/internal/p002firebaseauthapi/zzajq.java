package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajq  reason: invalid package */
public final class zzajq extends AbstractList implements RandomAccess, zzahn {
    /* access modifiers changed from: private */
    public final zzahn zza;

    public zzajq(zzahn zzahn) {
        this.zza = zzahn;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzahm) this.zza).get(i11);
    }

    public final Iterator iterator() {
        return new zzajp(this);
    }

    public final ListIterator listIterator(int i11) {
        return new zzajo(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzahn zze() {
        return this;
    }

    public final Object zzf(int i11) {
        return this.zza.zzf(i11);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzafv zzafv) {
        throw new UnsupportedOperationException();
    }
}
