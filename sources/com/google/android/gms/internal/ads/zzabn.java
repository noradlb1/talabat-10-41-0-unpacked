package com.google.android.gms.internal.ads;

class zzabn {
    public final int zzd;

    public zzabn(int i11) {
        this.zzd = i11;
    }

    public static int zze(int i11) {
        return (i11 >> 24) & 255;
    }

    public static String zzf(int i11) {
        StringBuilder sb2 = new StringBuilder(4);
        sb2.append((char) ((i11 >> 24) & 255));
        sb2.append((char) ((i11 >> 16) & 255));
        sb2.append((char) ((i11 >> 8) & 255));
        sb2.append((char) (i11 & 255));
        return sb2.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
