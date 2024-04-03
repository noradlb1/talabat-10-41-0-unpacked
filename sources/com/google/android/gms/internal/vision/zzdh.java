package com.google.android.gms.internal.vision;

import java.util.List;

final class zzdh extends zzdf {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdf zzls;

    public zzdh(zzdf zzdf, int i11, int i12) {
        this.zzls = zzdf;
        this.offset = i11;
        this.length = i12;
    }

    public final Object get(int i11) {
        zzct.zzc(i11, this.length);
        return this.zzls.get(i11 + this.offset);
    }

    public final int size() {
        return this.length;
    }

    public final /* synthetic */ List subList(int i11, int i12) {
        return subList(i11, i12);
    }

    public final Object[] zzbz() {
        return this.zzls.zzbz();
    }

    public final int zzca() {
        return this.zzls.zzca() + this.offset;
    }

    public final int zzcb() {
        return this.zzls.zzca() + this.offset + this.length;
    }

    public final zzdf zze(int i11, int i12) {
        zzct.zza(i11, i12, this.length);
        zzdf zzdf = this.zzls;
        int i13 = this.offset;
        return (zzdf) zzdf.subList(i11 + i13, i12 + i13);
    }
}
