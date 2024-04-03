package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

final class zzfk extends zzfm {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzfh zzsa;

    public zzfk(zzfh zzfh) {
        this.zzsa = zzfh;
        this.limit = zzfh.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i11 = this.position;
        if (i11 < this.limit) {
            this.position = i11 + 1;
            return this.zzsa.zzao(i11);
        }
        throw new NoSuchElementException();
    }
}
