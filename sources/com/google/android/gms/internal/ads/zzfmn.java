package com.google.android.gms.internal.ads;

final class zzfmn extends zzfmj {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzfmn(String str, boolean z11, boolean z12, zzfmm zzfmm) {
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfmj) {
            zzfmj zzfmj = (zzfmj) obj;
            if (this.zza.equals(zzfmj.zzb()) && this.zzb == zzfmj.zzd() && this.zzc == zzfmj.zzc()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = 1237;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003;
        if (true == this.zzc) {
            i11 = 1231;
        }
        return hashCode ^ i11;
    }

    public final String toString() {
        String str = this.zza;
        boolean z11 = this.zzb;
        boolean z12 = this.zzc;
        StringBuilder sb2 = new StringBuilder(str.length() + 99);
        sb2.append("AdShield2Options{clientVersion=");
        sb2.append(str);
        sb2.append(", shouldGetAdvertisingId=");
        sb2.append(z11);
        sb2.append(", isGooglePlayServicesAvailable=");
        sb2.append(z12);
        sb2.append("}");
        return sb2.toString();
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
