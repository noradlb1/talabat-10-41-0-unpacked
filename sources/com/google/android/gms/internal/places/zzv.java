package com.google.android.gms.internal.places;

import java.util.NoSuchElementException;

final class zzv extends zzx {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzw zzef;

    public zzv(zzw zzw) {
        this.zzef = zzw;
        this.limit = zzw.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i11 = this.position;
        if (i11 < this.limit) {
            this.position = i11 + 1;
            return this.zzef.zzj(i11);
        }
        throw new NoSuchElementException();
    }
}
