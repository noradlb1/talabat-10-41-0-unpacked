package com.google.android.gms.internal.vision;

final class zzdp extends zzdf<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzlx;

    public zzdp(Object[] objArr, int i11, int i12) {
        this.zzlx = objArr;
        this.offset = i11;
        this.size = i12;
    }

    public final Object get(int i11) {
        zzct.zzc(i11, this.size);
        return this.zzlx[(i11 * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
