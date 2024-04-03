package com.google.android.gms.internal.places;

import java.util.Iterator;

final class zzdg extends zzdm {
    private final /* synthetic */ zzdb zzma;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzdg(zzdb zzdb) {
        super(zzdb, (zzde) null);
        this.zzma = zzdb;
    }

    public final Iterator iterator() {
        return new zzdd(this.zzma, (zzde) null);
    }

    public /* synthetic */ zzdg(zzdb zzdb, zzde zzde) {
        this(zzdb);
    }
}
