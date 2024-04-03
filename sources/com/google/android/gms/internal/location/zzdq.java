package com.google.android.gms.internal.location;

final class zzdq extends zzdo {
    private final zzds zza;

    public zzdq(zzds zzds, int i11) {
        super(zzds.size(), i11);
        this.zza = zzds;
    }

    public final Object zza(int i11) {
        return this.zza.get(i11);
    }
}
