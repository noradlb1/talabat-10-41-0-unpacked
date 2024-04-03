package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

final class zzpt extends zzpv {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzps zzawa;

    public zzpt(zzps zzps) {
        this.zzawa = zzps;
        this.limit = zzps.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i11 = this.position;
        if (i11 < this.limit) {
            this.position = i11 + 1;
            return this.zzawa.zzal(i11);
        }
        throw new NoSuchElementException();
    }
}
