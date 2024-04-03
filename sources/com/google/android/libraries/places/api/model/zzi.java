package com.google.android.libraries.places.api.model;

final class zzi extends zzbd {
    private Integer zza;
    private Integer zzb;

    public final zzbd zza(int i11) {
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zzbd zzb(int i11) {
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final LocalTime zzc() {
        Integer num = this.zza;
        if (num != null && this.zzb != null) {
            return new zzaj(num.intValue(), this.zzb.intValue());
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" hours");
        }
        if (this.zzb == null) {
            sb2.append(" minutes");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
