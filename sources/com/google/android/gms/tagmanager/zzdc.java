package com.google.android.gms.tagmanager;

import android.util.LruCache;

final class zzdc extends LruCache {
    private final /* synthetic */ zzs zzahz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdc(zzdb zzdb, int i11, zzs zzs) {
        super(i11);
        this.zzahz = zzs;
    }

    public final int sizeOf(Object obj, Object obj2) {
        return this.zzahz.sizeOf(obj, obj2);
    }
}
