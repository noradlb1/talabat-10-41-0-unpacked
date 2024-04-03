package com.google.android.gms.internal.ads;

public final class zzafd {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzafd(int i11, int i12, int i13) {
        String str;
        if (i11 != Integer.MIN_VALUE) {
            StringBuilder sb2 = new StringBuilder(12);
            sb2.append(i11);
            sb2.append("/");
            str = sb2.toString();
        } else {
            str = "";
        }
        this.zza = str;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public final int zza() {
        zzd();
        return this.zzd;
    }

    public final String zzb() {
        zzd();
        return this.zze;
    }

    public final void zzc() {
        int i11 = this.zzd;
        int i12 = i11 == Integer.MIN_VALUE ? this.zzb : i11 + this.zzc;
        this.zzd = i12;
        String str = this.zza;
        StringBuilder sb2 = new StringBuilder(str.length() + 11);
        sb2.append(str);
        sb2.append(i12);
        this.zze = sb2.toString();
    }
}
