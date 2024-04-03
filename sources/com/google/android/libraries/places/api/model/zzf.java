package com.google.android.libraries.places.api.model;

final class zzf extends zzba {
    private Integer zza;
    private Integer zzb;

    public final zzba zza(int i11) {
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zzba zzb(int i11) {
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzbb zzc() {
        Integer num = this.zza;
        if (num != null && this.zzb != null) {
            return new zzaf(num.intValue(), this.zzb.intValue());
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" offset");
        }
        if (this.zzb == null) {
            sb2.append(" length");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
