package com.google.android.libraries.places.internal;

final class zzdb extends zzde {
    private String zza;
    private Integer zzb;
    private int zzc;

    public final zzde zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null packageName");
    }

    public final zzde zzb(int i11) {
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zzdf zzc() {
        Integer num;
        String str = this.zza;
        if (str != null && (num = this.zzb) != null && this.zzc != 0) {
            return new zzdd(str, num.intValue(), this.zzc, (zzdc) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" packageName");
        }
        if (this.zzb == null) {
            sb2.append(" versionCode");
        }
        if (this.zzc == 0) {
            sb2.append(" requestSource");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }

    public final zzde zzd(int i11) {
        this.zzc = i11;
        return this;
    }
}
