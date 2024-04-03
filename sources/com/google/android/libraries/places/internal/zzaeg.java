package com.google.android.libraries.places.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzaeg extends AbstractList<String> implements RandomAccess, zzach {
    /* access modifiers changed from: private */
    public final zzach zza;

    public zzaeg(zzach zzach) {
        this.zza = zzach;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzacg) this.zza).get(i11);
    }

    public final Iterator<String> iterator() {
        return new zzaef(this);
    }

    public final ListIterator<String> listIterator(int i11) {
        return new zzaee(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzach zzd() {
        return this;
    }

    public final Object zze(int i11) {
        return this.zza.zze(i11);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }
}
