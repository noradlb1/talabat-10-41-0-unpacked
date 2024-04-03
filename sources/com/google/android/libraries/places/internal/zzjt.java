package com.google.android.libraries.places.internal;

public final class zzjt extends zzabp<zzjy, zzjt> implements zzada {
    private zzjt() {
        super(zzjy.zzb);
    }

    public final zzjt zza(String str) {
        if (this.zzb) {
            zzx();
            this.zzb = false;
        }
        zzjy.zzc((zzjy) this.zza, str);
        return this;
    }

    public final zzjt zzb(int i11) {
        if (this.zzb) {
            zzx();
            this.zzb = false;
        }
        zzjy.zze((zzjy) this.zza, i11);
        return this;
    }

    public /* synthetic */ zzjt(zzjs zzjs) {
        super(zzjy.zzb);
    }
}
