package com.google.android.gms.internal.vision;

import java.util.AbstractMap;

final class zzdn extends zzdf {
    private final /* synthetic */ zzdk zzmb;

    public zzdn(zzdk zzdk) {
        this.zzmb = zzdk;
    }

    public final /* synthetic */ Object get(int i11) {
        zzct.zzc(i11, this.zzmb.size);
        int i12 = i11 * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzmb.zzlx[i12], this.zzmb.zzlx[i12 + 1]);
    }

    public final int size() {
        return this.zzmb.size;
    }
}
