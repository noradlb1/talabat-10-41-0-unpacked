package com.google.android.gms.internal.ads;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class zzlf {
    public static final zzlf zza = new zzlf(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzlf(int i11, int i12, int i13) {
        int i14;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        if (zzfn.zzR(i13)) {
            i14 = zzfn.zzm(i13, i12);
        } else {
            i14 = -1;
        }
        this.zze = i14;
    }

    public final String toString() {
        int i11 = this.zzb;
        int i12 = this.zzc;
        int i13 = this.zzd;
        StringBuilder sb2 = new StringBuilder(83);
        sb2.append("AudioFormat[sampleRate=");
        sb2.append(i11);
        sb2.append(", channelCount=");
        sb2.append(i12);
        sb2.append(", encoding=");
        sb2.append(i13);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
