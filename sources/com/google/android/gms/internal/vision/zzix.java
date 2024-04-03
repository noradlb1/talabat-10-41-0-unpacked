package com.google.android.gms.internal.vision;

import java.util.Iterator;

final class zzix extends zzjd {
    private final /* synthetic */ zziw zzaab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzix(zziw zziw) {
        super(zziw, (zziv) null);
        this.zzaab = zziw;
    }

    public final Iterator iterator() {
        return new zziy(this.zzaab, (zziv) null);
    }

    public /* synthetic */ zzix(zziw zziw, zziv zziv) {
        this(zziw);
    }
}
