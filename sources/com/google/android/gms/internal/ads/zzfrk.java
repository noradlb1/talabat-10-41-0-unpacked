package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

final class zzfrk extends zzfri implements ListIterator {
    final /* synthetic */ zzfrl zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrk(zzfrl zzfrl) {
        super(zzfrl);
        this.zzd = zzfrl;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfrm zzfrm = this.zzd.zzf;
        zzfrm.zzb = zzfrm.zzb + 1;
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfrk(zzfrl zzfrl, int i11) {
        super(zzfrl, ((List) zzfrl.zzb).listIterator(i11));
        this.zzd = zzfrl;
    }
}
